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
import com.trigent.test.VerifyACHPayment;
public class OnlinePaymentPage extends VerifyACHPayment{
	public WebDriver driver;
	
	 
@FindBy(xpath="//ul[@id='myTab']/li[6]/a") 
WebElement Invoicetab;


@FindBy(xpath="//table[@id='invoiceTable']//tbody")
WebElement Invoicetable;


@FindBy(xpath="//select[@id='ACH']")
WebElement SelectACH;

@FindBy(xpath="//select[@id='ACH']/option[2]")
WebElement SelectBank;


@FindBy(xpath="//button[@id='achPay']")
WebElement ClickSubmit;

@FindBy(xpath="//span[@id='totalPremium']")
WebElement TotalPremium;

@FindBy(xpath="//button[@id='removeAndSubmit']")
WebElement ClickUpdPay;

@FindBy(xpath="//div[@id='infoMsg']/h2")
WebElement Invoicemsg;

@FindBy(xpath="//div[@id='infoMsg']/h2/span[2]")
WebElement CheckAmount;

@FindBy(xpath="//button[@id='infoCloseBtn']")
WebElement ClickClose;


 public OnlinePaymentPage(WebDriver dr) {
				// TODO Auto-generated constructor stub
				driver=dr;
			}

	
	
 public void clickInvoiceTab() throws InterruptedException
 {
	 Thread.sleep(3000);
	 Invoicetab.click();
 }
	
	 public void verifyunpaidStatus() throws InterruptedException {		
		 
		 String Status = null;
		 int rowSize = 0;
			List < WebElement > InvoiceTable_Row = Invoicetable.findElements(By.tagName("tr"));		
			rowSize = InvoiceTable_Row.size();
		   	System.out.println("No of Employers: " + rowSize);
			for(WebElement InvoiceTableRow:InvoiceTable_Row)
			{
			List<WebElement> EleventhColumn=InvoiceTableRow.findElements(By.xpath("td[11]"));
			      //int ColumnIndex=1;
			      for(WebElement colElement:EleventhColumn)
			      {
			    	Status = colElement.getText(); 
			    	//  System.out.println("Status of the Invoice : " + Status);		    	  
			    	  if(Status.equals("Unpaid"))
			    	  {		        	 
			    		
			    		  WebElement Paybutton =  (WebElement) InvoiceTableRow.findElement(By.xpath("td[13]/div/button[2]"));
			    		  WebElement Selectdrpdwn = (WebElement) InvoiceTableRow.findElement(By.xpath("td[13]/div/ul/li"));
			    		  Paybutton.click();
			    		  Thread.sleep(3000);
			    		  Selectdrpdwn.click(); 
			    		  Thread.sleep(5000);
			    		  
			    		  SelectACH.click(); // ACH Payment popup
			    		  Thread.sleep(3000);
			    		  SelectBank.click();
			    		  Thread.sleep(3000); 
			    		 ClickSubmit.click();  
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
	 ClickUpdPay.click();
	 Thread.sleep(3000);
	 Invoicemsg.click();
	 
	
	 System.out.println("Amount Paid: " + CheckAmount.getText());

	 System.out.println("Invoice Message: " + Invoicemsg.getText());
	 
//	Assert.assertEquals(CheckAmount.getText(), TotalPremium.getText());
	 
 }

}
