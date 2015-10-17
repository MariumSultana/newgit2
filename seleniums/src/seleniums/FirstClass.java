package seleniums;

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

public class FirstClass {
	WebDriver dr;
	@Rule
	public ErrorCollector e = new ErrorCollector();
	
	@Before
	public void start(){
		dr = new FirefoxDriver();
		dr.get("http://www.ebay.com");
		dr.manage().window().maximize();
	}
	@Ignore
	@Test 
	public void testLogin() throws InterruptedException{
		
		dr.findElement(By.xpath("//span[@id='gh-ug-flex']/a")).click();
		dr.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Maisha");
		dr.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Jahane");
		dr.findElement(By.xpath("//input[@id='email']")).sendKeys("Maisha.Jahane@gmail.com");
		dr.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys("Masa#235");
		dr.findElement(By.xpath("//input[@id='rpass']")).sendKeys("Masa#235");
		Thread.sleep(5000);
	}
	@Test
	public void testAsserts() throws InterruptedException{
		System.out.println(dr.getTitle());
		dr.findElement(By.xpath("//button[@id='gh-shop-a']")).click();
		dr.findElement(By.xpath("//table[@id='gh-sbc']/tbody/tr/td[2]/ul[1]/li[1]/a")).click();
		
		dr.findElement(By.xpath("//select[@id='gh-cat']")).click();
		dr.findElement(By.xpath("//select[@id='gh-cat']/option[5]")).click();
		
		dr.findElement(By.xpath("//input[@id='gh-btn']")).submit();
		dr.findElement(By.xpath("html/body/div[4]/div/div[4]/div[1]/ul/li[31]/a")).click();
		dr.findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/ul[6]/li[5]/a")).click();
		System.out.println(dr.findElement(By.xpath("//li[@id='item280233be6a']/ul[1]/li[1]/span")).getText());
		String actual = dr.findElement(By.xpath("//li[@id='item280233be6a']/ul[1]/li[1]/span")).getText();
		String expected = "$5.99";
		try{
		Assert.assertEquals(expected, actual);
		}catch(Throwable t){
			e.addError(t);
		}finally{
			System.out.println("pass");
		}
		
		Thread.sleep(5000);
		
	}
@After
public void end(){
	dr.quit();
}
}
