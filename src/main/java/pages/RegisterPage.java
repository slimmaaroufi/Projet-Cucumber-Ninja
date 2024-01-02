package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, 30);
		//firstNameField.sendKeys(firstNameText);
	}
	
	
	public void enterLastName(String lastNameText) {
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, 30);
		//lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, 30);
		//emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, 30);
		//telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, 30);
		//passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordConfirmField, passwordText, 30);
		//passwordConfirmField.sendKeys(passwordText);
	}
	
	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicyOption, 30);
		//privacyPolicyOption.click();
	}
	
	
	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, 30);
		//continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	
	public void selectYesNewsletterOption() {
		elementUtils.clickOnElement(YesToNewsLetterOption, 30);
		//YesToNewsLetterOption.click();
	}
	
	
	public String getWarningMessageText() {
		
		return elementUtils.getTextFromElement(warningMessage, 30);
		//YesToNewsLetterOption.click();
		//return warningMessage.getText();
	}
	
	
	public String getFirstNameWarning() {
		return elementUtils.getTextFromElement(firstNameWarning, 30);
		//return firstNameWarning.getText();
	}
	
	
	public String getLastNameWarning() {
		return elementUtils.getTextFromElement(lastNameWarning, 30);
		//return lastNameWarning.getText();
	}
	
	public String getEmailWarning() {
		return elementUtils.getTextFromElement(emailWarning, 30);
		//return emailWarning.getText();
	}
	

	public String getTelephoneWarning() {
		return elementUtils.getTextFromElement(telephoneWarning, 30);
		//return telephoneWarning.getText();
	}
	
	public String getPasswordWarning() {
		return elementUtils.getTextFromElement(passwordWarning, 30);
		//return passwordWarning.getText();
	}
	
	
}
