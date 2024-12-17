package Locators;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkFlowLocators {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//span[.='Workflow']")
	private WebElement Workflow;

	@FindBy(xpath = "//*[@id='approvalStep']")
	private WebElement SelectTheCategoryDropdown;

	@FindBy(xpath = "//*[@id='main']/app-project-management/app-project-workflow-list/section/div/div[1]/div/div[2]/button")
	private WebElement AddWorkflowButton;

	// Adding of Steppers for Approval

	@FindBy(xpath = "//select[@formcontrolname='approvalSteps']")
	private WebElement SelectSteppers;

	@FindBy(xpath = "//input[@formcontrolname='reviewName']")
	private WebElement Name;

	@FindBy(xpath = "//*[@id='main']/app-project-management/app-project-document-review/section/div/div[2]/div/form/div[1]/div/div[2]/div[3]/textarea")
	private WebElement Description;

	@FindBy(xpath = "//select[@formcontrolname='category']")
	private WebElement SelectCategory;

	@FindBy(xpath = "//select[@formcontrolname='status']")
	private WebElement Status;

	@FindBy(xpath = "//input[@formcontrolname='nameForApproval']")
	private WebElement NameForApproval;

	// Step1

	@FindBy(xpath = "//input[@id='stepName0']")
	private WebElement StepName1;

	@FindBy(xpath = "//input[@id='stepName1']")
	private WebElement StepName2;

	@FindBy(xpath = "//input[@id='stepName2']")
	private WebElement StepName3;

	@FindBy(xpath = "//input[@id='stepName3']")
	private WebElement StepName4;

	@FindBy(xpath = "//input[@id='stepName4']")
	private WebElement StepName5;

	@FindBy(xpath = "//input[@id='stepName5']")
	private WebElement StepName6;

	@FindBy(xpath = "//input[@id='stepName6']")
	private WebElement StepName7;

	// Select Users Tab

	@FindBy(xpath = "(//button[@id='user-tab'])[1]")
	private WebElement Step1SlectUsers;

	@FindBy(xpath = "(//button[@id='user-tab'])[2]")
	private WebElement Step2SlectUsers;

	@FindBy(xpath = "(//button[@id='user-tab'])[3]")
	private WebElement Step3SlectUsers;

	@FindBy(xpath = "(//button[@id='user-tab'])[4]")
	private WebElement Step4SlectUsers;

	@FindBy(xpath = "(//button[@id='user-tab'])[5]")
	private WebElement Step5SlectUsers;

	@FindBy(xpath = "(//button[@id='user-tab'])[6]")
	private WebElement Step6SlectUsers;

	@FindBy(xpath = "(//button[@id='user-tab'])[7]")
	private WebElement Step7SlectUsers;

	// Select Users Group Tab

	@FindBy(xpath = "(//button[@id='user-group-tab'])")
	private List<WebElement> selectUserGroupTabs;

	@FindBy(xpath = "(//button[@id='user-group-tab'])[1]")
	private WebElement Step1SlectUsersGroups;

	@FindBy(xpath = "(//button[@id='user-group-tab'])[2]")
	private WebElement Step2SlectUsersGroups;

	@FindBy(xpath = "(//button[@id='user-group-tab'])[3]")
	private WebElement Step3SlectUsersGroups;

	@FindBy(xpath = "(//button[@id='user-group-tab'])[4]")
	private WebElement Step4SlectUsersGroups;

	@FindBy(xpath = "(//button[@id='user-group-tab'])[5]")
	private WebElement Step5SlectUsersGroups;

	@FindBy(xpath = "(//button[@id='user-group-tab'])[6]")
	private WebElement Step6SlectUsersGroups;

	@FindBy(xpath = "(//button[@id='user-group-tab'])[7]")
	private WebElement Step7SlectUsersGroups;

	// Selecting search user Field under select users

	@FindBy(xpath = "(//input[@placeholder='Search user'])")
	private List<WebElement> searchUserFields;

	// Selecting search user Field under select users

	@FindBy(xpath = "//ejs-multiselect[@id='multiUserGroup0']")
	private List<WebElement> selectingStepSearchUserGroupFields;

	// Description field in Steppers

	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	private List<WebElement> stepDescriptionFields;

	@FindBy(xpath = "(//textarea[@formcontrolname='description'])[2]")
	private WebElement Step1DescriptionField;

	@FindBy(xpath = "(//textarea[@formcontrolname='description'])[3]")
	private WebElement Step2DescriptionField;

	@FindBy(xpath = "(//textarea[@formcontrolname='description'])[4]")
	private WebElement Step3DescriptionField;

	@FindBy(xpath = "(//textarea[@formcontrolname='description'])[5]")
	private WebElement Step4DescriptionField;

	@FindBy(xpath = "(//textarea[@formcontrolname='description'])[6]")
	private WebElement Step5DescriptionField;

	@FindBy(xpath = "(//textarea[@formcontrolname='description'])[7]")
	private WebElement Step6DescriptionField;

	@FindBy(xpath = "(//textarea[@formcontrolname='description'])[8]")
	private WebElement Step7DescriptionField;

	// Email Trigger

	@FindBy(xpath = "(//*[@id='isEmail'])[1]")
	private WebElement EmailTrigger1;

	@FindBy(xpath = "(//*[@id='isEmail'])[2]")
	private WebElement EmailTrigger2;

	@FindBy(xpath = "(//*[@id='isEmail'])[3]")
	private WebElement EmailTrigger3;

	@FindBy(xpath = "(//*[@id='isEmail'])[4]")
	private WebElement EmailTrigger4;

	@FindBy(xpath = "(//*[@id='isEmail'])[5]")
	private WebElement EmailTrigger5;

	@FindBy(xpath = "(//*[@id='isEmail'])[6]")
	private WebElement EmailTrigger6;

	@FindBy(xpath = "(//*[@id='isEmail'])[7]")
	private WebElement EmailTrigger7;

	@FindBy(xpath = "//input[@id='isEditable']")
	private WebElement Editable;

	@FindBy(xpath = "//input[@id='min0']")
	private WebElement MinimumNoOfMemRqd1;

	@FindBy(xpath = "//input[@id='min1']")
	private WebElement MinimumNoOfMemRqd2;

	@FindBy(xpath = "//input[@id='min2']")
	private WebElement MinimumNoOfMemRqd3;

	@FindBy(xpath = "//input[@id='min3']")
	private WebElement MinimumNoOfMemRqd4;

	@FindBy(xpath = "//input[@id='min4']")
	private WebElement MinimumNoOfMemRqd5;

	@FindBy(xpath = "//input[@id='min5']")
	private WebElement MinimumNoOfMemRqd6;

	@FindBy(xpath = "//input[@id='min6']")
	private WebElement MinimumNoOfMemRqd7;

	// Watchers

	@FindBy(xpath = "//label[contains(text(), 'Watchers')]/following::ul[@id='myTab']//button[@formcontrolname='selectedUsers' and contains(text(), 'Select users')]")
	private WebElement WatchersSelectUsersTab;

	@FindBy(xpath = "//label[contains(text(), 'Watchers')]/following::ul[@id='myTab']//button[@formcontrolname='selectedUserGroups' and contains(text(), 'Select user groups')]")
	private WebElement WatchersSelectUsersGroupsTab;

	@FindBy(xpath = "//ejs-multiselect[@id='multiUser']")
	private WebElement watchersclick;

	@FindBy(xpath = "//ul[@id='multiUser_options']/li")
	private List<WebElement> watcherslist;

	@FindBy(xpath = "//ejs-multiselect[@id='multiUserGroup']")
	private WebElement watchersgroupclick;

	@FindBy(xpath = "//ul[@id='multiUserGroup_options']/li")
	private List<WebElement> watchersgrouplist;

	@FindBy(xpath = "//textarea[@formcontrolname='notes']")
	private WebElement WorkflowNotes;

	@FindBy(xpath = "//*[@id='stepRevise2']")
	private WebElement StepToRevise3;

	@FindBy(xpath = "//*[@id='stepRevise3']")
	private WebElement StepToRevise4;

	@FindBy(xpath = "//*[@id='stepRevise4']")
	private WebElement StepToRevise5;

	@FindBy(xpath = "//*[@id='stepRevise5']")
	private WebElement StepToRevise6;

	@FindBy(xpath = "//*[@id='stepRevise6']")
	private WebElement StepToRevise7;

	@FindBy(xpath = "//ul[@class='form-select mx-2 ng-untouched ng-pristine ng-valid']/li")
	private WebElement StepToReviseFieldList;

	@FindBy(xpath = "//button[.=' Create ']")
	private WebElement Create;

	public WorkFlowLocators(WebDriver driver) {
		// initialize elements
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		PageFactory.initElements(driver, this);
	}

	public void selectStepReviseDropdown(int step, String stepReviseValue) {
		WebElement stepDropdown = null;

		// Select the appropriate dropdown WebElement based on the step number
		switch (step) {
		case 3:
			stepDropdown = StepToRevise3;
			break;
		case 4:
			stepDropdown = StepToRevise4;
			break;
		case 5:
			stepDropdown = StepToRevise5;
			break;
		case 6:
			stepDropdown = StepToRevise6;
			break;
		case 7:
			stepDropdown = StepToRevise7;
			break;
		default:
			// Handle cases where the step is less than 3
			System.out.println("Step " + step + " does not have a dropdown associated.");
			return;
		}

		selectDropdownOption(stepDropdown, stepReviseValue); // Pass the numeric value
	}

//	public void selectDropdownOption(WebElement dropdown, String value) {
// 		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
//	    // Assuming that the dropdown options are listed and can be found by their values
//	    List<WebElement> options = driver.findElements(By.xpath("//option")); // Adjust this XPath as necessary
//	    for (WebElement option : options) {
//	        if (option.getText().equals(value)) {
//	            option.click();
//	            break;
//	        }
//	    }
//	}

	public void selectDropdownOption(WebElement dropdown, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);

		// Use an XPath that handles case insensitivity for numerical values
		String xpathExpression = ".//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ value.toLowerCase() + "')]";

		// Find the option using the constructed XPath
		List<WebElement> options = dropdown.findElements(By.xpath(xpathExpression));

		// If options are found, click on the first match
		if (!options.isEmpty()) {
			options.get(0).click();
		} else {
			System.out.println("No option found with value: " + value);
		}
	}

	public void EnterOnWorkflowNotes(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement WorkflowNotesField = wait.until(ExpectedConditions.elementToBeClickable(WorkflowNotes));
		WorkflowNotesField.clear();
		WorkflowNotesField.sendKeys(value);
	}

	public void Selectwatcher(String watcherName) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(watchersclick));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", watchersclick);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(watchersclick));
				watchersclick.click();
			} catch (Exception e) {
				System.out.println("Regular click failed, using JavaScript click.");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchersclick);
			}
			wait.until(ExpectedConditions.visibilityOfAllElements(watcherslist));
			selectDropdown(watcherslist, watcherName);
		} catch (Exception e) {
			System.out.println("Error in Selectwatcher: " + e.getMessage());
		}
	}

	public void Selectwatchersgroup(String watchersGroup) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(watchersgroupclick));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", watchersgroupclick);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(watchersgroupclick));
				watchersgroupclick.click();
			} catch (Exception e) {
				System.out.println("Regular click failed, using JavaScript click.");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchersgroupclick);
			}

			wait.until(ExpectedConditions.visibilityOfAllElements(watchersgrouplist));
			selectDropdown(watchersgrouplist, watchersGroup);
		} catch (Exception e) {
			System.out.println("Error in Selectwatcher: " + e.getMessage());
		}
	}

	public void selectDropdown(List<WebElement> elements, String compareText) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		boolean optionFound = false;
		for (WebElement element : elements) {
			wait.until(ExpectedConditions.visibilityOf(element));
			String txt = element.getText().trim();

			if (txt.equalsIgnoreCase(compareText)) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.click();
					System.out.println("Given option is found and selected: " + compareText);
					optionFound = true;
					break;
				} catch (Exception e) {
					System.out.println("Error clicking element: " + e.getMessage());
				}
			}
		}

		if (!optionFound) {
			System.out.println("Given option is not found in the dropdown list: " + compareText);
		}
	}

	public void ClickOnWatchersSelectUserTab() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WatchersSelectUsersTab));
			WatchersSelectUsersTab.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WatchersSelectUsersTab));
			WatchersSelectUsersTab.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnWatchersSelectUsersGroupsTab() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WatchersSelectUsersGroupsTab));
			WatchersSelectUsersGroupsTab.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(WatchersSelectUsersGroupsTab));
			WatchersSelectUsersGroupsTab.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void selectDropdownOptionApprovalLimit(String approvalLimit, int step) {
		String selectXPath = "//select[@id='name" + step + "']/option[text()=" + approvalLimit + "]";
		System.out.println(selectXPath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectXPath)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();
		} catch (TimeoutException e) {
			System.out.println(
					"The dropdown option '" + approvalLimit + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out
					.println("Element click intercepted for '" + approvalLimit + "'. Trying to click via JavaScript.");
			WebElement optionElement = driver.findElement(By.xpath(selectXPath));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

	public void clickOnMinimumNoOfMembersRequiredRadioBox(int value, int stepNumber) {
		WebElement buttonToClick = null;
		switch (stepNumber) {
		case 0:
			buttonToClick = MinimumNoOfMemRqd1;
			break;
		case 1:
			buttonToClick = MinimumNoOfMemRqd2;
			break;
		case 2:
			buttonToClick = MinimumNoOfMemRqd3;
			break;
		case 3:
			buttonToClick = MinimumNoOfMemRqd4;
			break;
		case 4:
			buttonToClick = MinimumNoOfMemRqd5;
			break;
		case 5:
			buttonToClick = MinimumNoOfMemRqd6;
			break;
		case 6:
			buttonToClick = MinimumNoOfMemRqd7;
			break;
		default:
			System.err.println("Invalid step number: " + stepNumber);
			return;
		}

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonToClick);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonToClick);

		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonToClick);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonToClick);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnEditableCheckBox() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Editable));
			Editable.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Editable));
			Editable.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void clickOnEmailTriggerCheckBox(int value, int stepNumber) {
		WebElement buttonToClick = null;
		switch (stepNumber) {
		case 0:
			buttonToClick = EmailTrigger1;
			break;
		case 1:
			buttonToClick = EmailTrigger2;
			break;
		case 2:
			buttonToClick = EmailTrigger3;
			break;
		case 3:
			buttonToClick = EmailTrigger4;
			break;
		case 4:
			buttonToClick = EmailTrigger5;
			break;
		case 5:
			buttonToClick = EmailTrigger6;
			break;
		case 6:
			buttonToClick = EmailTrigger7;
			break;
		default:
			System.err.println("Invalid step number: " + stepNumber);
			return;
		}

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonToClick);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonToClick);

		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonToClick);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonToClick);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnCreateButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Create));
			Create.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Create));
			Create.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	// Steppers fields

	// Sending values to Description field
	public void enterValueInStepDescriptionField(String description, int stepIndex) {
		switch (stepIndex) {
		case 0:
			Step1DescriptionField.sendKeys(description);
			break;
		case 1:
			Step2DescriptionField.sendKeys(description);
			break;
		case 2:
			Step3DescriptionField.sendKeys(description);
			break;
		case 3:
			Step4DescriptionField.sendKeys(description);
			break;
		case 4:
			Step5DescriptionField.sendKeys(description);
			break;
		case 5:
			Step6DescriptionField.sendKeys(description);
			break;
		case 6:
			Step7DescriptionField.sendKeys(description);
			break;
		default:
			throw new IllegalArgumentException("Invalid step number: " + stepIndex);
		}
	}

	// Sending values to Search User Group Field under Select user Group field

	public void searchUserFromDropdownForSelectUserGroupTab(String userGroupName, int step) {

		if (step < 1 || step > selectingStepSearchUserGroupFields.size()) {
			throw new IllegalArgumentException(
					"Step must be between 1 and " + selectingStepSearchUserGroupFields.size());
		}

		String userGroupOptionXPath = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ userGroupName.toLowerCase() + "') and not(contains(@class, 'hidden'))]";

		try {
			WebElement userGroupTab = selectUserGroupTabs.get(step - 1);
			wait.until(ExpectedConditions.visibilityOf(userGroupTab));
			userGroupTab.click();
			WebElement searchField = selectingStepSearchUserGroupFields.get(step - 1); // Adjust for zero-based index
			wait.until(ExpectedConditions.visibilityOf(searchField));
			searchField.clear();
			searchField.sendKeys(userGroupName);

			WebElement optionElement = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(userGroupOptionXPath)));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();

		} catch (TimeoutException e) {
			System.out.println("The dropdown option '" + userGroupName + "' for step " + step
					+ " is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + userGroupName + "' on step " + step
					+ ". Trying to click via JavaScript.");
			WebElement optionElement = driver.findElement(By.xpath(userGroupOptionXPath));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

	// Method to enter values in the search user group fields dynamically
	public void enterValueInSearchUserGroupField(String values, int step) {
		if (step < 1 || step > selectingStepSearchUserGroupFields.size()) {
			throw new IllegalArgumentException(
					"Step must be between 1 and " + selectingStepSearchUserGroupFields.size());
		}
		WebElement searchField = selectingStepSearchUserGroupFields.get(step - 1); // Adjust for zero-based index
		searchField.clear();
		searchField.sendKeys(values);
	}

	// Sending values to Search User field under select user tab

	public void searchUserFromDropdownForSelectUsersTab(String userName, int step) throws InterruptedException {
		String searchFieldXPath;
		if (step == 1) {
			// For step 1, use the direct XPath
			searchFieldXPath = "//input[@placeholder='Search user']";
		} else {
			// For subsequent steps, use the indexed XPath
			searchFieldXPath = "(//input[@placeholder='Search user'])[" + (step - 1) + "]";
		}

		System.out.println("Using search field XPath: " + searchFieldXPath);

		// Construct the dynamic XPath for the user option
		String userOptionXPath = "//li[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ userName.toLowerCase() + "')]";

		try {
			// Locate the search field for the specified step using the XPath
			WebElement searchField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchFieldXPath)));

			searchField.clear();
			Thread.sleep(3000); // Adjust the wait time if necessary
			searchField.sendKeys(userName);

			Thread.sleep(500); // You can replace this with an explicit wait if needed

			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userOptionXPath)));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();
		} catch (TimeoutException e) {
			System.out.println("The dropdown option '" + userName + "' for step " + step
					+ " is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + userName + "' on step " + step
					+ ". Trying to click via JavaScript.");
			try {
				WebElement optionElement = driver.findElement(By.xpath(userOptionXPath));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
			} catch (NoSuchElementException ex) {
				System.out.println("The dropdown option '" + userName + "' could not be found after intercept.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Search field for step " + step + " is not found.");
		}
	}

	// Method to enter values in the search fields dynamically
	public void enterValueInSearchUserField(String values, int step) {
		if (step < 1 || step > searchUserFields.size()) {
			throw new IllegalArgumentException("Step must be between 1 and " + searchUserFields.size());
		}
		WebElement searchField = searchUserFields.get(step - 1); // Adjust for zero-based index
		searchField.clear();
		searchField.sendKeys(values);
	}

	// Select Users Group Tab

	public void clickOnStepSelectUsersGroups(int stepNumber) {
		WebElement buttonToClick = null;
		switch (stepNumber) {
		case 0:
			buttonToClick = Step1SlectUsersGroups;
			break;
		case 1:
			buttonToClick = Step2SlectUsersGroups;
			break;
		case 2:
			buttonToClick = Step3SlectUsersGroups;
			break;
		case 3:
			buttonToClick = Step4SlectUsersGroups;
			break;
		case 4:
			buttonToClick = Step5SlectUsersGroups;
			break;
		case 5:
			buttonToClick = Step6SlectUsersGroups;
			break;
		case 6:
			buttonToClick = Step7SlectUsersGroups;
			break;
		default:
			System.err.println("Invalid step number: " + stepNumber);
			return;
		}

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonToClick);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonToClick);

		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			wait.until(ExpectedConditions.elementToBeClickable(buttonToClick));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonToClick);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonToClick);
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	// Select user Tab

	public void clickOnSelectUsers(int stepNumber) {
		WebElement userTab = null;

		// Select the appropriate WebElement based on the step number
		switch (stepNumber) {
		case 1:
			userTab = Step1SlectUsers;
			break;
		case 2:
			userTab = Step2SlectUsers;
			break;
		case 3:
			userTab = Step3SlectUsers;
			break;
		case 4:
			userTab = Step4SlectUsers;
			break;
		case 5:
			userTab = Step5SlectUsers;
			break;
		case 6:
			userTab = Step6SlectUsers;
			break;
		case 7:
			userTab = Step7SlectUsers;
			break;
		default:
			throw new IllegalArgumentException("Invalid step number: " + stepNumber);
		}

		// Click on the selected user tab
		try {
			wait.until(ExpectedConditions.elementToBeClickable(userTab));
			userTab.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			// Optionally, you could retry the click or implement additional logic here
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	// Step name
	public void enterStepName(int stepIndex, String value) {
		switch (stepIndex) {
		case 0:
			StepName1.sendKeys(value);
			break;
		case 1:
			StepName2.sendKeys(value);
			break;
		case 2:
			StepName3.sendKeys(value);
			break;
		case 3:
			StepName4.sendKeys(value);
			break;
		case 4:
			StepName5.sendKeys(value);
			break;
		case 5:
			StepName6.sendKeys(value);
			break;
		case 6:
			StepName7.sendKeys(value);
			break;
		default:
			throw new IllegalArgumentException("Invalid step index: " + stepIndex);
		}
	}

	// General Info - Workflow Steppers

	public void EnterOnNameForApproval(String values) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement NameForApprovals = wait.until(ExpectedConditions.elementToBeClickable(NameForApproval));
		NameForApprovals.sendKeys(values);

	}

	public String getApprovalFieldValue() {
		return NameForApproval.getAttribute("value");
	}

	public void ClearOnNameForApproval() {
		NameForApproval.clear();
	}

	public void ClickOnStatus() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Status));
			Status.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Status));
			Status.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void selectDropdownOptionSelectStatus(String optionText) {
		String xpathExpression = "//select[@formcontrolname='status']/option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ optionText.toLowerCase() + "')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();
		} catch (TimeoutException e) {
			System.out.println(
					"The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
			WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

	public void selectDropdownOptionSelectCategory(String optionText) {
		String xpathExpression = "//select[@formcontrolname='category']/option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ optionText.toLowerCase() + "')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();

		} catch (TimeoutException e) {
			System.out.println(
					"The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");
			WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

	public void ClickOnSelectCategory() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectCategory));
			SelectCategory.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectCategory));
			SelectCategory.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void EnterOnDescription(String values) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Descriptions = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Descriptions.sendKeys(values);
	}

	public void EnterOnName(String values) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Names = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Names.sendKeys(values);
	}

	public void selectDropdownOptionSteppersSelection(String optionText) {
		String xpathExpression = "//select//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ optionText.toLowerCase() + "')]";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();

		} catch (TimeoutException e) {
			System.out.println(
					"The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");

			WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

	public void ClickOnSelectSteppers() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectSteppers));
			SelectSteppers.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectSteppers));
			SelectSteppers.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	// workflow

	public void selectCategoryFromDropdown(String categoryName) {
		// Construct the XPath for the category option
		String xpathExpression = "//*[@id='approvalStep']//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ categoryName.toLowerCase() + "')]"; // Adjust according to actual HTML structure

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();
		} catch (TimeoutException e) {
			System.out.println(
					"The dropdown option '" + categoryName + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + categoryName + "'. Trying to click via JavaScript.");
			WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

	public void ClickOnAddWorkflowButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddWorkflowButton));

			AddWorkflowButton.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(AddWorkflowButton));
			AddWorkflowButton.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnSelectTheCategoryDropdown() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectTheCategoryDropdown));

			SelectTheCategoryDropdown.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(SelectTheCategoryDropdown));
			SelectTheCategoryDropdown.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public void ClickOnWorkflow() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Workflow));

			Workflow.click();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click intercepted: " + e.getMessage());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Workflow));
			Workflow.click();
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		}
	}

}
