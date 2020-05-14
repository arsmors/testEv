package TestDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage {
    BaseFunc baseFunc;
    private final By MAIN = By.xpath("//a[@class=\"am\"]");
    private final By MAIN_MENU = By.xpath("//*[@class=\"menu_main\"]");
    private final By CHECKBOX = By.xpath("//input[@type=\"checkbox\"]");
    public String homePage = "https://www.ss.com/en";
    private final By ADDTOFAVORITES = By.xpath("//*[contains(@id, 'a_fav')]");
    private final By ADDTOFAVORITES_FROM_LIST = By.xpath("//a[@id=\"a_fav_sel\"]");
    private final By ALERTOK = By.xpath("//*[@id=\"alert_ok\"]");
    private final By MEMOID = By.xpath("//span[@id=\"mnu_fav_id\"]");
    private final By MEMOPAGEADS = By.xpath("//td[@class=\"msga2 pp0\"]");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openHomePage(String category) {
        baseFunc.openPage(homePage + category);
    }

    public void chooseRandomAdFromList() {
        Random num = new Random();
        int id = num.nextInt(10);
        getItems(id).click();
    }

    public void chooseMultipleAdsFromList(int ads) {
        List<WebElement> items = baseFunc.getElements(CHECKBOX);
        for (int i = 0; i < ads; i++) {
            items.get(i).click();
        }
    }

    //        for (int i = 0; i < ads; i++) {
//            for (WebElement item : items) {
//                item.click();
//            }


    private WebElement getItems(int id) {
        List<WebElement> items = baseFunc.getElements(MAIN);
        return items.get(id);
    }

    private WebElement selectCheckbox(int id) {
        List<WebElement> items = baseFunc.getElements(CHECKBOX);
        return items.get(id);
    }

    public void addToFavorites() {
        baseFunc.getElement(ADDTOFAVORITES).click();
        baseFunc.getElement(ALERTOK).click();
    }

    public String getMemoId() {
        return baseFunc.getElement(MEMOID).getText();
    }

    public void selectMenuItem(String item) {
        List<WebElement> menuItems = baseFunc.getElements(MAIN_MENU);
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(item)) {
                menuItems.get(i).click();
                break;
            }
        }
    }

//    private WebElement getAds(int id) {
//        List<WebElement> items = baseFunc.getElements(MEMOPAGEADS);
//        return items.get(id);
//    }

}
