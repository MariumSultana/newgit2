package loginProcess;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
	WebDriver dr;
	@Before
	public void Start(){
		dr = new FirefoxDriver();
		dr.get("http://www.cheapflights.com/");
		dr.manage().window().maximize();
	}
	@Ignore
	@Test
	public void testLogin() throws InterruptedException{
		dr.findElement(By.xpath("//div[@id='sb-be-searchType']/div[2]/span[2]")).click();
		dr.findElement(By.xpath("//div[@id='sb-from']/input")).sendKeys("NY");
		dr.findElement(By.xpath("//div[@id='sb-to']/input")).sendKeys("TX");
		//dr.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[7]/a")).submit();
		//dr.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[4]/a")).click();
		Thread.sleep(5000);
		
		
	}
	//@Ignore
	@Test
	public void testSearch(){
		
		
	}
	@Ignore
	@Test
	public void testLogoff(){
		
	}

	@After
	public void End(){
	dr.quit();
	}
}

