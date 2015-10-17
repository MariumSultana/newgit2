import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CalPick {
	
	WebDriver dr;
	@Before
	public void start(){
	dr = new FirefoxDriver();
	dr.get("http://www.monster.com/");
	dr.manage().window().maximize();
	
	}
	@Test
	public void testLogin() throws InterruptedException{
		dr.findElement(By.xpath("//div[@id='login-btn-employer']/a/span")).click();
		dr.findElement(By.xpath("//input[@id='ctl00_ctl00_ContentPlaceHolderBase_cphBody_txtJobTitle']")).sendKeys("software engineer");
		dr.findElement(By.xpath("//input[@id='ctl00_ctl00_ContentPlaceHolderBase_cphBody_txtLocation']")).clear();
		dr.findElement(By.xpath("//input[@id='ctl00_ctl00_ContentPlaceHolderBase_cphBody_txtLocation']")).sendKeys("NJ");
		dr.findElement(By.xpath("//button[@id='ctl00_ctl00_ContentPlaceHolderBase_cphBody_btnContinue']")).click();
		Thread.sleep(5000);
		System.out.println(dr.findElement(By.xpath("//span[@id='ctl00_ctl00_ContentPlaceHolderBase_cphBody_msgBundleDesc']/ul/li[1]")).getText());
		System.out.println(dr.getTitle());
		System.out.println(dr.getCurrentUrl());
		//System.out.println(dr.getSize());
		//System.out.println(dr.getTitle());
	
		//dr.findElement(By.xpath("//input[@id='ctl00_ctl00_ContentPlaceHolderBase_cphBody_txtLocation']")).sendKeys("NJ");
		
	}
	
	
	@After
	public void end(){
	
	dr.quit();
	}

}
