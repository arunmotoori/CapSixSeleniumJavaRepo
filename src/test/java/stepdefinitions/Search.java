package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.HomePage;
import pageobjects.SearchPage;

public class Search extends Base {
	
	WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	
	@Before("@search")
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		
	}
	
	@After("@search")
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
	@Given("^Open the Application in any browser for searching$")
    public void open_the_application_in_any_browser_for_searching()  {
       
		driver.get(	prop.getProperty("url"));
		
    }

    @When("^I enter valid product into the search box field$")
    public void i_enter_valid_product_into_the_search_box_field()  {
    	
    	homePage = new HomePage(driver);
    	homePage.enterSearchTextIntoSearchField(prop.getProperty("validproduct"));
    	
    }

    @When("^I enter invalid product into the search box field$")
    public void i_enter_invalid_product_into_the_search_box_field()  {
    	
    	homePage = new HomePage(driver);
    	homePage.enterSearchTextIntoSearchField(prop.getProperty("nonexistingproduct"));
        
    }

    @When("^I dont enter any product name into the search box field$")
    public void i_dont_enter_any_product_name_into_the_search_box_field()  {
    	
    	homePage = new HomePage(driver);
    	homePage.enterSearchTextIntoSearchField("");
    	
    }

    @Then("^Searched Product should be displayed in the search results$")
    public void searched_product_should_be_displayed_in_the_search_results()  {
    	
    	Assert.assertTrue(searchPage.verifyTheDisplayOfHpProductInSearchResults());
        
    }

    @Then("^No Product available should be displayed in Search results$")
    public void no_product_available_should_be_displayed_in_search_results()  {
    	
    	Assert.assertEquals(searchPage.retrieveNoProductSearchMessage(),prop.getProperty("noproductinsearchmessage"));
        
    }

    @And("^I click on Search button$")
    public void i_click_on_search_button()  {
    	
    	searchPage = homePage.clickOnSearchButton();
        
    }

}
