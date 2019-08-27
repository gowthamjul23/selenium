package com.trigent.pages;

import java.util.List;

import org.apache.xmlbeans.StringEnumAbstractBase.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trigent.base.BaseTest;

public class EmployerList extends BaseTest {
	@FindBy(xpath="//div[contains(@class,'collapse navbar-collapse navbar-ex1-collapse')]/ul[1]/li[2]")
	WebElement employerListLink;
	
	@FindBy(xpath="//div[contains(@class,'panel-heading')]/span[contains(text(),'Employer List')]")
	WebElement EmployerListLabel;
	
	@FindBy(xpath="//table[@id='employerTable']/tbody")
	WebElement EmployerListTable;
	
 
	
	public EmployerList(WebDriver dr) {
	driver=dr;
	}
	
	public boolean verifyEmployerListPage(){
		return EmployerListLabel.isDisplayed();
		
	}

	
public void clickOnEmployerList() throws InterruptedException {
	employerListLink.click();
	Thread.sleep(3000);
		}
		
		//Select Employer table
		
 public void VerifyNumofEmployer_ListtheNames() {
		
//EmployerListTable.click();
   int rowSize = 0;
 	List < WebElement > rows_table = EmployerListTable.findElements(By.xpath("tr"));
   	rowSize = rows_table.size();
   	System.out.println("No of Employers: " + rowSize);
   	int RowIndex=1;
   	for (WebElement EmployerListTable : rows_table) {
	List < WebElement > FirstColumn = EmployerListTable.findElements(By.xpath("td[3]"));
    for(WebElement colElement:FirstColumn)
    {
	   System.out.println("Row "+RowIndex+" : Employer Name : "+colElement.getText());
	   }
	    	    RowIndex=RowIndex+1;
	    	}
	    	   
	    	}
	    	        
	    	    }
	    	 
	    	
	    	
	    	
		