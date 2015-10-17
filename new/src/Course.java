public class Course{
	
	

	int number;
	static char gender = 'S';
	 String name = "testss";
	
public static void main(String[] args) {
	
	Object a[] []= new Object[2][2];
	a[0][0]= "text";	
	a[0][1]=25;
	
	a[1][0]="text2";
	a[1][1]=68;
	
	
	
	int row=a.length;
	int col = a[0].length;
	for(int rows=0; rows<row; rows++){
		for(int cols=0; cols<col; cols++)
			System.out.print(a[rows][cols]+"----");
			System.out.println();
	}
			Object a1[] []= new Object[2][2];
			a1[0][0]= "text111";	
			a1[0][1]=25111;
			
			a1[1][0]="text2111";
			a1[1][1]=681111;
			
			int row1=a1.length;
			int col1 = a1[0].length;
			for(int rows1=0; rows1<row1; rows1++){
				for(int cols1=0; cols1<col1; cols1++)
					System.out.print(a1[rows1][cols1]+"----");
					System.out.println();
	}
}

	
}
 
