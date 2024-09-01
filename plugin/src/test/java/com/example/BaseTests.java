package com.example;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTests {

    public WebDriver driver;
    public final static int TIMEOUT = 10;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}