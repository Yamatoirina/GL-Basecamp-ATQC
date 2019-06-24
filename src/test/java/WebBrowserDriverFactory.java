import objects.ColorTheme;
import objects.LoginPage;
import objects.NoteFolder;
import objects.NotePad;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;


public class WebBrowserDriverFactory {

 public static WebDriver driver;
    public  static WebDriverWait wait;

    NotePad notePad;
    LoginPage loginPage;
    NoteFolder folder;
    ColorTheme colorTheme;


    @Before
    public void setupClass() {

        driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());

        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, 15);

        notePad = new NotePad(driver);
        loginPage = new LoginPage(driver);
        folder = new NoteFolder(driver);
        colorTheme = new ColorTheme(driver);
    }


    @After
    public void closeBrowser(){
        WebDriverPool.DEFAULT.dismissAll();
    }


}
