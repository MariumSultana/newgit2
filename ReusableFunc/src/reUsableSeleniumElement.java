import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class reUsableSeleniumElement {
String xpPricemin, xpPricemax;
WebDriver dr;
String xpSortLtoH = "";
//String vSortLtoH = "LowtoHigh";


	
	public void selectPriceMinMax(String fPricemin, String fPricemax){
		//a function to select min and max
		//select price min
		new Select(dr.findElement(By.xpath(xpPricemin))).selectByVisibleText(fPricemin);
		//select price max
		new Select(dr.findElement(By.xpath(xpPricemax))).selectByVisibleText(fPricemax);
	}
	
	public void selectSort(String fsortType){
		//a function to click on sort button
		//selectSort("LowtoHigh");
		//click on sort button
		dr.findElement(By.xpath("(//button[@id=''])[2]")).click();
		//select by sort type
		if(fsortType.equals("LowtoHigh")){
			dr.findElement(By.xpath(xpSortLtoH)).click();
		}else{
			System.out.println("not able to select sort type");
		}
	}
//regular expression- value is following certain expression--i.e. don't know the full value, using 2 or 3 words and find the pettren. 
	public String getNumber(String fprice){
		//IT should strip the $ sign, *.. just return the number i.e. $10,00* should return 1000
		//String vprice =""$11,000*;
		//getNumber(vprice)
		//int myprice = new int[10]
		/*for (int j; j<11; j++){
		 * String xpPrice= "//*[@id='']/div[" + j + "]/div[3]/div[2]/div[1]" 
		 * vprice = dr.findElement(By.xpath(xpPrice).getText();
		 * syso(vprice);
		 * vprice = getNumber(vprice)
		 * myprice[j-1] = Integer.perseInt(vprice);}
		 * syso(myascending(myprice));
		 *------ slpit the value
		 * public void mySplit(){
		 * String v1 = "Marium su l tal";
		 * String v2= v1.split("");
		 * int v2Lan = v2.length;//return the length of array
		 * for(int i =0; i<v2Lan; i++){
		 * syso(v2[i])}
		 * }
		 * -----
		 * String fPrice="$10,000"
		 * String[] fTemp = fPrice.split("\\$")
		 * syso(fTemp[0])
		 * syso(fTemp[1])
		 * ----
		 * String fPrice="$10,000"
		 * String f1 = fPrice.split("\\$");
		 * String f2=f1[1]; --we are taking the second item
		 * String f3[]=f2.split(",");
		 * String f4=f3[0]+f3[1];
		 * String f5[] = f4.split("\\*");
		 * syso("value of number is"+f5[0])	 
		 * ---------
		 * */
		
		String[] f1 = fprice.split("\\$");
		 String f2=f1[1]; 
		  String f3[]=f2.split(",");
		  String f4=f3[0]+f3[1];
		 String f5[] = f4.split("\\*");
		 return f5[0];
	}
}
