
package Testcases;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WorkflowTestcases {
	WebDriverWait wait;
	private WebDriver driver;
	private Locators.WorkFlowLocators WF;
	private ExtentTest test;
	private int approvalstep;
	private int timeallow;
	private int calen;
	private Locators.AssignRole_Locators AR;
	private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
	private Locators.LoginLocators L;
	private Locators.Design_Projects_Locators D;

	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager.loadData(
				"C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public WorkflowTestcases() throws InterruptedException {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.WF = new Locators.WorkFlowLocators(driver);
		this.AR = new Locators.AssignRole_Locators(driver);
		this.D = new Locators.Design_Projects_Locators(driver);
	}

	@Given("I visit the User Login for Design Projects for wf using sheetname {string} and rownumber {int}")
	public void i_visit_the_user_login_for_Design_projects_for_wf_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		String email = testdata.get(rownumber).get("Login Email");
		String password = testdata.get(rownumber).get("Login Password");

		L = new Locators.LoginLocators(driver);
		L.EnterEmail(email);
		L.EnterPassword(password);

	}

	@Given("I enter the credentials in login and click a login button for wf")
	public void i_enter_the_credentials_in_login_and_click_a_login_button_for_wf() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		L.ClickOnLogin();
	}

	@Then("Clicking on Project module under Design section for wf")
	public void clicking_on_project_module_under_design_section_for_wf() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		Thread.sleep(1000);
		D.ClickOnDesignProject();
	}

	@Then("filtering the required project and clickin on it for wf using sheetname {string} and rownumber {int}")
	public void filtering_the_required_project_and_clickin_on_it_for_wf_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws AWTException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
		String projectName = testdata.get(rownumber).get("Project name");
		Thread.sleep(4000);
		AR.EnterOnSearchBox(projectName);
		Thread.sleep(2000);
		AR.clickOnProject(projectName);
	}

	@Then("Clciking on Setting module in newly Created Project under Design module for wf")
	public void clciking_on_setting_module_in_newly_created_project_under_design_module() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
		AR.ClickOnSetting();
	}

	@Then("Creating workflow based on the type selected in the select category of the project using sheetname {string} and rownumber {int}")
	public void creating_workflow_based_on_the_type_selected_in_the_select_category_of_the_project(String sheetname,
			Integer startRownumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		List<Map<String, String>> categoryData = excelDataManager.getCachedData(sheetname);
		int rownumber = startRownumber;

		// Continue to create workflows as long as there is data in the
		// 'SelectTheCategory' column
		while (rownumber < categoryData.size()) {
			Thread.sleep(10000);
			String categoryName = categoryData.get(rownumber).get("SelectTheCategory");

			// Break the loop if "SelectTheCategory" is empty
			if (categoryName == null || categoryName.isEmpty()) {
				break;
			}

			// Step 1: Click on Workflow sub-module under settings in the newly Created
			// Project under Design module
			WF.ClickOnWorkflow();

			// Step 2: Click on Select the category drop-down and select the required
			// category
			WF.ClickOnSelectTheCategoryDropdown();
			WF.selectCategoryFromDropdown(categoryName);

			// Step 3: Click on Add Workflow button
			Thread.sleep(2000);
			WF.ClickOnAddWorkflowButton();

			// Step 4: Select the stepper from the dropdown
			String selectSteps = categoryData.get(rownumber).get("Select Steps");
			if (selectSteps != null && !selectSteps.isEmpty()) {
				WF.ClickOnSelectSteppers();
				WF.selectDropdownOptionSteppersSelection(selectSteps);
			}
			Thread.sleep(3000);
			// Step 5: Enter the valid Name
			String reviewName = categoryData.get(rownumber).get("Name");
			if (reviewName != null && !reviewName.isEmpty()) {
				WF.EnterOnName(reviewName);
			}

			// Step 6: Enter the Description
			String description = categoryData.get(rownumber).get("Description");
			if (description != null && !description.isEmpty()) {
				WF.EnterOnDescription(description);
			}

			// Step 7: Select Workflow Category
			String workflowCategory = categoryData.get(rownumber).get("Workflow category");
			if (workflowCategory != null && !workflowCategory.isEmpty()) {
				WF.ClickOnSelectCategory();
				WF.selectDropdownOptionSelectCategory(workflowCategory);
			}

			// Step 8: Select Status
			String status = categoryData.get(rownumber).get("Status");
			if (status != null && !status.isEmpty()) {
				WF.ClickOnStatus();
				WF.selectDropdownOptionSelectStatus(status);
			}

			// Step 9: Enter the valid Name for Approval
			// Fetch the value for "Name for approval"
			String nameForApproval = categoryData.get(rownumber).get("Name for approval");

			// Check if this is an RFI approval (where "Name for approval" is disabled with
			// default value "Answered")
			if (nameForApproval != null && nameForApproval.equals("Answered")) {
				// Verify that the field contains the default value "Answered"
				String actualValueInField = WF.getApprovalFieldValue(); // Add method to fetch the actual field value

				if (actualValueInField.equals("Answered")) {
					System.out.println(
							"Confirmed that 'Name for Approval' contains 'Answered'. Skipping entry as it's disabled for RFI approval.");
				} else {
					throw new Exception(
							"Expected 'Name for Approval' to be 'Answered' but found: " + actualValueInField);
				}
			} else if (nameForApproval != null && !nameForApproval.isEmpty()) {
				// If not RFI, clear and enter the value as usual
				WF.ClearOnNameForApproval();
				WF.EnterOnNameForApproval(nameForApproval);
			}

			// Retrieve the Editable value from Excel and parse it as an integer
			String editableValue = categoryData.get(rownumber).get("Editable");
			if (editableValue != null && !editableValue.isEmpty()) {
				// Convert the string to an integer, removing any decimal points
				int editableStatus = Integer.parseInt(editableValue.split("\\.")[0]);
				System.out.println(editableStatus + "--->Editable");
				// Check if the editableStatus is 1, then click the checkbox; otherwise, do
				// nothing
				if (editableStatus == 1) {
					WF.ClickOnEditableCheckBox();
				}
			}
			approvalstep = 0;
			timeallow = 0;
			calen = 0;
			// Step 10: Fill in the approval steps from the sheet
			fillApprovalSteps(sheetname, rownumber);

			// Step 11: Click on Create button to create the workflow
			Thread.sleep(2000);

			WF.ClickOnCreateButton();
			Thread.sleep(2000);
			// Move to the next row
			rownumber++;
		}
	}

	public void fillApprovalSteps(String sheetname, int rownumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		// Determine the number of steps based on "Select Steps" column
		String selectSteps = testdata.get(rownumber).get("Select Steps");
		int numberOfSteps = 0;

		// Determine the number of steps dynamically
		if (selectSteps != null) {
			switch (selectSteps) {
			case "One Step Approval":
				numberOfSteps = 1;
				break;
			case "Two Step Approval":
				numberOfSteps = 2;
				break;
			case "Three Step Approval":
				numberOfSteps = 3;
				break;
			case "Four Step Approval":
				numberOfSteps = 4;
				break;
			case "Five Step Approval":
				numberOfSteps = 5;
				break;
			case "Six Step Approval":
				numberOfSteps = 6;
				break;
			case "Seven Step Approval":
				numberOfSteps = 7;
				break;
			}
		}

		// Loop through each step and fill in the required data from the Excel sheet
		for (int step = 1; step <= numberOfSteps; step++) {
			// Dynamically construct the column names based on the step number
			String stepNameColumn = "Step" + step + "Name";
			String userColumn = "Step" + step + "User";
			String userGroup = "Step" + step + "UserGroup";
			String descriptionColumn = "Description" + step;
			String timeallowedColumn = "Step" + step + "Timeallowed";
			String calendarColumn = "Step" + step + "Calendar";
			String autoapprovaldaysColumn = "Step" + step + "AutoApprovalDays";
			String emailtriggerbox = "Step" + step + "Emailtigger";
			String minnoofmemreqd = "Step" + step + "MinimumNoOfMembersRequired";
			String ApprlLimit = "Step" + step + "ApprovalLimit";

			// Fetch data for each step
			String stepName = testdata.get(rownumber).get(stepNameColumn);
			String user = testdata.get(rownumber).get(userColumn);
			String UserGroup = testdata.get(rownumber).get(userGroup);
			String description = testdata.get(rownumber).get(descriptionColumn);
			String timeallowed = testdata.get(rownumber).get(timeallowedColumn);
			String calendar = testdata.get(rownumber).get(calendarColumn);
			String autoapprovaldays = testdata.get(rownumber).get(autoapprovaldaysColumn);
			String emailtrigger = testdata.get(rownumber).get(emailtriggerbox);
			String minmumnoofmemreqd = testdata.get(rownumber).get(minnoofmemreqd);
			String ApprovalLimit = testdata.get(rownumber).get(ApprlLimit);

			// Check if step data is present
			if (stepName != null && !stepName.isEmpty()) {
				// Enter the step name
				WF.enterStepName(step - 1, stepName); // Use (step - 1) as index

				// Handle Select Users if the user is not empty
				if (user != null && !user.isEmpty()) {
					// searchUserFromDropdownForSelectUsersTab(user, step - 1);
					selectDropdownUSERS(user, step - 1);
					Thread.sleep(2000);
				}

				if (UserGroup != null && !UserGroup.isEmpty()) {
					WF.clickOnStepSelectUsersGroups(step - 1);
					Thread.sleep(2000);
					selectDropdownFromMultiUserGroup(UserGroup, step - 1);
					Thread.sleep(2000);
				}

				if (step >= 3 && step <= 7) {
					String stepReviseColumn = "Step" + step + "Revise"; // Assuming you have columns like "Step3Revise",
																		// "Step4Revise", etc.
					System.out.println(stepReviseColumn);
					String stepReviseValue = testdata.get(rownumber).get(stepReviseColumn);

					if (stepReviseValue != null && !stepReviseValue.isEmpty()) {
						if (stepReviseValue != null && stepReviseValue.matches("\\d+\\.0")) {
							stepReviseValue = stepReviseValue.substring(0, stepReviseValue.indexOf(".0"));
							System.out.println("stepReviseValue--->"+stepReviseValue);
							System.out.println("step NO--->"+step);
							Thread.sleep(3000);
							WF.selectStepReviseDropdown(step, stepReviseValue);
						}
					}
				}
				// Handle Description if the description is not empty
				if (description != null && !description.isEmpty()) {
					WF.enterValueInStepDescriptionField(description, step - 1);
				}

				if (minmumnoofmemreqd != null && !minmumnoofmemreqd.isEmpty()) {
					// Convert the string to an integer, removing any decimal points
					int minmumnoofmemreqdStatus = Integer.parseInt(minmumnoofmemreqd.split("\\.")[0]);
					System.out.println(minmumnoofmemreqdStatus + "--->minmumnoofmemreqdStatus");
					// Check if the editableStatus is 1, then click the checkbox; otherwise, do
					// nothing
					if (minmumnoofmemreqdStatus == 1) {
						WF.clickOnMinimumNoOfMembersRequiredRadioBox(minmumnoofmemreqdStatus, step - 1);
						Thread.sleep(2000);
						if (ApprovalLimit != null && ApprovalLimit.matches("\\d+\\.0")) {
							ApprovalLimit = ApprovalLimit.substring(0, ApprovalLimit.indexOf(".0"));
							System.out.println(ApprovalLimit + "--->ApprovalLimit");
							WF.selectDropdownOptionApprovalLimit(ApprovalLimit, step - 1);
						}
					}
				}

				if (timeallowed != null && !timeallowed.isEmpty()) {
					EnterOnTimeAllowed(timeallowed, timeallow);
					timeallow++;
				}

				if (calendar != null && !calendar.isEmpty()) {
					selectDropdownFromCalendar(calendar, calen);
					calen++;
				}

				if (autoapprovaldays != null && !autoapprovaldays.isEmpty()) {
					AutoApprovalDays(autoapprovaldays, approvalstep);
					// ClickOnEmailTrigger(step);
					approvalstep++;
				}

				if (emailtrigger != null && !emailtrigger.isEmpty()) {
					// Convert the string to an integer, removing any decimal points
					int emailtriggerStatus = Integer.parseInt(emailtrigger.split("\\.")[0]);
					System.out.println(emailtriggerStatus + "--->EmailTrigger");
					// Check if the editableStatus is 1, then click the checkbox; otherwise, do
					// nothing
					if (emailtriggerStatus == 1) {
						WF.clickOnEmailTriggerCheckBox(emailtriggerStatus, step - 1);
					}
				}

				String WatchersSelectUsers = testdata.get(rownumber).get("WatchersSelectUsers");
				String WatchersSelectUsersGroup = testdata.get(rownumber).get("WatchersSelectUsersGroup");

				if (WatchersSelectUsers != null && !WatchersSelectUsers.isEmpty()) {
					WF.ClickOnWatchersSelectUserTab();
					Thread.sleep(1000);
					WF.Selectwatcher(WatchersSelectUsers);
					Thread.sleep(1000);
				}

				if (WatchersSelectUsersGroup != null && !WatchersSelectUsersGroup.isEmpty()) {
					WF.ClickOnWatchersSelectUsersGroupsTab();
					Thread.sleep(1000);
					WF.Selectwatchersgroup(WatchersSelectUsersGroup);
					Thread.sleep(1000);
				}

				String WorkflowNotes = testdata.get(rownumber).get("Workflow Notes");
				if (WorkflowNotes != null && !WorkflowNotes.isEmpty()) {
					WF.EnterOnWorkflowNotes(WorkflowNotes);
				}
			}
		}
		Thread.sleep(3000);
	}

//	 public void selectDynamicStepDropdownOption(int stepIndex, String optionText) {
//		    // Ensure the step index is within the range (2 to 7)
//		    if (stepIndex < 2 || stepIndex > 7) {
//		        throw new IllegalArgumentException("Step index must be between 2 and 7.");
//		    }
//
//		    // Construct the dynamic XPath based on the step index
//		    String dropdownXpath = String.format("//*[@id='stepRevise%d']", stepIndex);
//		    System.out.println("Dropdown XPath: " + dropdownXpath); // Debugging output
//
//		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		    try {
//		        // Wait for the dropdown to be visible
//		        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath)));
//
//		        // Scroll to the dropdown if it's not in view
//		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
//
//		        // Wait for the dropdown to be clickable
//		        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
//		        dropdownElement.click(); // Click the dropdown to open it
//
//		        // Wait for the dropdown options to be visible
//		        String optionsXpath = dropdownXpath + "//following-sibling::ul//li"; // Adjust as needed for your HTML structure
//		        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(optionsXpath)));
//
//		        boolean optionFound = false;
//
//		        // Iterate through options and select the matching one
//		        for (WebElement option : options) {
//		            String txt = option.getText().trim(); // Get the text of the option
//		            if (txt.equalsIgnoreCase(optionText)) {
//		                // Use JavaScript to click on the option
//		                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
//		                optionFound = true;
//		                System.out.println("Given Option is Found: " + txt);
//		                break;
//		            }
//		        }
//
//		        if (!optionFound) {
//		            System.out.println("Given Option is not found in the Dropdown List");
//		        }
//
//		    } catch (TimeoutException e) {
//		        System.out.println("Element was not found within the timeout period: " + e.getMessage());
//		    } catch (Exception e) {
//		        System.out.println("An error occurred while selecting the dropdown option: " + e.getMessage());
//		    }
//		}

	public void selectDropdownFromApprovalLimit(String ApprovalLimit, int step) throws Exception {
		String dynamicXPath = "//*[@id='name" + step + "']";
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
		searchField.click();

		List<WebElement> dropdownOptions = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='name" + step + "_options']/li")));
		boolean optionFound = false;
		for (WebElement option : dropdownOptions) {
			String txt = option.getText();
			System.out.println(option);
			System.out.println(txt);

			if (txt.equalsIgnoreCase(ApprovalLimit)) {
				option.click();
				optionFound = true; // Mark that the option was found and clicked
				break;
			}
		}
		if (!optionFound) {
			System.out.println("Given Option '" + ApprovalLimit + "' is not found in the Dropdown List");
		} else {
			System.out.println("Given Option '" + ApprovalLimit + "' is Found and clicked.");
		}
	}

	public void ClickOnEmailTrigger(int step) {
		String dynamicXPath = "(//*[@id='isEmail'])[" + step + "]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed

		WebElement Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
		wait.until(ExpectedConditions.elementToBeClickable(Field)); // Ensure element is clickable

		// Scroll to the element and click with JavaScript Executor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Field);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Field);
	}

	public void EnterOnTimeAllowed(String Time, int timeallow) {
		String dynamicXPath = "//input[@id='timeSlot" + timeallow + "']";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed

		WebElement Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
		wait.until(ExpectedConditions.elementToBeClickable(Field)); // Wait until the element is clickable
		if (Time != null && Time.matches("\\d+\\.0")) {
			Time = Time.substring(0, Time.indexOf(".0"));
		}
		// Scroll to the element to make it visible
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Field);

		// Click, clear, and set value with JavaScript Executor
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Field);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", Field); // Clear existing text
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", Field, Time); // Set the new
																										// value

	}

	public void selectDropdownFromCalendar(String calendar, int calen) {
		String dropdownXPath = "//select[@id='calendar" + calen + "']"; // XPath for the dropdown element
		String optionXPath = dropdownXPath
				+ "//option[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ calendar.toLowerCase() + "')]"; // XPath for the option within the dropdown

		System.out.println(optionXPath);
		System.out.println(optionXPath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

			WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXPath)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", dropdown);

			dropdown.click(); // Open the dropdown
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXPath)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", optionElement);
			optionElement.click();
		} catch (TimeoutException e) {
			System.out.println(
					"The dropdown option '" + calendar + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + calendar + "'. Trying to click via JavaScript.");
			WebElement optionElement = driver.findElement(By.xpath(optionXPath));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		} catch (NoSuchElementException e) {
			System.out.println("The dropdown option for '" + calendar + "' does not exist.");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}

	}

	public void AutoApprovalDays(String Days, int approvalstep) {
		String dynamicXPath = "//input[@id='autoApproval" + approvalstep + "']";
		System.out.println("Attempting to locate: " + dynamicXPath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
		try {
			WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);
			if ((Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].disabled;", field)) {
				throw new TimeoutException("Element not interactable, possibly disabled.");
			}
			wait.until(ExpectedConditions.elementToBeClickable(field));
			System.out.println("Field located and interactable for step " + approvalstep);
			if (Days != null && Days.matches("\\d+\\.0")) {
				Days = Days.substring(0, Days.indexOf(".0"));
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", field);
			((JavascriptExecutor) driver).executeScript("arguments[0].value='';", field); // Clear existing text
			((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", field, Days);

		} catch (NoSuchElementException | TimeoutException e) {
			System.out.println(
					"AutoApprovalDays field not available or interactable for step " + approvalstep + ". Skipping...");
		}

	}

	public void clickOnSelectUser(int stepNumber) {
		try {
			// Construct the dynamic XPath for the 'stepName' field based on the step number
			String stepNameXPath = "//*[@id='stepName" + (stepNumber - 1) + "']";

			System.out.println(stepNameXPath);
			// Locate the WebElement using the dynamic XPath
			WebElement stepNameInput = driver.findElement(By.xpath(stepNameXPath));

			// Wait until the element is clickable and then perform the click
			try {
				wait.until(ExpectedConditions.elementToBeClickable(stepNameInput));
				stepNameInput.click();
			} catch (ElementClickInterceptedException e) {
				System.err.println("Element click intercepted: " + e.getMessage());
				// Optionally, you could retry the click or implement additional logic here if
				// needed
			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
			}
		} catch (NoSuchElementException e) {
			System.err.println("StepName element for step " + stepNumber + " not found: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("An unexpected error occurred while locating the element: " + e.getMessage());
		}
	}

	// Select Users

	public void selectDropdownUSERS(String userName, int step) throws Exception {
		String dynamicXPath = "//ejs-multiselect[@id='multiUser" + step + "']";
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
		searchField.click();

		List<WebElement> dropdownOptions = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='multiUser" + step + "_options']/li")));
		boolean optionFound = false;
		for (WebElement option : dropdownOptions) {
			String txt = option.getText();
			System.out.println(option);
			System.out.println(txt);

			if (txt.equalsIgnoreCase(userName)) {
				option.click();
				optionFound = true; // Mark that the option was found and clicked
				break;
			}
		}
		if (!optionFound) {
			System.out.println("Given Option '" + userName + "' is not found in the Dropdown List");
		} else {
			System.out.println("Given Option '" + userName + "' is Found and clicked.");
		}
	}

	// Select Users GRoups

	public void selectDropdownFromMultiUserGroup(String userName, int step) throws Exception {
		String dynamicXPath = "//ejs-multiselect[@id='multiUserGroup" + step + "']";
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
		searchField.click();

		List<WebElement> dropdownOptions = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='multiUserGroup" + step + "_options']/li")));
		boolean optionFound = false;
		for (WebElement option : dropdownOptions) {
			String txt = option.getText();
			System.out.println(option);
			System.out.println(txt);

			if (txt.equalsIgnoreCase(userName)) {
				option.click();
				optionFound = true; // Mark that the option was found and clicked
				break;
			}
		}
		if (!optionFound) {
			System.out.println("Given Option '" + userName + "' is not found in the Dropdown List");
		} else {
			System.out.println("Given Option '" + userName + "' is Found and clicked.");
		}
	}

}
