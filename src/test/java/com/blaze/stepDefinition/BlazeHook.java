package com.blaze.stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class BlazeHook {


   public WebDriver driver;


   @Before
    public void startUp(){

       driver= DriverHelper.getDriver();

   }



   @After
    public void tearDown() throws InterruptedException {
       Thread.sleep(300);
       driver.quit();
   }













}
