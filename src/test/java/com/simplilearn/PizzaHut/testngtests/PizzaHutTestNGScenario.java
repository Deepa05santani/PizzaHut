package com.simplilearn.PizzaHut.testngtests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.simplilearn.PizzaHut.utils.ExcelUtils;

public class PizzaHutTestNGScenario {
    WebDriver driver;

    @DataProvider(name = "pizzaHutDataProvider")
    public Object[][] provideTestData() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx";
        String sheetName = "Data";
        return ExcelUtils.getExcelData(filePath, sheetName);
    }

    @Test(dataProvider = "pizzaHutDataProvider")
    public void executePizzaHutWorkflow(String url, String location) {
        // 1. Initialize WebDriver and navigate
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 2. Clear location pop-up screen if visible and type address
        try {
            WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@placeholder='Enter your location for delivery']")
            ));
            locationInput.sendKeys(location);
            
            // 3. Select first auto-populated drop-down option
            WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'location-suggestion') or @role='option'][1]")
            ));
            firstSuggestion.click();
            
            // 4. Validate URL contains 'deals' string text
            wait.until(ExpectedConditions.urlContains("deals"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("deals"), "URL validation failed! 'deals' not found.");
            System.out.println("Validation successful! Navigated to: " + currentUrl);
            
        } catch (Exception e) {
            Assert.fail("Automation step failed during execution: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}