package Locators;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Form_Template_Locators {
	
	WebDriver driver;
    WebDriverWait wait;
	
    @FindBy(xpath = "//span[.='Form Template']")
	private WebElement FormTemplate;
    
    @FindBy(xpath = "//*[@id='main']/app-admin-form-management/app-admin-form-list/section/div/div[1]/div/div[2]/button") 
    private WebElement ADDFormTemplate;

    
    @FindBy(xpath = "//input[@placeholder='Enter form name']")
 	private WebElement EnterFormName;

    @FindBy(xpath = "//input[@formcontrolname='fileName']")
 	private WebElement UploadFormTemplatePDF;
    
    @FindBy(xpath = "//button[.=' Create ']")
 	private WebElement ClickCreateButton;
    
    
    
	public Form_Template_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
    
	
	
	public void uploadPDF(String filePath) throws Exception {
            // Ensure the file input is visible and enabled before sending keys
            if (UploadFormTemplatePDF.isDisplayed() && UploadFormTemplatePDF.isEnabled()) {
                UploadFormTemplatePDF.sendKeys(filePath);
            } else {
                System.out.println("File upload element is not accessible.");
            }
        }

	
	public void ClickOnCreateButton() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickCreateButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ClickCreateButton);
			// Perform the click action
			ClickCreateButton.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ClickCreateButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ClickCreateButton);
			ClickCreateButton.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	public void EnterOnFormName(String values) {
		EnterFormName.sendKeys(values);
	}
	
	
	
	
	
	
	public void ClickOnADDFormTemplate() {
		try {
			// Wait for the loading spinner to disappear

			// Wait for the NextStep element to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ADDFormTemplate));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ADDFormTemplate);
			// Perform the click action
			ADDFormTemplate.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ADDFormTemplate));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ADDFormTemplate);
			ADDFormTemplate.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	public void ClickOnFormTemplate() {
	    try {
	        // Wait for the loading spinner to disappear (if applicable)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(FormTemplate));

	        // Perform the click action using JavaScript Executor
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", FormTemplate);
	        jsExecutor.executeScript("arguments[0].click();", FormTemplate);
	        
	    } catch (ElementClickInterceptedException e) {
	        // Handle the exception if the click is intercepted
	        System.err.println("Element click intercepted: " + e.getMessage());
	        
	        // Optionally, wait again for the spinner to disappear and retry clicking
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(FormTemplate));
	        
	        // Retry click with JavaScript Executor
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", FormTemplate);
	        jsExecutor.executeScript("arguments[0].click();", FormTemplate);
	        
	    } catch (Exception e) {
	        // Handle other potential exceptions
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
}
