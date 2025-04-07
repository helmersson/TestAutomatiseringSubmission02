package StepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverManager;
import utils.TestBrowsers;

public class Hooks {

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        DriverManager.setDriver(TestBrowsers.getDriver(browser));
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
