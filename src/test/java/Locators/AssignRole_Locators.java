package Locators;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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

public class AssignRole_Locators {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	private WebElement SearchBox;                                // search box to find the project
	
	
//    @FindBy(xpath = "//tbody//tr//td//a[contains(text(),'\" + projectName + \"')]")
//  	private WebElement FindTheRequiredProject;  
//  

    //Assing Role
    
    @FindBy(xpath = "//span[.='Setting']")
    private WebElement Setting; 
  
    @FindBy(xpath = "//span[.='Assign Role']")
    private WebElement AssignRole; 
  
    @FindBy(xpath = "//*[@id='btnAssignProjectUser']")
    private WebElement assignRoleButton;

//    @FindBy(xpath = "//input[@placeholder='Select the role']")
//    private WebElement SelectTheRole;
    
    @FindBy(xpath = "//*[@id='assignProjectUserModal']/div/div/div[2]/div/div/form/div[1]/div[1]/app-input/div/select")
    private WebElement SelectTheRole;
    
    
    @FindBy(xpath = "//input[@placeholder='Select users']")
    private WebElement AddUser;
    
    
	@FindBy(xpath="//ejs-multiselect[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement userdropdownclick;
	
	
	@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> userlist;
    

	
    @FindBy(xpath = "//button[.=' Assign ']")
    private WebElement AssignButton;
    
    
    //Assign Role for Group
    
    
    @FindBy(xpath = "//button[.=' Assign Role For Group ']")
    private WebElement AssignRoleForGroupTab;
    
    @FindBy(xpath = "//*[@id='btnAssignProjectUserGroup']")
    private WebElement AssignRoleForGroupButton;

//    @FindBy(xpath = "//input[@placeholder='Select the role']")
//    private WebElement SelectTheRoleForGroup;
    
    @FindBy(xpath = "//*[@id='assignUserGroupModal']/div/div/div[2]/div/div/form/div[1]/div[1]/app-input/div/select")
    private WebElement SelectTheRoleForGroup;
    
    
	
    @FindBy(xpath = "//input[@formcontrolname='selectedUserGroups']")
    private WebElement Addgroup;
    
    @FindBy(xpath="//ejs-multiselect[starts-with(@id,'ej2_dropdownlist')]")
	private WebElement usergroupdropdownclick;
	
	@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> usergrouplist;
	
	FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2));
	

    public AssignRole_Locators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	 
    public void selectRole(String role) {
		Select ss= new Select(SelectTheRole);
		ss.selectByVisibleText(role);
	}
	
    public void selectroleforgroup(String role) {
		Select ss= new Select(SelectTheRoleForGroup);
		ss.selectByVisibleText(role);
	}
    
    
	public void selectUser(String val) {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       // wait.until(ExpectedConditions.visibilityOfAllElements(userlist)); 
			selectDropdown(userlist, val);
		} catch (Exception e) {
			System.out.println("User is not found :"+e.getMessage());
		}
	}
    
	
	public void selectuserGroup(String val) {
		try {
			//usergroupdropdownclick.click();
			selectDropdown(usergrouplist, val);
		} catch (Exception e) {
			System.out.println("UserGroup is not found :"+e.getMessage());
		}
	}
	  
	public void selectDropdown(List<WebElement>t,String comparetxt) throws Exception {
		List<WebElement> elements=t;
		Thread.sleep(2000);
		for(WebElement s:elements) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", s);
			if(s.isDisplayed() && s.isEnabled()) {
			String txt=s.getText();
			
			if(txt.equalsIgnoreCase(comparetxt)) {
				s.click();
				//((JavascriptExecutor) driver).executeScript("arguments[0].click();", s);
				break;	
			}
			else {
				System.out.println("Given Option is not found in the Dropdown List");
			}} else {
				System.out.println("====================Element is not displayed & enabled===========");
			}
		}
		System.out.println("Given Option is Found ");
	}
 		
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public void selectDropdownUSERS(String userName) throws Exception {
//		String dynamicXPath = "//*[@id='ej2_dropdownlist_10']";
//		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
//	    searchField.click();
//	    
//	    List<WebElement> dropdownOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ej2_dropdownlist_10']/li")));
//	    boolean optionFound = false;
//	    for (WebElement option : dropdownOptions) {
//	        String txt = option.getText();
//	        System.out.println(option);
//	        System.out.println(txt);
//	       
//	        if (txt.equalsIgnoreCase(userName)) {
//	        	 option.click();
//	            optionFound = true; // Mark that the option was found and clicked
//	            break;
//	        }
//	    }
//	    if (!optionFound) {
//	        System.out.println("Given Option '" + userName + "' is not found in the Dropdown List");
//	    } else {
//	        System.out.println("Given Option '" + userName + "' is Found and clicked.");
//	    }
//	}
    
    
    
    
    
    
    
    
  public void selectUserFromDropdownForAddGroup(String userName) {
        String xpathExpression = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
                + userName.toLowerCase() + "')]"; // Adjust according to actual HTML structure
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
            optionElement.click();
        } catch (TimeoutException e) {
            System.out.println("The dropdown option '" + userName + "' is not found or not clickable within the timeout.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted for '" + userName + "'. Trying to click via JavaScript.");
            WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
        }
    }    
    
    
    
    
    public void ClickOnAddGroup() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(usergroupdropdownclick));

  			usergroupdropdownclick.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());

  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(usergroupdropdownclick));
  			usergroupdropdownclick.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    public void selectDropdownOptionForRoleGroup(String optionText) {
    	 String xpathExpression = "//*[@id='roleId']//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
                 + optionText.toLowerCase() + "')]";
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
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

    
    
    
    public void ClickOnSelectTheRoleInGroup() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SelectTheRoleForGroup));

  			SelectTheRoleForGroup.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SelectTheRoleForGroup));
  			SelectTheRoleForGroup.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}	
    }
    
    
    
    
    
    public void ClickOnAssignRoleForGroupButton() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRoleForGroupButton));

  			// Perform the click action
  			AssignRoleForGroupButton.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRoleForGroupButton));
  			AssignRoleForGroupButton.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    public void ClickOnAssignRoleForGroupTab() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRoleForGroupTab));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AssignRoleForGroupTab);
  			//AssignRoleForGroupTab.click();
  			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AssignRoleForGroupTab);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRoleForGroupTab));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AssignRoleForGroupTab);
  			//AssignRoleForGroupTab.click();
 			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AssignRoleForGroupTab);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    
    
    
    
    
    //Assign Role
    
    
    public void ClickOnAssignButton() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(AssignButton)); 
  			wait.until(ExpectedConditions.elementToBeClickable(AssignButton));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AssignButton);
  		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AssignButton);
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.visibilityOf(AssignButton)); 
  			wait.until(ExpectedConditions.elementToBeClickable(AssignButton));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AssignButton);
  			((JavascriptExecutor) driver).executeScript("arguments[0].click();", AssignButton);
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
	}
    
    
    
    
    
    
    
    public void selectUserFromDropdownForAddUser(String userName) {
        
        // Construct the XPath for the user option
        String xpathExpression = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
                + userName.toLowerCase() + "')]"; // Adjust according to actual HTML structure

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown option to be visible and clickable
            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

            // Scroll the option into view and click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
            optionElement.click();
        } catch (TimeoutException e) {
            System.out.println("The dropdown option '" + userName + "' is not found or not clickable within the timeout.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted for '" + userName + "'. Trying to click via JavaScript.");
            WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
        }
    }
    
    
    
    
    
    
    
    
    public void EnterOnAddUser(String values) {
    	AddUser.sendKeys(values);
    }
    
    
    
    
    public void ClickOnAddUser() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(userdropdownclick));
  			userdropdownclick.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(userdropdownclick));
  			userdropdownclick.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}	
    }
    
    
    
    public void ClickOnSelectTheRole() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SelectTheRole));
  			SelectTheRole.click();
  		} catch (ElementClickInterceptedException e) {
  			System.err.println("Element click intercepted: " + e.getMessage());
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(SelectTheRole));
  			SelectTheRole.click();
  		} catch (Exception e) {
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}	
    }
    
    
    
    
    public void ClickOnAssignRoleButton() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(assignRoleButton));

  			// Perform the click action
  			assignRoleButton.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(assignRoleButton));
  			assignRoleButton.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    } 
    
    
    
    
    public void ClickOnAssignRole() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRole));

  			// Perform the click action
  			AssignRole.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(AssignRole));
  			AssignRole.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    
    } 
    
    
	
    public void ClickOnSetting() {
    	try {
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Setting));

  			// Perform the click action
  			Setting.click();
  		} catch (ElementClickInterceptedException e) {
  			// Handle the exception if the click is intercepted
  			System.err.println("Element click intercepted: " + e.getMessage());

  			// Optionally, wait again for the spinner to disappear and retry clicking
  			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  			wait.until(ExpectedConditions.elementToBeClickable(Setting));
  			Setting.click();
  		} catch (Exception e) {
  			// Handle other potential exceptions
  			System.err.println("An unexpected error occurred: " + e.getMessage());
  		}
    }
    
    
    
    public WebElement findTheRequiredProject(String projectName) {
        String dynamicXpath = "//tbody//tr//td//a[contains(text(),'" + projectName + "')]";
        return driver.findElement(By.xpath(dynamicXpath));
    }
    
    
    public void clickOnProject(String projectName) throws InterruptedException {
        WebElement projectElement = findTheRequiredProject(projectName);
     	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectElement);
        wait.until(ExpectedConditions.elementToBeClickable(projectElement));
        Thread.sleep(2000);
        System.out.print(projectName);
        projectElement.click();
    } 
    
    
    
    
    public void EnterOnSearchBox(String values) throws AWTException, InterruptedException {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SearchBox);
    	wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
    	SearchBox.sendKeys(values);
    	Thread.sleep(2000);
    	Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    
    public void ClickOnSearchBox() {
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", SearchBox);
	        
	    } catch (ElementClickInterceptedException e) {
	        System.err.println("Element click intercepted: " + e.getMessage());
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(SearchBox));
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", SearchBox);
	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	    }
    }
    
    
    
    public void selectDropdownOptionForRole(String optionText) {
        // Construct the XPath for the option text in a case-insensitive manner
    	 String xpathExpression = "//*[@id='roleId']//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
                 + optionText.toLowerCase() + "')]";
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown options to become clickable
            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

            // Scroll the element into view and click
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

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
