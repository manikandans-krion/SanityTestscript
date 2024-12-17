package Testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
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
import Testcases.ExcelDataCache; // Adjust the package path accordingly

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Data.Datas;
import io.qameta.allure.Allure;
    public class RoleTestcases {
        
        private WebDriver driver;
        private Locators.LoginLocators L;
        private Locators.Roles_Locators R;
        private ExtentTest test;
        
        private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
        
        @Before
        public void setUp() throws InvalidFormatException, IOException {
            excelDataManager.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\DemoURL-Krion6D_Automation\\Excel\\TigerKrionDataSheet.xlsx");
        }
        

        public RoleTestcases() throws InterruptedException {
            System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
            System.setProperty("webdriver.chrome.verboseLogging", "true");
            this.driver = CustomWebDriverManager.getDriver();
            this.R = new Locators.Roles_Locators(driver);
        }
        
        
        
   
        @Given("I visit the User Login using sheetname {string} and rownumber {int}")
        public void i_visit_the_user_login_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
        	try {
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
              
              String email = testdata.get(rownumber).get("Login Email");
              String password = testdata.get(rownumber).get("Login Password");

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

        
        @And("I enter the credentials and click a login button")
        public void i_enter_the_credentials_and_click_a_login_button() throws Exception {
    		try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    			L.ClickOnLogin();
    		} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Login Page");
    		    throw e; 
    		}
        }
	
	
        @Then("Clicking on Role module under Administration")
        public void clicking_on_role_module_under_administration() {
        	try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    			R.ClickOnRole();
        	} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Main Page");
    		    throw e; 
    		}
        }
	
        @Then("Clicking on Add Role button to add the role")
        public void clicking_on_add_role_button_to_add_the_role() {
        	try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    			R.ClickOnADDRole();
        	} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Role Page");
    		    throw e; 
    		}
        }
	
        @Then("Entering Valid Role name using sheetname {string} and rownumber {int}")
        public void entering_valid_role_name_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
    			try {
    	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	        	  List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);

    			System.out.println("sheet name: " + testdata);
                
                String RoleName = testdata.get(rownumber).get("Role Name");
                Thread.sleep(1000);
                R.EnterOnRoleName(RoleName);
                LoginInputDatas("Rolename", RoleName);
    			} catch (Exception e) {
        			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
        		   exceptionHandler.handleException(e, "Role Page");
        		    throw e; 
        		}
        }
	
	
	
        @Then("Clicking on Select all check box to give all the persmission to the roles user")
        public void clicking_on_select_all_check_box_to_give_all_the_persmission_to_the_roles_user() {
        	try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    			R.ClickOnSelectAllOptions();
        	} catch (Exception e) {
    			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
    		   exceptionHandler.handleException(e, "Role Page");
    		    throw e; 
    		}
        }
	
	
        @Then("Click On Create button")
        public void click_on_create_button() {
        	try {
    			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    			R.ClickOnCreateButton();
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
