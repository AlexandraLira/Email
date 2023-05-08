package tests;

import com.epam.email.page.aol.AOLHomePage;
import com.epam.email.page.aol.AOLMailPage;
import com.epam.email.page.yahoo.YahooHomePage;
import com.epam.email.page.yahoo.YahooMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SendAndGetEmailTests extends BaseTest {

    private static final String USERNAME_OF_AOL = "test.acc_2@aol.com";
    private static final String PASSWORD_OF_AOL = "test.password321";
    private static final String USERNAME_OF_YAHOO = "test.acc_1@yahoo.com";
    private static final String PASSWORD_OF_YAHOO = "test.password123";
    private static final String SUBJECT = "test";
    private static final String TEXT = "The email has been sent.";

    @Test
    public void testEmailSending() {
        new AOLHomePage(driver)
                .openPage()
                .inputUsername(USERNAME_OF_AOL)
                .inputPassword(PASSWORD_OF_AOL);
        AOLMailPage emailToSend = new AOLMailPage(driver)
                .sendEmail(USERNAME_OF_YAHOO, SUBJECT, TEXT);
        assertTrue(emailToSend.isEmailSent());
    }

    @Test(dependsOnMethods = {"testEmailSending"})
    public void testEmailGetting() {
        new YahooHomePage(driver)
                .openPage()
                .inputUsername(USERNAME_OF_YAHOO)
                .inputPassword(PASSWORD_OF_YAHOO);
        YahooMailPage expectedEmail = new YahooMailPage(driver)
                .openInbox();
        assertTrue(expectedEmail.isEmailDisplayed());
    }

    @Test(dependsOnMethods = {"testEmailGetting"})
    public void testIsEmailUnread() {
        new YahooHomePage(driver)
                .openPage()
                .inputUsername(USERNAME_OF_YAHOO)
                .inputPassword(PASSWORD_OF_YAHOO);
        YahooMailPage expectedEmail = new YahooMailPage(driver).openInbox();
        assertTrue(expectedEmail.isMailUnread());
    }

    @Test(dependsOnMethods = {"testIsEmailUnread"})
    public void testCorrectSender() {
        new YahooHomePage(driver)
                .openPage()
                .inputUsername(USERNAME_OF_YAHOO)
                .inputPassword(PASSWORD_OF_YAHOO);
        YahooMailPage sender = new YahooMailPage(driver).openInbox();
        Assert.assertEquals(sender.getSender(), USERNAME_OF_AOL);
    }

    @Test(dependsOnMethods = {"testCorrectSender"})
    public void testContextOfLetter() {
        new YahooHomePage(driver)
                .openPage()
                .inputUsername(USERNAME_OF_YAHOO)
                .inputPassword(PASSWORD_OF_YAHOO);
        YahooMailPage context = new YahooMailPage(driver).openInbox();
        Assert.assertEquals(context.checkContent(), TEXT);
    }
}
