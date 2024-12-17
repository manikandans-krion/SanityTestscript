package Testcases;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FormTestcases {

	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.FormLocators FL;
	public Locators.RFILocators RFI;
	public ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setup() throws InvalidFormatException, Exception {
		excelDataManager
				.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public FormTestcases() {
		System.setProperty("Webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("Webdriver.chrome.verboselogging", "true");
		driver = CustomWebDriverManager.getDriver();
		this.FL = new Locators.FormLocators(driver);
		this.RFI=new  Locators.RFILocators(driver);

	}


	@And("Route to Form in the Attachments Module")
	public void route_to_form_in_the_attachments_module() {
		System.out.println("Clicked the Form successfully");
		FL.routingForm();
	}

	@And("Select the report in the FORMS using the sheetname {string} and rownumber {int}")
	public void select_the_report_in_the_forms_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String formname = testdata.get(int1).get("Formname");
		System.out.println(formname);
		FL.selectformtype(formname);
	}

	@Then("Click the Add button on the screen")
	public void click_the_add_button_on_the_screen() {
		FL.clickadd();
	}

	@Then("Enter the from date using the sheetname {string} and rownumber {int}")
	public void enter_the_from_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String Fromdate = testdata.get(int1).get("Start Date");
		String Frommonth = testdata.get(int1).get("Start Month");
		String Fromyear = testdata.get(int1).get("Start Year");
		
		System.out.println(Fromdate);
		System.out.println(Frommonth);
		System.out.println(Fromyear);
		Thread.sleep(3000);
		if(Fromdate !=null && Fromdate.matches("\\d+\\.0")) {
			Fromdate=Fromdate.substring(0,Fromdate.indexOf(".0"));
			System.out.println("====================Actual passing values=============");
			System.out.println("Month is :" + Fromdate);
		}
		if(Frommonth !=null && Frommonth.matches("\\d+\\.0")) {
			Frommonth=Frommonth.substring(0,Frommonth.indexOf(".0"));
			System.out.println("Date is :" + Frommonth);
		}
		if(Fromyear !=null && Fromyear.matches("\\d+\\.0")) {
			Fromyear=Fromyear.substring(0,Fromyear.indexOf(".0"));
			System.out.println("Year is :" + Fromyear);
		}
		String formatteddate= String.format("%02d/%02d/%d", Integer.parseInt(Frommonth), Integer.parseInt(Fromdate), Integer.parseInt(Fromyear));
		System.out.println(formatteddate);
		FL.clearfromdate();
		FL.selectingfromdate(formatteddate);
		//FL.selectingfromdate(Frommonth);
		//FL.selectingfromdate(Fromyear);
	}

	@Then("Enter the due date using the sheetname {string} and rownumber {int}")
	public void enter_the_due_date_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String duedate = testdata.get(int1).get("Due Date");
		String duemonth = testdata.get(int1).get("Due Month");
		String dueyear = testdata.get(int1).get("Due Year");
		
		System.out.println(duedate);
		System.out.println(duemonth);
		System.out.println(dueyear);
		
		if(duedate !=null && duedate.matches("\\d+\\.0")) {
			duedate=duedate.substring(0,duedate.indexOf(".0"));
			System.out.println("====================Actual passing values=============");
			System.out.println("Month is :" + duedate);
		}
		if(duemonth !=null && duemonth.matches("\\d+\\.0")) {
			duemonth=duemonth.substring(0,duemonth.indexOf(".0"));
			System.out.println("Date is :" + duemonth);
		}
		if(dueyear !=null && dueyear.matches("\\d+\\.0")) {
			dueyear=dueyear.substring(0,dueyear.indexOf(".0"));
			System.out.println("Year is :" + dueyear);
		}
		String formatteddate= String.format("%02d/%02d/%d", Integer.parseInt(duemonth), Integer.parseInt(duedate), Integer.parseInt(dueyear));
		System.out.println(formatteddate);
		FL.clearduedate();
		FL.selectingduedate(formatteddate);
		//FL.selectingduedate(duemonth);
		//FL.selectingduedate(dueyear);
	}

	@Then("Enter the locationname using the sheetname {string} and rownumber {int}")
	public void enter_the_locationname_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String loc = testdata.get(int1).get("Location");
		FL.enterlocation(loc);
	}

	@Then("select workflowname using the sheetname {string} and rownumber {int}")
	public void select_workflowname_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String wf = testdata.get(int1).get("Workflow");
		FL.ClickOnworkflow();
		Thread.sleep(2000);
		FL.selectworkflow(wf);
		//S.selectDropdownOption(wf);
	}

	@Then("Enter description using the sheetname {string} and rownumber {int}")
	public void enter_description_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String desc = testdata.get(int1).get("Description");
		FL.enterdescription(desc);
	}

	@Then("Click Add Work button")
	public void click_add_work_button() throws Exception {
		RFI.scrolling(200);
		Thread.sleep(2000);
		FL.addworkbtnclick();
	}

	@Then("Enter work details using the sheetname {string} and rownumber {int}")
	public void enter_work_details_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String crew = testdata.get(int1).get("Crew");
		System.out.println(crew);
		Thread.sleep(2000);
		FL.entercrew(crew);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String workers=testdata.get(int1).get("Workers");
		System.out.println(workers);
		FL.enterworker(workers);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String hrs=testdata.get(int1).get("Total Hours");
		System.out.println(hrs);
		FL.entertotalhr(hrs);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String wkpf=testdata.get(int1).get("Work performed");
		System.out.println(wkpf);
		FL.enterworkperformed(wkpf);
		
	}

	@Then("Click Save button to save work details")
	public void click_save_button_to_save_work_details() {
		FL.worksave();
	}

	@Then("Click Add Material button")
	public void click_add_material_button() throws Exception {
		RFI.scrolling(200);
		Thread.sleep(2000);
		FL.addmaterialbtnclick();
	}

	@Then("Enter material details using the sheetname {string} and rownumber {int}")
	public void enter_material_details_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String material = testdata.get(int1).get("Material");
		System.out.println(material);
		FL.entermaterial(material);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String quantity = testdata.get(int1).get("Quantity1");
		System.out.println(quantity);
		FL.enterquantity(quantity);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String unit = testdata.get(int1).get("Unit");
		System.out.println(unit);
		FL.enterunit(unit);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String cmnt = testdata.get(int1).get("Comment");
		System.out.println(cmnt);
		FL.entercomment(cmnt);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
	}

	@Then("Click Save button to save material details")
	public void click_save_button_to_save_material_details() {
		FL.materialsave();
	}

	@Then("Click Add Equipment button")
	public void click_add_equipment_button() throws Exception {
		RFI.scrolling(200);
		Thread.sleep(2000);
		FL.addequipbtnclick();
	}

	@Then("Enter Equipment details using the sheetname {string} and rownumber {int}")
	public void enter_equipment_details_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String equipmentname = testdata.get(int1).get("Equipment");
		System.out.println(equipmentname);
		FL.enterequipmentname(equipmentname);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String quantity = testdata.get(int1).get("Quantity2");
		System.out.println(quantity);
		FL.entereqpquantity(quantity);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String hrsused = testdata.get(int1).get("Hours used");
		System.out.println(hrsused);
		FL.entereqphours(hrsused);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
		
		String cmnt = testdata.get(int1).get("Comments");
		System.out.println(cmnt);
		FL.entereqpcomment(cmnt);
		wait= new WebDriverWait(driver, Duration.ofMillis(4000));
	}

	@Then("Click Save button to save Equipment details")
	public void click_save_button_to_save_equipment_details() {
		FL.equipmentsave();
	}

	@Then("Enter Notes using the sheetname {string} and rownumber {int}")
	public void enter_notes_using_the_sheetname_and_rownumber(String string, Integer int1) {
		FL.clicknotes();
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String notes = testdata.get(int1).get("Notes");
		System.out.println(notes);
		FL.enternotes(notes);
	}

	@Then("click the create button")
	public void click_the_create_button() {
		FL.clickcreate();
	}

//	@Then("Form should be created")
//	public void form_should_be_created() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new io.cucumber.java.PendingException();
//	}
}
