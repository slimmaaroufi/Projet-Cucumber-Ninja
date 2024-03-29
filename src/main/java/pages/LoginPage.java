package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailFiled;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	//Forgotten Password
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement warningMessageForgottenPassword;
	
	@FindBy(xpath="//a[text()='Forgotten Password']")
	private WebElement forgottenPassword;
	
	
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailFiled, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//emailFiled.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordField.sendKeys(passwordText);
		
	}
	
	public AccountPage clickOnloginButton() {
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//loginButton.click();
		return new AccountPage(driver);
	}
	
	
	public String getWarningMessageText() {
		
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return warningMessage.getText();
		
	}
	
	// action Forgotten Password
	public ForgotPasswordPage clickforgottenPassword() {
		elementUtils.clickOnElement(forgottenPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new ForgotPasswordPage(driver);
	}
	
	// message Forgotten Password
	public String getwarningMessageForgottenPassword() {
		return elementUtils.getTextFromElement(warningMessageForgottenPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
}
