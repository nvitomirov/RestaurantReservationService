package com.nebovito.reservationservce.integrationTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.annotation.PostConstruct;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(initializers = BaseIntegrationTest.DockerPostgreDataSourceInitializer.class)
@ExtendWith(SpringExtension.class)
@Testcontainers
public abstract class BaseIntegrationTest {

    public static PostgreSQLContainer<?> postgreDBContainer = new PostgreSQLContainer<>("postgres:13")
                    .withDatabaseName("reservation-service-postgres")
                    .withUsername("user1")
                    .withPassword("u53r");

    static {        postgreDBContainer.withClasspathResourceMapping(
                "init.sql", "/docker-entrypoint-initdb.d/init.sql", BindMode.READ_ONLY);
        postgreDBContainer.start();
    }

    public static class DockerPostgreDataSourceInitializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    applicationContext,
                    "spring.datasource.url=" + postgreDBContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreDBContainer.getUsername(),
                    "spring.datasource.password=" + postgreDBContainer.getPassword());
        }
    }

    @Autowired private WebApplicationContext webApplicationContext;

    @LocalServerPort private int port;

    private String uri;

    public String getBaseUrl() {
        return uri;
    }

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @BeforeEach
    public void before() {
        System.out.println("Setting up integration test class " + this.getClass().getSimpleName());
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
