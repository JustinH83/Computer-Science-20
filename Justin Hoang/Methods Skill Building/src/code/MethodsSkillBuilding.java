package code;

import java.util.Scanner;

public class MethodsSkillBuilding {
	
	//middle number
	public static int middle(int number1, int number2, int number3) {
		if(number1==number2 ||number1==number3)
			return number1;
		else if(number2==number3)
			return number2;
		else if(number3-number2>0 && number3-number1>0) {
			if(number2>number1)
				return number2;
			else
				return number1;
		}
		else if(number2>number1) {
			if(number3>number1) 
				return number3;
			else 
				return number1;
		}
		else if(number2>number3)
			return number2;
		else
			return number3;	
	}

	//sum of digits
	public static int sum(int number) {
		int sum=0;
		for (int x = 0; x<(int)Math.log10(number)+1; x++) {
			sum+=number/(int)(Math.pow(10,x))%10;
		}
		return sum;
	}
	
	//random number generator
	public static int random(int number1, int number2) {
		if(number1>number2) {
			return (int)(Math.random()*(number1-number2+1)+number2);
		}
		else
			return (int)(Math.random()*(number2-number1+1)+number1);
	}
	
	//error trap
	public static int input(int number1, int number2) {
		Scanner input = new Scanner(System.in);
		int number=number1;
		do {
			try {
				if(number>number2 || number<number1)
					System.out.println("That is not a valid input.");
				System.out.println("Choose a number from "+number1+"-"+ number2 +": ");
				number = input.nextInt();
			}
			catch(Exception e){
				input.next();
				number=number1-1;
			}
		}while(number>number2 || number<number1);
		return number;
	}
	
	//Roman numeral
	public static void romanNumeral(int number) {	
		do {
			
			if(number>=1 && number<=3) {
				System.out.print("I");
				number--;
			}
			else if(number>=4 && number<=8) {
				number-=5;
				if(number<0)
					romanNumeral(-1*number);
				System.out.print("V");
			}
			else if(number>=9 && number<=39) {
				number-=10;
				if(number<0)
					romanNumeral(-1*number);
				System.out.print("X");
			}
			else if(number>=40 && number<=49) {
				number-=40;
				System.out.print("XL");
			}
			else if(number>=50 && number<=89) {
				number-=50;
				System.out.print("L");
			}
			else if(number>=90 && number<=99) {
				number-=90;
				System.out.print("XC");
			}
			else {
				System.out.println("C");
				number=0;
			}
		}while(number>0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(middle(9,9,10));
		//System.out.println(sum(123456));
		//System.out.println(random(11,20));
		//System.out.println(input(1,10));
		romanNumeral(45);
		
	}

}
