package org.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutotestEx1 {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/ChromeDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\test\\AppData\\Local\\Google\\Chrome\\User Data\\", "--profile-directory=Profile 2");
        driver = new ChromeDriver(options);

        js = (JavascriptExecutor)driver;
    }

}
