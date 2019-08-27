package com.trigent.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeePage {
	
	
		@FindBy (xpath = "//*[@id='nav-tabs']")
		WebElement EmployeeName;
		
		@FindBy (xpath = "//*[@id='classTable']//tbody")
		WebElement EmployerClass;
		
		@FindBy (xpath = "//*[@id='covTable']//tbody")
		WebElement EmployeeCoverage;		
		
		@FindBy (xpath="(//button[text()='Terminate'])")
		WebElement ClickTerminate;
		
		@FindBy (id="removeClassConfirm")
		WebElement ConfirmButton;
		
		@FindBy (id = "classTerminationDate")
		WebElement TerminationDateField;
		
		@FindBy (xpath ="//*[@id='classTable']//tbody//tr[1]//td[text()='T']")
		WebElement Status;
		
		@FindBy (xpath ="(//button[text()='Close'])[1]")
		WebElement closeButton;
		
		@FindBy (xpath ="//*[@id='classTable']//tbody")
		WebElement EmployeeclassTable;
		
		//get name of the Employee in Employee list page
		public void EmployeeName() {
			String PTEmployeeName = EmployeeName.getText();
			System.out.println("Name of the Employee:" + PTEmployeeName);
		}

		//verify the number of class and list the name of the employer class
		public void VerifyEmployerClass() {
			int rowSize = 0;
			List < WebElement > EmployerClassRows = EmployerClass.findElements(By.tagName("tr"));
			//To calculate no of rows In table.
			rowSize = EmployerClassRows.size();
			System.out.println("No of Classes: " + rowSize);
			
			int RowIndex=1;
			for(WebElement EmployerClass:EmployerClassRows)
			{
			      List<WebElement> FirstColumn=EmployerClass.findElements(By.xpath("td[1]"));
			      //int ColumnIndex=1;
			      for(WebElement colElement:FirstColumn)
			      {
			           System.out.println("Row "+RowIndex+" : Employer Class Name : "+colElement.getText());
			           //ColumnIndex=ColumnIndex+1;
			       }
			      RowIndex=RowIndex+1;
			 }
		}	
		
		//Verify the number of Employee Coverage and list the coverage Type
		public void VerifyEmployeeCoverage() {
			int rowSize = 0;
			List < WebElement > EmployeeCoverageRows = EmployeeCoverage.findElements(By.tagName("tr"));
			//To calculate no of rows In table.
			rowSize = EmployeeCoverageRows.size();
			System.out.println("No of Employee Coverage Types: " + rowSize);
			
			int RowIndex=1;
			for(WebElement EmployeeCoverage:EmployeeCoverageRows)
			{
			      List<WebElement> FirstColumn=EmployeeCoverage.findElements(By.xpath("td[1]"));
			      //int ColumnIndex=1;
			      for(WebElement colElement:FirstColumn)
			      {
			           System.out.println("Row "+RowIndex+" : Employe Coverage Type : "+colElement.getText());
			           //ColumnIndex=ColumnIndex+1;
			       }
			      RowIndex=RowIndex+1;
			 }
		}	
		
		public void VerifyEmployeeCoverage_Volume_MonthlyPremium() {		
			
			
			List < WebElement > EmployeeCoverageRows = EmployeeCoverage.findElements(By.tagName("tr"));
			//To calculate no of rows In table.
			int rowCount = EmployeeCoverageRows.size();
			System.out.println("No of Employee Coverage: " + rowCount);		
			for (int row=0; row<rowCount; row++) {
				List<WebElement> Columns_One = EmployeeCoverageRows.get(row).findElements(By.xpath("td[1]"));	
				List<WebElement> Columns_Two = EmployeeCoverageRows.get(row).findElements(By.xpath("td[2]"));
				List<WebElement> Columns_Three = EmployeeCoverageRows.get(row).findElements(By.xpath("td[4]"));	
				List<WebElement> Columns_Four = EmployeeCoverageRows.get(row).findElements(By.xpath("td[5]"));

				int columnCount = Columns_One.size();
				//System.out.println("Number of Columns in Row" + row + "and Column Count" +columnCount);
				
				for (int column=0; column<columnCount; column++) {
					String coveragetype = Columns_One.get(column).getText();
					String carrier = Columns_Two.get(column).getText();
					String volume = Columns_Three.get(column).getText();
					String monPremium = Columns_Four.get(column).getText();
					System.out.println("Coverage Type :" + coveragetype);
					System.out.println("Carrier :" + carrier);
					System.out.println("Volume Amount :" + volume);
					System.out.println("Monthly Premium :" + monPremium);
					
				}
				
				System.out.println("....................................................");
			}		
		}	

		
		public void ClickTerminate()throws InterruptedException {					
				String Status = null;
				
				List < WebElement > EmployeeclassRow = EmployeeclassTable.findElements(By.tagName("tr"));		
				for(WebElement EmployeeclassTable:EmployeeclassRow)
				{
				List<WebElement> ThirdColumn=EmployeeclassTable.findElements(By.xpath("td[3]"));
				      //int ColumnIndex=1;
				      for(WebElement colElement:ThirdColumn)
				      {
				    	Status = colElement.getText(); 
				    	  System.out.println("Status of the Employer" + Status);		    	  
				    	  if(Status.equals("A"))
				    	  {		    
				    		  Thread.sleep(5000);
				    		  ClickTerminate.click();
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
			
		
		
	    public void EnterTerminationDate() throws InterruptedException {
		TerminationDateField.sendKeys("06/06/2019");
		Thread.sleep(3000);
	    }
	    public void ClickConfirm() throws InterruptedException {
		ConfirmButton.click();
		System.out.println("Clicked Confirmation button to Terminate the Plan");
		Thread.sleep(5000);
	  }
	    public void ClickClose() throws InterruptedException{
	    	closeButton.click();
	    	Thread.sleep(5000);
	    }
		
}
