package objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ColorTheme {
    private static final String url = "https://anotepad.com";
    private static final By settingsButton = By.cssSelector("a[href=\"/settings\"]");
    private static final By colorTheme = By.cssSelector("li:nth-child(4) span");
    private static final By dropdown= By.id("Theme");
    private static final By selectDark = By.xpath("//option[. = 'Dark']");
    private static final By updateSettingsButton = By.cssSelector(".form-group:nth-child(7) .btn");
    private static final By newColorTheme = By.cssSelector("#Theme > option:nth-child(2)");


    private WebDriver driver;
    private WebDriverWait wait;

    public ColorTheme(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5);
    }

    @Step
    public ColorTheme open() {
        driver.get(url);
        return this;
    }


    @Step
    public ColorTheme navigateToSettings(){
        driver.findElement(settingsButton).click();
        return this;
    }

    @Step
    public ColorTheme navigateToDropdownColourTheme(){
        driver.findElement(colorTheme).click();
        return this;
    }


    @Step
    public ColorTheme chooseColourTheme(){
        WebElement element = driver.findElement(dropdown);
        element.findElement(selectDark).click();
        return this;
    }


    @Step
    public ColorTheme setNewColourTheme(){
        driver.findElement(updateSettingsButton).click();
        wait.until((WebDriver d ) -> d.findElement(newColorTheme));
        return this;
    }


    @Step
    public String getCurrentColorTheme(){
        return driver.findElement(newColorTheme).getAttribute("value");
    }


}
