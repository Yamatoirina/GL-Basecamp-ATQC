Feature: Create new Note in aNotepad


  Scenario:  go to the aNotepad.com to create new Note

    Given aNotepad.com is opened in my browser
    When press button with text "Register/Login"
    And type to input with text "loginEmail" text: "asd@gmail.com"
    And type to input with name "Enter Password" text: "123456"
    And press button with value "Login"
    And type to input with noteText "Note Title" text: "My Beautiful Note"
    And type to input with noteText "Note Content" text: "Hello, my dear Teacher. My fucking test is working. Isn't it great?"
    And press Save button
    And press Delete button
    Then press button with text "Logout"



