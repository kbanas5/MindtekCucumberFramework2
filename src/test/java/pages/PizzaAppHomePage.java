package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PizzaAppHomePage {

    public PizzaAppHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "pizza1Pizza")
    public WebElement pizza1Dropdown;

    @FindBy(css = ".toppings1)")
    public WebElement toppings1Dropdown;

    @FindBy(css = ".toppings2)")
    public WebElement toppings2Dropdown;

    @FindBy(css = "#pizza1Qty")
    public WebElement pizzaQuantityBox;

    @FindBy(id = "pizza1Cost")
    public WebElement pizzaCostBox;

    @FindBy(css = "#name")
    public WebElement nameInput;

    @FindBy(css = "#email")
    public WebElement emailInput;

    @FindBy(css = "#phone")
    public WebElement phoneInput;

    @FindBy(css = "#ccpayment")
    public WebElement creditCardRadioBtn;

    @FindBy(css = "#cashpayment")
    public WebElement cashPaymentRadioBtn;

    @FindBy(css = "#placeOrder")
    public WebElement placeOrderBtn;

    @FindBy(css = "#reset")
    public WebElement resetBtn;

    @FindBy(xpath = "//p")
    public WebElement successMessage;

    @FindBy(id = "dialog")
    public WebElement dialogWindow;

}
