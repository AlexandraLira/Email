package com.epam.email.page.yahoo;

import com.epam.email.page.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooHomePage extends BasePage {

    private static final String YAHOO_HOME_PAGE_URL = "https://login.yahoo.com/";

    @FindBy(xpath = "//input[@id='login-username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id='login-signin']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='login-passwd']")
    private WebElement passwordInput;

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    public YahooHomePage openPage() {
        super.openPage(YAHOO_HOME_PAGE_URL);
        return this;
    }

    public YahooHomePage inputUsername(String usernameOfYahoo) {
        usernameInput.sendKeys(usernameOfYahoo);
        nextButton.click();
        return this;
    }

    public YahooHomePage inputPassword(String passwordOfYahoo) {
        waitForElementToBeVisible(passwordInput);
        passwordInput.sendKeys(passwordOfYahoo);
        nextButton.click();
        return this;
    }
}
