package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	//Constructeur
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccoubtDropMenu;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li/a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
		
	//@FindBy(xpath="//button[contains(@class,'btn-default']")
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccoubtDropMenu, 30);
	}
	
	public LoginPage selectLoginOption() {
		
		elementUtils.clickOnElement(loginOption, 30);
		//loginOption.click();
		//chauffeur vers pageLogin:redirigé vers la page de connexion
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegsiterOption() {
		elementUtils.clickOnElement(registerOption, 30);
		//registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBox(String productText) {
		elementUtils.typeTextIntoElement(searchBoxField, productText, 30);
		//searchBoxField.sendKeys(productText);
	}
	
	public SearchResultsPage clickOnSearchButton () {
		elementUtils.clickOnElement(searchButton, 30);
		//searchButton.click();
		return new SearchResultsPage(driver);
	}
	
	
}
