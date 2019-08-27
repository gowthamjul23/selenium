package com.trigent.pages;
import com.trigent.base.BaseTest;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralLedgerCommissionPage extends BaseTest{
WebDriver driver;
	
	//@FindBy (xpath = "//ul//li//a[text()='General Ledger Commission']")
@FindBy (css ="#wrapper > nav > div.collapse.navbar-collapse.navbar-ex1-collapse > ul.nav.navbar-nav.side-nav > li.dropdown.open > ul > li:nth-child(12) > a")
	WebElement generalLC;
	
	@FindBy (xpath = "//button[@id='payProducerButton']")
	WebElement payproducer;
	
	@FindBy (xpath="//*[@id='checkPrintTable']//tbody")
	WebElement PrintingConfirmation; 
	
	@FindBy(xpath ="//input[@id='fromDate']")
	WebElement GeneralLCFromDate;
	
	@FindBy(xpath ="//input[@id='toDate']")
	WebElement GeneralLCToDate;
	
	@FindBy(xpath ="//button[@id='addDebitsButton']")
	WebElement AddDebits;

	@FindBy(xpath ="//input[@id='payDate']")
	WebElement AddDebitsDateField;
	
	@FindBy(xpath ="//input[@class='form-control control_sm alpha-numeric-space']")
	WebElement AddDebitsDescrip;
	
	@FindBy(xpath ="//input[@id='payDebitAmount']")
	WebElement AddDebitAmt;
	
	
	@FindBy(xpath ="//button[@id='addDebit']")
	WebElement AddDebitSubmit;
	
	
	@FindBy(xpath ="//button[@id='payProducerButton']")
	WebElement PayProducer;
	
	@FindBy(xpath ="//input[@id='payDesc']")
	WebElement PayProdDescription;
	
	@FindBy (id="printCheckBtn")
	WebElement PrintButton;
	
	@FindBy(xpath ="//input[@id='paymentMethod' and @value='chq']")
	WebElement PayProdPaymentChq;
	
	@FindBy(xpath ="//input[@id='checkNumber']")
	WebElement PayProdChqno;
	
	
	@FindBy(xpath ="//input[@id='checkDeposit']")
	WebElement PayProdDate;
	
	@FindBy(xpath ="//div[@id='ui-datepicker-div']//tr[4]//td[3]//a")
	WebElement PayProdDate1;
	
	@FindBy(xpath ="//select[@id='ProducerId']")
	WebElement PayProdSelect;
	
	@FindBy(xpath ="//select[@id='ProducerId']//option[@value='17']")
	WebElement PayProdSelect1;
	
	
	@FindBy(xpath ="//tr[1]//td[1]//input[@id='commission_info[]']")
	WebElement PayProdCheckbox;
	
	@FindBy(xpath ="//button[@id='payProducer']")
	WebElement PayProdSubmit;
	
  @FindBy(xpath ="//input[@id='paymentMethod' and @value='ach']")
  WebElement PayProdPaymentACH;
  
  @FindBy(xpath ="//select[@id='ACH']//option[3]")
  WebElement PayProdPaymentACHDetails;
    
  @FindBy(xpath ="//table[@id='payProducerTable']/tbody/tr[1]/td[1]")
  WebElement SelectProdCheckbox;  
	
	@FindBy (xpath = "//div[@class='modal-body']//span[@class='h4size']")
	WebElement paymentProducerpage;
	
	@FindBy (xpath = "//input[@id='payDesc']")
	WebElement description;	
	
	@FindBy (xpath = "//button[@id='addDebitsButton']")
	WebElement addDebits;
	
	@FindBy (xpath="//span[@class='h4size' and contains(text(), 'Add Debits')]")
	WebElement ptAddDebits;
	
	@FindBy (xpath= "//input[@class='form-control control_sm alpha-numeric-space']")
	WebElement addDebitDesc;
	
	@FindBy (xpath = "//input[@id='payDate']")
	WebElement addDebitsDate;
	
	@FindBy (xpath = "//input[@id='payDebitAmount']")
	WebElement amountField;	
	
	@FindBy (xpath="//table[@id='payProducerTable']//tr[1]//td[8]")
	WebElement paidPremium;
	
	@FindBy (xpath="//table[@id='payProducerTable']//tr[1]//td[9]")
	WebElement commissionPercentage;
	
	@FindBy (xpath="//table[@id='payProducerTable']//tr[1]//td[10]")
	WebElement commissionAmount;
	
	@FindBy (xpath = "//input[@id='paymentMethod' and @value='chq']")
	WebElement paymentchq;
	
	@FindBy (xpath = "//input[@id='checkNumber']")
	WebElement chqno;
	
	@FindBy (xpath = "//*[@id='checkDeposit']")
	WebElement Dropdown_Bank;
	
	@FindBy (xpath = "//*[@id='BankId']/option[2]")
	WebElement HDFCBank;
	
	
	
	@FindBy (xpath = "//input[@id='checkDeposit']")
	WebElement date;
	
	@FindBy (xpath = "//div[@id='ui-datepicker-div']//tr[3]//td[6]")
	WebElement selectDate;
	
	@FindBy (xpath = "//select[@id='ProducerId']")
	WebElement select;
	
	@FindBy (xpath = "//select[@id='ProducerId']//option[@value='1']")
	WebElement selectvalue;
	
	@FindBy (xpath="//input[@id='checkAllProducer']")
	WebElement checkbox;
	
	@FindBy (xpath="//button[@id='addDebit']")
	WebElement DebitSubmit;
	
	@FindBy (xpath="//input[@id='fromDate']")
	WebElement PeriodFrom;
	
	@FindBy (xpath="//input[@id='toDate']")
	WebElement PeriodTo;
	
	@FindBy (xpath="//input[@id='payAmount']")
	WebElement Amount;
	
	@FindBy (xpath="//input[@id='pay_date']")
	WebElement checkDate;	
	
	
	public void clickGeneralLC() throws InterruptedException, AWTException {
		
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		
		Thread.sleep(3000);
		generalLC.click();	 	
		
	 }
	public void click_ValidateGeneralLC () throws InterruptedException, AWTException {		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);		
		Thread.sleep(3000);		
		generalLC.click();
		 String text  = generalLC.getText();
		 System.out.println("General LC page is displaying: " +text);	
	}
	 
	 public void clickPayProducer() {
		 payproducer.click();
	 }
	 public void Click_Validatepayproducer() {
		 payproducer.click();
		 String text = payproducer.getText();
		 System.out.println("Pay Producer is clicked: "+text);
	}
	 public void payProducerpage() {
		 String paypage = paymentProducerpage.getText();
		 System.out.println("Pay Producer Page is Displayed" +paypage);
	 }
	 
	 public void verifyGeneralLCpage () {
			generalLC.click();
			 String text  = generalLC.getText();
			 System.out.println("General LC page is displaying: " +text);	
		}
		
		public void clickAddDebits () {
			addDebits.click();
		}
		
		public void ClickAddDebitsButton() {
			    AddDebits.click();			    
		   }	   		
		public void verifyAddDebitDesc (String Description) {
			addDebitDesc.sendKeys(Description);				
		}		
		public void enterText_AddDebitDesc () {
			addDebitDesc.sendKeys("New Description for the Debit.");
		}		
		public void verifyAddDebitDate () {
			addDebitsDate.click();
			String CurrentDate = addDebitsDate.getAttribute("value");
			System.out.println("Date is Default current date : " +CurrentDate);	
		}
		public void verifyAmountField (String Amount) {
			amountField.sendKeys(Amount);
		}		
		public void verifyFromandTodates() {
			String fromDate = PeriodFrom.getAttribute("value");
			System.out.println("From Date is : " +fromDate);
			
			String toDate = PeriodTo.getAttribute("value");
			System.out.println("To Date is : " +toDate);
		} 
		public void clickDebitSubmit () {
			DebitSubmit.click();
			System.out.println("Submitted Successfully");
		}
		public void checkCommissionPercentage() throws InterruptedException {
			
			DecimalFormat df2 = new DecimalFormat(".##");
			String paidpremium = paidPremium.getText();
			Thread.sleep(3000);
			String compercentage = commissionPercentage.getText();			
			Thread.sleep(3000);
			String comAmount = commissionAmount.getText();		
			Thread.sleep(3000);
			
			paidpremium = paidpremium.substring(2,paidpremium.length()).trim();
			double pdpremium = Double.parseDouble(paidpremium);
			Thread.sleep(3000);	
			
			compercentage = compercentage.replaceAll("%", "").trim();
			double commissionpercentage = Double.parseDouble(compercentage);
			Thread.sleep(3000);	
			  
			double calculatedAmount = (pdpremium * commissionpercentage)/100; 	
			calculatedAmount = Double.valueOf(df2.format(calculatedAmount));
			Thread.sleep(3000);	
			System.out.println("Calculated Amount:" + calculatedAmount);
			
			comAmount = comAmount.substring(2,comAmount.length()).trim();
			double commissionAmount = Double.parseDouble(comAmount);
			Thread.sleep(3000);	
			System.out.println("Commission Amount:" + commissionAmount);
			
			System.out.println("Calculated Amount == Commission Amount => " + (commissionAmount == calculatedAmount));				
		}		
		public void validateDescrip(String pay_Description) throws InterruptedException {
			 description.sendKeys(pay_Description);
			 Thread.sleep(3000);	
			 String text = description.getAttribute("value");
			 System.out.println("Description value is: "+text);
		}
		public void assertAddDebitPage() {
			String PgtitleAddDebit = ptAddDebits.getText();
			 System.out.println("Description value is: "+PgtitleAddDebit);
		}	 
	 public void descrip() {
		 description.sendKeys("Test A");
	 }
	 public void chq() {
		 paymentchq.click();
	 }
	 public void chqno(String CheckNum) {
		 chqno.sendKeys(CheckNum);
	 }	 
	 
	 public void date() {
		 date.click();
	 }
	 public void selectDate () {
		 selectDate.click();
	 }
	 public void checkDateToday () {
    	 checkDate.getText();
    	 String text = payproducer.getText();
    	 System.out.println("Default Current Date: "+text);
    	 
     }
	 
	 public void SelectBank() {
			Dropdown_Bank.click();
			HDFCBank.click();
			
		}
	 
	 public void select() {
		 select.click();
	 }
	 public void selectvalue() {
		 selectvalue.click();
	 }
	public void checkbox() {
		PayProdCheckbox.click();
	}
	public void amount() {
		 Amount.click();
		 String text = Amount.getAttribute("value");
		 System.out.println("Amount value is: "+text);
	}
public void amountMaxChar() {	
	String S1 = amountField.getAttribute("value");
    int length = S1.length();
    System.out.println("Length of the Amount is: " + length);

      String textareaCharacterLimit = amountField.getAttribute("maximumlength");
		 //return textareaCharacterLimit;
		 System.out.println("The max length of Amount value is: "+textareaCharacterLimit);
}
public void clickPayProdSubmit() throws InterruptedException {
	PayProdSubmit.click();	
	Thread.sleep(5000);
	System.out.println("Payment Submitted Succesfully");
}

public void clickprintbutton() {
	PrintButton.click();
} 
public void clickPayProdACH() {
	PayProdPaymentACH.click(); 
}
public void clickPayProdACHDetails() {
	PayProdPaymentACHDetails.click();
}

 
public void PayProducer_Validate_Check () {
	 //Validate the PayProducer DATE, DESCRIP, AMOUNT, CHEQ field 
	 
	 
	 PayProdChqno.click();
	  
	 PayProdDate.click();
	 String text2 = PayProdDate.getText();
	 System.out.println("Default Current Date: "+text2);
	 
	 PayProdDate1.click();
	 String text3 =  PayProdDate.getText();
	 System.out.println("Default Current Date: "+text3);
	 
	 PayProdSelect.click();
	 PayProdSelect1.click();
	 PayProdCheckbox.click();
	 
	 amountField.click();
	 String text4 = amountField.getAttribute("value");
	 System.out.println("Amount value is: "+text4);
	 	 
}

public void Check_Print_Confirmation() throws InterruptedException{
int rowCount = 0;
	List < WebElement > PrintingConfirmationRows = PrintingConfirmation.findElements(By.tagName("tr")); 
	//To calculate no of rows In table.
	 rowCount = PrintingConfirmationRows.size();
	System.out.println("Check Printing for: " + rowCount);		
	int RowIndex=1;
	for (WebElement PrintTable:PrintingConfirmationRows) {
		List<WebElement> Columns = PrintTable.findElements(By.xpath("td"));			

		//int columnIndex = 1;
		System.out.println("Below are the values of Producer ; Check Date ; Check No ; Check Amount");
		
		for (WebElement ColElement: Columns) {
			
			String TableValue = ColElement.getText();		
			
			System.out.println(TableValue);				
		}
		 RowIndex=RowIndex+1;
		System.out.println("....................................................");
		
		}
	} 
	}		
	
 /*int rowSize = 0;//
		List < WebElement > EmployeeTable_row = EmployeeTable.findElements(By.tagName("tr"));//
		//To calculate no of rows In table.
		rowSize = EmployeeTable_row.size();//
		System.out.println("No of Employees: " + rowSize);//
		
		int RowIndex=1;//
		for(WebElement EmployeeTable:EmployeeTable_row)//
		{
		      List<WebElement> FirstColumn=EmployeeTable.findElements(By.xpath("td[2]"));///
		      //int ColumnIndex=1; //
		      for(WebElement colElement:FirstColumn)//
		      {
		    	  String EmpName = colElement.getText();
		           System.out.println("Row "+RowIndex+" : Employee Name : "+EmpName);
		           //ColumnIndex=ColumnIndex+1;
		       }
		      RowIndex=RowIndex+1;*/



 