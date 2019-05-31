package Tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{


        public HomePage(WebDriver browser) {
            super(browser);
        }


    @FindBy(how = How.LINK_TEXT, using = "Log in")
    private WebElement LoginLinkText;

    @FindBy(how = How.LINK_TEXT, using = "Log out")
    private WebElement LogOutText;


    public void goToLoginPage() {
        LoginLinkText.click();
    }

    public void logout(){
        LogOutText.click();
    }
}
