## 📌 Project Overview
This project is **a scalable, maintainable Selenium automation framework built using Java and industry best practices. It supports cross-browser execution, parallel testing, CI/CD integration, and automated reporting.**
The framework is designed **to simulate real-world enterprise automation projects, with a focus on readability, reusability, stability, and CI readiness.**

## 🎯 Purpose
- Demonstrate **real-world automation framework design**
- Showcase **CI/CD, Docker, Selenium Grid integration**
- Provide **a ready-to-use enterprise automation template**
- Enable **parallel, cross-browser execution**
- Automate **test execution reporting & notifications**

## ✨ Key Features
- Selenium WebDriver with Java
- TestNG for orchestration & parallel execution
- Page Object Model (POM)
- Data-driven testing
- RetryAnalyzer for failed tests
- Thread-safe WebDriver using ThreadLocal
- Extent HTML Reports
- Log4j2 logging
- Jenkins CI/CD integration
- Dockerized Selenium Grid execution
- Automated test execution reporting

## 🧪 Test Types Covered
- UI Tests
- API Tests
- Database Verification Tests
- Data Driven Tests

## 🧰 Tools & Technologies and  Usages in This Project

**Java 17** `→|Core programming language|` 

**Selenium WebDriver** `→|UI automation|`  

**TestNG** `→|Test orchestration & parallel execution|` 

**Maven** `→|Dependency & build management|` 

**Log4j2** `→|Logging|` 

**Extent Reports** `→|Rich HTML reports|` 

**Git / GitHub** `→|Version control|` 

**Jenkins** `→|End-to-end CI automation|` 

**Docker** `→|Containerized execution|` 

**Selenium Grid** `→| Parallel & cross-browser testing|` 

##📁 Framework Folder Structure
```
Demo-Automation-Project
|
|---- src/main/java
|   |---- com.orangehrm.actiondriver →|Reusable WebDriver actions|
|   |    |---- ActionDriver.java
|   |---- com.orangehrm.base →|Base test setup & teardown|
|   |   |---- BaseClass.java
|   |---- com.orangehrm.listeners →|TestNG listeners (retry, reports)|
|   |   |---- TestListener.java
|   |---- com.orangehrm.pages →|Page Object classes|
|   |   |---- HomePage.java
|   |   |---- LoginPageTest.java
|   |---- com.orangehrm.utilities →|Helpers (config, waits, utils)|
|       |---- ApiUtility.java
|       |---- DataProvider.java
|       |---- ExcellReaderUtility.java
|       |---- ExtentManager.java
|       |---- RetryAnalyzer.java
|       |---- ..........
|
|---- src/main/resources
|   |---- config.properties →|Environment configuration|
|   |---- log4j2.xml →|Logging configuration|
|
|---- src/test/java
|   |---- com.orangehrm.test
|       |---- LoginPageTest.java →|UI test cases, Data-driven test case|
|       |---- HomePageTest.java →|UI test cases|
|       |---- ApiTest.java →|API tests|
|       |---- DBVerificationTest.java →|DB validation tests|
|       |---- ..........
|
|---- src/test/resources
|   |---- ExtentReport →|HTML execution reports|
|   |	|---- ExtentReport.html
|   |----  screenshots →|Stores screenshots|
|   |---- testdata →|Data-driven test files|
|   	|---- TestData.xlsx
|
|---- docker
|   |---- docker-compose.yml →|Selenium Grid & nodes setup|
|
|---- logs
|   |---- app.log →|Execution logs|
|   |---- error.log
|
|---- Jenkinsfile →|CI pipeline script|
|---- pom.xml →|Maven dependencies|
|---- testng.xml →|Test suite configuration|
|---- target →|Build artifacts|
```
##🏗️ High-Level Architecture

```
Developer (Eclipse IDE)
        |
        |  Code Commit & Push
        v
     GitHub Repository
        |
        |  GitHub Webhook / SCM Polling
        v
     Jenkins Pipeline & Stages (CI Server)
        |-Start
        |-- 1. Checkout Source Code Management
        |-- 2. Tool Install (Maven)
		|-- 3. Environment Setup (Docker Compose)			
		|				|--Start Selenium Grid Hub
		|					|-- Chrome Node
		|					|-- Firefox Node
		|					|-- Edge Node
		|-- 4. Checkout Repo
        |-- 5. Build Project (Maven Clean Install)
        |-- 6. Test - Execute TestNG Suites (Parallel Execution) . Application Under Test (OrangeHRM – Local/XAMPP)
		|				|-- UI Tests
		|				|-- API Tests
		|				|-- DB Verification Tests
		|-- 7. Stop Selenium Grid (Cleanup Running Containers)
		|-- 8. Publish Extent Reports		
		|-- 9. Post Action - Email Notification (Success / Failure)
		|-END
```
## 🛠️ Project Setup & Execution steps
1. Install Java 17, Maven 3.9.11, and add system environment variables for Java and Maven.
2. Locally host OrangeHRM Test site using XAMPP.
3. Install Jenkins 2.528.3,  Docker Desktop
4. Make sure Docker.Desktop, Jenkins are up and running (locally)
5. Setup ngrok to Forward locally hosted Jenkins, accessible globally for webhook communications.
6. Make sure Jenkins site (http://localhost:8080/) is accessible globally and locally:
7. XAMPP, Jenkins and Docker should be up and running. Check the OrangeHRM Test site is accessible through web browsers. 
8. Clone the project from GitHub repository.
9. Change the following to make sure it does not overlap or duplicate with existing Eclipse projects (Optional)
10. Import the project into Eclipse as a Maven project.
11. Change the configuration property file's settings to run locally.
12. Check if the project is good to go.	\
	`d. Run Project As Maven clean - Verify "BUILD SUCCESS"` \
	`e. Run Project As Maven install - Verify "BUILD SUCCESS"`
13. Create a GitHub Repository
14. Push project to GitHub repo (Initial commit)
15. Configure Git Webhook for the repo.
16. Ensure the OrangeHRM web application is running locally
17. Change configuration property settings to run under Dockerized Selenium-Grid \
	`seleniumGrid=false` \
	`dockerActive=false` \
	`headlessMode=true`
18. Configured Jenkins pipeline project enabling triggering with webhook
	a. Pipeline script from SCM with trigger webhook
	b. Repo link, Branch, Script Path
19. Adjust Environment Parameters in 'Jenkinsfile' as per the project's specifications.
20. Push code changes to GitHub and minimize Eclipse.
21. Immediately Observe the Project section. Jenkins will auto-triggers build process of the pipeline 
22. Monitor Jenkins console logs
23. Necessary docker container will be created and Monitor Selenium-Grid
24. Wait for execution to end.
25. Receive execution report via email
26. View email and reports.

## 🏁 Final Notes
This framework demonstrates **enterprise-level automation design**, CI/CD integration, and scalable test execution suitable for real-world projects.
