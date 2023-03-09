package ru.Ozon;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class FilterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    public FilterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor)driver;
    }
    @FindBy(xpath = "//button//..//span[contains(text(), 'Все фильтры')]")
    private WebElement allFilters;
    @FindBy(xpath = "//span[contains(text(), 'Цвет')]//..//..//..")
    private WebElement colour;
    @FindBy(xpath = "//span[contains(text(), 'Цвет')]//..//..//..//..//span[contains(text(), 'Посмотреть все')]")
    private WebElement expandList;
    @FindBy(xpath = "//div[@class = 'tsBodyLBold']//span[contains(text(), 'Пол')]")
    private WebElement genderlist;
    @FindBy(xpath = "//span[contains(text(), 'Пол')]//..//..//..//..//span[contains(text(), 'Женский')]")
    private WebElement gender;
    @FindBy(xpath = "//span[contains(text(), 'Цена')]")
    private WebElement priceList;
    @FindBy(xpath = "//span[contains(text(), 'Цена')]//..//..//..//..//p[contains(text(), 'от')]//..//input")
    private WebElement priceMin;
    @FindBy(xpath = "//span[contains(text(), 'Цена')]//..//..//..//..//p[contains(text(), 'до')]//..//input")
    private WebElement priceMax;
    @FindBy(xpath = "//button//span[contains(text(), 'Применить')]")
    private WebElement applyBtn;

    public void setAllFilters(String Colour, String Gender , String minPrice, String maxPrice) {
        WebElement filters = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//button//..//span[contains(text(), 'Все фильтры')]")));

        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -60);", allFilters);
        allFilters.click();
        WebElement applyBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//button//span[contains(text(), 'Применить')]")));

        colour.click();
        expandList.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                String.format("//div[@class='vue-portal-target']//*//div[text() = '%s']//..//..//..//div", Colour))));
        driver.findElement(By.xpath(String.format(
                "//div[@class='vue-portal-target']//*//div[text() = '%s']//..//..//..//div", Colour))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                String.format("//button//span[contains(text(), 'Цвет: %s')]", Colour))));
        colour.click();

        if (!(Gender == "")) {
            genderlist.click();

            gender.click();
            genderlist.click();
            WebElement genderBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    String.format("//button//span[contains(text(), 'Пол: %s')]", Gender))));
            genderBtn.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(priceList));
        priceList.click();
        priceMin.click();
        priceMin.sendKeys(Keys.CONTROL, "a");
        priceMin.sendKeys(String.format("%s", minPrice));   //2000

        priceMax.click();
        priceMax.sendKeys(Keys.CONTROL, "a");
        priceMax.sendKeys(String.format("%s", maxPrice));    // 4000
        try{
            wait.until(ExpectedConditions.elementToBeClickable(priceList));
            priceList.click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//span[contains(text(), 'Цена')]")).click();
        }
        applyBtn.click();
    }
    public void setAllFilters(String Colour, String minPrice, String maxPrice) {
        setAllFilters(Colour, "" , minPrice, maxPrice);
    }
}

