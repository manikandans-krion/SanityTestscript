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
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Locators.Form_Template_Locators;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;

public class FormTemplateTestcases {

	  private WebDriver driver;
      private Locators.LoginLocators L;
      private Locators.Form_Template_Locators F;
      private ExtentTest test;
      
      private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
      Form_Template_Locators formTemplateLocators;
      
      @Before
      public void setUp() throws InvalidFormatException, IOException {
          excelDataManager.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");
      }
      
	

      public FormTemplateTestcases() throws InterruptedException {
          System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
          System.setProperty("webdriver.chrome.verboseLogging", "true");
          this.driver = CustomWebDriverManager.getDriver();
          this.F = new Locators.Form_Template_Locators(driver);
      }
      
      
      
      
	
      @Then("Clicking on Form Template module under Administration")
      public void clicking_on_form_template_module_under_administration() throws Exception {
    		try {
      			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
      			Thread.sleep(2000);
      			F.ClickOnFormTemplate();
          	} catch (Exception e) {
      			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
      		   exceptionHandler.handleException(e, "Main Page");
      		    throw e; 
      		}
      }
	
      @Then("Clicking on Add Form  Template button to add the Form")
      public void clicking_on_add_form_template_button_to_add_the_form() {
    		try {
      			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
      			F.ClickOnADDFormTemplate();
          	} catch (Exception e) {
      			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
      		   exceptionHandler.handleException(e, "Form Template Page");
      		    throw e; 
      		}
      }
	
      @Then("Entering Valid Form name using sheetname {string} and rownumber {int}")
      public void entering_valid_Form_name_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
  			try {
  	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

  			System.out.println("sheet name: " + testdata);
              
              String FormName = testdata.get(rownumber).get("Form Name");
              Thread.sleep(1000);
              F.EnterOnFormName(FormName);
              LoginInputDatas("Formname", FormName);
  			} catch (Exception e) {
      			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
      		   exceptionHandler.handleException(e, "Form Template Page");
      		    throw e; 
      		}
      }
	
      @Then("Uploading PDF file using sheetname using sheetname {string} and rownumber {int}")
      public void uploading_pdf_file_using_sheetname_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    	  try {
              // Wait for file input to be visible
              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

              // Fetch PDF file path from the Excel data
              List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
              
              if (testdata == null || testdata.isEmpty()) {
                  throw new Exception("No data found in Excel sheet: " + sheetname);
              }

              // Get the PDF file path from the test data for the given row
              String pdfFilePath = testdata.get(rownumber).get("PDF");

              if (pdfFilePath == null || pdfFilePath.isEmpty()) {
                  throw new Exception("PDF file path not found for row: " + rownumber);
              }

              // Upload the PDF file using your upload method
              F.uploadPDF(pdfFilePath);

          } catch (Exception e) {
              // Handle exceptions using your custom ExceptionHandler
              ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
              exceptionHandler.handleException(e, "PDF Upload Page");
              throw e;
          }
      }

	
	@Then("Click on Create button to create Form Template")
	public void Click_on_Create_button_to_create_Form_Template() {
		try {
  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
  			F.ClickOnCreateButton();
      	} catch (Exception e) {
  			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
  		   exceptionHandler.handleException(e, "Form Template Page");
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
