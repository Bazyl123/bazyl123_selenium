package com.lsy.trackspace;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Pita on 5/24/2015.
 */
public class SeleniumBase {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpAll() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDownAll() {
        driver.quit();
    }
}
