package cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;



public class MyStepdefs {


    @Given("aNotepad.com is opened in my browser")
    public void anotepad_com_is_opened_in_my_browser() {
        open("https://anotepad.com");
    }


    @When("^press button with text \"([^\"]*)\"$")
    public void pressButtonWithText(String button) {
        $(byText(button)).click();

    }


    @And("type to input with text \"([^\"]*)\" text: \"([^\"]*)\"")
    public void typeToInputWithText(String input, String text) {
        $(byId(input)).sendKeys(text);
    }


    @And("^press button with value \"([^\"]*)\"$")
    public void pressButtonWithValue(String value) {
        $(byCssSelector(".form-group:nth-child(6) #submit")).shouldHave(text(value)).click();

    }


    @And("select button with text \"([^\"]*)\"")
    public void selectButtonWithText(String button) {
        $(byText(button)).click();

    }


    @And("type to input with name \"([^\"]*)\" text: \"([^\"]*)\"")
    public void typeToInputWithNameText(String name, String text) {
        $(byAttribute("placeholder",name)).sendKeys(text);
    }


    @And("type to input with noteText \"([^\"]*)\" text: \"([^\"]*)\"")
    public void typeToInputWithNoteTextText(String noteText, String text) {
        $(byAttribute("placeholder", noteText)).sendKeys(text);
    }

    @And("press Save button")
    public void pressElementWithText() {
        $(byCssSelector(".col-md-6 > #btnSaveNote")).click();

    }

    @And("press Settings button")
    public void pressSettingsButton() {
        $(byXpath("//span[contains(.,'Settings')]")).click();
    }


    @And("press Delete button")
    public void pressDeleteButton() {
        $(byCssSelector(".delete")).click();
        switchTo().alert().accept();

    }
}
