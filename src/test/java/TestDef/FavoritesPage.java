package TestDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FavoritesPage {
    BaseFunc baseFunc;

    public FavoritesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By ADDTOFAVORITES = By.xpath("//*[contains(@id, 'a_fav')]");
    private final By ALERTOK = By.xpath("//*[@id=\"alert_ok\"]");
    private final By MEMOID = By.xpath("//span[@id=\"mnu_fav_id\"]");
    private final By MEMOPAGEADS = By.xpath("//td[@class=\"msga2 pp0\"]");

    public String getMemoId() {
        return baseFunc.getElement(MEMOID).getText();
    }

    public void addToFavorites() {
        baseFunc.getElement(ADDTOFAVORITES).click();
        baseFunc.getElement(ALERTOK).click();
    }

    public void checkAllAdsDisplayedOnPage() {
        List<WebElement> listOfElements = baseFunc.getElements(MEMOPAGEADS);
        assertFalse("ads are not added to favorites", listOfElements.isEmpty());
    }

    public void checkMemoToolbarHasCount() {
        List<WebElement> listOfElements = baseFunc.getElements(MEMOPAGEADS);

        int ads = listOfElements.size();
        try {
            int memoToolbarId = Integer.parseInt(getMemoId().replaceAll("[^\\d.]", ""));
            assertEquals("memo toolbar is showing incorrect qty", memoToolbarId, ads);
        } catch (Exception e) {
            throw new NullPointerException("memo toolbar is empty or showing incorrect qty. Please check manually!");
        }
    }
}
