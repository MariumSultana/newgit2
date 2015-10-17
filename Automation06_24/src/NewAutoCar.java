import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class NewAutoCar {
	WebDriver dr;
	@Before
	public void start(){
		dr = new FirefoxDriver();
		dr.get("https://www.dice.com");
		dr.manage().window().maximize();
	}
	@Ignore
	@Test
	public void testCar() throws InterruptedException{
	
		dr.findElement(By.xpath("//form[@id='search-form']/fieldset/div[4]/div/div[2]/div/a")).click();
		Thread.sleep(5000);
		dr.findElement(By.xpath("//input[@id='for_one']")).sendKeys("automation");
		dr.findElement(By.xpath("//input[@id='for_all']")).sendKeys("engineer");
		dr.findElement(By.xpath("//input[@id='for_exact']")).sendKeys("permanent position");
		dr.findElement(By.xpath("//input[@id='for_none']")).sendKeys("none");
		dr.findElement(By.xpath("//input[@id='for_jt']")).sendKeys("Automation QA Analyst");
		dr.findElement(By.xpath("//input[@id='for_com']")).sendKeys("any company");
		dr.findElement(By.xpath("//input[@id='for_loc']")).clear();
		dr.findElement(By.xpath("//input[@id='for_loc']")).sendKeys("NJ");
		
		Thread.sleep(5000);
		dr.findElement(By.xpath("html/body/div[3]/div/div/div[12]/div[2]/div/div/button")).click();
		dr.findElement(By.xpath("html/body/div[3]/div/div/div[12]/div[2]/div/div/ul/li[3]/a/input")).click();
		dr.findElement(By.xpath("//div[@id='postedDateS']/a")).click();
		dr.findElement(By.xpath("html/body/div[3]/div/div/div[13]/div[2]/div[2]/span[3]")).click();
		Thread.sleep(10000);
		dr.findElement(By.xpath("//input[@id='sort2']")).click();
		dr.findElement(By.xpath("//input[@id='telecommute2']")).click();
		
		
	}
	//@Ignore
	@Test 
	public void testTitle() throws InterruptedException{
		System.out.println(dr.findElement(By.xpath("//form[@id='search-form']/fieldset/div[1]/div/strong")).getText());
		Thread.sleep(5000);
		System.out.println((dr.getTitle()));
		System.out.println(dr.getPageSource());
		//System.out.println(dr.getCurrentUrl());
		System.out.println(dr.navigate());
		
	}
	@After
	public void end(){
		dr.quit();
	}

}
