package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;



import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PopUPShoppingCartPage;
import pages.ProductPage;
import pages.SearchResultsPage;
import utils.CommonUtils;
import utils.ElementUtils;

public class Orders {

	WebDriver driver;
	private AccountPage accountPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private ProductPage productPage;
	private ElementUtils elementUtils;
	private PopUPShoppingCartPage popUPShoppingCartPage;
	
	
	
	@Given("I login to the application")
	public void i_login_to_the_application() {
	    driver =DriverFactory.getDriver();
	    HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage= homePage.selectLoginOption();

		loginPage.enterEmailAddress("slimtest9@gmail.com");
		loginPage.enterPassword("12345");
		accountPage= loginPage.clickOnloginButton();
		homePage.enterProductIntoSearchBox("HP");
		searchResultsPage= homePage.clickOnSearchButton();
		Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
		
	}

	@When("I add any product to bag and checkout")
	public void i_add_any_product_to_bag_and_checkout() {
		elementUtils = new ElementUtils(driver);
		elementUtils.ScrollElement();
		
		searchResultsPage = new SearchResultsPage(driver);
		productPage =searchResultsPage.clickButtonAddCart();
		
	}

	@When("I place an order")
	public void i_place_an_order() {
		
		productPage.clickItemButton();
		
	}

	@Then("I should see that the order is placed successfully")
	public void i_should_see_that_the_order_is_placed_successfully() throws InterruptedException {
		
		
	      
		Assert.assertEquals("Success: You have added HP LP3065 to your shopping cart!", productPage.getMessageTextProductSuccess());
		Assert.assertTrue(popUPShoppingCartPage.getTotale().contains("$122.00"));
		//System.out.println();
		//Thread.sleep(3000);
	}

	
	
	
}
