package tests;

import com.epam.email.page.aol.AOLHomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    private static final String USERNAME_OF_AOL = "test.acc_2@aol.com";
    private static final String PASSWORD_OF_AOL = "test.password321";
    private static final String EMPTY_STRING = "";

    @Test
    public void testWithValidCredentials() {
        AOLHomePage validCredentials = new AOLHomePage(driver)
                .openPage()
                .inputUsername(USERNAME_OF_AOL)
                .inputPassword(PASSWORD_OF_AOL);
        assertTrue(validCredentials.isProfileIconDisplayed(), "User is not logged in");
    }

    @Test
    public void testWithInvalidUsername() {
        AOLHomePage invalidUsername = new AOLHomePage(driver)
                .openPage()
                .inputUsername("wrongusername@aol.com");
        assertTrue(invalidUsername.isUsernameInvalid(), "Username is valid");
    }

    @Test
    public void testWithValidUserNameAndInvalidPassword() {
        AOLHomePage invalidPasswordValidUsername = new AOLHomePage(driver)
                .openPage()
                .inputUsername(USERNAME_OF_AOL)
                .inputPassword("wrongpassword");
        assertTrue(invalidPasswordValidUsername.isPasswordInvalid(), "Password is valid");
    }

    @Test
    public void testWithEmptyUserName() {
        AOLHomePage emptyUsername = new AOLHomePage(driver)
                .openPage()
                .inputUsername(EMPTY_STRING);
        assertTrue(emptyUsername.isUsernameEmpty(), "Username is not empty");
    }

    @Test
    public void testWithValidUserNameAndEmptyPassword() {
        AOLHomePage emptyPassword = new AOLHomePage(driver)
                .openPage()
                .inputUsername(USERNAME_OF_AOL)
                .inputPassword(EMPTY_STRING);
        assertTrue(emptyPassword.isPasswordEmpty(), "Password is not empty");
    }
}
