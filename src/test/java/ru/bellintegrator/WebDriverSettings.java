package ru.bellintegrator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    WebDriver chromeDriver;

    @BeforeEach
    public void installSettings() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser() {
        chromeDriver.quit();
    }
}