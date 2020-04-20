import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pn.pages.SGRFPage;

public class MyStepdefs {

    WebDriver webDriver = new ChromeDriver();
    SGRFPage sgRFPage = new SGRFPage(webDriver);

    String startURL = "http://localhost:9292/";
    String endURL = "http://localhost:9292/registration_complete?dob=1999-01-01&customRadioInline1=on&cv=&streamRadioInline1=on";


    @Given("I am on the SGRFPage")
    public void iAmOnTheSGRFPage() {
        Assertions.assertEquals(startURL, sgRFPage.getURL());
    }

    @When("I enter all details correctly")
    public void iEnterAllDetailsCorrectly() {
        sgRFPage.addCorrectDataForAllFields();
        sgRFPage.clickFemaleButton();
        sgRFPage.clickDevOpsStreamButton();
        sgRFPage.clickTermsAndConditions();
        sgRFPage.clickSubmitButton();
    }

    @Then("my application is registered")
    public void myApplicationIsRegistered() {
        Assertions.assertEquals( endURL, sgRFPage.isRegistrationSuccessful());
        webDriver.close();
    }



    @Given("I enter all details incorrectly")
    public void iEnterAllDetailsIncorrectly() {
    }

    @Then("I am unable to register")
    public void iAmUnableToRegister() {
    }

    @When("I enter minimum required information")
    public void iEnterMinimumRequiredInformation() {
    }

    @Then("I am able to register")
    public void iAmAbleToRegister() {
    }
}
