package Locators;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChecklistLocators {

	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//span[.='Check List']")
	private WebElement CheckList;
	
	
	@FindBy(xpath = "//*[@id='main']/app-project-management/app-project-check-list/section/div/div[1]/div/div[2]/div/div[2]/button")
	private WebElement AddButton;


	@FindBy(xpath = "//input[@placeholder='Enter code']")
	private WebElement CheckListCode;
	
	@FindBy(xpath = "//input[@placeholder='Enter checklist name']")
	private WebElement CheckListTitle;
	
	@FindBy(xpath = "//input[@placeholder='Enter name']")
	private WebElement EnterName;
	
//	@FindBy(xpath = "//input[@placeholder='Select the category']")
//	private WebElement SelectTheCategory;
	
	
	
	@FindBy(xpath="//app-multiselect[@name='Category']//ejs-dropdownlist[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement Categoryclick;
	
	@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> Categoryselect;
	
	
	@FindBy(xpath = "//input[@placeholder='Select the priority']")
	private WebElement Priority;
	
	 @FindBy(xpath = "//textarea[@placeholder='Enter description']")
	 private WebElement Description;
	
	
	 @FindBy(xpath = "//button[.=' Add Row ']")
	 private WebElement AddRow;
	 
	 
	 
	 
	 
	 
		FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2));
	 
	 
	 
	public ChecklistLocators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		PageFactory.initElements(driver, this);
	}
	
	
	//
	
	public void prioritydropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(Categoryclick));
		Categoryclick.click();
	}
	
	public void SelectPrioritydropdown(String type) {
		try {
			selectDropdown(Categoryselect, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void selectDropdown(List<WebElement>t,String comparetxt) throws Exception {
		List<WebElement> elements=t;
		Thread.sleep(2000);
		for(WebElement s:elements) {
			String txt=s.getText();
			if(txt.equalsIgnoreCase(comparetxt)) {
				s.click();
				break;	
			}
			else {
				System.out.println("Given Option is not found in the Dropdown List");
			}
		}
		System.out.println("Given Option is Found ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ClickOnAddRow() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(AddRow)); 
			wait.until(ExpectedConditions.elementToBeClickable(AddRow));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddRow);
 			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddRow);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddRow));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddRow);
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddRow);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	public void EnterOnDescription(String values) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try {
	            WebElement Descriptions = wait.until(ExpectedConditions.elementToBeClickable(Description));
	            Descriptions.sendKeys(values);
	        } catch (ElementNotInteractableException | TimeoutException e) {
	            System.out.println("Standard sendKeys failed, attempting with JavaScriptExecutor.");
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].value = arguments[1];", Description, values);
	        }
	}
	
	
	public void ClearOnDescription() {
		Description.clear();
	}
	
	
	
	
	
	public void EnterOnPriority(String values) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try {
	            WebElement Prioritys = wait.until(ExpectedConditions.elementToBeClickable(Priority));
	            Prioritys.sendKeys(values);
	        } catch (ElementNotInteractableException | TimeoutException e) {
	            System.out.println("Standard sendKeys failed, attempting with JavaScriptExecutor.");
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].value = arguments[1];", Priority, values);
	        }
	}
	
	
	
	public void ClickOnPriority() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(Priority)); 
			wait.until(ExpectedConditions.elementToBeClickable(Priority));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Priority);
 			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Priority);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Priority));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Priority);
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Priority);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	

	public void selectDropdownOptionForPriority(String optionText) {
	    String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
	                              + optionText.toLowerCase() + "')]";
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
	        optionElement.click();
	    } catch (TimeoutException e) {
	        System.out.println("The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
	        WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	    }
	}
	
	
//	public void selectDropdownOptionForPriority(String optionText) {
//		 String xpathExpression = "//ul[contains(@class, 'e-list-parent')]//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
//                + optionText.toLowerCase() + "')]";
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
	

	   public void selectDropdownOptionSelectTheCategory(String optionText) {
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
	

//	public void EnterOnSelectTheCategory(String values) {
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        try {
//	            WebElement Category = wait.until(ExpectedConditions.elementToBeClickable(SelectTheCategory));
//	            Category.sendKeys(values);
//	        } catch (ElementNotInteractableException | TimeoutException e) {
//	            System.out.println("Standard sendKeys failed, attempting with JavaScriptExecutor.");
//	            JavascriptExecutor js = (JavascriptExecutor) driver;
//	            js.executeScript("arguments[0].value = arguments[1];", SelectTheCategory, values);
//	        }
//	}
	
	
	
//	public void ClickOnSelectTheCategory() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOf(SelectTheCategory)); 
//			wait.until(ExpectedConditions.elementToBeClickable(SelectTheCategory));
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SelectTheCategory);
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", SelectTheCategory);
//		} catch (ElementClickInterceptedException e) {
//			System.err.println("Element click intercepted: " + e.getMessage());
//
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(SelectTheCategory));
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SelectTheCategory);
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", SelectTheCategory);
//		} catch (Exception e) {
//			System.err.println("An unexpected error occurred: " + e.getMessage());
//		}
//	}
//	
	
	
	
	
	public void EnterOnName(String values) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(EnterName));
            Name.sendKeys(values);
        } catch (ElementNotInteractableException | TimeoutException e) {
            System.out.println("Standard sendKeys failed, attempting with JavaScriptExecutor.");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = arguments[1];", EnterName, values);
        }
    }

	public void ClearOnName() {
		EnterName.clear();
	}
	
	
	public void EnterOnCheckListTitle(String values) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement Title = wait.until(ExpectedConditions.elementToBeClickable(CheckListTitle));
		    Title.sendKeys(values);
	}
	
	
	
	public void EnterOnCheckListCode(String values) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement Code = wait.until(ExpectedConditions.elementToBeClickable(CheckListCode));
		    Code.sendKeys(values);
	}
	
	
	
	
	public void ClickOnAddButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(AddButton)); 
			wait.until(ExpectedConditions.elementToBeClickable(AddButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddButton);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddButton);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddButton));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AddButton);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddButton);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	public void ClickOnCheckList() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(CheckList)); 
			wait.until(ExpectedConditions.elementToBeClickable(CheckList));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", CheckList);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", CheckList);
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CheckList));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", CheckList);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", CheckList);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//
	
	
	private WebElement getDynamicElement(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void enterDynamicName(String name, int index) {
        String nameXpath = String.format("(//input[@placeholder='Enter name'])[%d]", index);
        WebElement nameElement = getDynamicElement(nameXpath);
        nameElement.clear();
        nameElement.sendKeys(name);
    }

    public void selectDynamicCategory(String category, int index) throws InterruptedException {
        String categoryXpath = String.format("(//input[@placeholder='Select the category'])[%d]", index);
        WebElement categoryElement = getDynamicElement(categoryXpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", categoryElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", categoryElement);
        Thread.sleep(2000);
        categoryElement.sendKeys(category);
//        selectDropdownOption(category, categoryXpath);
      //  selectDropdownOption(category);
    }

    public void enterDynamicPriority(String priority, int index) throws InterruptedException {
        String priorityXpath = String.format("(//input[@placeholder='Select the priority'])[%d]", index);
        WebElement priorityElement = getDynamicElement(priorityXpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", priorityElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", priorityElement);
        Thread.sleep(2000);
        priorityElement.sendKeys(priority);
    //    selectDropdownOption(priority, priorityXpath);
     //   selectDropdownOption(priority);
    }

    public void enterDynamicDescription(String description, int index) {
        String descriptionXpath = String.format("(//textarea[@placeholder='Enter description'])[%d]", index);
        WebElement descriptionElement = getDynamicElement(descriptionXpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptionElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", descriptionElement);
        descriptionElement.clear();
        descriptionElement.sendKeys(description);
    }

//    private void selectDropdownOption(String optionText, String dropdownXpath) {
//        String optionXpath = dropdownXpath + String.format("//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]", optionText.toLowerCase());
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
//        } catch (Exception e) {
//            System.out.println("Unable to select dropdown option: " + e.getMessage());
//        }
//    }
	
	
//    private void selectDropdownOption(String optionText, String dropdownXpath) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        try {
//            // Wait for the dropdown to be visible
//            WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath)));
//
//            // Use Select class to handle the dropdown
//            Select dropdown = new Select(dropdownElement);
//
//            // Convert the option text to lower case for case-insensitive matching
//            String optionToSelect = optionText.toLowerCase();
//
//            // Find the option based on the text
//            List<WebElement> options = dropdown.getOptions();
//            for (WebElement option : options) {
//                if (option.getText().toLowerCase().equals(optionToSelect)) {
//                    dropdown.selectByVisibleText(option.getText());
//                    break; // Break once the desired option is selected
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.println("Unable to select dropdown option: " + e.getMessage());
//        }
//    }
//    
    
    
    
    
    
    private void selectDropdownOption(String optionText, String dropdownXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement dropdownInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownInput);
            String optionsXpath = dropdownXpath + "//following-sibling::ul//li"; // Adjust this based on your HTML structure
            List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(optionsXpath)));
            boolean optionFound = false;
            for (WebElement option : options) {
                String txt = option.getText();
                if (txt.equalsIgnoreCase(optionText)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option); // Use JavaScript click for the option
                    optionFound = true;
                    System.out.println("Given Option is Found: " + txt);
                    break;
                }
            }
            if (!optionFound) {
                System.out.println("Given Option is not found in the Dropdown List");
            }
        } catch (Exception e) {
            System.out.println("Unable to select dropdown option: " + e.getMessage());
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
//    private void selectDropdownOption(String optionText) {
//        String optionXpath = String.format("//following-sibling::ul//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]", optionText.toLowerCase());
//        
//     //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
//        } catch (Exception e) {
//            System.out.println("Unable to select dropdown option: " + e.getMessage());
//        }
//    }
	
	
	
	
//    private void selectDropdownOption(String optionText, String dropdownXpath) {
//        String optionXpath = String.format("//following-sibling::ul//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]", optionText.toLowerCase());
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time
//        try {
//            // Click the dropdown to open it
//            WebElement dropdown = driver.findElement(By.xpath(dropdownXpath));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
//          //  dropdown.click();  // Click to open the dropdown
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
//            // Wait for the option to be visible
//            
//            Thread.sleep(1000);
//            WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
//
//            // Log the state of the option before clicking
//            System.out.println("Trying to click on option: " + optionXpath);
//            System.out.println("Is displayed: " + optionElement.isDisplayed());
//            System.out.println("Is enabled: " + optionElement.isEnabled());
//
//            // Use JavaScript to click the option directly
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
//        } catch (Exception e) {
//            System.out.println("Unable to select dropdown option: " + e.getMessage());
//        }
//    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
