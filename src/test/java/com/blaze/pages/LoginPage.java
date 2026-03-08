package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {

 private WebDriver driver;


 public LoginPage(WebDriver driver){

     PageFactory.initElements(driver,this);
     this.driver=driver;
 }



 @FindBy(xpath = "//a[@id='login2']")
    WebElement login;



 @FindBy(css = "input[id='loginusername']")
    WebElement userName;


 @FindBy(css = "#loginpassword")
    WebElement password;

 @FindBy(xpath = "//button[.='Log in']")
    WebElement loginBtn;

 @FindBy(xpath = "//button[.='Log in']/preceding-sibling::button")
 WebElement closeBtn;


public void OpenLoginModal(){

    BrowserUtils.click(this.login,driver);
}


 public void loginFunctionality(String userName, String password){

     BrowserUtils.sendKeys(this.userName,driver,userName);
     BrowserUtils.sendKeys(this.password,driver,password);
     BrowserUtils.click(this.loginBtn,driver);
 }


 public void clickOnCloseBtn(){
    BrowserUtils.click(this.closeBtn,driver);
 }












}
