package com.trigent.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.trigent.base.BaseTest;

public class UploadCensusPage extends BaseTest{
	public WebDriver driver;
	
	@FindBy(xpath ="//li[@id='employeeTab']/a")
	WebElement ClickEmployees;
	
	@FindBy(xpath ="//button[@id='uploadCensusBtn']")
	WebElement ClickUploadCensus;
	
	//Upload Enrollment Census pop up header
	@FindBy(xpath ="//span[contains(text(), 'Upload Enrollment Census')]")
	WebElement popupheader;
	
	@FindBy(xpath ="//*[@id='censusUploadForm']/span[1]/span/span")
	WebElement Browse;
	
	
	@FindBy(xpath ="//input[@id='uploadBtn']")
	WebElement Upload;
	
	@FindBy(xpath="//div[@id='message']/span")
	WebElement Message;
	
	@FindBy(xpath="//button[@id='continueBtn']")
	WebElement Continue;
	
	@FindBy(xpath="//div[@id='message']")
	WebElement ValidMessage;
	
	@FindBy(xpath="//button[@id='finalCensusBtn']")
	WebElement FinalCensusUpload;
	
	@FindBy(xpath="//div[@id='message']")
	WebElement Success;
	
	
	
	
	
	
	
	
	@FindBy(xpath ="//button[@id='closeUploadCensusBtn']")
	WebElement Closebutton;
	
	@FindBy(xpath ="//table[@id='employeeTable']/tbody")
	WebElement EmployeeTable;
	
//*****************************************************************************************************************************************************************************************
//Smoke Test Cases methods
	
	public UploadCensusPage(WebDriver dr) {
		// TODO Auto-generated constructor stub
		driver=dr;
	}
	
	 
// To Click Employees Tab 	
   public void SelectEmployee() throws InterruptedException {
	ClickEmployees.click();
	Thread.sleep(1000);
	 }
   
   
// To verify Upload Census file pop up	
	   
public void verifyUploadCensusPage() throws InterruptedException, AWTException {
	ClickUploadCensus.click();
	Thread.sleep(5000);
	popupheader.click();	
	Thread.sleep(1000);
	String Uploadpopupheader = popupheader.getText();	
	System.out.print("Popup Header for Upload: " + Uploadpopupheader);
	Thread.sleep(5000);
	String Expectedpopupheader = "Upload Enrollment Census";
	Assert.assertEquals(Uploadpopupheader, Expectedpopupheader);
	System.out.print("\nSuccessfully Verified the pop up Header");
}
	

public void Filepath() {
	StringSelection filecensus = new StringSelection (System.getProperty("user.dir") + "\\TestData\\Enrollment_Census.xlsx");
    System.out.print("File Path of the excel -------->" +filecensus);
    
}

//To Upload Census file	

	public void UploadCensus() throws InterruptedException, AWTException  {
		    Browse.click();
		    Thread.sleep(3000);
		    String Filepath = (System.getProperty("user.dir") + "\\TestData\\Enrollment_Census.xlsx");
		    System.out.print("File Path of the excel -------->" +Filepath);
			//StringSelection filecensus = new StringSelection("E:\\Trigent\\Premium Calculation Guide_FINAL w PFL (1).PDF");
		    StringSelection filecensus = new StringSelection (System.getProperty("user.dir") + "\\TestData\\Enrollment_Census.xlsx");
		    System.out.print("File Path of the excel -------->" +filecensus);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filecensus, null); 
			Thread.sleep(1000);  
			//Create an object for robot class			
			Robot robot = new Robot(); 
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        robot.keyPress(KeyEvent.VK_CONTROL); 
	        
	        robot.keyPress(KeyEvent.VK_V); 
	        robot.keyRelease(KeyEvent.VK_V);
	         
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(50);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    	Thread.sleep(5000);
			System.out.print("\nSuccessfully Uploaded in popup\n");
			
			//To click Upload Button
			Upload.click();	
			Thread.sleep(5000);
			
	}
	 
	public void VerifyCensus() throws InterruptedException {
		System.out.println(Message.getText());
			try {
		
				Continue.click(); 
				Thread.sleep(3000);
				
					FinalCensusUpload.click();
					Thread.sleep(3000);
					System.out.println(Success.getText()); 			
			
			}
			
			catch(Exception e){
				
				try {
					FinalCensusUpload.click();
					Thread.sleep(3000);
					System.out.println(Success.getText());
				}
				catch(Exception fail){
					System.out.println("Your census upload was unsuccessful");	 
					driver.quit();
				}		   
				
			}
			
				
			Closebutton.click();
}
	
	public void CountCensusRecord() {
	
		//EmployeeTable.click();
		
		int rowSize = 0;
		List < WebElement > rows_table = EmployeeTable.findElements(By.xpath("tr"));		
		rowSize = rows_table.size();		
		System.out.println("No of Employees: " + rowSize);
		
	}
		
}
	
	

