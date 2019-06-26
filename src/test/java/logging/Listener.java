package logging;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;


public class Listener extends AbstractWebDriverEventListener {

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        out.println("[Something went wrong:] "+throwable.getMessage().split(":")[0]);

        saveAllureScreenshot(driver);


        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tempFile, new File(currentTimeMillis() + "screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println("[Screenshot captured]");



    }



    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }




}
