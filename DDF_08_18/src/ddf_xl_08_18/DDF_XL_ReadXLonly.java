package ddf_xl_08_18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDF_XL_ReadXLonly {

	WebDriver dr;
	String[][] xlData;
	String  vIntRate, vLoanAmt, Vresult, vTDID;
	String vActualMPymt, vExpectedMPymt;
	String baseurl = "http://www.mortgagecalculator.com/";
	int xRow, xCol;
	String xPath, xSheet, xPath_r;
	


	
	
	@Before
	public void Start() throws Exception{
		xPath = "/Users/Maisha/Documents/DDF/ReadXL.xls";
		xPath_r = "/Users/Maisha/Documents/DDF/ReadXL_result.xls";
		xSheet = "TestData";
		System.out.println("read start");
		xlData = readxl(xPath, xSheet);
		//System.out.println("read ended" + xlData[xRow][xCol]);
	dr = new FirefoxDriver();
	//dr.get(baseurl);
		dr.manage().window().maximize();
	dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void testDDFXL() throws Throwable{
		
	
		 
for(int i = 1; i<xRow; i++){
		vTDID=xlData[i][0];
		vIntRate = xlData[i][1];
		vLoanAmt = xlData[i][2];
		vExpectedMPymt = xlData[i][3];
		vActualMPymt = xlData[i][4];
		Vresult = xlData[i][5]  ;
		//System.out.println("test data id "+ xlData[i][0]);
	
		
		dr.get(baseurl);
		MCFValues( vIntRate,  vLoanAmt);
		//System.out.println(MCFActualMPymt(vExpectedMPymt ));
		vActualMPymt = getActualMPymt(vExpectedMPymt );
		xlData[i][4] = vActualMPymt;
		
		
		if(vActualMPymt.equals(vExpectedMPymt )){
		System.out.println("pass");
		
		xlData[i][5]= "Pass";
		}else{
			System.out.println("fail");
			xlData[i][5]= "Fail";
		}
		System.out.println(" expected monthly payment " +vExpectedMPymt );
		
		
	try{
		System.out.println("start write xl");
	writeXL(xPath_r, "Test Result", xlData);
	System.out.println("write xl completed");
	}catch (Throwable e){
		System.out.println(e);
	}
		
	}
	}
	
	@After
	public void End(){
		dr.quit();
		//System.out.println("browser quit");
	}
	

	public void MCFValues(String fIntRate, String fLoanAmt){
		dr.findElement(By.xpath("//select[@id='sh_type']/option[2]")).click();
		dr.findElement(By.xpath("//input[@id='mpc_interest_rate']")).clear();
		dr.findElement(By.xpath("//input[@id='mpc_interest_rate']")).sendKeys(fIntRate);
		dr.findElement(By.xpath("//input[@id='mpc_loan_amount']")).clear();
		dr.findElement(By.xpath("//input[@id='mpc_loan_amount']")).sendKeys(fLoanAmt);
		dr.findElement(By.xpath("//div[@id='mortgagePaymentCalc_go_div']/div/input")).click();
	}
	//changed method statement to get value instead verify value
	public String getActualMPymt(String fExpectedMPymt ){
		String fActualMPymt;
		fActualMPymt =  dr.findElement(By.xpath("//span[@id='mortgagePaymentCalc_amount']")).getText();
		System.out.println("actual  monthly payment "+ fActualMPymt);
		return fActualMPymt;
		/*if(vActualMPymt.equals(fExpectedMPymt )){
			return "pass";
			
		}else{
			return "fail";
			
		}*/
	}
	public String[][] readxl(String fPath, String fsheet) throws Exception{
		String[][] myData;
		
		File myxl = new File(fPath);
		FileInputStream myStream = new FileInputStream(myxl);
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);
		HSSFSheet myWS = myWB.getSheet(fsheet);
		 xRow= myWS.getLastRowNum()+1;
		 xCol= myWS.getRow(0).getLastCellNum();
		//System.out.println("rows"+xRow); 
		// System.out.println("column"+xCol);
		 myData = new String[xRow][xCol];
		
		 for(int i=0; i<xRow; i++){
			 HSSFRow row = myWS.getRow(i);
			 for(int j = 0; j<xCol; j++){
				 HSSFCell cell = row.getCell(j);
				 String value = "-";
				 if(cell!=null){
					 value = cellToString(cell);
				 }
				 myData[i][j] = value;
				// System.out.print("the value is "+ value);
				 //.out.print("----");
				 try{
						System.out.println("test  READ get value"+ myData[i][j]);
						}catch (ArrayIndexOutOfBoundsException s){
							System.out.println("arran index out of bound exc"+ s);
						}
			 }
			// System.out.println("");
		 }
		 myStream.close();
		 return myData;
		
	}
	public void writeXL(String fPath, String fSheet, String[][] xData) throws Exception{
		File oFile = new File(fPath);
		HSSFWorkbook oWB = new HSSFWorkbook();
		HSSFSheet oWS = oWB.createSheet(fSheet);
		try{
		int x_row = xData.length;
		int x_col = xData[0].length;
		for(int myrow=0; myrow<x_row; myrow++){
			HSSFRow orow = oWS.createRow(myrow);
			for(int mycol=0; mycol<x_col; mycol++){
				HSSFCell ocell = orow.createCell(mycol);
				ocell.setCellType(HSSFCell.CELL_TYPE_STRING);
				System.out.println("get setce celltype from write"+(HSSFCell.CELL_TYPE_STRING));
				ocell.setCellValue(xData[myrow][mycol]);
				System.out.println("test  WRITE get value"+xData[myrow][mycol]);

				FileOutputStream fOut = new FileOutputStream(oFile);
				oWB.write(fOut);
				fOut.flush();
				fOut.close();
			}
		
		
			
		}
		System.out.println("write code write correctly");
}catch (Throwable e){
			System.out.println("throwable write function errir"+e);
		}
		
	}
	public static String cellToString(HSSFCell cell){

		Object result;
		int type = cell.getCellType();
		switch(type){
		case HSSFCell.CELL_TYPE_NUMERIC : //numeric values in Excel
			result = cell.getNumericCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING: //string value in Excel
			result = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			throw new RuntimeException("i can't evalute formula in java");
		case HSSFCell.CELL_TYPE_BLANK:
			result = "%";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			throw new RuntimeException("this cell has an error");
		default :
				throw new RuntimeException("there are no support of this cell to string convesito mehtod");
				}
		return result.toString();
	}
	
	}


