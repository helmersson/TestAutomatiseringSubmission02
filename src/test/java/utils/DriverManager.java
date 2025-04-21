package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Create a default Chrome driver if none exists
            WebDriver defaultDriver = TestBrowsers.getDriver("chrome");
            driver = defaultDriver;
            System.out.println("Created default Chrome driver");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
