package com.lsy.trackspace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Pita on 5/23/2015.
 */
public class LoginPage extends Page {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void open() {
        driver.get("https://google.com");
    }
}
