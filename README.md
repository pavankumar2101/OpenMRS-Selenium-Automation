# OpenMRS Selenium Automation Framework

## Overview

This project is a Selenium automation framework developed for testing the OpenMRS application.

The framework follows industry-standard automation practices including:

- Page Object Model (POM)
- TestNG execution
- Parallel test execution
- ThreadLocal WebDriver management
- Extent HTML reporting
- Logging
- Retry mechanism
- Environment-based configuration

## Technology Stack

| Tool | Purpose |
|---|---|
| Java 17 | Programming Language |
| Selenium WebDriver 4.35.0 | Browser Automation |
| TestNG 7.11.0 | Test Execution Framework |
| Maven | Build Management |
| WebDriverManager 5.9.2 | Browser Driver Management |
| Extent Reports 5.1.2 | Test Reporting |
| SLF4J + Logback | Logging Framework |

## Framework Features

### Page Object Model (POM)

The framework follows the Page Object Model design pattern.

Page classes contain:

- Web element locators
- Page actions
- Reusable methods

Benefits:

- Better code maintainability
- Improved code reusability
- Cleaner test scripts

### Parallel Execution

The framework supports parallel test execution using TestNG.

Features:

- Multiple test classes can execute simultaneously
- ThreadLocal WebDriver management
- Independent browser instances for each test thread

### Browser Management

Browser handling is implemented using:

- BrowserFactory
- DriverManager
- WebDriverManager

The framework supports configurable browser execution.

### Reporting

The framework uses Extent Reports for HTML test reporting.

Report features:

- Timestamp-based report generation
- Execution metadata
- Environment details
- Screenshots on test failure

### Retry Mechanism

The framework includes TestNG retry support.

Failed tests can automatically retry based on the configured retry logic.

### Configuration Management

The framework supports environment-based configuration using:

- config.properties
- config-dev.properties
- config-qa.properties

Maven profiles are used to execute tests in different environments.

## Project Structure

The framework follows a modular structure:

```text
com.openmrs

├── base          - Test setup and teardown
├── pages         - Page Object Model classes
├── tests         - Test execution classes
├── utils         - Reusable utility classes
├── reporting     - Extent Report management
├── listeners     - TestNG listeners
└── retry         - Retry mechanism classes
```

## Configuration Setup

The framework supports environment-based configuration using property files.

Configuration files are located in:

```text
src/test/resources
```

Available configuration files:

```text
config.properties
config-dev.properties
config-qa.properties
```

### Maven Profiles

The framework uses Maven profiles to select the execution environment.

Available profiles:

| Profile | Configuration |
|---|---|
| dev | config-dev.properties |
| qa | config-qa.properties |

## Test Execution

The framework can be executed using Maven profiles.

### Run Tests in Development Environment

Command:

```bash
mvn test -Pdev
```

Uses:

```text
config-dev.properties
```

### Run Tests in QA Environment

Command:

```bash
mvn test -Pqa
```

Uses:

```text
config-qa.properties
```

### TestNG Execution

The framework uses:

```text
testng.xml
```

for:

- Test class execution
- Parallel execution configuration
- Listener configuration

## Test Reports

The framework generates HTML reports using Extent Reports.

Reports are created in:

```text
test-output/
```

Each execution generates a unique timestamp-based report.

Example:

```text
ExtentReport_01-08-2026_21-16-20.html
```

The report contains:

- Test execution status
- Pass/Fail details
- Environment information
- Browser information
- Execution time
- Java version
- Operating system details
- Screenshots for failed tests

## CI/CD Preparation

The framework is designed to support future CI/CD integration.

Automation tests can be executed through Maven commands:

```bash
mvn test -Pdev
```

or

```bash
mvn test -Pqa
```

The framework is suitable for integration with CI/CD tools such as:

- Jenkins
- GitHub Actions
- Azure DevOps

Generated test reports and execution results can be collected after every pipeline run.