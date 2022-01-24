# Table reservation service

Restaurant wants to make a reservation system for their customers.
Customers should be able to reserve their table in certain time for certain number of guests.
All the tables in the restaurant can be reserved.
Guests usually spend certain amount of time at this place, therefore restaurant should be able to configure the amount of time how long the tables are usually taken at their place (variable).
In this timetable cannot be reserved.
Reservation should be for at least so many guests as a customer asks - it can be a bigger table also.

### System saves following data:
- Restaurant(name, address, description)
- Table (number, code, numberOfSeats, Restaurant)
- Reservation (time, reservationName, numberOfGuests, Table)

### Endpoints

- Restaurant - add, list
- Tables in Restaurant - add, edit, delete, list all, get free tables for number of guests and time
- Reservations  - create, edit, delete, list all for the day
