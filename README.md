# Playwright-with-Java and Cucumber 
## Built and run on Intellij

This project includes a cucumber feature file built using Maven Test Framework with Java using the Playwright library as the binder

For more details click here [Playwright using Java](https://playwright.dev/java/)

The tests are run as part of the build process, here on github. NB. Because this project uses features and scenarios rather than 'tests' the run cycle shows 0 tests run (Actions: run)), although a duration is sepecified demonstarting that the scenarios have indeed run.

By default the sceanrios are run in headless mode. To change this by setting setHeadless(true) to base in **BaseClass.java**

**To run using different browsers** change the browser value to one of: chrome, firefox or webkit in the file **config.properties**

When the feature file is run in intellij using the **junit test runner** (SauuceDemoTestRunner) the following cucumber report is generated. This generateds the cucumber.json file which can then be used to generate the Maven HTML Report, see further below

![image](https://user-images.githubusercontent.com/4279571/208960481-ce37603d-96c8-4808-a894-a43ce5161db6.png)

Clicking on the listed link gives:

![image](https://user-images.githubusercontent.com/4279571/208960888-47d013ce-db5e-483c-9457-694db917a5bb.png)

A **Maven Cucumber Report** can be generated by running the following command at the IntelliJ Terminal

`mvn verify test`

![image](https://user-images.githubusercontent.com/4279571/208961367-77cb84a4-6de1-4c4a-8b64-e5eedf2ff534.png)