package carLoanSummaryP;

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
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CarLoanSummary {
	WebDriver dr;
	String baseurl, vPurprice, vDpymt, vTinvalue, vpath, vsheet, vTCID, Vresult, wpath, wsheet ;
	int x_row, x_col;
	String xpPurprice, xpDpymt, xpTinvalue, xpCalcu, EMonthlyPymt, AMonthlyPymt, ATof72pmt, vexecute;
	String[][] XlData;
	
	
	@Before
	public void start() throws IOException{
	
		baseurl="http://www.onlineloancalculator.org/";
	
		xpPurprice="//input[@name='param[principal]']";
		xpDpymt="//input[@name='param[down_payment]']";
		xpTinvalue="//input[@name='param[trade_in_value]']";
		xpCalcu="//td[@id='calculate_btn']/input";
		
		vpath="/Users/Maisha/Documents/DDF/CarLoanSummaryTD.xls";
		wpath ="/Users/Maisha/Documents/DDF/CarLoanSummaryTD_r.xls";
		vsheet="Test Data";
		wsheet="Test Data_r";
		System.out.println("read xl start ");
		XlData= readxl(vpath, vsheet);
	
		System.out.println("read xl end");
		dr = new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().window().maximize();
	
	}
		@Test
		public void carlTest() throws IOException{
		
			for (int i=1; i<x_row; i++){
			vexecute=XlData[i][0];
				vTCID = XlData[i][1];
			vPurprice = XlData[i][2];
			vDpymt = XlData[i][3];
			vTinvalue = XlData[i][4];
			EMonthlyPymt = XlData[i][5];
			AMonthlyPymt = XlData[i][6];
			ATof72pmt = XlData[i][7];
			Vresult = XlData[i][8]; 
			if(XlData[i][0].equalsIgnoreCase("Y")){
			dr.get(baseurl);
			entervalue(vPurprice,vDpymt,vTinvalue );
			
			AMonthlyPymt = getamonthpymt(EMonthlyPymt);
			System.out.println("actual paymt "+AMonthlyPymt);
			XlData[i][6]=AMonthlyPymt;
			if (AMonthlyPymt.equals(EMonthlyPymt)){
				XlData[i][8]= "Pass";
			}else{
				XlData[i][8]= "Fail";
			}
			String get72pymt = getATof72pmt();
			XlData[i][7]= get72pymt;
					
		}else{
			XlData[i][8]= "Not Executed";
		}
			}
			writexl(wpath, wsheet, XlData);
			
	}
		
		
	@After
	public void end(){
		//Exercise: create a method that calculates monthly payment using a formula
		//EMI = (p x r x (1+r)n)/ ((1+r)n-1)
		//where eMI = equally monthly installment
		//p= loan amount -down payment
		//r= annual interest rate/1200
		//n= term (period of number of year or month for lone re-payment)
		//get all the link, url, and title - chose any site
		dr.quit();
	}
	public void entervalue(String fPurprice, String fDpymt, String fTinvalue ){
		dr.findElement(By.xpath(xpPurprice)).clear();
		dr.findElement(By.xpath(xpPurprice)).sendKeys(vPurprice);
		dr.findElement(By.xpath(xpDpymt)).clear();
		dr.findElement(By.xpath(xpDpymt)).sendKeys(vDpymt);
		dr.findElement(By.xpath(xpTinvalue)).clear();
		dr.findElement(By.xpath(xpTinvalue)).sendKeys(vTinvalue);
		dr.findElement(By.xpath(xpCalcu)).click();
	}
public String getamonthpymt(String fMonthlyPymt){
	String amonthpymt = dr.findElement(By.xpath("(//h3)[1]")).getText();
	return amonthpymt;
}
public String getATof72pmt(){
	String ATof72pmt = dr.findElement(By.xpath("(//h3)[2]")).getText();
	return ATof72pmt;
}
public String[][] readxl(String fpath, String fsheet) throws IOException{
	String[][] xldata;
	File myfile = new File(fpath);
	FileInputStream myStream = new FileInputStream(myfile);
	HSSFWorkbook myWB = new HSSFWorkbook(myStream);
	HSSFSheet myWS = myWB.getSheet(fsheet);
	x_row= myWS.getLastRowNum()+1;
	x_col=myWS.getRow(0).getLastCellNum();
	xldata = new String[x_row][x_col];
	for(int i=0; i<x_row; i++){
		HSSFRow row = myWS.getRow(i);
		for(int j=0; j<x_col; j++){
			HSSFCell cell = row.getCell(j);
			String value = "-";
			if(cell!=null){
				value = cellToString(cell);
				}
			xldata[i][j] = value;
			System.out.println("read data "+value);
		}
	}
	myStream.close();
	return xldata ;
}
public String cellToString(HSSFCell cell) {
	Object result;
	int type = cell.getCellType();
	switch(type){
	case HSSFCell.CELL_TYPE_NUMERIC:
		result = cell.getNumericCellValue();
	break;
	case HSSFCell.CELL_TYPE_STRING:
		result = cell.getStringCellValue();
		break;
	case HSSFCell.CELL_TYPE_BLANK:
		result = "%";
		break;
	case HSSFCell.CELL_TYPE_BOOLEAN:
		result = cell.getBooleanCellValue();
		break;
	case HSSFCell.CELL_TYPE_ERROR:
		throw new RuntimeException("can't convert");
	case HSSFCell.CELL_TYPE_FORMULA:
		throw new RuntimeException("can't convert");
		default:
			throw new RuntimeException("can't convert");
	}
	
	return result.toString();
}
public void writexl(String fpath, String fsheet, String[][] wxlData) throws IOException{
	File file = new File(fpath);
	HSSFWorkbook WB = new HSSFWorkbook();
	HSSFSheet WS = WB.createSheet(fsheet);
	int row = wxlData.length;
	int col = wxlData[0].length;
	for(int rows=0; rows<row; rows++ ){
		HSSFRow row_w = WS.createRow(rows);
		for(int cols=0; cols<col; cols++){
			HSSFCell cell_w = row_w.createCell(cols);
			cell_w.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell_w.setCellValue(wxlData[rows][cols]);
			
			FileOutputStream myStream =new FileOutputStream(file);
			WB.write(myStream);
			myStream.flush();
			myStream.close();
			
		}
	}
}
}
