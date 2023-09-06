package StepDefinitions;
import Pages.Homepage;
import Pages.Loginpage;
import Pages.TMpage;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TMFeatureStepDefinition extends CommonDriver

{
    Loginpage loginPageObj = new Loginpage();
    Homepage homePageObj = new Homepage();
    TMpage tmPageObj = new TMpage();

    @Before
    public void LoginActions()
    {
        driver = new ChromeDriver();
    }
    @After
    public void CloseTestRun()
    {
        driver.quit();
    }

    @Given("I logged in to TurnUp portal Successfully")
    public void i_logged_in_to_turn_up_portal_successfully()
    {
        // Write code here that turns the phrase above into concrete actions
        loginPageObj.LoginActions(driver);
    }
    @Given("I navigate to Time and Material page")
    public void i_navigate_to_time_and_material_page()
    {
         // Write code here that turns the phrase above into concrete actions
        homePageObj.GoToTMPage(driver);
    }
    @When("I create a new time record")
    public void i_create_a_new_time_record()
    {
        // // Write code here that turns the phrase above into concrete actions
        tmPageObj.CreateTimeRecord(driver);
    }
    @Then("the record should be created sucessfully")
    public void the_record_should_be_created_sucessfully()
    {
        // Write code here that turns the phrase above into concrete actions
        String newRecord = tmPageObj.GetCode(driver);

        Assert.assertEquals( newRecord ,"August16th","New Record has not been created");
    }
    @When("I update {string} on an existing Time record")
    public void i_update_on_an_existing_time_record(String string)
    {
        // Write code here that turns the phrase above into concrete actions
            tmPageObj.EditTimeRecord(driver,string);
    }
    @Then("the record should have an  updated {string}")
    public void the_record_should_have_an_updated(String string)
    {
        // Write code here that turns the phrase above into concrete actions
        String editedCode = tmPageObj.GetEditedCode(driver);
        Assert.assertEquals(editedCode ,string,"New Record has not been created");
    }
    @When("I delete an existing Time record")
    public void i_delete_an_existing_time_record()
    {
     tmPageObj.DeleteTimeRecord(driver);
    }
    @Then("the record should be deleted successfully")
    public void the_record_should_be_deleted_successfully() {
       String deletedRecord = tmPageObj.GetDeletedCode(driver);
       Assert.assertNotEquals(deletedRecord,"code","Record has not been Deleted");
    }


}
