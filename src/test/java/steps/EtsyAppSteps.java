package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchResultsPage;
import pages.EtsyAppTittlePages;
import utilities.Driver;
import java.util.List;
import java.util.Locale;

public class EtsyAppSteps {

    WebDriver driver = Driver.getDriver();//driver here in case you need to get Title or something
    EtsyAppHomePage etsyAppHomePage = new EtsyAppHomePage();
    EtsyAppSearchResultsPage etsyAppSearchResultsPage = new EtsyAppSearchResultsPage();
    EtsyAppTittlePages etsyTitlePages = new EtsyAppTittlePages();

    @When("user searches for {string}")
    public void user_searches_for(String item) {
        etsyAppHomePage.searchBox.sendKeys(item + Keys.ENTER);

    }

    @Then("user validates search results items name contains keyword {string}")
    public void user_validates_search_results_items_contains_keyword(String keyword) {

        List<WebElement> myItemsList = etsyAppSearchResultsPage.listOfItemsTitles;

            for (WebElement element : myItemsList) {
                String title = element.getText();
                if (title.contains(keyword)) continue;
                Assert.assertFalse(
                        "Element «" + title + "» does not contain keyword: " + keyword,
                        title.contains(keyword));

        }

    }

    @And("user applies price filter {string} dollars")
    public void userAppliesFilterOverDollars(String filterRange) {
        EtsyAppSearchResultsPage etsyAppSearchResultsPage = new EtsyAppSearchResultsPage();
        etsyAppSearchResultsPage.allFiltersBtn.click();
        switch (filterRange) {
            case "over 1500":
                etsyAppSearchResultsPage.over1500RadioBtn.click();
                break;
            case "under 250":
                etsyAppSearchResultsPage.FilterUnder250RadioBtn.click();
                break;
            case "250 to 750":
                etsyAppSearchResultsPage.filterRange250to750RadioBtn.click();
                break;
            case "500 to 1000":
                etsyAppSearchResultsPage.filterRange500to1000RadioBtn.click();
                break;
        }
        etsyAppSearchResultsPage.applyBtn.click();
    }

    @Then("user validates that item prices are {string} dollars")
    public void userValidatesThatItemPricesAreOverDollars(String filterRange) throws InterruptedException {

        if (filterRange.equals("over 1500")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

            for (WebElement element : prices) {
                System.out.println(element.getText());
                String priceStr = element.getText().replace(",", "");
                double actualPriceDouble = Double.parseDouble(priceStr);
                System.out.println(actualPriceDouble);
                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                double expectedPriceDbl = Double.parseDouble(expectedPrice);
                Assert.assertTrue(actualPriceDouble >= expectedPriceDbl);
            }
        } else if (filterRange.equals("under 250")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

            for (WebElement element : prices) {
                System.out.println(element.getText());
                String priceStr = element.getText().replace(",", "");
                double actualPriceDouble = Double.parseDouble(priceStr);
                System.out.println(actualPriceDouble);
                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                double expectedPriceDbl = Double.parseDouble(expectedPrice);
                Assert.assertTrue(actualPriceDouble <= expectedPriceDbl);
            }
        }else if (filterRange.equals("250 to 750")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

            for (WebElement element : prices) {
                System.out.println(element.getText());
                String priceStr = element.getText().replace(",", "");
                double actualPriceDouble = Double.parseDouble(priceStr);
                System.out.println(actualPriceDouble);
                String expectedPrice1 = filterRange.substring(0,filterRange.indexOf(" "));
                double expectedPriceDbl1 = Double.parseDouble(expectedPrice1);
                String expectedPrice2 = filterRange.substring(filterRange.lastIndexOf(" ")+1);
                double expectedPriceDbl2 = Double.parseDouble(expectedPrice2);

                Assert.assertTrue(actualPriceDouble >= expectedPriceDbl1 && actualPriceDouble <= expectedPriceDbl2);
        }
        }else if(filterRange.equals("500 to 1000")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

            for (WebElement element : prices) {
                System.out.println(element.getText());
                String priceStr = element.getText().replace(",", "");
                double actualPriceDouble = Double.parseDouble(priceStr);
                System.out.println(actualPriceDouble);
                String expectedPrice1 = filterRange.substring(0,filterRange.indexOf(" "));
                double expectedPriceDbl1 = Double.parseDouble(expectedPrice1);
                String expectedPrice2 = filterRange.substring(filterRange.lastIndexOf(" ")+1); //for examples table
                double expectedPriceDbl2 = Double.parseDouble(expectedPrice2);

                Assert.assertTrue(actualPriceDouble >= expectedPriceDbl1 && actualPriceDouble <= expectedPriceDbl2);
        }
        }
    }
    @When("user clicks on {string} section")
    public void user_clicks_on_section(String section) {
        switch (section) {
            case "Jewelry & Accessories":
                etsyAppHomePage.jewelryAndAccessories.click();
                break;
            case "Clothing & Shoes":
                etsyAppHomePage.clothingAndShoes.click();
                break;
            case "Home & Living":
                etsyAppHomePage.homeAndLiving.click();
                break;
            case "Wedding & Party":
                etsyAppHomePage.weddingAndParty.click();
                break;
            case "Toys & Entertainment":
                etsyAppHomePage.toysAndEnt.click();
                break;
            case "Art & Collectibles":
                etsyAppHomePage.artAndColl.click();
                break;
            case "Craft Supplies":
                etsyAppHomePage.craftAndSupp.click();
                break;
            case "Gifts & Gift Cards":
                etsyAppHomePage.giftsAndCards.click();
                break;
        }
    }

    @Then("user validates the title is {string} and the header is {string}")
    public void user_validates_the_title_is_and_the_header_is(String title, String header) {
    String actualHeader = "";
    String actualTitle = "";

        switch (header) {
            case "Jewelry & Accessories":
                actualHeader = etsyTitlePages.jaHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Clothing & Shoes":
                actualHeader = etsyTitlePages.csHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Home & Living":
                actualHeader = etsyTitlePages.hlHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Wedding & Party":
                actualHeader = etsyTitlePages.wpHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Toys & Entertainment":
                actualHeader = etsyTitlePages.teHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Art & Collectibles":
                actualHeader = etsyTitlePages.acHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Craft Supplies & Tools":
                actualHeader = etsyTitlePages.cstHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "The Etsy Gift Guide":
                actualHeader = etsyTitlePages.ggHeader.getText();
                actualTitle = driver.getTitle();
                break;
        }

        Assert.assertEquals(title,actualTitle);
        Assert.assertEquals(header,actualHeader);

    }




}
