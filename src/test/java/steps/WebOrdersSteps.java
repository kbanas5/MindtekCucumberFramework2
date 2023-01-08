package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class WebOrdersSteps {

    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage = new WebOrdersHomePage();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();

    @When("user enters username {string} and password {string} and clicks on login button")
    public void user_enters_username_and_password_test_and_clicks_on_login_button(String username, String password) throws InterruptedException {
        driver.get(ConfigReader.getProperty("WebOrdersURL"));
        webOrdersLoginPage.username.sendKeys(username);
        Thread.sleep(2000);
        webOrdersLoginPage.password.sendKeys(password);
        Thread.sleep(2000);
        webOrdersLoginPage.loginBtn.click();

    }
    @Then("user validates application is logged in")
    public void user_validates_application_is_logged_in() {
    String expectedTitle = "Web Orders";
    String actualTitle = driver.getTitle();
    //System.out.println(actualTitle);
    Assert.assertEquals(expectedTitle,actualTitle);
    }


    @Then("user validates an error message {string}")
    public void userValidatesAnErrorMessage(String errorMessage) {
        String actualErrorMessage = webOrdersLoginPage.errorMessage.getText();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(errorMessage,actualErrorMessage);
    }
    @When("user clicks on Order module")
    public void user_clicks_on_order_module() {
        webOrdersHomePage.orderModule.click();
    }

    @When("user selects {string} with {int}")
    public void user_selects_with_quantity(String product, int quantity) {
        BrowserUtils.selectDropdownByValue(webOrdersOrderPage.productDropdown,product);
        webOrdersOrderPage.quantityInput.sendKeys(Keys.CONTROL+"A");
        webOrdersOrderPage.quantityInput.sendKeys(Keys.BACK_SPACE);
        webOrdersOrderPage.quantityInput.sendKeys(quantity+""+Keys.ENTER);



    }
    @Then("user validates total is calculated properly for {int}")
    public void user_validates_total_is_calculated_properly_for_quantity(int quantity) {
        int expectedTotal = 0;
        String pricePerUnit = webOrdersOrderPage.unitPriceInput.getAttribute("value");
        String discountAmount = webOrdersOrderPage.discountInput.getAttribute("value");
         // if my quantity less than 10 = no discount, discount = 0

        int pricePerUnitInt = Integer.parseInt(pricePerUnit);
        int discountAmountInt = Integer.parseInt(discountAmount);

        if(discountAmountInt==0){
            expectedTotal = quantity * pricePerUnitInt;
        }else{
            expectedTotal = quantity * pricePerUnitInt;
            expectedTotal = expectedTotal - expectedTotal * discountAmountInt/100;
        }
        String actualTotal = webOrdersOrderPage.totalInput.getAttribute("value");
        int actualTotalInt = Integer.parseInt(actualTotal);

        Assert.assertEquals(expectedTotal,actualTotalInt);

    }
    @When("user creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>.

       /* List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        System.out.println(data.get(0).get("zipcode"));
        System.out.println(data.toString());*/

        Map<String,String> data = dataTable.asMap(String.class,String.class);
        System.out.println(data.toString());
        BrowserUtils.selectDropdownByValue(webOrdersOrderPage.productDropdown,data.get("product"));
        webOrdersOrderPage.quantityInput.sendKeys(data.get("quantity"));
        webOrdersOrderPage.customerNameInput.sendKeys(data.get("name"));
        webOrdersOrderPage.streetAddressInput.sendKeys(data.get("street"));
        webOrdersOrderPage.cityAddressInput.sendKeys(data.get("city"));
        webOrdersOrderPage.stateBox.sendKeys(data.get("state"));
        webOrdersOrderPage.zipcodeAddressInput.sendKeys(data.get("zip"));
        webOrdersOrderPage.visaCheckBox.click();
        webOrdersOrderPage.cardNrInput.sendKeys(data.get("cc"));
        webOrdersOrderPage.expDateInput.sendKeys(data.get("expire date"));
        webOrdersOrderPage.processBtn.click();

    }

    @Then("user validates success message {string}")
    public void user_validates_success_message(String expectedMessage) throws InterruptedException {
        Thread.sleep(3000);
     String actualMessage = webOrdersOrderPage.successMessage.getText();
     Assert.assertEquals(expectedMessage,actualMessage);
    }



}
