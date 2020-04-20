package org.pn;

import io.cucumber.java.bs.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pn.pages.SGRFPage;

import java.awt.*;

public class SGRFPOMTester {

    String startURL = "http://localhost:9292/";
    String endURL = "http://localhost:9292/registration_complete?dob=1999-01-01&customRadioInline1=on&cv=&streamRadioInline1=on";


    static WebDriver webDriver = new ChromeDriver();
    static SGRFPage sgRFPage = new SGRFPage(webDriver);

    @Test
    @DisplayName("Correct Page Address")
    public void correctPageAddress(){
        Assertions.assertEquals(startURL, sgRFPage.getURL());
    }

    @Test
    @DisplayName("Correct Title Message")
    public void correctTitleMessage(){
        Assertions.assertEquals("Welcome to Sparta Global", sgRFPage.getTitleMessage());
    }

    @Test
    @DisplayName("Correct Sparta Global Logo URL Used")
    public void correctSpartaGlobalLogoURL(){
        Assertions.assertEquals
                ("http://localhost:9292/images/sparta-global-logo-white.svg",
                        sgRFPage.getLogoURL());
    }

    @Test
    @DisplayName("Correct Logo Width")
    public void correctLogoWidth(){
        Assertions.assertEquals(120, sgRFPage.getLogoWidth());
    }

    @Test
    @DisplayName("Correct Logo Height")
    public void correctLogoHeight(){
        Assertions.assertEquals(80, sgRFPage.getLogoHeight());
    }

    @Test
    @DisplayName("Correct Title Bar Colour")
    public void correctTitleBarColour(){
        Color c = Color.decode("#3D0B37");
        String rgbaString = "rgba(" + c.getRed() + ", " +
                c.getGreen() + ", " + c.getBlue() + ", 1)";
        Assertions.assertEquals(rgbaString, sgRFPage.getTitleBarColour());
    }

    @Test
    @DisplayName("Correct topHeader text on page")
    public void correctTopHeaderTextOnPage(){
        Assertions.assertEquals("Sparta Global Registration Form", sgRFPage.getTopHeaderText());
    }

    @Test
    @DisplayName("Check First Name field has loaded")
    public void hasFirstNameFieldLoaded(){
        Assertions.assertTrue(sgRFPage.isFirstNameFieldAvailable());
    }

    @Test
    @DisplayName("Check Date Of Birth field has loaded")
    public void hasDateOfBirthFieldLoaded(){
        Assertions.assertTrue(sgRFPage.isDateOfBirthFieldAvailable());
    }

    @Test
    @DisplayName("Check Date Of Birth field title has loaded")
    public void hasDateOfBirthFieldTitleLoaded(){
        Assertions.assertTrue(sgRFPage.isDateOfBirthFieldTitleAvailable());
    }

    @Test
    @DisplayName("Check Date Of Birth field title is correct text")
    public void correctDateOfBirthFieldTitleText(){
        Assertions.assertEquals("Date Of Birth", sgRFPage.getDateOfBirthFieldTitleText());
    }

    @Test
    @DisplayName("Check Date Of Birth field is set to correct type")
    public void correctDateOfBirthFieldType(){
        Assertions.assertEquals("date", sgRFPage.isDateOfBirthFieldTypeDate());
    }

    /*
    The "Age", "Date Of Birth" & "Degree" input fields are missing a name and id in the master version.
    I have edited:        views/posts/index.erb       Lines: 46, 55 and 71
    to now include appropriate names and ids to access and test the values reliably in future as they
    shared the same name ("form-control") and made access difficult and unreliable.
     */

    @Test
    @DisplayName("Check Age field only accepts numbers")
    public void correctInputAcceptedInAgeField(){
        Assertions.assertTrue(sgRFPage.isAgeFieldAcceptingNumbersOnly());
        // NOTE: the following are accepted due to datatype: "." "e" "-"
    }

    @Test
    @DisplayName("Check Age Field shows correct placeholder text")
    public void correctPlaceholderTextInAgeField(){
        Assertions.assertEquals("Enter Age", sgRFPage.getPlaceholderTextInAgeField());
    }

    @Test
    @DisplayName("Check Age field does not accept negative numbers")
    public void correctHandlingOfNegativeNumbersInAgeField(){
        Assertions.assertTrue(sgRFPage.isAgeFieldHandlingNegativeNumbersCorrectly());
    }

    @Test
    @DisplayName("Check Unhappy Path")
    public void checkUnhappyPath(){
        Assertions.assertTrue(sgRFPage.isSubmitButtonAvailable());
        sgRFPage.clickSubmitButton();
        Assertions.assertEquals(startURL, sgRFPage.isRegistrationSuccessful());
    }

    @Test
    @DisplayName("Check Happy Path")
    public void checkHappyPath(){
        sgRFPage.addCorrectDataForAllFields();
        sgRFPage.clickFemaleButton();
        sgRFPage.clickDevOpsStreamButton();
        sgRFPage.clickTermsAndConditions();
        sgRFPage.clickSubmitButton();
        Assertions.assertEquals( endURL, sgRFPage.isRegistrationSuccessful());
    }

    // The Minimal Path fails to work because Date Of Birth is actually a required field even
    // though there is no "*" by the field.
    @Test
    @DisplayName("Check Minimal Path")
    public void checkMinimalPath(){
        sgRFPage.addCorrectDataForMinimumFields();
        sgRFPage.clickFemaleButton();
        sgRFPage.clickDevOpsStreamButton();
        sgRFPage.clickTermsAndConditions();
        sgRFPage.clickSubmitButton();
        Assertions.assertEquals(endURL, sgRFPage.isRegistrationSuccessful());

    }




}
