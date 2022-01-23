package com.cybertek.tests.pages;


import static com.cybertek.utilities.Driver.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroPage{

    public ZeroPage(){
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement usernameField;


    @FindBy(id = "user_password")
    public WebElement passwordField;

    @FindBy(name = "submit")
    public WebElement loginButton;

    @FindBy(id = "primary-button")
    public WebElement errorbutton;

    @FindBy(xpath = "//*[@id='login_form']/div")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@class='icon-user']")
    public WebElement usernameIcon;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;




}
