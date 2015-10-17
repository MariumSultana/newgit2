import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class KDF1 {
	WebDriver dr;
	
	@Test
	public void testKDF() throws InterruptedException{
	//TC001- find a colleague
		String vactual1 ="Someone's already using that email.";
		String vactual2 ="Let's start with your profile";
		String vactualt1="An exact match for Rahima jahan could not be found.";
		String TextgetT2_1;
		System.out.println("first test case is started");
		browserGetURL("https://www.linkedin.com/");
		textType("//input[@name='first']", "Rahima");
		textType("//input[@name='last']", "jahan");
		buttonClick("//input[@name='search']");
		waitFor(5000);
		String TextgetT1 = getText("//p[@class='no-results-message']");
		waitFor(5000);
		System.out.println("verify result test 1 : "+TextgetT1);
		if (vactualt1.equals(TextgetT1)){
			System.out.println("vactual and expeaced is Pass");
		}else{
			System.out.println("vactual and expeaced is Fail");
		}
		browserClose();
		System.out.println("first test case is end");
	
	//TC002: join now
		System.out.println("2nd test case is start");
		browserGetURL("https://www.linkedin.com/");
		//first name
		textType("//input[@id='first-name']", "Aminul");
		//last name
		textType("//input[@id='last-name']", "Islam");
		//email
		textType("//input[@id='join-email']", "548988huyu@yahoo.com");
		//password
		textType("//input[@id='join-password']", "1236548");
		//click button
		buttonClick("//button[@class='btn btn-primary join-btn']");
		waitFor(5000);
	try{
		TextgetT2_1 = getText("//div[@class='alerts-cont']/div/p/strong");
		System.out.println("verify result test 2_2 : "+TextgetT2_1);
		waitFor(5000);
		if (vactual1.equals(TextgetT2_1)){
			System.out.println("vactual and expeaced is Pass");
		}else{
			System.out.println("vactual and expeaced is Fail");
		}
	}catch(NoSuchElementException e){
		System.out.println("error found which prevent to join");
	}finally{
		
		String TextgetT2_2 = getText("//h1");
		System.out.println("verify result test 2_2 : "+TextgetT2_2);
		waitFor(5000);
		if (vactual2.equals(TextgetT2_2)){
			System.out.println("vactua2 and expeaced is Pass");
		}else{
			System.out.println("vactua2 and expeaced is Fail");
		}
		}
	browserClose();
	System.out.println("2nd test case is end");
	}
		
		
	

	
	//independent keyword function-Reusable
	public void browserGetURL(String fURL){
		//purpose: open a browser session and navigate a specific url				
		//input: URL		
		//output:
		dr = new FirefoxDriver();
		dr.get(fURL);
	}
	public void browserClose(){
		//purpose: Close an open browser session 
		//input:
		//output:
		dr.quit();
	}
	public void textType(String fXPath, String fText){
		//purpose: find an element and type a text web edit field
		//input:xpath, text to type
		//output:
		dr.findElement(By.xpath(fXPath)).clear();
		dr.findElement(By.xpath(fXPath)).sendKeys(fText);
	}
	public void buttonClick(String fXPath){
		//purpose: Clicks on a button
		//input:xpath to identify that specific button
		//output:
		dr.findElement(By.xpath(fXPath)).click();
		
	}
	public void waitFor(int i ) throws InterruptedException{
		Thread.sleep(i);
	}
	public String getText(String fXPath){
		//purpose: get text from a page
		//input:xpath to identify that specific button
		//output:return text
		String fresut;
		fresut= dr.findElement(By.xpath(fXPath)).getText();
		return fresut;
	}
}
