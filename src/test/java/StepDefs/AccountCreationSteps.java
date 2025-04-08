package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import utils.DriverManager;

import static org.junit.Assert.assertEquals;


public class AccountCreationSteps {


    WebDriver driver = DriverManager.getDriver();
    SoftAssert softAssert = new SoftAssert();






    private WebElement waitForElement(By locator, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    
    @Given("Navigate to the {string} Page")
    public void checkSoThatWeAreOnThePage(String string) {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

    }

    @And("User enters their date of birth as {string}")
    public void userEntersTheirDateOfBirthAs(String dob) {
        WebElement dobField= waitForElement(By.id("dp"), 5);
        dobField.clear();
        dobField.sendKeys(dob);

    }

    @And("User enters first name as {string}")
    public void userEntersFirstNameAs(String first_name) {
        WebElement firstNameField = waitForElement(By.id("member_firstname"), 5);
        firstNameField.clear();
        firstNameField.sendKeys(first_name);

    }

    @And("User enters last name as {string}")
    public void userEntersLastNameAs(String last_name) {
        driver.findElement(By.id("member_lastname")).sendKeys(last_name);

    }

    @And("User enters email address as {string}")
    public void userEntersEmailAddressAs(String email) {
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
    }

    @And("User confirms email as {string}")
    public void userConfirmsEmailAs(String email) {
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
    }

    @And("User enters password as {string}")
    public void userEntersPasswordAs(String password) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
    }

    @And("User confirms password as {string}")
    public void userConfirmsPasswordAs( String password) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(password);
    }

    @And("User selects roles as {string}")
    public void userSelectsRolesAs(String role) {  // <-- Must accept String parameter
        System.out.println("Selected role: " + role);
        if (role.equalsIgnoreCase("Player")) {
            WebElement checkbox = driver.findElement(By.xpath("//label[@for='signup_basketballrole_21']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }

    }

    @And("User accepts communication")
    public void userAcceptsCommunication() {
    }

    @And("User accepts the ToS")
    public void userAcceptsTheToS() {
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
    }

    @And("User accepts the Code of Conduct")
    public void userAcceptsTheCodeOfConduct() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }

    @And("User clicks on the confirm and join button")
    public void userClicksOnTheConfirmAndJoinButton() {
    }

    @Then("A successful account is created")
    public void aSuccessfulAccountIsCreated() {
    }

    @And("User does not accept the ToS")
    public void userDoesNotAcceptTheToS() {
        WebElement tosErrorMessage = waitForElement(By.xpath("//*[@id='signup_form']/div[11]/div/div[2]/div[1]/span/span)"), 5);

        if(tosErrorMessage.isDisplayed()) {
            String actual = tosErrorMessage.getText().trim();
            String expected = "You must confirm that you have read and accepted our Terms and Conditions";


            softAssert.assertEquals(expected,actual);
        } else {
            System.out.println("Error message for ToS is not displayed");
        }

    }

    @Then("A error message pops up indicating what the user did wrong")
    public void aErrorMessagePopsUpIndicatingWhatTheUserDidWrong() {
    }



    @And("Check that User accepted ToS")
    public void checkThatUserAcceptedToS() {
        WebElement tosCheckBox = waitForElement(By.xpath("//*[@id=\"sign_up_25\"]"), 5);

        if (tosCheckBox.isSelected()) {
            System.out.println("ToS checkbox is selected");

        } else {
            System.out.println("ToS checkbox is NOT selected");
        }
    }

    @And("Check that User accepted Code of Conduct")
    public void checkThatUserAcceptedCodeOfConduct() {
        WebElement cocErrorMessage = waitForElement(By.xpath("//*[@id='signup_form']/div[11]/div/div[7]/span/span)"), 5);

        if (cocErrorMessage.isDisplayed()) {
            String actual = cocErrorMessage.getText().trim();
            String expected = "You must confirm that you have read, understood and agree to the Code of Ethics and Conduct";

            softAssert.assertEquals(actual,expected);
        } else {
            System.out.println("Error message for CoC is not displayed");
        }
    }

    @And("Verify that we are on the {string} Page")
    public void verifyThatWeAreOnThePage(String arg0) {
    }

    @And("User verifies that the passwords are correct")
    public void userVerifiesThatThePasswordsAreCorrect() {
    }
}
