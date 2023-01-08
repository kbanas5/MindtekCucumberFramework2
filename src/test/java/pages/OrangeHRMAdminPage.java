package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OrangeHRMAdminPage {

    public OrangeHRMAdminPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active oxd-select-text--error']")
    public WebElement userRoleDropdown;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[1]")
    public WebElement usernameBox;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    public WebElement passwordBox;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement confirmPassBox;

    @FindBy(xpath = "//div[contains(text(),'Pierre Muller')]")
    public WebElement employeeName;

    @FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell']")
    public List<WebElement> employeesInfoList;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveBtn;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameBox;

}
