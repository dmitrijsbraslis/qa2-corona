package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class HomePage {
    private final By ACCEPT_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By ARTICLE = By.tagName("article");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final By CLOSE_ADS_BTN = By.xpath(".//div[contains(@style, 'z-index: 6100')]");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        if (baseFunc.isElementPresents(CLOSE_ADS_BTN)) {
            baseFunc.click(CLOSE_ADS_BTN);
        }
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_BTN);
    }

    public void openArticleById(int id) {
        WebElement titleToClick = baseFunc.findElements(TITLE).get(id);
        baseFunc.click(titleToClick);
    }

    public List<WebElement> getTitles() {
        return baseFunc.findElements(TITLE);
    }

    public List<WebElement> getComments() {
        return baseFunc.findElements(COMMENT_COUNT);
    }

    public HashMap<String, Integer> getAllArticles() {
        List<WebElement> articles = baseFunc.findElements(ARTICLE);

        HashMap<String, Integer> allArticles = new HashMap<String, Integer>();

        for (WebElement we : articles) {
            if(we.findElement(TITLE).getText().length() != 0) {

                String title = we.findElement(TITLE).getText();
                Integer commentCount;

                if (we.findElements(COMMENT_COUNT).isEmpty()) {
                    commentCount = 0;
                } else {
                    String commentsToParse = we.findElement(COMMENT_COUNT).getText();
                    commentCount = Integer.parseInt(commentsToParse.substring(1, commentsToParse.length() - 1));
                }

                allArticles.put(title, commentCount);
            }
        }

        return allArticles;
    }
}
