package com.cybertek.tests.tests;

import com.cybertek.tests.TestBase;
import com.cybertek.tests.pages.AmazonPage;
import com.cybertek.utilities.Configurations_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001 extends TestBase {
    AmazonPage amazonPage = new AmazonPage();
    @Test
    public void test1() throws InterruptedException {
        driver.get(Configurations_Reader.getKey("url"));
        amazonPage.cookiesButton.click();
        amazonPage.searchBox.sendKeys("hats for men");
        amazonPage.searchButton.click();
        driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();
        Select select = new Select(amazonPage.quantityDropDown);
        select.selectByValue("2");
        amazonPage.addToCartButton.click();
        amazonPage.cart.click();

        int quantity = Integer.parseInt(amazonPage.firstHatQuantity.getText());
        String itemPrice = amazonPage.firstHatPrice.getText();
        double priceItem = Double.parseDouble(itemPrice.substring(1));
        double expectedBill = quantity * priceItem;
        double actualPrice = Double.parseDouble(amazonPage.totalBill.getText().substring(1));

        Assert.assertEquals(actualPrice,expectedBill);
        System.out.println(actualPrice);

    }

}
