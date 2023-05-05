package com.epam.email.page.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void waitForElementToBeVisibleAndClick(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public WebElement waitForElementToBeVisible(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return waitForElementToBeVisible(element).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
