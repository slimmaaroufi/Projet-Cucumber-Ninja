package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ProductPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	
	public ProductPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	
	
	@FindBy(xpath="//h1[text()='HP LP3065']")
	private WebElement titleProduct;
	
    @FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
	private WebElement warningSuccessMessageProduct;
	
	@FindBy(id="button-cart")
	private WebElement ItemButtonProduct;
	
	
	public String displayTitleProduct() {
		
		return elementUtils.getTextFromElement(titleProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	
	public String getMessageTextProductSuccess() {
		
		return elementUtils.getTextFromElement(warningSuccessMessageProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	//ajouter page popupitem apres revenir  a faire liraison entre eurx
	
	public PopUPShoppingCartPage clickItemButton() {
		elementUtils.clickOnElement(ItemButtonProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new PopUPShoppingCartPage(driver);
	
	}
	
	

	
	
	
	
	
	
	
	
}
