package logging;

import io.qameta.allure.junit4.DisplayName;
import objects.LoginPage;
import objects.NotePad;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestWithListenerAndLogging {

    EventFiringWebDriver edr;
    WebDriverWait wait;
    NotePad notePad;
    LoginPage loginPage;

    String loginEmail = "asd@gmail.com";
    String loginPwd = "12345";


    @Before
    public void start() {
        edr = new EventFiringWebDriver(new ChromeDriver());
        edr.register(new Listener());
        wait = new WebDriverWait(edr,5);
        notePad = new NotePad(edr);
        loginPage = new LoginPage(edr);


        Logs logs = edr.manage().logs();
       LogEntries logEntries = logs.get(LogType.DRIVER);

        for (LogEntry logEntry : logEntries) {

            System.out.println(logEntry.getMessage());

        }



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



    @After
    public void stop() {
        edr.quit();
    }


}
