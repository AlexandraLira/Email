package com.epam.email.page.aol;

import com.epam.email.page.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AOLMailPage extends BasePage {

    @FindBy(xpath = "//a[@data-test-id='compose-button']")
    private WebElement composeButton;

    @FindBy(xpath = "//input[@id='message-to-field']")
    private WebElement toField;

    @FindBy(xpath = "//input[@data-test-id='compose-subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@data-test-id='rte']")
    private WebElement textField;

    @FindBy(xpath = "//button[@data-test-id='compose-send-button']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//a[@data-test-id='navigate-button']")
    private WebElement sendEmailPopupWindow;

    public AOLMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AOLMailPage sendEmail(String username, String subject, String text) {
        waitForElementToBeVisibleAndClick(composeButton);
        waitForElementToBeVisible(toField);
        toField.sendKeys(username);
        subjectField.sendKeys(subject);
        textField.sendKeys(text);
        sendEmailButton.click();
        return this;
    }

    public boolean isEmailSent() {
        return waitForElementToBeVisible(sendEmailPopupWindow).isDisplayed();
    }
}
