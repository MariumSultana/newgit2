package loginProcess;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondTest {
	@BeforeClass
	public static void begain(){
		System.out.println("=============================Begainning=========================");
	}
	WebDriver dr;
	@Before
	public void testStart1(){
		dr =new FirefoxDriver();
		dr.get("http://www.cheapflights.com");
		dr.manage().window().maximize();
	}
	
	@Test
	public void testArray() throws InterruptedException{
		dr.findElement(By.xpath("//nav[@id='page-tabstrip']/ul/li[4]/a")).click();
		//System.out.println(dr.findElement(By.xpath("//form[@id='SearchBoxForm']/fieldset[1]/label")).getText());
		Thread.sleep(5000);
		dr.findElement(By.xpath("//input[@id='SearchBox_DestinationName']")).sendKeys("Las Vegas");
		dr.findElement(By.xpath("//input[@id='checkin']")).click();
		Thread.sleep(5000);
		WebElement calendar = (WebElement) dr.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[1]"));
	
	}
	@After
	public void testEsnd1(){
	
		dr.quit(); 
		
	}
	@AfterClass
	public static void end(){
		System.out.println("=============================Ending=========================");
	}
}
