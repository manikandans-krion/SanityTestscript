package Testcases;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
public class DocTestcases {

	
	private WebDriver driver;
	private Locators.DocLocat DOC;
	private ExtentTest test;
	private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();
	
	
	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager
		.loadData("C:\\Users\\TWINUser13\\eclipse-workspace\\check\\Krion_6D_Consultation-main\\Excel\\TigerKrionDataSheet.xlsx");
}
	
	
	public DocTestcases() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.DOC = new Locators.DocLocat(driver);
	}


   @Then("Click on File upload button in document module")
   public void Click_on_File_upload_button_in_document_module() throws InterruptedException {
	 try {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
		Thread.sleep(4000);
		DOC.navigatetodoc();
		Thread.sleep(3000);
    } catch (Exception e) {
		ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
		   exceptionHandler.handleException(e, "Document Page");
		    throw e; 
		}
  }
	
   @Then("upload the document using sheetname {string}")
   public void upload_the_document_using_sheetname(String sheetname) throws Exception {
       try {
           List<Map<String, String>> testData = excelDataManager.getCachedData(sheetname);
           System.out.println("Sheet data: " + testData);
           for (int rowIndex = 0; rowIndex < testData.size(); rowIndex++) {
               String imageFilePath = testData.get(rowIndex).get("Documentpath");

               if (imageFilePath == null || imageFilePath.trim().isEmpty()) {
                   System.out.println("No document path found at row " + (rowIndex + 1) + ". Skipping this row.");
                   continue;
               }
               Thread.sleep(3000);  
               DOC.uploadbtn();
               System.out.println("Uploading file from path: " + imageFilePath);
               Thread.sleep(2000); 
               DOC.UploadingAnImage(imageFilePath);
               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
               wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[starts-with(@class,'e-file-status') and contains(text(),'File uploaded successfully')]")));
               System.out.println("File uploaded successfully: " + imageFilePath);
               Thread.sleep(4000);  
               DOC.close();
           }
       } catch (Exception e) {
           ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
           exceptionHandler.handleException(e, "Document Page");
           throw e; 
       }
   }

	
	
	
	
	
	
	
	
	
	
}
