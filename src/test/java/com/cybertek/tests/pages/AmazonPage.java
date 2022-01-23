package com.cybertek.tests.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement cookiesButton;

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(name = "quantity")
    public WebElement quantityDropDown;


    @FindBy(id = "nav-cart-count-container")
    public WebElement cart;

    @FindBy(xpath = "//*[@id='a-autoid-1-announce']/span[2]")
    public WebElement firstHatQuantity;


    @FindBy(xpath = "//p[@class='a-spacing-mini']/span")
    public WebElement firstHatPrice;

    @FindBy(xpath = "//*[@id='sc-subtotal-amount-activecart']/span")
    public WebElement totalBill;

}
