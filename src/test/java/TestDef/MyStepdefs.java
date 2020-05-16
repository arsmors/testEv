package TestDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    BaseFunc baseFunc = new BaseFunc();
    HomePage homePage = new HomePage(baseFunc);
    SearchPage searchPage = new SearchPage(baseFunc);
    FavoritesPage favoritesPage = new FavoritesPage(baseFunc);

    @Given("website with category {string}")
    public void websiteWithCategory(String category) {
        homePage.openHomePage(category);
    }

    @When("user open single ad")
    public void userDrilldownIntoAd() {
        homePage.chooseRandomAdFromList();
    }

    @And("add to favorites")
    public void addToFavorites() {
        favoritesPage.addToFavorites();
    }

    @Then("ads are displayed on page")
    public void adsAreDisplayedOnPage() {
        homePage.selectMenuItem("Memo");
        favoritesPage.checkAllAdsDisplayedOnPage();
    }

    @Then("ads count on page is similar to memo count on toolbar")
    public void adsCountOnPageIsSimilarToMemoCountOnToolbar() throws InterruptedException {
        homePage.selectMenuItem("Memo");
        favoritesPage.checkMemoToolbarHasCount();
        baseFunc.closePage();
    }

    @When("user select {int} ads")
    public void userSelectAds(int ads) {
        homePage.chooseMultipleAdsFromList(ads);
    }

    @When("user go to {string} section")
    public void userGoToSection(String item) {
        homePage.openHomePage("");
        homePage.selectMenuItem(item);
    }

    @And("search for {string} item")
    public void searchForItem(String item) {
        searchPage.enterSearchDetails(item);
    }
}
