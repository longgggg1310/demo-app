# Spring Boot Application with Redis, MinIO, and ELK Stack

This Spring Boot application is designed to work seamlessly with Docker, integrating Redis for caching, MinIO for object storage, and ELK Stack (Elasticsearch, Logstash, Kibana) for centralized log management. Below, we'll guide you through setting up, configuring, and utilizing the application.

## Prerequisites

Ensure Docker is installed on your system before proceeding.

## Setup Instructions

1. Clone the repository to your local machine.

2. Ensure you have the Dockerfile and Docker Compose file (`docker-compose.yml`) in the project directory.

3. Run the following command to build and start the Docker containers:

    ```
    docker-compose up
    ```

4. Once the containers are up and running, you can access the following services:

    - MinIO: [http://localhost:9000](http://localhost:9000)
    - Elasticsearch: [http://localhost:9200](http://localhost:9200)
    - Kibana: [http://localhost:5602](http://localhost:5602)
    - Redis: `redis://localhost:6379`

## Configuration

### Docker Compose Configuration

- Customize environment variables, volumes, and ports in the `docker-compose.yml` file as per your requirements.

### Spring Boot Application

- Ensure the `application.properties` file in the Spring Boot application is properly configured to interact with Redis for caching and MinIO for object storage.

## Controllers

### EmployeeController

- Manages employee data with endpoints for retrieval, creation, and search, including caching of employee data.

### FakerDataController

- Provides an endpoint to generate fake data for testing purposes.

### MinIOController

- Exposes an endpoint to retrieve URLs of all images stored in MinIO.

## Logstash

- The Logstash configuration is included in the Docker Compose file. Ensure Logstash configuration files (`logstash.yml` and pipeline configurations) are properly configured for your application's log format.

## Elasticsearch

- Utilizes Elasticsearch for indexing and searching logs.
- Includes fuzzy search capabilities for more flexible and forgiving search queries.

## Kibana

- Use Kibana to visualize and analyze logs stored in Elasticsearch.
- Count logs based on Logstash fields and generate visualizations and dashboards for monitoring and analysis.

## Usage

- Utilize Redis caching to improve application performance by reducing database queries.
- Store and retrieve large objects efficiently using MinIO object storage.
- Monitor and analyze application logs in real-time using the Kibana dashboard powered by ELK Stack.

## Additional Notes

- Make sure your Spring Boot application is configured to interact correctly with Redis, MinIO, Elasticsearch, and ELK Stack.
- Customize the application as needed to meet specific requirements.

## Elasticsearch Repository

To utilize the `EmployeeRepositoryElasticsearch` interface within your Spring Boot application, follow these steps:

1. Ensure that `EmployeeRepositoryElasticsearch` extends `ElasticsearchRepository<EmployeeDocument, Long>`.

2. Use `@Query` annotations to define custom queries for searching `EmployeeDocument` objects by address.

### Example Queries:

- **Exact Match:**

  ```java
  @Query("{\"bool\": {\"must\": {\"match\": {\"address\": \"?0\"}}}}")
  List<EmployeeDocument> findByAddress(String fieldValue);

- **Fuzzy Search:**
```java
  @Query("{\"fuzzy\": {\"address\": {\"value\": \"?0\", \"fuzziness\": \"auto\"}}}")
  List<EmployeeDocument> findByAddressFuzzy(String address);
