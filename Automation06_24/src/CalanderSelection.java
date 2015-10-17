import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;




public class CalanderSelection {
	static FirefoxDriver dr = new FirefoxDriver();
	
	@BeforeClass
	public static void start() throws InterruptedException{
		dr.get("http://www.skyscanner.com/");
		dr.manage().window().maximize();
		Thread.sleep(5000);
	}
	@Ignore
	@Test
	public void testPickCal() throws InterruptedException{
		/*try{
		dr.findElement(By.xpath("//fieldset[@id='js-trip-type']/div/label[2]")).click();
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}finally{
			dr.findElement(By.id("js-one-way-input")).click();
		}*/
		dr.findElement(By.xpath("//input[@id='js-origin-input']")).clear();
		dr.findElement(By.xpath("//input[@id='js-origin-input']")).sendKeys("New York, NY (Any)");
		dr.findElement(By.xpath("//input[@id='js-destination-input']")).sendKeys("Flint, MI (FNT)");
		Thread.sleep(5000);
	}
	
	@AfterClass
	public static void end(){
		dr.quit();
	}
}

