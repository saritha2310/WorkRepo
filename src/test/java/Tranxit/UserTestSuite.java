package Tranxit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTestSuite {

    static WebDriver browser;

    @BeforeClass
    public static void openBrowser() {
        System.out.println("openBrowser");
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.manage().window().maximize();

    }

    public static void waitForSomeTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterClass
    public static void closeBrowser() {
        System.out.println("closeBrowser");
        browser.close();
    }


    @Before
    public void login() {
        System.out.println("login");

        //open url
        browser.get("https://schedule.tranxit.co/login");
        //id email

        WebElement usernameTextBox = browser.findElement(By.id("email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("demo@demo.com");

        WebElement passwordTextBox = browser.findElement(By.id("password"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("123456");

        WebElement loginButton = browser.findElement(By.className("log-teal-btn"));
        loginButton.click();
        browser.findElement(By.className("demoModeDialogclose")).click();


    }

    @After
    public void logout() {
        System.out.println("logout");
        browser.manage().deleteAllCookies();
        browser.get("https://schedule.tranxit.co/logout");
    }

    @Test
    public void testUpdateProfile() {

        System.out.println("testUpdateProfile");


        WebElement profileLink = browser.findElement(By.linkText("Profile"));
        profileLink.click();


        WebElement popupBox = browser.findElement(By.className("demoModeDialogclose"));
        if (popupBox.isDisplayed()) {
            browser.findElement(By.className("demoModeDialogclose")).click(); }


        WebElement widget = browser.findElement(By.cssSelector("#widget-global-pz2l8h56pag > " +
                "div > div > div > div > div.lc-1dmysac.e1ohfhv0 > div.lc-12t0z3s.e1ohfhv1"));
        if (widget.isDisplayed()) {
            browser.switchTo().parentFrame(); }

        WebElement editProfileButton = browser.findElement(By.className("form-sub-btn"));
        editProfileButton.click();

        WebElement lastNameTextBox = browser.findElement(By.name("last_name"));
        lastNameTextBox.clear();
        lastNameTextBox.sendKeys("newLastName");
        WebElement saveButton = browser.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div[7]/button"));
        saveButton.click();

        WebElement messageBox = browser.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]"));
        String actualMessage = messageBox.getText();
        UserTestSuite.waitForSomeTime();
        Assert.assertTrue(actualMessage.contains("Profile Updated"));

    }

    @Test
    public void addMoney() {

        System.out.println("addmoney");


        WebElement walletLink = browser.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/ul/li[8]/a"));
        walletLink.click();



        WebElement popupBox = browser.findElement(By.className("demoModeDialogclose"));
        if (popupBox.isDisplayed()) {
            browser.findElement(By.className("demoModeDialogclose")).click();
        }

        WebElement widget = browser.findElement(By.cssSelector("#widget-global-pz2l8h56pag > " +
                "div > div > div > div > div.lc-1dmysac.e1ohfhv0 > div.lc-12t0z3s.e1ohfhv1"));
        if (widget.isDisplayed()) {
            browser.switchTo().parentFrame(); }



        WebElement amountTextBox = browser.findElement(By.xpath("//*[@id=\"add_money\"]/div[2]/div/input"));

        amountTextBox.sendKeys("10");
        WebElement addMoneyButton = browser.findElement(By.xpath("//*[@id=\"submit-button\"]"));
        addMoneyButton.click();

        WebElement displayBox = browser.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]"));
        String msg = displayBox.getText();
        System.out.println(msg);


        Assert.assertTrue(msg.contains("added to your wallet"));

    }
}







