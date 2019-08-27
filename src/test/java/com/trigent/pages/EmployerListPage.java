package com.trigent.pages;
import com.trigent.base.BaseTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class EmployerListPage extends BaseTest{@FindBy (xpath ="//td[text()='Advanced Assembly LLC']")
WebElement AdvAssembly;

@FindBy (xpath ="//a[@href='#page8']")
WebElement InvoicesandPaymentsTab;

@FindBy (xpath ="//*[@id='invoiceTable']//tbody")
WebElement EmpInvoiceandPayments;	


@FindBy (xpath = "//*[@id='employerTable']//tbody")  
WebElement EmployerclassTable;

@FindBy (id="editEmployerInfo")
WebElement Edit_Employer;

@FindBy (xpath = "//input[(@name='Status')]")
	WebElement Employer_checkbox;

@FindBy (xpath="//*[@id='saveEmployerInfo' and @title='Save Employer Information']")
WebElement Employer_Edit_save;

@FindBy (id = "employerName")
WebElement EmployerName;

@FindBy (xpath = "//*[@id='employerInfoSection']/text()[13]")
WebElement StatusofEmployer;

@FindBy (id = "bulkPayButton")
WebElement PayTotalOutstandingBalance;

@FindBy(id= "infoMsgGeneral")
WebElement ConfirmationMessage;

@FindBy(id="infoMsg")
WebElement ErrorMessage;

@FindBy(id="yesConfirmtotbal")
WebElement ConfirmYesButton ;

@FindBy (id="infoCloseBtn")
WebElement CloseButton;






public void ClickFirstEmployer() {
	FirstEmployer.click();		
}


public void ClickEmpTab() throws InterruptedException {
	EmployeeTab.click();
	Thread.sleep(5000);
}
public void clickFirstEmployee() throws InterruptedException {
	FirstEmployee.click();
	Thread.sleep(5000); 
}
public void clickInvoiceandPayment() throws InterruptedException{
	InvoicesandPaymentsTab. click();
	Thread.sleep(5000);
}

public void VerifyInvoice() throws InterruptedException{
	List < WebElement > EmpInvoiceandPaymentsRows = EmpInvoiceandPayments.findElements(By.tagName("tr"));
	//To calculate no of rows In table.
	int rowCount = EmpInvoiceandPaymentsRows.size();
	System.out.println("Invoice and payments: " + rowCount);		
	for (int row=0; row<rowCount; row++) {
		List<WebElement> Columns_One = EmpInvoiceandPaymentsRows.get(row).findElements(By.xpath("td[2]"));	
		List<WebElement> Columns_Two = EmpInvoiceandPaymentsRows.get(row).findElements(By.xpath("td[3]"));
		List<WebElement> Columns_Three = EmpInvoiceandPaymentsRows.get(row).findElements(By.xpath("td[7]"));
		List<WebElement> Columns_Four = EmpInvoiceandPaymentsRows.get(row).findElements(By.xpath("td[11]"));
	//List<WebElement> Columns_Four = EmpInvoiceandPaymentsRows.get(row).findElements(By.xpath("td[5]"));

		int columnCount = Columns_One.size();
		//System.out.println("Number of Columns in Row" + row + "and Column Count" +columnCount);
		
		for (int column=0; column<columnCount; column++) {
			String InvoiceNumber = Columns_One.get(column).getText();
			String UWCompany = Columns_Two.get(column).getText();
			String InvoiceAmount = Columns_Three.get(column).getText();
			String Status = Columns_Four.get(column).getText();
			//String monPremium = Columns_Four.get(column).getText();
			System.out.println("Invoice Number is :" + InvoiceNumber);
			System.out.println("UWCompany is  :" + UWCompany);
			System.out.println("Invoice Amount is:" + InvoiceAmount);
			System.out.println("Paid Status is :" + Status);
			//System.out.println("Monthly Premium :" + monPremium);
			
		}
		
		System.out.println("....................................................");
	}		
}	

public void VerifyInvoiceOutstandingBalance() throws InterruptedException{
	List < WebElement > EmpInvoiceandPaymentsRows = EmpInvoiceandPayments.findElements(By.tagName("tr"));
	//To calculate no of rows In table.
	int rowCount = EmpInvoiceandPaymentsRows.size();
	System.out.println("Invoice and payments: " + rowCount);		
	for (int row=0; row<rowCount; row++) {
		List<WebElement> Columns_Two = EmpInvoiceandPaymentsRows.get(row).findElements(By.xpath("td[2]"));				
		List<WebElement> Columns_Ten = EmpInvoiceandPaymentsRows.get(row).findElements(By.xpath("td[10]"));
	//List<WebElement> Columns_Four = EmpInvoiceandPaymentsRows.get(row).findElements(By.xpath("td[5]"));

		int columnCount = Columns_Two.size();
		//System.out.println("Number of Columns in Row" + row + "and Column Count" +columnCount);
		
		for (int column=0; column<columnCount; column++) {
			String InvoiceNumber = Columns_Two.get(column).getText();				
			String osBalance = Columns_Ten.get(column).getText();
			//String monPremium = Columns_Four.get(column).getText();
			System.out.println("Invoice Number is :" + InvoiceNumber);
			System.out.println("Outstanding Balance is :" + osBalance);
			//System.out.println("Monthly Premium :" + monPremium);
			
		}
		
		System.out.println("....................................................");
	}		
}	

public void VerifyEmployerStatus_U()throws InterruptedException {					
	
	String Status = null;
	
	List < WebElement > EmployerclassRow = EmployerclassTable.findElements(By.tagName("tr"));		
	for(WebElement EmployerclassTable:EmployerclassRow)
	{
	List<WebElement> FifthColumn=EmployerclassTable.findElements(By.xpath("td[5]"));
	      //int ColumnIndex=1;
	      for(WebElement colElement:FifthColumn)
	      {
	    	Status = colElement.getText(); 
	    	  System.out.println("Status of the Employer" + Status);		    	  
	    	  if(Status.equals("U"))
	    	  {		        	 
	    		  colElement.click();
	    		  Thread.sleep(5000);
	        	  break;
	        	 
	    	  }
	    	  
	       }
	      if(Status.equals("U"))
	      {
	    	  break;
	      }
	 }
	
}
public void VerifyEmployerStatus_A()throws InterruptedException {					
	
	String Status = null;
	
	List < WebElement > EmployerclassRow = EmployerclassTable.findElements(By.tagName("tr"));		
	for(WebElement EmployerclassTable:EmployerclassRow)
	{
	List<WebElement> FifthColumn=EmployerclassTable.findElements(By.xpath("td[5]"));
	      //int ColumnIndex=1;
	      for(WebElement colElement:FifthColumn)
	      {
	    	Status = colElement.getText(); 
	    	  System.out.println("Status of the Employer" + Status);		    	  
	    	  if(Status.equals("A"))
	    	  {		        	 
	    		  colElement.click();
	    		  Thread.sleep(5000);
	        	  break;
	        	 
	    	  }
	    	  
	       }
	      if(Status.equals("A"))
	      {
	    	  break;
	      }
	 }
	
}

public void ClickEditEmployer() throws InterruptedException {		
	Edit_Employer.click();		
	Thread.sleep (3000);
}
		

public void click_Employer_checkbox ()throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", Employer_checkbox);
	 Employer_checkbox.click();
	Thread.sleep (3000);		
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	 jse.executeScript("arguments[0].scrollIntoView();", EmployerName);
	 Thread.sleep (3000);
	Employer_Edit_save.click();
	Thread.sleep (5000);		
	String ActivatedEmployerName = EmployerName.getText();		
	System.out.println("Activated Employer Name " + ActivatedEmployerName);
		}

	



public void ClickPayTotalOutstandingBalance() throws InterruptedException {
	PayTotalOutstandingBalance.click();
	Thread.sleep(5000);
	
	if(ConfirmYesButton.isDisplayed()) {
		String ConfirmationWindow = ConfirmationMessage.getText();
		System.out.print("The message displaying is :"+ ConfirmationWindow);
	ConfirmYesButton .click();
	}
	
	else {
		String ErrorMsgeWindow = ErrorMessage.getText();
		System.out.print("The message displaying is :"+ ErrorMsgeWindow);
		CloseButton.click();
	}
	
}

//......................................................



@FindBy(xpath = "//*[@id='employerTable']//tr[1]//td[3]")
WebElement FirstEmployer;

@FindBy(xpath = "//td[contains(text(),'Advanced Assembly LLC')]")
WebElement FourthEmployer;

@FindBy(xpath = "//table[@id='formsTable']/tbody/tr[1]/td[1]")
WebElement ProducerAgencyName;

@FindBy (xpath = "//*[@id='modalDialog']/div/div/div[1]/div/div[1]/span[1]")
WebElement GridName;

@FindBy (id = "employeeTab")
WebElement EmployeeTab;

@FindBy (xpath = "//*[@id='employeeTable']//tbody")
WebElement EmployeeTable;

@FindBy (xpath = "//*[@id='employeeTable']//tr[1]//td[1]")
WebElement FirstEmployee;

@FindBy(xpath="//table[@id='employerTable']/tbody")
WebElement EmployerListTable;	

@FindBy(xpath="//div[contains(@class,'bs-example')]/ul/li[5]/a")
WebElement planInformationtab;

@FindBy (id = "addPlanBtn")
WebElement addPlan;

@FindBy (id = "Carrier")                 
WebElement Carrier;

@FindBy(xpath="//select[@id='Carrier']/option[2]")
WebElement Carrier_selection;

@FindBy (id = "UW_Company")
WebElement underWritingCompany;

@FindBy (xpath = "//*[@id='PlanType']")
WebElement planType;

@FindBy (xpath = "//*[@id='Class']")
WebElement classes;

@FindBy (xpath = "//*[@id='BizGrp_Prod_ID']")
WebElement Product;

@FindBy (xpath = "//*[@id='Carrier_GroupNumber']")
WebElement policyNumber;

@FindBy (xpath = "//*[@id='Carrier_EffectiveDate']")
WebElement planEffectiveDate;

@FindBy (xpath = "//*[@id='Renewal_Date']")
WebElement planRenewalDate;

@FindBy (xpath = "//*[@id='savePlanBtn']")
WebElement SavePlanBtn;

@FindBy (xpath = "//*[@id='eepTable']//tbody")
WebElement PlanTable;

//click the first Employer Name in the grid of the Employer list


public void clickActiveEmployer() {
	FourthEmployer.click();
}

//Click Employee Tab
public void clickEmployeeTab() { 
	EmployeeTab.click();
}

public void clickPlanInformationTab() {
	planInformationtab.click();
}	


public void clickAddPlan() throws InterruptedException {
	addPlan.click();
	Thread.sleep(3000);
}


//To verify the Name of the Producer Agency from the table and the page we open
public void click_Verify_ProducerAgencyName() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", ProducerAgencyName);
	Thread.sleep(3000);
	ProducerAgencyName.click();		
String ProducerAgencyInTable =	ProducerAgencyName.getText();	
System.out.print("Producer Agency Name in the Table: " + ProducerAgencyInTable);
Thread.sleep(5000);
String ProducerAgencyInGrid = GridName.getText();
System.out.print("Producer Agency Name in the Grid: " + ProducerAgencyInGrid);
Assert.assertEquals(ProducerAgencyInTable, ProducerAgencyInGrid);
	
}

//To get the number of records in the table and get the name of the Employees
public void verify_Employees() {	
	int rowSize = 0;
	List < WebElement > EmployeeTable_row = EmployeeTable.findElements(By.tagName("tr"));
	//To calculate no of rows In table.
	rowSize = EmployeeTable_row.size();
	System.out.println("No of Employees: " + rowSize);
	 
	int RowIndex=1;
	for(WebElement EmployeeTable:EmployeeTable_row)
	{
	      List<WebElement> FirstColumn=EmployeeTable.findElements(By.xpath("td[2]"));
	      //int ColumnIndex=1; 
	      for(WebElement colElement:FirstColumn)
	      {
	    	  String EmpName = colElement.getText();
	           System.out.println("Row "+RowIndex+" : Employee Name : "+EmpName);
	           //ColumnIndex=ColumnIndex+1;
	       }
	      RowIndex=RowIndex+1;
	 }
}	

//To verify the Status of the Employer and click the Employer with the Status "A"
public void verifyEmployerStatus() throws InterruptedException {			
	String Status = null;
	List < WebElement > EmployerTable = EmployerListTable.findElements(By.tagName("tr"));		
	for(WebElement EmployerListTable:EmployerTable)
	{
	List<WebElement> FifthColumn=EmployerListTable.findElements(By.xpath("td[5]"));
	      //int ColumnIndex=1;
	      for(WebElement colElement:FifthColumn)
	      {
	    	Status = colElement.getText(); 
	    	  System.out.println("Status of the Employer" + Status);		    	  
	    	  if(Status.equals("A"))
	    	  {		        	 
	        	  colElement.click();
	        	  break;
	    	  }
	    	  
	       }
	      if(Status.equals("A")) 
	      {
	    	  break;
	      }
	 }
	
}

public void checkEmployerStatus() throws InterruptedException {			
	String Status = null;
	List < WebElement > EmployerTable = EmployerListTable.findElements(By.tagName("tr"));		
	for(WebElement EmployerListTable:EmployerTable)
	{
	List<WebElement> FifthColumn=EmployerListTable.findElements(By.xpath("td[5]"));
	      //int ColumnIndex=1;
	      for(WebElement colElement:FifthColumn)
	      {
	    	Status = colElement.getText(); 		    	  		    	  
	    	  if(Status.equals("A"))
	    	  {		        	 
	        	  colElement.click();
	        	  break;
	    	  }
	    	  
	       }
	      if(Status.equals("A"))
	      {
	    	  break;
	      }
	 }
	
}

public void EnterDetailsinAddPlan() throws InterruptedException {
	Carrier.click();
	Carrier_selection.click(); 
	
	
	//Select drpcarrier = new Select (Carrier);
	//drpcarrier.selectByVisibleText("Cigna");
	
	Select drpUWcompany = new Select (underWritingCompany);
	drpUWcompany.selectByIndex(1);
    Thread.sleep(3000);
    
    Select drpClasses = new Select (classes);
    drpClasses.selectByIndex(1);
    Thread.sleep(5000);
    
    Select drpPlan = new Select (planType);
    drpPlan.selectByIndex(1);
    Thread.sleep(5000);
    
    Select drpProduct = new Select (Product);
    drpProduct.selectByIndex(1);
    Thread.sleep(5000);
    
    policyNumber.click();
    policyNumber.sendKeys("SKY0001234");
    Thread.sleep(5000);
    
    planEffectiveDate.click();
    planEffectiveDate.sendKeys("06/06/2018");
    Thread.sleep(5000);
    
    planRenewalDate.click();
    planRenewalDate.sendKeys("06/06/2018");
    Thread.sleep(5000);
	
}

public void ClickSavePlan() {
	SavePlanBtn.click();
}

public void AssertLastRowofPlanTable() {
	
	List < WebElement > PlanTableLastRow =  PlanTable.findElements(By.cssSelector("table#eepTable tr:last-child"));
	//To get the value of the Column.
	int rowCount = PlanTableLastRow.size();
		
	for (int row=0; row<rowCount; row++) {
		List<WebElement> Columns_One = PlanTableLastRow.get(row).findElements(By.xpath("td[1]"));	
		List<WebElement> Columns_Two = PlanTableLastRow.get(row).findElements(By.xpath("td[2]"));
		List<WebElement> Columns_Three = PlanTableLastRow.get(row).findElements(By.xpath("td[4]"));	
		List<WebElement> Columns_Four = PlanTableLastRow.get(row).findElements(By.xpath("td[5]"));

		int columnCount = Columns_One.size();
		//System.out.println("Number of Columns in Row" + row + "and Column Count" +columnCount);
		
		for (int column=0; column<columnCount; column++) {
		
		
			String product = Columns_One.get(column).getText();
			String classes = Columns_Two.get(column).getText();
			String UWcompany = Columns_Three.get(column).getText();
			String policynumber = Columns_Four.get(column).getText();
			
			
			System.out.println("Product :" + product);
			System.out.println("Classes :" + classes);
			System.out.println("UWcompany :" + UWcompany);
			System.out.println("Policy Number :" + policynumber);
			
		}
		System.out.println(".........................");
	}
	
}


public void ClickAdvAssembly() throws InterruptedException {
	AdvAssembly.click();
	Thread.sleep(5000);
	
}
} 
