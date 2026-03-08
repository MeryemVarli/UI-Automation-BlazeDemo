package com.blaze.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

public class MainPage {



    private WebDriver driver;


    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

@FindBy(xpath = "//a[.='Laptops']")
    WebElement laptopsBtn;


@FindBy(xpath = "//a[.='MacBook Pro']")
    WebElement macPro;


@FindBy(css = "a[class='btn btn-success btn-lg']")
    WebElement addToCartBtn;

@FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement cartBtn;




public void selectCategoryAndProduct(){

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    try{
        BrowserUtils.click(this.laptopsBtn,driver);
    }catch (StaleElementReferenceException e){

        System.out.println("Element was stale, retrying the click...");
        wait.until(ExpectedConditions.elementToBeClickable(this.laptopsBtn)).click();
    }catch (TimeoutException | ElementNotInteractableException e){
        System.err.println("Standard click failed, attempting JS click"+e.getMessage());
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()",this.laptopsBtn);

        }catch (Exception jsEx){
            System.err.println("Javascript also failed"+jsEx.getMessage());
        }

    }


wait.until(ExpectedConditions.visibilityOf(this.macPro));
BrowserUtils.click(this.macPro,driver);

}


public void addProductToCart(){

    BrowserUtils.click(this.addToCartBtn,driver);

   String alertText =  BrowserUtils.getTextFromAlert(driver);
   System.out.println(alertText);
   BrowserUtils.acceptJSAlert(driver);

   BrowserUtils.click(this.cartBtn,driver);
}




}
