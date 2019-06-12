// Generated by Selenium IDE
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.Instant;
import java.util.*;
public class Test1Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  WebDriverWait wait;

  //add the WebDriverManager setup before class
  @BeforeClass
  public static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();

  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test1() throws InterruptedException {
    wait  = new WebDriverWait(driver,5);
    driver.get("https://anotepad.com/");
    driver.manage().window().setSize(new Dimension(1600, 860));
    driver.findElement(By.id("edit_title")).sendKeys("My First Note");
    driver.findElement(By.id("btnSaveNote")).click();

    // add the wait function before assert
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert.alert-warning"), "You have saved your note as"));
    assertThat(driver.findElement(By.cssSelector(".alert:nth-child(1)")).getText(), is("You have saved your note as a Guest User. You can come back at anytime to continue editing as long as you don\'t delete your browser cookies. To access your notes from anywhere and never lose them, please Create a Free Account. Your existing notes will be saved into your account."));
    driver.findElement(By.linkText("Delete")).click();
    driver.switchTo().alert().accept();
    driver.findElement(By.cssSelector("#savedNotes > div")).click();
    assertThat(driver.findElement(By.cssSelector("#savedNotes > div")).getText(), is("No note here."));
  }
}
