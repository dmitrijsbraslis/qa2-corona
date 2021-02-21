package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        driver.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
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
        LOGGER.info("Getting text of element by locator: " + locator);
        return findElement(locator).getText();
    }

    public String getText(By locator, int id) {
        LOGGER.info("Getting text of element Nr. " + id + " by locator: " + locator);
        List<WebElement> elements = findElements(locator);

        Assertions.assertFalse(elements.isEmpty(), "Element list is empty");
        Assertions.assertTrue(elements.size() > id, "There are less than " + id + 1 + " elements");
        return elements.get(id).getText();
    }

    public WebElement findElement(By locator) {
        LOGGER.info("Trying to find element by locator: " + locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
