package com.bananascrum.szkolenia.pageObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Administrator on 2015-02-11.
 */
public class SprintPage extends Page {
    public SprintPage(WebDriver driver) {
        super(driver);
    }

    public PlanPage goToPlanPage() {
        driver.findElement(By.xpath("//html/body/div/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[5]/div[3]/ul/li[2]/a")).click();
        wait.until(presenceOfElementLocated(By.xpath("//div[3]/div[5]/form/a")));
        return new PlanPage(driver);
    }

    public boolean isItemInTest(String title) {
        if (getElementWithTextFromElementList(By.id("sprint-backlog-items"), title) == null) {
            return false;
        }
        return true;
    }
}
