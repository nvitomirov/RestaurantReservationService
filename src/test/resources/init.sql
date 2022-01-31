CREATE TABLE restaurant(
id UUID CONSTRAINT restaurantPrimaryKey PRIMARY KEY,
name varchar(150) not null,
address varchar(500),
description varchar(1500)
);

CREATE TABLE restaurant_table(
id UUID CONSTRAINT restaurantTablePrimaryKey PRIMARY KEY,
number integer,
code varchar(20),
number_of_seats integer,
restaurant_id UUID not null,
foreign key (restaurant_id) references restaurant(id) on update cascade
);

CREATE TABLE table_reservation(
id UUID CONSTRAINT tableReservationPrimaryKey PRIMARY KEY,
reservation_name varchar(250) not null,
numberOfGuests integer not null,
restaurant_table_id UUID not null,
foreign key (restaurant_table_id) references restaurant_table(id) on update cascade
);
