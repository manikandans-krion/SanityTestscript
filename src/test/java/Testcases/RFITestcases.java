package Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RFITestcases {

	private WebDriver driver;
	private Locators.RFILocators RFI;
	 private Locators.Review_Actions_Locators RVW;
	 private Locators.Issue_Locators ISU;
	private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager
				.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");

	}

	public RFITestcases() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.RFI = new Locators.RFILocators(driver);
	     this.RVW = new Locators.Review_Actions_Locators(driver);
	     this.ISU = new Locators.Issue_Locators(driver);

	}


	@And("Navigate to RFI in the Action Module")
	public void navigate_to_rfi_in_the_action_module() {
		RFI.routingRFI();
		System.out.println("RFIList screen is displayed ");
	}

	@Then("Click the Add button")
	public void click_the_add_button() {
		RFI.Addbtn();
	}

	@And("Click the toggle button using the sheetname {string} and rownumber {int}")
	public void click_the_toggle_button_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String reviewbtn = testdata.get(int1).get("Create as Review");
		System.out.println(reviewbtn);
		
		if(reviewbtn!=null && reviewbtn.matches("\\d+\\.0")) {
			reviewbtn=reviewbtn.substring(0,reviewbtn.indexOf(".0"));
		}
		System.out.println(reviewbtn);
		RFI.disable(reviewbtn);
	}

	@When("Clear the default code in the RFIcode field")
	public void clear_the_default_code_in_the_rf_icode_field() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {

			RFI.clearcode();

		} catch (AWTException e) {
			System.out.println("Code is not cleared :" + e.getMessage());
		}
	}

	@Then("Enter the RFI code using the sheetname {string} and rownumber {int}")
	public void enter_the_rfi_code_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String code1 = testdata.get(int1).get("Suffixcode");
		String code =testdata.get(int1).get("RFIcode");
		
		try {
			if(code!=null && !code.isEmpty()) {
				RFI.enterCode(code);
			}
			if(code1!=null && !code1.isEmpty() && code1.matches("\\d+\\.0")) {
				code1=code1.substring(0,code1.indexOf(".0"));
				Thread.sleep(2000);
				RFI.enterCode(code1);
			}
		} catch (AWTException e) {
			System.out.println("Code is Not Entered :" + e.getMessage());
		}
	}

	@And("Enter the RFI name using the sheetname {string} and rownumber {int}")
	public void enter_the_rfi_name_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String name = testdata.get(int1).get("RFIname");

		RFI.entername(name);
	}

	@And("Enter the RFI Question using the sheetname {string} and rownumber {int}")
	public void enter_the_rfi_question_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String Question = testdata.get(int1).get("Question");

		RFI.enterquestion(Question);
	}

	@And("Enter the Answer using the sheetname {string} and rownumber {int}")
	public void enter_the_answer_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String Answer = testdata.get(int1).get("Answer");

		RFI.enteranswer(Answer);
	}

	@Then("Enter the Due Date using the sheetname {string} and rownumber {int}")
	public void enter_the_due_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String RFIdueDate = testdata.get(int1).get("Due Date");
		String RFIdueMonth = testdata.get(int1).get("Due Month");
		String RFIdueYear = testdata.get(int1).get("Due Year");

		System.out.println(RFIdueDate);
		System.out.println(RFIdueMonth);
		System.out.println(RFIdueYear);
		Thread.sleep(1000);
		RFI.datefieldclick();
		RFI.datefieldclear();
		
		
		if (RFIdueMonth != null && RFIdueMonth.matches("\\d+\\.0")) {
			RFIdueMonth = RFIdueMonth.substring(0, RFIdueMonth.indexOf(".0"));
			System.out.println("====================Actual passing values=============");
			System.out.println("Month is :"+RFIdueMonth);
		}
		if (RFIdueDate != null && RFIdueDate.matches("\\d+\\.0")) {
			RFIdueDate = RFIdueDate.substring(0, RFIdueDate.indexOf(".0"));
			System.out.println("Date is :"+RFIdueDate);
		}
		
		if (RFIdueYear != null && RFIdueYear.matches("\\d+\\.0")) {
			RFIdueYear = RFIdueYear.substring(0, RFIdueYear.indexOf(".0"));
			System.out.println("Year is :"+RFIdueYear);
		}	
		String formattedDate = String.format("%02d/%02d/%d", Integer.parseInt(RFIdueMonth), Integer.parseInt(RFIdueDate), Integer.parseInt(RFIdueYear));
		System.out.println(formattedDate);
		RFI.enterduedate(formattedDate);
		//RFI.enterduedate(RFIdueDate);
		//RFI.enterduedate(RFIdueMonth);
		//RFI.enterduedate(RFIdueYear);
	}

	@Then("Enter the Location using the sheetname {string} and rownumber {int}")
	public void enter_the_location_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String Loc = testdata.get(int1).get("Location");
		RFI.enterLocation(Loc);
	}

	@Then("Select Type dropdown using the sheetname {string} and rownumber {int}")
	public void select_type_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) {
		RFI.Typedropdownclick();
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String type = testdata.get(int1).get("Type");
		System.out.println(type);
		RFI.SelectTypedropdown(type);
	}

	@Then("Select Discipline dropdown using the sheetname {string} and rownumber {int}")
	public void select_discipline_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		Thread.sleep(3000);
		RFI.scrolling(150);
		Thread.sleep(3000);
		RFI.Disciplinedropdownclick();
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String discipline = testdata.get(int1).get("Discipline");
		System.out.println(discipline);
		RFI.SelectDisciplinedropdown(discipline);
	}

	@Then("Select Category dropdown using the sheetname {string} and rownumber {int}")
	public void select_category_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {
		Thread.sleep(3000);
		RFI.Categorydropdownclick();
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String category = testdata.get(int1).get("Category");
		System.out.println(category);
		RFI.SelectCategorydropdown(category);
	}

	@Then("Select Workflow dropdown using the sheetname {string} and rownumber {int}")
	public void select_workflow_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		Thread.sleep(3000);
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String workflow = testdata.get(int1).get("Workflow");
		System.out.println(workflow);
		Thread.sleep(2000);
		RFI.workflowselection(workflow);
	}

	@Then("Select Priority dropdown using the sheetname {string} and rownumber {int}")
	public void select_priority_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		Thread.sleep(3000);
		RFI.scrolling(150);
		Thread.sleep(3000);
		RFI.prioritydropdownclick();
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String priority = testdata.get(int1).get("Priority");
		System.out.println(priority);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		RFI.SelectPrioritydropdown(priority);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	}

	@Then("Upload image from the image path using the sheetname {string} and rownumber {int}")
	public void upload_image_from_the_image_path_using_the_sheetname_and_rownumber(String string, Integer int1) {
		RFI.scrolling(300);
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String path = testdata.get(int1).get("Imagepath");
		System.out.println(path);
		RFI.Imageupload(path);
	}

	@Then("Attach the file name using the sheetname {string} and rownumber {int}")
	public void attach_the_file_name_using_the_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
//		Thread.sleep(3000);
//		RFI.scrolling(250);
//		Thread.sleep(3000);
//		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
//		String name = testdata.get(int1).get("Filename");
//		System.out.println(name);
//		RFI.filesearch(name);
//		Thread.sleep(5000);
//		RFI.fileattach();
		
		
		 try {
	 	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 	     	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

	 			System.out.println("sheet name: " + testdata);

	 			String Attachfile = testdata.get(rownumber).get("Attachfile");
	 			String FileName = testdata.get(rownumber).get("File Name");
	 			Thread.sleep(1000);
	 			RVW.ClickOnAttachFiles();
	 			Thread.sleep(1000);
	 			ISU.attachFile(Attachfile,FileName);
	 			Thread.sleep(1000);													
	 			RVW.clickOnRequiredFile(FileName);
	 			Thread.sleep(2000);
	 			RVW.ClickOnAttachButton();
	 			} catch (Exception e) {
	 			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
	 		   exceptionHandler.handleException(e, "Add Issue Page");
	 		    throw e; 
	 		} 	
	}
	
	@Given("Click the create button")
	public void click_the_create_button() throws Exception {
		RFI.scrolling(250);
		Thread.sleep(2000);
		RFI.createClick();
	}

	@Then("RFI should be created")
	public void rfi_should_be_created() {
		
		System.out.println("RFI is Added successfully");
		
	}

}
