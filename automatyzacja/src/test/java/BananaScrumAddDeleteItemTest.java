import com.sun.org.apache.xpath.internal.XPath;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Administrator on 2015-02-10.
 */
public class BananaScrumAddDeleteItemTest extends SeleniumBase {

    public static final String TITLE = UUID.randomUUID().toString();

    @Test
    public void itemIsAddedDeleted() {

        goToBacklog();
        String elementText = createElementText();

        // add item

        addItemToBacklog(elementText);
        assertNotNull(isItemInBacklog(elementText));

        // delete element
        deleteElementFromBacklog(isItemInBacklog(elementText));
        assertNull(isItemInBacklog(elementText));


    }

    private void goToBacklog() {
        String url = "https://szkolenia.bananascrum.com";
        open(url);
        trylogInAs("admin", "password");
    }


    private String createElementText() {
        String itemID = UUID.randomUUID().toString();
        return "new item PiotrJ" + itemID;
    }

    private void addItemToBacklog(String elementText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add item")));
        click(By.linkText("Add item"));
        wait.until(presenceOfElementLocated(By.name("commit")));
        insertText(By.id("item_user_story"), elementText);
        click(By.name("commit"));
        wait.until(invisibilityOfElementLocated(By.name("commit")));
    }

    private void deleteElementFromBacklog(WebElement element) {
        WebElement trashButton = element.findElement(By.xpath(".//img[@alt=\"Delete this backlog item\"]"));
        trashButton.click();
        driver.switchTo().alert().accept();
        wait.until(invisibilityOfElementLocated(By.id("flash-ajax")));

    }


    private WebElement isItemInBacklog(String elementText) {
        return getElementWithTextFromElementList(By.id("backlog-items"), elementText);
    }


}

// getelement from baclkog to selenium base
// shorten everything by imports