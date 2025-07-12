# Hibernate 7.0.5 Final

## 📌 Introduction to Hibernate

Hibernate is an **Object-Relational Mapping (ORM)** framework for Java. It simplifies the interaction between Java applications and relational databases by mapping Java classes to database tables.

Hibernate 7.0.5 Final is a major release offering full support for **Jakarta Persistence 3.2** (formerly Java Persistence API - JPA), modern bootstrapping techniques, enhanced modularity, and alignment with JPA standards.

---

## 🧩 Why Jakarta Persistence API (JPA) is Required

Jakarta Persistence API (formerly Java Persistence API - JPA) defines a **standard** for managing relational data in Java applications. Hibernate is a **JPA-compliant provider**, meaning it implements the specification.

### ✅ Key Purposes and Benefits:

* **Abstraction Layer**: Standard API for ORM that decouples application logic from the underlying implementation.
* **Portability**: Applications can switch between different JPA providers (e.g., EclipseLink, Hibernate) with minimal changes.
* **Standard Annotations**: Define entities, relationships, and configurations using annotations like `@Entity`, `@Id`, etc.
* **Lifecycle Management**: Manages the lifecycle of entities from transient to persistent to detached.
* **Query Language**: JPQL (Java Persistence Query Language) for platform-independent queries.

---

## ⚙️ Hibernate Configuration Overview

### Configuration Approaches:

* **XML-based (`hibernate.cfg.xml`)**
* **Programmatic (via Java code)**
* **JPA-style (`persistence.xml`)**

### Core Configuration Properties:

* JDBC connection settings: URL, username, password
* Dialect: e.g., `org.hibernate.dialect.PostgreSQLDialect`
* Schema management: `hibernate.hbm2ddl.auto`
* Logging: `hibernate.show_sql`, `hibernate.format_sql`

---

## 🧠 Important Interfaces and Methods

### 📘 Jakarta Persistence (JPA) Interfaces

* **`EntityManagerFactory`**

  * Bootstraps and provides `EntityManager` instances.
  * Heavyweight and thread-safe.

* **`EntityManager`**

  * Core interface to perform persistence operations.
  * Methods:

    * `persist(Object entity)` – Insert new entity.
    * `merge(Object entity)` – Update existing entity.
    * `remove(Object entity)` – Delete entity.
    * `find(Class<T>, Object id)` – Retrieve entity by ID.
    * `createQuery(...)` – JPQL/criteria query execution.

* **`EntityTransaction`**

  * Controls transaction boundaries.
  * Methods:

    * `begin()` – Starts a new transaction.
    * `commit()` – Commits current transaction.
    * `rollback()` – Rolls back active transaction.

* **`TypedQuery<T>` / `Query`**

  * Allows execution of JPQL and criteria queries.
  * `TypedQuery<T>` provides type safety.

* **`Persistence`**

  * Utility class to bootstrap `EntityManagerFactory` using configuration.

### 📙 JPA Annotations

* `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`
* `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`
* `@JoinColumn`, `@Embedded`, `@Embeddable`, `@MappedSuperclass`

---

### 🧰 From Hibernate Native API

* **`SessionFactory`**:

  * A factory for `Session` objects.
  * Heavyweight, thread-safe; usually created once per application.

* **`Session`**:

  * Equivalent to `EntityManager` in native Hibernate.
  * Manages persistence operations.
  * As of Hibernate 6 and continuing in 7, traditional methods like `save()`, `update()`, `delete()`, and `get()` have been **deprecated and removed**.
  * Instead, developers should use:

    * `persist()` – to make an entity managed and persistent.
    * `merge()` – to update an entity’s state.
    * `remove()` – to delete an entity.
    * `find()` or `byId()` – to retrieve an entity by identifier.
  * These changes bring Hibernate’s API more in line with JPA standards and ensure consistency between native and JPA usage.
  * Equivalent to `EntityManager` in native Hibernate.
  * Manages persistence operations.
  * Provides methods like `save()`, `update()`, `delete()`, `get()`, `load()`.

* **`Transaction`**:

  * Provides methods to control transaction boundaries: `begin()`, `commit()`, `rollback()`.

* **`Configuration`**:

  * Allows setting properties and mapping resources.
  * Typically used for programmatic setup.

* **`StandardServiceRegistry`**:

  * Provides centralized access to configured services.
  * Used in combination with `MetadataSources` to build `SessionFactory`.

---

## 🔎 Hibernate 7.0.5 Key Features

* Full support for **Jakarta Persistence 3.2**.
* Improved modularity and pluggability.
* Enhanced bootstrapping APIs.
* Extended support for `@ManyToMany` with association entity.
* SQL AST improvements for advanced query translations.
* Unified `SessionFactory` and `EntityManagerFactory` use.

---

## 🔚 Conclusion

Hibernate 7.0.5 Final offers a modern and flexible ORM framework with full support for Jakarta Persistence, providing powerful native APIs and standard JPA interfaces. Understanding the purpose and differences between these interfaces enables developers to build scalable, maintainable, and portable enterprise applications.

# Hibernate Architecture Image

![Hibernate Architecture ](https://github.com/anirudhagaikwad/JavaFullStack/blob/main/Hibernate/images/architecture.png)

# Hibernate api-overview with custom width and height

<img src="https://github.com/anirudhagaikwad/JavaFullStack/blob/main/Hibernate/images/api-overview.png" alt="api-overview" width="600" height="500">

# Entity Lifecycle
![Entity Lifecycle ](https://github.com/anirudhagaikwad/JavaFullStack/blob/main/Hibernate/images/entity-lifecyle.png)