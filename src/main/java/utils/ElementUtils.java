package utils;

import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	//Click on element
	
	public void clickOnElement (WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		
		webElement.click();
		
	}
	
	public void typeTextIntoElement (WebElement element,String textToBeTyped,long durationInSeconds) {
		
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	//Wait For element 
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
				WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
				return wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
				
		}
	
	//select Option In DropDown
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select select=new Select(element);
		select.selectByVisibleText(dropDownOption);
		
	}
	
	//Accept Alert
	public void acceptAlert(long durationInSeconds) {
		
		Alert alert= waitForElement(durationInSeconds);
		alert.accept();
	}
	
	//Dismiss Alert
	public void dismissAlert(long durationInSeconds) {
		Alert alert= waitForElement(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForElement(long durationInSeconds) {
		
		Alert alert=null;
		try 
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert= wait.until(ExpectedConditions.alertIsPresent());
		}
			catch(Throwable e) 
			{
				e.printStackTrace();
			}
	
		return alert;
	}
	
	//Mouse Hover and click element
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
	
		WebElement webElement=null;
		try {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch (Throwable e) {
			
			e.printStackTrace();
		}
		return webElement;
	}
	
	
	// javascriptClick
	
	public void javascriptClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		//JavascriptException js= ((JavascriptException)driver);
		//js.executeScript("arguments[0].click();",webElement);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", webElement);
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds, String textToBeTyped) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
		
	}
	
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {
		
		try 
		{
			WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
			return webElement.isDisplayed();
		}
		catch(Throwable e) 
		{
			return false;
		}
		
	}
	
	
	// scrolling methode
	
	     public void ScrollElement () {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, -700)");
	} 
		
	
}


