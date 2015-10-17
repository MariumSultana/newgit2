import org.junit.Test;


public class arrayAscendingOrder {

	@Test
	public void myTest(){
		int x1[] = {1, 2, 3, 4};
		int x2[]={1, 3, 5, 2};
		//verify x1 element is an ascending order; x1 is array of integer 
	System.out.println(arrayf(x1));
	System.out.println(arrayf(x2));
	/*System.out.println(arrayf(x2));
	for (int i=0; i<4; i++){
		System.out.println((x2[i]));
	}*/
		
	}
	
	
	public String arrayf(int[] f1){
		String status = "Pass";
		int fLen = f1.length;
		for(int i=0; i<f1.length-1; i++){
			if(f1[i]<f1[i+1]){
				System.out.println("the ascending is true " + i);
			}else{
				status = "fail";
				return status;
				
			}
		}
		
		
		return "Pass";
		//return pass if array order is ascending order else fail
		//array is collection of items put together one besides another
	}
}
