package StepDefinitions;

import Pages.Dashboard;
import Pages.LoginPage;
import Util.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginSteps extends BaseTests {

    protected LoginPage loginPage;

    protected Dashboard dashboard;

    protected String validationError;
    
    protected String validationText;

    @Given("User is on respond.io login page")
    public void atHomePage()
    {
        try{
            BaseTests.setup();
        }
        catch (Exception exp){
            System.out.println(exp);
        }
    }

    @When("Login with valid {string} and {string}")
    public void invalidLogin(String username, String password) {
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            loginPage = new LoginPage();
            loginPage.setUsernameAndPassword(username, password);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            dashboard = loginPage.clickLoginbutton();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        catch (Exception exp){
        System.out.println(exp);
        }
    }

    @And("Error validation message is shown")
    public void isError() throws InterruptedException {
        try{
        	
            validationError = loginPage.getError();
            String actualValidationMessage = "Incorrect username or password.";
            assertEquals(actualValidationMessage, validationError, "Validation message is not correct");
            BaseTests.driver.quit();
        }
        catch(Exception exp){
            System.out.println(exp);
        }
    }
    
    @Then("User must not logged in")
    public void validateThatUserMustNotLoggedIn() {
        try{
        	validationText = loginPage.getError();
            String actualValidationText = "Sign in";
            assertEquals(actualValidationText, validationText, "User is logged in, while user should not as user used invalid credentials!!");
            BaseTests.driver.quit();
        }
        catch(Exception exp){
            System.out.println(exp);
        }
    }

    @Then("Verify the Login is successful")
    public void isSuccess() throws InterruptedException {
        try{
        	Thread.sleep(200);
            String actualUrl = "/dashboard";
            assertTrue(dashboard.getCurrentURL().
                            contains(actualUrl),
                    "Login Failed");
        }
        catch (Exception exp)
        {
            System.out.println(exp);
        }
    }

    @After
    public void afterScenario(){
    	driver.quit();
    }
}