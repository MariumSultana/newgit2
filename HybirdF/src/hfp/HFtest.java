package hfp;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HFtest {
	WebDriver dr;
	@Rule
	public ErrorCollector errCol = new ErrorCollector();
	
	@Before
	public void start(){
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.get("http://www.dice.com/");
	}
	//@Ignore
	@Test
	public void TestFindTechSearch() throws InterruptedException{
		String vactual, vexpected;
		vexpected = "Distance";
		dr.findElement(By.xpath("//input[@id='search-field-keyword']")).clear();
		dr.findElement(By.xpath("//input[@id='search-field-keyword']")).sendKeys("Automation engineer");
		dr.findElement(By.xpath("//input[@id='search-field-location']")).clear();
		dr.findElement(By.xpath("//input[@id='search-field-location']")).sendKeys("Marlborough, MA");
		dr.findElement(By.xpath("//button[@class ='btn btn-primary btn-lg btn-block']")).click();
		Thread.sleep(5000);
		vactual= dr.findElement(By.xpath("//div[@id='locationMiles']/div[1]")).getText();
		try{
		Assert.assertEquals(vexpected, vactual);
		System.out.println("TestFindTechSearch"+ vexpected);
		System.out.println("TestFindTechSearch"+ vactual);
		}catch (Throwable t){
			System.out.println(" result is not expected"+ t);
			errCol.addError(t);
		}		
	}
	//@Ignore
	@Test
	public void TestDashboardForgotpassword() throws InterruptedException{
		String vactual, vexpected;
		vexpected = "Enter the email address associated with your MyDice account. We'll email you a link to a page where you can easily create a new password.";
		dr.findElement(By.xpath("//a[@id='MyDice_1']")).click();
		dr.findElement(By.xpath("//input[@id='email']")).clear();
		dr.findElement(By.xpath("//input[@id='email']")).sendKeys("aminulislam@yahoo.com");
		dr.findElement(By.xpath("//input[@id='password']")).clear();
		dr.findElement(By.xpath("//input[@id='password']")).sendKeys("213654");
		dr.findElement(By.xpath("//a[@class='btn-lg-valign']")).click();
		Thread.sleep(1000);
		vactual= dr.findElement(By.xpath("//form[@id='passwordAssistanceForm']/div[1]/p")).getText();
		try{
			Assert.assertEquals(vexpected, vactual);
			System.out.println("TestDashboardForgotpassword"+ vexpected);
			System.out.println("TestDashboardForgotpassword"+ vactual);
			}catch (Throwable t){
				System.out.println(" result is not expected"+ t);
				errCol.addError(t);
			}
		
		
	}
	//@Ignore
	@Test
	public void TestTechNewsEmailsubmit() throws InterruptedException{
		String vactual, vexpected;
		vexpected = "Newsletter";
		
		dr.findElement(By.xpath("//a[@id='Dice_Blog_Network_1']")).click();
		Thread.sleep(1000);
		vactual= dr.findElement(By.xpath("//div[@id='newsletter']/div[1]/h2")).getText();
		try{
			Assert.assertEquals(vexpected, vactual);
			System.out.println("TestTechNewsEmailsubmit"+ vexpected);
			System.out.println("TestTechNewsEmailsubmit"+ vactual);
			}catch (Throwable t){
				System.out.println(" result is not expected"+ t);
				errCol.addError(t);
			}
	
		
	}
	@After
	public void end(){
		dr.quit();
		
	}

}
