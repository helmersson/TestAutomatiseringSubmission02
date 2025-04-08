package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class TestBrowsers {

    public static WebDriver getDriver(String browser) {
        String chromeDriverPath = System.getProperty("user.dir") + "/drivers/chromedriver";
        System.out.println("Resolved ChromeDriver path: " + chromeDriverPath); //Ändra till .exe på windows och ta bort det för mac
        System.out.println("File exists: " + new File(chromeDriverPath).exists());

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);    //Ändra till .exe på windows och ta bort det för mac

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "drivers/geckodriver.exe");
            return new FirefoxDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
    }
}

