package com.epam.email.page.aol;

import com.epam.email.page.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AOLHomePage extends BasePage {

    private static final String AOL_MAIL_PAGE_URL = "https://mail.aol.com/";

    @FindBy(xpath = "//*[@id='ybarAccountMenu']")
    private WebElement profileIcon;

    @FindBy(xpath = "//*[@data-error='messages.INVALID_USERNAME']")
    private WebElement invalidUsernameErrorMessage;

    @FindBy(xpath = "//*[@data-error='messages.ERROR_INVALID_PASSWORD']")
    private WebElement invalidPasswordErrorMessage;

    @FindBy(xpath = "//*[@data-error='messages.ERROR_EMPTY_PASSWORD']")
    private WebElement emptyPasswordErrorMessage;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='login-username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id='login-signin']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='login-passwd']")
    private WebElement passwordInput;

    public AOLHomePage(WebDriver driver) {
        super(driver);
    }

    public AOLHomePage openPage() {
        openPage(AOL_MAIL_PAGE_URL);
        return this;
    }

    public AOLHomePage inputUsername(String usernameOfAol) {
        loginButton.click();
        waitForElementToBeVisible(usernameInput);
        usernameInput.sendKeys(usernameOfAol);
        nextButton.click();
        return this;
    }

    public boolean isProfileIconDisplayed() {
        return isElementDisplayed(profileIcon);
    }

    public boolean isUsernameInvalid() {
        return isElementDisplayed(invalidUsernameErrorMessage);
    }

    public AOLHomePage inputPassword(String password) {
        waitForElementToBeVisible(passwordInput);
        passwordInput.sendKeys(password);
        nextButton.click();
        return this;
    }

    public boolean isPasswordInvalid() {
        return isElementDisplayed(invalidPasswordErrorMessage);
    }

    public boolean isUsernameEmpty() {
        return isElementDisplayed(invalidUsernameErrorMessage);
    }

    public boolean isPasswordEmpty() {
        return isElementDisplayed(emptyPasswordErrorMessage);
    }
}
