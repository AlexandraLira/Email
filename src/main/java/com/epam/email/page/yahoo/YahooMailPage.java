package com.epam.email.page.yahoo;

import com.epam.email.page.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooMailPage extends BasePage {

    @FindBy(xpath = "//a[@id='ybarMailLink']")
    private WebElement mailButton;

    @FindBy(xpath = "//a[@data-test-id='folder-list-item']")
    private WebElement inboxButton;

    @FindBy(xpath = "//span[@title='test']")
    private WebElement email;

    @FindBy(xpath = "//span[@title='test']/parent::div/parent::div/parent::div/parent::div/parent::a[@data-test-read='false']")
    private WebElement unreadSign;

    @FindBy(xpath = "//span[@title='test']/preceding::div/span[@title='test.acc_2@aol.com']")
    private WebElement sender;

    @FindBy(xpath = "//div[text()='The email has been sent.']")
    private WebElement contextOfLetter;

    public YahooMailPage(WebDriver driver) {
        super(driver);
    }

    public String getSender() {
        return sender.getText();
    }

    public YahooMailPage openInbox() {
        mailButton.click();
        waitForElementToBeVisibleAndClick(inboxButton);
        return this;
    }

    public boolean isEmailDisplayed() {
        return waitForElementToBeVisible(email).isDisplayed();
    }

    public boolean isMailUnread() {
        return waitForElementToBeVisible(unreadSign).isDisplayed();
    }

    public String checkContent() {
        email.click();
        return waitForElementToBeVisible(contextOfLetter).getText();
    }
}
