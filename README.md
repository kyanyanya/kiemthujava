# Bank Account Management

This is a simple Java project that demonstrates basic bank account management with functionalities such as deposit, withdraw, and balance checking. The project includes unit tests written using JUnit to ensure code reliability.

---

## Features

- **Create Bank Account**: Initialize an account with an initial balance.
- **Deposit Money**: Add funds to the account.
- **Withdraw Money**: Remove funds from the account, with checks for sufficient balance.
- **Check Balance**: Retrieve the current account balance.
- **Error Handling**: Handles invalid inputs such as negative values or over-withdrawal.

---

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or later.
- **Maven**: For dependency management.
- **JUnit**: Included via Maven dependencies.

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/kyanyanya/kiemthujava.git
   cd bank-account-management
2. Build the project using Maven:
   mvn clean install
3. Run the tests:
   mvn test

# Project Structure
.
├── src
│   ├── main
│   │   └── java
│   │       └── BankAccount.java
│   └── test
│       └── java
│           └── BankAccountTest.java
├── pom.xml
└── README.md

![img.jpg](img/img.jpg)