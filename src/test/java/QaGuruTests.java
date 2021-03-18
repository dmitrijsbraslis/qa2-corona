import model.qaguru.Courses;
import model.qaguru.QaStudent;
import model.qaguru.Registration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BaseFunc;
import pages.qaguru.HomePage;
import pages.qaguru.RegistrationPage;
import pages.qaguru.SuccessPage;

public class QaGuruTests {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final String SUCCESS_TXT = "Paldies! Reģistrācija ir veiksmīga. Tuvākajā laikā mēs sazināsimies ar jums un piedāvāsim detalizēto informāciju par kursu, laiku un norises vietu :)";
    private final String URL = "qaguru.lv/totest/";
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void registrationCheck() {
        LOGGER.info("This test will check registration happy path");

        baseFunc.openURL(URL);

        HomePage homePage = new HomePage(baseFunc);
        RegistrationPage registrationPage = homePage.openRegistrationPage();

        QaStudent student = new QaStudent();
        student.setFirstName("AT_FN");
        student.setLastName("AT_LN");
        student.setEmail("at@at.at");
        student.setPhone("22222222");

        Registration registration = new Registration();
        registration.setStudent(student);
        registration.setDiscount("CODE");
        registration.setComment("COMMENT");
        registration.setCourse(Courses.QA2);

        registrationPage.fillInRegistrationForm(registration);
        registrationPage.submitForm();

        SuccessPage successPage = new SuccessPage(baseFunc);
        Assertions.assertEquals(SUCCESS_TXT, successPage.getSuccessTxt(), "Incorrect success msg!");
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
