import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.HomePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApolloTests {
    private final String URL = "apollo.lv";

    @Test
    public void commercialCloseTest() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

        HashMap<String, Integer> articles = homePage.getAllArticles();

        for (Map.Entry<String, Integer> article : articles.entrySet()) {
            System.out.println(article.getKey() + " :: " + article.getValue());
        }

//        List<WebElement> titles = homePage.getTitles();
//        List<WebElement> comments = homePage.getComments();

//        for (int i = 0; i < titles.size(); i++) {
//            if (comments.size() > i) {
//                System.out.println(titles.get(i).getText() + " :: " + comments.get(i).getText());
//            } else {
//                System.out.println(titles.get(i).getText() + " :: -------");
//            }
//        }

//        homePage.openArticleById(0);
//
//        ArticlePage articlePage = new ArticlePage(baseFunc);
//        System.out.println(articlePage.getTitle());
//        articlePage.waitForAds();
//
//        articlePage.openCommentsPage();
    }
}
