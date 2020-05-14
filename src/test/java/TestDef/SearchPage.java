package TestDef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchPage {
    BaseFunc baseFunc;

    private final By SEARCH_BOX = By.xpath("//input[@type=\"text\"]");

    public SearchPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void enterSearchDetails(String search) {
        baseFunc.getElement(SEARCH_BOX).click();
        baseFunc.getElement(SEARCH_BOX).sendKeys(search);
        baseFunc.getElement(SEARCH_BOX).sendKeys(Keys.RETURN);
    }
}
