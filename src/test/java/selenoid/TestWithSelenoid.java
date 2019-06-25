package selenoid;

import io.qameta.allure.junit4.DisplayName;
import objects.LoginPage;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;


public class TestWithSelenoid {

    static RemoteWebDriver driver;
    static LoginPage loginPage;



    String loginEmail = "asd@gmail.com";
    String loginPwd = "123456";



    @BeforeClass
    public static void start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("72.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

         driver = new RemoteWebDriver(
                URI.create("http://192.168.0.237:4444/wd/hub").toURL(),
                capabilities
        );


          loginPage = new LoginPage(driver);
    }



    @Test
    @DisplayName("Log in with valid credentials")
    public void loginTest() {

        loginPage
                .open()
                .enterLoginEmail(loginEmail)
                .enterLoginPassword(loginPwd)
                .loginIntoAccount();

        Assert.assertEquals(loginPage.isSettingsButtonDisplayed(), true);

    }



    @AfterClass
    public static void stop() {
        driver.quit();
    }

}
