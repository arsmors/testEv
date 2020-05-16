package TestDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class HomePage {
    BaseFunc baseFunc;

    public String homePage = "https://www.ss.com/en";
    private final By MAIN = By.xpath("//a[@class=\"am\"]");
    private final By MAIN_MENU = By.xpath("//*[@class=\"menu_main\"]");
    private final By CHECKBOX = By.xpath("//input[@type=\"checkbox\"]");

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

    private WebElement getItems(int id) {
        List<WebElement> items = baseFunc.getElements(MAIN);
        return items.get(id);
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
}
