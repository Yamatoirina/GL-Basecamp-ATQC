package cucumber;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class TestingScenarios {

    @Given("^aNotepad is opened in my browser$")
    public void aNotepadIsOpenInMyBrowser() throws Throwable {
        open("https://anotepad.com/");
    }






}
