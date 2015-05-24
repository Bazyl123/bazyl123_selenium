package com.bananascrum.szkolenia.pageObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.List;


/**
 * Created by Administrator on 2015-02-11.
 */
public class BacklogPage extends Page {

    private String myUrl;
    public BacklogPage(WebDriver driver) {
        super(driver);
        myUrl = "https://szkolenia.bananascrum.com/projects/luty-2015/items";

    }

    public void addBackLogItem(String title) {
        wait.until(presenceOfElementLocated(By.linkText("Add item")));
        click(By.linkText("Add item"));
        wait.until(presenceOfElementLocated(By.id("item_user_story")));
        insertText(By.id("item_user_story"), title);
        click(By.name("commit"));
    }

    public boolean isItemInBacklog(String title) {
        wait.until(invisibilityOfElementLocated(By.name("commit")));
        if (getElementWithTextFromElementList(By.id("backlog-items"), title) == null) {
            return false;
        }
        return true;

    }

    public void removeBackLogItem(String title) {
        WebElement element = getElementWithTextFromElementList(By.id("backlog-items"), title);
        WebElement trashButton = element.findElement(By.xpath(".//img[@alt=\"Delete this backlog item\"]"));
        trashButton.click();
        driver.switchTo().alert().accept();
        wait.until(invisibilityOfElementLocated(By.id("flash-container")));
       }

    public boolean isOpen() {
        if(presenceOfElementLocated(By.linkText("Logout")) == null) {
             return false;
        }return true;
    }


}

