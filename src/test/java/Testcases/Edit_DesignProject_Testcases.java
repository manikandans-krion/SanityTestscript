package Testcases;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class Edit_DesignProject_Testcases {

	private WebDriver driver;
	private Locators.LoginLocators L;
	private Locators.Edit_Design_Projects_Locators D;
	private Locators.Edit_Review_Locators R;
	private Locators.Edit_RFA_Locators RFA;
	private Locators.Edit_Meeting_Locators MET;
	private Locators.Edit_BOM_BOQ_Locators BOM;
	private Locators.Edit_Checklist_Locators Chk;
	private ExtentTest test;
	private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager.loadData(
				"C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public Edit_DesignProject_Testcases() throws InterruptedException {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.D = new Locators.Edit_Design_Projects_Locators(driver);
		this.R = new Locators.Edit_Review_Locators(driver);
		this.RFA = new Locators.Edit_RFA_Locators(driver);
		this.MET = new Locators.Edit_Meeting_Locators(driver);
		this.BOM = new Locators.Edit_BOM_BOQ_Locators(driver);
		this.Chk = new Locators.Edit_Checklist_Locators(driver);
	}

	/*
	 * @Given("I visit the User Login for Design Projects using sheetname {string} and rownumber {int}"
	 * ) public void
	 * i_visit_the_user_login_for_Design_projects_using_sheetname_and_rownumber(
	 * String sheetname, Integer rownumber) throws Exception { try {
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 * List<Map<String, String>> testdata =
	 * excelDataManager.getCachedData(sheetname);
	 * 
	 * String email = testdata.get(rownumber).get("Login Email"); String password =
	 * testdata.get(rownumber).get("Login Password");
	 * 
	 * if (password.matches("\\d+(\\.\\d+)?")) { // Check if password is numeric
	 * password = password.replaceAll("\\.0$", ""); // Remove the decimal if it's a
	 * whole number }
	 * 
	 * L = new Locators.LoginLocators(driver); L.EnterEmail(email);
	 * L.EnterPassword(password);
	 * 
	 * LoginInputDatas("Email", email); LoginInputDatas("Password", password); }
	 * catch (Exception e) { ExceptionHandler exceptionHandler = new
	 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	 * exceptionHandler.handleException(e, "Login Page"); throw e; } }
	 * 
	 * @Given("I enter the credentials in login and click a login button") public
	 * void i_enter_the_credentials_in_login_and_click_a_login_button() { try {
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 * L.ClickOnLogin();
	 * 
	 * } catch (Exception e) { ExceptionHandler exceptionHandler = new
	 * ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	 * exceptionHandler.handleException(e, "Login Page"); throw e; } }
	 * 
	 * 
	 */

	// Filtering the Required Project to Edit

	@Then("Changing the required fields in Project using sheetname {string} and rownumber {int}")
	public void chaning_the_required_fields_in_project(String sheetname, int rownumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
		Thread.sleep(3000);
		D.ClickOnDesignProject();
		String OldProjectCode = testdata.get(rownumber).get("Old Project code");
		Thread.sleep(4000);
		D.clickOnActionButtonForProject(OldProjectCode);

	}

	@Then("Choosing whether to Update ISO project or Non-ISO project using sheetname {string} and rownumber {int}")
	public void choosing_whether_to_update_iso_project_or_non_iso_project_using_sheetname_and_rownumber(String string,
			Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		try {

			String WithOrWithoutISOProject = testdata.get(int1).get("With or Without ISO Project");
			if (WithOrWithoutISOProject != null && !WithOrWithoutISOProject.isEmpty()) {
				int WithOrWithoutISOProjectStatus = Integer.parseInt(WithOrWithoutISOProject.split("\\.")[0]);
				System.out.println(WithOrWithoutISOProjectStatus + "--->WithOrWithoutISOProjectStatus");
				if (WithOrWithoutISOProjectStatus == 1) {
					Thread.sleep(1000);
					D.ClickOnProjectWithoutISO();
				}
			}

		} catch (Exception e) {
			System.out.println("Project Type is not updated");
		}
	}

	@Then("Update valid project code using sheetname {string} and rownumber {int}")
	public void update_valid_project_code_using_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		try {
			String ProjectCode = testdata.get(int1).get("Project code");

			if (ProjectCode != null && !ProjectCode.isEmpty()) {
				Thread.sleep(1000);
				D.ClearOnProjectCode();
				Thread.sleep(2000);
				D.EnterOnProjectCode(ProjectCode);
			}
		} catch (Exception e) {
			System.out.println("Project Code is not updated");
		}
	}

	@Then("Update valid project name using sheetname {string} and rownumber {int}")
	public void update_valid_project_name_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String ProjectName = testdata.get(int1).get("Project name");
		if (ProjectName != null && !ProjectName.isEmpty()) {
			Thread.sleep(1000);
			D.ClearOnProjectName();
			Thread.sleep(2000);
			D.EnterOnProjectName(ProjectName);
		}
	}

	@Then("Update valid project description using sheetname {string} and rownumber {int}")
	public void update_valid_project_description_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String ProjectDescrpt = testdata.get(int1).get("Project Description");
		if (ProjectDescrpt != null && !ProjectDescrpt.isEmpty()) {
			Thread.sleep(1000);
			D.ClearOnProjectDescrpt();
			Thread.sleep(2000);
			D.EnterOnProjectDescrpt(ProjectDescrpt);
		}
	}

	@Then("Update Start Date of the project using sheetname {string} and rownumber {int}")
	public void update_start_date_of_the_project_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String ProjectStartDate = testdata.get(int1).get("start date");
		String ProjectStartMonth = testdata.get(int1).get("start month");
		String ProjectStartYear = testdata.get(int1).get("start year");

		if ((ProjectStartDate != null && !ProjectStartDate.isEmpty())
				&& (ProjectStartMonth != null && !ProjectStartMonth.isEmpty())
				&& (ProjectStartYear != null && !ProjectStartYear.isEmpty())) {

			if (ProjectStartYear != null && ProjectStartYear.matches("\\d+\\.0")) {
				ProjectStartYear = ProjectStartYear.substring(0, ProjectStartYear.indexOf(".0"));

				Thread.sleep(1000);
				D.ClickOnStartDate();
				D.ClearOnStartDate();
				D.EnterOnStartDate(ProjectStartDate);
				D.EnterOnStartDate(ProjectStartMonth);
				D.EnterOnStartDate(ProjectStartYear);
			}
		}
	}

	@Then("Update the project design type from drop-down using sheetname {string} and rownumber {int}")
	public void update_the_project_design_type_from_drop_down_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException, AWTException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String ProjectDesigntype = testdata.get(int1).get("Design type");

		if (ProjectDesigntype != null && !ProjectDesigntype.isEmpty()) {
			Thread.sleep(1000);
			D.ClickOnProjectDesignType();
			Thread.sleep(2000);
			D.EnterOnProjectDesignType(ProjectDesigntype);
			performTabKeyPress();
		}
	}

	@Then("Update the project category type from drop-down using sheetname {string} and rownumber {int}")
	public void update_the_project_category_type_from_drop_down_using_sheetname_and_rownumber(String string,
			Integer int1) throws InterruptedException, AWTException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String Projectcategory = testdata.get(int1).get("category");

		if (Projectcategory != null && !Projectcategory.isEmpty()) {
			Thread.sleep(1000);
			D.EnterOnProjectCategory(Projectcategory);
			Thread.sleep(1000);
			performTabKeyPress();
		}
	}

	@Then("Update the project owner type from drop-down using sheetname {string} and rownumber {int}")
	public void update_the_project_owner_type_from_drop_down_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException, AWTException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String ProjectOwner = testdata.get(int1).get("Owner");

		if (ProjectOwner != null && !ProjectOwner.isEmpty()) {

			Thread.sleep(1000);
			D.ClickOnProjectOwnerSelection();
			D.EnterOnProjectOwnerSelection(ProjectOwner);
			D.selectDropdownOption(ProjectOwner);

		}

	}

	@Then("Update the project status type from drop-down using sheetname {string} and rownumber {int}")
	public void update_the_project_status_type_from_drop_down_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException, AWTException {

		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String Projectstatus = testdata.get(int1).get("status");
		if (Projectstatus != null && !Projectstatus.isEmpty()) {
			Thread.sleep(1000);
			D.ClickOnProjectStatus();
			Thread.sleep(1000);
			D.EnterOnProjectStatus(Projectstatus);
			Thread.sleep(1000);
			performTabKeyPress();
		}
	}

	@Then("Update address in address line one field using sheetname {string} and rownumber {int}")
	public void update_address_in_address_line_one_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String AddressLine1 = testdata.get(int1).get("Address Line1");

		if (AddressLine1 != null && !AddressLine1.isEmpty()) {
			Thread.sleep(1000);
			D.ClearOnAddressLine1();
			Thread.sleep(2000);
			D.EnterOnAddressLine1(AddressLine1);
		}
	}

	@Then("Update address in address line two field using sheetname {string} and rownumber {int}")
	public void update_address_in_address_line_two_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String AddressLine2 = testdata.get(int1).get("Address Line2");

		if (AddressLine2 != null && !AddressLine2.isEmpty()) {
			Thread.sleep(1000);
			D.ClearOnAddressLine2();
			Thread.sleep(2000);
			D.EnterOnAddressLine2(AddressLine2);
		}
	}

	@Then("Update City name in the field using sheetname {string} and rownumber {int}")
	public void update_city_name_in_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String City = testdata.get(int1).get("city");
		if (City != null && !City.isEmpty()) {
			Thread.sleep(1000);
			D.ClearOnCity();
			Thread.sleep(2000);
			D.EnterOnCity(City);
		}

	}

	@Then("Update State name in the field using sheetname {string} and rownumber {int}")
	public void update_state_name_in_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String State = testdata.get(int1).get("state");
		if (State != null && !State.isEmpty()) {
			Thread.sleep(1000);
			D.ClearOnState();
			Thread.sleep(2000);
			D.EnterOnState(State);
		}

	}

	@Then("Update valid Pincode in the field using sheetname {string} and rownumber {int}")
	public void update_valid_pincode_in_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String Pincode = testdata.get(int1).get("postal code");
		if (Pincode != null && !Pincode.isEmpty()) {
			if (Pincode != null && Pincode.matches("\\d+\\.0")) {
				Pincode = Pincode.substring(0, Pincode.indexOf(".0"));

				Thread.sleep(1000);
				D.ClearOnPincode();
				Thread.sleep(1000);
				D.EnterOnPincode(Pincode);
			}
		}

	}

	@Then("Update Country name in the field using sheetname {string} and rownumber {int}")
	public void update_country_name_in_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String Country = testdata.get(int1).get("country");
		if (Country != null && !Country.isEmpty()) {
			Thread.sleep(1000);
			D.ClearOnCountry();
			Thread.sleep(2000);
			D.EnterOnCountry(Country);
		}
	}

	@Then("Click on Update button to update project details")
	public void click_on_update_button_to_update_project_details() throws InterruptedException {
		D.ClickOnUpdateButton();
		Thread.sleep(4000);
	}

	// Edit Review under Action

	@Then("Changing the required field in Review module under Action using sheetname {string} and rownumber {int}")
	public void Changing_the_required_field_in_Review_module_under_Action(String sheetname, int rownumber)
			throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
		System.out.println("Sheet details :" + testdata);
		String ProjectCode = testdata.get(rownumber).get("Project code");
		Thread.sleep(2000);
		D.ClickOnDesignProject();
		Thread.sleep(4000);
		D.EnterOnSearchBox(ProjectCode);
		Thread.sleep(2000);
		D.clickOnProject(ProjectCode);
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(4000);
		R.ClickOnActions();
		Thread.sleep(3000);
		R.ClickOnReview();
		Thread.sleep(4000);
		R.SelectStatusclick();
		Thread.sleep(4000);
		String type = testdata.get(rownumber).get("Status");
		R.SelectStatusType(type);
		Thread.sleep(4000);
		String OldReviewCode = testdata.get(rownumber).get("Old Review Code");
		Thread.sleep(4000);
		D.clickOnActionButtonForProject(OldReviewCode);
		Thread.sleep(4000);

		String Attachfile = testdata.get(rownumber).get("Attachfile");
		String FileName = testdata.get(rownumber).get("File Name");

		if (Attachfile != null && !Attachfile.isEmpty()) {
			Thread.sleep(1000);
			R.ClickOnAttachFiles();
			Thread.sleep(1000);
			R.attachFile(Attachfile, FileName);
			Thread.sleep(1000);
			R.clickOnRequiredFile(FileName);
			Thread.sleep(2000);
			R.ClickOnAttachButton();
		}

	}

	@Then("Update Parent Review name from the drop-down using sheetname {string} and rownumber {int}")
	public void update_parent_review_name_from_the_drop_down_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException, AWTException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);

		String ParentReview = testdata.get(int1).get("Parent Review");
		if (ParentReview != null && !ParentReview.isEmpty()) {
			Thread.sleep(1000);
			R.ClickOnParentReview();
			Thread.sleep(1000);
			R.selectDropdownOption(ParentReview);
			performTabKeyPress();
		}
	}

	@Then("Update  valid code on Review Code field using sheetname {string} and rownumber {int}")
	public void update_valid_code_on_review_code_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);
		String ReviewCode = testdata.get(int1).get("Review Code");
		if (ReviewCode != null && !ReviewCode.isEmpty()) {
			Thread.sleep(1000);
			R.ClearOnReviewCode();
			Thread.sleep(1000);
			R.EnterOnReviewCode(ReviewCode);
		}

	}

	@Then("Update valid name on Review Name field using sheetname {string} and rownumber {int}")
	public void update_valid_name_on_review_name_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);
		String ReviewName = testdata.get(int1).get("Review Name");
		if (ReviewName != null && !ReviewName.isEmpty()) {
			Thread.sleep(1000);
			R.ClearOnReviewName();
			Thread.sleep(1000);
			R.EnterOnReviewName(ReviewName);
		}
	}

	@Then("Update Description on the field using sheetname {string} and rownumber {int}")
	public void update_description_on_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);

		String Description = testdata.get(int1).get("Description");
		if (Description != null && !Description.isEmpty()) {
			Thread.sleep(1000);
			R.ClearOnDescription();
			Thread.sleep(1000);
			R.EnterOnDescription(Description);
		}
	}

	@Then("Update valid start date on the field using sheetname {string} and rownumber {int}")
	public void update_valid_start_date_on_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);

		String ReviewStartDate = testdata.get(int1).get("Start Date");
		String ReviewStartMonth = testdata.get(int1).get("Start Month");
		String ReviewStartYear = testdata.get(int1).get("Start Year");

		if ((ReviewStartDate != null && !ReviewStartDate.isEmpty())
				&& (ReviewStartMonth != null && !ReviewStartMonth.isEmpty())
				&& (ReviewStartYear != null && !ReviewStartYear.isEmpty())) {

			if (ReviewStartYear != null && ReviewStartYear.matches("\\d+\\.0")) {
				ReviewStartYear = ReviewStartYear.substring(0, ReviewStartYear.indexOf(".0"));
			}
			if (ReviewStartMonth != null && ReviewStartMonth.matches("\\d+\\.0")) {
				ReviewStartMonth = ReviewStartMonth.substring(0, ReviewStartMonth.indexOf(".0"));
			}
			if (ReviewStartDate != null && ReviewStartDate.matches("\\d+\\.0")) {
				ReviewStartDate = ReviewStartDate.substring(0, ReviewStartDate.indexOf(".0"));
			}
			System.out.println(
					"Start Date details :" + ReviewStartMonth + "| " + ReviewStartDate + "| " + ReviewStartYear);
			Thread.sleep(1000);
			R.ClickOnStartDate();
			R.ClearOnStartDate();
			Thread.sleep(1000);
			String fromateddate = String.format("%02d/%02d/%d", Integer.parseInt(ReviewStartMonth),
					Integer.parseInt(ReviewStartDate), Integer.parseInt(ReviewStartYear));
			R.EnterOnStartDate(fromateddate);

		}
	}

	@Then("Update valid End date on the field using sheetname {string} and rownumber {int}")
	public void update_valid_end_date_on_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);

		String ReviewEndDate = testdata.get(int1).get("End Date");
		String ReviewEndMonth = testdata.get(int1).get("End Month");
		String ReviewEndYear = testdata.get(int1).get("End Year");

		if ((ReviewEndDate != null && !ReviewEndDate.isEmpty()) && (ReviewEndMonth != null && !ReviewEndMonth.isEmpty())
				&& (ReviewEndYear != null && !ReviewEndYear.isEmpty())) {

			if (ReviewEndYear != null && ReviewEndYear.matches("\\d+\\.0")) {
				ReviewEndYear = ReviewEndYear.substring(0, ReviewEndYear.indexOf(".0"));
			}
			if (ReviewEndMonth != null && ReviewEndMonth.matches("\\d+\\.0")) {
				ReviewEndMonth = ReviewEndMonth.substring(0, ReviewEndMonth.indexOf(".0"));
			}
			if (ReviewEndDate != null && ReviewEndDate.matches("\\d+\\.0")) {
				ReviewEndDate = ReviewEndDate.substring(0, ReviewEndDate.indexOf(".0"));
			}
			System.out.println("End Date details :" + ReviewEndMonth + "| " + ReviewEndDate + "| " + ReviewEndYear);
			Thread.sleep(1000);
			R.ClickOnEndDate();
			R.ClearOnEndDate();
			Thread.sleep(1000);
			String fromateddate = String.format("%02d/%02d/%d", Integer.parseInt(ReviewEndMonth),
					Integer.parseInt(ReviewEndDate), Integer.parseInt(ReviewEndYear));
			R.EnterOnEndDate(fromateddate);

		}
	}

	@Then("Update workflow on the field using sheetname {string} and rownumber {int}")
	public void update_workflow_on_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);
		String Workflow = testdata.get(int1).get("Workflow");

		if (Workflow != null && !Workflow.isEmpty()) {
			Thread.sleep(1000);
			R.workflowselection(Workflow);
			Thread.sleep(1000);
		}

	}

	@Then("Update priority from the drop-down using sheetname {string} and rownumber {int}")
	public void update_priority_from_the_drop_down_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);
		String Priority = testdata.get(int1).get("Priority");

		if (Priority != null && !Priority.isEmpty()) {
			Thread.sleep(1000);
			R.prioritydropdownclick();
			Thread.sleep(1000);
			R.SelectPrioritydropdown(Priority);
		}
	}

	@Then("Update valid Estimate cost in the field using sheetname {string} and rownumber {int}")
	public void update_valid_estimate_cost_in_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);
		String EstimateCost = testdata.get(int1).get("Estimate Cost");
		if (EstimateCost != null && !EstimateCost.isEmpty()) {
			Thread.sleep(1000);
			R.ClearOnEstimateCost();
			Thread.sleep(1000);
			R.EnterOnEstimateCost(EstimateCost);
		}
	}

	@Then("Update valid Actual cost in the field using sheetname {string} and rownumber {int}")
	public void update_valid_actual_cost_in_the_field_using_sheetname_and_rownumber(String string, Integer int1)
			throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);

		String ActualCost = testdata.get(int1).get("Actual Cost");
		if (ActualCost != null && !ActualCost.isEmpty()) {
			Thread.sleep(1000);
			R.ClearOnActualCost();
			Thread.sleep(1000);
			R.EnterOnActualCost(ActualCost);
		}
	}

	@Then("Update checklist from the drop-down using sheetname {string} and rownumber {int}")
	public void update_checklist_from_the_drop_down_using_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Sheet details :" + testdata);
	}

	@Then("Clicking on update button to update a Review for the project")
	public void clicking_on_update_button_to_update_a_review_for_the_project() throws InterruptedException {
		Thread.sleep(4000);
		R.ClickOnUpdate();
		Thread.sleep(4000);
	}

	// Edit RFA under Action

	@Then("Changing the required field in RFA module under Action using sheetname {string} and rownumber {int}")
	public void changing_the_required_fied_in_RFA_module(String sheetname, int rownumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
		String ProjectCode = testdata.get(rownumber).get("Project code");
		Thread.sleep(2000);
		D.ClickOnDesignProject();
		Thread.sleep(4000);
		D.EnterOnSearchBox(ProjectCode);
		Thread.sleep(2000);
		D.clickOnProject(ProjectCode);
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(4000);
		R.ClickOnActions();
		Thread.sleep(3000);
		RFA.ClickOnRFA();
		Thread.sleep(4000);
		R.SelectStatusclick();
		Thread.sleep(4000);
		String type = testdata.get(rownumber).get("Status");
		R.SelectStatusType(type);
		Thread.sleep(4000);
		String OldRFACode = testdata.get(rownumber).get("Old RFA Code");
		Thread.sleep(4000);
		D.clickOnActionButtonForProject(OldRFACode);
	}

	@Then("Update valid code on RFA Code field using sheetname {string} and rownumber {int}")
	public void update_valid_code_on_rfa_code_field_using_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

			String RFACode = testdata.get(int1).get("RFA Code");
			if (RFACode != null && !RFACode.isEmpty()) {
				Thread.sleep(1000);
				RFA.ClearOnRFACode();
				Thread.sleep(1000);
				RFA.EnterOnRFACode(RFACode);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	@Then("Update valid name on RFA Name field using sheetname {string} and rownumber {int}")
	public void update_valid_name_on_rfa_name_field_using_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String RFAName = testdata.get(int1).get("RFA Name");
			if (RFAName != null && !RFAName.isEmpty()) {
				Thread.sleep(1000);
				RFA.ClearOnRFAName();
				Thread.sleep(1000);
				RFA.EnterOnRFAName(RFAName);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	@Then("Update Description on the field in add RFA using sheetname {string} and rownumber {int}")
	public void update_description_on_the_field_in_add_rfa_using_sheetname_and_rownumber(String string, Integer int1) {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String Description = testdata.get(int1).get("Description");
			if (Description != null && !Description.isEmpty()) {
				RFA.ClearOnDescription();
				RFA.EnterOnDescription(Description);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	@Then("Update valid start date on the field in add RFA using sheetname {string} and rownumber {int}")
	public void update_valid_start_date_on_the_field_in_add_rfa_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String RFAStartDate = testdata.get(int1).get("Start Date");
			String RFAStartMonth = testdata.get(int1).get("Start Date");
			String RFAStartYear = testdata.get(int1).get("Start Year");

			if ((RFAStartDate != null && !RFAStartDate.isEmpty()) && (RFAStartMonth != null && !RFAStartMonth.isEmpty())
					&& (RFAStartYear != null && !RFAStartYear.isEmpty())) {

				if (RFAStartYear != null && RFAStartYear.matches("\\d+\\.0")) {
					RFAStartYear = RFAStartYear.substring(0, RFAStartYear.indexOf(".0"));
				}
				if (RFAStartMonth != null && RFAStartMonth.matches("\\d+\\.0")) {
					RFAStartMonth = RFAStartMonth.substring(0, RFAStartMonth.indexOf(".0"));
				}
				if (RFAStartDate != null && RFAStartDate.matches("\\d+\\.0")) {
					RFAStartDate = RFAStartDate.substring(0, RFAStartDate.indexOf(".0"));
				}
				Thread.sleep(1000);
				RFA.ClickOnStartDate();
				RFA.ClearOnStartDate();
				String fromateddate = String.format("%02d/%02d/%d", Integer.parseInt(RFAStartMonth),
						Integer.parseInt(RFAStartDate), Integer.parseInt(RFAStartYear));
				RFA.EnterOnStartDate(fromateddate);
				}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	@Then("Update valid End date on the field in add RFA using sheetname {string} and rownumber {int}")
	public void update_valid_end_date_on_the_field_in_add_rfa_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String RFAEndDate = testdata.get(int1).get("End Date");
			String RFAEndMonth = testdata.get(int1).get("End Date");
			String RFAEndYear = testdata.get(int1).get("End Year");

			if ((RFAEndDate != null && !RFAEndDate.isEmpty()) && (RFAEndMonth != null && !RFAEndMonth.isEmpty())
					&& (RFAEndYear != null && !RFAEndYear.isEmpty())) {

				if (RFAEndYear != null && RFAEndYear.matches("\\d+\\.0")) {
					RFAEndYear = RFAEndYear.substring(0, RFAEndYear.indexOf(".0"));
				}
				if (RFAEndMonth != null && RFAEndMonth.matches("\\d+\\.0")) {
					RFAEndMonth = RFAEndMonth.substring(0, RFAEndMonth.indexOf(".0"));
				}
				if (RFAEndDate != null && RFAEndDate.matches("\\d+\\.0")) {
					RFAEndDate = RFAEndDate.substring(0, RFAEndDate.indexOf(".0"));
				}

				Thread.sleep(1000);
				RFA.ClickOnEndDate();
				RFA.ClearOnEndDate();
				String fromateddate = String.format("%02d/%02d/%d", Integer.parseInt(RFAEndMonth),
						Integer.parseInt(RFAEndDate), Integer.parseInt(RFAEndYear));
				RFA.EnterOnEndDate(fromateddate);
		}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	@Then("Update Workflow from the drop-down in add RFA using sheetname {string} and rownumber {int}")
	public void update_workflow_from_the_drop_down_in_add_rfa_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String Workflow = testdata.get(int1).get("Workflow");
			if (Workflow != null && !Workflow.isEmpty()) {
				Thread.sleep(1000);
				RFA.workflowselection(Workflow);
				Thread.sleep(1000);
				performTabKeyPress();
				performTabKeyPress();
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	@Then("Update priority from the drop-down in add RFA using sheetname {string} and rownumber {int}")
	public void update_priority_from_the_drop_down_in_add_rfa_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Priority = testdata.get(int1).get("Priority");
			if (Priority != null && !Priority.isEmpty()) {
				Thread.sleep(1000);
				RFA.prioritydropdownclick();
				Thread.sleep(1000);
				RFA.SelectPrioritydropdown(Priority);
			}
		
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	@Then("Udpate Attach files from the drop-down and attaching the files using sheetname {string} and rownumber {int}")
	public void udpate_attach_files_from_the_drop_down_and_attaching_the_files_using_sheetname_and_rownumber(
			String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Attachfile = testdata.get(int1).get("Attachfile");
			String FileName = testdata.get(int1).get("File Name");
			if (Attachfile != null && !Attachfile.isEmpty()) {
				Thread.sleep(1000);
				R.ClickOnAttachFiles();
				Thread.sleep(1000);
				RFA.attachFile(Attachfile, FileName);
				Thread.sleep(1000);
				R.clickOnRequiredFile(FileName);
				Thread.sleep(2000);
				R.ClickOnAttachButton();
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	@Then("Clicking on update button to update a RFA for the project")
	public void clicking_on_update_button_to_update_a_rfa_for_the_project() throws Exception {
		try {
			Thread.sleep(3000);
			RFA.ClickOnUpdate();
			Thread.sleep(4000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFA");
			throw e;
		}
	}

	// Share -> Edit Meeting Module

	@Then("Changing the required field in Meeting module under Share using sheetname {string} and rownumber {int}")
	public void changing_the_required_fied_in_meeting_module(String sheetname, int rownumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
		String ProjectCode = testdata.get(rownumber).get("Project code");
		Thread.sleep(2000);
		D.ClickOnDesignProject();
		Thread.sleep(4000);
		D.EnterOnSearchBox(ProjectCode);
		Thread.sleep(2000);
		D.clickOnProject(ProjectCode);
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(4000);
		MET.ClickOnShare();
		Thread.sleep(3000);
		MET.ClickOnMeeting();
		Thread.sleep(4000);
		String OldMeetingName = testdata.get(rownumber).get("Old Meeting Name");
		Thread.sleep(4000);
		D.clickOnActionButtonForProject(OldMeetingName);

	}
	
	@Then("Update meeting name on Name field in add Meeting using sheetname {string} and rownumber {int}")
	public void update_meeting_name_on_name_field_in_add_meeting_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String MeetingName = testdata.get(int1).get("Name");
			if (MeetingName != null && !MeetingName.isEmpty()) {
				Thread.sleep(1000);
				MET.ClearOnName();
				Thread.sleep(1000);
				MET.EnterOnName(MeetingName);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Update Meeting Date on date field in add Meeting using sheetname {string} and rownumber {int}")
	public void update_meeting_date_on_date_field_in_add_meeting_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String MeetingStartDate = testdata.get(int1).get("Meeting Start Date");
			String MeetingStartMonth = testdata.get(int1).get("Meeting Start Month");
			String MeetingStartYear = testdata.get(int1).get("Meeting Start Year");

			if ((MeetingStartDate != null && !MeetingStartDate.isEmpty())
					&& (MeetingStartMonth != null && !MeetingStartMonth.isEmpty())
					&& (MeetingStartYear != null && !MeetingStartYear.isEmpty())) {

				if (MeetingStartYear != null && MeetingStartYear.matches("\\d+\\.0")) {
					MeetingStartYear = MeetingStartYear.substring(0, MeetingStartYear.indexOf(".0"));
				}
				if (MeetingStartMonth != null && MeetingStartMonth.matches("\\d+\\.0")) {
					MeetingStartMonth = MeetingStartMonth.substring(0, MeetingStartMonth.indexOf(".0"));
				}
				if (MeetingStartDate != null && MeetingStartDate.matches("\\d+\\.0")) {
					MeetingStartDate = MeetingStartDate.substring(0, MeetingStartDate.indexOf(".0"));
				}

				Thread.sleep(1000);
				MET.ClickOnDate();
				MET.ClearOnDate();
				MET.EnterOnDate(MeetingStartDate);
				MET.EnterOnDate(MeetingStartMonth);
				performTabKeyPress();
				MET.EnterOnDate(MeetingStartYear);

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Update Meeting Time on date field in add Meeting using sheetname {string} and rownumber {int}")
	public void update_meeting_time_on_date_field_in_add_meeting_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String Hour = testdata.get(int1).get("Hour");
			String Minute = testdata.get(int1).get("Minute");
			String AM_PM = testdata.get(int1).get("AM/PM");

			if ((Hour != null && !Hour.isEmpty()) && (Minute != null && !Minute.isEmpty())
					&& (AM_PM != null && !AM_PM.isEmpty())) {

				Thread.sleep(1000);
				MET.ClickOnTime();
				MET.ClearOnTime();
				MET.EnterOnTime(Hour);
				MET.EnterOnTime(Minute);
				MET.EnterOnTime(AM_PM);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Update Meeting Duration hours and minutes field in add Meeting using sheetname {string} and rownumber {int}")
	public void update_meeting_duration_hours_and_minutes_field_in_add_meeting_using_sheetname_and_rownumber(
			String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String DurationHours = testdata.get(int1).get("Duration Hours");
			String DurationMinutes = testdata.get(int1).get("Duration Minutes");
			if ((DurationHours != null && !DurationHours.isEmpty())
					&& (DurationMinutes != null && !DurationMinutes.isEmpty())) {

				Thread.sleep(1000);
				MET.ClearOnDurationHours();
				MET.EnterOnDurationHours(DurationHours);
				Thread.sleep(1000);
				MET.ClearOnDurationMinutes();
				MET.EnterOnDurationMinutes(DurationMinutes);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Update Description on the field in add Meeting using sheetname {string} and rownumber {int}")
	public void update_description_on_the_field_in_add_meeting_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Description = testdata.get(int1).get("Description");
			if (Description != null && !Description.isEmpty()) {
				MET.ClearOnDescription();
				Thread.sleep(1000);
				MET.EnterOnDescription(Description);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Update Notes to the meeting in the Enter notes field if extra notes need to be add clicking on Add Notes button in Edit Meeting using sheetname {string} and rownumber {int}")
	public void update_notes_to_the_meeting_in_the_enter_notes_field_if_extra_notes_need_to_be_add_clicking_on_add_notes_button_in_edit_meeting_using_sheetname_and_rownumber(
			String string, Integer int1) {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("Notes Details :"+testdata);
			
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Update the selected Participants from Select Users and Selected Group of Users in Edit meeting using sheetname {string} and rownumber {int}")
	public void update_the_selected_participants_from_select_users_and_selected_group_of_users_in_edit_meeting_using_sheetname_and_rownumber(
			String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			for (Map<String, String> row : testdata) {
				String userName = row.get("Select users"); // Adjust based on your Excel column header
				if (userName != null && !userName.isEmpty()) {
					Thread.sleep(1000);
					MET.ClickOnSelectUsersTab();
					Thread.sleep(1000);
					MET.ClickOnSelectUserField();
					Thread.sleep(1000);
					MET.Selectusers(userName);
					Thread.sleep(2000);
				} else {
					System.out.println("No more users to select, stopping the selection process.");
					break;
				}
			}

			for (Map<String, String> row : testdata) {
				String userName = row.get("Select user groups"); // Adjust based on your Excel column header
				if (userName != null && !userName.isEmpty()) {
					Thread.sleep(1000);
					MET.ClickOnSelectGroupUsersTab();
					Thread.sleep(1000);
					MET.ClickOnSelectUserGroupField();
					Thread.sleep(1000);
					MET.Selectusersgroup(userName);
					Thread.sleep(2000);
				} else {
					System.out.println("No more users to select, stopping the selection process.");
					break;
				}
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Update by Uploading an Image in the field in Edit meeting using sheetname {string} and rownumber {int}")
	public void update_by_uploading_an_image_in_the_field_in_edit_meeting_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String imageFilePath = testdata.get(int1).get("Upload Images");
			

			if (imageFilePath != null && !imageFilePath.isEmpty()) {
				Thread.sleep(1000);
				MET.UploadingAnImage(imageFilePath);
			}

			
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Update Selecting Attach files from the drop-down and attaching the files in Edit Meeting using sheetname {string} and rownumber {int}")
	public void update_selecting_attach_files_from_the_drop_down_and_attaching_the_files_in_edit_meeting_using_sheetname_and_rownumber(
			String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Attachfile = testdata.get(int1).get("Attachfile");
			String FileName = testdata.get(int1).get("File Name");
			if (Attachfile != null && !Attachfile.isEmpty()) {
				Thread.sleep(1000);
				R.ClickOnAttachFiles();
				Thread.sleep(1000);
				R.attachFile(Attachfile, FileName);
				Thread.sleep(1000);
				R.clickOnRequiredFile(FileName);
				Thread.sleep(2000);
				R.ClickOnAttachButton();
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	@Then("Clicking on Update button to update a Meeting for the project")
	public void clicking_on_update_button_to_update_a_meeting_for_the_project() throws Exception {
		try {
			Thread.sleep(4000);
			RFA.ClickOnUpdate();
			Thread.sleep(4000);
			R.clickupdatebtn();
			Thread.sleep(4000);
			
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Meeting Page");
			throw e;
		}
	}

	// Attachments -> Edit BOM/BOQ

	@Then("Changing the required field in BOM_BOQ module under Attachments using sheetname {string} and rownumber {int}")
	public void changing_the_required_field_in_bom_boq_module_under_attachments_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
		String ProjectCode = testdata.get(rownumber).get("Project code");
		Thread.sleep(2000);
		D.ClickOnDesignProject();
		Thread.sleep(4000);
		D.EnterOnSearchBox(ProjectCode);
		Thread.sleep(2000);
		D.clickOnProject(ProjectCode);
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(4000);
		BOM.ClickOnAttachments();
		Thread.sleep(3000);
		BOM.ClickOnBOM_BOQ();
		Thread.sleep(4000);
		R.SelectStatusclick();
		Thread.sleep(4000);
		String type = testdata.get(rownumber).get("Status");
		R.SelectStatusType(type);
		Thread.sleep(4000);
		String OldBOMCode = testdata.get(rownumber).get("Old BOM Code");
		Thread.sleep(4000);
		D.clickOnActionButtonForProject(OldBOMCode);
	
		
		String EstimatedTotal = testdata.get(rownumber).get("Estimated Total");
		String QuotedTotal = testdata.get(rownumber).get("Quoted Total");		
		String ActualTotal = testdata.get(rownumber).get("Actual Total");
			
				/*
		 * String calculatedEstimatedTotal = BOM.getEstimatedTotal(); int
		 * estimatedquantity = Integer.parseInt(EstimatedQuantity); int
		 * estimatedpricePerUnit = Integer.parseInt(EstimatedPricePerUnit);
		 * 
		 * int estimatedTotalCalculated = estimatedquantity * estimatedpricePerUnit;
		 * 
		 * String estimatedTotalCalculatedStr =
		 * String.valueOf(estimatedTotalCalculated); String estimatedTotalFieldValue =
		 * BOM.getEstimatedTotal();
		 * 
		 * Assert.assertEquals("Estimated Total value does not match!",
		 * estimatedTotalCalculatedStr, estimatedTotalFieldValue);
		 */
		
		
		
		
		/*
		 * int orderedquantity = Integer.parseInt(OrderedQuantity); int
		 * quotedpricePerUnit = Integer.parseInt(QuotedPricePerUnit);
		 * 
		 * int quotedTotalCalculated = orderedquantity * quotedpricePerUnit;
		 * 
		 * String quotedTotalCalculatedStr = String.valueOf(quotedTotalCalculated);
		 * String quotedTotalFieldValue = BOM.getQuotedTotal();
		 * 
		 * Assert.assertEquals("Quoted Total value does not match!",
		 * quotedTotalCalculatedStr, quotedTotalFieldValue);
		 */


	
		/*
		 * int actualquantity = Integer.parseInt(ActualQuantity); int actualpricePerUnit
		 * = Integer.parseInt(ActualPricePerUnit);
		 * 
		 * int actualotalCalculated = actualquantity * actualpricePerUnit;
		 * 
		 * String actualTotalCalculatedStr = String.valueOf(actualotalCalculated);
		 * String actualTotalFieldValue = BOM.getActualTotal();
		 * 
		 * Assert.assertEquals("Actual Total value does not match!",
		 * actualTotalCalculatedStr, actualTotalFieldValue);
		 */
			

	}
	
	@Then("Update Parent BOM\\/BOQ name from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_parent_bom_boq_name_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String ParentBOM = testdata.get(int1).get("Parent BOM");
			if (ParentBOM != null && !ParentBOM.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClickOnParentBOM();
				Thread.sleep(1000);
				BOM.selectDropdownOption(ParentBOM);
				performTabKeyPress();
			}
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid code on BOM\\/BOQ Code field using sheetname {string} and rownumber {int}")
	public void update_valid_code_on_bom_boq_code_field_using_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String Code = testdata.get(int1).get("Code");
			if (Code != null && !Code.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClickOnCode();
				BOM.ClearOnCode();
				Thread.sleep(1000);
				BOM.EnterOnCode(Code);
			}
			
			
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid name on Name field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_name_on_name_field_in_bom_boq_using_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Name = testdata.get(int1).get("Name");
			if (Name != null && !Name.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClearOnName();
				Thread.sleep(1000);
				BOM.EnterOnName(Name);
			}

			
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update workflow on the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_workflow_on_the_field_in_bom_boq_using_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Workflow = testdata.get(int1).get("Workflow");
			if (Workflow != null && !Workflow.isEmpty()) {
				Thread.sleep(1000);
				RFA.workflowselection(Workflow);
			}
			
			
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update priority from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_priority_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Priority = testdata.get(int1).get("Priority");
			if (Priority != null && !Priority.isEmpty()) {
				Thread.sleep(1000);
				RFA.prioritydropdownclick();
				Thread.sleep(1000);
				RFA.SelectPrioritydropdown(Priority);
			}
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid unit field from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_unit_field_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Unit = testdata.get(int1).get("Unit");
			if (Unit != null && !Unit.isEmpty()) {
				Thread.sleep(1000);
				BOM.unitdropdownclick();
				Thread.sleep(1000);
				BOM.SelectUnitdropdown(Unit);
			}
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid Estimated Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_estimated_quantity_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String EstimatedQuantity = testdata.get(int1).get("Estimated Quantity");
			
			if (EstimatedQuantity != null && EstimatedQuantity.matches("\\d+\\.0")) {
				EstimatedQuantity = EstimatedQuantity.substring(0, EstimatedQuantity.indexOf(".0"));
			}
			
			if (EstimatedQuantity != null && !EstimatedQuantity.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClearOnEstimatedQuantity();
				Thread.sleep(1000);
				BOM.EnterOnEstimatedQuantity(EstimatedQuantity);
			} else {
				System.out.println("Estimated Quantity Value remains the same");
			}
			
			Thread.sleep(1000);
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid Estimated Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_estimated_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(
			String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String EstimatedPricePerUnit = testdata.get(int1).get("Estimated Price Per Unit");
			
			if (EstimatedPricePerUnit != null && EstimatedPricePerUnit.matches("\\d+\\.0")) {
				EstimatedPricePerUnit = EstimatedPricePerUnit.substring(0, EstimatedPricePerUnit.indexOf(".0"));
			}
			if (EstimatedPricePerUnit != null && !EstimatedPricePerUnit.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClearOnEstimatedPricePerUnit();
				Thread.sleep(1000);
				BOM.EnterOnEstimatedPricePerUnit(EstimatedPricePerUnit);
			} else {
				System.out.println("Estimated Price Per Unit remains the same");
			}
			Thread.sleep(1000);
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid Ordered Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_ordered_quantity_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String OrderedQuantity = testdata.get(int1).get("Ordered Quantity");
			
			if (OrderedQuantity != null && OrderedQuantity.matches("\\d+\\.0")) {
				OrderedQuantity = OrderedQuantity.substring(0, OrderedQuantity.indexOf(".0"));
			}
			
			if (OrderedQuantity != null && !OrderedQuantity.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClearOnOrderedQuantity();
				Thread.sleep(1000);
				BOM.EnterOnOrderedQuantity(OrderedQuantity);
			} else {
				System.out.println("Ordered Quantity remains the same");
			}
			Thread.sleep(1000);
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid Quoted Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_quoted_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String QuotedPricePerUnit = testdata.get(int1).get("Quoted Price Per Unit");
			if (QuotedPricePerUnit != null && QuotedPricePerUnit.matches("\\d+\\.0")) {
				QuotedPricePerUnit = QuotedPricePerUnit.substring(0, QuotedPricePerUnit.indexOf(".0"));
			}

			if (QuotedPricePerUnit != null && !QuotedPricePerUnit.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClearOnQuotedPricePerUnit();
				Thread.sleep(1000);
				BOM.EnterOnQuotedPricePerUnit(QuotedPricePerUnit);
			} else {
				System.out.println("Ordered Price Per Unit remains the same");
			}
			Thread.sleep(1000);
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid Actual Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_actual_quantity_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String ActualQuantity = testdata.get(int1).get("Actual Quantity");
			
			if (ActualQuantity != null && ActualQuantity.matches("\\d+\\.0")) {
				ActualQuantity = ActualQuantity.substring(0, ActualQuantity.indexOf(".0"));
			}
			if (ActualQuantity != null && !ActualQuantity.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClearOnActualQuantity();
				Thread.sleep(1000);
				BOM.EnterOnActualQuantity(ActualQuantity);
			} else {
				System.out.println("Actual Quantity remains the same");
			}
			Thread.sleep(1000);
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid Actual Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_actual_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String ActualPricePerUnit = testdata.get(int1).get("Actual Price Per Unit");
			
			if (ActualPricePerUnit != null && ActualPricePerUnit.matches("\\d+\\.0")) {
				ActualPricePerUnit = ActualPricePerUnit.substring(0, ActualPricePerUnit.indexOf(".0"));
			}

			if (ActualPricePerUnit != null && !ActualPricePerUnit.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClearOnActualPricePerUnit();
				Thread.sleep(1000);
				BOM.EnterOnActualPricePerUnit(ActualPricePerUnit);
			} else {
				System.out.println("Actual Price Per Unit remains the same");
			}
			Thread.sleep(1000);
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid Remarks in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_remarks_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String Remarks = testdata.get(int1).get("Remarks");
			if (Remarks != null && !Remarks.isEmpty()) {
				Thread.sleep(1000);
				BOM.ClearOnRemarks();
				Thread.sleep(1000);
				BOM.EnterOnRemarks(Remarks);
			}
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update valid GUID in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_valid_guid_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String GUID = testdata.get(int1).get("GUID");
			if (GUID != null && !GUID.isEmpty()) {
				Thread.sleep(2000);
				BOM.ClearOnGUID();
				Thread.sleep(1000);
				BOM.EnterOnGUID(GUID);
			}		
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Update Uploading valid QR code file in the Attach QR code field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void update_uploading_valid_qr_code_file_in_the_attach_qr_code_field_in_bom_boq_using_sheetname_and_rownumber(
			String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String QRCode = testdata.get(int1).get("QR Code");
			if (QRCode != null && !QRCode.isEmpty()) {
				Thread.sleep(2000);
				BOM.UploadingQRCode(QRCode);
			}
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Clicking on Add Properties button to update and entering values in the field Property name and Property value using sheetname {string} and rownumber {int}")
	public void clicking_on_add_properties_button_to_update_and_entering_values_in_the_field_property_name_and_property_value_using_sheetname_and_rownumber(
			String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			for (int rownumber1 = 0; rownumber1 < testdata.size(); rownumber1++) {
				String propertyNameValue = testdata.get(rownumber1).get("Property Name");
				String propertyValueValue = testdata.get(rownumber1).get("Property Value");
				if (propertyNameValue == null || propertyNameValue.isEmpty() || propertyValueValue == null
						|| propertyValueValue.isEmpty()) {
					System.out.println("No data found for Property Name or Property Value at row " + (rownumber1 + 1)
							+ ". Skipping this row.");
					continue; // Skip this row if missing data
				}
				System.out.println("Adding Property: " + propertyNameValue + " with Value: " + propertyValueValue);
				Thread.sleep(1000);
				BOM.ClickOnAddPropertiesButton();
				Thread.sleep(1000);
				BOM.EnterOnPropertyName(propertyNameValue);
				BOM.EnterOnPropertyValue(propertyValueValue);
				Thread.sleep(2000);
				BOM.ClickOnSubmitButton();
				System.out.println("Property Submitted for row " + (rownumber1 + 1));
				Thread.sleep(2000);
			}
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}

	@Then("Clicking on Update button to Update BOM for the project")
	public void clicking_on_update_button_to_update_bom_for_the_project() throws Exception {
		try {
			Thread.sleep(4000);
			RFA.ClickOnUpdate();
			Thread.sleep(4000);
			
		}
		catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit BOM Page");
			throw e;
		}
	}



	// Attachments -> Edit Checklist

	@Then("Entering values in checklist fields and items using sheetnames {string} and {string} with rownumber {int}")
	public void enteringValuesInChecklistFieldsAndItems(String checklistSheet, String checklistItemsSheet,
			int rownumber) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(checklistSheet);
		String ProjectCode = testdata.get(rownumber).get("Project code");
		Thread.sleep(2000);
		D.ClickOnDesignProject();
		Thread.sleep(4000);
		D.EnterOnSearchBox(ProjectCode);
		Thread.sleep(2000);
		D.clickOnProject(ProjectCode);
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(4000);
		BOM.ClickOnAttachments();
		Thread.sleep(3000);
		Chk.ClickOnCheckList();
		Thread.sleep(4000);
		String OldChecklistCode = testdata.get(rownumber).get("Old Checklist Code");
		Thread.sleep(4000);
		D.clickOnActionButtonForProject(OldChecklistCode);

	}
	

	@Then("Update valid code on checklist Code field using sheetname {string} and rownumber {int}")
	public void update_valid_code_on_checklist_code_field_using_sheetname_and_rownumber(String checklistSheet, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(checklistSheet);
			String Code = testdata.get(int1).get("Checklist Code");
			if (Code != null && !Code.isEmpty()) {
				Thread.sleep(1000);
				Chk.ClearOnCheckListCode();
				Thread.sleep(1000);
				Chk.EnterOnCheckListCode(Code);
			}
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Checklist Page");
			throw e;
		}
	}

	@Then("Update valid Name on checklist Name field using sheetname {string} and rownumber {int}")
	public void update_valid_name_on_checklist_name_field_using_sheetname_and_rownumber(String checklistSheet, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(checklistSheet);
			
			String Name = testdata.get(int1).get("Checklist Name");
			if (Name != null && !Name.isEmpty()) {
				Thread.sleep(1000);
				Chk.ClearOnCheckListTitle();
				Thread.sleep(1000);
				Chk.EnterOnCheckListTitle(Name);
			}
			
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Checklist Page");
			throw e;
		}
	}

	@Then("Update values under Checklist Item Fields using sheetname {string} and rownumber {int}")
	public void update_values_under_checklist_item_fields_using_sheetname_and_rownumber(String checklistItemsSheet, Integer rownumber) throws Exception {
		try {
					
			List<Map<String, String>> checklistItemsData = excelDataManager.getCachedData(checklistItemsSheet);
			int totalRows = checklistItemsData.size();

			for (int i = rownumber; i < totalRows; i++) {
				String itemName = checklistItemsData.get(i).get("Checklist item Name");
				String category = checklistItemsData.get(i).get("Category");
				String priority = checklistItemsData.get(i).get("Priority");
				String description = checklistItemsData.get(i).get("Description");

				// Stop processing if the key column (Checklist item Name) is empty
				if (itemName == null || itemName.trim().isEmpty()) {
					System.out.println("Empty data encountered at row: " + i + ". Stopping further processing.");
					break;
				}

				// Fill in Checklist Item fields
				Thread.sleep(1000);
				Chk.ClearOnName();
				Chk.EnterOnName(itemName);
				LoginInputDatas("ChecklistitemName", itemName);

				// Enter Category
				Thread.sleep(1000);
				Chk.prioritydropdownclick();
				Thread.sleep(1000);
				Chk.SelectPrioritydropdown(category);
				LoginInputDatas("Category", category);

				// Enter Priority
				Thread.sleep(1000);
				RFA.prioritydropdownclick();
				Thread.sleep(1000);
				RFA.SelectPrioritydropdown(priority);
				LoginInputDatas("Priority", priority);

				// Enter Description
				Thread.sleep(1000);
				Chk.ClearOnDescription();
				Chk.EnterOnDescription(description);
				LoginInputDatas("Description", description);

				// Click "Add Row" for next entry
				Thread.sleep(1000);
				Chk.ClickOnAddRow();
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
			}
			
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Checklist Page");
			throw e;
		}
	}

	@Then("Click on Update Button to update checklist")
	public void click_on_update_button_to_update_checklist() throws Exception {
		try {
			Thread.sleep(4000);
			RFA.ClickOnUpdate();
			Thread.sleep(4000);
			
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Checklist Page");
			throw e;
		}
	}





	private void takeScreenshot(int rowNumber) {
		try {
			// Take a screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = "C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\screenshot\\" + rowNumber
					+ ".png";

			// Save the screenshot to the specified path
			FileUtils.copyFile(screenshot, new File(screenshotPath));

			// Attach the screenshot to the Allure report
			Allure.addAttachment("Screenshot for Row " + rowNumber,
					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

			// Attach the screenshot to the Extent report
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private void takeScreenshotStr(String rowNumber) {
		try {
			// Take a screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = "C:\\Users\\TWINUser13\\eclipse-workspace\\Automation\\screenshot\\" + rowNumber
					+ ".png";

			// Save the screenshot to the specified path
			FileUtils.copyFile(screenshot, new File(screenshotPath));

			// Attach the screenshot to the Allure report
			Allure.addAttachment("Screenshot for Row " + rowNumber,
					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

			// Attach the screenshot to the Extent report
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private void performTabKeyPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	private void LoginInputDatas(String fieldName, String fieldValue) {

		test = ExtentCucumberAdapter.getCurrentStep();

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldName + "</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldValue + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { fieldName }, { fieldValue }, };
		Markup m = MarkupHelper.createTable(data);

		// Log the table in Extent Report
		test.log(Status.PASS, m);
	}

}
