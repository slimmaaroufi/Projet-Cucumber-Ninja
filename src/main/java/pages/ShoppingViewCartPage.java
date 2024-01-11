package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ShoppingViewCartPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public ShoppingViewCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
			
	}
	
	@FindBy(xpath="//a[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCartTitre;
	
	
	public String getTitreViewShoppingCart() {
		
		return elementUtils.getTextFromElement(shoppingCartTitre, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	
	
	
	
	
	
	
}
