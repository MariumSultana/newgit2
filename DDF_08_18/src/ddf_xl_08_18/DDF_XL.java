package ddf_xl_08_18;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDF_XL {

	WebDriver dr;
	String baseurl = "http://www.mortgagecalculator.com/";
	


	
	@BeforeClass
	public static void beforeClassstart(){
		System.out.println("the class execution will start");
	}
	@Before
	public void Start(){
		dr = new FirefoxDriver();
		dr.get(baseurl);
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void testDDFXL(){
		
		double  vIntRate = 2.3;
		String vLoanAmt = "200,000";
		String vExpectedMPymt = "$1139.47";
		for(int i = 0; i<3; i++){
		 vIntRate = vIntRate +1;
			System.out.println("interest rate"+ vIntRate );
		
		System.out.println(MCFActualMPymt(vExpectedMPymt ));
		System.out.println(" expected monthly payment " +vExpectedMPymt );
		MCFValues( vIntRate,  vLoanAmt);
		}
		
	}
	public void MCFValues(double fIntRate, String fLoanAmt){
		dr.findElement(By.xpath("//select[@id='sh_type']/option[2]")).click();
		dr.findElement(By.xpath("//input[@id='mpc_interest_rate']")).clear();
		dr.findElement(By.xpath("//input[@id='mpc_interest_rate']")).sendKeys(Double.toString(fIntRate));
		dr.findElement(By.xpath("//input[@id='mpc_loan_amount']")).clear();
		dr.findElement(By.xpath("//input[@id='mpc_loan_amount']")).sendKeys(fLoanAmt);
		dr.findElement(By.xpath("//div[@id='mortgagePaymentCalc_go_div']/div/input")).click();
	}
	
	public String MCFActualMPymt(String fExpectedMPymt ){
		String vActualMPymt;
		vActualMPymt =  dr.findElement(By.xpath("//span[@id='mortgagePaymentCalc_amount']")).getText();
		System.out.println("actual  monthly payment "+ vActualMPymt);
		if(vActualMPymt.equals(fExpectedMPymt )){
			return "pass";
			
		}else{
			return "fail";
			
		}
	}
	@After
	public void End(){
		dr.quit();
		System.out.println("browser quit");
	}
	@AfterClass
	public static void afterClassend(){
		System.out.println("the class execution is ended");
	}
}

