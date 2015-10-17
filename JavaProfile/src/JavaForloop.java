public class JavaForloop{
String nameSt;
public JavaForloop(int num) {
	System.out.println("the constructor : "+num);
}
public void setName(String name){
nameSt=name;	
}
public String getName(){
	System.out.println("the name is: "+nameSt);
	return nameSt;
}
public static void main(String[] args) {
	JavaForloop n1 = new JavaForloop(58);
	n1.setName("Tomy");
	n1.getName();
	System.out.println("the variable value is: "+n1.nameSt);
}
}