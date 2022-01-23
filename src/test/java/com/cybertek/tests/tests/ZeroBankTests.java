package com.cybertek.tests.tests;

import com.cybertek.tests.TestBase;
import static com.cybertek.utilities.Configurations_Reader.*;
import static com.cybertek.utilities.Driver.*;

import com.cybertek.tests.pages.ZeroPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZeroBankTests extends TestBase {

    ZeroPage zeroPage = new ZeroPage();

    @Test(priority = 1)
    public void loginValidDetails(){
        String expectedPage = "Account Summary";
        getDriver().get(getKey("zeroUrl"));
        zeroPage.signInButton.click();
        login(getKey("username"), getKey("password"));
        zeroPage.errorbutton.click();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("account_summary_link")).click();

        Assert.assertTrue(driver.getTitle().contains(expectedPage));

        logout();
    }

    @Test(priority = 2)
    public void logInInvalidUsername(){
        String expectedTitle = "Zero - Log in";
        getDriver().get(getKey("zeroUrl"));
        zeroPage.signInButton.click();
        login(getKey("invalidUsername"), getKey("password"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");


    }

    @Test(priority = 3)
    public void logInInvalidPassword(){
        String expectedTitle = "Zero - Log in";
        getDriver().get(getKey("zeroUrl"));
        zeroPage.signInButton.click();
        login(getKey("username"), getKey("invalidPassword"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }

    @Test(priority = 4)
    public void blankUsernameLogin(){
        String expectedTitle = "Zero - Log in";
        getDriver().get(getKey("zeroUrl"));
        zeroPage.signInButton.click();
        login(getKey("blankUsername"), getKey("password"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }

    @Test(priority = 5)
    public void blankPasswordLogin(){
        String expectedTitle = "Zero - Log in";
        getDriver().get(getKey("zeroUrl"));
        zeroPage.signInButton.click();
        login(getKey("username"), getKey("blankPassword"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }
    @Test(priority = 6)
    public void invalidUsernamePasswordLogin(){
        String expectedTitle = "Zero - Log in";
        getDriver().get(getKey("zeroUrl"));
        zeroPage.signInButton.click();
        login(getKey("invalidUsername"), getKey("invalidPassword"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }

    @Test(priority = 7)
    public void blankUsernamePasswordLogin(){
        String expectedTitle = "Zero - Log in";
        getDriver().get(getKey("zeroUrl"));
        zeroPage.signInButton.click();
        login(getKey("blankUsername"), getKey("blankPassword"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }


    public void login(String username, String password){
        zeroPage.usernameField.sendKeys(username);
        zeroPage.passwordField.sendKeys(password);
        zeroPage.loginButton.click();
    }

    public void logout(){
        zeroPage.usernameIcon.click();
        zeroPage.logoutLink.click();
    }



}
