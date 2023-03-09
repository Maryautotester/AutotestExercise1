package ru.Ozon;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class AutotestEx1 {
    public WebDriver driver;
    public JavascriptExecutor js;
    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/ChromeDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "start-maximized",
                "--remote-allow-origins=*",
                "--user-data-dir=C:\\Users\\test\\AppData\\Local\\Google\\Chrome\\User Data\\",
                "--profile-directory=Guest"
                );
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor)driver;
    }
    @Test
    public void autotestEx11() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        homePage.open();
        homePage.searchProduct("зонт");
        filterPage.setAllFilters("зеленый", "Женский", "2000", "4000");
        homePage.changeSortingtoLowPrice();
        homePage.findproductbyName("Зонт Vogue");
        homePage.chooseproductbyName("Зонт Vogue");
        homePage.addProductToCart();
        cartPage.Cart();
    }
    @Test
    public void autotestEx12() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);

        homePage.open();
        homePage.searchProduct("светильник настольный");
        filterPage.setAllFilters("золотой","800", "2000");
        homePage.changeSortingtoLowPrice();
        homePage.findproductbyName("Настольная лампа \"Лалия\"");
    }
    @After
    public void close() {
        driver.quit();
        System.out.println("test finished");
    }
}
