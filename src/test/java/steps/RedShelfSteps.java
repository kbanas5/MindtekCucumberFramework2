package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.RedShelfHomePage;
import pages.RedShelfSearchResultsPage;
import utilities.Driver;

import java.util.List;


public class RedShelfSteps {

    WebDriver driver = Driver.getDriver();
    RedShelfHomePage redShelfHomePage = new RedShelfHomePage();
    RedShelfSearchResultsPage searchResults = new RedShelfSearchResultsPage();

    @When("user searches {string} with space in the beginning and at the end")
    public void userSearchesWithSpaceInTheBeginningAndAtTheEnd(String topic) {
        redShelfHomePage.searchBox.sendKeys(Keys.BACK_SPACE);
        redShelfHomePage.searchBox.sendKeys(topic);
        redShelfHomePage.searchBtn.click();


    }

    @Then("user validates search message {string}")
    public void userValidatesSearchMessage(String searchMessage) {
        String actualMessage = redShelfHomePage.searchResultMessage.getText();
        Assert.assertEquals(searchMessage, actualMessage);

    }

    @When("user searches {string} author")
    public void user_searches_author(String author) {
        redShelfHomePage.searchBox.sendKeys(Keys.BACK_SPACE);
        redShelfHomePage.searchBox.sendKeys(author);
        redShelfHomePage.searchBtn.click();
    }

    @Then("user validates all books having author {string}")
    public void userValidatesAllBooksHavingAuthor(String author) {
        List<WebElement> authors = searchResults.listOfAuthorsSearchSethGodin;

        for (WebElement opt : authors) {
            System.out.println(opt.getText());
            if (opt.getText().equals(author)) {
                System.out.println("List contains books of that author.");
            } else {
                System.out.println("List doesn't contain books of that author.");
            }

        }
    /* if(list.contains(author)) {
         System.out.println("List contains books of that author.");
     }else{
         System.out.println("List doesn't contain books of that author.");
*/

      /*  Map<WebElement, Integer> mapAuthors = new HashMap<>();
        for (WebElement webElement : authors) {
            if (!mapAuthors.containsKey(webElement)) {
                mapAuthors.put(webElement, 1);
            } else {
                mapAuthors.put(webElement, mapAuthors.get(webElement) + 1);
            }
        }
        System.out.println(mapAuthors);
*/
    }
    @When("user searches {string} book")
    public void user_searches_book(String bookTitle) {
        redShelfHomePage.searchBox.sendKeys(Keys.BACK_SPACE);
        redShelfHomePage.searchBox.sendKeys(bookTitle);
        redShelfHomePage.searchBtn.click();
    }

    @When("user chooses first {string} book in search results and ads it to the cart")
    public void user_chooses_first_book_in_search_results_and_ads_it_to_the_cart(String bookTitle) {
        searchResults.purpleCowBookLink.click();
        searchResults.addToCartBtn.click();
    }

    @Then("user validates the book {string} is in the cart")
    public void user_validates_the_book_is_in_the_cart(String bookTitle) {
       searchResults.cartBtn.click();
       Assert.assertTrue(searchResults.purpleCowBookLink.isDisplayed());

    }

    @When("user searches for {string} book")
    public void userSearchesForBook(String bookTitle) {
    }

    @Then("user validates first result page having no more than {int} books.")
    public void userValidatesFirstResultPageHavingNoMoreThanBooks(int arg0) {
    }
}







