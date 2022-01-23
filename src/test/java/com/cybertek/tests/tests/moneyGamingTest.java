package com.cybertek.tests.tests;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.cybertek.utilities.Configurations_Reader.*;



public class moneyGamingTest extends TestBase {


    @Test
    public void test1(){
        driver.get(getKey("moneyUrl"));
        driver.findElement(By.cssSelector(".newUser.green")).click();
        WebElement title = driver.findElement(By.name("map(title)"));
        Select select = new Select(title);
        select.selectByValue("Mr");
        driver.findElement(By.id("forename")).sendKeys("Zikrillo");
        driver.findElement(By.name("map(lastName)")).sendKeys("Islomov");
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.id("form")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='error'])[1]")).isDisplayed());

    }


}
