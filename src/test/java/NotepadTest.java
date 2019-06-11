import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotepadTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void openBrowser(){
        driver = new ChromeDriver();
        wait  = new WebDriverWait(driver,5);
    }



    @Test
    public void createNote(){
        driver.get("https://anotepad.com/");
        driver.findElement(By.id("edit_title")).sendKeys("My First Note");
        driver.findElement(By.id("btnSaveNote")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert.alert-warning"), "You have saved your note as"));
        driver.findElement(By.cssSelector(".delete")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();


        Assert.assertEquals("No note here.", driver.findElement(By.cssSelector(".saved_notes div")).getText());

}



    @After
    public void closeBrowser(){
        driver.quit();
    }

}
