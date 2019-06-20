import io.github.bonigarcia.wdm.WebDriverManager;
import objects.ColorTheme;
import objects.LoginPage;
import objects.NoteFolder;
import objects.NotePad;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManagerUtil {

    public static WebDriver driver;
    public  static WebDriverWait wait;

    NotePad notePad;
    LoginPage loginPage;
    NoteFolder folder;
    ColorTheme colorTheme;


    @Before
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, 15);

        notePad = new NotePad(driver);
        loginPage = new LoginPage(driver);
        folder = new NoteFolder(driver);
        colorTheme = new ColorTheme(driver);
    }



    @After
    public void closeBrowser(){
        driver.quit();
    }
}
