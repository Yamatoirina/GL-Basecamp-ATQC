//package grid;
//
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.*;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import java.net.MalformedURLException;
//import java.net.URL;
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.WebDriver;
//
//public class SeleniumGrid {
//
//    Webdriver driver;
//    String baseUrl, nodeURL;
//
//    @Before
//    public void SetUp() throws MalformedURLException {
//        baseUrl = "http://autoqa.org";
//        nodeURL = "http://192.168.1.4:5566/wb/hub";
//        DesiredCapabilities сapability = new DesiredCapabilities.firefox();
//        сapability.setBrowserName("firefox");
//        сapability.setPlatform(Platform.XP);
//        driver = new RemoteWebdriver(new URL(nodeURL), capability);
//    }
//
//
//
//
//
//
//    @After
//    public void afterTest() {
//        driver.quite();
//    }
//}
