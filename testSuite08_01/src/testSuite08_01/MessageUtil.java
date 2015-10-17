package testSuite08_01;

public class MessageUtil {
private String message;
	public MessageUtil(String message) {
	this.message = message;
	}

	public Object Salute() {
		System.out.println(message);
		return message;
	}

}
