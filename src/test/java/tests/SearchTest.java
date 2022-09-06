package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.HomePage;
import pageobjects.SearchPage;

public class SearchTest extends Base {
	
	public WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {
		
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
	@Test(priority=1)
	public void searchWithValidProductName() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterSearchTextIntoSearchField(prop.getProperty("validproduct"));
		SearchPage searchPage = homePage.clickOnSearchButton();
	
		Assert.assertTrue(searchPage.verifyTheDisplayOfHpProductInSearchResults());

	}
	
	@Test(priority=2)
	public void searchWithInvalidProductName() {
		HomePage homePage = new HomePage(driver);
		homePage.enterSearchTextIntoSearchField(prop.getProperty("nonexistingproduct"));
		SearchPage searchPage = homePage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.retrieveNoProductSearchMessage(),prop.getProperty("noproductinsearchmessage"));
	
	}
	
	@Test(priority=3)
	public void searchByNotProvidingAnyProductName() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterSearchTextIntoSearchField("");
		SearchPage searchPage = homePage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.retrieveNoProductSearchMessage(),prop.getProperty("noproductinsearchmessage"));
		
	}

}
