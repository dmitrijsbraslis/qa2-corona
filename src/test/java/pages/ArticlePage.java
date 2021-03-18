package pages;

import org.openqa.selenium.By;

public class ArticlePage {
    private BaseFunc baseFunc;
    private final By TITLE = By.tagName("h1");
    private final By ADS_IFRAME = By.xpath(".//iframe[contains(@style, 'z-index: 62389')]");
    private final By COMMENTS_ICO = By.xpath(".//a[contains(@class, 'item--comments')]");

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        return baseFunc.getText(TITLE);
    }

    public void openCommentsPage() {
        baseFunc.waitForElementToBeVisible(COMMENTS_ICO);
        baseFunc.click(COMMENTS_ICO);
    }

    public void waitForAds() {
        baseFunc.waitForElementDisappears(ADS_IFRAME);
    }
}
