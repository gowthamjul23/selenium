package com.trigent.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import com.trigent.base.BaseTest;

public class PaymentTypes extends BaseTest{
	public WebDriver driver;
	
	@FindBy(xpath ="//ul[@id='myTab']/li[6]/a")
	WebElement InvoiceTab;  
	
	@FindBy(xpath="//table[@id='invoiceTable']//tbody")
	WebElement Invoicetable;    
	
	@FindBy(xpath ="//select[@id='credit_code']")
	WebElement CreditFielddrpdwn; 
	
	@FindBy(xpath ="//select[@id='ACH']")
	WebElement ACHFielddrpdwn; 
	
	
	
	@FindBy(xpath ="//select[@id='credit_code']/option[2]")
	WebElement SelectImpCredit;  
	
	@FindBy(xpath="//select[@id='ACH']/option[2]")
	WebElement SelectBank; 
	
	
	@FindBy(xpath ="//button[@id='creditPay']")
	WebElement Submit;  
	
	@FindBy(xpath="//button[@id='achPay']")
	WebElement ACHSubmit;
	
	@FindBy(xpath ="//span[@id='totalPremium']")
	WebElement TotalPremium;  

	@FindBy(xpath ="//button[@id='removeAndSubmit']")
	WebElement UpPay;  
	
	
	@FindBy(xpath ="//div[@id='infoMsg']/h2/span[2]")
	WebElement TotalAmount;
	
	@FindBy(xpath ="//div[@id='infoMsg']")  
	WebElement InvoiceMsg;
	
	
	@FindBy(xpath ="//button[@id='infoCloseBtn']")
	WebElement CloseButton;
	
	@FindBy(xpath = "//*[@id='modalConfirm']//bold")
	WebElement ConfirmMessageOnlinePayment;
	
	@FindBy (xpath = "//*[@id='noConfirm']")
	WebElement NoPayNow;	
	
	
	@FindBy (xpath = "//*[@id='infoCloseBtn']")
	WebElement InvoiceCloseButton;
	
	
	
//*****************************************************************************************************************************************************************************************
//Smoke Test Cases methods
		
 public PaymentTypes(WebDriver dr) {
       // TODO Auto-generated constructor stub
	driver=dr;
		}
	
 public void ClickInvoiceTab() throws InterruptedException
 {
	 Thread.sleep(2000);
	 InvoiceTab.click();
 }
	
	 public void VerifyUnpaidStatustopayCredit() throws InterruptedException {		
		 
		 String Status = null; 
		 int rowSize = 0;
			List < WebElement > InvoiceTable_Row = Invoicetable.findElements(By.tagName("tr"));		
			rowSize = InvoiceTable_Row.size();
		  	System.out.println("No of Rows: " + rowSize);
		  	Thread.sleep(2000);
			for(WebElement InvoiceTableRow:InvoiceTable_Row)
			{
				
			List<WebElement> EleventhColumn=InvoiceTableRow.findElements(By.xpath("td[11]"));	
		
			 
			      //int ColumnIndex=1;
			      for(WebElement colEle:EleventhColumn) 
			      {			    	  
			    	Status = colEle.getText(); 
			    	Thread.sleep(2000);
			    	 System.out.println("Status of the Invoice : " + Status);		    	  
			    	  if(Status.equals("Unpaid"))
			    	  {		         	 
			    		  //System.out.println("Status of the Invoice : " + Status);	
			    		  WebElement Paybutton =  (WebElement) InvoiceTableRow.findElement(By.xpath("td[13]/div/button[2]/span[1]"));
			    		  Thread.sleep(2000);
			    		  WebElement Selectdrpdwn = (WebElement) InvoiceTableRow.findElement(By.xpath("td[13]/div/ul//li[text()='Credit']"));
			    		  Thread.sleep(2000);
			    		  
			    		  JavascriptExecutor js = (JavascriptExecutor) driver;
			    		  js.executeScript("arguments[0].scrollIntoView();", Paybutton);
			    		  Paybutton.click(); 
			    		  Thread.sleep(3000);
			    		  Selectdrpdwn.click();
			    		  Thread.sleep(5000); 
			    		  
			    		  CreditFielddrpdwn.click(); // Credit Payment pop up
			    		  Thread.sleep(3000);
			    		  SelectImpCredit.click();
			    		  Thread.sleep(3000);
			    		  Submit.click();  
			    		 Thread.sleep(3000);
			        	  break;
			    	  }
			    	  
			       }
			      if(Status.equals("Unpaid"))
			      {
			    	  break;
			      }
			 }
			
		}
		 
		 
 public void VerifyUnpaidStatustopayOnline() throws InterruptedException {		
		 
		 String Status = null;
		 int rowSize = 0;
			List < WebElement > InvoiceTable_Row = Invoicetable.findElements(By.tagName("tr"));		
			rowSize = InvoiceTable_Row.size();
		  	System.out.println("No of Rows: " + rowSize);
		  	Thread.sleep(2000);
			for(WebElement InvoiceTableRow:InvoiceTable_Row)
			{
				
			List<WebElement> EleventhColumn=InvoiceTableRow.findElements(By.xpath("td[11]"));	
		
			 
			      //int ColumnIndex=1;
			      for(WebElement colEle:EleventhColumn) 
			      {			    	  
			    	Status = colEle.getText(); 
			    	Thread.sleep(2000);
			    	 System.out.println("Status of the Invoice : " + Status);		    	  
			    	  if(Status.equals("Unpaid"))
			    	  {		         	 
			    		  //System.out.println("Status of the Invoice : " + Status);	
			    		  WebElement Paybutton =  (WebElement) InvoiceTableRow.findElement(By.xpath("td[13]/div/button[2]/span[1]"));
			    		  Thread.sleep(2000);
			    		  WebElement Selectdrpdwn = (WebElement) InvoiceTableRow.findElement(By.xpath("td[13]/div/ul//li[text()='Online']"));
			    		  Thread.sleep(2000);
			    		  
			    		  JavascriptExecutor js = (JavascriptExecutor) driver;
			    		  js.executeScript("arguments[0].scrollIntoView();", Paybutton);
			    		  Paybutton.click(); 
			    		  Thread.sleep(3000);
			    		  Selectdrpdwn.click();
			    		  Thread.sleep(5000);     
			        	  break;
			    	  }
			    	  
			       }
			      if(Status.equals("Unpaid"))
			      {
			    	  break;
			      }
			 }
			
		}
			
 public void VerifyUnpaidStatustopayACH() throws InterruptedException {		
	 
	 String Status = null; 
	 int rowSize = 0;
		List < WebElement > InvoiceTable_Row = Invoicetable.findElements(By.tagName("tr"));		
		rowSize = InvoiceTable_Row.size();
	  	System.out.println("No of Rows: " + rowSize);
	  	Thread.sleep(2000);
		for(WebElement InvoiceTableRow:InvoiceTable_Row)
		{
			
		List<WebElement> EleventhColumn=InvoiceTableRow.findElements(By.xpath("td[11]"));	
	
		 
		      //int ColumnIndex=1;
		      for(WebElement colEle:EleventhColumn) 
		      {			    	  
		    	Status = colEle.getText(); 
		    	Thread.sleep(2000);
		    	 System.out.println("Status of the Invoice : " + Status);		    	  
		    	  if(Status.equals("Unpaid"))
		    	  {		         	 
		    		  //System.out.println("Status of the Invoice : " + Status);	
		    		  WebElement Paybutton =  (WebElement) InvoiceTableRow.findElement(By.xpath("td[13]/div/button[2]/span[1]"));
		    		  Thread.sleep(2000);
		    		  WebElement Selectdrpdwn = (WebElement) InvoiceTableRow.findElement(By.xpath("td[13]/div/ul//li[text()='ACH']"));
		    		  Thread.sleep(2000);
		    		  
		    		  JavascriptExecutor js = (JavascriptExecutor) driver;
		    		  js.executeScript("arguments[0].scrollIntoView();", Paybutton);
		    		  
		    		  Paybutton.click(); 
		    		  Thread.sleep(3000);
		    		  Selectdrpdwn.click();
		    		  Thread.sleep(5000); 
		    		  
		    		  ACHFielddrpdwn.click(); // ACH Payment pop up
		    		  Thread.sleep(3000);
		    		  
		    		  SelectBank.click();
		    		  Thread.sleep(3000);
		    		  
		    		  ACHSubmit.click();  
		    		 Thread.sleep(3000);
		        	  break;
		    	  }
		    	  
		       }
		      if(Status.equals("Unpaid"))
		      {
		    	  break;
		      }
		 }
		
	}
	
 public void CoverageandPay() throws InterruptedException
 {
	 
	 Thread.sleep(1000);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", TotalPremium);
	 String Total =TotalPremium.getText();
	 System.out.println("Total Premium: " +Total);
	 Thread.sleep(1000);
	 UpPay.click();
	 Thread.sleep(1000);
	// InvoiceMsg.click();
	 Thread.sleep(3000);	

	 System.out.println("Invoice Message : " + InvoiceMsg.getText());
	 
	System.out.println("Total Amount Paid : " + TotalAmount.getText());
	CloseButton.click();
	Thread.sleep(3000);
	 
 }
 
 public void VerifyConfirmationMessage() throws InterruptedException {
	 String ConfirmMsg = ConfirmMessageOnlinePayment.getText();
	 System.out.println("Confirmation Message to Remove Employees" + ConfirmMsg);
	 NoPayNow.click();
	 Thread.sleep(3000);
	 String InvoiceMsgOnlinePay = InvoiceMsg.getText();
	 System.out.println("Invoice Message : " +InvoiceMsgOnlinePay);
	 Thread.sleep(5000);
	 InvoiceCloseButton.click();
	 Thread.sleep(3000);
	 
 }

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
