![SeureStack Logo](_docs/securestack-logo-900x200.png)

SecureStack is a full-stack Kotlin Spring Boot application that helps development
teams stay secure and up-to-date by monitoring software tools and project dependencies for version updates.
It supports GitHub login, team-based organization, app-specific configuration,
and sends email alerts when newer versions are available—making dependency tracking simple,
proactive, and secure.

**SecureStack** is a full-stack **Kotlin Spring Boot app**:
* Uses **PostgreSQL** database for storing 
  * users and teams, 
  * teams software (for example Git, Java, IntelliJ, Kotlin)
  * applications and their software and Gradle/Maven dependencies for version updates
* Sends **email alerts** on new versions
* Uses **GitHub OAuth** for authentication
* Includes a **Thymeleaf** frontend, packaged with the backend


Table of contents:
1. [🖥️ Run Locally](#%EF%B8%8F-2-setup-development-environment-software-installation-guide)
2. [☁️ Run at Hetzner (in the Cloud)](#-3-technologies-covered)
3. [🛠️ How the Application Was Created](#-3-technologies-covered)
4. [📜 License](#-7-license)

---

## 🖥️ 1 Run Locally


### 1.1 Install [PostgreSQL](https://www.postgresql.org/download). Linux and macOS: You should install pgAdmin also.

### 1.2 Create a PostgreSQL database named `securestack`.

### 1.3 Download [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download).



### 1.4 Clone Repository and open it in IntelliJ:

In IntelliJ welcome screen use `Clone Repository` and enter
[https://github.com/ditlef9/securestack-kotlin-springboot-postgresql.git](https://github.com/ditlef9/securestack-kotlin-springboot-postgresql.git).

...or...

![Download](_docs/download-black-24x24.svg) [Download ZIP](https://github.com/ditlef9/securestack-kotlin-springboot-postgresql/archive/refs/heads/main.zip)

...or...

Use Git and clone the material:
```bash
git clone https://github.com/ditlef9/securestack-kotlin-springboot-postgresql.git
```

The Project uses the [latest LTS version of Java](https://www.oracle.com/java/technologies/java-se-support-roadmap.html).




---

## ☁️ 2 Run at Hetzner (in the Cloud)

---


## 🛠️ 3 How the Application Was Created

### 3.1 Created a starter at https://start.spring.io/

* Project: Gradle - Kotlin
* Language: Kotlin
Dependencies:
* Web:
	* Spring Web	To build REST APIs (backend)
* Security:
	* Spring Security	To secure endpoints and integrate GitHub login
	* OAuth2 Client	For GitHub OAuth login
* SQL:
	* Spring Data JPA	For working with PostgreSQL via JPA/Hibernate
	* PostgreSQL Driver	To connect to your PostgreSQL database
* Template Engines:
	* Thymeleaf 	Server-side rendered views (e.g. emails)
* I/O:
	* Validation	For input validation (e.g. form fields, request data)

---

## 📜 4 License


This project is licensed under the
[Apache License](https://www.apache.org/licenses/LICENSE-2.0).

You are free to use, modify, and distribute this software in both personal and commercial projects,
provided that you include a copy of the license and provide appropriate attribution.

There is no warranty, and the software is provided "as is."