package com.cybertek.tests.tests;

import com.cybertek.tests.TestBase;
import static com.cybertek.utilities.Configurations_Reader.*;
import static com.cybertek.utilities.Driver.*;

import com.cybertek.tests.pages.ZeroPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroBankTests extends TestBase {

    ZeroPage zeroPage = new ZeroPage();

    @Test(priority = 1)
    public void loginValidDetails(){
        String expectedPage = "Account Summary";
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
        login(getKey("invalidUsername"), getKey("password"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");


    }

    @Test(priority = 3)
    public void logInInvalidPassword(){
        String expectedTitle = "Zero - Log in";
        login(getKey("username"), getKey("invalidPassword"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }

    @Test(priority = 4)
    public void blankUsernameLogin(){
        String expectedTitle = "Zero - Log in";
        login(getKey("blankUsername"), getKey("password"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }

    @Test(priority = 5)
    public void blankPasswordLogin(){
        String expectedTitle = "Zero - Log in";
        login(getKey("username"), getKey("blankPassword"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }
    @Test(priority = 6)
    public void invalidUsernamePasswordLogin(){
        String expectedTitle = "Zero - Log in";
        login(getKey("invalidUsername"), getKey("invalidPassword"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }

    @Test(priority = 7)
    public void blankUsernamePasswordLogin(){
        String expectedTitle = "Zero - Log in";
        login(getKey("blankUsername"), getKey("blankPassword"));
        Assert.assertTrue(zeroPage.errorMessage.isDisplayed());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title did not match");

    }




    @Test(priority = 8)
    public void accountSummaryColumnsTest(){
        List<String> expectedList = new ArrayList<String>(Arrays.asList("Cash Accounts", "Investment Accounts", "Credit Accounts", "Loan Accounts"));
        goToAccountSummaryPage();
        List<WebElement> elements = getDriver().findElements(By.tagName("h2"));
        for (int i = 0; i < elements.size(); i ++ ) {
            Assert.assertEquals(elements.get(i).getText(), expectedList.get(i), i + " element did not match");
        }

    }


    @Test
    public void creditAccountsTest(){
        List<String> expectedList = new ArrayList<>(Arrays.asList("Account", "Credit Card", "Balance"));
        goToAccountSummaryPage();

        List<WebElement> elements = driver.findElements(By.xpath("(//*[@class='table'])[3]//th"));

        for (int i = 0; i < elements.size(); i ++ ) {
            Assert.assertEquals(elements.get(i).getText(), expectedList.get(i), i + " element did not match");
            System.out.println(elements.get(i).getText());
        }

    }



    public void login(String username, String password){
        getDriver().get(getKey("zeroUrl"));
        zeroPage.signInButton.click();
        zeroPage.usernameField.sendKeys(username);
        zeroPage.passwordField.sendKeys(password);
        zeroPage.loginButton.click();
    }

    public void logout(){
        zeroPage.usernameIcon.click();
        zeroPage.logoutLink.click();
    }

    public void goToAccountSummaryPage(){
        login(getKey("username"), getKey("password"));
        zeroPage.errorbutton.click();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("account_summary_link")).click();
    }



}
