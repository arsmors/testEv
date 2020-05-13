package TestDef;

import TestDef.BaseFunc;
import TestDef.HomePage;
import io.cucumber.java.en.Given;

public class MyStepdefs {
    BaseFunc baseFunc = new BaseFunc();
    HomePage homePage = new HomePage(baseFunc);

    @Given("website with category {string}")
    public void websiteWithCategory(String category) {
        homePage.openHomePage(category);
    }
}
