package TestDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    BaseFunc baseFunc = new BaseFunc();
    HomePage homePage = new HomePage(baseFunc);

    @Given("website with category {string}")
    public void websiteWithCategory(String category) {
        homePage.openHomePage(category);
    }

    @When("user open single ad")
    public void userDrilldownIntoAd() {
        homePage.chooseAdFromList(1);
    }

    @And("add to favorites")
    public void addToFavorites() {
        homePage.addToFavorites();
    }

    @Then("ads with count {string} are displayed in memos page")
    public void adsWithCountAreDisplayedInMemosPage(String count) {
        String id = homePage.getMemoId();
        Assert.assertTrue("Test failed", id.contains(count));
    }
}
