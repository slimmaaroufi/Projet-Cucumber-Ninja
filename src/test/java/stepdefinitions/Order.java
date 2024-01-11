package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class Order {
	WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private ProductPage productPage;
	
	
	
	@And("I add any product to bag and checkout")
	public void i_add_any_product_to_bag_and_checkout() {
		searchResultsPage = new SearchResultsPage(driver);
		productPage=searchResultsPage.clickButtonAddCart();
	}

	
	@And("Verify the title {string}")
	public void verify_the_title(String titleProductText) {
		//Assert.assertTrue(productPage.displayTitleProduct());
		//Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
		Assert.assertTrue(productPage.displayTitleProduct().contains("HP LP3065"));
		//Assert.assertEquals("HP LP3065", productPage.displayTitleProduct());
	}

	@And("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() {
		
		productPage.clickItemButton();
	}
	

	@Then("I should see that the order is placed and get a successfully message")
	public void i_should_see_that_the_order_is_placed_and_get_a_successfully_message() {
		
		Assert.assertEquals("Success: You have added HP LP3065 to your shopping cart!", productPage.getMessageTextProductSuccess());
		
		
	}
}
