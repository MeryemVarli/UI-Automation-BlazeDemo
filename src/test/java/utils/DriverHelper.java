package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverHelper {

    //singleton patter design
  private static WebDriver driver;


    private DriverHelper(){}


    public static WebDriver getDriver(){

      if (driver==null || ((RemoteWebDriver)driver).getSessionId()==null) {

          switch (ConfigReader.readProperty("browser")) {
              case "chrome":
                  driver=new ChromeDriver();
                  break;

              case "firefox":
                  driver = new FirefoxDriver();
                  break;

              case "edge":
                  driver = new EdgeDriver();
                  break;

              case "safari":
                  driver = new SafariDriver();
                  break;

              default:
                  driver = new ChromeDriver();

          }

          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

      }


       return driver;


      }


    }









