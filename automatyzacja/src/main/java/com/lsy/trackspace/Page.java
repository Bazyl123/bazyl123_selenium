package com.lsy.trackspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.image.ByteLookupTable;
import java.util.List;

/**
 * Created by Pita on 5/23/2015.
 */
public abstract class Page {
    public static WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    public void insertText(By locator, String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected WebElement getElementFromElementList(By locator, String elementText){
        WebElement element = driver.findElement(locator);
        List<WebElement> elements = element.findElements(By.tagName("li"));
        for (WebElement webElement : elements){
            if (webElement.getText().contains(elementText)){
                return webElement;
            }
        }
        return null;
    }
}
