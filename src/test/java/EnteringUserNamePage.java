import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnteringUserNamePage {
    private static final String SUBJECT = RandomStringUtils.randomAlphabetic(5);
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void enteringUserNameOfYahoo() throws InterruptedException {
        driver.get("https://mail.aol.com/");
        WebElement userNameInputOfYahoo = driver.findElement(By.xpath("//input[@id='login-username']"));
        userNameInputOfYahoo.sendKeys("test.acc_2@aol.com");
        WebElement nextButtonOfYahoo = driver.findElement(By.xpath("//input[@id='login-signin']"));
        nextButtonOfYahoo.click();
        Thread.sleep(1000);
        WebElement passwordInputOfYahoo = driver.findElement(By.id("login-passwd"));
        passwordInputOfYahoo.sendKeys("test.password321");
        WebElement passwordSignInButtonOfYahoo = driver.findElement(By.xpath("//button[@id='login-signin']"));
        passwordSignInButtonOfYahoo.click();
        Thread.sleep(1000);
        WebElement composeButtonOfYahoo = driver.findElement(By.xpath("//a[@data-test-id='compose-button']"));
        composeButtonOfYahoo.click();
        WebElement toField = driver.findElement(By.xpath("//input[@id='message-to-field']"));
        toField.sendKeys("test.acc_1@yahoo.com");
        WebElement subjectField = driver.findElement(By.xpath("//input[@data-test-id='compose-subject']"));
        subjectField.sendKeys(SUBJECT);
        WebElement messageField = driver.findElement(By.xpath("//div[@data-test-id='rte']"));
        messageField.sendKeys("The email has been sent.");
        WebElement sendButton = driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']"));
        sendButton.click();
        Thread.sleep(1000);
        driver.get("https://login.yahoo.com/");
        WebElement userNameInputOfAol = driver.findElement(By.xpath("//input[@id='login-username']"));
        userNameInputOfAol.sendKeys("test.acc_1@yahoo.com");
        WebElement nextButtonOfAol = driver.findElement(By.xpath("//input[@id='login-signin']"));
        nextButtonOfAol.click();
        Thread.sleep(1000);
        WebElement passwordInputOfAol = driver.findElement(By.xpath("//input[@id='login-passwd']"));
        passwordInputOfAol.sendKeys("test.password123");
        WebElement passwordSignInButtonOfAol = driver.findElement(By.xpath("//button[@id='login-signin']"));
        passwordSignInButtonOfAol.click();
        Thread.sleep(1000);
        WebElement mailButtonOfYahoo = driver.findElement(By.xpath("//a[@id='ybarMailLink']"));
        mailButtonOfYahoo.click();
        WebElement inboxButton = driver.findElement(By.xpath("//a[@data-test-id='folder-list-item']"));
        inboxButton.click();
        Thread.sleep(1000);
        WebElement email = driver.findElement(By.xpath(String.format("//span[@title='%s']", SUBJECT)));
        WebElement unread = email.findElement(By.xpath("//a[@data-test-read='false']"));
        Assert.assertTrue(email.isDisplayed(), "The email hasn't arrived");
        Assert.assertTrue(unread.isDisplayed(), "The email has been read");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
    }

}
