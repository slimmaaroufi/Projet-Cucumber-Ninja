package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class PopUPShoppingCartPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public PopUPShoppingCartPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//button[@title='Remove']")
	private WebElement removeButton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']/li/p[@class='text-center']")
	private WebElement warningMessageShoppingEmpty;
	
	@FindBy(xpath="//strong[contains(text(), 'Checkout')]")
	private WebElement checkoutButton;
	
	@FindBy(xpath="//strong[contains(text(), 'View Cart')]")
	private WebElement viewCartButton;
	
	
	
	
	public CheckOutPage clickCheckOutButton() {
		elementUtils.clickOnElement(checkoutButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new CheckOutPage(driver);
	
	}
	
	public ShoppingViewCartPage clickViewCartButton() {
		elementUtils.clickOnElement(viewCartButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new ShoppingViewCartPage(driver);
	
	}
	
	public void clickRemoveButton() {
		elementUtils.clickOnElement(removeButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return new ShoppingViewCartPage(driver);
	
	}
	
	public String getMessageTextShoppingEmptySucces() {
		
		return elementUtils.getTextFromElement(warningMessageShoppingEmpty, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	
}
