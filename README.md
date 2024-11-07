Overview

This project is a Test Automation Framework designed for web application testing using Java. The framework is structured with best practices in mind, following the Page Object Model (POM) design pattern to improve test maintenance and reduce code duplication. The structure includes well-organized packages for different components such as pages, utilities, and test cases.

Project Structure

The project directory is divided into the following sections:

1. src/main/java


Purpose: Contains main application code and resources.
Subdirectories:
resources/ – Reserved for any main project resources that may be needed.

2. src/test/java

Purpose: Contains all the test code and related classes.

Subdirectories:

pages

Description: Holds the Page Object Model classes representing different pages of the web application.

Classes:

BaseUrl: A base class providing common setup and teardown methods or base configurations.

HomePage: Represents the main or landing page of the application, containing web element locators and methods relevant to interactions on this page.

MobilePage: Represents a specific page related to mobile product listings, containing methods for interacting with mobile-specific elements.

MotorolaPage: Dedicated to the Motorola product page, holding locators and actions for this specific brand page.

SearchPage: Contains the locators and methods needed for search functionality interactions.


tests/searchTest

Description: Contains test classes focusing on search functionalities.

Test Class: Typically includes methods annotated with @Test that validate various search-related scenarios.


utilities

Description: Includes utility classes that provide reusable methods and functionality to support test execution.


Classes:

BrowserFactory: A utility class for initializing and managing browser instances.
CategoriesDataProvider: Supplies data for test methods using @DataProvider to handle multiple test cases efficiently.

ExcelUtilities: A helper class for reading and writing data from/to Excel files.

TestNGUtilities: Contains common utilities that assist with the execution of TestNG test cases.


Framework Features

Page Object Model (POM): Enhances code readability and maintainability.

TestNG Integration: Manages test execution and reporting.

Data-Driven Testing: Supported through CategoriesDataProvider and ExcelUtilities for external data input.

Browser Management: Centralized setup and teardown methods using BrowserFactory.


Installation and Setup

Clone the repository:
"git clone [https://github.com/chrisMper/ASQA.git]"

Import the project into your preferred IDE (e.g., IntelliJ IDEA or Eclipse).

Ensure dependencies are met by installing them via Maven:
"mvn install"

Run tests: You can execute tests via the TestNG XML file (testng.xml) located in the project root.

Usage

Page Classes: Interact with web elements and execute actions relevant to each page.

Test Classes: Include @Test annotated methods that use page class methods to validate application functionality.

Utilities: Utilize helper functions for setup, data handling, and common test logic.
Dependencies
Java: Version 8 or higher
Maven: Build and dependency management tool
TestNG: Test framework for Java
Apache POI: For Excel data handling
