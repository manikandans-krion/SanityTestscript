package Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

public class TeamsTestcases {
	  private WebDriver driver;
      private Locators.LoginLocators L;
      private Locators.Roles_Locators R;
      private Locators.Teams_Locators T;
      private ExtentTest test;
      
      private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
      
      @Before
      public void setUp() throws InvalidFormatException, IOException {
          excelDataManager.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");
      }
      
      public TeamsTestcases() throws InterruptedException {
          System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
          System.setProperty("webdriver.chrome.verboseLogging", "true");
          this.driver = CustomWebDriverManager.getDriver();
          this.T = new Locators.Teams_Locators(driver);
      }
      
      

      

      @Then("Clicking on Teams module under Administration")
      public void clicking_on_teams_module_under_administration() throws Exception {
      	try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
  			Thread.sleep(2000);
  			T.ClickOnTeams();
      	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Main Page");
  		    throw e; 
  		}
      }
	
      @Then("Clicking on Add Team button to add the Team")
      public void clicking_on_add_role_button_to_add_the_role() {
      	try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
  			T.ClickOnADDTeam();
      	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Teams Page");
  		    throw e; 
  		}
      }
      
      
      
	
      @Then("Entering Valid Team name using sheetname {string} and rownumber {int}")
      public void entering_valid_team_name_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
  			try {
  	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

  			System.out.println("sheet name: " + testdata);
              
              String TeamName = testdata.get(rownumber).get("Team Name");
              Thread.sleep(1000);
              T.EnterOnTeamName(TeamName);
              LoginInputDatas("Teamname", TeamName);
  			} catch (Exception e) {
      			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
      		   exceptionHandler.handleException(e, "Teams Page");
      		    throw e; 
      		}
      }
	
	
      @Then("Entering Valid Team code using sheetname {string} and rownumber {int}")
      public void entering_valid_team_code_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
  			try {
  	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

  			System.out.println("sheet name: " + testdata);
              
              String TeamCode = testdata.get(rownumber).get("Team Code");
              Thread.sleep(1000);
              T.EnterOnTeamCode(TeamCode);
              LoginInputDatas("Teamcode", TeamCode);
  			} catch (Exception e) {
      			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
      		   exceptionHandler.handleException(e, "Teams Page");
      		    throw e; 
      		}
      }
     
      @Then("Click On Create button on Teams")
      public void click_on_create_button_on_teams() {
      	try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
  			T.ClickOnCreateButton();
      	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Role Page");
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
