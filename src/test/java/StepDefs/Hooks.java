package StepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DriverManager;
import utils.TestBrowsers;
import org.openqa.selenium.WebDriver;

public class Hooks {

    // Baseline browser is overridden in the feature file
    public static String browserName = "chrome";



    @Before
    public void setUp(Scenario scenario) {
        cleanWebDriverManagerCache();

        if (browserName != null) {
            if (DriverManager.getDriver() == null) {
                WebDriver driver = TestBrowsers.getDriver(browserName);
                DriverManager.setDriver(driver);
                System.out.println("Test started on browser: " + browserName);
            }
        } else {
            throw new RuntimeException("Browser name is not specified.");
        }


    }

    // Clears the WebDriverManager cache, had issues with this when i tried CI
    public void cleanWebDriverManagerCache() {
        try {
            WebDriverManager.chromedriver().clearDriverCache();
            WebDriverManager.firefoxdriver().clearDriverCache();
            WebDriverManager.edgedriver().clearDriverCache();
            System.out.println("WebDriverManager cache cleared successfully");
        } catch (Exception e) {
            System.err.println("Error clearing WebDriverManager cache: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
        browserName = "chrome";
    }
}
