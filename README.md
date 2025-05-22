# Bitheap Automation Framework

## Overview

This project is a **Bitheap automation framework** developed to automate the process of purchasing a product. The core technologies used in this project include:

- **Java**
- **Selenium WebDriver**
- **JUnit**

It follows industry best practices and is structured using the **Page Object Model (POM)** to promote maintainability and scalability.

## Features

- ✅ Automated product purchase flow using Selenium
- ✅ Implementation of the **Singleton Design Pattern**
- ✅ Use of **WebDriverWait** to handle synchronization and avoid unexpected behavior
- ✅ Secure handling of demo login credentials (passwords are encoded and decoded safely)
- ✅ A centralized `Constants` class to store reusable values
- ✅ `FrameworkProperties` class for reading configuration values from external files
- ✅ Management of common web interruptions (such as cookie pop-ups)

## Test Coverage

- A set of JUnit test cases has been created to demonstrate key functionalities.
- Some personal details and functions have been intentionally excluded to protect confidential information.
- The demo account credentials used in this framework are **not personal** and are meant strictly for demonstration purposes.

## Security Considerations

- Encoded passwords are included and decoded during runtime to follow better security practices, especially when sharing code on public platforms.
- Sensitive information such as real personal details has been omitted.

## Known Issues & Notes

- The website used in this automation contains cookie pop-ups that may interfere with actions. The framework includes steps to **automatically dismiss these pop-ups** at the beginning of test flows.
- More enhancements and tests will be added over time to increase coverage and robustness.

## To Run This Project

To start the project:

1. Clone the repository.
2. Ensure you have Java and a compatible IDE (such as IntelliJ or Eclipse).
3. Install dependencies for Selenium and JUnit from a maven repo.
4. Configure your `properties` file with demo URLs and encoded credentials.
5. Run your test suite using your preferred test runner.

## Author

**Motsinoni Phillimon**  
Software Developer | Automation Enthusiast
