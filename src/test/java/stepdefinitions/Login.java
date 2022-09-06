package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;


public class Login extends Base {
	
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@After("@login")
	public void tearDown() {
		
		if(driver!=null) {
			
			driver.quit();
		}
		
	}
	
	@Before("@login")
	public void setup() throws IOException {
		
		driver = initializeBrowser();	
		
	}
	
	
	@Given("^Open the Application in any browser$")
    public void open_the_application_in_any_browser()  {
       
		driver.get(	prop.getProperty("url"));
		
    }
	
	@And("^Navigate to Login page$")
    public void navigate_to_login_page() {
		
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		loginPage = homePage.clickOnLoginOption();
        
    }

	@When("^User enters valid credentials into the email and password fields$")
	public void user_enters_valid_credentials_into_the_email_and_password_fields()  {
	        
		loginPage.enterEmailAddress(prop.getProperty("validemail"));
		loginPage.enterPassword(prop.getProperty("validpassword"));
		
	}
	
	@When("^User enters invalid credentials into the email and password fields$")
    public void user_enters_invalid_credentials_into_the_email_and_password_fields() {
		
		loginPage.enterEmailAddress(generateNewEmailTimeStamp());
		loginPage.enterPassword(prop.getProperty("invalidpassword"));
    }
	
	@And("^User clicks on Login button$")
    public void user_clicks_on_login_button()  {
		
		accountPage = loginPage.clickOnLoginButton();
        
    }

    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login()  {
    	
    	Assert.assertTrue(accountPage.verifyDisplayOfEditYourAccountInformationOption());
        
    }

    @Then("^Verify user login is unsuccessfull$")
    public void verify_user_login_is_unsuccessfull(){
    	
    	Assert.assertTrue(loginPage.retrieveInvalidCredentailsWarningMessage().contains(prop.getProperty("invalidcredentailswarning")));
        
    }

    @When("^User enters username say \"([^\"]*)\" and password say \"([^\"]*)\" into the fields$")
    public void user_enters_username_and_password_into_the_fields(String username, String password)  {
        
    	loginPage.enterEmailAddress(username);
    	loginPage.enterPassword(password);
    	
    }

    @Then("^Verify login status \"([^\"]*)\" of the User$")
    public void verify_login_status_something_of_the_user(String loginstatus)  {
    	
    	boolean actualLoginStatus = false;
    	
    	if(loginstatus.equals("success")) {
    		
    		actualLoginStatus = true;
    		
    	}else if(loginstatus.equals("failure")) {
    		
    		actualLoginStatus = false;
    	
    	}
    	
    	if(actualLoginStatus) {
    		
        	Assert.assertTrue(accountPage.verifyDisplayOfEditYourAccountInformationOption());

    	}else {
    		
    		Assert.assertTrue(loginPage.retrieveInvalidCredentailsWarningMessage().contains(prop.getProperty("invalidcredentailswarning")));
    		
    	}
       
    }

    
}
