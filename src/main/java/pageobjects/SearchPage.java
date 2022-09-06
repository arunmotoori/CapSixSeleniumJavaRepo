package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement hpProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noResultsOnSearchMessage;
		
	public boolean verifyTheDisplayOfHpProductInSearchResults() {
		
		return hpProduct.isDisplayed();
		
	}
	
	public String retrieveNoProductSearchMessage() {
		
		return noResultsOnSearchMessage.getText();
		
	}

}
