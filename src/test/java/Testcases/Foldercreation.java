package Testcases;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

public class Foldercreation {

	private WebDriver driver;
	private Locators.FolderLocators FC;
	private ExtentTest test;
	private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager
		.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");
}

	public Foldercreation() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.FC = new Locators.FolderLocators(driver);
	}

	@Given("Select the project using sheetname {string} and rownumber {int}")
	public void select_the_project_using_sheetname_and_rownumber(String string, Integer int1) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Plus button Should to be click");
		
		String pname = testdata.get(int1).get("Projectname");
		System.out.println(pname);
		
	//	FC = new Locators.FolderLocators(driver);
		Folderdatas("projectname", pname);
		FC.Navigateproject();
		FC.pname(pname);
		FC.projectclik();
	}

	@Then("Navigate to that project dashboard")
	public void navigate_to_that_project_dashboard() throws Exception {
		FC.navigatetodoc();
		Thread.sleep(3000);
		
	}

	@Given("User can create the new folder by foldername entered using the sheetname {string} and rownumber {int}")
	public void user_can_create_the_new_folder_by_foldername_entered_using_the_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		FC.Newfolder();
		System.out.println("Plus button is clicked");
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Plus button Should to be click");
		
		String Fname = testdata.get(int1).get("Foldername");
		System.out.println(Fname);
		
		FC = new Locators.FolderLocators(driver);
		Folderdatas("foldername", Fname);
		
		FC.enterFoldername(Fname);
		
		System.out.println("Folder name is Entered");
		System.out.println("New Folder should be created");
	}

	@Then("New folder should be created")
	public void new_folder_should_be_created() {
		System.out.println("Save button is clicked");
		FC.clicksave();
	}		
	@Given("User can create the new subfolder by subfoldername entered using the sheetname {string} and rownumber {int}")
	public void user_can_create_the_new_subfolder_by_subfoldername_entered_using_the_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		System.out.println("Creating subfolder");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		System.out.println("Plus button Should to be click");
		
		String sname = testdata.get(int1).get("Subfoldername");
		System.out.println(sname);
		
		FC = new Locators.FolderLocators(driver);
		Folderdatas("subfoldername", sname);
		
		FC.subfolder(sname);
		FC.clicksave();
	}

	private void Folderdatas(String fieldName, String fieldValue) {

		test = ExtentCucumberAdapter.getCurrentStep();
		ExtentReports extent = new ExtentReports();
		test = extent.createTest("Test Name");
		System.out.println("Test values ======================>" + test);

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
