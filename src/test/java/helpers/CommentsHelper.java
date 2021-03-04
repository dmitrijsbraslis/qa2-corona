package helpers;

import org.openqa.selenium.WebElement;

public class CommentsHelper {
    public int getCommentsCount(WebElement we) {
        String textToParse = we.getText(); //->(66)
        String commentsCount = textToParse.substring(1, textToParse.length() - 1); //->66 (String)
        return Integer.parseInt(commentsCount);
    }
}
