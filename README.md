# Load API - Spring Boot & PostgreSQL

This project is a RESTful API built using Spring Boot and PostgreSQL for managing loads in a logistics system. It allows CRUD (Create, Read, Update, Delete) operations for Load entities, with each load associated with a specific Shipper.

## Features Used
- Add, update, delete, and retrieve loads.
- Each load is linked to a shipper.
- Shippers can have multiple loads (one-to-many relationship).
- Uses Spring Data JPA to interact with a PostgreSQL database.

## Technologies Used
- **Java**: Core programming language
- **Spring Boot**: Framework used to build the API
- **Spring Data JPA**: Java Persistence API for database operations.
- **PostgreSQL**: Database used for storing load and shipper data
- **Maven**: Dependency management and build tool
- **Postman**: Tool Used for API testing

## Getting Started

### Prerequisites

- Java 17 or above
- Maven
- PostgreSQL
- Postman
- IDE (IntelliJ Idea)

### Installation

1. **Clone the Repository:**

   ``` bash
   git clone https://github.com/Pragadeesh-19/LoadApi.git
   cd LoadApi
   ```

2. **Configure the Database:**
   Create a PostgreSQL database and update the `application.properties` file with your database credentials

   ``` Properties
   spring.application.name=LoadApi

   spring.datasource.url=${DB_URL}
   spring.datasource.username=${DB_USERNAME}
   spring.datasource.password=${DB_PASSWORD}
   spring.datasource.driver-class-name=org.postgresql.Driver
    
   spring.jpa.properties.hibernate.format_sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and Run the Application:**
   
   Using Maven:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### API Endpoints:

1. **Shipper Endpoints:**
   - `POST /shipper`:               Create a new shipper
   - `GET /shipper/{shipperid}`:    Get Shipper by shipperId
   - `GET /shipper`:                Get all available shippers
   - `PUT /shipper/{shipperId}`:    Update a shipper with its shipperId
   - `DELETE /shipper/{shipperId}`: Delete a shipper By shipperId
  
2. **Load Endpoints:**
   - `POST /load/{shipperId}`: create a load in a specific shipper using shipperId
   - `GET /load`:              Get all the list of loads in a shipper by shipperId
   - `PUT /load/{loadId}`:     Update the load with loadId
   - `DELETE /load/{loadId}`:  delete a load by loadId
  
### Testing:

  API endpoints are tested using Postman.

1. **Shipper Endpoints:**
   
  - `POST /shipper`:

    ![createShipper](https://github.com/user-attachments/assets/4c162157-7556-49be-adcc-348c8af9ee4f)

  - `GET /shipper/{shipperid}`:

    ![getShipperById](https://github.com/user-attachments/assets/03b94b6b-8261-4d71-bb27-5fbf0725b602)

  - `GET /shipper`:

    ![getAllShippers](https://github.com/user-attachments/assets/b04d4058-3ae7-406f-8730-8d8ebf91f14b)

  - `PUT /shipper/{shipperId}`:

    ![updateShipperById](https://github.com/user-attachments/assets/69fb8f86-d6a8-48ec-be66-2f8259e8d7b4)

  - `DELETE /shipper/{shipperId}`:

    ![deleteShipperById](https://github.com/user-attachments/assets/e476d717-9e5e-435c-b9cd-c49f72ee1fab)

3. **Load Endpoints:**
   
  - `POST /load/{shipperId}`:

    ![createLoad](https://github.com/user-attachments/assets/0c36921f-9bee-4e19-b2db-3ab7f5406b8f)

  - `GET /load`:

    ![loadByShipperId](https://github.com/user-attachments/assets/ab3c1e4c-90c8-463d-979e-b048d97ea243)

  - `PUT /load/{loadId}`:

    ![updateLoad](https://github.com/user-attachments/assets/29469538-2a35-4364-9651-d90b65c2c22f)

  - `DELETE /load/{loadId}`:

    ![deleteLoad](https://github.com/user-attachments/assets/5d4e1561-9e3b-459d-b07e-85eeacaa8d82)


### Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes or enhancements.

