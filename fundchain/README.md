# Fundchain

A blockchain-based crowdfunding platform built with Spring Boot.

## Features

- User authentication and authorization
- Project creation and management
- Blockchain integration for secure transactions
- Real-time updates using WebSocket
- Community features and discussions
- Document management
- AI-powered project analysis

## Technology Stack

- Java 17
- Spring Boot 3.2.3
- Spring Security
- Spring Data JPA
- H2 Database
- WebSocket
- Thymeleaf
- Lombok

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/fundchain.git
```

2. Navigate to the project directory:
```bash
cd fundchain
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## Project Structure

```
fundchain/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/fundchain/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── FundchainApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 