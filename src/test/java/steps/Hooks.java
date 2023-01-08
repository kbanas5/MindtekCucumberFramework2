package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.sk.Tak;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver = Driver.getDriver();

    @Given("user navigates to {string} application")
    public void user_navigates_to_web_order_application(String webApp) {
        switch (webApp) {
            case "WebOrders":
                driver.get(ConfigReader.getProperty("WebOrdersURL"));
                break;
            case "Etsy":
                driver.get(ConfigReader.getProperty("EtsyAppURL"));
                break;
            case "PizzaApp":
                driver.get(ConfigReader.getProperty("PizzaAppURL"));
                break;
            case "RedShelfApp":
                driver.get(ConfigReader.getProperty("RedShelfURL"));
                break;
        }
    }
    @Before
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        System.out.println("Method runs before scenario.");
    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","testFailure");
        }
        driver.quit();
        System.out.println("Method runs after scenario.");
    }
}
