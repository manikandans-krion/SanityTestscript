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
import Locators.ChecklistLocators;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class DesingProjectTestcases {

	private WebDriver driver;
	private Locators.LoginLocators L;
	private Locators.Design_Projects_Locators D;
	private Locators.Roles_Locators R;
	private Locators.AssignRole_Locators AR;
	private Locators.WorkFlowLocators WF;
	private Locators.Review_Actions_Locators RVW;
	private Locators.Issue_Locators ISU;
	private Locators.RFA_Locators RFA;
	private Locators.RFILocators RFI;
	private Locators.Meeting_Share_Locators MET;
	private Locators.BOM_BOQ_Attachments_Locators BOM;
	private Locators.ChecklistLocators Chk;
	private ExtentTest test;
	private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
	private List<List<String>> approvalSteps;

	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager.loadData(
				"C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public DesingProjectTestcases() throws InterruptedException {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.R = new Locators.Roles_Locators(driver);
		this.AR = new Locators.AssignRole_Locators(driver);
		this.WF = new Locators.WorkFlowLocators(driver);
		this.RVW = new Locators.Review_Actions_Locators(driver);
		this.ISU = new Locators.Issue_Locators(driver);
		this.RFA = new Locators.RFA_Locators(driver);
		this.RFI = new Locators.RFILocators(driver);
		this.MET = new Locators.Meeting_Share_Locators(driver);
		this.BOM = new Locators.BOM_BOQ_Attachments_Locators(driver);
		this.Chk = new Locators.ChecklistLocators(driver);
		this.D = new Locators.Design_Projects_Locators(driver);
	}

	@Given("I visit the User Login for Design Projects using sheetname {string} and rownumber {int}")
	public void i_visit_the_user_login_for_Design_projects_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			String email = testdata.get(rownumber).get("Login Email");
			String password = testdata.get(rownumber).get("Login Password");

			if (password.matches("\\d+(\\.\\d+)?")) { // Check if password is numeric
				password = password.replaceAll("\\.0$", ""); // Remove the decimal if it's a whole number
			}

			L = new Locators.LoginLocators(driver);
			L.EnterEmail(email);
			L.EnterPassword(password);

			LoginInputDatas("Email", email);
			LoginInputDatas("Password", password);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Login Page");
			throw e;
		}
	}

	@Given("I enter the credentials in login and click a login button")
	public void i_enter_the_credentials_in_login_and_click_a_login_button() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			L.ClickOnLogin();

			if (D.isElementVisible(D.Error)) {
				System.out.println("Login not successful due to invalid password or username");
				Assert.assertEquals(D.isElementVisible(D.Error), "Error");
			} else {
				System.out.println("Login Successful");
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Login Page");
			throw e;
		}
	}

	@Then("Clicking on Project module under Design section")
	public void clicking_on_project_module_under_design_section() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(1000);
			D.ClickOnDesignProject();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Main Page");
			throw e;
		}
	}

	@Then("Click on ADD Project button to create new project")
	public void Click_on_ADD_Project_button_to_create_new_project() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			D.ClickOnAddProjectButton();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Choosing whether to create ISO project or Non-ISO project using sheetname {string} and rownumber {int}")
	public void Choosing_whether_to_create_ISO_project_or_Non_ISO_project(String sheetname, int rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String WithOrWithoutISOProject = testdata.get(rownumber).get("With or Without ISO Project");
			Thread.sleep(2000);
			if (WithOrWithoutISOProject != null && !WithOrWithoutISOProject.isEmpty()) {
				int WithOrWithoutISOProjectStatus = Integer.parseInt(WithOrWithoutISOProject.split("\\.")[0]);
				System.out.println(WithOrWithoutISOProjectStatus + "--->WithOrWithoutISOProjectStatus");
				if (WithOrWithoutISOProjectStatus == 1) {
					Thread.sleep(1000);
					D.ClickOnProjectWithoutISO();
				}
			}

			LoginInputDatas("WithOrWithoutISOProject", WithOrWithoutISOProject);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}

	}

	@Then("Clicking on Project template field and selecting the template using sheetname {string} and rownumber {int}")
	public void clicking_on_project_template_field_and_selecting_the_template_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ProjectTemplate = testdata.get(rownumber).get("Project Template");
			Thread.sleep(1000);
			D.ClickOnProjectTemplate();
			D.EnterOnProjectTemplate(ProjectTemplate);
			D.selectDropdownOption(ProjectTemplate);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("ProjectTemplate", ProjectTemplate);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}

	}

	@Then("Entering valid project code using sheetname {string} and rownumber {int}")
	public void entering_valid_project_code_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ProjectCode = testdata.get(rownumber).get("Project code");
			Thread.sleep(1000);
			D.ClickOnProjectCode();
			D.ClearOnProjectCode();
			D.EnterOnProjectCode(ProjectCode);
			LoginInputDatas("ProjectCode", ProjectCode);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering valid project name using sheetname {string} and rownumber {int}")
	public void entering_valid_project_name_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ProjectName = testdata.get(rownumber).get("Project name");
			Thread.sleep(1000);
			D.ClickOnProjectName();
			D.ClearOnProjectName();
			D.EnterOnProjectName(ProjectName);
			LoginInputDatas("ProjectName", ProjectName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering valid project description using sheetname {string} and rownumber {int}")
	public void entering_valid_project_description_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ProjectDescrpt = testdata.get(rownumber).get("Project Description");
			Thread.sleep(1000);
			D.ClickOnProjectDescrpt();
			D.ClearOnProjectDescrpt();
			D.EnterOnProjectDescrpt(ProjectDescrpt);
			LoginInputDatas("ProjectDescrpt", ProjectDescrpt);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering Start Date of the project using sheetname {string} and rownumber {int}")
	public void entering_Start_Date_of_the_project(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ProjectStartDate = testdata.get(rownumber).get("start date");
			String ProjectStartMonth = testdata.get(rownumber).get("start month");
			String ProjectStartYear = testdata.get(rownumber).get("start year");

			if (ProjectStartYear != null && ProjectStartYear.matches("\\d+\\.0")) {
				ProjectStartYear = ProjectStartYear.substring(0, ProjectStartYear.indexOf(".0"));

				Thread.sleep(1000);
				D.ClickOnStartDate();
				D.ClearOnStartDate();
				D.EnterOnStartDate(ProjectStartDate);
				D.EnterOnStartDate(ProjectStartMonth);
				D.EnterOnStartDate(ProjectStartYear);
				LoginInputDatas("ProjectStartDate", ProjectStartDate);
				LoginInputDatas("ProjectStartMonth", ProjectStartMonth);
				LoginInputDatas("ProjectStartYear", ProjectStartYear);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Enter and select the project design type from drop-down using sheetname {string} and rownumber {int}")
	public void enter_and_select_the_project_design_type_from_drop_down_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ProjectDesigntype = testdata.get(rownumber).get("Design type");
			Thread.sleep(1000);
			D.ClickOnProjectDesignType();
			Thread.sleep(2000);
			D.EnterOnProjectDesignType(ProjectDesigntype);
			D.selectDropdownOption(ProjectDesigntype);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("ProjectDesigntype", ProjectDesigntype);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Enter and select the project category type from drop-down using sheetname {string} and rownumber {int}")
	public void enter_and_select_the_project_category_type_from_drop_down_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Projectcategory = testdata.get(rownumber).get("category");
			Thread.sleep(1000);
			D.EnterOnProjectCategory(Projectcategory);
			D.selectDropdownOption(Projectcategory);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("Projectcategory", Projectcategory);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Enter and select the project owner type from drop-down using sheetname {string} and rownumber {int}")
	public void enter_and_select_the_project_owner_type_from_drop_down_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ProjectOwner = testdata.get(rownumber).get("Owner");
			Thread.sleep(1000);
			D.ClickOnProjectOwnerSelection();
			D.EnterOnProjectOwnerSelection(ProjectOwner);
			D.selectDropdownOption(ProjectOwner);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("ProjectOwner", ProjectOwner);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Enter and select the project status type from drop-down using sheetname {string} and rownumber {int}")
	public void enter_and_select_the_project_status_type_from_drop_down_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Projectstatus = testdata.get(rownumber).get("status");
			Thread.sleep(1000);
			D.ClickOnProjectStatus();
			D.EnterOnProjectStatus(Projectstatus);
			D.selectDropdownOption(Projectstatus);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("Projectstatus", Projectstatus);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering address in address line one field using sheetname {string} and rownumber {int}")
	public void entering_address_in_address_line_one_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String AddressLine1 = testdata.get(rownumber).get("Address Line1");
			Thread.sleep(1000);
			D.EnterOnAddressLine1(AddressLine1);
			LoginInputDatas("AddressLine1", AddressLine1);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering address in address line two field using sheetname {string} and rownumber {int}")
	public void entering_address_in_address_line_two_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String AddressLine2 = testdata.get(rownumber).get("Address Line2");
			Thread.sleep(1000);
			D.EnterOnAddressLine2(AddressLine2);
			LoginInputDatas("AddressLine2", AddressLine2);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering City name in the field using sheetname {string} and rownumber {int}")
	public void entering_city_name_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String City = testdata.get(rownumber).get("city");
			Thread.sleep(1000);
			D.EnterOnCity(City);
			LoginInputDatas("City", City);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering State name in the field using sheetname {string} and rownumber {int}")
	public void entering_state_name_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String State = testdata.get(rownumber).get("state");
			Thread.sleep(1000);
			D.EnterOnState(State);
			LoginInputDatas("State", State);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering valid Pincode in the field using sheetname {string} and rownumber {int}")
	public void entering_valid_pincode_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Pincode = testdata.get(rownumber).get("postal code");

			if (Pincode != null && Pincode.matches("\\d+\\.0")) {
				Pincode = Pincode.substring(0, Pincode.indexOf(".0"));

				Thread.sleep(1000);
				D.EnterOnPincode(Pincode);
				LoginInputDatas("Pincode", Pincode);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Entering Country name in the field using sheetname {string} and rownumber {int}")
	public void entering_country_name_in_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Country = testdata.get(rownumber).get("country");
			Thread.sleep(1000);
			D.EnterOnCountry(Country);
			LoginInputDatas("Country", Country);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}
	}

	@Then("Click on Create button to create new project")
	public void Click_on_Create_button_to_create_new_project() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			R.ClickOnCreateButton();

			if (D.isElementVisible(D.Error)) {
				System.out.println("Project Not Created due to Error Message");
				Assert.assertEquals(D.isElementVisible(D.Error), "Error");
			} else {
				System.out.println("Project Created Successfully");
			}

		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error.");
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add project Page");
			throw e;
		}

	}

	// Assigning Role for the Created Project but First we need to find the created
	// project from the list or from the table by searching in the search-box by its
	// name

	@Then("filtering the required project and clickin on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_project_and_clickin_on_it_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws AWTException, InterruptedException {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			String projectcode = testdata.get(rownumber).get("Project code");
			Thread.sleep(4000);
			AR.EnterOnSearchBox(projectcode);
			Thread.sleep(2000);
			AR.clickOnProject(projectcode);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Assigning Role Page");
			throw e;
		}
	}

	@Then("Clciking on Setting module in newly Created Project under Design module")
	public void clciking_on_setting_module_in_newly_created_project_under_design_module() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			AR.ClickOnSetting();
			Thread.sleep(2000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning Page");
			throw e;
		}
	}

	// Assign Module

	@Then("Clciking on Assign role sub-module under settings in newly Created Project under Design module")
	public void clciking_on_assign_role_sub_module_under_settings_in_newly_created_project_under_design_module() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			AR.ClickOnAssignRole();
			Thread.sleep(2000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning Page");
			throw e;
		}
	}

	@Then("Clicking on Assign Role button to assigning the role to the user")
	public void clicking_on_assign_role_button_to_assigning_the_role_to_the_user() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			AR.ClickOnAssignRoleButton();
			Thread.sleep(2000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning Page");
			throw e;
		}
	}

	// Assign Role

	@Then("Clicking on Select role drop-down to select the required role from the list using sheetname {string} and rownumber {int}")
	public void clicking_on_select_role_drop_down_to_select_the_required_role_from_the_list_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String RoleName = testdata.get(rownumber).get("Role");
			Thread.sleep(1000);
			// AR.ClickOnSelectTheRole();
			Thread.sleep(1000);
			// AR.selectDropdownOptionForRole(RoleName);
			AR.selectRole(RoleName);
			LoginInputDatas("RoleName", RoleName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning Page");
			throw e;
		}
	}

	@Then("Clicking on Add user drop-down to select the required number of users from the list sheetname {string} and rownumber {int}")
	public void clicking_on_add_user_drop_down_to_select_the_required_number_of_users_from_the_list_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			List<Map<String, String>> userData = excelDataManager.getCachedData(sheetname);
			Thread.sleep(1000);
			for (Map<String, String> row : userData) {
				String userName = row.get("Add user"); // Adjust based on your Excel column header
				if (userName != null && !userName.trim().isEmpty()) {
					System.out.println(userName);
					Thread.sleep(1000);
					AR.ClickOnAddUser();
					Thread.sleep(1000);
					AR.selectUser(userName);
					Thread.sleep(2000);
				} else {
					System.out.println("No more users to select, stopping the selection process.");
					break;
				}
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning Page");
			throw e;
		}
	}

	@Then("Clicking on Assign button to assing the role for the desire number of users")
	public void Clicking_on_Assign_button_to_assing_the_role_for_the_desire_number_of_users() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(3000);
			AR.ClickOnAssignButton();
			Thread.sleep(3000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning Page");
			throw e;
		}
	}

	// Assign Role For Group

	@Then("Clicking on Assign Role for Group tab")
	public void clicking_on_assign_role_for_group_tab() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(4000);
			AR.ClickOnSetting();
			Thread.sleep(4000);
			AR.ClickOnAssignRole();
			Thread.sleep(4000);
			AR.ClickOnAssignRoleForGroupTab();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning group Page");
			throw e;
		}
	}

	@Then("Clickingon Assign Role Group button to create a group")
	public void clickingon_assign_role_group_button_to_create_a_group() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			AR.ClickOnAssignRoleForGroupButton();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning group Page");
			throw e;
		}
	}

	@Then("Clicking on Select role drop-down to select the required role from the list for Group using sheetname {string} and rownumber {int}")
	public void clicking_on_select_role_drop_down_to_select_the_required_role_from_the_list_for_group_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String RoleName = testdata.get(rownumber).get("Role For Group");
			Thread.sleep(1000);
			// AR.ClickOnSelectTheRoleInGroup();
			Thread.sleep(1000);
			// AR.selectDropdownOptionForRoleGroup(RoleName);
			AR.selectroleforgroup(RoleName);
			LoginInputDatas("RoleName for Group", RoleName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning group Page");
			throw e;
		}
	}

	@Then("Clicking on Add group drop-down to select the required number of users from the list sheetname {string} and rownumber {int}")
	public void clicking_on_add_group_drop_down_to_select_the_required_number_of_users_from_the_list_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			List<Map<String, String>> userData = excelDataManager.getCachedData(sheetname);
			Thread.sleep(1000);

			for (Map<String, String> row : userData) {
				String userName = row.get("Add group"); // Adjust based on your Excel column header
				if (userName != null && !userName.isEmpty()) {
					System.out.println(userName);
					Thread.sleep(3000);
					AR.ClickOnAddGroup();
					Thread.sleep(1000);
					AR.selectuserGroup(userName);
					Thread.sleep(2000);
				} else {
					System.out.println("No more users to select, stopping the selection process.");
					break;
				}
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning Page");
			throw e;
		}
	}

	@Then("Clicking on Assign button to assing the role for the desire number of users users in group")
	public void clicking_on_assign_button_to_assing_the_role_for_the_desire_number_of_users_users_in_group() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			AR.ClickOnAssignButton();
			Thread.sleep(5000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Role Assigning Page");
			throw e;
		}
	}

	// Workflow Creation

	// Actions - > Review Creation flow

	@Then("Clicking on Action module from sidebar")
	public void clicking_on_action_module_from_sidebar() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(2000);
			RVW.ClickOnActions();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Work Flow creation Page");
			throw e;
		}
	}

	@Then("Clicking on Review sub-module from sidebar")
	public void clicking_on_review_sub_module_from_sidebar() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(2000);
			RVW.ClickOnReview();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Work Flow creation Page");
			throw e;
		}
	}

	@Then("Clicking on ADD button to create Add review")
	public void clicking_on_add_button_to_create_add_review() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(2000);
			RVW.ClickOnAddButton();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Work Flow creation Page");
			throw e;
		}
	}

	@Then("Selecting Parent Review name from the drop-down using sheetname {string} and rownumber {int}")
	public void selecting_parent_review_name_from_the_drop_down_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ParentReview = testdata.get(rownumber).get("Parent Review");
			Thread.sleep(1000);
			RVW.ClickOnParentReview();
			Thread.sleep(1000);
			RVW.selectDropdownOption(ParentReview);
			performTabKeyPress();
			// performTabKeyPress();
			LoginInputDatas("ParentReview", ParentReview);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review creation Page");
			throw e;
		}
	}

	@Then("Entering  valid code on Review Code field using sheetname {string} and rownumber {int}")
	public void entering_valid_code_on_review_code_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ReviewCode = testdata.get(rownumber).get("Review Code");
			Thread.sleep(1000);
			RVW.ClearOnReviewCode();
			Thread.sleep(1000);
			if (ReviewCode != null && !ReviewCode.isEmpty()) {
				RVW.EnterOnReviewCode(ReviewCode);
			}
			String suffix = testdata.get(rownumber).get("Suffix code");
			if (suffix != null && suffix.matches("\\d+\\.0")) {
				suffix = suffix.substring(0, suffix.indexOf(".0"));
			}
			System.out.println("====Suffix vale =============:" + suffix);

			RVW.enterSuffix(suffix);

			LoginInputDatas("ReviewCode", ReviewCode);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review creation Page");
			throw e;
		}
	}

	@Then("Entering valid name on Review Name field using sheetname {string} and rownumber {int}")
	public void entering_valid_name_on_review_name_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ReviewName = testdata.get(rownumber).get("Review Name");
			RVW.EnterOnReviewName(ReviewName);
			LoginInputDatas("ReviewCode", ReviewName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review creation Page");
			throw e;
		}
	}

	@Then("Entering Description on the field using sheetname {string} and rownumber {int}")
	public void entering_description_on_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Description = testdata.get(rownumber).get("Description");
			RVW.ClearOnDescription();
			Thread.sleep(1000);
			RVW.EnterOnDescription(Description);
			LoginInputDatas("Description", Description);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review creation Page");
			throw e;
		}
	}

	@Then("Entering valid start date on the field using sheetname {string} and rownumber {int}")
	public void entering_valid_start_date_on_the_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ReviewStartDate = testdata.get(rownumber).get("Start Date");
			String ReviewStartMonth = testdata.get(rownumber).get("Start Month");
			String ReviewStartYear = testdata.get(rownumber).get("Start Year");

			if (ReviewStartYear != null && ReviewStartYear.matches("\\d+\\.0")) {
				ReviewStartYear = ReviewStartYear.substring(0, ReviewStartYear.indexOf(".0"));
			}
			if (ReviewStartMonth != null && ReviewStartMonth.matches("\\d+\\.0")) {
				ReviewStartMonth = ReviewStartMonth.substring(0, ReviewStartMonth.indexOf(".0"));
			}
			if (ReviewStartDate != null && ReviewStartDate.matches("\\d+\\.0")) {
				ReviewStartDate = ReviewStartDate.substring(0, ReviewStartDate.indexOf(".0"));
			}

			Thread.sleep(1000);
			RVW.ClickOnStartDate();
			RVW.ClearOnStartDate();
			RVW.EnterOnStartDate(ReviewStartDate);
			RVW.EnterOnStartDate(ReviewStartMonth);
			RVW.EnterOnStartDate(ReviewStartYear);
			LoginInputDatas("ReviewStartDate", ReviewStartDate);
			LoginInputDatas("ReviewStartMonth", ReviewStartMonth);
			LoginInputDatas("ReviewStartYear", ReviewStartYear);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review Page");
			throw e;
		}
	}

	@Then("Entering valid End date on the field using sheetname {string} and rownumber {int}")
	public void entering_valid_end_date_on_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ReviewEndDate = testdata.get(rownumber).get("End Date");
			String ReviewEndMonth = testdata.get(rownumber).get("End Month");
			String ReviewEndYear = testdata.get(rownumber).get("End Year");

			if (ReviewEndYear != null && ReviewEndYear.matches("\\d+\\.0")) {
				ReviewEndYear = ReviewEndYear.substring(0, ReviewEndYear.indexOf(".0"));
			}
			
			if (ReviewEndMonth != null && ReviewEndMonth.matches("\\d+\\.0")) {
				ReviewEndMonth = ReviewEndMonth.substring(0, ReviewEndMonth.indexOf(".0"));
			}

			if (ReviewEndDate != null && ReviewEndDate.matches("\\d+\\.0")) {
				ReviewEndDate = ReviewEndDate.substring(0, ReviewEndDate.indexOf(".0"));
			}

			Thread.sleep(1000);
			RVW.ClickOnEndDate();
			RVW.ClearOnEndDate();
			RVW.EnterOnEndDate(ReviewEndMonth);
			RVW.EnterOnEndDate(ReviewEndDate);
			
			RVW.EnterOnEndDate(ReviewEndYear);
			LoginInputDatas("ReviewEndDate", ReviewEndDate);
			LoginInputDatas("ReviewEndMonth", ReviewEndMonth);
			LoginInputDatas("ReviewEndYear", ReviewEndYear);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review Page");
			throw e;
		}
	}

	@Then("Selecting workflow on the field using sheetname {string} and rownumber {int}")
	public void selecting_workflow_on_the_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Workflow = testdata.get(rownumber).get("Workflow");
			System.out.println(Workflow);
			Thread.sleep(1000);
			RFI.workflowselection(Workflow);
//    RVW.ClickonWorkFlow();
//    Thread.sleep(1000);
//    RVW.EnterOnWorkFlow(Workflow);
//    Thread.sleep(1000);
//    RVW.selectDropdownOptionForWorkFlow(Workflow);
			LoginInputDatas("Workflow", Workflow);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review Page");
			throw e;
		}
	}

	@Then("Selecting priority from the drop-down using sheetname {string} and rownumber {int}")
	public void selecting_priority_from_the_drop_down_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Priority = testdata.get(rownumber).get("Priority");
			System.out.println(Priority);
			Thread.sleep(1000);
			RFI.prioritydropdownclick();
//		RVW.ClickOnPriority();		
//		Thread.sleep(1000);
//		RVW.EnterOnPriority(Priority);
			Thread.sleep(1000);
			RFI.SelectPrioritydropdown(Priority);
//		RVW.selectDropdownOptionForPriority(Priority);
			LoginInputDatas("Priority", Priority);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review Page");
			throw e;
		}
	}

	@Then("Entering valid Estimate cost in the field using sheetname {string} and rownumber {int}")
	public void entering_valid_estimate_cost_in_the_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String EstimateCost = testdata.get(rownumber).get("Estimate Cost");
			RVW.ClickOnEstimateCost();
			RVW.ClearOnEstimateCost();
			Thread.sleep(1000);
			RVW.EnterOnEstimateCost(EstimateCost);
			LoginInputDatas("EstimateCost", EstimateCost);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review Page");
			throw e;
		}
	}

	@Then("Entering valid Actual cost in the field using sheetname {string} and rownumber {int}")
	public void entering_valid_actual_cost_in_the_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ActualCost = testdata.get(rownumber).get("Actual Cost");
			RVW.ClickOnActualCost();
			RVW.ClearOnActualCost();
			Thread.sleep(1000);
			RVW.EnterOnActualCost(ActualCost);
			LoginInputDatas("ActualCost", ActualCost);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review Page");
			throw e;
		}
	}

	@Then("Selecting checklist from the drop-down using sheetname {string} and rownumber {int}")
	public void selecting_checklist_from_the_drop_down_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Attachfile = testdata.get(rownumber).get("Attachfile");
			String FileName = testdata.get(rownumber).get("File Name");
			Thread.sleep(1000);
			RVW.ClickOnAttachFiles();
			Thread.sleep(1000);
			RVW.attachFile(Attachfile, FileName);
			Thread.sleep(1000);
			RVW.clickOnRequiredFile(FileName);
			Thread.sleep(2000);
			RVW.ClickOnAttachButton();
			Thread.sleep(2000);
			// RVW.ClickOnCreateButton();
			LoginInputDatas("Attachfile", Attachfile);
			LoginInputDatas("FileName", FileName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review Page");
			throw e;
		}
	}

	@Then("Clicking on Create button to create a Review for the project")
	public void Clicking_on_Create_button_to_create_a_Review_for_the_project() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			RVW.ClickOnCreateButton();
// 			if (D.isElementVisible(D.Error)) {
//                System.out.println("Review Not Created due to Error Message");
//                Assert.assertEquals(D.isElementVisible(D.Error), "Error");
//            } else {
//                System.out.println("Review Created Successfully");
//            }
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Review Page");
			throw e;
		}
	}

	// Actions - > Issue page Creation

	@Then("Clicking on Issues sub-module from sidebar")
	public void Clicking_on_Issues_sub_module_from_sidebar() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			ISU.ClickOnIssues();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Clicking on ADD button to create Add Issues")
	public void Clicking_on_ADD_button_to_create_Add_Issues() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			ISU.ClickOnAddButton();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Entering valid code on Issue Code field using sheetname {string} and rownumber {int}")
	public void Entering_valid_code_on_Issue_Code_field(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
			
			String IssueCode = testdata.get(rownumber).get("Issue Code");
			ISU.ClickOnIssueCode();
			ISU.ClearOnIssueCode();
			Thread.sleep(1000);
			if(IssueCode!=null && !IssueCode.isEmpty()) {
				ISU.EnterOnIssueCode(IssueCode);
			}
			String IssueCode1 = testdata.get(rownumber).get("Suffix code");
			ISU.ClickOnIssueCode();
			ISU.ClearOnIssueCode();
			Thread.sleep(1000);
			if(IssueCode1!=null && !IssueCode1.isEmpty() && IssueCode1.matches("\\d+\\.0")) {
				IssueCode1=IssueCode1.substring(0, IssueCode1.indexOf(".0"));
				ISU.EnterOnIssueCode(IssueCode1);
			}
			
			LoginInputDatas("IssueCode", IssueCode);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Entering valid name on Name field using sheetname {string} and rownumber {int}")
	public void Entering_valid_name_on_name_field(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Name = testdata.get(rownumber).get("Name");
			ISU.EnterOnName(Name);
			LoginInputDatas("Name", Name);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Entering Description on the field in add issue using sheetname {string} and rownumber {int}")
	public void Entering_Description_on_the_field_in_add_issue(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Description = testdata.get(rownumber).get("Description");
			ISU.ClearOnDescription();
			Thread.sleep(1000);
			ISU.EnterOnDescription(Description);
			LoginInputDatas("Description", Description);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Entering valid start date on the field in add issue using sheetname {string} and rownumber {int}")
	public void entering_valid_start_date_on_the_field_in_add_issue_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String IssueStartDate = testdata.get(rownumber).get("Start Date");
			String IssueStartMonth = testdata.get(rownumber).get("Start Month");
			String IssueStartYear = testdata.get(rownumber).get("Start Year");

			if (IssueStartYear != null && IssueStartYear.matches("\\d+\\.0")) {
				IssueStartYear = IssueStartYear.substring(0, IssueStartYear.indexOf(".0"));

				Thread.sleep(1000);
				ISU.ClickOnStartDate();
				ISU.ClearOnStartDate();
				ISU.EnterOnStartDate(IssueStartDate);
				ISU.EnterOnStartDate(IssueStartMonth);
				ISU.EnterOnStartDate(IssueStartYear);
				LoginInputDatas("IssueStartDate", IssueStartDate);
				LoginInputDatas("IssueStartMonth", IssueStartMonth);
				LoginInputDatas("IssueStartYear", IssueStartYear);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Entering valid Due date on the field in add issue using sheetname {string} and rownumber {int}")
	public void entering_valid_due_date_on_the_field_in_add_issue_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String IssueEndDate = testdata.get(rownumber).get("Due Date");
			String IssueEndMonth = testdata.get(rownumber).get("Due Month");
			String IssueEndYear = testdata.get(rownumber).get("Due Year");

			if (IssueEndYear != null && IssueEndYear.matches("\\d+\\.0")) {
				IssueEndYear = IssueEndYear.substring(0, IssueEndYear.indexOf(".0"));

				Thread.sleep(1000);
				ISU.ClickOnDueDate();
				ISU.ClearOnDueDate();
				ISU.EnterOnDueDate(IssueEndMonth);
				ISU.EnterOnDueDate(IssueEndDate);
				
				ISU.EnterOnDueDate(IssueEndYear);
				LoginInputDatas("IssueEndDate", IssueEndDate);
				LoginInputDatas("IssueEndMonth", IssueEndMonth);
				LoginInputDatas("IssueEndYear", IssueEndYear);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Selecting Type from the drop-down using sheetname {string} and rownumber {int}")
	public void Selecting_Type_from_the_drop_down(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Type = testdata.get(rownumber).get("Type");
			Thread.sleep(1000);
			ISU.typedropdownclick();
			Thread.sleep(1000);
			ISU.Selecttypedropdown(Type);
//        ISU.ClickOnType();
//        ISU.EnterOnType(Type);
//        ISU.selectDropdownOption(Type);
			Thread.sleep(1000);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("Type", Type);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}

	}

	@Then("Selecting Placement from the drop-down using sheetname {string} and rownumber {int}")
	public void Selecting_Placement_from_the_drop_down(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Placement = testdata.get(rownumber).get("Placement");
			Thread.sleep(1000);
			ISU.placementdropdownclick();
			Thread.sleep(1000);
			ISU.Selectplacementdropdown(Placement);
//        ISU.ClickOnPlacement();
//        ISU.EnterOnPlacement(Placement);
//        ISU.selectDropdownOption(Placement);
			Thread.sleep(1000);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("Placement", Placement);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Selecting Root cause from the drop-down using sheetname {string} and rownumber {int}")
	public void Selecting_Root_cause_from_the_drop_down(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Rootcause = testdata.get(rownumber).get("Root Cause");
			Thread.sleep(1000);
			ISU.rootcausedropdownclick();
			Thread.sleep(1000);
			ISU.Selectrootcausedropdown(Rootcause);
//        ISU.ClickOnRootCause();
//        ISU.EnterOnRootCause(Rootcause);
//        ISU.selectDropdownOption(Rootcause);
			Thread.sleep(1000);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("Rootcause", Rootcause);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Selecting Workflow from the drop-down in add issue using sheetname {string} and rownumber {int}")
	public void selecting_workflow_from_the_drop_down_in_add_issue_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Workflow = testdata.get(rownumber).get("Workflow");
			Thread.sleep(1000);
			RFI.workflowselection(Workflow);
//        ISU.ClickOnWorkflow();
//        ISU.EnterOnWorkflow(Workflow);
//        ISU.selectDropdownOption(Workflow);
			Thread.sleep(1000);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("Workflow", Workflow);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Entering Location in the field in add issue using sheetname {string} and rownumber {int}")
	public void Entering_Location_in_the_field_in_add_issue(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Location = testdata.get(rownumber).get("Location");
			Thread.sleep(1000);
			ISU.EnterOnLocation(Location);
			LoginInputDatas("Location", Location);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Entering valid Estimate cost in the field in add issue using sheetname {string} and rownumber {int}")
	public void entering_valid_estimate_cost_in_the_field_in_add_issue_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String EstimateCost = testdata.get(rownumber).get("Estimate Cost");
			ISU.ClickOnEstimateCost();
			ISU.ClearOnEstimateCost();
			Thread.sleep(1000);
			ISU.EnterOnEstimateCost(EstimateCost);
			LoginInputDatas("EstimateCost", EstimateCost);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Entering valid Actual cost in the field in add issue using sheetname {string} and rownumber {int}")
	public void entering_valid_actual_cost_in_the_field_in_add_issue_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ActualCost = testdata.get(rownumber).get("Actual Cost");
			ISU.ClickOnActualCost();
			ISU.ClearOnActualCost();
			Thread.sleep(1000);
			ISU.EnterOnActualCost(ActualCost);
			LoginInputDatas("ActualCost", ActualCost);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Uploading an Image in the field in add issue using sheetname {string} and rownumber {int}")
	public void Uploading_an_Image_in_the_field_in_add_issue(String sheetname, int rownumber) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet data: " + testData);

			String imageFilePath = testData.get(rownumber).get("Upload Images");

			ISU.UploadingAnImage(imageFilePath);
			LoginInputDatas("imageFilePath", imageFilePath);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Selecting Attach files from the drop-down in add issue using sheetname {string} and rownumber {int}")
	public void Selecting_Attach_files_from_the_drop_down_in_add_issue(String sheetname, int rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Attachfile = testdata.get(rownumber).get("Attachfile");
			String FileName = testdata.get(rownumber).get("File Name");
			Thread.sleep(1000);
			RVW.ClickOnAttachFiles();
			Thread.sleep(1000);
			ISU.attachFile(Attachfile, FileName);
			Thread.sleep(1000);
			RVW.clickOnRequiredFile(FileName);
			Thread.sleep(2000);
			RVW.ClickOnAttachButton();
			LoginInputDatas("Attachfile", Attachfile);
			LoginInputDatas("FileName", FileName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Clicking on Create button to create a Issue in the project")
	public void Clicking_on_Create_button_to_create_a_Issue_in_the_project() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			RVW.ClickOnCreateButton();
// 			if (D.isElementVisible(D.Error)) {
//                System.out.println("Issue Not Created due to Error Message");
//                Assert.assertEquals(D.isElementVisible(D.Error), "Error");
//            } else {
//                System.out.println("Issue Created Successfully");
//            }
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	// Actions - > RFA page Creation

	@Then("Clicking on RFA sub-module from sidebar")
	public void Clicking_on_RFA_sub_module_from_sidebar() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			RFA.ClickOnRFA();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA Page");
			throw e;
		}
	}

	@Then("Clicking on ADD button to create Add RFA")
	public void Clicking_on_ADD_button_to_create_Add_RFA() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			RFA.ClickOnAddButton();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA Page");
			throw e;
		}
	}

	@Then("Entering valid code on RFA Code field using sheetname {string} and rownumber {int}")
	public void entering_valid_code_on_rfa_code_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String RFACode1 = testdata.get(rownumber).get("Suffixcode");
			String RFACode = testdata.get(rownumber).get("RFA Code");
			
			if(RFACode!=null && !RFACode.isEmpty()) {
				RFA.EnterOnRFACode(RFACode);
			}
			Thread.sleep(3000);
			RFA.Clickoncode();
			RFA.ClearOnRFACode();
			Thread.sleep(1000);
			if(RFACode1!=null && RFACode1.matches("\\d+\\.0")) {
				RFACode1=RFACode1.substring(0,RFACode1.indexOf(".0"));
			}
			System.out.println("=====code======:"+RFACode1);
			RFA.EnterOnRFACode(RFACode1);
			LoginInputDatas("RFACode", RFACode1);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA creation Page");
			throw e;
		}
	}

	@Then("Entering valid name on RFA Name field using sheetname {string} and rownumber {int}")
	public void entering_valid_name_on_RFA_name_field_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String RFAName = testdata.get(rownumber).get("RFA Name");
			RFA.EnterOnRFAName(RFAName);
			LoginInputDatas("RFAName", RFAName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA creation Page");
			throw e;
		}
	}

	@Then("Entering Description on the field in add RFA using sheetname {string} and rownumber {int}")
	public void entering_description_on_the_field_in_add_RFA_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Description = testdata.get(rownumber).get("Description");
			RFA.ClearOnDescription();
			Thread.sleep(1000);
			RFA.EnterOnDescription(Description);
			LoginInputDatas("Description", Description);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA creation Page");
			throw e;
		}
	}

	@Then("Entering valid start date on the field in add RFA using sheetname {string} and rownumber {int}")
	public void entering_valid_start_date_on_the_field_in_RFA_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String RFAStartDate = testdata.get(rownumber).get("Start Date");
			String RFAStartMonth = testdata.get(rownumber).get("Start Month");
			String RFAStartYear = testdata.get(rownumber).get("Start Year");

			if (RFAStartYear != null && RFAStartYear.matches("\\d+\\.0")) {
				RFAStartYear = RFAStartYear.substring(0, RFAStartYear.indexOf(".0"));

				Thread.sleep(1000);
				RFA.ClickOnStartDate();
				RFA.ClearOnStartDate();
				RFA.EnterOnStartDate(RFAStartDate);
				RFA.EnterOnStartDate(RFAStartMonth);
				RFA.EnterOnStartDate(RFAStartYear);
				LoginInputDatas("RFAStartDate", RFAStartDate);
				LoginInputDatas("RFAStartMonth", RFAStartMonth);
				LoginInputDatas("RFAStartYear", RFAStartYear);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA Page");
			throw e;
		}
	}

	@Then("Entering valid End date on the field in add RFA using sheetname {string} and rownumber {int}")
	public void entering_valid_end_date_on_the_field_in_add_RFA_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String RFAEndDate = testdata.get(rownumber).get("End Date");
			String RFAEndMonth = testdata.get(rownumber).get("End Month");
			String RFAEndYear = testdata.get(rownumber).get("End Year");

			if (RFAEndYear != null && RFAEndYear.matches("\\d+\\.0")) {
				RFAEndYear = RFAEndYear.substring(0, RFAEndYear.indexOf(".0"));

				Thread.sleep(1000);
				RFA.ClickOnEndDate();
				RFA.ClearOnEndDate();
				RFA.EnterOnEndDate(RFAEndMonth);
				RFA.EnterOnEndDate(RFAEndDate);
	
				RFA.EnterOnEndDate(RFAEndYear);
				LoginInputDatas("RFAEndDate", RFAEndDate);
				LoginInputDatas("RFAEndMonth", RFAEndMonth);
				LoginInputDatas("RFAEndYear", RFAEndYear);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA Page");
			throw e;
		}
	}

	@Then("Selecting Workflow from the drop-down in add RFA using sheetname {string} and rownumber {int}")
	public void selecting_workflow_from_the_drop_down_in_add_RFA_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Workflow = testdata.get(rownumber).get("Workflow");
			Thread.sleep(1000);
			RFI.workflowselection(Workflow);
//		RFA.ClickonWorkFlow();
//		RFA.EnterOnWorkFlow(Workflow);
//		RFA.selectDropdownOption(Workflow);
			Thread.sleep(1000);
			performTabKeyPress();
			performTabKeyPress();
			LoginInputDatas("Workflow", Workflow);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA Page");
			throw e;
		}
	}

	@Then("Selecting priority from the drop-down in add RFA using sheetname {string} and rownumber {int}")
	public void selecting_priority_from_the_drop_down_in_add_RFA_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Priority = testdata.get(rownumber).get("Priority");
			System.out.println(Priority);
			Thread.sleep(3000);
			RFI.scrolling(150);
			Thread.sleep(3000);
			RFI.prioritydropdownclick();
//		RFA.ClickOnPriority();		
//		Thread.sleep(1000);
//		RFA.EnterOnPriority(Priority);
			Thread.sleep(1000);
			RFI.SelectPrioritydropdown(Priority);
//		RFA.selectDropdownOption(Priority);
			LoginInputDatas("Priority", Priority);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA Page");
			throw e;
		}
	}

	@Then("Selecting Attach files from the drop-down and attaching the files using sheetname {string} and rownumber {int}")
	public void Selecting_Attach_files_from_the_drop_down_and_attaching_the_files(String sheetname, int rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Attachfile = testdata.get(rownumber).get("Attachfile");
			String FileName = testdata.get(rownumber).get("File Name");
			Thread.sleep(1000);
			RVW.ClickOnAttachFiles();
			Thread.sleep(1000);
			RFA.attachFile(Attachfile, FileName);
			Thread.sleep(1000);
			RVW.clickOnRequiredFile(FileName);
			Thread.sleep(2000);
			RVW.ClickOnAttachButton();
			LoginInputDatas("Attachfile", Attachfile);
			LoginInputDatas("FileName", FileName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA Page");
			throw e;
		}
	}

	@Then("Clicking on Create button to create a RFA for the project")
	public void Clicking_on_Create_button_to_create_a_RFA_for_the_project() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			RVW.ClickOnCreateButton();
			Thread.sleep(3000);
//		if (D.isElementVisible(D.Error)) {
//            System.out.println("RFA Not Created due to Error Message");
//            Assert.assertEquals(D.isElementVisible(D.Error), "Error");
//        } else {
//            System.out.println("RFA Created Successfully");
//        }
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add RFA Page");
			throw e;
		}
	}

	// Share - > Meeting module to create meeting for the project discussion

	@Then("Clicking on Share module from sidebar")
	public void Clicking_on_Share_module_from_sidebar() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			MET.ClickOnShare();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting creation Page");
			throw e;
		}
	}

	@Then("Clicking on Meeting sub-module")
	public void Clicking_on_Meeting_sub_module() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			MET.ClickOnMeeting();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting creation Page");
			throw e;
		}
	}

	@Then("Clicking on Add button to create Meeting for the project")
	public void Clicking_on_Add_button_to_create_Meeting_for_the_project() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(2000);
			MET.ClickOnAddButton();
			Thread.sleep(3000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting creation Page");
			throw e;
		}
	}

	@Then("Entering meeting name on Name field in add Meeting using sheetname {string} and rownumber {int}")
	public void Entering_meeting_name_on_Name_field_in_add_Meeting(String sheetname, int rownumber) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String MeetingName = testdata.get(rownumber).get("Name");
			MET.EnterOnName(MeetingName);

			LoginInputDatas("MeetingName", MeetingName);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting creation Page");
			throw e;
		}
	}

	@Then("Entering Meeting Date on date field in add Meeting using sheetname {string} and rownumber {int}")
	public void Entering_Meeting_Date_on_date_field_in_add_Meeting(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String MeetingStartDate = testdata.get(rownumber).get("Meeting Start Date");
			String MeetingStartMonth = testdata.get(rownumber).get("Meeting Start Month");
			String MeetingStartYear = testdata.get(rownumber).get("Meeting Start Year");

			if (MeetingStartYear != null && MeetingStartYear.matches("\\d+\\.0")) {
				MeetingStartYear = MeetingStartYear.substring(0, MeetingStartYear.indexOf(".0"));

				System.out.println(MeetingStartYear);
				Thread.sleep(1000);
				MET.ClickOnDate();
				MET.ClearOnDate();
				MET.EnterOnDate(MeetingStartDate);
				MET.EnterOnDate(MeetingStartMonth);
				//performTabKeyPress();
				MET.EnterOnDate(MeetingStartYear);
				Thread.sleep(1000);
				LoginInputDatas("MeetingStartDate", MeetingStartDate);
				LoginInputDatas("MeetingStartMonth", MeetingStartMonth);
				LoginInputDatas("MeetingStartYear", MeetingStartYear);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting Page");
			throw e;
		}
	}

	@Then("Entering Meeting Time on date field in add Meeting using sheetname {string} and rownumber {int}")
	public void Entering_Meeting_Time_on_date_field_in_add_Meeting(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Hour = testdata.get(rownumber).get("Hour");
			String Minute = testdata.get(rownumber).get("Minute");
			String AM_PM = testdata.get(rownumber).get("AM/PM");

			Thread.sleep(1000);
			MET.ClickOnTime();
			MET.ClearOnTime();
			MET.EnterOnTime(Hour);
			MET.EnterOnTime(Minute);
			MET.EnterOnTime(AM_PM);
			LoginInputDatas("Hour", Hour);
			LoginInputDatas("Minute", Minute);
			LoginInputDatas("AM_PM", AM_PM);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting Page");
			throw e;
		}
	}

	@Then("Entering Meeting Duration hours and minutes field in add Meeting using sheetname {string} and rownumber {int}")
	public void Entering_Meeting_Duration_hours_and_minutes_field_in_add_Meeting(String sheetname, int rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String DurationHours = testdata.get(rownumber).get("Duration Hours");
			String DurationMinutes = testdata.get(rownumber).get("Duration Minutes");

			Thread.sleep(1000);
			MET.ClearOnDurationHours();
			MET.EnterOnDurationHours(DurationHours);
			Thread.sleep(1000);
			MET.ClearOnDurationMinutes();
			MET.EnterOnDurationMinutes(DurationMinutes);
			LoginInputDatas("DurationHours", DurationHours);
			LoginInputDatas("DurationMinutes", DurationMinutes);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting Page");
			throw e;
		}
	}

	@Then("Entering Description on the field in add Meeting using sheetname {string} and rownumber {int}")
	public void Entering_Description_on_the_field_in_add_Meeting(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Description = testdata.get(rownumber).get("Description");
			MET.ClearOnDescription();
			Thread.sleep(1000);
			MET.EnterOnDescription(Description);
			LoginInputDatas("Description", Description);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting Page");
			throw e;
		}
	}

	@Then("Entering Notes to the meeting in the Enter notes field if extra notes need to be add clicking on Add Notes button in add Meeting using sheetname {string} and rownumber {int}")
	public void Entering_Notes_to_the_meeting_in_the_Enter_notes_field_if_extra_notes_need_to_be_add_clicking_on_Add_Notes_button_in_add_Meeting(
			String sheetname, int rownumber) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			int i = rownumber;
			int notesEntered = 0; // To track the number of notes entered

			while (true) {
				String enterNoteData = testdata.get(i).get("Enter Notes");

				if (enterNoteData == null || enterNoteData.trim().isEmpty()) {
					break; // Exit if no more notes to enter
				}

				// Enter the note using the current notesEntered index
				MET.EnterOnNotes(enterNoteData, notesEntered);

				// Check if there's more data to enter
				String nextNoteData = null;
				if (i + 1 < testdata.size()) {
					nextNoteData = testdata.get(i + 1).get("Enter Notes");
				}

				if (nextNoteData == null || nextNoteData.trim().isEmpty()) {
					break; // No more notes to add
				} else {
					MET.ClickOnAddNotes(); // Click to add a new input field for the next note
				}

				notesEntered++; // Increment the index for the next note field
				i++; // Move to the next row
			}
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

	@Then("Selecting the selected Participants from Select Users and Selected Group of Users in Add meeting using sheetname {string} and rownumber {int}")
	public void Selecting_the_selected_Participants_from_Select_Users_and_Selected_Group_of_Users_in_Add_meeting(
			String sheetname, int rownumber) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			Thread.sleep(1000);

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
			System.err.println("An error occurred while selecting participants: " + e.getMessage());
		}
	}

	@Then("Uploading an Image in the field in add meeting using sheetname {string} and rownumber {int}")
	public void Uploading_an_Image_in_the_field_in_add_meeting(String sheetname, int rownumber) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet data: " + testData);

			String imageFilePath = testData.get(rownumber).get("Upload Images");

			ISU.UploadingAnImage(imageFilePath);
			LoginInputDatas("imageFilePath", imageFilePath);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting Page");
			throw e;
		}
	}

	@Then("Selecting Attach files from the drop-down and attaching the files in Add Meeting using sheetname {string} and rownumber {int}")
	public void Selecting_Attach_files_from_the_drop_down_and_attaching_the_files_in_add_meeting(String sheetname,
			int rownumber) throws Exception {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

		System.out.println("sheet name: " + testdata);

		String Attachfile = testdata.get(rownumber).get("Attachfile");
		String FileName = testdata.get(rownumber).get("File Name");
		Thread.sleep(1000);
		RVW.ClickOnAttachFiles();
		Thread.sleep(1000);
		MET.attachFile(Attachfile, FileName);
		Thread.sleep(1000);
		RVW.clickOnRequiredFile(FileName);
		Thread.sleep(2000);
		RVW.ClickOnAttachButton();
		LoginInputDatas("Attachfile", Attachfile);
		LoginInputDatas("FileName", FileName);

	}

	@Then("Clicking on Create button to create a Meeting for the project")
	public void Clicking_on_Create_button_to_create_a_Meeting_for_the_project() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
			Thread.sleep(6000);
			RVW.ClickOnCreateButton();
			Thread.sleep(5000);
// 		if (D.isElementVisible(D.Error)) {
//            System.out.println("Meeting Not Created due to Error Message");
//            Assert.assertEquals(D.isElementVisible(D.Error), "Error");
//        } else {
//            System.out.println("Meeting Created Successfully");
//        }
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Meeting Page");
			throw e;
		}
	}

	// Attachments - > BOM/BOQ Module Creation

	@Then("Clicking on Attachments module from sidebar")
	public void clicking_on_Attachments_module_from_sidebar() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(1000);
			BOM.ClickOnAttachments();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM/BOQ Page");
			throw e;
		}
	}

	@Then("Clicking on BOM\\/BOQ sub-module")
	public void clicking_on_bom_boq_sub_module() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(1000);
			BOM.ClickOnBOM_BOQ();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM/BOQ Page");
			throw e;
		}
	}

	@Then("Clicking on Add button to create BOM\\/BOQ for the project")
	public void clicking_on_add_button_to_create_bom_boq_for_the_project() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(1000);
			BOM.ClickOnAddButton();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM/BOQ Page");
			throw e;
		}
	}

	@Then("Selecting Parent BOM\\/BOQ name from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void selecting_parent_bom_boq_name_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ParentBOM = testdata.get(rownumber).get("Parent BOM");
			System.out.println(ParentBOM);
			Thread.sleep(1000);
			BOM.ClickOnParentBOM();
			Thread.sleep(1000);
			BOM.selectDropdownOption(ParentBOM);
			performTabKeyPress();
			// performTabKeyPress();
			LoginInputDatas("ParentBOM", ParentBOM);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid code on BOM\\/BOQ Code field using sheetname {string} and rownumber {int}")
	public void entering_valid_code_on_bom_boq_code_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Code = testdata.get(rownumber).get("Code");
			String Code1 = testdata.get(rownumber).get("Suffixcode");
			if(Code!=null && !Code.isEmpty()) {
				BOM.ClickOnCode();
				BOM.ClearOnCode();
				Thread.sleep(1000);
				BOM.EnterOnCode(Code);
			}
			
			BOM.ClickOnCode();
			BOM.ClearOnCode();
			Thread.sleep(1000);
			if(Code1!=null && !Code1.isEmpty() &&Code1.matches("\\d+\\.0")) {
				Code1=Code1.substring(0,Code1.indexOf(".0"));
			}
			System.out.println("====Code====="+Code1);
			BOM.EnterOnCode(Code1);
			LoginInputDatas("Code", Code);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid name on Name field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void entering_valid_name_on_name_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Name = testdata.get(rownumber).get("Name");
			BOM.ClearOnName();
			BOM.EnterOnName(Name);
			LoginInputDatas("Name", Name);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Add Issue Page");
			throw e;
		}
	}

	@Then("Selecting workflow on the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void selecting_workflow_on_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Workflow = testdata.get(rownumber).get("Workflow");
			Thread.sleep(1000);
			RFI.workflowselection(Workflow);

//       BOM.ClickOnWorkflow();
//       Thread.sleep(1000);
//       BOM.EnterOnWorkflow(Workflow);
//       Thread.sleep(1000);
//       BOM.selectDropdownOptionForWorkFlow(Workflow);
			LoginInputDatas("Workflow", Workflow);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Selecting priority from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void selecting_priority_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Priority = testdata.get(rownumber).get("Priority");
			Thread.sleep(1000);
//		BOM.ClickOnPriority();	
			RFI.prioritydropdownclick();
			Thread.sleep(1000);
//	    BOM.EnterOnPriority(Priority);
//		Thread.sleep(1000);
			RFI.SelectPrioritydropdown(Priority);
//		BOM.selectDropdownOptionForPriority(Priority);
			LoginInputDatas("Priority", Priority);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid unit field from the drop-down in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void entering_valid_unit_field_from_the_drop_down_in_bom_boq_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Unit = testdata.get(rownumber).get("Unit");
			Thread.sleep(1000);
			BOM.unitdropdownclick();
			// BOM.ClickOnUnit();
			Thread.sleep(1000);
//    			BOM.EnterOnUnit(Unit);
//    			Thread.sleep(1000);
			BOM.SelectUnitdropdown(Unit);
//    			BOM.selectDropdownOptionForUnit(Unit);
			LoginInputDatas("Unit", Unit);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid Estimated Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void entering_valid_estimated_quantity_in_the_field_in_bom_boq_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String EstimatedQuantity = testdata.get(rownumber).get("Estimated Quantity");
			Thread.sleep(1000);
			BOM.EnterOnEstimatedQuantity(EstimatedQuantity);
			LoginInputDatas("EstimatedQuantity", EstimatedQuantity);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid Estimated Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void entering_valid_estimated_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String EstimatedPricePerUnit = testdata.get(rownumber).get("Estimated Price Per Unit");
			Thread.sleep(1000);
			BOM.EnterOnEstimatedPricePerUnit(EstimatedPricePerUnit);
			LoginInputDatas("EstimatedPricePerUnit", EstimatedPricePerUnit);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Verifying Estimated Total value in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void verifying_estimated_total_value_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
			String EstimatedQuantity = testdata.get(rownumber).get("Estimated Quantity");
			String EstimatedPricePerUnit = testdata.get(rownumber).get("Estimated Price Per Unit");
			String EstimatedTotal = testdata.get(rownumber).get("Estimated Total");

			if (EstimatedQuantity != null && EstimatedQuantity.matches("\\d+\\.0")) {
				EstimatedQuantity = EstimatedQuantity.substring(0, EstimatedQuantity.indexOf(".0"));
			}

			if (EstimatedPricePerUnit != null && EstimatedPricePerUnit.matches("\\d+\\.0")) {
				EstimatedPricePerUnit = EstimatedPricePerUnit.substring(0, EstimatedPricePerUnit.indexOf(".0"));
			}

			Thread.sleep(1000);
			String calculatedEstimatedTotal = BOM.getEstimatedTotal();
			int estimatedquantity = Integer.parseInt(EstimatedQuantity);
			int estimatedpricePerUnit = Integer.parseInt(EstimatedPricePerUnit);

			int estimatedTotalCalculated = estimatedquantity * estimatedpricePerUnit;

			String estimatedTotalCalculatedStr = String.valueOf(estimatedTotalCalculated);
			String estimatedTotalFieldValue = BOM.getEstimatedTotal();

			Assert.assertEquals("Estimated Total value does not match!", estimatedTotalCalculatedStr,
					estimatedTotalFieldValue);
			System.out.println(estimatedTotalCalculatedStr);
			System.out.println(estimatedTotalFieldValue);
			LoginInputDatas("EstimatedQuantity", EstimatedQuantity);
			LoginInputDatas("EstimatedPricePerUnit", EstimatedPricePerUnit);
			LoginInputDatas("Estimated Total", EstimatedTotal);
			LoginInputDatas("estimatedTotalCalculatedStr", estimatedTotalCalculatedStr);
			LoginInputDatas("estimatedTotalFieldValue", estimatedTotalFieldValue);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid Ordered Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void Entering_valid_Ordered_Quantity_in_the_field_in_bom_boq(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String OrderedQuantity = testdata.get(rownumber).get("Ordered Quantity");

			BOM.ClearOnOrderedQuantity();
			Thread.sleep(1000);
			BOM.EnterOnOrderedQuantity(OrderedQuantity);
			LoginInputDatas("OrderedQuantity", OrderedQuantity);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid Quoted Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void entering_valid_Quoted_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String QuotedPricePerUnit = testdata.get(rownumber).get("Quoted Price Per Unit");
			BOM.ClearOnQuotedPricePerUnit();
			Thread.sleep(1000);
			BOM.EnterOnQuotedPricePerUnit(QuotedPricePerUnit);
			LoginInputDatas("QuotedPricePerUnit", QuotedPricePerUnit);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Verifying the Quoted Total value in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void verifying_Quoted_total_value_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
			String OrderedQuantity = testdata.get(rownumber).get("Ordered Quantity");
			String QuotedPricePerUnit = testdata.get(rownumber).get("Quoted Price Per Unit");
			String QuotedTotal = testdata.get(rownumber).get("Quoted Total");

			if (OrderedQuantity != null && OrderedQuantity.matches("\\d+\\.0")) {
				OrderedQuantity = OrderedQuantity.substring(0, OrderedQuantity.indexOf(".0"));
			}

			if (QuotedPricePerUnit != null && QuotedPricePerUnit.matches("\\d+\\.0")) {
				QuotedPricePerUnit = QuotedPricePerUnit.substring(0, QuotedPricePerUnit.indexOf(".0"));
			}

			Thread.sleep(1000);
			int orderedquantity = Integer.parseInt(OrderedQuantity);
			int quotedpricePerUnit = Integer.parseInt(QuotedPricePerUnit);

			int quotedTotalCalculated = orderedquantity * quotedpricePerUnit;

			String quotedTotalCalculatedStr = String.valueOf(quotedTotalCalculated);
			String quotedTotalFieldValue = BOM.getQuotedTotal();

			Assert.assertEquals("Quoted Total value does not match!", quotedTotalCalculatedStr, quotedTotalFieldValue);
			System.out.println(quotedTotalCalculatedStr);
			System.out.println(quotedTotalFieldValue);

			LoginInputDatas("OrderedQuantity", OrderedQuantity);
			LoginInputDatas("QuotedPricePerUnit", QuotedPricePerUnit);
			LoginInputDatas("quotedTotalCalculatedStr", quotedTotalCalculatedStr);
			LoginInputDatas("quotedTotalFieldValue", quotedTotalFieldValue);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid Actual Quantity in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void Entering_valid_Actual_Quantity_in_the_field_in_bom_boq(String sheetname, Integer rownumber)
			throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ActualQuantity = testdata.get(rownumber).get("Actual Quantity");

			BOM.ClearOnActualQuantity();
			Thread.sleep(1000);
			BOM.EnterOnActualQuantity(ActualQuantity);
			LoginInputDatas("ActualQuantity", ActualQuantity);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid Actual Price per unit in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void entering_valid_Actual_price_per_unit_in_the_field_in_bom_boq_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String ActualPricePerUnit = testdata.get(rownumber).get("Actual Price Per Unit");
			BOM.ClearOnActualPricePerUnit();
			Thread.sleep(1000);
			BOM.EnterOnActualPricePerUnit(ActualPricePerUnit);
			LoginInputDatas("ActualPricePerUnit", ActualPricePerUnit);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Verifying the Actual Total value in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void verifying_Actual_total_value_in_the_field_in_bom_boq_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);
			String ActualQuantity = testdata.get(rownumber).get("Actual Quantity");
			String ActualPricePerUnit = testdata.get(rownumber).get("Actual Price Per Unit");
			String ActualTotal = testdata.get(rownumber).get("Actual Total");

			if (ActualQuantity != null && ActualQuantity.matches("\\d+\\.0")) {
				ActualQuantity = ActualQuantity.substring(0, ActualQuantity.indexOf(".0"));
			}

			if (ActualPricePerUnit != null && ActualPricePerUnit.matches("\\d+\\.0")) {
				ActualPricePerUnit = ActualPricePerUnit.substring(0, ActualPricePerUnit.indexOf(".0"));
			}

			Thread.sleep(1000);
			int actualquantity = Integer.parseInt(ActualQuantity);
			int actualpricePerUnit = Integer.parseInt(ActualPricePerUnit);

			int actualotalCalculated = actualquantity * actualpricePerUnit;

			String actualTotalCalculatedStr = String.valueOf(actualotalCalculated);
			String actualTotalFieldValue = BOM.getActualTotal();

			Assert.assertEquals("Actual Total value does not match!", actualTotalCalculatedStr, actualTotalFieldValue);
			System.out.println(actualTotalCalculatedStr);
			System.out.println(actualTotalFieldValue);

			LoginInputDatas("ActualQuantity", ActualQuantity);
			LoginInputDatas("ActualPricePerUnit", ActualPricePerUnit);
			LoginInputDatas("actualTotalCalculatedStr", actualTotalCalculatedStr);
			LoginInputDatas("actualTotalFieldValue", actualTotalFieldValue);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid Remarks in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void Entering_valid_Remarks_in_the_field_in_bom_boq(String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Remarks = testdata.get(rownumber).get("Remarks");
			Thread.sleep(1000);
			BOM.EnterOnRemarks(Remarks);
			LoginInputDatas("Remarks", Remarks);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Entering valid GUID in the field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void Entering_valid_GUID_in_the_field_in_bom_boq(String sheetname, Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String GUID = testdata.get(rownumber).get("GUID");
			Thread.sleep(1000);
			BOM.EnterOnGUID(GUID);
			LoginInputDatas("GUID", GUID);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Uploading valid QR code file in the Attach QR code field in BOM\\/BOQ using sheetname {string} and rownumber {int}")
	public void uploading_valid_qr_code_file_in_the_attach_qr_code_field_in_bom_boq_using_sheetname_and_rownumber(
			String sheetname, Integer rownumber) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet data: " + testData);

			String QRCode = testData.get(rownumber).get("QR Code");

			BOM.UploadingQRCode(QRCode);
			LoginInputDatas("QRCode", QRCode);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	@Then("Clicking on Add Properties button and entering values in the field Property name and Property value using sheetname {string} and rownumber {int}")
	public void Clicking_on_Add_Properties_button_and_entering_values_in_the_field_Property_name_and_Property_value(
			String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet data: " + testData);
			for (int rownumber1 = 0; rownumber1 < testData.size(); rownumber1++) {
				String propertyNameValue = testData.get(rownumber1).get("Property Name");
				String propertyValueValue = testData.get(rownumber1).get("Property Value");
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
			System.out.println("All available properties added successfully.");
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}

//    	 try { 
//    	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
//
//    	        List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
//    	        System.out.println("Sheet data: " + testData);
//    	        int rownumber1 = 0;
//    	     while (rownumber1 < testData.size()) {
//    	         String propertyNameValue = testData.get(rownumber1).get("Property Name"); // Get the Property Name
//    	         String propertyValueValue = testData.get(rownumber1).get("Property Value"); // Get the Property Value
//    	         if (propertyNameValue == null || propertyNameValue.isEmpty() || propertyValueValue == null || propertyValueValue.isEmpty()) {
//    	             break; // Exit the loop when encountering empty data
//    	         }
//    	         BOM.ClickOnAddPropertiesButton();
//    	         Thread.sleep(1000); // Wait for a second (consider using WebDriverWait instead)
//    	         String propertyNameXpath = String.format("(//input[@placeholder='Enter field name'])[%d]", rownumber1 + 1);
//    	         String propertyValueXpath = String.format("(//input[@placeholder='Enter field value'])[%d]", rownumber1 + 1);
//    	         System.out.println(propertyNameXpath);
//    	         System.out.println(propertyValueXpath);
//    	         WebElement propertyNameElement = driver.findElement(By.xpath(propertyNameXpath));
//    	         WebElement propertyValueElement = driver.findElement(By.xpath(propertyValueXpath));
//    	         propertyNameElement.sendKeys(propertyNameValue);
//    	         propertyValueElement.sendKeys(propertyValueValue);
//    	         rownumber1++;
//    	     }
//    	    } catch (Exception e) {
//    	        ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//    	        exceptionHandler.handleException(e, "BOM Page");
//    	        throw e;
//    	    }
	}

	@Then("Clicking on Create button to create BOM for the project")
	public void Clicking_on_Create_button_to_create_BOM_for_the_project() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			Thread.sleep(1000);
			R.ClickOnCreateButton();
// 			if (D.isElementVisible(D.Error)) {
//                System.out.println("BOM Not Created due to Error Message");
//                Assert.assertEquals(D.isElementVisible(D.Error), "Error");
//            } else {
//                System.out.println("BOM Created Successfully");
//            }
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "BOM Page");
			throw e;
		}
	}

	// Attachments - > Check List Module Page Creation

	@Then("Clicking on check List sub-module")
	public void Clicking_on_check_List_sub_module() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			Chk.ClickOnCheckList();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Checklist Page");
			throw e;
		}
	}

	@Then("Clicking on Add button to create check List for the project")
	public void Clicking_on_Add_button_to_create_check_List_for_the_project() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			Chk.ClickOnAddButton();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Checklist Page");
			throw e;
		}
	}

	@Then("Entering valid code on checklist Code field using sheetname {string} and rownumber {int}")
	public void Entering_valid_code_on_checklist_Code_field(String sheetname, int rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Code = testdata.get(rownumber).get("Checklist Code");
			Thread.sleep(1000);
			Chk.EnterOnCheckListCode(Code);
			LoginInputDatas("Code", Code);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Checklist Page");
			throw e;
		}
	}

	@Then("Entering valid Name on checklist Name field using sheetname {string} and rownumber {int}")
	public void entering_valid_name_on_checklist_name_field_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

			System.out.println("sheet name: " + testdata);

			String Name = testdata.get(rownumber).get("Checklist Name");
			Thread.sleep(1000);
			Chk.EnterOnCheckListTitle(Name);
			LoginInputDatas("Name", Name);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Checklist Page");
			throw e;
		}
	}

	@Then("Entering values under Checklist Item Fields using sheetname {string} and rownumber {int}")
	public void Entering_values_under_Checklist_Item_Fields(String sheetname, int startRowNumber) throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			System.out.println(testdata);
			int totalRows = testdata.size();
			ChecklistLocators checklistLocators = new ChecklistLocators(driver);
			// Loop through each row starting from startRowNumber until an empty row is
			// found
			for (int rownumber = startRowNumber; rownumber < totalRows; rownumber++) {
				String ChecklistitemName = testdata.get(rownumber).get("Checklist item Name");
				String Category = testdata.get(rownumber).get("Category");
				String Priority = testdata.get(rownumber).get("Priority");
				String Description = testdata.get(rownumber).get("Description");

				// Break the loop if the key column (Checklist item Name) is empty
				if (ChecklistitemName == null || ChecklistitemName.trim().isEmpty()) {
					System.out
							.println("Empty data encountered at row: " + rownumber + ". Stopping further processing.");
					break;
				}

//                 String nameXpath = String.format("(//input[@placeholder='Enter name'])[%d]", rownumber + 1);
//                 String categoryXpath = String.format("(//input[@placeholder='Select the category'])[%d]", rownumber + 1);
//                 String priorityXpath = String.format("(//input[@placeholder='Select the priority'])[%d]", rownumber + 1);
//                 String descriptionXpath = String.format("(//textarea[@placeholder='Enter description'])[%d]", rownumber + 1);

				// Fill in the form fields
				Thread.sleep(1000);
				Chk.ClearOnName();
				Chk.EnterOnName(ChecklistitemName);
				LoginInputDatas("ChecklistitemName", ChecklistitemName);

				// Enter and select Category
				Thread.sleep(1000);
				// Chk.ClickOnSelectTheCategory();
				Chk.prioritydropdownclick();
				Thread.sleep(1000);
				// Chk.EnterOnSelectTheCategory(Category);
				Chk.SelectPrioritydropdown(Category);
				// Thread.sleep(1000);
				// Chk.selectDropdownOptionSelectTheCategory(Category);
				LoginInputDatas("Category", Category);

				// Enter and select Priority
				Thread.sleep(1000);
				// Chk.ClickOnPriority();
				RFI.prioritydropdownclick();
				Thread.sleep(1000);
				// Chk.EnterOnPriority(Priority);
				RFI.SelectPrioritydropdown(Priority);
				// Chk.selectDropdownOptionForPriority(Priority);
				LoginInputDatas("Priority", Priority);

				// Enter Description
				Thread.sleep(1000);
				Chk.ClearOnDescription();
				Chk.EnterOnDescription(Description);

				// Log the input data (optional for debugging)
				LoginInputDatas("ChecklistitemName", ChecklistitemName);
				LoginInputDatas("Category", Category);
				LoginInputDatas("Priority", Priority);
				LoginInputDatas("Description", Description);

				// Click on "Add Row" to proceed for next entry
				Thread.sleep(1000);
				Chk.ClickOnAddRow();

				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

//                 checklistLocators.enterDynamicName(ChecklistitemName, rownumber + 1);
//                 checklistLocators.selectDynamicCategory(Category, rownumber + 1);
//                 checklistLocators.enterDynamicPriority(Priority, rownumber + 1);
//                 checklistLocators.enterDynamicDescription(Description, rownumber + 1);
//
//                 // Log the input data if needed
//                 LoginInputDatas("ChecklistitemName", ChecklistitemName);
//                 LoginInputDatas("Category", Category);
//                 LoginInputDatas("Priority", Priority);
//                 LoginInputDatas("Description", Description);
//
//                 if (rownumber < totalRows - 1 && testdata.get(rownumber + 1).get("Checklist item Name") != null) {
//                     Chk.ClickOnAddRow();
//                     ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
//                 } else {
//                     System.out.println("No more data to process. Exiting loop.");
//                     break;
//                 }
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Checklist Page");
			throw e;
		}
	}

	@Then("Click on Create Button to create checklist")
	public void Click_on_Create_Button_to_create_checklist() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
			Thread.sleep(2000);
			R.ClickOnCreateButton();
			Thread.sleep(3000);
//  			if (D.isElementVisible(D.Error)) {
//                System.out.println("CheckList Not Created due to Error Message");
//                Assert.assertEquals(D.isElementVisible(D.Error), "Error");
//            } else {
//                System.out.println("CheckList Created Successfully");
//            }
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Checklist Page");
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
