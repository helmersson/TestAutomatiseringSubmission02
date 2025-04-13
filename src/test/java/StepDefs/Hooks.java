package StepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverManager;
import utils.TestBrowsers;
import org.openqa.selenium.WebDriver;


public class Hooks {

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome"); // default if not specified
        WebDriver driver = TestBrowsers.getDriver(browser);
        System.out.println("Launching browser: " + browser);
        DriverManager.setDriver(driver);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
