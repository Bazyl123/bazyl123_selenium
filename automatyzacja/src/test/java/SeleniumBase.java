import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2015-02-10.
 */
public class SeleniumBase {
    protected static WebDriverWait wait;
    public static WebDriver driver;
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void setUpAll() {
        driver = new FirefoxDriver();
        baseUrl = "https://szkolenia.bananascrum.com";
        wait = new WebDriverWait(driver, 10);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        open(baseUrl);
    }

    public void waitForElementWithText(By by, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    protected void trylogInAs(String login, String password) {
        insertText(By.id("login"), login);
        insertText(By.id("password"), password);
        click(By.name("commit"));
    }

    protected void assertElementPresent(By locator) {
        assertTrue(isElementPresent(locator));
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    public void insertText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void open(String url) {
        driver.get(url);
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    protected WebElement getElementWithTextFromElementList(By by, String itemText) {
        WebElement element =  driver.findElement(by);
        List<WebElement> elements = element.findElements(By.tagName("li"));
        for (WebElement webElement:elements) {
            if (webElement.getText().contains(itemText)) {
                return webElement;
            }
        }return null;
    }
}
