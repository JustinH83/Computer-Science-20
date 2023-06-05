package code;

import java.util.Scanner;

public class BoneGame {
	//menu
	public static void points(int player, int computer) {
		System.out.println("-------------------");
		System.out.println("Player: " + player);
		System.out.println("Computer: " + computer);
		System.out.println("-------------------");
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
	//rolling the bones
	public static int rolls(){
		int possiblePoints=0;
		if(Math.random()>0.5) {
			System.out.print("Rectangles ");
			possiblePoints+=1;
		}
		if(Math.random()>0.5) {
			System.out.print("Squares ");
			possiblePoints+=1;
		}
		if(Math.random()>0.5) {
			System.out.print("Triangles ");
			possiblePoints+=2;
		}
		if(Math.random()>0.5) {
			System.out.print("Circles ");
			possiblePoints+=3;
		}
		if(Math.random()>0.5) {
			System.out.print("Diamonds");
			possiblePoints+=4;
		}
		System.out.println("");
		return possiblePoints;
	}
	//probability of getting higher than player
	public static double odds(int target) {
		int outcomes=0;
		for(int rectangles=0; rectangles<2;rectangles++) 
			for(int squares=0; squares<2;squares++) 
				for(int triangles=0; triangles<2;triangles++) 
					for(int circles=0; circles<2;circles++) 
						for(int diamonds=0; diamonds<2;diamonds++) {
							if(rectangles+squares+2*triangles+3*circles+4*diamonds>=target)
								outcomes++;
						}
		return (double)outcomes/32;
		/*
		int [] possibleRolls= new int [5];
		for(int x=0; x<5; x++) 
			possibleRolls[x]=0;
		for(int i=0; i<5; i++) {
			possibleRolls[i]=1;
			if(possibleRolls[0]+possibleRolls[1]+possibleRolls[2]*2+possibleRolls[3]*3+possibleRolls[4]*4>target)
				outcomes++;
			possibleRolls[i]=0;
		for(int x=0; x<5; x++) 
			possibleRolls[x]=0;
		}
		for(int x=0;x<5;x++) {
			possibleRolls[x]=1;
			for(int z=x; z<5;z++) {
				possibleRolls[z]=1;
				if(possibleRolls[0]+possibleRolls[1]+possibleRolls[2]*2+possibleRolls[3]*3+possibleRolls[4]*4>target)
					outcomes++;
				possibleRolls[z]=0;
			}
			possibleRolls[x]=0;
		}
		for(int x=0; x<5; x++) 
			possibleRolls[x]=1;
		for(int x=0;x<5;x++) {
			possibleRolls[x]=0;
			for(int z=x; z<5;z++) {
				possibleRolls[z]=0;
				if(possibleRolls[0]+possibleRolls[1]+possibleRolls[2]*2+possibleRolls[3]*3+possibleRolls[4]*4>target)
					outcomes++;
				possibleRolls[z]=1;
			}
			possibleRolls[x]=1;
		}
		for(int x=0; x<5; x++) 
			possibleRolls[x]=1;
		for(int i=0; i<5; i++) {
			possibleRolls[i]=0;
			if(possibleRolls[0]+possibleRolls[1]+possibleRolls[2]*2+possibleRolls[3]*3+possibleRolls[4]*4>target)
				outcomes++;
			possibleRolls[i]=1;
		}
		if(11>target)
			outcomes++;
		return (double)outcomes/32;		
		*/
	}
	//main game logic
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the bone game!");
		int playerPoints = 0;
		int computerPoints = 0;
		int possiblePoints=0;
		int rerolls=0;
		int repeat = 0;
		double risk=0;
		//main game loop
		do {
			rerolls=0;
			points(playerPoints, computerPoints);
			//player's turn
			do {
				possiblePoints=rolls();
				if(rerolls<2) {
					System.out.println("Total possible points are " + possiblePoints + ". Do you want to reroll?(1 for yes/2 for no)");
					repeat = input(1,2);
				}
				rerolls++;
				System.out.println("-------------------");
			}while(repeat==1 && rerolls<3);
			System.out.println("You got " + possiblePoints + " points");
			int previousPoints= possiblePoints;
			playerPoints+=possiblePoints;
			points(playerPoints, computerPoints);
			//computer turn
			rerolls=0;
			do {
				System.out.println("-------------------");
				possiblePoints=rolls();
				if(rerolls<2)
					System.out.println("Total possible points are " + possiblePoints);
				if (playerPoints>=20) {
					if(computerPoints+possiblePoints<playerPoints) {
						repeat=1;
						if(rerolls<2)
							System.out.println("The computer decides to reroll");
					}
					else
						repeat=0;
				}
				else if(playerPoints!=0) {
					if(odds(possiblePoints)>0.45){
						repeat=1;
						if(rerolls<2)
							System.out.println("The computer decides to reroll");
					}
					else 
						repeat=0;
				}
				else {
					if(odds(possiblePoints)>0.45){
						repeat=1;
						if(rerolls<2)
							System.out.println("The computer decides to reroll");
					}
					else 
						repeat=0;
					previousPoints=possiblePoints;
				}
				rerolls++;
				System.out.println("-------------------");
			}while(repeat==1 && rerolls<3);
			System.out.println("The computer got " + possiblePoints + " points");
			computerPoints+=possiblePoints;
		}while(playerPoints<20 && computerPoints<20);
		points(playerPoints, computerPoints);
		if(playerPoints == computerPoints)
			System.out.println("It's a draw!");
		else if(playerPoints>=20){
			if(computerPoints<20)
				System.out.println("You win!");
			else {
				if(computerPoints>playerPoints)
					System.out.println("The computer wins!");
				else
					System.out.println("You win!");
			}
		}
		else
			System.out.println("The computer wins!");
	}
}
