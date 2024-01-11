package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class CheckOutPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
			
	}
	
	@FindBy(xpath="//h1[text()='Checkout']")
	private WebElement checkoutTitre;
	
	
	public String getTitreCheckOut() {
		
		return elementUtils.getTextFromElement(checkoutTitre, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	
	
	
	
	
	
	
	
}
