package stepdefinitions;



import org.junit.Assert;

import org.openqa.selenium.WebDriver;





import factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		
		driver= DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		//liaison:methode once you navigate to the login page using
		//la page de connexion est égale à la page d'accueil point sélectionnez l'option de connexion
		loginPage= homePage.selectLoginOption();	
	
	}
	//ajouter les symboles suivants pour scenario outline:(.+)^$
	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		//loginPage =new LoginPage(driver);
		loginPage.enterEmailAddress(emailText);
		
		//driver.findElement(By.id("input-email")).sendKeys(emailText);
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		
		loginPage.enterPassword(passwordText);
		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
	
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountPage= loginPage.clickOnloginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	   /* Assertion is true is displayed*/
		//accountPage=new AccountPage(driver);
		
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	
	}
	
	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		//loginPage =new LoginPage(driver);
		commonUtils=new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStam());
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStam());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
	}
	
	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	    		
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	
	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		//loginPage =new LoginPage(driver);
		loginPage.enterEmailAddress("");
		//driver.findElement(By.id("input-email")).sendKeys("");
	}
	
	

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		
		
		loginPage.enterPassword("");
		//driver.findElement(By.id("input-password")).sendKeys("");
	}
	
	@When("User enters valid email address {string} into email field in the login page")
	public void user_enters_valid_email_address_into_email_field_in_the_login_page(String emailText) {
		loginPage.enterEmailAddress(emailText);
	}
	
	
	
}
