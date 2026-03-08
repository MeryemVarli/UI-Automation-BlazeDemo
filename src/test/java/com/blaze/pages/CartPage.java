package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CartPage {

    private WebDriver driver;


  public CartPage(WebDriver driver){

      PageFactory.initElements(driver,this);
      this.driver=driver;
  }


@FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderBtn;


@FindBy(css = "#name")
    WebElement name;

@FindBy(css = "#country")
    WebElement country;

@FindBy(css = "#city")
    WebElement city;

@FindBy(css = "#card")
    WebElement creditCard;

@FindBy(css = "#month")
    WebElement month;

@FindBy(css = "#year")
    WebElement year;

@FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseBtn;

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement thankYouMessage;

@FindBy(xpath = "//button[.='OK']")
    WebElement OKBtn;



public void clickPlaceOrder(){
    BrowserUtils.click(this.placeOrderBtn,driver);
   }



public void nameAndCountry(String name, String country){
    BrowserUtils.sendKeys(this.name,driver,name);
    BrowserUtils.sendKeys(this.country,driver,country);
}



public void cityAndCreditCard(String city, String creditCard){

    BrowserUtils.sendKeys(this.city,driver,city);
    BrowserUtils.sendKeys(this.creditCard,driver,creditCard);
}


public void monthAndYearAndClickPurchase(String month, String year){
    BrowserUtils.sendKeys(this.month,driver,month);
    BrowserUtils.sendKeys(this.year,driver,year);
    BrowserUtils.click(this.purchaseBtn,driver);

}


public void validateTheMessageAndClickOnOK(String actualMessage){

     BrowserUtils.getText(this.thankYouMessage,driver);
     BrowserUtils.click(this.OKBtn,driver);
    }









}
