package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.AccountSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class RegisterTest extends Base {
	
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
	public void registerWithMandatoryFields() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		RegisterPage registerPage = homePage.clickOnRegisterOption();
		registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress(generateNewEmailTimeStamp());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validpassword"));
		registerPage.selectAgree();
		AccountSuccessPage accountSuccessPage = registerPage.clickOnContinueButton();
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessMessage(),prop.getProperty("accountsuccessmessage"));
		
	}
	
	@Test(priority=2)
	public void registerWithAllFields() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		RegisterPage registerPage = homePage.clickOnRegisterOption();
		registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress(generateNewEmailTimeStamp());
		registerPage.enterTelephone(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(prop.getProperty("validpassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.selectAgree();
		AccountSuccessPage accountSuccessPage = registerPage.clickOnContinueButton();
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessMessage(),prop.getProperty("accountsuccessmessage"));
		
	}
	
	

}
