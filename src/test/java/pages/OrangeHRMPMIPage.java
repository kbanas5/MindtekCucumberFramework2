package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class OrangeHRMPMIPage {

    public OrangeHRMPMIPage() {

        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addBtn;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(css = "span[class='oxd-switch-input oxd-switch-input--active --label-right']")
    public WebElement sliderStatusBtn;

    @FindBy(css = "button[type='submit']")
    public WebElement saveBtn;

    @FindBy(css = "#oxd-toaster_1")
    public WebElement successMessage;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    public WebElement getAddBtn;

    @FindBy(css = "div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.oxd-table-filter:nth-child(1) div.oxd-table-filter-area form.oxd-form div.oxd-form-row div.oxd-grid-4.orangehrm-full-width-grid div.oxd-grid-item.oxd-grid-item--gutters:nth-child(6) div.oxd-input-group.oxd-input-field-bottom-space div:nth-child(2) div.oxd-select-wrapper div.oxd-select-text.oxd-select-text--active > div.oxd-select-text-input")
    public WebElement jobTitleDropdown;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement employeeNameInput;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 --strong']")
    public WebElement newEmployeeNameProfile;

    @FindBy(xpath = "(//input)[8]")
    public WebElement dlNumberBox;

    @FindBy(xpath = "(//input[@placeholder='yyyy-mm-dd'])[1]")
    public WebElement expiryDateBox;

    @FindBy(xpath = "(//input)[10]")
    public WebElement ssnNumber;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    public WebElement nationalityDropdown;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement maritalStatusDropdown;

    @FindBy(xpath = "(//input[@placeholder='yyyy-mm-dd'])[2]")
    public WebElement dateOfBirthBox;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/label[1]/span[1]")
    public WebElement maleRadioBtn;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement save2Btn;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
    public WebElement arrowDownNationalityDropdown;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
    public WebElement arrowDownMaritalDropdown;

    @FindBy(xpath = "//div[@class='oxd-select-option']")
    public List<WebElement> listOfNationalitiesDropdown;

    @FindBy(xpath = "//div[@class='oxd-select-option']")
    public List<WebElement> listOfMaritalStatusDropdown;

    @FindBy (xpath = "//aside/nav/div[2]/ul/li[1]/a")
    public WebElement adminBtn;



}