# revature-bookshelf-backend


## Discovery server setup

1. Start eureka server 
2. Initialize eureka client in your micro-service and micro-service you want to communicate with by:
- Adding dependency:
    ```
    <dependency>
   <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    ```
- And dependency management: (with `<spring-cloud.version>2021.0.0</spring-cloud.version>` in properties)
  ```
  <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
  ```
- Enabling Eureka client in your microservice application file:
    ```
    @SpringbootApplication
    @EnableDiscoveryClient
    ```
- In your application.properties
``spring.application.name={service-name}``
3. Implement in application:
- ``@EnableDiscoveryClient`` after ``@SpringBootApplication``
- RestTemplate Bean in Application class:
  ```
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate()
  }
  ```
- Then you can use @Autowired RestTemplate to query the microservices you need:
  ``restTemplate.getForObject(url:http://{microserviceApplicationName}/{routeToQuery)``
  
