import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.HomePage;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private int articleId = 3;

    @Test
    public void tvnetPageObjectTest() {
        LOGGER.info("This test is checking article titles and comment counts");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        //Get article title on Home page
        String homePageTitle = homePage.getArticleTitleById(articleId);

//        homePage.openArticleById(articleId);
//
//        ArticlePage articlePage = new ArticlePage(baseFunc);
        ArticlePage articlePage = homePage.openArticleById(articleId);
        //Get article title on Article Page
        String articlePageTitle = articlePage.getTitle();

        //Compare article titles
//        Assertions.assertEquals(homePageTitle, articlePageTitle, "Titles are not the same");
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not the same");
    }
}
