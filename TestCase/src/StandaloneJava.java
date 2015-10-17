import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class StandaloneJava {

	public static void main(String[] args) {
		Collection a= new ArrayList();
		a.add("aa");
		Object[][] data= new Object[2][3];
		data[0][0]="testuser1";
		data[0][1]="Pass1";
		data[0][2]=365;
		//2nd set row
		
		data[1][0]="testuser2";
		data[1][1]="Pass2";
		data[1][2]=36536;
		Arrays.asList(data);

	}

}
