package code;

import java.util.Scanner;

public class While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int counter = 0;
		while (counter<5) {
			System.out.println("Hello World!");
			counter++;
		}
		
		do {
			System.out.println("Hello World");
			counter++;
		}while(counter<10);
		*/
		Scanner input = new Scanner(System.in);
		int number = 0;
		int sum=0;
		int counter=-1;
		do {
			System.out.print("Choose a number: ");
			number = input.nextInt();
			if(number>0)
				sum+=number;
			counter++;
		}while(number>=0);
		System.out.println("The average is "+(1.0*sum/counter));
	}

}
