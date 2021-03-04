import model.Courses;
import model.QaStudent;
import model.Registration;
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
    private final String URL = "qaguru.lv/totest";
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final String SUCCESS_TXT = "Paldies! Reģistrācija ir veiksmīga. Tuvākajā laikā mēs sazināsimies ar jums un piedāvāsim detalizēto informāciju par kursu, laiku un norises vietu :)";
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void registrationCheck() {
        LOGGER.info("This test will check registration happy path");

        baseFunc.openURL(URL);

        HomePage homePage = new HomePage(baseFunc);
        RegistrationPage registrationPage = homePage.openRegistrationPage();

        QaStudent student = new QaStudent();
        student.setFirstName("AT FN");
        student.setLastName("AT LN");
        student.setEmail("ats@ats.lv");
        student.setPhone("22222222");

        Registration registration = new Registration();
        registration.setStudent(student);
        registration.setCode("CODE");
        registration.setComment("Comment here");
        registration.setCourses(Courses.QA2);

        registrationPage.fillInRegistrationForm(registration);
        registrationPage.submitForm();

        SuccessPage successPage = new SuccessPage(baseFunc);
        Assertions.assertEquals(SUCCESS_TXT, successPage.getSuccessMsg(), "Problem with success msg!");
    }

    @AfterEach
    public void close() {
        baseFunc.closeBrowser();
    }
}
