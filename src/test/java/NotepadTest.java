
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


public class NotepadTest extends WebBrowserDriverFactory{


    String title = "My New Super Note";
    String noteContent = "Note content\nSome text\nAnother text";

    String loginEmail = "asd@gmail.com";
    String loginPwd = "123456";

    String folderName = "My New Folder";

    String value = "Dark";



    @Test
    @DisplayName("Test notepad content is correct")
    public void notepadTest() {
        notePad
                .openApplication()
                .setNoteTitle(title)
                .resetNoteContent(noteContent)
                .saveRecentNote();
        Assert.assertEquals(noteContent, notePad.getNoteContent());
    }

    @Test
    @DisplayName("Test title content is okay")
    public void notepadTest2() {
        notePad
                .openApplication()
                .setNoteTitle(title)
                .resetNoteContent(noteContent)
                .saveRecentNote();
        Assert.assertEquals(title, notePad.getTitleContent());
    }


    @Test
    @DisplayName("Log in with valid credentials")
    public void loginTest() {

        loginPage
                .open()
                .enterLoginEmail(loginEmail)
                .enterLoginPassword(loginPwd)
                .loginIntoAccount();

        Assert.assertEquals(loginPage.isSettingsButtonDisplayed(), true);

    }


    @Test
    @DisplayName("Create New NoteFolder")
    public void createFolder() {

        loginPage
                .open()
                .enterLoginEmail(loginEmail)
                .enterLoginPassword(loginPwd)
                .loginIntoAccount();

        folder
                .manageNoteFolder()
                .enterNoteFolderName(folderName)
                .saveNoteFolder()
                .close();

        Assert.assertEquals(folder.getCreatedFolderName(), folderName);

    }


    @Test
    @DisplayName("Changing Color theme by Settings")
    public void changeColourTheme(){
        loginPage
                .open()
                .enterLoginEmail(loginEmail)
                .enterLoginPassword(loginPwd)
                .loginIntoAccount();

        colorTheme
                .open()
                .navigateToSettings()
                .navigateToDropdownColourTheme()
                .chooseColourTheme()
                .setNewColourTheme();


        Assert.assertEquals(value, colorTheme.getCurrentColorTheme());


    }


}
