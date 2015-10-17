import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FaceBookAutomation {
	
	WebDriver dr;
	@Before
	public void Start(){
		dr = new FirefoxDriver();
		dr.get("https://www.facebook.com");
		dr.manage().window().maximize();
	}
	@Ignore
	@Test
	public void testHomePage(){
		dr.findElement(By.xpath("//input[@id='email']")).sendKeys("6466363256");
		dr.findElement(By.xpath("//input[@id='pass']")).sendKeys("6466363256");
		dr.findElement(By.xpath("//input[@id='u_0_x']")).click();
		
	}
	@Test
	public void testRegister() throws InterruptedException{
		dr.findElement(By.xpath("//input[@id='u_0_b']")).sendKeys("A");
		dr.findElement(By.xpath("//input[@id='u_0_d']")).sendKeys("B");
		dr.findElement(By.xpath("//input[@id='u_0_f']")).sendKeys("6466363256");
		dr.findElement(By.xpath("//input[@id='u_0_i']")).sendKeys("6466363256");
		dr.findElement(By.xpath("//input[@id='u_0_k']")).sendKeys("6466363256");
		Thread.sleep(5000);
		dr.findElement(By.xpath("//select[@id='month']/option[4]")).click();
		Thread.sleep(5000);
		dr.findElement(By.xpath("//select[@id='day']/option[30]")).click();
		dr.findElement(By.xpath("//select[@id='year']/option[7]")).click();
		dr.findElement(By.xpath("//input[@id='u_0_n']")).click();
		dr.findElement(By.xpath("//div[@id='u_0_r']/p/a[1]")).click();
		dr.findElement(By.xpath("//div[@id='blueBarNAXAnchor']/div/div[2]/div/div/span/a")).click();
		dr.findElement(By.xpath("//button[@id='u_0_s']")).submit();
		
		Thread.sleep(5000);
	}
	
	@After
	public void end(){
		dr.quit();
	}
}

