package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        LOGGER.info("Setting up driver path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();

        LOGGER.info("Maximizing window");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    public void openURL(String url) {
        LOGGER.info("Opening " + url + " web page");

        // !true -> false
        // !false -> true
        // || -> OR (либо)      && -> AND (и)
        if(!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

//        if(url.startsWith("http://") || url.startsWith("https://")) {
//
//        } else {
//            url = "http://" + url;
//        }

        driver.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).click();
    }

    public void click(WebElement we) {
        wait.until(ExpectedConditions.elementToBeClickable(we));
        we.click();
    }

    public List<WebElement> findElements(By locator) {
        LOGGER.info("Getting all elements by: " + locator);
        return driver.findElements(locator);
    }

    public String getText(By locator) {
        LOGGER.info("Getting text for element by locator: " + locator);
        //Get element -> Get text of this element
        return findElement(locator).getText();
    }

    public String getText(By locator, int id) {
        LOGGER.info("Getting text of element Nr. " + (id + 1) + " by locator " + locator);
        List<WebElement> elements = findElements(locator);

        Assertions.assertFalse(elements.isEmpty(), "Elements list is empty");
        Assertions.assertTrue(elements.size() > id, "There are less than " + (id + 1) + " elements");

        return elements.get(id).getText();
    }

    public WebElement findElement(By locator) {
        LOGGER.info("Trying to find element by locator: " + locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void type(By locator, String text) {
        WebElement inputField = findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void select(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public void closeBrowser() {
        driver.close();
    }
}
