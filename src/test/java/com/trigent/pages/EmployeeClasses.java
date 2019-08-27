package com.trigent.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.trigent.base.BaseTest;
import com.trigent.pages.EmployerList;


public class EmployeeClasses extends BaseTest{
	public WebDriver driver;
	
	@FindBy(xpath="//table[@id='employerTable']/tbody/tr[1]/td[3]")
	WebElement selectemployer;
	
	@FindBy(xpath="//td[text()='Advanced Assembly LLC']")
	WebElement selectemployerbyname;
	
	
	@FindBy(xpath="//ul[@id='myTab']/li[4]/a")
	WebElement selectclass;
	@FindBy(xpath="//table[@id='classTable']/tbody")
	WebElement listclass;
	
	@FindBy(xpath="//table[@id='employerTable']/tbody")
	WebElement EmployerListTable;
	
	
	
	public EmployeeClasses(WebDriver dr) {
		// TODO Auto-generated constructor stub
		driver=dr; 
	}
	
	
	

	public void Selectemployer() throws InterruptedException {
		// TODO Auto-generated method stub
		selectemployer.click();
	}
	
	
	//To verify the Status of the Employer and click the Employer with the Status "W"
	public void SelectEmployerStatusW() throws InterruptedException {			
		String Status = null; 
		List < WebElement > EmployerTable = EmployerListTable.findElements(By.tagName("tr"));		
		for(WebElement EmployerListTable:EmployerTable)
		{
		List<WebElement> FifthColumn=EmployerListTable.findElements(By.xpath("td[5]"));
		      //int ColumnIndex=1;
		      for(WebElement colElement:FifthColumn)
		      {
		    	Status = colElement.getText(); 
		    	 // System.out.println("Status of the Employer" + Status);		    	  
		    	  if(Status.equals("W")) 
		    	  {		        	 
		        	  colElement.click(); 
		        	  break;
		    	  }
		    	  
		       } 
		      if(Status.equals("W"))   
		      {
		    	  break;
		      }
		 } 
		
	}
	
	//To verify the Status of the Employer and click the Employer with the Status "A"
		public void SelectEmployerStatusA() throws InterruptedException {			
			String Status = null;
			List < WebElement > EmployerTable = EmployerListTable.findElements(By.tagName("tr"));		
			for(WebElement EmployerListTable:EmployerTable)
			{
			List<WebElement> FifthColumn=EmployerListTable.findElements(By.xpath("td[5]"));
			      //int ColumnIndex=1;
			      for(WebElement colElement:FifthColumn)
			      {
			    	Status = colElement.getText(); 
			    	 // System.out.println("Status of the Employer" + Status);		    	  
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
		
	
	
	
	public void Selectclass() throws InterruptedException {
		selectclass.click();		
		Thread.sleep(1000);
	}
	public void listclass() throws InterruptedException {		
		int rowSize = 0;
		List < WebElement > rows_table = listclass.findElements(By.xpath("tr"));		
		rowSize = rows_table.size();		
		System.out.println("No of Classes: " + rowSize);
		int RowIndex=1;
		for (WebElement listclass : rows_table) {
			List<WebElement> FirstColumn = listclass.findElements(By.xpath("td[1]"));
		//	int ColumnIndex=1;
			for(WebElement colElement:FirstColumn)
		      {
		           System.out.println("Row "+RowIndex+" : Class Name : "+colElement.getText());
		           //ColumnIndex=ColumnIndex+1;
		       }
		      RowIndex=RowIndex+1;
	}

	}



	public void SelectEmployerByName() throws InterruptedException {
		// TODO Auto-generated method stub
		selectemployerbyname.click();
		Thread.sleep(2000);
		
	}



	
}



