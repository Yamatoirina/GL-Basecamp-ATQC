package selenide;

import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestingBySelenide {

    @BeforeClass
    public static void start() {
        System.setProperty("selenide.browser", "chrome");
        open("https://anotepad.com/");
    }


    @Test
    public void createNewNote(){
        $(By.id("edit_title")).setValue("Vasja Pupkin");
        $(By.id("edit_textarea")).setValue("Vasja is the Best Hero!");
        $(By.xpath("//*[@id='btnSaveNote']")).click();
        $(By.cssSelector(".alert.alert-warning")).should(appear).shouldHave(text("You have saved your note as a"));
        $(By.cssSelector(".delete")).click();
        switchTo().alert().accept();
        $(By.xpath("//*[@id=\"savedNotes\"]/div")).shouldHave(text("No note here."));
    }



}
