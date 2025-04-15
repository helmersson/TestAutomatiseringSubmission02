package StepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import utils.TestBrowsers;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static String browserName = "chrome";

    @Before
    public void setUp(Scenario scenario) {
        if (browserName != null) {
            WebDriver driver = TestBrowsers.getDriver(browserName);
            DriverManager.setDriver(driver);
            System.out.println("Test started on browser: " + browserName);
        } else {
            throw new RuntimeException("Browser name is not specified.");
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
