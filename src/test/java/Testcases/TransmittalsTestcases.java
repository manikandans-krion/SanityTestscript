package Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransmittalsTestcases {
	
	public WebDriver driver;
	public Locators.TransmittalsLocators T;
	public Locators.RFILocators RFI;
	public Locators.SubmittalsLocators S;
	 private Locators.Review_Actions_Locators RVW;
	 private Locators.Issue_Locators ISU;
	public ExcelDataManager excelDataManager= ExcelDataManager.getInstance();
	
	@Before
	public void setup() throws InvalidFormatException, IOException {
		excelDataManager.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");
	}
	
	public TransmittalsTestcases() {
		System.setProperty("Webdriver.chrome.log", "chromedriver.logfile");
		System.setProperty("Webdriver.chrome.verboselogging", "true");
		this.driver= CustomWebDriverManager.getDriver();
		this.T=new Locators.TransmittalsLocators(driver);
		this.RFI=new Locators.RFILocators(driver);
		this.S = new Locators.SubmittalsLocators(driver);
		this.RVW = new Locators.Review_Actions_Locators(driver);
		this.ISU = new Locators.Issue_Locators(driver);
	}
	
	
	@And("Navigate to Transmittals in the Share Module")
	public void navigate_to_transmittals_in_the_share_module() {
	   T.Transmittalclick();
	}
	
	@Then("Click Add button in the screen")
	public void click_add_button_in_the_screen() throws InterruptedException {
	   T.addbtnclick();
	   Thread.sleep(3000);
	}
	
	@And("Enable or disable the toggle button using the sheetname {string} and rownumber {int}")
	public void Enable_or_disable_the_toggle_button_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		
		String reviewbtn = testdata.get(int1).get("Create as Review");
		System.out.println(reviewbtn);
		
		if(reviewbtn!=null && reviewbtn.matches("\\d+\\.0")) {
			reviewbtn=reviewbtn.substring(0,reviewbtn.indexOf(".0"));
		}
		System.out.println(reviewbtn);
		T.togglebtnclick(reviewbtn);
	}

	@When("Clear the default code in the Transmittalcode field")
	public void clear_the_default_code_in_the_transmittalcode_field() throws AWTException {
	   T.clearcode();
	}
	
	@Then("Enter the Transmittalcode using the sheetname {string} and rownumber {int}")
	public void enter_the_transmittalcode_using_the_sheetname_and_rownumber(String string, Integer int1) throws AWTException {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String code=testdata.get(int1).get("Transmittal code");
		String code1=testdata.get(int1).get("Suffixcode");
		if(code!=null && !code.isEmpty()) {
			T.entertransmtlCode(code);
		}
		
		System.out.println(code);
		if(code1!=null && code1.matches("\\d+\\.0")) {
			code1=code1.substring(0,code1.indexOf(".0"));
		}
		System.out.println("====code===="+code1);
	    T.entertransmtlCode(code1);
	}
	
	@And("Enter the Transmittalname using the sheetname {string} and rownumber {int}")
	public void enter_the_transmittalname_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String name=testdata.get(int1).get("Transmittal name");
		System.out.println(name);
		T.entertransmtlname(name);
		
	}

	@Then("Enter the Descriptions of transmittal using the sheetname {string} and rownumber {int}")
	public void enter_the_descriptions_of_transmittal_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String description=testdata.get(int1).get("Description");
		System.out.println(description);
		T.enterdescription(description);
	}
	
	@Then("Select the Workflow for transmittal dropdown using the sheetname {string} and rownumber {int}")
	public void select_the_workflow_for_transmittal_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String wf=testdata.get(int1).get("Workflow");
		System.out.println(wf);
		//T.selectworkflow(wf);
		S.ClickOnWorkflow();
		Thread.sleep(1000);
		//S.selectworkflow(workflow);
		S.selectDropdownOption(wf);
	}
	
	@Then("Attach the file by the filename using the sheetname {string} and rownumber {int}")
	public void attach_the_file_by_the_filename_using_the_sheetname_and_rownumber(String sheetname, Integer rownumber) throws InterruptedException {
	   
//		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
//		
//		String filename=testdata.get(int1).get("File name");
//		System.out.println(filename);
//		RFI.scrolling(200);
//		Thread.sleep(3000);
//		T.clickattachbtn();
//		T.driverbtnclick();
//		T.attachfile(filename);
//		T.checkboxclick();
		
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

				
	}
	
	@Given("Click the create button in the screen")
	public void click_the_create_button_in_the_screen() {
	    T.createclick();
	}
	
	@Then("Transmittals should be created")
	public void transmittals_should_be_created() {
	   System.out.println("Transmittal is successfully created ...");
	}
	
}
