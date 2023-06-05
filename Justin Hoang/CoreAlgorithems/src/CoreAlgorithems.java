import java.util.Scanner;

public class CoreAlgorithems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//extracting a digit from an int
		/*
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		System.out.print("Enter a place value: ");
		int place = input.nextInt();

			Strings 
		String st = Integer.toString(number);
		char digit = st.charAt(st.length()-place-1);
		int answer = digit - '0';
		System.out.println(digit);
		
		System.out.println(number/(int)Math.pow(10,place)%10);
		*/
//error trap
		int number = 0, min = 1, max = 10;
		Scanner input = new Scanner(System.in);
		do {
			try {
				System.out.print("Enter a number from " + min +" to "+max + ": ");
				number = input.nextInt();
			}
			catch(Exception e) {
				System.out.println("That is not valid");
				input.next();
			}
		}while(number>max || number<min);
	}

}
