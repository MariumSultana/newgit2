package purchaseHealthInsP;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindHealthInsMA {
 
WebDriver dr;
String[][] xldata;
String Result, interest, vloanAmount, vyears, vExpectedMPymt, vActualMPymt, vPath, 
vPath_w, VSheet,VSheet_w, vTestid, vResult, vExecution;
int x_row, x_col;
 String baseurl = "http://www.bankrate.com/";

	@Before
	public void start() throws IOException{
		System.out.println("test execution is started");
	
		vPath = "/Users/Maisha/Documents/DDF/MPymt.xls";
		vPath_w = "/Users/Maisha/Documents/DDF/MPymt_res.xls";
		VSheet = "Test Data";
		VSheet_w= "TestData Result";
		vExecution = "Y";
		vExecution = "N";
		System.out.println("start read data");
		xldata = readxl(vPath, VSheet);
		System.out.println("end read data");
		
		
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void findHealthinsMATest() throws Exception{
		for(int i=1; i<x_row; i++){
			vExecution =xldata[i][0];
			vTestid = xldata[i][1];
			vloanAmount=xldata[i][2];
			vyears =xldata[i][3];
			vExpectedMPymt=xldata[i][4];
			vResult = 	xldata[i][6];
			//System.out.println("vExpectedMPymt "+xldata[i][3]);
			//System.out.println("vTestid "+ xldata[i][0]);
			
			if(vExecution.equalsIgnoreCase("Y")){
	dr.get(baseurl);
	Morg(vloanAmount, vyears);
	vActualMPymt = Monthpymt(vExpectedMPymt);
	xldata[i][5] = vActualMPymt;
	System.out.println("actual pymt "+vActualMPymt);
	if (vActualMPymt.equals(vExpectedMPymt)){
		xldata[i][6]= "Pass";
		//System.out.println("Pass");
	}else{
		xldata[i][6]= "Fail";
		//System.out.println("Fail");
	}
		
		}else{
			xldata[i][6]= "no result";
		}
		}
		try{
			System.out.println("start write xl");
			writexl(vPath_w, VSheet_w, xldata);
		System.out.println("write xl completed");
		}catch (Throwable e){
			System.out.println(e);
		}
		
	}
	
	@After
	public void end(){
		dr.quit();
		System.out.println("test execution is completed");
	}
	public void Morg(String floanAmount, String fyears ){
	
		dr.findElement(By.xpath("//div[@id='brwrap']/ul/li[3]/a")).click();
		dr.findElement(By.xpath("//div[@id='MtgPaymentCalc']/div/div/a")).click();
		dr.findElement(By.xpath("//input[@id='loanAmount']")).clear();
		dr.findElement(By.xpath("//input[@id='loanAmount']")).sendKeys(vloanAmount);
		dr.findElement(By.xpath("//input[@id='years']")).clear();
		dr.findElement(By.xpath("//input[@id='years']")).sendKeys(vyears);
		dr.findElement(By.xpath("//button[@id='calcButton']")).click();
		
	}
public String Monthpymt(String fExpectedMPymt ){
	String fActualMPymt;
	fActualMPymt = dr.findElement(By.xpath("//span[@id='mpay']")).getText();
	return fActualMPymt;
}
public String[][] readxl(String fPath, String fSheet) throws IOException{
	String[][] readData;
	File myReadFile = new File(fPath);
	FileInputStream myStream = new FileInputStream(myReadFile);
	HSSFWorkbook myWB = new HSSFWorkbook(myStream);
	HSSFSheet myWS = myWB.getSheet(fSheet);
	x_row = myWS.getLastRowNum()+1;
	x_col = myWS.getRow(0).getLastCellNum();
	System.out.println("count row "+x_row);
	System.out.println("count cell "+x_col);
	readData = new String[x_row][x_col];
	for(int i=0; i<x_row; i++){
		HSSFRow row = myWS.getRow(i);
		for(int j=0; j<x_col; j++){
			HSSFCell cell = row.getCell(j);
			String value = "-";
			if(cell!=null){
				value = cellToString(cell);
			}
			readData[i][j] = value;
			//System.out.println("value"+ value);
			 try{
					System.out.println("test  READ get value"+ readData[i][j]);
					}catch (ArrayIndexOutOfBoundsException s){
						System.out.println("arran index out of bound exc"+ s);
					}
		}
		
	}
	myStream.close();
	return readData ;
}
public String cellToString(HSSFCell cell) {
	Object result;
	int type = cell.getCellType();
	switch (type){
	case HSSFCell.CELL_TYPE_NUMERIC:
		result = cell.getNumericCellValue();
		break;
	case HSSFCell.CELL_TYPE_STRING:
		result = cell.getStringCellValue();
		break;
	case HSSFCell.CELL_TYPE_BOOLEAN:
		result = cell.getBooleanCellValue();
		break;
	case HSSFCell.CELL_TYPE_FORMULA:
		throw new RuntimeException("can't convert");
	case HSSFCell.CELL_TYPE_BLANK:
		result = "%";
		break;
	case HSSFCell.CELL_TYPE_ERROR:
		throw new RuntimeException("can't convert");
		default:
			throw new RuntimeException("can't convert");
	}
	return result.toString();
}
public void writexl(String fpath, String fsheet, String[][] fwritexl) throws IOException{
	int row, col;
	File writefile = new File(fpath);
	HSSFWorkbook myWB = new HSSFWorkbook();
	HSSFSheet myWS = myWB.createSheet(fsheet);
	row = fwritexl.length;
	col = fwritexl[0].length;
	
	for(int rows=0; rows<row; rows++){
		HSSFRow x_row = myWS.createRow(rows);
		for(int cols=0; cols<col; cols++){
			HSSFCell x_cell = x_row.createCell(cols);
			x_cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			x_cell.setCellValue(fwritexl[rows][cols]);
			
			FileOutputStream  myStream = new FileOutputStream(writefile);
			myWB.write(myStream);
			myStream.flush();
			myStream.close();
		}
	}
	
}
}
