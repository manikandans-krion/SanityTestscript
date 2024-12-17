package Testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EditTransmittals {

	public WebDriver driver;
	public WebDriverWait wait;
	public ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
	public Locators.TransmittalsLocators T;
	public Locators.Issue_Locators ISS;

	@Before
	public void setup() throws InvalidFormatException, IOException {
		excelDataManager
				.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\EditModule\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public EditTransmittals() {
		System.setProperty("webdriver.chrome.log", "chromedriver.logfile");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.T = new Locators.TransmittalsLocators(driver);
		this.ISS = new Locators.Issue_Locators(driver);
	}

	@Then("filtering the required Transmittals and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_transmittals_and_clicking_on_it_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet Details :" + testdata);
			String projectcode = testdata.get(rownumber).get("Project Code");
			ISS.ClickOnDesignProject();
			Thread.sleep(2000);
			T.Navigateproject();
			Thread.sleep(4000);
			T.EnterOnSearchBox(projectcode);
			Thread.sleep(2000);
			T.clickOnProject(projectcode);
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			T.viewMenu();
			T.Transmittalclick();
			Thread.sleep(4000);
			T.SelectStatusclick();
			Thread.sleep(4000);
			String status = testdata.get(rownumber).get("Status");
			System.out.println("Status :" + status);
			T.SelectStatusType(status);
			Thread.sleep(4000);
			String transmitalcode = testdata.get(rownumber).get("OldTransmittal code");
			System.out.println("Transmittal code :" + transmitalcode);
			T.EnterOnSearchsubmittals(transmitalcode);
			Thread.sleep(4000);
			T.clickOnEdit();
			Thread.sleep(2000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

	@Then("Changing the required field in Transmittals using sheetname {string} and rownumber {int}")
	public void changing_the_required_field_in_transmittals_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet details :"+testdata);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

	@Then("Update the Transmittalcode using the sheetname {string} and rownumber {int}")
	public void update_the_transmittalcode_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

			String updatecode = testdata.get(int1).get("Updatetransmittal code");
			if (updatecode != null && !updatecode.isEmpty()) {
				Thread.sleep(1000);
				T.clearcode();
				T.entertransmtlCode(updatecode);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

	@Then("Update the Transmittalname using the sheetname {string} and rownumber {int}")
	public void update_the_transmittalname_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String updatename = testdata.get(int1).get("Updatetransmittal name");
			if (updatename != null && !updatename.isEmpty()) {
				Thread.sleep(1000);
				T.clearname();
				T.entertransmtlname(updatename);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

	@Then("Update the Descriptions of transmittal using the sheetname {string} and rownumber {int}")
	public void update_the_descriptions_of_transmittal_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String desc = testdata.get(int1).get("Description");
			if (desc != null && !desc.isEmpty()) {
				Thread.sleep(1000);
				T.cleardesc();
				T.enterdescription(desc);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

	@Then("Update the Workflow for transmittal dropdown using the sheetname {string} and rownumber {int}")
	public void update_the_workflow_for_transmittal_dropdown_using_the_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String Wf = testdata.get(int1).get("Workflow");
			if (Wf != null && !Wf.isEmpty()) {
				Thread.sleep(1000);
				T.selectworkflow(Wf);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

	@Then("Update Attach the file by the filename using the sheetname {string} and rownumber {int}")
	public void update_attach_the_file_by_the_filename_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String attachfile = testdata.get(int1).get("Attachfile");
			String filename = testdata.get(int1).get("File Name");
			if (attachfile != null && !attachfile.isEmpty() && filename != null && !filename.isEmpty()) {
				Thread.sleep(1000);
				T.selectfiletype(attachfile);
				Thread.sleep(2000);
				T.searchfile(filename);
				Thread.sleep(2000);
				T.checkboxclick();
				T.clickattachedbtn();

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

	@Given("Click the Update button on the screen")
	public void click_the_update_button_on_the_screen() throws Exception {
		try {
			T.createclick();
			Thread.sleep(4000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

	@Then("Transmittals should be Updated")
	public void transmittals_should_be_updated() {
		try {
			System.out.println("Transmittals is updated successfully");
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Transmittals");
			throw e;
		}
	}

}