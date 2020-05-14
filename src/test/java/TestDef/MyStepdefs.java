package TestDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MyStepdefs {
    BaseFunc baseFunc = new BaseFunc();
    HomePage homePage = new HomePage(baseFunc);

    private final By MEMOPAGEADS = By.xpath("//td[@class=\"msga2 pp0\"]");

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
        homePage.addToFavorites();
    }

    @Then("ads are displayed on page")
    public void adsAreDisplayedOnPage() {
        homePage.openHomePage("/favorites/");
        List<WebElement> listOfElements = baseFunc.getElements(MEMOPAGEADS);
        assertFalse("ads are not added to favorites", listOfElements.isEmpty());
    }

    @Then("ads count on page is similar to memo count on toolbar")
    public void adsCountOnPageIsSimilarToMemoCountOnToolbar() throws InterruptedException {
       homePage.openHomePage("/favorites/");
       List<WebElement> listOfElements = baseFunc.getElements(MEMOPAGEADS);

       int ads = listOfElements.size();
       try {
           int memoToolbarId = Integer.parseInt(homePage.getMemoId().replaceAll("[^\\d.]", ""));
           assertEquals("memo toolbar is showing incorrect qty", memoToolbarId, ads);
       } catch (Exception e) {
           throw new NullPointerException("memo toolbar is empty or showing incorrect qty");
       }

       baseFunc.closePage();
    }


    @When("user select {int} ads")
    public void userSelectAds(int ads) {
        homePage.chooseMultipleAdsFromList(ads);

    }

}
