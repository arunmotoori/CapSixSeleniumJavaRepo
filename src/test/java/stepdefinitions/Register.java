package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.AccountSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class Register extends Base {
	
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	@Before("@register")
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		
	}
	
	@After
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
	@Given("^Open the Application in any browser for registration$")
    public void open_the_application_in_any_browser_for_registration()  {
		
		driver.get(prop.getProperty("url"));
       
    }

    @When("^I enter all the details into the fields$")
    public void i_enter_all_the_details_into_the_fields(DataTable dataTable)  {
    	
    	Map<String,String> map = dataTable.asMap();
    	
    	registerPage.enterFirstName(map.get("firstname"));
    	registerPage.enterLastName(map.get("lastname"));
    	registerPage.enterEmailAddress(generateNewEmailTimeStamp());
    	registerPage.enterTelephone(map.get("phone"));
    	registerPage.enterPassword(map.get("password"));
    	registerPage.enterPasswordConfirm(map.get("password"));
        
    }

    @Then("^New User Account should get created$")
    public void new_user_account_should_get_created()  {
    	
    	Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessMessage(),prop.getProperty("accountsuccessmessage"));
        
    }

    @And("^I navigate to Register Account page$")
    public void i_navigate_to_register_account_page()  {
    	
    	homePage = new HomePage(driver);
    	homePage.clickOnMyAccountDropMenu();
    	registerPage = homePage.clickOnRegisterOption();
        
    }

    @And("^I select Privacy Policy checkbox field$")
    public void i_select_privacy_policy_checkbox_field()  {
    	
    	registerPage.selectAgree();
        
    }

    @And("^I click on Continue button$")
    public void i_click_on_continue_button()  {
    	
    	accountSuccessPage = registerPage.clickOnContinueButton();
        
    }

}
