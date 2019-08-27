package com.trigent.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.trigent.base.BaseTest;

public class PlanInformation extends BaseTest{
	public WebDriver driver;
	@FindBy(xpath="//div[contains(@class,'collapse navbar-collapse navbar-ex1-collapse')]/ul[1]/li[2]")
	WebElement employerListLink;
	@FindBy(xpath="//table[@id='employerTable']/tbody/tr[8]")
	WebElement selectEmployer;
	//Plan Information tab
	@FindBy(xpath="//ul[@id='myTab']/li[5]/a")
	WebElement planInfo;
	//select plan table
	@FindBy(xpath="//table[@id='eepTable']/tbody")
	WebElement selectplan;
	
	//Plan Information Edit
	@FindBy(xpath="//table[@id='eepTable']/tbody/tr[1]/td[13]/button[contains(text(),'Edit')]")
	WebElement plnInfoEditButton;
	@FindBy(xpath="//div[@id='myTabContent']/div[5]/div/div[1]/span[contains(text(),'Plan Information')]")
	WebElement planInformationLabel;
	
	@FindBy(xpath="//input[@name='Plan_Name']")
	WebElement planInfoPlanName;
	@FindBy(xpath="//div[contains(text(),'Plan Anniversary Date:')]")
	WebElement planAnniversaryDateField;
	@FindBy(xpath="//form[@id='planForm']/input[@id='Anniversary_Date']")
	WebElement planAnnivarsayDateInput;
	
	@FindBy(xpath="//div[@id='modalDialog']/div/div/div[1]/div[1]/div/span[2]/button[@id='editPlanBtn']")
	WebElement saveEditPlanInformationButton;
	@FindBy(xpath=" //div[@id='modalDialog']/div/div/div[1]/div[1]/div/span[2]/button[2]")
	WebElement cancelEditPlanInfoBtn;
	
	@FindBy(xpath="//div[@id='modalDialog']/div/div/div[1]/div[2][contains(text(),'* Anniversary Date Cannot be Blank.')]")
	WebElement anniversaryDaterequiredMessage;
	
	//Plan Information Commission
	@FindBy(xpath="//table[@id='eepTable']/tbody/tr[1]/td[11]/button[contains(text(),'Commission')]")
	WebElement planInfoCommissionBtn;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/thead/tr/th[7]/span/a")
	WebElement addAgencyBtnPlanLevel;
	@FindBy(xpath="//select[@id='ProducerNumber']")
	WebElement selectAgencyPlanLevel;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr[1]/td[2]/input[@name='CommissionPercentage']")
	
	WebElement commissionPercentagePlanlevel;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr/td[2]/span/input[@name='CommissionPercentage']")
	WebElement editCommissionAfterPlanLevel;
	@FindBy(xpath="//button[@id='savePlanCommissionBtn']")
	WebElement addAgencySaveBtnPlanLevel;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr[1]/td[7]/div/button[contains(text(),'Remove')]")
	WebElement removeAgencyBtnPlanLevel;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr[1]/td[5]/input[@id='crd']")
	WebElement crdCheckBox;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr[1]/td[6]/input[@id='caf']")
	WebElement cafCheckBox;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr/td[7]/div/button[1][contains(text(),'Edit')]")
	WebElement agencyEditBtnPlanLevel;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr/td[7]/div/button[3][@id='savePlanCommissionBtn']")
	WebElement agencySaveBtnPlanLevel;
	@FindBy(xpath="//div[@id='modalDialog']/div/div/div[1]/div[1]/div/span[2]/button[contains(text(),Cancel)]")
	WebElement cancelBtnAfterAddAgency;
	@FindBy(xpath="//div[contains(@class,'bs-example')]/ul/li[5]/a")
	WebElement planInformationtab;
	@FindBy(xpath="//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr/td[3]/input[@name='EffectiveDate']")
	WebElement agencyEffectiveDatePlanLevel;
	
	public PlanInformation(WebDriver dr) {
		// TODO Auto-generated constructor stub
		driver=dr;
	}
public String verifyPlanInformationLabel() throws Exception{
		
		String validatePlanInfoPage=planInformationLabel.getText();
		
		System.out.println(validatePlanInfoPage);
		return validatePlanInfoPage;
		
	}

public String verifyPlanAnniversaryDate() throws Exception{
	
	plnInfoEditButton.click();
	Thread.sleep(5000);
	String  planAnniversaryDate=planAnniversaryDateField.getText(); 
	Thread.sleep(5000);
	System.out.println(planAnniversaryDate);
	/*String planAnnivesaryDatefieldFormat=planAnnivarsayDateInput.getText();
	System.out.println(planAnnivesaryDatefieldFormat);*/
	return planAnniversaryDate;
	}

public void addAgencyPlanLevel(String Agency,String commission) throws Exception{
	
	planInfoCommissionBtn.click();
	Thread.sleep(2000);
	addAgencyBtnPlanLevel.click();
	Select selectAgency=new Select(selectAgencyPlanLevel);
	selectAgency.selectByVisibleText(Agency);
	
	commissionPercentagePlanlevel.sendKeys(commission);
	WebElement calEffDate=	driver.findElement(By.xpath("//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr/td[3]/input[@name='EffectiveDate']"));
	calEffDate.click();
	Actions c1= new Actions(driver);
	c1.moveToElement(calEffDate).doubleClick().build().perform();
	WebElement effcDate=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[4]/a"));
	effcDate.click();
	
	
	addAgencySaveBtnPlanLevel.click();
	Thread.sleep(2000);
	
}
public void editAgencyPlanLevel(String commission) throws Exception{
	planInfoCommissionBtn.click();
	Thread.sleep(3000);
	agencyEditBtnPlanLevel.click();
	Thread.sleep(5000);
	if(commission.trim()!=null && commission.trim().length() >=0){
		editCommissionAfterPlanLevel.clear();
		editCommissionAfterPlanLevel.sendKeys(commission);
	}
	/*WebElement calander1=driver.findElement(By.xpath("//form[@id='gradeCommForm']/table[@id='customFields']/tbody/tr[1]/td[3]/input[@name='EffectiveDate']"));
	calander1.click();
	WebElement effcdate=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[4]"));
	effcdate.click();*/
	agencySaveBtnPlanLevel.click();
	cancelBtnAfterAddAgency.click();
	Thread.sleep(5000);
}
//***************************************************************************************************************************************************************************
//Smoke Test Cases Method

 public void PlanInfo() throws InterruptedException {
	// TODO Auto-generated method stub
	 planInfo.click();
	Thread.sleep(1000);
 }
 public void Selectplan() throws InterruptedException {
	 int rowSize = 0;
		List < WebElement > rows_table = selectplan.findElements(By.xpath("tr"));		
		rowSize = rows_table.size();		
		System.out.println("No of Plans: " + rowSize);
		int RowIndex=1; 
		for (WebElement selectplan : rows_table) {
			List<WebElement> FirstColumn = selectplan.findElements(By.xpath("td[1]"));
		//	int ColumnIndex=1;
			for(WebElement colElement:FirstColumn)
		      {
		           System.out.println("Row "+RowIndex+" : Plan Name : "+colElement.getText());
		           //ColumnIndex=ColumnIndex+1;
		       }
		      RowIndex=RowIndex+1;
	
	
} 

}
}
