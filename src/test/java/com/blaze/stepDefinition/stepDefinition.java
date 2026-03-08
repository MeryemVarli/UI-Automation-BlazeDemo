package com.blaze.stepDefinition;

import com.blaze.pages.CartPage;
import com.blaze.pages.LoginPage;
import com.blaze.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class stepDefinition {

WebDriver driver = DriverHelper.getDriver();
LoginPage loginPage = new LoginPage(driver);
MainPage mainPage = new MainPage(driver);
CartPage cartPage = new CartPage(driver);


    @Given("user is on the product store home page")
    public void user_is_on_the_product_store_home_page() {
        driver.get(ConfigReader.readProperty("blazeUrl"));
        System.out.println("Navigated to: " + driver.getCurrentUrl());
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.OpenLoginModal();

    }
    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        String userName = ConfigReader.readProperty("username");
        String password = ConfigReader.readProperty("password");

        loginPage.loginFunctionality(userName,password);

    }
    @Then("user select the laptops category then select product mac pro")
    public void user_select_the_laptops_category_then_select_product_mac_pro() {
        mainPage.selectCategoryAndProduct();
    }

    @Then("user adds the product to cart and click on Cart")
    public void user_adds_the_product_to_cart_and_click_on_cart() {
      mainPage.addProductToCart();
    }

    @Then("user click on place order")
    public void user_click_on_place_order() {
        cartPage.clickPlaceOrder();
    }

    @Then("user enters name as {string} and country as {string}")
    public void user_enters_name_as_and_country_as(String name, String country) {
        cartPage.nameAndCountry(name, country);

    }

    @Then("user enters city {string} and credi card as {string}")
    public void user_enters_city_and_credi_card_as(String city, String creditCard) {
        cartPage.cityAndCreditCard(city, creditCard);
    }

    @Then("user enters month as {string} and year as {string} and the click on purchase")
    public void user_enters_month_as_and_year_as_and_the_click_on_purchase(String month, String year) {
       cartPage.monthAndYearAndClickPurchase(month,year);
    }

    @Then("user should see the success message {string}")
    public void user_should_see_the_success_message(String actualMessage) {

        cartPage.validateTheMessageAndClickOnOK(actualMessage);
    }





    @When("user opens login modal")
    public void user_opens_login_modal() {
        loginPage.OpenLoginModal();

    }
    @When("user logs in with invalid credentials as {string} and {string}")
    public void user_logs_in_with_invalid_credentials_as_and(String userName, String password) {

        loginPage.loginFunctionality(userName,password);


    }
    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String expectedMessage) {
      String actualMessage=  BrowserUtils.getTextFromAlert(driver);
      Assert.assertEquals("failed to validate the error message",expectedMessage,actualMessage);

      BrowserUtils.acceptJSAlert(driver);
      loginPage.clickOnCloseBtn();
    }






























}
