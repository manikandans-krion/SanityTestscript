package Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Roles_Locators {

	WebDriver driver;
    WebDriverWait wait;
    
	@FindBy(xpath = " //span[.='Role']")
	private WebElement Role;
	
	@FindBy(xpath = "(//button[@type='button'])[1]")
	private WebElement ADDRoleButton;
	
	@FindBy(xpath = "//input[@placeholder='Enter role name']")
	private WebElement EnterRoleName;
	
	@FindBy(xpath = "//*[@id='main']/app-role-management/app-role-add-edit/section/div/div[2]/div/div/form/div[1]/div[2]/div/input")
	private WebElement SelectAllOptions;

	@FindBy(xpath = "//button[.=' Create ']")
	private WebElement ClickCreateButton;
	
	
	
	
	
	
	
	
    
	public Roles_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	public void ClickOnCreateButton() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickCreateButton));

			// Perform the click action
			ClickCreateButton.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickCreateButton));
			ClickCreateButton.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	

	public void ClickOnSelectAllOptions() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectAllOptions));

			// Perform the click action
			SelectAllOptions.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectAllOptions));
			SelectAllOptions.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	public void EnterOnRoleName(String values) {
		EnterRoleName.sendKeys(values);
	}
	
	

	
	public void ClickOnADDRole() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ADDRoleButton));

			// Perform the click action
			ADDRoleButton.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ADDRoleButton));
			ADDRoleButton.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void ClickOnRole() {
	    try {
	        // Wait for the loading spinner to disappear (if applicable)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(Role));

	        // Perform the click action using JavaScript Executor
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", Role);
	        
	    } catch (ElementClickInterceptedException e) {
	        // Handle the exception if the click is intercepted
	        System.err.println("Element click intercepted: " + e.getMessage());
	        
	        // Optionally, wait again for the spinner to disappear and retry clicking
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(Role));
	        
	        // Retry click with JavaScript Executor
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", Role);
	        
	    } catch (Exception e) {
	        // Handle other potential exceptions
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    
}
