package pages.qaguru;

import model.qaguru.Registration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.BaseFunc;

public class RegistrationPage {
    private final By FIRST_NAME = By.id("firstName");
    private final By LAST_NAME = By.id("lastName");
    private final By EMAIL = By.id("email");
    private final By PHONE = By.id("phone");
    private final By COURSE = By.id("course");
    private final By DISCOUNT = By.id("discount");
    private final By COMMENT = By.id("comment");
    private final By DATA_PROC = By.id("dataProc");
    private final By REGISTER_BTN = By.xpath(".//input[@type = 'submit']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public RegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        LOGGER.info("We are on Registration Page");
    }

    public void fillInRegistrationForm(Registration reg) {
        LOGGER.info("Filling registration form");

        baseFunc.type(FIRST_NAME, reg.getStudent().getFirstName());
        baseFunc.type(LAST_NAME, reg.getStudent().getLastName());
        baseFunc.type(EMAIL, reg.getStudent().getEmail());
        baseFunc.type(PHONE, reg.getStudent().getPhone());
        baseFunc.select(COURSE, reg.getCourse().toString());
        baseFunc.type(DISCOUNT, reg.getDiscount());
        baseFunc.type(COMMENT, reg.getComment());
        baseFunc.click(DATA_PROC);
    }

    public void submitForm() {
        LOGGER.info("Submitting registration form");
        baseFunc.click(REGISTER_BTN);
    }
}
