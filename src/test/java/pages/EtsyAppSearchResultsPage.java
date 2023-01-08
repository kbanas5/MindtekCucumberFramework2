package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppSearchResultsPage {

    public EtsyAppSearchResultsPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div/ol/li/div/div/a/div[2]/h3")
    public List<WebElement> listOfItemsTitles;

    @FindBy(css = "span[class='wt-hide-xs wt-show-md filter-expander']")
    public WebElement allFiltersBtn;

    @FindBy(xpath = "//label[contains(text(),'Over $1,500')]")
    public WebElement over1500RadioBtn;

    @FindBy(xpath = "//label[contains(text(),'Under $250')]")
    public WebElement FilterUnder250RadioBtn;

    @FindBy(xpath = "//label[contains(text(),'$250 to $750')]")
    public WebElement filterRange250to750RadioBtn;

    @FindBy(xpath = "//label[contains(text(),'$500 to $1,000')]")
    public WebElement filterRange500to1000RadioBtn;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    public WebElement applyBtn;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//p[1]//span[@class='currency-value']")
    public List<WebElement> listOfItemsPrices;


    @FindBy(xpath = "//label[contains(text(),'Under $100')]")
    public WebElement chairUnder100Radio;

    @FindBy(xpath = "//label[contains(text(),'$50 to $500')]")
    public WebElement carpet50to500Radio;

    @FindBy(xpath = "//label[contains(text(),'$500 to $1,000')]")
    public WebElement table500to1000Radio;
}
