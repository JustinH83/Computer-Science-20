package code;

import java.util.Scanner;
//cntrl shift "o"

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("What is your name: ");
		
		Scanner input = new Scanner(System.in);
		
		//String name = input.next();
		//System.out.println("Hello " + name);
		//System.out.println("What year were you born in? ");
		//int year = input.nextInt();
		//System.out.println(" You will be " + (2023-year) + " this year");
		
		System.out.println("Choose a number: ");
		int first = input.nextInt();
		System.out.println("Choose a 2nd number: ");
		int second = input.nextInt();
		System.out.println("The sum of your 2 numbers is: " + (first + second));
	}

}
