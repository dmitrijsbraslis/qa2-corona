package pages.qaguru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.BaseFunc;

public class SuccessPage {
    private final By SUCCESS_BLOCK = By.xpath(".//div[@class = 'successTxt']");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public SuccessPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        LOGGER.info("We are on success registration page");
    }

    public String getSuccessMsg() {
        LOGGER.info("Getting success message");
        return baseFunc.getText(SUCCESS_BLOCK);
    }
}
