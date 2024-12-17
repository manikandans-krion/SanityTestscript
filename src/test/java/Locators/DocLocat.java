package Locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocLocat {

	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@FindBy(xpath = "//aside[@id='project-sidebar']/ul/descendant::li[3]")
	private WebElement doc;

//	@FindBy(xpath = "//div[@class='card-header ng-star-inserted']/button[1]")
//	private WebElement clickuploadfiles;
	
	@FindBy(xpath = "//*[@id='main']//app-project-management//app-document-list//button[1]")
	private WebElement clickuploadfiles;

	
	
	
	@FindBy(xpath="//ejs-uploader[@id='fileupload']//input[@type='file']")
	private WebElement uploadfilebtn;
		
	
	@FindBy(xpath="//ul[@class='e-upload-files']/li")
	private WebElement filecount;
	
	@FindBy(xpath="//span[starts-with(@class,'e-file-status')]")
	private WebElement filestatus;
	
	@FindBy(xpath="//div[@class='modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable']//button[@aria-label='Close']")
	private WebElement Close;
	
	@FindBy(xpath="//button[.=' Done ']")
	private WebElement Done;
	
	
	public DocLocat(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofMillis(30));
		PageFactory.initElements(driver, this);
	}
	
	
	public void navigatetodoc(){
		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(doc));
		act.click(doc).build().perform();
	}
	
	public void uploadbtn(){
		wait.until(ExpectedConditions.elementToBeClickable(clickuploadfiles));
		clickuploadfiles.click();
	}
	
	public void uploadfile(){
		wait.until(ExpectedConditions.elementToBeClickable(uploadfilebtn));
		uploadfilebtn.click();
	}
	
	
	
	
	
	
	  public void UploadingAnImage(String imageFilePath ) {
	    	if (imageFilePath != null && !imageFilePath.isEmpty()) {
	        System.out.println("Image path from Excel: " + imageFilePath);
	        uploadfilebtn.sendKeys(imageFilePath);
	        System.out.println("Image uploaded successfully: " + imageFilePath);
	    	} else {
	        throw new RuntimeException("Image file path is not available in the Excel sheet or it's invalid.");
	       
	    	}
	    }
	  
	public int count() {
		List<WebElement>Uploadedcount=driver.findElements(By.xpath("//ul[@class='e-upload-files']/li"));
		int Actualcount=Uploadedcount.size();
		return Actualcount;
	}
	
	public int sucessfullcount() {
		List<WebElement>Successcount=driver.findElements(By.xpath("//*[@id='fileupload']/div/ul/li/span/span[4]"));
		int success=Successcount.size();		
		return success;
	}
	
	public void filestatus() {
		List<WebElement>file_status=driver.findElements(By.xpath("//span[starts-with(@class,'e-file-status')]"));
		for(WebElement k:file_status) {
			//wait.until(ExpectedConditions.visibilityOfAllElements(file_status));
			String t=k.getText();
			System.out.println(t);
		}
		
	}
	
	int passcount = 0;
	int failcount=0;
	public void Individual() {
		List<WebElement>Successcount=driver.findElements(By.xpath("//*[@id='fileupload']/div/ul/li/span/span[4]"));
			for(WebElement k:Successcount) {
				String t=k.getText();
				if(t.equalsIgnoreCase("File uploaded successfully"))
				{
					passcount++;
				} else if(t.equalsIgnoreCase("File upload canceled"))
				{
					failcount++;
				}
			}
			System.out.println("Successfully uploaded files count is : "+passcount);
			System.out.println("Failed Uploaded count is :"+failcount);
	}
	
	public void close() {
		Close.click();
	}
}
