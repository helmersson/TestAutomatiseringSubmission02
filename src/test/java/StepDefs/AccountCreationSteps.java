package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import utils.TestData;
import utils.DriverManager;





public class AccountCreationSteps {


    WebDriver driver = DriverManager.getDriver();





    private WebElement waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    
    @Given("Navigate to the {string} Page")
    public void checkSoThatWeAreOnThePage(String string) {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

    }

    @And("User enters their date of birth as {string}")
    public void userEntersTheirDateOfBirthAs(String input) {
        driver.findElement(By.id("dp")).sendKeys(TestData.dob);

    }

    @And("User enters first name as {string}")
    public void userEntersFirstNameAs(String input) {
        driver.findElement(By.id("member_firstname")).sendKeys(TestData.firstName);

    }

    @And("User enters last name as {string}")
    public void userEntersLastNameAs(String input) {
        driver.findElement(By.id("member_lastname")).sendKeys(TestData.lastName);

    }

    @And("User enters email address as {string}")
    public void userEntersEmailAddressAs(String input) {
        driver.findElement(By.id("member_emailaddress")).sendKeys(TestData.email);
    }

    @And("User confirms email as {string}")
    public void userConfirmsEmailAs(String input) {
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(TestData.email);
    }

    @And("User enters password as {string}")
    public void userEntersPasswordAs(String input) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(TestData.password);
    }

    @And("User confirms password as {string}")
    public void userConfirmsPasswordAs( String input) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(TestData.password);
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
    }

    @And("User accepts the Code of Conduct")
    public void userAcceptsTheCodeOfConduct() {
    }

    @And("User clicks on the confirm and join button")
    public void userClicksOnTheConfirmAndJoinButton() {
    }

    @Then("A successful account is created")
    public void aSuccessfulAccountIsCreated() {
    }

    @And("User does not accept the ToS")
    public void userDoesNotAcceptTheToS() {
    }

    @Then("A error message pops up indicating what the user did wrong")
    public void aErrorMessagePopsUpIndicatingWhatTheUserDidWrong() {
    }

    @And("Check that User accepted communication")
    public void checkThatUserAcceptedCommunication() {
    }

    @And("Check that User accepted ToS")
    public void checkThatUserAcceptedToS() {
    }

    @And("Check that User accepted Code of Conduct")
    public void checkThatUserAcceptedCodeOfConduct() {
    }
}
