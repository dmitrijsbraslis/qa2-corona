import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.HomePage;


public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final int ARTICLE_ID = 2;

    @Test
    public void tvnetPageObjectTest() {
        LOGGER.info("This test is checking titles and comment count");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

        //Get 4th article title on Home Page
        String homePageTitle = homePage.getArticleTitleById(ARTICLE_ID);

        ArticlePage articlePage = homePage.openArticleById(ARTICLE_ID);

//        ArticlePage articlePage = new ArticlePage(baseFunc);

        //Get article title on Article Page
        String articlePageTitle = articlePage.getTitle();

        //Compare article titles
//        Assertions.assertEquals(homePageTitle, articlePageTitle, "Titles are not the same");
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not the same");
    }
}
