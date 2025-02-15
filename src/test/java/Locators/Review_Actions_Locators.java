package Locators;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.jsoup.internal.FieldsAreNonnullByDefault;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Review_Actions_Locators {

	
	WebDriver driver;
	WebDriverWait wait;
	
	
	 @FindBy(xpath = "//span[.='Actions']")
	 private WebElement Actions;
	
	
	 @FindBy(xpath = "//span[.='Review']")
	 private WebElement Review;
	
	 
	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-task/section/div/div[1]/div/div[2]/div/div[2]/button")
	 private WebElement AddButton;


    
	 @FindBy(xpath = "//select[@formcontrolname='parentTaskId']")
	 private WebElement ParentReview;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter review code']")
	 private WebElement ReviewCode;
	 
	 
	 @FindBy(xpath = "//input[@placeholder='Enter review name']")
	 private WebElement ReviewName;
	 
	 
	    @FindBy(xpath = "//textarea[@placeholder='Enter description']")
		private WebElement Description;
	 
	    @FindBy(xpath = "//input[@placeholder='Enter Start Date']")
		private WebElement StartDate; 
	    
	    @FindBy(xpath = "//input[@placeholder='Enter Due Date']")
		private WebElement DueDate;
	    
	    @FindBy(xpath = "//input[@placeholder='Select the workflow']")
	    private WebElement WorkFlow;
	 
	 
	 @FindBy(xpath = "//input[@placeholder='Select the priority']")
	 private WebElement Priority;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter estimate cost']")
	 private WebElement EstimateCost;
	 
	 @FindBy(xpath = "//input[@placeholder='Enter actual cost']")
	 private WebElement ActualCost;
	 
	 
	 @FindBy(xpath = "//input[@formcontrolname='checkListIds']")
	 private WebElement CheckList;
	 
	 @FindBy(xpath = "//button[.=' Attach files ']")
	 private WebElement Attachfiles;
	 
	 


	 
	 @FindBy(xpath = "//input[@placeholder='Search']")
	 private WebElement SearchBoxField;
	 
	 @FindBy(xpath = "//button[.=' Attach ']")
	 private WebElement AttachButton;
	 
	 
	 
	 
//	 @FindBy(xpath = "//*[@id='main']/app-project-management/app-project-task-add-edit/section/div/div[2]/div/div/form/div[1]/app-common-attachment-editor/app-common-file-attach/div[2]/div/div/div[3]/button[2]/text()")
//	 private WebElement AttachButton;

	 
	 
	 @FindBy(xpath = "//button[.=' Create ']")
	 private WebElement CreateButton;
	 
	 
	 @FindBy(xpath="//input[@id='code']")
	 private WebElement suffixcode;
	 
	 
	 
	 
	 
	public Review_Actions_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void ClickOnCreateButton() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(CreateButton));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", CreateButton);
	        CreateButton.click();
	        System.out.println("CreateButton clicked successfully.");
	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());
	        try {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", CreateButton);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CreateButton);
	            System.out.println("CreateButton clicked using JavaScript.");
	        } catch (Exception jsException) {
	            System.err.println("JavaScript click failed: " + jsException.getMessage());
	        }
	    } catch (TimeoutException e) {
	        System.err.println("Timed out waiting for Attach button to be clickable: " + e.getMessage());
	    } catch (NoSuchElementException e) {
	        System.err.println("Create button not found: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}

	
	
	
	
	public void ClickOnAttachButton() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(AttachButton));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AttachButton);
			  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AttachButton);
	        System.out.println("Attach button clicked successfully.");
	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());
	        try {
	        	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AttachButton);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AttachButton);
	            System.out.println("Attach button clicked using JavaScript.");
	        } catch (Exception jsException) {
	            System.err.println("JavaScript click failed: " + jsException.getMessage());
	        }
	        
	    } catch (TimeoutException e) {
	        System.err.println("Timed out waiting for Attach button to be clickable: " + e.getMessage());
	    } catch (NoSuchElementException e) {
	        System.err.println("Attach button not found: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}

	
	
	
	public WebElement findTheRequiredFile(String FileName) {
		  if (FileName == null || FileName.trim().isEmpty()) {
		        System.err.println("File name is empty or null.");
		        return null;
		    }
		// Build dynamic XPath based on the provided file name
	    String dynamicXpath = "//tbody//tr//td[contains(text(),'" + FileName + "')]";
	    try {
	        // Return the located WebElement using the dynamic XPath
	        return driver.findElement(By.xpath(dynamicXpath));
	    } catch (NoSuchElementException e) {
	        System.err.println("File with name '" + FileName + "' not found: " + e.getMessage());
	        return null;
	    }
	}

	public void clickOnRequiredFile(String FileName) {
	    try {
	        WebElement FileElement = findTheRequiredFile(FileName);

	        // Check if the file element was found before proceeding
	        if (FileElement != null) {
	            // Wait until the element is clickable
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.elementToBeClickable(FileElement));
	        //    FileElement.click();
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", FileElement);
	            // Log success and perform the click
	            System.out.println("Clicking on file: " + FileName);
	        } else {
	            System.err.println("Cannot click. The file '" + FileName + "' was not found.");
	        }
	    } catch (TimeoutException e) {
	        System.err.println("Timed out waiting for file '" + FileName + "' to be clickable: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred while clicking the file: " + e.getMessage());
	    }
	}

	  
	
	   public void attachFile(String DocumentName, String FileName) {
	        try {
	            String fileXPath = "//ul//li//a[contains(text(), '" + DocumentName + "')]";
	            System.out.println(fileXPath);
	            WebElement fileElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fileXPath)));
	            fileElement.click();
	            Thread.sleep(2000);
	            String Searchfield = "//input[@placeholder='Search']";
	            WebElement SearchfieldBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Searchfield)));
	            SearchfieldBox.click();
	            Thread.sleep(2000);
	            SearchfieldBox.sendKeys(FileName);
	            Thread.sleep(2000);
		    	Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
	            System.out.println("DocumentName '" + DocumentName + "' attached successfully.");
	        } catch (Exception e) {
	            System.out.println("Error attaching file: " + e.getMessage());
	        }
	    }	
	
	
	
	
	
	
	public void ClickOnAttachFiles() {
		try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Attachfiles));
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Attachfiles);
  			Attachfiles.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Attachfiles));
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Attachfiles);
  			Attachfiles.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
	
	
	public void enterSuffix(String suffix) {
		suffixcode.sendKeys(suffix);
	}
	
	public void EnterOnActualCost(String values) {
		ActualCost.sendKeys(values);
	}
	
	
	public void ClearOnActualCost() {
		ActualCost.clear();
	}
	
	
	
	public void ClickOnActualCost() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(ActualCost));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActualCost);
	        
	        ActualCost.click();
	        System.out.println("Actual cost field clicked successfully.");

	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());

	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActualCost);
	        System.out.println("Actual cost field clicked using JavaScript after interception.");

	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}

	
	
	public void EnterOnEstimateCost(String values) {
		EstimateCost.sendKeys(values);
	}
	
	
	public void ClearOnEstimateCost() {
		EstimateCost.clear();
	}
	
	
	public void ClickOnEstimateCost() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        wait.until(ExpectedConditions.elementToBeClickable(EstimateCost));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", EstimateCost);
	        
	        EstimateCost.click();
	        System.out.println("Estimate cost field clicked successfully.");

	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());

	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", EstimateCost);
	        System.out.println("Estimate cost field clicked using JavaScript after interception.");

	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}

	
	
	
	

	public void selectDropdownOptionForPriority(String optionText) {
	    // Construct the XPath for the option text in a case-insensitive manner
	    String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
	                              + optionText.toLowerCase() + "')]";
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // Wait for the overlay to disappear (if it exists)
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	        // Wait for the dropdown option to be visible and clickable
	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

	        // Scroll the element into view (if needed) and click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
	        
	        // Try clicking via JavaScript as a fallback
	        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	}
	
	
	
	
//	public void selectDropdownOptionForPriority(String optionText) {
//		 String xpathExpression = "//ul[contains(@class, 'e-list-parent')]//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
//                 + optionText.toLowerCase() + "')]";
//
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		 try {
//			 // Wait for the dropdown option to be visible and clickable
//			 WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
//
//			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
//			 optionElement.click();
//		 } catch (TimeoutException e) {
//			 System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
//		 } catch (ElementClickInterceptedException e) {
//			 System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
//
//			 WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
//			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
//}
//
//	}

	
	public void EnterOnPriority(String values) {
		Priority.sendKeys(values);
	}
	
	
	
	public void ClickOnPriority() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(Priority));  // Ensure the element is visible
	        wait.until(ExpectedConditions.elementToBeClickable(Priority));  // Ensure it's clickable
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Priority);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Priority);
	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Priority);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Priority);
	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}

	
	
	
	
	public void EnterOnWorkFlow(String values) {
		WorkFlow.sendKeys(values);
	}
	
	
	
	public void ClickonWorkFlow() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(WorkFlow));  // Wait until visible
	        wait.until(ExpectedConditions.elementToBeClickable(WorkFlow));  // Wait until clickable
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", WorkFlow);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", WorkFlow);
	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", WorkFlow);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", WorkFlow);
	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
	}

	
	
	 public void EnterOnCheckListField(String values) {
		 CheckList.sendKeys(values);
	    }
	
	
	 public void EnterOnEndDate(String values) {
		 DueDate.sendKeys(values);
	    }
	 
	  
	 public void ClearOnEndDate() {
		 DueDate.clear();
	 }
	
	public void ClickOnEndDate() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(DueDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", DueDate);
  			DueDate.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());

  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(DueDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", DueDate);
  			DueDate.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
	
	
	
	 public void EnterOnStartDate(String values) {
	    	StartDate.sendKeys(values);
	    }
	 
	  
    public void ClearOnStartDate() {
    	StartDate.clear();
    }
    
    
    public void ClickOnStartDate() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(StartDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", StartDate);
  			StartDate.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());

  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(StartDate));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", StartDate);
  			StartDate.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
	
	
	public void EnterOnDescription(String values) {
		Description.sendKeys(values);
	}
	
	public void ClearOnDescription() {
		Description.clear();
	}
	
	
	public void EnterOnReviewName(String values) {
		ReviewName.sendKeys(values);
	}
	

	public void EnterOnReviewCode(String values) {
		ReviewCode.sendKeys(values);
	}
	
	
	public void ClearOnReviewCode() {
		ReviewCode.clear();
	}
	
	
	public void selectDropdownOption(String optionText) {
	    // Construct the XPath for the option text in a case-insensitive manner
	    String xpathSelect = "//*[@id='task']"; // Replace with your actual select element XPath

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelect)));

	        selectElement.click();

	        // Construct the XPath for the option within the select element
	        String xpathOption = "//select[@id='task']//option[normalize-space(.)='" + optionText.trim() + "']";

	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOption)));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("Timeout waiting for dropdown option '" + optionText + "' to be clickable.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for dropdown option '" + optionText + "'. Trying to click via JavaScript.");
	        String xpathOption = "//select[@id='task']//option[normalize-space(.)='" + optionText.trim() + "']";
	        WebElement optionElement = driver.findElement(By.xpath(xpathOption));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	}


	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	public void selectDropdownOptionForWorkFlow(String optionText) throws InterruptedException {
	    // Construct the XPath for the option text in a case-insensitive manner
		 String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                 + optionText.toLowerCase() + "')]";

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        Thread.sleep(1000);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");

	        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	} 
	
	
	
	
	
	
	
	
	 public void ClickOnParentReview() {
		 try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(ParentReview));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ParentReview);
				ParentReview.click();
			} catch (ElementClickInterceptedException e) {
				System.err.println("Element click intercepted: " + e.getMessage());

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(ParentReview));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ParentReview);
				ParentReview.click();
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
	 }
	 
	
	 public void ClickOnAddButton() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(AddButton));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddButton);
				AddButton.click();
			} catch (ElementClickInterceptedException e) {
				// Handle the exception if the click is intercepted
				System.err.println("Element click intercepted: " + e.getMessage());

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(AddButton));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddButton);
				AddButton.click();
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
		}
	 
	 
	 
	
	public void ClickOnReview() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Review));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Review);
			Review.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Review));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Review);
			Review.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void ClickOnActions() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Actions));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Actions);
			// Perform the click action
			Actions.click();
		} catch (ElementClickInterceptedException e) {
			// Handle the exception if the click is intercepted
			System.err.println("Element click intercepted: " + e.getMessage());

			// Optionally, wait again for the spinner to disappear and retry clicking
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Actions));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Actions);
			Actions.click();
		} catch (Exception e) {
			// Handle other potential exceptions
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
