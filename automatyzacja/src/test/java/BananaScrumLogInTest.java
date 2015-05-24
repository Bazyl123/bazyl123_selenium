//package com.example.tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class BananaScrumLogInTest extends SeleniumBase {

    @Test
    @Parameters({"admin, xxxxx",
            "xxxxx, password",
            " , ",
            "admin, ",
            " , password",
            "xxxxxx, xxxxxxx"})
    public void itIsImpossibleToLogInWithIncorrectCredentials(String userName, String password) {
        //when
        trylogInAs(userName, password);
        //then
        waitForElementWithText(By.id("flash"), "Login failed");
        assertElementPresent(By.name("commit"));
    }


    @Test
    public void itIsPossibleToLogIn() {
        //when
        trylogInAs("admin", "password");
        //then
        assertElementPresent(By.linkText("Logout"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("flash")));
        click(By.linkText("Logout"));

    }
}
