package StepDefinitions;

import Pages.Dashboard;
import Pages.LoginPage;
import Util.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WorkflowSteps extends BaseTests {

    protected LoginPage loginPage = new LoginPage();

    protected Dashboard dashboard;

    @Given("User with {string} and {string} is logged in")
    public void userWithAndIsLoggedIn(String username, String password) {
       try{
           BaseTests.setup();
           loginPage = new LoginPage();
           loginPage.setUsernameAndPassword(username, password);
           dashboard = loginPage.clickLoginbutton();
       }
       catch (Exception exp){
           System.out.println(exp);
       }
    }

    @When("user is on dashboard")
    public void userIsOnDashboard() {
        try{
            String actualUrl = "/dashboard";
            assertTrue(dashboard.getCurrentURL().
                            contains(actualUrl),
                    "User is not on Dashboard!");
        }
        catch (Exception exp){
            System.out.println(exp);
        }
    }
    
    @Then("Perform steps to add workflow")
    public void perform_steps_to_add_workflow() {
    	dashboard = loginPage.getDriver();
    	dashboard.createWorkflow();
    	System.out.print(dashboard.validateSuccessMessageAppeared());
    	assertEquals(dashboard.validateSuccessMessageAppeared(),
    			"Workflow Away Message (6) added successfully.", 
    			"Workspace publish failed!!");
    }
    
    @After
    public void afterScenario(){
        tearDown();
    }
}