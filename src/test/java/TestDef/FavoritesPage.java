package TestDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavoritesPage {
    BaseFunc baseFunc;

    public FavoritesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By ADDTOFAVORITES = By.xpath("//*[contains(@id, 'a_fav')]");
    private final By ALERTOK = By.xpath("//*[@id=\"alert_ok\"]");
    private final By MEMOID = By.xpath("//span[@id=\"mnu_fav_id\"]");

    public String getMemoId() {
        return baseFunc.getElement(MEMOID).getText();
    }

    public void addToFavorites() {
        baseFunc.getElement(ADDTOFAVORITES).click();
        baseFunc.getElement(ALERTOK).click();
    }
}
