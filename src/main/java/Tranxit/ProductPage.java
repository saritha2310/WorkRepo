package Tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Iterator;
import java.util.List;


public class ProductPage extends BasePage{

    public ProductPage(WebDriver browser) {
        super(browser);
    }


    @FindBy(how = How.LINK_TEXT,using = "Books" )
          private WebElement booksText;

    @FindBy(how = How.LINK_TEXT,using = "Pride and Prejudice" )
    private WebElement productsText;

    @FindBy(how = How.TAG_NAME,using = "body" )
    private WebElement bodyText;



    public void gotoCategory(){
        booksText.click();
        }

    public void gotoProduct(){
        productsText.click();
    }

    public boolean showText(String text){
       return bodyText.getText().contains(text);
   }




}

