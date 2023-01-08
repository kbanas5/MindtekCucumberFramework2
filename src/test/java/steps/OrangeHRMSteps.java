package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.OrangeHRMAdminPage;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMLoginPage;
import pages.OrangeHRMPMIPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class OrangeHRMSteps {
     WebDriver driver = Driver.getDriver();
     OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
     OrangeHRMHomePage homePage = new OrangeHRMHomePage();
     OrangeHRMPMIPage orangeHRMPMIPage = new OrangeHRMPMIPage();
     OrangeHRMAdminPage orangeHRMAdminPage = new OrangeHRMAdminPage();

     @Given("Admin navigates to Orange HRM with userName {string} and password {string}")
     public void admin_navigates_to_orange_hrm_with_user_name_and_password(String userName, String password) {
          WebDriver driver = Driver.getDriver();
          driver.get(ConfigReader.getProperty("OrangeHrmURL"));
          loginPage.usernameInput.sendKeys(userName);
          loginPage.passwordInput.sendKeys(password);
          loginPage.loginBtn.click();

     }

     @When("Admin  clicks PIM button and creates new user with {string} and {string} and clicks the save button")
     public void admin_clicks_PIM_button_and_creates_new_user_with_and(String firstName, String lastName) throws InterruptedException {
          homePage.PIMbtn.click();
          orangeHRMPMIPage.addBtn.click();
          orangeHRMPMIPage.firstName.sendKeys(firstName);
          orangeHRMPMIPage.lastName.sendKeys(lastName);
          Thread.sleep(2000);
          orangeHRMPMIPage.saveBtn.click();
     }

     @And("Admin proceeds with additional new user information and clicks the save button")
     public void adminProceedsWithAdditionalNewUserInformationAndClicksTheSaveButton(DataTable dataTable) throws InterruptedException {
         Thread.sleep(5000);
          Map<String,String> data = dataTable.asMap(String.class,String.class);
          for(String value : data.values()) {
               System.out.println(value);
          }
       orangeHRMPMIPage.dlNumberBox.sendKeys(data.get("DL number"));
       orangeHRMPMIPage.expiryDateBox.sendKeys(data.get("Expiry date"));
       orangeHRMPMIPage.ssnNumber.sendKeys(data.get("SSN number"));
       /*  for(WebElement opt : orangeHRMPMIPage.listOfNationalitiesDropdown){
             if(data.get("Nationality").equals(opt.getText()));
             opt.click();
         }*/

        /* orangeHRMPMIPage.arrowDownMaritalDropdown.click();
         Thread.sleep(2000);
         for(WebElement opt : orangeHRMPMIPage.listOfMaritalStatusDropdown){
             if("Married".equals(opt.getText()));
             opt.click();
         }*/
       orangeHRMPMIPage.dateOfBirthBox.sendKeys(data.get("Date of Birth"));
         JavascriptExecutor jse = ((JavascriptExecutor) driver);
         jse.executeScript("window.scrollBy(0,100)");
       orangeHRMPMIPage.maleRadioBtn.click();
       orangeHRMPMIPage.save2Btn.click();

     }
     @Then("Admin validates new user {string} {string} is added")
     public void admin_validates_new_user_is_added(String firstName, String lastName,DataTable dataTable) throws InterruptedException {
         Map<String,String> data = dataTable.asMap(String.class,String.class);
     orangeHRMPMIPage.adminBtn.click();
     orangeHRMPMIPage.addBtn.click();
     orangeHRMAdminPage.employeeNameBox.sendKeys(firstName +" "+ lastName);
     orangeHRMAdminPage.employeeNameBox.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
     orangeHRMAdminPage.usernameBox.sendKeys(data.get("Username"));
     orangeHRMAdminPage.passwordBox.sendKeys(data.get("Password"));
     orangeHRMAdminPage.confirmPassBox.sendKeys(data.get("Confirm Password"));
     orangeHRMAdminPage.saveBtn.click();

         List<WebElement> employeesData = orangeHRMAdminPage.employeesInfoList;
         int count = 0;
         for(WebElement opt : employeesData){
             count++;
             Assert.assertEquals("Pierre Muller", opt.getText());
         }


     }

    @When("Admin navigates to PIM module and chooses edit option for user of his choice and edits information")
    public void adminNavigatesToPIMModuleAndChoosesEditOptionForUserOfHisChoiceAndEditsInformation() {
        
    }

    @Then("Admin validates the changes with the message {string}")
    public void adminValidatesTheChangesWithTheMessage(String arg0) {
    }
}


