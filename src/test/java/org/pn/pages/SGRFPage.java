package org.pn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.SplittableRandom;

public class SGRFPage {

    WebDriver webDriver;

    By titleMessage = new By.ByClassName("navbar-right");
    By spartaGlobalLogo = new By.ByXPath("/html/body/nav/div[1]/img");
    By titleBar = new By.ByXPath("/html/body/nav");
    By topHeader = new By.ByXPath("/html/body/div/h1");
    By firstName = new By.ById("firstName");
    By lastName = new By.ById("lastName");
    By dateOfBirthField = new By.ByName("dob");
    By getDateOBirthFieldTitle = new By.ByXPath("/html/body/div/form/div[4]/div/label");
    By ageField = new By.ById("inputAge"); // This id does not exist on Master version, must update
    By degree = new By.ById("degree");
    By university = new By.ById("inputUni");
    By address1 = new By.ById("inputAddress");
    By address2 = new By.ById("inputAddress2");
    By city = new By.ById("inputCity");
    By county = new By.ById("inputCounty");
    By postcode = new By.ById("inputPostcode");
    By email = new By.ById("inputemailaddress");
    By skills = new By.ById("exampleFormControlTextarea1");
    By phoneNumber = new By.ById("exampleFormControlInput1");
    By linkedIn = new By.ByXPath("/html/body/div/form/div[17]/div/input");
    By regSuccess = new By.ByClassName("container");
    By submitButton = new By.ByCssSelector("button.btn.btn-primary");
    By femaleButton = new By.ByXPath("/html/body/div/form/div[6]/label");
    By streamButton = new By.ByXPath("/html/body/div/form/div[20]/div[2]/label");
    By termsAndCond = new By.ById("terms");


    String[] correctData = {"Alice", "Smith", "22", "Downtown", "Science",
            "University of Oxford", "42 Fake Street", "Faketown", "Bristol",
            "BB5 XVZ", "fake@email.com", "Singing \nDancing", "07777777777",
            "https://www.site.com", "DevOps"};



    public SGRFPage(WebDriver driver){
        this.webDriver = driver;
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:9292/");

    }

    public String getURL(){return webDriver.getCurrentUrl();}

    public String getTitleMessage(){
        String titleMessageText = webDriver.findElement(titleMessage).getText();
        return titleMessageText;
    }

    public String getLogoURL(){
        WebElement sgLogo = webDriver.findElement(spartaGlobalLogo);
        return sgLogo.getAttribute("src");
    }

    public int getLogoWidth(){
        WebElement sgLogo = webDriver.findElement(spartaGlobalLogo);
        return sgLogo.getSize().getWidth();
    }

    public int getLogoHeight(){
        WebElement sgLogo = webDriver.findElement(spartaGlobalLogo);
        return sgLogo.getSize().getHeight();
    }

    public String getTitleBarColour(){
        WebElement titleBarColour = webDriver.findElement(titleBar);
        String colourString =titleBarColour.getCssValue("background-color");
        System.out.println(colourString.hashCode() + " " + colourString);
        Color color = new Color(colourString.hashCode());
        System.out.println(color.getRed());
        System.out.println(titleBarColour.getCssValue("background-color"));
        return colourString;
    }

    public String getTopHeaderText(){
        String topHeaderText = webDriver.findElement(topHeader).getText();
        return topHeaderText;
    }


    public boolean isFirstNameFieldAvailable(){
        boolean firstNameFieldAvailable = webDriver.findElement(firstName).isDisplayed();
        return firstNameFieldAvailable;
    }

    public boolean isDateOfBirthFieldAvailable(){
        boolean dateOfBirthFieldAvailable = webDriver.findElement(dateOfBirthField).isDisplayed();
        return dateOfBirthFieldAvailable;
    }

    public boolean isDateOfBirthFieldTitleAvailable(){
        boolean dateOfBirthFieldTitleAvailable = webDriver.findElement(getDateOBirthFieldTitle)
                .isDisplayed();
        System.out.println("Checkpoint");
        return dateOfBirthFieldTitleAvailable;
    }

    public String getDateOfBirthFieldTitleText(){
        String dateOfBirthFieldTitleText = webDriver.findElement(getDateOBirthFieldTitle)
                .getText();
        return dateOfBirthFieldTitleText;
    }

    public String isDateOfBirthFieldTypeDate(){
        String dOBFieldType = webDriver.findElement(dateOfBirthField).getAttribute("type");
        return dOBFieldType;
    }

    public boolean isAgeFieldAcceptingNumbersOnly(){
        String exampleTest = "@bC!";
        WebElement ageFieldElement = webDriver.findElement(ageField);
        ageFieldElement.sendKeys(exampleTest);
        return (ageFieldElement.getAttribute("valueAsNumber").contains(exampleTest))
                ? false : true;
    }

    public String getPlaceholderTextInAgeField(){
        String agePlaceholder = webDriver.findElement(ageField).getAttribute("placeholder");
        return agePlaceholder;
    }

    public boolean isAgeFieldHandlingNegativeNumbersCorrectly(){
        String exampleTest = "-42";
        WebElement ageFieldElement = webDriver.findElement(ageField);
        ageFieldElement.sendKeys(exampleTest);
        return (ageFieldElement.getAttribute("valueAsNumber").contains(exampleTest))
                ? false : true;
    }

    public void addCorrectDataForAllFields(){
        webDriver.findElement(firstName).sendKeys(correctData[0]);
        webDriver.findElement(lastName).sendKeys(correctData[1]);
        webDriver.findElement(ageField).sendKeys(correctData[2]);
        webDriver.findElement(degree).sendKeys(correctData[4]);
        webDriver.findElement(university).sendKeys(correctData[5]);
        webDriver.findElement(address1).sendKeys(correctData[6]);
        webDriver.findElement(city).sendKeys(correctData[7]);
        webDriver.findElement(address2).sendKeys(correctData[3]);
        webDriver.findElement(county).sendKeys(correctData[8]);
        webDriver.findElement(postcode).sendKeys(correctData[9]);
        webDriver.findElement(email).sendKeys(correctData[10]);
        webDriver.findElement(skills).sendKeys(correctData[11]);
        webDriver.findElement(phoneNumber).sendKeys(correctData[12]);
        webDriver.findElement(linkedIn).sendKeys(correctData[13]);
        webDriver.findElement(dateOfBirthField).sendKeys("01011999");

    }

    public void addCorrectDataForMinimumFields(){
        webDriver.findElement(firstName).sendKeys(correctData[0]);
        webDriver.findElement(lastName).sendKeys(correctData[1]);
        webDriver.findElement(ageField).sendKeys(correctData[2]);
        webDriver.findElement(degree).sendKeys(correctData[4]);
        webDriver.findElement(address1).sendKeys(correctData[6]);
        webDriver.findElement(city).sendKeys(correctData[7]);
        webDriver.findElement(postcode).sendKeys(correctData[9]);
        webDriver.findElement(email).sendKeys(correctData[10]);
        webDriver.findElement(phoneNumber).sendKeys(correctData[12]);
    }

    public void  clickTermsAndConditions(){webDriver.findElement(termsAndCond).click();}

    public void clickDevOpsStreamButton(){webDriver.findElement(streamButton).click();}

    public void clickFemaleButton(){webDriver.findElement(femaleButton).click();}

    public boolean isSubmitButtonAvailable(){
        return (webDriver.findElement(submitButton).isDisplayed()) ? true : false;
    }

    public void clickSubmitButton(){webDriver.findElement(submitButton).click();}

    public String isRegistrationSuccessful(){
        String testSuccessURL = webDriver.getCurrentUrl();
        return testSuccessURL;
    }




}
