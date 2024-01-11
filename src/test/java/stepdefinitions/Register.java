package stepdefinitions;


import java.util.Map;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	//private DriverFactory driverFactory;
	//private HomePage homePage;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		//driverFactory= new DriverFactory();
		driver= DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage =homePage.selectRegsiterOption();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		//registerPage =new RegisterPage(driver);
		
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		commonUtils=new CommonUtils();
		registerPage.enterEmailAddress(commonUtils.getEmailWithTimeStam());
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStam());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}
	
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerPage =new RegisterPage(driver);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailAddress(dataMap.get("email"));
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
/*				
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
*/	
	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		registerPage.selectPrivacyPolicy();
		//driver.findElement(By.name("agree")).click();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountSuccessPage =registerPage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	   
		//AccountSuccessPage accountSuccessPage=new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		registerPage.selectYesNewsletterOption();
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	   		
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	   //Intentionally kept bank
		//registerPage = new RegisterPage(driver);
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmailAddress("");
		registerPage.enterTelephoneNumber("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	    Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
	    Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameWarning());
	    Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameWarning());
	    Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailWarning());
	    Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneWarning());
	    Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordWarning());
	    	   
	}

}
