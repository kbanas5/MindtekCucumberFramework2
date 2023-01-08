package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeHRMHomePage {

    public OrangeHRMHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//aside/nav/div[2]/ul/li[2]/a")
    public WebElement PIMbtn;

    @FindBy (xpath = "//aside/nav/div[2]/ul/li[1]/a")
    public WebElement adminBtn;

    @FindBy (xpath = "//form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")
    public WebElement userRole;

    @FindBy (xpath = "//form/div[1]/div/div[3]/div/div[2]/div/div")
    public WebElement status;




}