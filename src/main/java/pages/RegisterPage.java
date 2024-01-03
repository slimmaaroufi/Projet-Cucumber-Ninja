package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement YesToNewsLetterOption;
	
	
	//@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
		
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public void enterFirstName(String firstNameText) {
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//firstNameField.sendKeys(firstNameText);
	}
	
	
	public void enterLastName(String lastNameText) {
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordConfirmField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordConfirmField.sendKeys(passwordText);
	}
	
	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//privacyPolicyOption.click();
	}
	
	
	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	
	public void selectYesNewsletterOption() {
		elementUtils.clickOnElement(YesToNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//YesToNewsLetterOption.click();
	}
	
	
	public String getWarningMessageText() {
		
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//YesToNewsLetterOption.click();
		//return warningMessage.getText();
	}
	
	
	public String getFirstNameWarning() {
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return firstNameWarning.getText();
	}
	
	
	public String getLastNameWarning() {
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return lastNameWarning.getText();
	}
	
	public String getEmailWarning() {
		return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return emailWarning.getText();
	}
	

	public String getTelephoneWarning() {
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return telephoneWarning.getText();
	}
	
	public String getPasswordWarning() {
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return passwordWarning.getText();
	}
	
	
}
