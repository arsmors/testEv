package TestDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage {
    BaseFunc baseFunc;
    private final By MAIN = By.xpath("//a[@class=\"am\"]");
    public String homePage = "https://www.ss.com/en";
    private final By ADDTOFAVORITES = By.xpath("//a[@title=\"Add to favorites\"]");
    private final By ALERTOK = By.xpath("//*[@id=\"alert_ok\"]");
    private final By MEMOID = By.xpath("//span[@id=\"mnu_fav_id\"]");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openHomePage(String category) {
        baseFunc.openPage(homePage + category);
    }

    public void chooseAdFromList(int id) {
        getItems(id).click();
    }

    private WebElement getItems(int id) {
        List<WebElement> items = baseFunc.getElements(MAIN);
        return items.get(id);
    }

    public void addToFavorites() {
        baseFunc.getElement(ADDTOFAVORITES).click();
        baseFunc.getElement(ALERTOK).click();
    }

    public String getMemoId() {
        return baseFunc.getElement(MEMOID).getText();
    }

    public int randomNumber() {
        Random num = new Random();
        int n = num.nextInt(10);
        return n;
    }


}
