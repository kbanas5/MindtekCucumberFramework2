package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RedShelfSearchResultsPage {

    public RedShelfSearchResultsPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "//div[@class='product-search-result-author']")
    public List<WebElement> listOfAuthorsSearchSethGodin;

    @FindBy(id = "ember67")
    public WebElement purpleCowBookLink;

    @FindBy(xpath = "//span[@class='mdc-button__ripple']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//a[@aria-label='Shopping Cart']//*[name()='svg']")
    public WebElement cartBtn;

    @FindBy(xpath = "//a[normalize-space()='Purple Cow, New Edition']")
    public WebElement PurpleCowBookInTheCart;
}
