package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ArticlePage {
    private BaseFunc baseFunc;

    private final By TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        return baseFunc.getText(TITLE);
    }
}
