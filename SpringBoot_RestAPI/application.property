# ===============================
# Server Configuration
# ===============================
server.port=8080
server.servlet.context-path=/

# ===============================
# Database Configuration
# ===============================
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver

# ===============================
# JPA and Hibernate Configuration
# ===============================
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update  # Options: none, validate, update, create, create-drop
spring.jpa.properties.hibernate.format_sql=true

# ===============================
# Connection Pooling (HikariCP)
# ===============================
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.maximum-pool-size=20
spring.datasource.hikari.idle-timeout=30000
spring.datasource.hikari.max-lifetime=1800000
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.pool-name=HikariCP-Pool

# ===============================
# Logging Configuration
# ===============================
logging.level.org.springframework=INFO
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# ===============================
# Spring Security (Optional)
# ===============================
spring.security.user.name=admin
spring.security.user.password=admin123
spring.security.user.roles=ADMIN,USER

# ===============================
# Thymeleaf Configuration
# ===============================
spring.thymeleaf.cache=false
spring.thymeleaf.mode=HTML5

# ===============================
# File Upload Configuration
# ===============================
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=20MB

# ===============================
# Actuator Endpoints (Optional)
# ===============================
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always

# ===============================
# Mail Configuration (Optional)
# ===============================
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=myemail@gmail.com
spring.mail.password=mypassword
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
