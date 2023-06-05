package code;

import java.util.Scanner;

public class NumberGuessing {
	
	public static int input(int number1, int number2) {
		Scanner input = new Scanner(System.in);
		int number=number1;
		do {
			try {
				if(number>number2 || number<number1) {
					System.out.println("That is not a valid input.");
					System.out.println("Choose a number from "+number1+"-"+ number2 +": ");
				}
				number = input.nextInt();
			}
			catch(Exception e){
				input.next();
				number=number1-1;
			}
		}while(number>number2 || number<number1);
		return number;
	}
	
	public static void hotCold(int guess, int number, int max) {
		if(Math.abs(guess-number)<=(int)(max*0.1)) 
			System.out.println("Very Hot");
		else if(Math.abs(guess-number)<(int)(max*0.3)) 
			System.out.println("warm");
		else if(Math.abs(guess-number)<(int)(max*0.4)) 
			System.out.println("cool");
		else
			System.out.println("very cold");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 0;
		Scanner input = new Scanner(System.in);
		int guesses = 3;
		int guess=0;
		int replay = 0;
		int max=0;
		//repeat the game
		do {
			//difficulty 
			System.out.println("Choose a difficulty (1 for easy / 2 for medium / 3 for hard)");
			int difficulty = input(1,3);
			if (difficulty == 1)
				max = 10;
			else if(difficulty == 2)
				max=15;
			else
				max=20;
			number = (int)(Math.random()*max + 1);
			System.out.println(number); //remove for final version
			guesses=3;
			//main game loop
			do{
				//error trap for the number
				System.out.println("Choose a number from 1-"+ max +": ");
				guess = input(1,max);
				//checking the number
				if(guess==number)
					//cheat
					if(Math.random()<=0.20 && guesses==3){
						while(guess==number)
							number = (int)(Math.random()*max + 1);
						System.out.println("You are incorrect!");
					}
					//if number is right
					else {
						System.out.println("You are correct!");
						break;
					}
				//if number is wrong
				else 
					System.out.println("You are incorrect!");
				//Hot and cold
				if(guesses!=1) {
					hotCold(guess, number, max);
				}
				guesses--;
				System.out.println("You have " + guesses + " guesses left");
			}while(guesses>0);
			if (guess!=number)
				System.out.println("The correct answer was "+number);
			//error trap for playing again
			System.out.println("Do you want to play again? (1 for yes/2 for no)");
			replay=input(1,2);
		}while(replay==1);
	}
}