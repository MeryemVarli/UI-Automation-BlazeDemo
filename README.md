## **UI Testing Project: BlazeDemo Automation**

Automated UI testing framework for the BlazeDemo e-commerce website using Selenium WebDriver, Java, and Cucumber BDD.





## **Prerequisites**
* Java Development Kit (JDK) installed
* Maven installed
* WebDriver binaries (if not managed by Maven)


  
  

## **Setup**
Clone the repository:
git clone https://github.com/MeryemVarli/UI-Automation-BlazeDemo.git




## **Project Structure**

*  **src/test/java/com/blaze:**
     * `pages/`: Implements Page Object Model (POM) for UI element encapsulation.
     * `stepDefinition/`: Maps Gherkin steps to Java logic, including Hooks for browser lifecycle management.
     * `runners/`: JUnit runner configured with CucumberOptions.
     
  * **utils/: Core framework utilities:**
     * `DriverHelper`: Implements the Singleton Pattern for WebDriver management.
     * `BrowserUtils`: Common reusable actions.
     * `ConfigReader`: Handles environment data from properties files.
     
  * **configuration.properties:** Centralized storage for URLs and test credentials.
  * **pom.xml:** Manages project dependencies and build lifecycle.

    
    

**#Features & Scenarios Tested**

* E2E Purchase Flow: A data-driven scenario using Scenario Outline to validate the full checkout process
* Login Functionality(Positive & Negative)

  
  

**#Tests Report**
 **[View Interactive UI Test Report](target/uiReport.html)**
> **Note:** The framework generates a detailed `uiReport.html` in the `target/` folder after every run. To view the report with full styling, download the repository and open the `uiReport.html` file in any browser.



 
