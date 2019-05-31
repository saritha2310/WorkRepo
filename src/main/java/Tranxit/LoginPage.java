package Tranxit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
        public LoginPage(WebDriver browser) {
            super(browser);
        }

        @FindBy(how = How.ID,using = "Email")
        private WebElement emailId;

    @FindBy(how = How.ID,using = "Password")
    private WebElement passwordText;

    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")
    private WebElement Submit;

    @FindBy(how = How.TAG_NAME,using = "body")
    private WebElement bodyText;



    public void login(String Username, String Password){
        emailId.sendKeys(Username);
        passwordText.sendKeys(Password);
        Submit.click(); }

        public boolean isuserLogged(){
            return bodyText.getText().contains("Welcome to our store");

        }


    }



