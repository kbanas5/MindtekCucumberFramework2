package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import io.cucumber.datatable.DataTable;
import java.util.Map;

public class PizzaAppSteps {

    String costValue;
    WebDriver driver = Driver.getDriver();
    PizzaAppHomePage pizzaAppHomePage = new PizzaAppHomePage();

    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) throws InterruptedException {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        Map<String,String> data = dataTable.asMap(String.class,String.class);
        for(String value : data.values()){
            System.out.println(value);
        }
        BrowserUtils.selectDropdownByValue(pizzaAppHomePage.pizza1Dropdown,data.get("Pizza"));//selecting value from Pizza dropdown
        Thread.sleep(2000);
        BrowserUtils.selectDropdownByValue(pizzaAppHomePage.toppings1Dropdown,data.get("Topping1"));
        Thread.sleep(2000);
        BrowserUtils.selectDropdownByValue(pizzaAppHomePage.toppings2Dropdown,data.get("Topping2"));
        pizzaAppHomePage.pizzaQuantityBox.clear();
        pizzaAppHomePage.pizzaQuantityBox.sendKeys(data.get("Quantity"));
        pizzaAppHomePage.nameInput.sendKeys(data.get("Name"));
        pizzaAppHomePage.nameInput.sendKeys(data.get("Email"));
        pizzaAppHomePage.nameInput.sendKeys(data.get("Phone"));
        costValue = pizzaAppHomePage.pizzaCostBox.getAttribute("value");
        if(data.get("Payment").equals("Cash on Pickup")) {
            pizzaAppHomePage.cashPaymentRadioBtn.click();
        }else {
            pizzaAppHomePage.creditCardRadioBtn.click();
        }
        pizzaAppHomePage.placeOrderBtn.click();
    }

    @Then("user validates that order is created with message {string} {string} {string}")
    public void user_validates_that_order_is_created_with_message(String successMessage,String quantity, String pizza) {
    String expectedMessage = successMessage + costValue + " " + pizza;
    String actualMessage = pizzaAppHomePage.dialogWindow.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
