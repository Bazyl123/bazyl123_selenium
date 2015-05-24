package com.bananascrum.szkolenia.pageObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Administrator on 2015-02-11.
 */
public class PlanPage extends Page {
    public PlanPage(WebDriver driver) {
        super(driver);
    }

    public void moveItemToTest(String title) {
        WebElement element = getElementWithTextFromElementList(By.id("backlog-items"), title);
        element.findElement(By.xpath("//div[6]/ul/li[1]/div[5]/div[3]/img[3]")).click();
        wait.until(invisibilityOfElementLocated(By.id("flash-ajax")));
    }
}
