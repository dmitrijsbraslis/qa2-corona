import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstFullTest {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");

    private final Logger LOGGER = LogManager.getLogger(FirstFullTest.class);

    @Test
    public void titleAndCommentsCheck() {
        LOGGER.info("This test is checking titles and comments on TVNET page");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("We are opening browser window");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Going to TVNET Home Page");
        driver.get("http://tvnet.lv");

        LOGGER.info("Taking 3rd article");
        WebElement currentArticle = driver.findElements(ARTICLE).get(0);

        LOGGER.info("Finding and store article title");
        String titleToCompare = currentArticle.findElement(TITLE).getText();

        //Find and store comments count
        int commentsCount = 0;

        if (!currentArticle.findElements(COMMENT_COUNT).isEmpty()) {
            WebElement element = currentArticle.findElement(COMMENT_COUNT);
            String stringToParse = element.getText(); // -> (36)
            stringToParse = stringToParse.substring(1, stringToParse.length() - 1); // (36) -> 36
            commentsCount = Integer.parseInt(stringToParse);
        }
//      ---------------------------OR-----------------------------------------------------------------
//        if (currentArticle.findElements(COMMENT_COUNT).isEmpty()) {
//            //true - no elements
//            int commentsCount = 0;
//        } else {
//            //false - there is at least one element in list
//            WebElement element = currentArticle.findElement(COMMENT_COUNT);
//            String stringToParse = element.getText(); // -> (36)
//            stringToParse = stringToParse.substring(1, stringToParse.length() - 1); // (36) -> 36
//            int commentsCount = Integer.parseInt(stringToParse);
//        }
//       _____________________________________________________________________________________________

//        if (statement) {
//            statement -> true
//        } else {
//            statement -> false
//        }

//        !true = false
//        !false = true

        //Open 3rd article
        currentArticle.findElement(TITLE).click();

        //Find and check title
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
//        Assertions.assertEquals(titleToCompare, articlePageTitle, "Wrong title on article page");
        Assertions.assertTrue(titleToCompare.startsWith(articlePageTitle), "Wrong title on article page");


        //Find and check comments count

        //Open comments page

        //Find and check title

        //Find and check comments count
    }
}
