package com.bananascrum.szkolenia.pageObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Administrator on 2015-02-11.
 */
public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        //driver.get("https://szkolenia.bananascrum.com/session/new");
        driver.get("https://google.com");
    }

    public void LogIn(String userName, String password) {
        trylogInAs(userName, password);
        wait.until(invisibilityOfElementLocated(By.id("flash")));
    }


    public BacklogPage logInCorrectly(String userName, String password) {
        trylogInAs(userName, password);
        BacklogPage bp = new BacklogPage(driver);
        return bp;
    }

    private void trylogInAs(String login, String password) {
        insertText(By.id("login"), login);
        insertText(By.id("password"), password);
        click(By.name("commit"));
    }


}


