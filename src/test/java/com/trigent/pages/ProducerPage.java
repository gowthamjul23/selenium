package com.trigent.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.trigent.base.BaseTest;

public class ProducerPage extends BaseTest{
	
	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id='producersTable']//tbody")
	WebElement ProducerTable;
	
	@FindBy(xpath = "//td[1]//input[@class='tablesorter-filter']")
	WebElement productAgency;
	
	@FindBy (xpath = "//span[@id='employerName']")
	WebElement employerPage;	
	
	@FindBy (xpath = "//ul[@class='dropdown-menu']//li/a[contains(text(),'Producers')]")
	WebElement producers;
	
	@FindBy (xpath = "//td[2]//input[@class='tablesorter-filter']")
	WebElement productName;
	
	@FindBy (xpath = "//table//tr[1]//td[1]")
	WebElement Row;
	
	@FindBy (xpath = "//a[@class='btn btn-small btn-warning addCF']")
	WebElement addLicense;
	
	@FindBy (xpath = "//tr[1]//input[@class='form-control LicenseNumber']")
	WebElement licenseNumber;
	
	@FindBy (xpath = "//tr[1]//select[@id='LicenseState']")
	WebElement licenseState;
	
	@FindBy (xpath = "//span[@id='cloneSelect1']//select[@id='LicenseState']//option[@value='AL']")
	WebElement dropdownselect;
	
	@FindBy (xpath = "//tr[1]//input[@class='form-control EffectiveDate hasDatepicker']")
	WebElement licenseEffectiveDate;
	
	@FindBy (xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
	WebElement prevMonth;
	
	@FindBy (xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	WebElement nextMonth;
	
	@FindBy (xpath = "//a[@class='ui-state-default' and contains(text(), '15')]")
	WebElement effectiveDate;
	
	@FindBy (xpath = "//tr[1]//input[@name='ExpiryDate']")
	WebElement licenseExpiryDate;
	
	@FindBy (xpath = "//a[@class='ui-state-default' and contains(text(), '21')]")
	WebElement expiryDate;
	
	@FindBy (xpath = "//tr[1]//select[@id='Perpetual']")
	WebElement perpetual;
	
	@FindBy (xpath = "//select[@class='form-control']//option[contains(text(), 'Yes')]")
	WebElement perpetualYes;
	
	@FindBy (xpath = "//select[@class='form-control']//option[contains(text(), 'No')]")
	WebElement perpetualNo;
	
	@FindBy (xpath = "//tr[1]//button[@id='saveProducerLicenseBtn']")
	WebElement saveLicense;
	
	@FindBy (xpath = "//div[@id='errorMsg'][1]")
	WebElement errorMsg;
	
	@FindBy (xpath = "//select[@name='formtype']")
	WebElement dropdownFormType;
	
	@FindBy (id = "skip_docs_validation")
	WebElement checkBox;
	
	@FindBy (xpath ="//select[@name='formtype']//option[(contains(text(), 'W-9'))]")
	WebElement formTypeW9;
	
	@FindBy (xpath ="//select[@name='formtype']//option[(contains(text(), 'E & O'))]")
	WebElement formTypeEO;
	
	@FindBy (xpath ="//input[@id='sortformfiles']")
	WebElement btnChoose;
	
	@FindBy (xpath ="//button[@class='btn btn-success btn-small']")
	WebElement btnUpload;
	
	@FindBy (xpath ="//table[@id='licenseTable']//tbody//tr[last()]")
	WebElement LicenseRow;
    
	@FindBy (xpath = "//table[@id='licenseTable']//tbody//tr[last()]//td[1]")
	WebElement formTypeName;
    
   @FindBy (xpath = "//table[@id='licenseTable']//tbody//tr[last()]//td[2]")
   WebElement formUploadedDate;
   
   @FindBy (xpath = "//table[@id='licenseTable']//tbody//tr[last()]//td[3]")
   WebElement formUploadedBy;
   
   @FindBy (xpath = "//table[@class='casesTable table']//tbody//tr[1]/td[1]")
   WebElement verifylicenseNumber;
   
   @FindBy (xpath = "//table[@class='casesTable table']//tbody//tr[1]/td[2]")
   WebElement verifylicenseState;
   
   @FindBy (xpath = "//table[@class='casesTable table']//tbody//tr[1]/td[3]")
   WebElement verifyEffDate;
    
   @FindBy (xpath = "//table[@class='casesTable table']//tbody//tr[1]/td[4]")
   WebElement verifyExpDate;
    
   @FindBy (xpath = "//table[@class='casesTable table']//tbody//tr[1]/td[5]")
   WebElement verifyPerpetual;
    
   @FindBy (xpath = "//table[@id='licenseTable']//tbody//tr[1]//td[1]")
   WebElement verifyFormType;
    
  
public void clickOnProducers() {
	producers.click();
}
public void searchProductAgency(String ProductAgencyName){
	//public void searchProductAgency(){
	// TODO Auto-generated method stub
	productAgency.sendKeys(ProductAgencyName);
}

public void searchProductName() {
	productName.sendKeys("");
}

public void clickFirstRow() {
	Row.click();
}

public void clickProductAgency() {
	Row.click();
}

public void clickAddLicenseButton() throws InterruptedException, AWTException {
	Thread.sleep(3000);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	Thread.sleep(3000);
	addLicense.click();
}
public void enterLicenseNumber(String LicenseNumber) {
//public void enterLicenseNumber() {
	// TODO Auto-generated method stub
	licenseNumber.sendKeys(LicenseNumber);
}
public void clickLicenseState() {
	licenseState.click();	
}
public void clickDropdownValue() {
	dropdownselect.click();
}
public void clickPreviousMonth() {
	prevMonth.click();
}
public void clickNextMonth() {
	nextMonth.click();
}
public void clickLicenseEffectiveDate() {
	licenseEffectiveDate.click();
}
public void dateEffectiveofLicense() {
	effectiveDate.click();
}
public void clickLicenseExpiryDate() {
	licenseExpiryDate.click();
}
public void dateExpiryofLicense () {
	expiryDate.click();
}
public void clickPerpetual() {
	perpetual.click();
}
public void dropdownPerpetualYes() {
	perpetualYes.click();
}
public void dropdownPerpetualNo() {
	perpetualNo.click();
}
public void clickSave() {
	saveLicense.click();
}
public void validateStatusofLicense() throws InterruptedException {
	
	if(errorMsg.isDisplayed()) {
		String errormessage = errorMsg.getText();
		System.out.println("License number already exist." + errormessage);
		}
		else {
			System.out.println("License Saved Successfully");
		}	
	
}
	
	
public void clickFormType() throws AWTException, InterruptedException {
	Thread.sleep(3000);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	Thread.sleep(3000);	
	dropdownFormType.click();
}
public void selectFormW9() {
	formTypeW9.click();
}
public void selectFormE0(){
	formTypeEO.click();
}
public void Choosebtn() throws InterruptedException, AWTException  {
	btnChoose.click();
	StringSelection ss1 = new StringSelection("D:\\Test.jpg");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
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
public void clickUploadbtn() throws InterruptedException {		
	btnUpload.click();
}
public void clickLicenseRow() {
	LicenseRow.click();
}
public void validateUpload() {
	String formName = formTypeName.getText();
	System.out.println("Form Name :" + formName);
	String UploadedDate = formUploadedDate.getText();
	System.out.println("Uploaded Date :" +UploadedDate);
	String UploadedBy = formUploadedBy.getText();
	System.out.println("Uploaded By:" +UploadedBy);
	
}
/*check Employee Admin
public void VerifyEmployeeLogin() {
	if(employerPage.isDisplayed()) {
		System.out.println("This is Employee Login. Administration is not enabled.");
		}else{
		System.out.println("Administration is enable for this Login");
		}
}	*/
	// Verify License Number, State, Effective Date, Perpetual
	
public void VerifyProducer() {
	String LicNum = verifylicenseNumber.getText();
    System.out.println("License Number: " +LicNum);
    
    String State = verifylicenseState.getText();
    System.out.println("State: " +State);
    
    String EffDate = verifyEffDate.getText();
    System.out.println("Effective Date: " +EffDate);

    String ExpDate = verifyExpDate.getText();
    System.out.println("Expiry Date: " +ExpDate);
    
    String perpetual = verifyPerpetual.getText();
    System.out.println("Perpetual : " +perpetual);
    
    String Formtype = verifyFormType.getText();
    System.out.println("Form Type : " +Formtype);
}
public void verifyCheckbox() {	
	boolean checkboxstatus = checkBox.isSelected();
	System.out.println(checkboxstatus);
}


//=================================================================================//
//Smoke Test Methods
public void verifyNumofRows_ProducerAgency() {	 
	int rowSize = 0;
	List < WebElement > Producertable_rows = ProducerTable.findElements(By.tagName("tr"));
	//To calculate no of rows In table.
	rowSize = Producertable_rows.size();
	System.out.println("No of Producers: " + rowSize);
	
	int RowIndex=1; 
	for(WebElement ProducerTable:Producertable_rows)
	{
	      List<WebElement> FirstColumn=ProducerTable.findElements(By.xpath("td[1]"));
	      //int ColumnIndex=1;
	      for(WebElement colElement:FirstColumn)
	      {
	           System.out.println("Row "+RowIndex+" : Producer Name : "+colElement.getText());
	           //ColumnIndex=ColumnIndex+1;
	       }
	      RowIndex=RowIndex+1;
	 }
}	
	
	
	/*
	int rows_count = Producertable_rows.size();
	//Loop will execute till the last row of table.
	for (int row = 1; row < rows_count; row++) {	   	
		System.out.println("Number of Row " + row);
		Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_ESCAPE);
robot.keyRelease(KeyEvent.VK_ESCAPE);*/
}





