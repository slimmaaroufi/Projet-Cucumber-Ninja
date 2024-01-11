package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;



public class ForgotPasswordPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailFiled;
	
	@FindBy(css="input[type='submit'][value='Continue']")
	public static WebElement ContinueButtonForget;
	

	
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailFiled, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	

	public LoginPage clickContinueButtonForgottin() {
		elementUtils.clickOnElement(ContinueButtonForget, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
}
	

	
	
	
}
