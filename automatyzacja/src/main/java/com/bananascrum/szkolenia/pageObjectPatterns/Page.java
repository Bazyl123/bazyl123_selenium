package com.bananascrum.szkolenia.pageObjectPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Administrator on 2015-02-11.
 */
public abstract class Page {

    public static WebDriver  driver;
    WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }


    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    public void insertText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected SprintPage goToSprintPage() {
        driver.findElement(By.xpath("//div[3]/ul/li[4]/a/div")).click();
        wait.until(presenceOfElementLocated(By.xpath("//div[5]/div[3]/ul/li[2]/a")));
        return new SprintPage(driver);
    }

    protected WebElement getElementWithTextFromElementList(By by, String itemText) {
        WebElement element = driver.findElement(by);
        List<WebElement> elements = element.findElements(By.tagName("li"));
        for (WebElement webElement : elements) {
            if (webElement.getText().contains(itemText)) {
                return webElement;
            }
        }
        return null;
    }
}
