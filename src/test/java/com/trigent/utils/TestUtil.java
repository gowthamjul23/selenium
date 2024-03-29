package com.trigent.utils;

import java.io.File;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	public static final long ms=5000;
	public static boolean isExecuatable(String testname, Xls_Reader xls){
	
		for(int rowNum =2; rowNum<=xls.getRowCount("Test Cases"); rowNum++){
			if(xls.getCellData("Test Cases", "TCID", rowNum).equalsIgnoreCase(testname)){
				if(xls.getCellData("Test Cases", "Runmode", rowNum).equalsIgnoreCase("Y"))
					return true;
					else
					return false;
			}
		}
		return false;
	}
	
/*public static void takeScreenShoot(String fileName){
	File srcFile= ((TakesScreenshot)(TestBase.driver)).getScreenshotAs(OutputType.FILE);
	try {
		//FileUtils.copyFile(srcFile,new File("D:\\Project\\Raptor\\Raptor_Automation"+fileName+".jpg"));
		FileUtils.copyFile(srcFile,new File("C:\\Raptor\\Screenshots"));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}*/

	
	public static String captureScreenShot(WebDriver driver, String ScreenShotName){
		try{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			String dest="C:\\Users\\ammajan_m\\Desktop\\RateCentric\\RCscreenshots\\"+ScreenShotName+".png";
			File destination = new File(dest);
			FileUtils.copyFile(Source, destination);
			System.out.println("Screen shot taken");
			return dest;
		}
		catch (Exception e){
			System.out.println("Exception while capturing screen shot"+e.getMessage());
			return e.getMessage();
		}
	}
	
	
	
public static void delay(int ms){
	try {
		Thread.sleep(ms);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/* Method to select option by Value */
public static void selectOptionByValue(WebElement selectedElement, final String selectOption){
	Select select = new Select(selectedElement);
	select.selectByValue(selectOption);
}
/* Method to select option by Index */
public static void selectOptionByIndex(WebElement selectedElement, final int selectOption){
	Select select = new Select(selectedElement);
	select.selectByIndex(selectOption);
}
/* Method to select option by VisibleText */
public static void selectOptionByVisibleText(WebElement selectedElement, final String selectOption){
	Select select = new Select(selectedElement);
	select.selectByVisibleText(selectOption);
}

public static Object[][] getData(String testName,String sheetName,Xls_Reader xls){
		int testStartRowNum=0;
		// find the row num from which test starts
		for(int rNum=1;rNum<=xls.getRowCount(sheetName);rNum++){
			if(xls.getCellData(sheetName, 0, rNum).equals(testName)){
				testStartRowNum=rNum;
				break;
			}
		}
		//System.out.println("Test "+ testName +" starts from "+ testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int totalCols=0;
		while(!xls.getCellData(sheetName, totalCols, colStartRowNum).equals("")){
			totalCols++;
		}
		//System.out.println("Total Cols in test "+ testName + " are "+ totalCols);
		//rows
		int dataStartRowNum=testStartRowNum+2;
		int totalRows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+totalRows).equals("")){
			totalRows++;
		}
		//System.out.println("Total Rows in test "+ testName + " are "+ totalRows);
		
		Object[][] data = new Object[totalRows][1];
		int index=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+totalRows);rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<totalCols;cNum++){
				table.put(xls.getCellData(sheetName, cNum, colStartRowNum), xls.getCellData(sheetName, cNum, rNum));
				System.out.print(xls.getCellData(sheetName, cNum, colStartRowNum)+" "+xls.getCellData(sheetName,cNum, rNum));
			}
			table.put("RowNum", String.valueOf(rNum));
			data[index][0]= table;
			index++;
			//System.out.println();
		}
		
		return data;
	}

	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new
			    ExpectedCondition<Boolean>() {
			        public Boolean apply(WebDriver driver) {
			            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			        }
			    };
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(pageLoadCondition);
			}
	

}
