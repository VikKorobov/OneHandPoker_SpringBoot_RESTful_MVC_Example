# OneHandPoker_SpringBoot_RESTful_MVC_Example
A stateless **RESTful** Poker **API** built with *Spring Boot* and *Spring MVC*, simulating a single hand of poker. A teaching example demonstrating **RESTful API** design, **HTTP** methods, request/response handling, **MVC** architecture, and stateless application principles.

---
## About the Project

This project is an educational **RESTful API** built with *Spring Boot* and *Spring MVC*, using a simplified, single-hand poker scenario to demonstrate modern backend software development.

The application is designed as a practical teaching example for students, junior developers, and anyone interested in learning how to build, structure, test, document, and deploy a Java-based REST API.

Rather than focusing solely on making an application work, this project emphasizes understanding why software is designed in a particular way.

It demonstrates how established software engineering principles, architectural patterns, testing methodologies, and development tools can work together to produce maintainable, readable, testable, and extensible software.

The project covers:

- **RESTful API** development and stateless communication
- *Spring MVC* and layered application architecture
- **Domain-Driven Design (DDD)**
- **Test-First Development (TFD)**
- Object-oriented design and **SOLID** principles
- **KISS**, **YAGNI**, and **DRY** principles
- Unit testing and mocking
- Relational database integration
- Containerization and reproducible development environments
- Dependency management and build automation
- Interactive **API** documentation

The primary goal is education, not the development of a gambling application.

### A Note on Gambling and Responsible Education

Poker has been selected as the application's example domain because it provides a recognizable set of rules, entities, relationships, and outcomes that can be modeled using object-oriented programming.

<ins>This project does not promote, encourage, or glorify gambling.</ins>

In fact, its educational intention is the opposite.

Gambling can cause serious financial, psychological, and social harm. The project does not seek to normalize gambling as a means of earning money or portray it as a desirable financial activity.

Instead, poker provides a convenient technical example for exploring concepts such as:

- Rule-based decision-making
- Domain modeling and business logic
- Probability and randomness
- Input validation and error handling
- State management and stateless communication
- Separation of responsibilities
- Deterministic and repeatable testing

The application deliberately focuses on a simplified, single-hand scenario rather than creating a complete gambling platform.

The educational value lies in understanding the underlying software engineering concepts, not in encouraging participation in gambling.

Where appropriate, the project can also serve as a starting point for discussing probability, risk, and the mathematical disadvantages associated with gambling.

<ins>Software development education should promote critical thinking and responsible technology use.</ins>

### Educational Objectives

By exploring this project, learners should gain a better understanding of how to:

1. Design and implement a **RESTful API** using *Java* and *Spring Boot*.
2. Understand the request-response lifecycle in *Spring MVC*.
3. Build stateless backend services.
4. Model business domains using Domain-Driven Design.
5. Write tests before implementing application functionality.
6. Apply **SOLID** principles to object-oriented software.
7. Recognize and avoid unnecessary complexity and duplication.
8. Separate business logic from infrastructure concerns.
9. Use mocks to isolate dependencies during testing.
10. Integrate a relational database into a backend application.
11. Containerize application components using *Docker*.
12. Manage dependencies and automate builds using *Maven*.
13. Document and explore API endpoints using *Swagger UI*.

The project is intended to encourage learners to question architectural decisions rather than simply reproduce existing code.

---
## Repository Structure and Learning Progression

### Step-by-Step Development with Git Branches

This repository is structured as a step-by-step educational project, where the application is developed incrementally rather than presented solely as a finished product.

Each development step is represented by a dedicated Git branch, allowing learners to follow the evolution of the application from its initial setup to its more complete implementation.

The purpose of this approach is to make the development process itself part of the learning experience.

Instead of only examining the final result, learners can explore how and why individual features, architectural decisions, design principles, and technologies are introduced.

### Branch Organization

The repository follows a sequential branch structure.

Each branch represents a specific milestone in the development process and builds upon the concepts introduced in previous steps.

An illustrative naming convention is:

```text
main
 |
 +-- step-01-project-setup
 |
 +-- step-02-domain-modeling
 |
 +-- step-03-unit-testing
 |
 +-- step-04-application-logic
 |
 +-- step-05-rest-api
 |
 +-- step-06-persistence
 |
 +-- step-07-containerization
 |
 +-- step-08-api-documentation
 |
 +-- ...
```

The branch names and number of steps may change as the project develops.

The `main` branch serves as the repository's central entry point. Individual step branches preserve the implementation at specific learning milestones.

Each step is intended to provide a meaningful reference implementation that can be explored independently while remaining part of the overall learning progression.

### Navigating the Branches

After cloning the repository, learners can explore the available branches using Git.

Clone the repository:
```bash
git clone <repository-url>
cd <repository-directory>
```

List available branches:
```bash
git branch -a
```

Switch to a particular learning step:
```bash
git switch step-02-domain-modeling
```

If the branch is not yet available locally, it can be retrieved from the remote repository.

Compare two consecutive development steps:
```bash
git diff step-01-project-setup..step-02-domain-modeling
```

This allows learners to examine the code changes introduced between two milestones.

### Recommended Learning Approach

For the best educational experience, learners are encouraged to follow the branches in sequence.

1. Begin with the first development step.
2. Read the documentation and identify the learning objectives.
3. Examine the implementation and its tests.
4. Try implementing the concepts independently.
5. Compare the implementation with the next branch.
6. Reflect on the design decisions and principles demonstrated.
7. Continue to the next development step.

Learners are also encouraged to create their own branches to experiment with alternative implementations without modifying the provided reference stages.

---
## Technology Stack

Each technology has been selected to demonstrate a specific responsibility within a modern backend development workflow.

### *Java* and *Spring Boot*

*Spring Boot* provides the foundation for developing the application.

*Spring Boot* simplifies the setup and configuration of Spring-based applications through features such as automatic configuration, dependency management, and embedded web servers.

#### Educational purpose

Students learn how to:

- Create and configure a Spring Boot application.
- Understand dependency injection and inversion of control.
- Define application components and their responsibilities.
- Manage dependencies through the Spring container.
- Separate configuration from business logic.
- Build independently executable backend services.

An important lesson is understanding that Spring Boot reduces configuration effort but does not replace the need for good software design.

### *Spring MVC*

*Spring MVC* provides the web framework used to expose the application's **RESTful API** endpoints.

It is responsible for processing incoming **HTTP** requests, routing them to controllers, and producing appropriate HTTP responses.

The **Model-View-Controller (MVC)** pattern separates different application responsibilities.

In this project:

- **Model:** Represents application data and domain concepts.
- **View:** Is represented by serialized API responses, typically JSON, rather than traditional HTML templates.
- **Controller:** Handles HTTP interactions and delegates business operations to the appropriate application components.

#### Educational purpose

Students learn about:

- **REST** controllers and endpoint mappings.
- **HTTP** methods such as GET, POST, PUT, and DELETE, where appropriate.
- Request parameters, path variables, and request bodies.
- *JSON* serialization and deserialization.
- **HTTP** status codes.
- Input validation.
- Separation between web controllers and business services.

---
## **RESTful** and Stateless Architecture

The application follows a **REST**-oriented architectural approach.

**REST** encourages the use of standard **HTTP** semantics, resource-oriented interfaces, and communication that does not depend on server-side client sessions.

A stateless **API** does not rely on server-side session information from previous requests to understand the current request.

Each request must contain the information required to process it, or identify resources whose state can be retrieved independently.

Stateless does not mean that an application cannot use a database or maintain persistent data.

It means that the server does not depend on conversational session state to process requests.

### Educational purpose

Learners explore:

- The difference between application state and session state.
- Why independent requests simplify **API** interactions.
- How statelessness supports scalability.
- Why **HTTP** status codes and response representations matter.
- How **REST API**s separate clients from server implementations.
- The importance of predictable and consistent endpoint behavior.

A single-hand poker scenario provides a manageable example for exploring these ideas without introducing the complexity of a full multiplayer application.

---
## Software Architecture and Design Philosophy

### Understanding Layered Architecture

This project introduces layered architecture, a software design approach that organizes an application into distinct layers, each with clearly defined responsibilities.

The main idea is to separate different concerns within a system rather than combining all functionality into tightly coupled components.

Each layer focuses on a particular aspect of the application and communicates with other layers through well-defined boundaries.

Layered architecture provides several benefits:

- Separation of Concerns: Different responsibilities are organized into distinct parts of the application.
- Maintainability: Changes to one part of the system can often be made without affecting unrelated functionality.
- Testability: Components can be tested independently by isolating their dependencies.
- Readability: A clear structure helps developers understand where functionality belongs.
- Flexibility: Implementations can be modified or replaced with less impact on other components.
- Reduced Coupling: Well-defined boundaries help prevent unnecessary dependencies between different parts of the system.

### **Domain-Driven Design (DDD)**

**Domain-Driven Design** is an approach to software development that places the business domain and its rules at the center of the design process.

Rather than organizing the entire application around frameworks or database tables, **DDD** encourages developers to understand the problem being solved and express that understanding through software.

In this project, the poker scenario provides a domain with recognizable concepts, such as cards, hands, rankings, and game rules.

#### Educational purpose

Students are introduced to:

- Domain: The problem area the software represents.
- Entities: Domain objects that have a meaningful identity.
- Repositories: Abstractions for retrieving and persisting domain objects.
- Domain Services: Operations expressing domain behavior that does not naturally belong to a single entity or value object.

Not every project requires every **DDD** building block. Learners should understand when each concept adds value rather than introducing it automatically.

#### Why **DDD** Matters

**DDD** encourages developers to keep core business rules independent of technical implementation details.

For example, determining the ranking of a poker hand is a domain concern. It should not depend on HTTP controllers, JSON serialization, or database-specific operations.

This separation makes the business logic easier to understand, test, and maintain.

### **Test-First Development (TFD)**

**Test-First Development** is a development approach in which tests are written before the functionality they verify.

The process encourages developers to think about expected behavior, inputs, outputs, and edge cases before writing implementation code.

1. Write a test: Describe the expected behavior of a small piece of functionality.
2. Observe failure: Confirm that the test fails because the behavior has not yet been implemented.
3. Implement functionality: Write the minimum code necessary to satisfy the test.
4. Refactor: Improve the implementation while keeping the tests passing.
5. Repeat: Continue with the next small requirement.

This is closely related to the Red-Green-Refactor cycle commonly associated with Test-Driven Development (**TDD**).

#### Educational purpose

Learners discover how test-first development can:

- Encourage clearer requirements.
- Improve software design.
- Reduce unnecessary implementation.
- Identify edge cases earlier.
- Support safe refactoring.
- Provide fast feedback during development.
- Encourage smaller, more focused components.

The intention is to demonstrate that testing is part of the development process, not merely a final verification step.

---
## Software Engineering Principles

The project uses established software engineering principles as guidelines for making design decisions.

These principles should not be treated as rigid rules. Their purpose is to help developers reason about maintainability, complexity, and change.

### **SOLID** Principles

**SOLID** represents five principles of object-oriented software design.

**S** — **Single Responsibility Principle (SRP)**

A class should have one primary reason to change.

For example, a component responsible for evaluating poker hands should not also be responsible for formatting HTTP responses or managing database connections.

**O** — **Open/Closed Principle (OCP)**

Software components should be open for extension but closed for modification.

A well-designed system should allow new behavior to be introduced without repeatedly rewriting stable existing functionality.

**L** — **Liskov Substitution Principle (LSP)**

Objects implementing a shared abstraction should be usable interchangeably without violating the expectations of that abstraction.

**I** — **Interface Segregation Principle (ISP)**

Clients should not be forced to depend on methods they do not use.

Smaller, focused interfaces are often easier to implement, test, and maintain than large interfaces containing unrelated operations.

**D** — **Dependency Inversion Principle (DIP)**

High-level business logic should not depend directly on low-level implementation details. Both should depend on appropriate abstractions.

For example, domain or application logic should not need to know the implementation details of a PostgreSQL connection.

#### Educational purpose

Students learn to:

- Keep responsibilities focused so that changes in one concern do not unnecessarily affect others.
- Learn how abstractions and polymorphism can support extension, while recognizing that unnecessary abstraction creates complexity.
- Understand behavioral contracts and why inheritance or interface implementation must preserve expected behavior.
- Design interfaces around meaningful responsibilities.
- Understand how dependency inversion and dependency injection improve modularity and testability.

### **KISS** — **Keep It Simple, Stupid**

**KISS** encourages developers to prefer straightforward solutions over unnecessary complexity.

A solution should be as simple as possible while still meeting its requirements.

#### Educational purpose

Students learn to:

- Prefer readable code over clever implementations.
- Avoid unnecessary design patterns.
- Keep methods and classes understandable.
- Reduce the number of moving parts.
- Choose the simplest design that correctly solves the problem.

The goal is not to write the fewest lines of code, but to produce code that is easy to understand and maintain.

### YAGNI — You Aren't Gonna Need It

**YAGNI** discourages implementing functionality based solely on assumptions about future requirements.

For example, a single-hand poker API does not automatically require multiplayer matchmaking, tournament management, payment processing, or a complex game engine.

#### Educational purpose

Students learn to:

- Focus on current requirements.
- Avoid speculative features.
- Recognize premature abstraction.
- Reduce maintenance overhead.
- Make design decisions based on demonstrated needs.

**YAGNI** reinforces the idea that good software design does not require building every conceivable feature.

### DRY — Don't Repeat Yourself

**DRY** encourages developers to avoid duplicating knowledge and business rules throughout a system.

If a domain rule is defined in multiple locations, changes may require several independent updates and introduce inconsistencies.

#### Educational purpose

Students learn to:

- Identify duplicated business knowledge.
- Extract reusable logic where appropriate.
- Establish a single authoritative implementation of domain rules.
- Avoid unnecessary coupling through excessive reuse.

**DRY** does not mean that every visually similar piece of code must be combined.

Sometimes small amounts of structural similarity are preferable to creating an inappropriate abstraction.

The important distinction is between duplicated code and duplicated knowledge.

---
## Tech-Stack

### Testing Technologies - *JUnit* & *Mockito*

*JUnit* is the primary testing framework used in the project.

It provides the tools required to define and execute automated tests for Java code.

#### Educational purpose

Students learn how to:

- Write unit tests.
- Organize test cases.
- Assert expected outcomes.
- Test normal behavior and edge cases.

For a rule-based domain such as poker, testing is particularly valuable because expected results can often be clearly defined.

For example, a test can verify that a particular combination of cards produces the expected hand classification.

*Mockito* is a *Java* mocking framework used to create controlled substitutes for dependencies during testing.

Mocks allow a test to focus on the behavior of a specific component without requiring all of its collaborators to be available.

#### Educational purpose

Students learn to:

- Isolate units of behavior.
- Replace external dependencies with test doubles.
- Define controlled responses from collaborators.
- Verify interactions where appropriate.
- Distinguish unit tests from integration tests.

For example, a service can be tested with a mocked repository without requiring a running PostgreSQL database.

### Persistence and Infrastructure - *PostgreSQL*

*PostgreSQL* is the relational database technology used by the application.

It introduces learners to the persistence layer and the distinction between application memory, session state, and durable storage.

#### Educational purpose

Students learn about:

- Relational data modeling.
- Data persistence.
- Separation of persistence logic from domain logic.
- Database configuration and connectivity.

*PostgreSQL* also provides an opportunity to discuss how database concerns should be isolated from the core business domain.

A stateless **API** can still interact with persistent data. The key is that processing a request does not depend on a previous client session.

### Containerization - *Docker*

*Docker* provides containerization for application infrastructure and deployment environments.

Containers package software with the environment required to execute it, helping reduce inconsistencies between development machines.

#### Educational purpose

Students learn about:

- Images and containers.
- Dockerfiles.
- Container networking.
- Environment variables.
- Port mapping.
- Persistent volumes.
- Running PostgreSQL in a container.
- Reproducible development environments.
- Multi-container applications and Docker Compose, where applicable.

Docker demonstrates how an application's execution environment can be defined and reproduced rather than configured manually on every machine.

It also provides a practical introduction to infrastructure concepts commonly encountered in professional software development.

### Build and Dependency Management - *Apache Maven*

*Maven* is used to manage project dependencies and automate the Java build lifecycle.

Its configuration is defined primarily through the `pom.xml` file.

#### Educational purpose
Students learn how to:

- Declare and manage dependencies.
- Understand dependency scopes.
- Package an application.
- Understand reproducible builds.
- Use standard project directory conventions.

Maven provides a consistent workflow for building and testing the application across different development environments.

### API Documentation - *Swagger UI* & *OpenAPI*

*Swagger UI* provides an interactive interface for exploring and testing the REST API.

It typically uses an *OpenAPI* specification to describe available endpoints, request structures, responses, and HTTP operations.

#### Educational purpose

Students learn about:

- **API** contracts.
- Endpoint documentation.
- Request and response schemas.
- **HTTP** response codes.
- Communication between backend and frontend.
- The importance of keeping documentation consistent with implementation.

*Swagger UI* helps learners understand how external consumers interact with a backend application.

It also reinforces the idea that an API is a public contract, not merely a collection of controller methods.

---
## How the Concepts Work Together

One of the project's most important educational goals is demonstrating how technologies and principles complement each other.

Each component has a distinct responsibility:

- *Spring MVC* handles **HTTP** communication.
- Application services coordinate use cases.
- Domain objects represent business concepts and enforce domain rules.
- Repositories provide persistence abstractions where needed.
- *PostgreSQL* stores persistent information.
- *JUnit* and *Mockito* help verify behavior.
- *Maven* automates builds and testing.
- *Docker* provides reproducible runtime environments.
- *Swagger UI* makes the API discoverable and easier to explore.

**DDD** helps define boundaries between these responsibilities.

**SOLID** helps guide the design of individual components.

**KISS**, **YAGNI**, and **DRY** help manage complexity.

**TFD** encourages developers to verify behavior throughout implementation.

Together, these practices demonstrate how software engineering extends beyond writing code that simply produces the expected output.

---
## Project Scope and Limitations

This application is intentionally limited in scope.

It is a teaching example, not a production-ready gambling platform or a complete poker implementation.

Its simplified single-hand scenario allows learners to focus on architecture, testing, and software engineering principles without introducing unnecessary application complexity.

The project should not be interpreted as demonstrating every possible feature of *Spring Boot*, **DDD**, **REST**, or production system design.

Similarly, applying architectural principles does not guarantee that every design decision is optimal.

The code should be examined critically, discussed, tested, and improved as part of the learning process.

---
# Final Thoughts

Software engineering is about more than choosing frameworks and writing functioning code.

It involves understanding a problem, modeling its rules, managing complexity, testing assumptions, and creating systems that other developers can understand and maintain.

This project uses a deliberately small and recognizable domain to demonstrate those skills.

Its educational philosophy can be summarized as:

Understand the problem. Design with intention. Test behavior. Keep things simple. Learn from the decisions.

The ultimate purpose of this repository is not to teach people how to gamble, but to help them become more thoughtful, responsible, and capable software developers.

---
## License — Creative Commons CC0 1.0 Universal

### Public Domain Dedication

<ins>This project is released under *Creative Commons Zero 1.0 Universal (CC0 1.0)*.</ins>

*CC0* is a public domain dedication designed to make creative and educational works freely available for anyone to use, modify, share, and build upon.

The author waives copyright and related rights to the greatest extent permitted by applicable law.

Where a complete waiver is not legally possible, CC0 provides a fallback license allowing broad reuse.

### What Does *CC0* Allow

Under *CC0*, you are free to:

- Use: Use the project for personal, educational, academic, or commercial purposes.
- Copy: Reproduce the source code and documentation.
- Modify: Change, improve, refactor, or extend the application.
- Distribute: Share the original or modified project with others.
- Build Upon: Incorporate the material into other projects, including commercial applications.

No permission from the original author is required for these uses.

### Attribution Requirements

Attribution is not legally required under *CC0*.

However, acknowledging the original project is appreciated, particularly when using it in educational material.

Giving credit supports academic integrity, helps learners discover the original teaching resources, and encourages knowledge sharing.

Attribution is a recommendation, not a condition of use.

### Important Limitations

*CC0* also has several important limitations:

- <ins>No warranties:</ins> The project is provided as-is, without guarantees of correctness, reliability, security, or suitability for a particular purpose.
- <ins>No liability:</ins> The author disclaims liability for the use of the work to the extent permitted by law.
- <ins>No patent or trademark grants:</ins> *CC0* does not grant patent or trademark rights.
- <ins>Third-party rights:</ins> Dependencies, libraries, and other third-party materials remain subject to their respective licenses and rights.
- <ins>*No implied endorsement:</ins> Reusing the project does not imply that the original author endorses the resulting work.

### Why *CC0* Was Chosen

The purpose of this repository is to make software engineering education as accessible as possible.

Knowledge should be easy to explore, reproduce, challenge, improve, and share.

By using *CC0*, the project aims to remove unnecessary copyright-related barriers to educational reuse.

Students, teachers, self-taught developers, and educational institutions are encouraged to adapt the material to their own learning needs.

This includes translating documentation, restructuring lessons, experimenting with alternative architectures, and creating new teaching resources.

The goal is to encourage learning and the free exchange of knowledge rather than restrict how educational material can be used.

### Official License

- [CC0 1.0 Universal — Summary](https://creativecommons.org/publicdomain/zero/1.0/)
- [CC0 1.0 Universal — Full Legal Text](https://creativecommons.org/publicdomain/zero/1.0/legalcode.en)

<ins>SPDX License Identifier:</ins> `CC0-1.0`

This license note is provided for educational clarity. The official CC0 legal text governs the public domain dedication.
