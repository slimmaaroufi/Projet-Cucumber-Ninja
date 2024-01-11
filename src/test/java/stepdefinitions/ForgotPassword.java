package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;

public class ForgotPassword {
	WebDriver driver;
	private LoginPage loginPage;
	private ForgotPasswordPage forgotPasswordPage;
	
	
	@When("^User clicks on MyAccount$")
	public void user_clicks_on_my_account() {
	    System.out.println(">>User clicks on MyAccount");
	    driver= DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		
	}

	@And("^Selects login option$")
	public void selects_login_option() {
		System.out.println(">>Selects login option");
		HomePage homePage=new HomePage(driver);
		loginPage= homePage.selectLoginOption();
	}

	@And("^Click on Forgotten Password option$")
	public void click_on_forgotten_password_option() {
		System.out.println(">>\"Click on Forgotten Password option");
		loginPage = new LoginPage (driver);
		loginPage.clickforgottenPassword();
	}
	
	@When("Enters valid email address {string}")
	public void enters_valid_email_address(String textEmailValid) {
		System.out.println(">>\"Enters valid email address {adressMailText}");
		loginPage.enterEmailAddress(textEmailValid);
	}
	
	// return message Forgotten Password
	@Then("^Proper confirmation message should be displayed$")
	public void proper_confirmation_message_should_be_displayed() {
		System.out.println(">>\"Proper confirmation message should be displayed");
		Assert.assertTrue(loginPage.getwarningMessageForgottenPassword().contains("An email with a confirmation link has been sent your email address."));
	}
	

	@And("User clicks on Continue")
	public void User_clicks_on_Continue() {
		forgotPasswordPage = new ForgotPasswordPage(driver);
		loginPage =forgotPasswordPage.clickContinueButtonForgottin();
		
	}

	
	
}
