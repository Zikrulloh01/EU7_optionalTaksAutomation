package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.cybertek.utilities.Configurations_Reader.*;
public class Driver {

    private Driver(){}

    private static WebDriver driver;


    public static WebDriver getDriver(){

        if (driver == null){
            String browser = getKey("browser");
            if (browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            else if (browser.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            else if (browser.equalsIgnoreCase("safari")){
                if (!System.getProperty("os.name").contains("mac")){
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    throw new WebDriverException("Your OS does not support Safari");
                }
            }
        }
        return driver;
    }


    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }

}
