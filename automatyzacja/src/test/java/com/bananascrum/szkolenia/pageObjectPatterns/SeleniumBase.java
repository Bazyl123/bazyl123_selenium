package com.bananascrum.szkolenia.pageObjectPatterns;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2015-02-11.
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
