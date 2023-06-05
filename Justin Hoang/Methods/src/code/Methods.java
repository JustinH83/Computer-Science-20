package code;

public class Methods {
	
	public static void helloWorld() {
		System.out.println("Hello world");
	}
	
	public static int add(int number1, int number2) {
		return number1 + number2;
	}
	public static int add(int number1, int number2, int number3) {
		return number1 + number2 + number3;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		helloWorld();
		
		System.out.println(add(5,9));
	}

}
