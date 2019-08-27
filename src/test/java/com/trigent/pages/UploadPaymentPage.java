package com.trigent.pages;
import java.awt.AWTException; 
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import com.trigent.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;

public class UploadPaymentPage extends BaseTest{
	By menuUploadPayment = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(), 'Upload Payment')]");
    By btnUploadPayment = By.id("uploadPayment");
    By btnDownloadTemplate = By.xpath("//button[contains(text(), 'Download Template')]");
    By btnUnmatchedPayment = By.xpath("//button[contains(text(), 'Unmatched Payment')]");
    By btnUpload2 = By.id("saveUserBtn"); 
    By btnChoose = By.xpath("//input[@name='userfile']");
    By uploadSuccessmsg = By.xpath("//div[@class='alert alert-success alert-dismissable']");                                                
    By uploadAlertmsg = By.xpath("//div[@class='panel-body up']//div[@class='alert alert-danger alert-dismissable']");
    By headerUnmatchedPayment = By.xpath("//span[@class='h4size']//span");
    By btnProcess_row1 = By.xpath("//tr[last()]//button[@name='processNow']");
    By btnRemoveSubmit = By.xpath("//button[@id='removeAndSubmit']");
    
public void clickUploadPaymentMenu() {
	driver.findElement(menuUploadPayment).click(); 
}
public void assertUploadPayment() {
	String btn1 = driver.findElement(btnUnmatchedPayment).getText();
	System.out.println("Button1 :" +btn1);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	String btn2 = driver.findElement(btnDownloadTemplate).getText();
	System.out.println("Button2 :" +btn2);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	String btn3 = driver.findElement(btnUploadPayment).getText();
	System.out.println("Button3 :" +btn3);
	 
}
public void clickUnmatchedPaymentBtn() {
	driver.findElement(btnUnmatchedPayment).click();
}
public void clickUploadPaymentBtn() {
	driver.findElement(btnUploadPayment).click();
}
public void clickDownloadBtn() throws InterruptedException {
	driver.findElement(btnDownloadTemplate).click();
	Thread.sleep(5000);
	System.out.println("Sample Template Downloaded Successfully");
	
}
public void chooseFile_Unmatchedpayment() throws InterruptedException, AWTException  {
	driver.findElement(btnChoose).click();
	StringSelection fileUM = new StringSelection("D:\\upload_payment_UM.xlsx");	
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileUM, null);
    Thread.sleep(1000);
    Robot robot1 = new Robot();
    robot1.delay(250);
    robot1.keyPress(KeyEvent.VK_ENTER);
    robot1.keyRelease(KeyEvent.VK_ENTER);
    robot1.keyPress(KeyEvent.VK_CONTROL);
    robot1.keyPress(KeyEvent.VK_V);
    robot1.keyRelease(KeyEvent.VK_V);
    robot1.keyRelease(KeyEvent.VK_CONTROL);
    robot1.keyPress(KeyEvent.VK_ENTER);
    robot1.delay(50);
    robot1.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
}

    public void chooseFile_Matchedpayment() throws InterruptedException, AWTException  {
    	driver.findElement(btnChoose).click();    	
    	StringSelection fileM = new StringSelection (System.getProperty("user.dir") + "\\TestData\\upload_payment.xlsx");
    	System.out.print("File Path of the excel -------->" +fileM);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileM, null);
        Thread.sleep(1000);   
        Robot robot1 = new Robot();
        robot1.delay(250);
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        
        robot1.keyPress(KeyEvent.VK_CONTROL);
        
        robot1.keyPress(KeyEvent.VK_V);
        robot1.keyRelease(KeyEvent.VK_V);
         
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.delay(50);
        robot1.keyRelease(KeyEvent.VK_ENTER);
    	Thread.sleep(5000);
    }
   
    
public void clickUploadBtn2 () {
	driver.findElement(btnUpload2).click();
}
public void validateUploadSuccessMsg() {
	String successMsg = driver.findElement(uploadSuccessmsg).getText();	
		System.out.println("File Upload Status : " + successMsg);		
		
}


public void validateUploadAlertMsg() {
	String alertMsg = driver.findElement(uploadAlertmsg).getText(); 
	System.out.println("File Upload Status:" + alertMsg);
}
public boolean confirmUpload() {
	try {
		if(driver.findElement(uploadSuccessmsg).isDisplayed()) 
		{
			System.out.println("File Uploaded Successfully");
			
		}
		else 
		{
			System.out.println("File not uploaded");
			
		}
	}
	catch(Exception e) {
		return false;		
	}
	return false;	
}
//Unmatched Payment page
public void assertunmatchedpayment() {
	String pagetitle = driver.findElement(headerUnmatchedPayment).getText();
	System.out.println("Unmatched Payment Page is Displayed" + pagetitle);
}
//Unmatched payment Process
public void clickProcess () {
	driver.findElement(btnProcess_row1).click();
}
public void clickRemoveSubmit() {
	driver.findElement(btnRemoveSubmit).click();
}

}


