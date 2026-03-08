package utils;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static java.awt.SystemColor.text;

public class BrowserUtils {





public static String getText(WebElement element, WebDriver driver){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
}




public static void sendKeys(WebElement element,WebDriver driver, String key){

 try{

     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
     wait.until(ExpectedConditions.elementToBeClickable(element));
     element.clear();
     element.sendKeys(key);
 }catch (ElementNotInteractableException | NoSuchElementException e) {//you can use many exceptions but cant use parent and child exceptions together
     System.err.println("Exception occurred while sending key" + e.getMessage());

 }

}


    public static void click(WebElement element, WebDriver driver){
//TimeoutException
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }catch (TimeoutException | ElementNotInteractableException e){

            System.err.println("JavaScript method did not work on click " + e.getMessage());

        }

    }



   //to handle dropdowns
   public static void selectBy(WebElement element, String option, String methodName){

        Select select = new Select(element);

        switch (methodName){
            case "visibleText":
                select.selectByVisibleText(option);
                break;
            case "ByValue":
                select.selectByValue(option);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(option)); //select.selectByIndex(int index) --it converts a string into a primitive int
                break;
            default:
                System.out.println("please check your method name, the method name you chose is not available");
        }

    }




    public static void scrollWithJS(WebDriver driver, WebElement element){

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(element));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true)",element);

    }




    public static void switch2Windows(WebDriver driver){

  String currentID =  driver.getWindowHandle();
  Set<String> allIDs=  driver.getWindowHandles();


    for (String ID :allIDs){

        if (!ID.equals(currentID)){
            driver.switchTo().window(ID);
            break;
        }
    }

    }





    public static void switchWindowWithTitle(WebDriver driver, String title){

   Set<String> ids =  driver.getWindowHandles();

   for (String id : ids){

      driver.switchTo().window(id);

      if (driver.getTitle().contains(title)){
          break;
      }
   }

    }




    public static void switchWindowWithURL(WebDriver driver, String URL){

   Set<String> ids =  driver.getWindowHandles();


   for (String id : ids){
       driver.switchTo().window(id);

       if (driver.getCurrentUrl().contains(URL)){
           break;
       }
   }
    }




    public static void acceptJSAlert(WebDriver driver){

    try {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert= driver.switchTo().alert();
        alert.accept();
    }catch (NoAlertPresentException e){

        System.err.println("Exception occurred while switching driver to alert" +e.getMessage());
    }
    }


    public static String getTextFromAlert(WebDriver driver){

    String text =" ";

    try{

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
       text=alert.getText();

    }catch (NoAlertPresentException e){
        System.err.println("Exception occurred while attempting to switch to js alert "+e.getMessage());
    }

    return text;
    }



    public  static void moveToElementWithAction(WebDriver driver, WebElement element){

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }























}
