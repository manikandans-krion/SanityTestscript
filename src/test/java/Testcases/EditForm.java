package Testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class EditForm {

	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.FormLocators FL;
	public Locators.Issue_Locators ISS;
	public ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager.loadData(
				"C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public EditForm() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.FL = new Locators.FormLocators(driver);
		this.ISS = new Locators.Issue_Locators(driver);
	}

	@Then("filtering the required Form and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_form_and_clicking_on_it_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			String projectcode = testdata.get(rownumber).get("Project Code");
			ISS.ClickOnDesignProject();
			Thread.sleep(2000);
			FL.Navigateproject();
			Thread.sleep(4000);
			FL.EnterOnSearchBox(projectcode);
			Thread.sleep(2000);
			FL.clickOnProject(projectcode);
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			FL.viewMenu();
			FL.routingForm();
			String Formname = testdata.get(rownumber).get("Formname");
			System.out.println("Name" + Formname);
			FL.selectformtype(Formname);
			Thread.sleep(4000);
			FL.SelectStatusclick();
			Thread.sleep(4000);
			String status = testdata.get(rownumber).get("Status");
			System.out.println("Status" + status);
			FL.SelectStatusType(status);
			Thread.sleep(4000);
			// FL.EnterOnSearchBox(Formname);
			Thread.sleep(4000);
			FL.clickOnEdit();
			Thread.sleep(2000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Changing the required field in Form using sheetname {string} and rownumber {int}")
	public void changing_the_required_field_in_form_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			System.out.println("sheet details :" + testdata);

			// String Workflow=testdata.get(rownumber).get("Workflow");

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Update the from date using the sheetname {string} and rownumber {int}")
	public void update_the_from_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details :" + testdata);

			String startdate = testdata.get(int1).get("Start Date");
			String startmonth = testdata.get(int1).get("Start Month");
			String startyear = testdata.get(int1).get("Start Year");

			if ((startdate != null && !startdate.isEmpty()) && (startmonth != null && !startmonth.isEmpty())
					&& (startyear != null && !startyear.isEmpty())) {
				if (startdate != null && startdate.matches("\\d+\\.0")) {
					startdate = startdate.substring(0, startdate.indexOf(".0"));
				}

				if (startmonth != null && startmonth.matches("\\d+\\.0")) {
					startmonth = startmonth.substring(0, startmonth.indexOf(".0"));
				}

				if (startyear != null && startyear.matches("\\d+\\.0")) {
					startyear = startyear.substring(0, startyear.indexOf(".0"));
				}
				Thread.sleep(1000);
				System.out.println("Date" + startdate);
				System.out.println("Month" + startmonth);
				System.out.println("Year" + startyear);
				String formatteddate = String.format("%02d/%02d/%d", Integer.parseInt(startmonth),
						Integer.parseInt(startdate), Integer.parseInt(startyear));
				FL.clearfromdate();
				FL.selectingfromdate(formatteddate);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Update the due date using the sheetname {string} and rownumber {int}")
	public void update_the_due_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details :" + testdata);

			String duedate = testdata.get(int1).get("Due Date");
			String duemonth = testdata.get(int1).get("Due Month");
			String dueyear = testdata.get(int1).get("Due Year");

			if ((duedate != null && !duedate.isEmpty()) && (duemonth != null && !duemonth.isEmpty())
					&& (dueyear != null && !dueyear.isEmpty())) {
				if (duedate != null && duedate.matches("\\d+\\.0")) {
					duedate = duedate.substring(0, duedate.indexOf(".0"));
				}

				if (duemonth != null && duemonth.matches("\\d+\\.0")) {
					duemonth = duemonth.substring(0, duemonth.indexOf(".0"));
				}

				if (dueyear != null && dueyear.matches("\\d+\\.0")) {
					dueyear = dueyear.substring(0, dueyear.indexOf(".0"));
				}
				Thread.sleep(1000);
				System.out.println("Date" + duedate);
				System.out.println("Month" + duemonth);
				System.out.println("Year" + dueyear);
				String formatteddate = String.format("%02d/%02d/%d", Integer.parseInt(duemonth),
						Integer.parseInt(duedate), Integer.parseInt(dueyear));
				FL.clearduedate();
				FL.selectingduedate(formatteddate);

			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Update the locationname using the sheetname {string} and rownumber {int}")
	public void update_the_locationname_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details :" + testdata);

			String loc = testdata.get(int1).get("Location");
			if (loc != null && !loc.isEmpty()) {
				Thread.sleep(1000);
				FL.clearlocation();
				FL.enterlocation(loc);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Update description using the sheetname {string} and rownumber {int}")
	public void update_description_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details :" + testdata);

			String desc = testdata.get(int1).get("Description");
			if (desc != null && !desc.isEmpty()) {
				Thread.sleep(1000);
				FL.cleardescription();
				FL.enterdescription(desc);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Click Edit Work button")
	public void click_edit_work_button() {
		try {
			FL.ClickOnWorklogeditbtn();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Update work details using the sheetname {string} and rownumber {int}")
	public void update_work_details_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details :" + testdata);

			String crew = testdata.get(int1).get("Crew");
			String workers = testdata.get(int1).get("Workers");
			String totalhrs = testdata.get(int1).get("Total Hours");
			String workperformed = testdata.get(int1).get("Work performed");

			if (crew != null && !crew.isEmpty()) {
				Thread.sleep(1000);
				FL.clearcrew();
				FL.entercrew(crew);
			}

			if (workers != null && !workers.isEmpty()) {
				Thread.sleep(1000);
				FL.clearworkers();
				Thread.sleep(1000);
				FL.enterworker(workers);
			}

			if (totalhrs != null && !totalhrs.isEmpty()) {
				Thread.sleep(1000);
				FL.cleartotalhrs();
				FL.entertotalhr(totalhrs);
			}

			if (workperformed != null && !workperformed.isEmpty()) {
				Thread.sleep(1000);
				FL.clearworkperoformed();
				FL.enterworkperformed(workperformed);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Click Update button to save work details")
	public void click_update_button_to_save_work_details() {
		try {
			FL.worksave();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Click Edit Material button")
	public void click_edit_material_button() {
		try {
			FL.ClickOnMaterialeditbtn();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Update material details using the sheetname {string} and rownumber {int}")
	public void update_material_details_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details :" + testdata);

			String material = testdata.get(int1).get("Material");
			String quantity1 = testdata.get(int1).get("Quantity1");
			String unit = testdata.get(int1).get("Unit");
			String comment = testdata.get(int1).get("Comment");

			if (material != null && !material.isEmpty()) {
				Thread.sleep(1000);
				FL.Clearaddmaterial();
				FL.entermaterial(material);
			}

			if (quantity1 != null && !quantity1.isEmpty()) {
				Thread.sleep(1000);
				FL.Clearquantity();
				FL.enterquantity(quantity1);
			}

			if (unit != null && !unit.isEmpty()) {
				Thread.sleep(1000);
				FL.Clearunit();
				FL.enterunit(unit);
			}

			if (comment != null && !comment.isEmpty()) {
				Thread.sleep(1000);
				FL.Clearcomment();
				FL.entercomment(comment);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Click Update button to save material details")
	public void click_update_button_to_save_material_details() {
		try {
			FL.materialsave();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Click Edit Equipment button")
	public void click_edit_equipment_button() {
		try {
			FL.ClickonEquipmenteditbtn();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Update Equipment details using the sheetname {string} and rownumber {int}")
	public void update_equipment_details_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details :" + testdata);

			String equipment = testdata.get(int1).get("Equipment");
			String quantity2 = testdata.get(int1).get("Quantity2");
			String hrsused = testdata.get(int1).get("Hours used");
			String cmnts = testdata.get(int1).get("Comments");

			if (equipment != null && !equipment.isEmpty()) {
				Thread.sleep(1000);
				FL.Clearequipmentname();
				FL.enterequipmentname(equipment);
			}

			if (quantity2 != null && !quantity2.isEmpty()) {
				Thread.sleep(1000);
				FL.Clearequipmentqty();
				FL.entereqpquantity(quantity2);

			}

			if (hrsused != null && !hrsused.isEmpty()) {
				Thread.sleep(1000);
				FL.Clearhoursused();
				FL.entereqphours(hrsused);
			}

			if (cmnts != null && !cmnts.isEmpty()) {
				Thread.sleep(1000);
				FL.Cleareqpcomment();
				FL.entereqpcomment(cmnts);

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Click Update button to save Equipment details")
	public void click_update_button_to_save_equipment_details() {
		try {
			FL.equipmentsave();
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("Update Notes using the sheetname {string} and rownumber {int}")
	public void update_notes_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details :" + testdata);

			String notes = testdata.get(int1).get("Notes");

			if (notes != null && !notes.isEmpty()) {
				Thread.sleep(1000);
				FL.Clearnotes();
				FL.enternotes(notes);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

	@Then("click the Update button")
	public void click_the_update_button() throws Exception {
		try {
			FL.clickcreate();
			Thread.sleep(3000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Form");
			throw e;
		}
	}

}