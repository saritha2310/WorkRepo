package Tranxit;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {

        static WebDriver browser;
        HomePage homePage;
        LoginPage loginPage;
        ProductPage productPage;

    @Before
    public void userOpenedBrowser() {
        WebDriverManager.chromedriver().setup();
        //browser = new ChromeDriver();
        browser = BrowserFactory.getBrowser();
        browser.get("http://demo.nopcommerce.com");
        browser.manage().timeouts().implicitlyWait(240,TimeUnit.SECONDS);
    }

    @Then("^he should see the welcome message$")
    public void heShouldSeeTheWelcomeMessage()
    {

        Assert.assertTrue(browser.findElement(By.tagName("body")).getText().contains("Welcome to our store"));

    }

    @After
    public void heShouldCloseTheBrowser() {
        browser.close();
    }


    @Given("^User opened home page$")
    public void userOpenedHomePage() {
        browser.get("https://demo.nopcommerce.com");
    }


    @And("^entered login page$")
    public void enteredLoginPage() {
        homePage = new HomePage(browser);
        homePage.goToLoginPage();

    }



//
//    @And("^try to login$")
//    public void tryToLogin() {
//        browser.findElement(By.xpath
//                ("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")).click();
//
//    }

    @Then("^he should successfully login$")
    public void heShouldSuccessfullyLogin() {
        Assert.assertTrue(loginPage.isuserLogged());
    }

    @And("^he should logout$")
    public void heShouldLogout() {
        homePage.logout();
    }

    @When("^he enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void heEntersUsernameAsAndPasswordAs(String arg0, String arg1) throws Throwable {
        loginPage = new LoginPage(browser);

    loginPage.login(arg0,arg1);}

    @Given("^User is in home page$")
    public void userIsInHomePage() {browser.get("https://demo.nopcommerce.com");

    }

    @And("^is in login page$")
    public void isInLoginPage() { browser.findElement(By.linkText("Log in")).click();

    }

    @Then("^he should not be successfully login$")
    public void heShouldNotBeSuccessfullyLogin() {  Assert.assertFalse(loginPage.isuserLogged());

    }

    @When("^he go to home page$")
    public void heGoToHomePage() {
        browser.get("https://demo.nopcommerce.com");

    }


    @When("^user opens the footer link page \"([^\"]*)\"$")
    public void userOpensTheFooterLinkPage(String text) throws Throwable {
        browser.findElement(By.linkText(text)).click();
    }

    @Then("^the page should be open with text \"([^\"]*)\"$")
    public void thePageShouldBeOpenWithText(String text) throws Throwable {

        Assert.assertTrue(productPage.showText(text));
    }
//
//    @When("^user opens the product category page \"([^\"]*)\"$")
//    public void userOpensTheProductCategoryPage(WebElement arg0) throws Throwable {
//        productPage = new ProductPage(browser);
//        productPage.gotoCategory(arg0);
//
//    }


//    @When("^user opens a product type \"([^\"]*)\"$")
//    public void userOpensAProductType(String arg0) throws Throwable {
//        productPage.gotoProduct();
//
//    }





    @And("^the image should display$")
    public void theImageShouldDisplay() {

    }

    @And("^the price should display$")
    public void thePriceShouldDisplay() {
        String textinBrowser = browser.findElement(By.tagName("body")).getText();
        Assert.assertTrue(textinBrowser.contains("Price"));


    }

    @And("^the review link should display$")
    public void theReviewLinkShouldDisplay() {

    }

    @And("^the product should be able to add to cart$")
    public void theProductShouldBeAbleToAddToCart() {
       browser.findElement(By.className("button-2")).click();}

//    @Then("^the success message should display$")
//    public void theSuccessMessageShouldDisplay() {
//        browser.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
//        String textinBrowser = browser.findElement(By.tagName("body")).getText();
//        Assert.assertTrue(textinBrowser.contains("The product has been added to your "));
//
//    }

    @And("^user opens actual product \"([^\"]*)\"$")
    public void userOpensActualProduct(String arg0) throws Throwable {
        browser.findElement(By.cssSelector(arg0)).click();
    }


//    @After
//    public void afterTest(Scenario scenario){
//        if(scenario.isFailed()) {
//            scenario.embed(((TakesScreenshot) browser).getScreenshotAs(OutputType.BYTES), "image/png");
//        }
//    }

    @Given("^user opens the product category page$")
    public void userOpensTheProductCategoryPage() {
        productPage = new ProductPage(browser);
        productPage.gotoCategory();
    }

    @When("^user opens a product$")
    public void userOpensAProduct() {
        productPage.gotoProduct();
    }
}





