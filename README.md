
## Test Automation Framework

This project is a Java-based Selenium Test Automation Framework built for testing web applications.

It follows the Page Object Model (POM) design pattern and supports parallel execution, reporting, logging, retry mechanisms, and cloud execution using LambdaTest.

The framework is designed to be scalable, maintainable, and reusable, similar to automation frameworks used in real-world SDET teams.


## Features

- Page Object Model (POM) architecture  
- Cross-browser testing  
- Parallel execution using TestNG  
- Retry mechanism for failed tests  
- Screenshot capture on failure  
- Detailed HTML reporting using Extent Reports  
- Logging using Log4j  
- Cloud execution using LambdaTest  
- CI execution using GitHub Actions  


## Tech Stack
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Extent Reports  
- Log4j  
- LambdaTest  
- JSON  
- Java Faker  


## Prerequisites
Before running the framework, make sure the following tools are installed:

- Java 17
- Maven
- Git
- Chrome Browser
  

## Setup Instructions

## Clone the repository

```bash
git clone https://github.com/sushie0208/Test-Automation-Framework.git
cd Test-Automation-Framework
```

---

# Running Tests

## Run tests locally

```bash
mvn clean test
```

---

## Run tests on LambdaTest

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
```

---

## Run tests locally in headless mode

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
```

## The test suite configuration is defined in:

testng.xml

Example configuration:

<suite name="Automation Practice Test Suite" parallel="tests" thread-count="2">


## Reports

After execution, an HTML report is generated.

Location:

```
/reports.html
```

The report contains:

- Passed tests
- Failed tests
- Skipped tests
- Screenshots for failed tests

## Screenshots

Screenshots for failed test cases are stored in:

/screenshots

These screenshots are also attached to the Extent report.

## Logs

Execution logs are generated using Log4j and stored in:

/logs

Logs help in debugging test failures.


## CI Integration


The framework is integrated with **GitHub Actions**.

The pipeline automatically:

- Builds the project
- Runs the TestNG suite
- Generates reports
- Uploads logs and artifacts


## 🔗 Links

[![Portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/sushie0208/)

[![LinkedIn](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/susmita-hajare-525557167/)




## Authors


Susmita Hajare

GitHub:  
https://github.com/sushie0208
