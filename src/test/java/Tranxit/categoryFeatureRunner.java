package Tranxit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@reg")

public class categoryFeatureRunner {

    static WebDriver browser;

    @BeforeClass
    public static void beforeClassMethod(){
        System.out.println("openBrowser");
        browser = BrowserFactory.getBrowser();
        browser.manage().window().maximize();
    }

    @AfterClass
    public static void closeTheBrowser() {
        browser.close();
    }
}


