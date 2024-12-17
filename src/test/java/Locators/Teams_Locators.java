package Locators;


import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Teams_Locators {

	WebDriver driver;
    WebDriverWait wait;
	
    @FindBy(xpath = "//span[.='Teams']")
	private WebElement Teams;
	
    @FindBy(xpath = "//*[@id='main']/app-team-management/app-team-list/section/div/div[1]/div/div[2]/button")
    private WebElement ClickAddTeam;

    @FindBy(xpath = "//input[@placeholder='Enter team name']")
    private WebElement EnterTeamName;
	
    @FindBy(xpath = "//input[@placeholder='Enter Team code']")
    private WebElement EnterTeamCode;
	
    @FindBy(xpath = "//button[.=' Create ']")
	private WebElement ClickCreateButton;
    

    
    
    
	public Teams_Locators(WebDriver driver) {
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
	
	
	
	
	
	public void EnterOnTeamCode(String values) {
		EnterTeamCode.sendKeys(values);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void EnterOnTeamName(String values) {
		EnterTeamName.sendKeys(values);
	}
	
	

	
	public void ClickOnADDTeam() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickAddTeam));

			// Perform the click action
			ClickAddTeam.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickAddTeam));
			ClickAddTeam.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	public void ClickOnTeams() {
	    try {
	        // Wait for the loading spinner to disappear (if applicable)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(Teams));

	        // Perform the click action using JavaScript Executor
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", Teams);
	        
	    } catch (ElementClickInterceptedException e) {
	        // Handle the exception if the click is intercepted
	        System.err.println("Element click intercepted: " + e.getMessage());
	        
	        // Optionally, wait again for the spinner to disappear and retry clicking
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(Teams));
	        
	        // Retry click with JavaScript Executor
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", Teams);
	        
	    } catch (Exception e) {
	        // Handle other potential exceptions
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
