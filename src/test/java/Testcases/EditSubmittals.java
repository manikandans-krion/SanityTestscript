package Testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EditSubmittals {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.SubmittalsLocators S;
	public Locators.Issue_Locators ISS;
	public ExcelDataManager excelDataManager=ExcelDataManager.getInstance();
	
	 @Before
     public void setUp() throws InvalidFormatException, IOException {
         excelDataManager.loadData("C:\\Users\\TWINUser13\\Desktop\\Edit_krion6D\\EditModules_DemoURL_Krion6D\\Excel\\TigerKrionDataSheet.xlsx");
     }
	 
	public EditSubmittals() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboselogging", "true");
		this.driver=CustomWebDriverManager.getDriver();
		this.S=new Locators.SubmittalsLocators(driver);
		this.ISS= new Locators.Issue_Locators(driver);
	}	
	@Then("filtering the required Submittals and clicking on it using sheetname {string} and rownumber {int}")
	public void filtering_the_required_submittals_and_clicking_on_it_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
	    try {
	  
	    	List<Map<String,String>> testdata=excelDataManager.getCachedData(sheetname);
	    	System.out.println("Sheet details :"+testdata);
	    	String projectcode=testdata.get(rownumber).get("Project Code");
	    	ISS.ClickOnDesignProject();
	    	Thread.sleep(2000);
	    	S.Navigateproject();
	    	Thread.sleep(4000);
	    	S.EnterOnSearchBox(projectcode);
	    	Thread.sleep(2000);
	    	S.clickOnProject(projectcode);
	    	Thread.sleep(3000);
	    	driver.navigate().refresh();
	    	Thread.sleep(3000);
	    	S.viewMenu();
	    	S.submittalclick();
			Thread.sleep(4000);
			S.SelectStatusclick();
			Thread.sleep(4000);
			String status=testdata.get(rownumber).get("Status");
			System.out.println("Status :"+status);
			S.SelectStatusType(status);
			Thread.sleep(4000);
			String submittalcode=testdata.get(rownumber).get("OldSubmittal code");
			System.out.println("submittal code :"+submittalcode);
			S.EnterOnSearchsubmittals(submittalcode);
			Thread.sleep(4000);
			S.clickOnEdit();
			Thread.sleep(2000);
	    	
	    }catch(Exception e) {
	    	ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
	    }
	}
	
	@Then("Changing the required field in Submittals using sheetname {string} and rownumber {int}")
	public void changing_the_required_field_in_submittals_using_sheetname_and_rownumber(String sheetname, Integer rownumber) throws Exception {
		try {
			
			List<Map<String,String>>testdata=excelDataManager.getCachedData(sheetname);					
		}catch(Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}  
	}
	
	@Then("Update the Submittalcode using the sheetname {string} and rownumber {int}")
	public void update_the_submittalcode_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

			String updatecode = testdata.get(int1).get("Update submittal code");
			if (updatecode != null && !updatecode.isEmpty()) {
				Thread.sleep(3000);
				System.out.println("update code :" + updatecode);
				S.clearcode();
				S.entersubtmlCode(updatecode);
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update the submittalname using the sheetname {string} and rownumber {int}")
	public void update_the_submittalname_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String updatename=testdata.get(int1).get("Updatename");
			if(updatename!=null && !updatename.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("name :"+updatename);
				S.clearname();
				S.entersubtlname(updatename);
			}
			
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update the Spec Section dropdown using the sheetname {string} and rownumber {int}")
	public void update_the_spec_section_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String specsection=testdata.get(int1).get("Spec section");
			if(specsection!=null && !specsection.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("specsection :"+specsection);
				S.clickspecsection();
				S.selectspecsection(specsection);
			}
			
			
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update the Sub Spec Section dropdown using the sheetname {string} and rownumber {int}")
	public void update_the_sub_spec_section_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String subspecsection=testdata.get(int1).get("Sub spec section");
			if(subspecsection!=null && !subspecsection.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("subspecsection"+subspecsection);
				S.clearsubspec();
				S.entersubspec(subspecsection);
			}
			
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update the Descriptions using the sheetname {string} and rownumber {int}")
	public void update_the_descriptions_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String desc=testdata.get(int1).get("Description");
			if(desc!=null && !desc.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("desc :"+desc);
				S.cleardesc();
				S.enterdescription(desc);
			}
			
			
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update the Type dropdown using the sheetname {string} and rownumber {int}")
	public void update_the_type_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String type=testdata.get(int1).get("Type");
			if(type!=null && !type.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("type :"+type);
				S.typeclick();
				S.selecttype(type);
			}
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update the Workflow for submittal dropdown using the sheetname {string} and rownumber {int}")
	public void update_the_workflow_for_submittal_dropdown_using_the_sheetname_and_rownumber(String string,
			Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String wf=testdata.get(int1).get("Workflow");
			if(wf!=null && !wf.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("wf :"+wf);
				S.selectworkflow(wf);
			}
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update Due Date using the sheetname {string} and rownumber {int}")
	public void update_due_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String duedate=testdata.get(int1).get("Due Date");
			String duemonth=testdata.get(int1).get("Due Month");
			String dueyear=testdata.get(int1).get("Due Year");
						
			if ((duedate != null && !duedate.isEmpty())
					&& (duemonth != null && !duemonth.isEmpty())
					&& (dueyear != null && !dueyear.isEmpty()))
				{
					if(duedate !=null && duedate.matches("\\d+\\.0")) {
						duedate= duedate.substring(0,duedate.indexOf(".0"));
					}
					
					if(duemonth !=null && duemonth.matches("\\d+\\.0")) {
						duemonth= duemonth.substring(0,duemonth.indexOf(".0"));
					}
					
					if(dueyear !=null && dueyear.matches("\\d+\\.0")) {
						dueyear= dueyear.substring(0,dueyear.indexOf(".0"));
					}
						Thread.sleep(1000);
						System.out.println("Date"+duedate);
						System.out.println("Month"+duemonth);
						System.out.println("Year"+dueyear);
						String formatteddate=String.format("%02d/%02d/%d",Integer.parseInt(duemonth),Integer.parseInt(duedate),Integer.parseInt(dueyear));
						System.out.println(formatteddate);
						S.clearduedate();
						S.selectduedate(formatteddate);
						
				}
			
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update the Priority dropdown using the sheetname {string} and rownumber {int}")
	public void update_the_priority_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String priority=testdata.get(int1).get("Priority");
			if(priority!=null && !priority.isEmpty()) {
				Thread.sleep(1000);
				S.priorityclick();
				S.selectpriority(priority);
			}
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update Required Date using the sheetname {string} and rownumber {int}")
	public void update_required_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String reqdate=testdata.get(int1).get("Req Date");
			String reqmonth=testdata.get(int1).get("Req Month");
			String reqyear=testdata.get(int1).get("Req Year");
						
			if ((reqdate != null && !reqdate.isEmpty())
					&& (reqmonth != null && !reqmonth.isEmpty())
					&& (reqyear != null && !reqyear.isEmpty()))
				{
					if(reqdate !=null && reqdate.matches("\\d+\\.0")) {
						reqdate= reqdate.substring(0,reqdate.indexOf(".0"));
					}
					
					if(reqmonth !=null && reqmonth.matches("\\d+\\.0")) {
						reqmonth= reqmonth.substring(0,reqmonth.indexOf(".0"));
					}
					
					if(reqyear !=null && reqyear.matches("\\d+\\.0")) {
						reqyear= reqyear.substring(0,reqyear.indexOf(".0"));
					}
						Thread.sleep(1000);
						System.out.println("Date"+reqdate);
						System.out.println("Month"+reqmonth);
						System.out.println("Year"+reqyear);
						String formatteddate=String.format("%02d/%02d/%d",Integer.parseInt(reqmonth),Integer.parseInt(reqdate),Integer.parseInt(reqyear));
						System.out.println(formatteddate);
						S.clearreqdate();
						S.selectreqdate(formatteddate);
						
				}
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update Required approval Date using the sheetname {string} and rownumber {int}")
	public void update_required_approval_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String reqappdate=testdata.get(int1).get("ReqApp Date");
			String reqappmonth=testdata.get(int1).get("ReqApp Month");
			String reqappyear=testdata.get(int1).get("ReqApp Year");
						
			if ((reqappdate != null && !reqappdate.isEmpty())
					&& (reqappmonth != null && !reqappmonth.isEmpty())
					&& (reqappyear != null && !reqappyear.isEmpty()))
				{
					if(reqappdate !=null && reqappdate.matches("\\d+\\.0")) {
						reqappdate= reqappdate.substring(0,reqappdate.indexOf(".0"));
					}
					
					if(reqappmonth !=null && reqappmonth.matches("\\d+\\.0")) {
						reqappmonth= reqappmonth.substring(0,reqappmonth.indexOf(".0"));
					}
					
					if(reqappyear !=null && reqappyear.matches("\\d+\\.0")) {
						reqappyear= reqappyear.substring(0,reqappyear.indexOf(".0"));
					}
						Thread.sleep(1000);
						System.out.println("Date"+reqappdate);
						System.out.println("Month"+reqappmonth);
						System.out.println("Year"+reqappyear);
						String formatteddate=String.format("%02d/%02d/%d",Integer.parseInt(reqappmonth),Integer.parseInt(reqappdate),Integer.parseInt(reqappyear));
						System.out.println(formatteddate);
						S.clearreqappdate();
						S.selectreqappdate(formatteddate);
						
				}
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update Required on jobsite Date using the sheetname {string} and rownumber {int}")
	public void update_required_on_jobsite_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String jobsitedate=testdata.get(int1).get("Jobsite Date");
			String jobsitemonth=testdata.get(int1).get("Jobsite Month");
			String jobsiteyear=testdata.get(int1).get("Jobsite Year");
			
			if ((jobsitedate != null && !jobsitedate.isEmpty())
					&& (jobsitemonth != null && !jobsitemonth.isEmpty())
					&& (jobsiteyear != null && !jobsiteyear.isEmpty()))
				{
					if(jobsitedate !=null && jobsitedate.matches("\\d+\\.0")) {
						jobsitedate= jobsitedate.substring(0,jobsitedate.indexOf(".0"));
					}
					
					if(jobsitemonth !=null && jobsitemonth.matches("\\d+\\.0")) {
						jobsitemonth= jobsitemonth.substring(0,jobsitemonth.indexOf(".0"));
					}
					
					if(jobsiteyear !=null && jobsiteyear.matches("\\d+\\.0")) {
						jobsiteyear= jobsiteyear.substring(0,jobsiteyear.indexOf(".0"));
					}
						Thread.sleep(1000);
						System.out.println("Date"+jobsitedate);
						System.out.println("Month"+jobsitemonth);
						System.out.println("Year"+jobsiteyear);
						String formatteddate=String.format("%02d/%02d/%d",Integer.parseInt(jobsitemonth),Integer.parseInt(jobsitedate),Integer.parseInt(jobsiteyear));
						System.out.println(formatteddate);
						S.clearjosbitedate();
						S.selectjobsitedate(formatteddate);
						
				}
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update Lead time using the sheetname {string} and rownumber {int}")
	public void update_lead_time_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			String leadtime=testdata.get(int1).get("Lead time");
			if(leadtime!=null && !leadtime.isEmpty()) {
				Thread.sleep(1000);
				S.clearleadtime();
				S.enterleadtime(leadtime);
			}
		
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Update Attach file name using the sheetname {string} and rownumber {int}")
	public void update_attach_file_name_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		try {
			List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
			
			String attachfile=testdata.get(int1).get("Attachfile");
			String filename=testdata.get(int1).get("File Name");
			if(attachfile!=null && !attachfile.isEmpty() && filename!=null && !filename.isEmpty()) {
				Thread.sleep(1000);
				System.out.println("Attachfile" + attachfile);
				System.out.println("filename" + filename);
				S.selectfiletype(attachfile);
				Thread.sleep(3000);
				S.searchfile(filename);
				Thread.sleep(3000);
				S.fileattach();
				S.attachedbtnclick();
		}
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Given("Click Update button in the screen")
	public void click_update_button_in_the_screen() throws Exception {
		try {
			S.createclick();
			Thread.sleep(4000);
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}

	@Then("Submittals should be Updated")
	public void submittals_should_be_updated() {
		try {
			System.out.println("SUbmittals is Updated Successfully");
		}catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Edit Submittals");
			throw e;
		}
	}


	

}