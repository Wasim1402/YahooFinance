package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class YahooFinanceTest {

    private static WebDriver driver;
    private WebDriverWait wait;

    public static void main(String[] args) {
        YahooFinanceTest test = new YahooFinanceTest();
        test.setup();
        test.searchForStock("TSLA");
        test.verifyAutosuggest("TESLA Inc");
        test.clickFirstAutosuggestEntry();
        test.verifyStockPrice(200.0);
        test.captureAdditionalData();
        test.teardown();
    }

    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://finance.yahoo.com/");
    }

    public void searchForStock(String stockSymbol) {
    	WebElement searchBox = driver.findElement(By.xpath("//input[@class='_yb_1si415s _yb_u9vxc0  _yb_ljajab finsrch-inpt  ']"));
//        searchBox.clear();
    	searchBox.click();
        //searchBox.sendKeys("Tesla");
        System.out.println("Searching for stock symbol: " + stockSymbol);
    }

    public void verifyAutosuggest(String expectedSuggestion) {
        WebElement firstSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']/li[1]")));
        String actualSuggestion = firstSuggestion.getText();
        if (actualSuggestion.contains(expectedSuggestion)) {
            System.out.println("Autosuggest verification passed. Expected: " + expectedSuggestion + ", Actual: " + actualSuggestion);
        } else {
            System.out.println("Autosuggest verification failed. Expected: " + expectedSuggestion + ", Actual: " + actualSuggestion);
            throw new AssertionError("Autosuggest verification failed.");
        }
    }

    public void clickFirstAutosuggestEntry() {
        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@role='listbox']/li[1]")));
        firstSuggestion.click();
        System.out.println("Clicked on the first autosuggest entry.");
    }

    public void verifyStockPrice(double minPrice) {
        WebElement stockPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//fin-streamer[@data-field='regularMarketPrice']")));
        String stockPriceText = stockPriceElement.getText().replace(",", "");
        double stockPrice = Double.parseDouble(stockPriceText);

        if (stockPrice > minPrice) {
            System.out.println("Stock price verification passed. Price: $" + stockPrice);
        } else {
            System.out.println("Stock price verification failed. Price: $" + stockPrice);
            throw new AssertionError("Stock price is not greater than $" + minPrice);
        }
    }

    public void captureAdditionalData() {
        WebElement previousClose = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[@data-test='PREV_CLOSE-value']")));
        WebElement volume = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[@data-test='TD_VOLUME-value']")));

        System.out.println("Previous Close: " + previousClose.getText());
        System.out.println("Volume: " + volume.getText());
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
























