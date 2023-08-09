package com.examly.springapp;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert; // Import TestNG's Assert class

public class SpringApplicationTests {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest() throws Exception {
        // Replace <seleniumhost:port> with correct values
        String seleniumHost = "seleniumhost"; // Remove the "http://" part
        int seleniumPort = 4444;
        
        // Construct the Selenium Hub URL
        String hubUrl = String.format("http://%s:%d/wd/hub", seleniumHost, seleniumPort);
        
        driver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
        
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void testSomething() {
        // Your test code here
        // Example:
        driver.get("https://www.example.com");
        String title = driver.getTitle();
        String expectedTitle = "Example Domain"; // Corrected the expected title
        Assert.assertEquals(title, expectedTitle);
    }
}
