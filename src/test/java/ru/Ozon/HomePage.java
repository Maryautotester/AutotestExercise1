package ru.Ozon;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        js = (JavascriptExecutor)driver;
    }
    @FindBy(xpath = "//*[@placeholder='Искать на Ozon']")
    private WebElement product;
    @FindBy(xpath = "//div//a[contains(@class, 'suggestions-item type-history tsBodyL')]")
    private WebElement selectItem;
    @FindBy(xpath = "//button[@aria-label='Поиск']")
    private WebElement searchBtn;
    @FindBy(xpath = "//button//span[contains(text(), 'Добавить в корзину')]//..//..//..//..//..//..//..")
    private WebElement addTo;
    @FindBy(xpath = "//div[@role = 'listbox']//div//input")
    private WebElement comboboxSelect;
    public void open() {
        driver.get("https://www.ozon.ru");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(true, title.equals("OZON — интернет-магазин. Миллионы товаров по выгодным ценам"));
    }
    public void searchProduct(String searchProduct) {
        System.out.println(String.format("%s", searchProduct));
        product.sendKeys(String.format("%s", searchProduct)); //  "зонт"
        // wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }
    public void changeSortingtoLowPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(comboboxSelect));
        comboboxSelect.click();
        comboboxSelect.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
    }
    public void findproductbyName(String productName) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("data-widget=\"skuAdvSearchShelf\"")));
        int i = 0;
        do {
            if (driver.findElements(By.xpath(String.format("//span[contains(text(), '%s')]", productName))).size() > 0) {
                break;
            }
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebElement next = driver.findElement(By.xpath("//div[contains(text(), 'Дальше')]"));
            js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", next);
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'Дальше')]")));
            next.click();
            i++;
            System.out.println(i);
        } while (i < 11);
    }
    public void chooseproductbyName(String nameofProduct) {
        System.out.println(String.format("//span[contains(text(), '%s')]", nameofProduct));
        driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", nameofProduct))).click();
    }
    public void addProductToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//button//span[contains(text(), 'Добавить в корзину')]")));
        addTo.isDisplayed();
        addTo.click();
    }
}
