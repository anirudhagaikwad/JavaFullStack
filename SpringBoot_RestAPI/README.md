# Spring Boot Application Configuration

This document outlines the key configuration settings used in this Spring Boot application. These settings are defined in the `application.properties` file.

---

## 📡 Server Configuration

```properties
server.port=8080  
server.servlet.context-path=/
```

- The server runs on port **8080**.
- The context path is set to the root (`/`).

---

## 🛢️ Database Configuration

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase  
spring.datasource.username=myuser  
spring.datasource.password=mypassword  
spring.datasource.driver-class-name=org.postgresql.Driver
```

- Using **PostgreSQL** as the database.
- Replace with appropriate credentials and database name.

---

## 🏗️ JPA and Hibernate Configuration

```properties
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect  
spring.jpa.show-sql=true  
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.properties.hibernate.format_sql=true
```

- Enables SQL logging and formatted output.
- `ddl-auto=update` ensures Hibernate updates the schema automatically.

---

## ⚙️ HikariCP Connection Pooling

```properties
spring.datasource.hikari.minimum-idle=5  
spring.datasource.hikari.maximum-pool-size=20  
spring.datasource.hikari.idle-timeout=30000  
spring.datasource.hikari.max-lifetime=1800000  
spring.datasource.hikari.connection-timeout=30000  
spring.datasource.hikari.pool-name=HikariCP-Pool
```

- Efficient database connection pooling using **HikariCP**.

---

## 📝 Logging Configuration

```properties
logging.level.org.springframework=INFO  
logging.level.org.hibernate.SQL=DEBUG  
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

- Detailed logging for debugging SQL and data binding.

---

## 🔐 Spring Security (Optional)

```properties
spring.security.user.name=admin  
spring.security.user.password=admin123  
spring.security.user.roles=ADMIN,USER
```

- Default in-memory user configuration for development/testing.

---

## 🌐 Thymeleaf Configuration

```properties
spring.thymeleaf.cache=false  
spring.thymeleaf.mode=HTML5
```

- Disables template caching for development.
- Uses `HTML5` mode.

---

## 📤 File Upload Configuration

```properties
spring.servlet.multipart.enabled=true  
spring.servlet.multipart.max-file-size=10MB  
spring.servlet.multipart.max-request-size=20MB
```

- Supports file uploads with specified limits.

---

## 📊 Actuator Endpoints (Optional)

```properties
management.endpoints.web.exposure.include=*  
management.endpoint.health.show-details=always
```

- Enables all actuator endpoints.
- Always shows health endpoint details.

---

## ✉️ Mail Configuration (Optional)

```properties
spring.mail.host=smtp.gmail.com  
spring.mail.port=587  
spring.mail.username=myemail@gmail.com  
spring.mail.password=mypassword  
spring.mail.properties.mail.smtp.auth=true  
spring.mail.properties.mail.smtp.starttls.enable=true
```

- Email sending configuration using Gmail SMTP.
- Ensure 2FA and App Passwords are set up for Gmail.

---

> ⚠️ **Security Note**: Never hardcode passwords or sensitive data in the properties file for production. Use environment variables or encrypted secrets management.

---

## 🧩 Dependencies

This configuration is suitable for a Spring Boot application with:
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Security (Optional)
- Thymeleaf (Optional)
- Spring Boot Actuator (Optional)
- Spring Boot Starter Mail (Optional)

---

## 🔄 Customize As Needed

Adjust these settings based on your specific environment and use case (e.g., dev, test, prod).

---

📘 **Happy Coding with Spring Boot!**

