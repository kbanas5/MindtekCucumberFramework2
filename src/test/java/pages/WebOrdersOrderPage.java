package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebOrdersOrderPage {

    public WebOrdersOrderPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    public WebElement unitPriceInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement discountInput;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement totalInput;

    @FindBy(css = "input[type='submit']")
    public WebElement calculateBtn;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetAddressInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityAddressInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipcodeAddressInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNrInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expDateInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processBtn;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaCheckBox;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/input[1]")
    public WebElement resetBtn;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBox;

    @FindBy(xpath = "//strong[contains(text(),'New order has been successfully added.')]")
    public WebElement successMessage;
}
