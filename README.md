# SauceDemoSumerge

This project is designed to test the login functionality for the [SauceDemo](https://www.saucedemo.com/) website using Selenium WebDriver and TestNG.

## Task

The task is to validate the login form on the SauceDemo website.

### Requirements

1. **Check if the username and password fields are on the main screen:**
    - Username input has `id="user-name"`
    - Password input has `id="password"`
    - Login button has `id="login-button"`

2. **Check if valid credentials work:**
    - Username: `standard_user`
    - Password: `secret_sauce`
    - After login, a div containing text "Swag Labs" is visible.

3. **Check if invalid credentials show an error:**
    - Use invalid credentials
    - Error message: "Epic sadface: Username and password do not match any user in this service"

4. **Check for empty credentials:**
    - Empty username: "Epic sadface: Username is required"
    - Empty password: "Epic sadface: Password is required"

## Project Structure
```plaintext
SauceDemoSumerge/
│   .gitignore
│   pom.xml
│   testng.xml
│
├───FailedTestcaseScreenshot
│
├───src
│   └───test
│       └───java
│           ├───library
│           │       BaseClass.java
│           │       UtilityClass.java
│           │
│           ├───pages
│           │       LoginPage.java
│           │
│           └───tests
│                   LoginPageTest.java
│
├───test-output
│      emailable-report.html
│
└───TestData
       config.properties
```
## File Descriptions

- **BaseClass**: WebDriver setup and teardown methods.
- **UtilityClass**: Utility methods including data reading and screenshot capture.
- **LoginPage**: Page Object Model (POM) for the login page.
- **LoginPageTest**: TestNG tests for SauceDemo login functionality.
   - `verifyUsername`: Checks if the username input field is displayed.
   - `verifyPassword`: Checks if the password input field is displayed.
   - `verifyLoginButton`: Checks if the login button is displayed.
   - `loginWithValidCredentials`: Enters valid credentials (`standard_user`, `secret_sauce`) and verifies redirection to the product page URL and the presence of the Swag Labs logo.
   - `loginWithInvalidCredentials`: Enters invalid credentials and verifies the display of the correct error message.
   - `loginWithBlankUsername`, `loginWithBlankPassword`, `loginWithBlankCredentials`: Tests for empty username, password, and both fields, verifying the respective error messages.


## Getting Started

### Prerequisites

- Java 12
- Maven
- IntelliJ IDEA or Eclipse

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/MennatAllahhxx/SauceDemoSumerge.git
   cd SauceDemoSumerge
   ```
2. Open the project in your preferred IDE (IntelliJ IDEA or Eclipse).

3. Ensure Maven dependencies are resolved by running:
   ```sh
   mvn clean install
   ```

4. Configure the `testng.xml` file in your IDE to define test suites or modify test parameters as needed.

## Usage

### Running Tests

1. To execute the tests, run:
   ```sh
   mvn test
   ```

2. After running tests, view detailed test results in `test-output/emailable-report.html`.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
