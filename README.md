# Sauce lab POM Automation Framework :)

This is a cloud device sauce labs automation framework built using Selenium, Maven, and Testng.

# Prerequisites

Before running the tests, make sure you have the following installed:

* Java JDK (version 8 or higher)
* Maven
* Git

# Getting Started

To get started, clone the repository from GitHub:
git clone https://github.com/mdhaseebpes/SeleniumGridSelenoidAWSHaseeb.git

# Running the Tests

To run the smoke tests, use the following command:
mvn clean test -Denv=qa -DsuiteXmlFile=src/test/java/resources/testrunner/smoke.xml


To run the regression tests, use the following command:
mvn clean test -Denv=qa -DsuiteXmlFile=src/test/java/resources/testrunner/regression.xml

To run the sanity tests, use the following command:
mvn clean test -Denv=qa -DsuiteXmlFile=src/test/java/resources/testrunner/sanity.xml

To run the in selenium grid, use the following command:
mvn clean test -Denv=qa -DsuiteXmlFile=src/test/java/resources/testrunner/regression_remote.xml

To run the in seleniod, use the following command:
mvn clean test -Denv=qa -DsuiteXmlFile=src/test/java/resources/testrunner/regression_selenoid.xml

This will execute test scripts and generate the test reports.

# Test Reports

After running the tests, the test reports will be generated in the output/report directory and allure-results directly. Open
currently we have reports 
* Extent HTML reports
* Allure reports


If you encounter any issues or errors while using the framework, please refer to the Troubleshooting section in the
README.md file on the GitHub repository. If the issue persists, feel free to open an issue on the repository page.

# Contributions

Contributions to the framework are welcome! If you have any improvements, bug fixes, or new features to suggest, please
fork the repository, make your changes, and submit a pull request.

# Contact
If you have any questions or need further assistance, please feel free to reach out to the project maintainer:

* Name: [MOHAMMED HASEEB ALI KHAN]
* Email: [mdhaseebpes@gmail.com]
  Thank you for using  Automation Framework! Happy testing!




