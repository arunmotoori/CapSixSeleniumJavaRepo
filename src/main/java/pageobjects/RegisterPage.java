package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement agreeField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	private WebElement yesNewsletterOption;

	
	public void enterFirstName(String firstNameText) {
		
		firstNameField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		
		lastNameField.sendKeys(lastNameText);
		
	}
	
	public void enterEmailAddress(String emailAddressText) {
		
		emailAddressField.sendKeys(emailAddressText);
		
	}
	
	public void enterTelephone(String telephoneText) {
		
		telephoneField.sendKeys(telephoneText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
		
	}
	
	public void enterPasswordConfirm(String passwordText) {
		
		confirmPasswordField.sendKeys(passwordText);
		
	}
	
	public void selectYesNewsletterOption() {
		
		yesNewsletterOption.click();
		
	}
	
	public void selectAgree() {
		
		agreeField.click();
		
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		
		continueButton.click();
		return new AccountSuccessPage(driver);
		
	}

}
