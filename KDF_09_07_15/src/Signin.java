import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Signin {
	WebDriver dr;
	@Test
	public void mytest() throws Exception, Throwable{
		String vURL, vXPath, vText,vXPath1, vText1, vXPathb, vdata, vXPathV, vactual, vexpected;
		vURL="https://www.linkedin.com/";
		vXPath ="//input[@id='login-email']";
		vText ="aminulislamu542@yahoo.com";
		vXPath1="//input[@id='login-password']";
		vText1="1236548";
		vXPathb ="//input[@name='submit']";
		vdata="5000";
		vXPathV="//div[@id='control_gen_2']/p/strong";
		vexpected="Your LinkedIn account has been temporarily restricted";
		browserGetURL(vURL);
		textType(vXPath, vText);
		textType(vXPath1, vText1);
		buttonClick(vXPathb);
		
		waitFor(Integer.parseInt(vdata) );
		getText(vXPathV);
		waitFor(Integer.parseInt(vdata) );
		vactual = getText(vXPathV);
		System.out.println("vactual" +vactual);
		System.out.println("vexpected"+vexpected);
		try{
		if(vactual.equals(vexpected)){
			
			System.out.println("Pass");
		}
		}catch(NoSuchElementException t){
			System.out.println("element is not correct "+t);
		}
		
		
	}
	@After
	public void end(){
		dr.quit();
	}
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
			System.out.println("inside function actual "+fresut);
			return fresut;
		}
	}

