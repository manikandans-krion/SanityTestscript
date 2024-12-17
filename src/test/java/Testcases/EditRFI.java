package Testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EditRFI {

	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.RFILocators RFI;
	public Locators.Issue_Locators ISS;
	public ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager.loadData(
				"C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public EditRFI() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.RFI = new Locators.RFILocators(driver);
		this.ISS = new Locators.Issue_Locators(driver);
	}

	@Then("filtering the required RFI and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_rfi_and_clicking_on_it_using_sheetname_and_rownumber(String sheetname,
			Integer rownumber) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			System.out.println("Sheet Details :" + testdata);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			Thread.sleep(1000);
			ISS.ClickOnDesignProject();
			String projectcode = testdata.get(rownumber).get("Project Code");
			Thread.sleep(2000);
			RFI.Navigateproject();
			Thread.sleep(4000);
			RFI.EnterOnSearchBox(projectcode);
			Thread.sleep(2000);
			RFI.clickOnProject(projectcode);
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			RFI.viewMenu();
			RFI.routingRFI();
			Thread.sleep(4000);
			String RFIcode = testdata.get(rownumber).get("OldRFI code");
			System.out.println("Code" + RFIcode);
			Thread.sleep(4000);
			RFI.SelectStatusclick();
			Thread.sleep(4000);
			String status = testdata.get(rownumber).get("Status");
			System.out.println("Status" + status);
			RFI.SelectStatusType(status);
			Thread.sleep(4000);
			RFI.EnterOnSearchRFI(RFIcode);
			Thread.sleep(4000);
			RFI.clickOnEdit();
			Thread.sleep(2000);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Changing the required field in RFI using sheetname {string} and rownumber {int}")
	public void changing_the_required_field_in_rfi_using_sheetname_and_rownumber(String sheetname, Integer rownumber)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(sheetname);
			System.out.println("sheet details: " + testdata);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}

	}

	@Then("Update the RFI code using the sheetname {string} and rownumber {int}")
	public void update_the_rfi_code_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);
			String code = testdata.get(int1).get("Update RFIcode");
			if (code != null && !code.isEmpty()) {
				RFI.clearcode();
				Thread.sleep(1000);
				System.out.println("Code" + code);
				RFI.enterCode(code);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update the RFI name using the sheetname {string} and rownumber {int}")
	public void update_the_rfi_name_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);
			String RFIname = testdata.get(int1).get("Updated RFIname");
			if (RFIname != null && !RFIname.isEmpty()) {
				RFI.clearname();
				Thread.sleep(1000);
				System.out.println("Updatedname" + RFIname);
				RFI.entername(RFIname);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update the RFI Question using the sheetname {string} and rownumber {int}")
	public void update_the_rfi_question_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);
			String question = testdata.get(int1).get("Question");

			if (question != null && !question.isEmpty()) {
				RFI.clearquestion();
				Thread.sleep(1000);
				System.out.println("question" + question);
				RFI.enterquestion(question);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update the Answer using the sheetname {string} and rownumber {int}")
	public void update_the_answer_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);
			String ans = testdata.get(int1).get("Answer");
			if (ans != null && !ans.isEmpty()) {
				RFI.clearanswer();
				Thread.sleep(1000);
				System.out.println("answer" + ans);
				RFI.enteranswer(ans);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update the Due Date using the sheetname {string} and rownumber {int}")
	public void update_the_due_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);

			String Duedate = testdata.get(int1).get("Due Date");
			String Duemonth = testdata.get(int1).get("Due Month");
			String Dueyear = testdata.get(int1).get("Due Year");

			if ((Duedate != null && !Duedate.isEmpty()) && (Duemonth != null && !Duemonth.isEmpty())
					&& (Dueyear != null && !Dueyear.isEmpty())) {
				if (Duedate.matches("\\d+\\.0")) {
					Duedate = Duedate.substring(0, Duedate.indexOf(".0"));
				}
				if (Duemonth.matches("\\d+\\.0")) {
					Duemonth = Duemonth.substring(0, Duemonth.indexOf(".0"));
				}
				if (Dueyear.matches("\\d+\\.0")) {
					Dueyear = Dueyear.substring(0, Dueyear.indexOf(".0"));
				}
				System.out.println(Duedate);
				System.out.println(Duemonth);
				System.out.println(Dueyear);
				String formattedDate = String.format("%02d/%02d/%d", Integer.parseInt(Duemonth),
						Integer.parseInt(Duedate), Integer.parseInt(Dueyear));
				System.out.println(formattedDate);
				RFI.cleardate();
				RFI.enterduedate(formattedDate);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update the Location using the sheetname {string} and rownumber {int}")
	public void update_the_location_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);

			String loc = testdata.get(int1).get("Location");
			if (loc != null && !loc.isEmpty()) {
				RFI.clearlocation();
				Thread.sleep(1000);
				RFI.enterLocation(loc);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update Type dropdown using the sheetname {string} and rownumber {int}")
	public void update_type_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);

			String type = testdata.get(int1).get("Type");
			if (type != null && !type.isEmpty()) {
				RFI.Typedropdownclick();
				Thread.sleep(1000);
				RFI.SelectTypedropdown(type);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Updaate Discipline dropdown using the sheetname {string} and rownumber {int}")
	public void updaate_discipline_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);
			Thread.sleep(3000);
			RFI.scrolling(150);
			Thread.sleep(3000);

			String discipline = testdata.get(int1).get("Discipline");
			if (discipline != null && !discipline.isEmpty()) {
				RFI.Disciplinedropdownclick();
				Thread.sleep(1000);
				RFI.SelectDisciplinedropdown(discipline);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update Category dropdown using the sheetname {string} and rownumber {int}")
	public void update_category_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);

			String category = testdata.get(int1).get("Category");
			if (category != null && !category.isEmpty()) {
				RFI.Categorydropdownclick();
				Thread.sleep(1000);
				RFI.SelectCategorydropdown(category);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update Workflow dropdown using the sheetname {string} and rownumber {int}")
	public void update_workflow_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);

			String wf = testdata.get(int1).get("Workflow");
			if (wf != null && !wf.isEmpty()) {
				Thread.sleep(1000);
				RFI.workflowselection(wf);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update Priority dropdown using the sheetname {string} and rownumber {int}")
	public void update_priority_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);

			String priority = testdata.get(int1).get("Priority");
			if (priority != null && !priority.isEmpty()) {
				RFI.prioritydropdownclick();
				Thread.sleep(1000);
				RFI.SelectPrioritydropdown(priority);
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update the Upload image from the image path using the sheetname {string} and rownumber {int}")
	public void update_the_upload_image_from_the_image_path_using_the_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);

			String imgpath = testdata.get(int1).get("Imagepath");
			if (imgpath != null && !imgpath.isEmpty()) {
				Thread.sleep(1000);
				System.out.println(imgpath);
				RFI.Imageupload(imgpath);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("Update Attach the file name using the sheetname {string} and rownumber {int}")
	public void update_attach_the_file_name_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			System.out.println("sheet details: " + testdata);

			String attachfile = testdata.get(int1).get("Attachfile");
			String Filename = testdata.get(int1).get("File Name");

			if ((attachfile != null && !attachfile.isEmpty()) && Filename != null && !Filename.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("Attachfile" + attachfile);
				System.out.println("filename" + Filename);
				RFI.selectfiletype(attachfile);
				Thread.sleep(3000);
				RFI.searchfile(Filename);
				Thread.sleep(3000);
				RFI.fileattach();
				RFI.attachedbtnclick();

			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Given("Click the update button")
	public void click_the_update_button() throws Exception {
		try {
			Thread.sleep(4000);
			RFI.ClickOnUpdate();
			Thread.sleep(4000);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit RFI");
			throw e;
		}
	}

	@Then("RFI should be Updated")
	public void rfi_should_be_updated() {
		System.out.println("RFI is updated successfully ");
	}

}