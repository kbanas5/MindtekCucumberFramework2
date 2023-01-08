package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RedShelfHomePage {

    public RedShelfHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "search-catalog-home")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn home-search-btn']")
    public WebElement searchBtn;

    @FindBy(xpath = "//h1[contains(text(),'Search results for')]")
    public WebElement searchResultMessage;
}
