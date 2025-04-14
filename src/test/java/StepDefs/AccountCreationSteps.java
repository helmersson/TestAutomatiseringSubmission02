package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import utils.DriverManager;

import static org.junit.Assert.assertEquals;


public class AccountCreationSteps {

    WebDriver driver = DriverManager.getDriver();

    private WebElement waitForElement(By locator, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    // **NAVIGATION**
    @Given("Navigate to the {string} Page")
    public void checkSoThatWeAreOnThePage(String string) {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

        String actual = driver.getTitle();
        String expected = "Basketball England Members Area";

        assertEquals(expected, actual);
        System.out.println("Expected =" + expected + "," + "Actual =" + actual);
    }

    // **INPUT**

    @And("User enters their date of birth as {string}")
    public void userEntersTheirDateOfBirthAs(String dob) {
        WebElement dobField = waitForElement(By.id("dp"), 5);
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
    public void userSelectsRolesAs(String role) {
        System.out.println("Selected role: " + role);
        if (role.equalsIgnoreCase("Player")) {
            WebElement checkbox = driver.findElement(By.xpath("//label[@for='signup_basketballrole_21']"));
            checkbox.click();
        }

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
        WebElement submitButton = driver.findElement(By.cssSelector("#signup_form > div.form-actions.noborder > input"));
        submitButton.click();
    }

    @Then("A successful account is created")
    public void aSuccessfulAccountIsCreated() {
    }

    // **VERIFICATION**

    @And("Check that User accepted ToS")
    public void checkThatUserAcceptedToS() {
        WebElement tosErrorMessage = waitForElement(By.cssSelector("span[for='TermsAccept']"), 5);

        if(tosErrorMessage.isDisplayed()) {
            String actual = tosErrorMessage.getText().trim();
            String expected = "You must confirm that you have read and accepted our Terms and Conditions";
            assertEquals(expected, actual);
            System.out.println("Expected =" + expected + "," + "Actual =" + actual);

        } else {
            System.out.println("Error message for ToS is not displayed");
        }
    }

    @And("Check that User accepted Code of Conduct")
    public void checkThatUserAcceptedCodeOfConduct() {
        WebElement CocCheckBox = waitForElement(
                By.id("sign_up_26"), 5);

        if (CocCheckBox.isSelected()) {
            System.out.println("CoC checkbox is selected");
        } else {
            System.out.println("CoC checkbox is not selected");
        }
    }

    @And("Verify that we are on the {string} Page")
    public void verifyThatWeAreOnThePage(String arg0) {
        String actual = driver.getCurrentUrl();
        String expected = "https://membership.basketballengland.co.uk/NewSupporterAccount";

        assertEquals(expected,actual);
        System.out.println("Expected =" + expected + "," + "Actual =" + actual);
    }


    // **ERROR HANDLING*


    @Then("A error message pops up indicating what the user did wrong")
    public void aErrorMessagePopsUpIndicatingWhatTheUserDidWrong() {
    }

    @And("Check that last name error message is visible")
    public void checkThatLastNameErrorMessageIsVisible() {
        WebElement lastNameErrorMessage = waitForElement(By.cssSelector("#signup_form > div:nth-child(6) > div:nth-child(2) > div > span > span"), 5);
        if(lastNameErrorMessage.isDisplayed()) {
            String actual = lastNameErrorMessage.getText().trim();
            String expected = "Last Name is required";
            assertEquals(expected, actual);
            System.out.println("Expected =" + expected + "," + "Actual =" + actual);
        } else {
            System.out.println("Error message for Last Name is not displayed");
        }
    }

    @And("Checks that password error message is visible")
    public void checksThatPasswordErrorMessageIsVisible() {
        WebElement passwordErrorMessage = waitForElement(By.cssSelector("#signup_form > div:nth-child(9) > div > div.row > div:nth-child(2) > div > span > span"), 5);
        if(passwordErrorMessage.isDisplayed()) {
            String actual = passwordErrorMessage.getText().trim();
            String expected = "Password did not match";
            assertEquals(expected, actual);
            System.out.println("Expected =" + expected + "," + "Actual =" + actual);

        } else {
            System.out.println("Error message for Last Name is not displayed");
        }
    }
}
