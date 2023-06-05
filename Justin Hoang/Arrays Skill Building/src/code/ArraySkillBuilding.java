package code;

import java.util.Scanner;

public class ArraySkillBuilding {
	
	public static void menu() {
		System.out.println("0. Exit program");
		System.out.println("1. Populate the array randomly");
		System.out.println("2. Populate the array sequentially from 1 to 100");
		System.out.println("3. Display the Array");
		System.out.println("4. Shuffle the Array");
		System.out.println("5. Find the first occurance of a number");
		System.out.println("6. Check if the array is in ascending order");
		System.out.println("7. shuffle the array until it is in ascending order(or until it tries 1000 times)");
		System.out.println("8. Find the lowest number");
		System.out.println("9. Find the largest number");
		System.out.println("10. Find how many of a certain number there is");
		System.out.println("11. Replace every occurance of a number with another number");
		System.out.println("12. Find the largest sum of 10 consecative number");
	}
	//randomly populate the array
	public static int[] random(int[]manta) {
		for(int x=0; x<manta.length; x++) 
			manta[x]=(int)(Math.random()*100+1);
		return manta;
	}
	//populate the array from 1-100
	public static int[] populate(int[]manta) {
		for(int x=0; x<manta.length;x++)
			manta[x] = x+1;
		return manta;
	}
	//display the array
	public static void display(int[]manta) {
		for (int x=0; x<manta.length;x++) {
			if(x%10==0)
				System.out.println("");
			if((int)(manta[x]/10)==0)
				System.out.print("   " + manta[x]);
			else if((int)(manta[x]/100)==0)
				System.out.print("  " + manta[x]);
			else
				System.out.print(" " + manta[x]);
		}
		System.out.println("");
	}
	//shuffle the array
	public static int[] shuffle(int[] manta) {
		int[] shuffled = new int[manta.length];
		int[] seen = new int[manta.length];
		boolean repeat=false;
		int position=0;
		for(int x=0; x<manta.length;x++) {
			do {
				repeat=false;
				position=(int)(Math.random()*manta.length);
				for(int y=0; y<seen.length;y++) {
					if(seen[position]==1)
						repeat=true;
				}
				if(repeat==false) {
					shuffled[x] = manta[position];
					seen[position]=1;
				}
			}while(repeat==true);
		}
		return shuffled;
	}
	//find first occurance of a number
	public static void first(int[]manta, int target){
		int location=-1;
		for(int x=0; x<manta.length;x++) {
			if(manta[x]==target)
				location = x;
		}
		if(location==-1)
			System.out.println("-1");
		else
			System.out.println(location);
	}
	//check if array is in ascending order
	public static boolean ascending(int[] manta) {
		boolean answer = false;
		for(int x=0; x<manta.length-1;x++) {
			if(manta[x+1]<manta[x])
				break;
			answer=true;
		}
		return answer;
	}
	//shuffle until it is in ascending order
	public static int[] shuffleSort(int[]manta) {
		int[] original = manta;
		int counter=0;
		do {
			counter++;
			if(ascending(manta)==true) {
				System.out.println("true");
				return manta;
			}
			else
				shuffle(manta);
		}while(counter<1000);
		System.out.println("false");
		return original;
	}
	//find lowest number
	public static int lowest(int[]manta) {
		int lowest=manta[0];
		for (int x = 0; x<manta.length;x++) {
			if(manta[x]<lowest)
				lowest=manta[x];
		}
		return lowest;
	}
	//find highest number
	public static int highest(int[]manta) {
		int highest=manta[0];
		for (int x = 0; x<manta.length;x++) {
			if(manta[x]>highest)
				highest=manta[x];
		}
		return highest;
	}
	//find repeats of a certain number
	public static int repeats(int[]manta, int target) {
		int repeats=0;
		for (int x = 0; x<manta.length;x++) {
			if(manta[x]==target)
				repeats++;
		}
		return repeats;
	}
	//replace 1 number with another
	public static int[] replace(int[]manta, int num1, int num2) {
		for (int x = 0; x<manta.length;x++) {
			if(manta[x]==num1)
				manta[x]=num2;
		}
		return manta;
	}
	//find the largest sum of ten consecutive numbers
	public static int largestTen(int[]manta) {
		int largest=0;
		for (int x = 0; x<manta.length-10;x++) {
			int sum = 0;
			for (int y=0; y<10;y++) 
				sum+=manta[x+y];
			if(sum>largest)
				largest=sum;
		}
		return largest;
	}
	//largest 3x3
	public static void display(int[][]manta) {
		for (int x=0;x<20;x++) {
			for (int y=0;y<20;y++) {
				if((int)(manta[x][y]/10)==0)
					System.out.print("   " + manta[x][y]);
				else if((int)(manta[x][y]/100)==0)
					System.out.print("  " + manta[x][y]);
				else
					System.out.print(" " + manta[x][y]);
			}
			System.out.println("");
		}
	}
	public static int threeByThree(int[][]manta) {
		int largest=0;
		int largestx=0;
		int largesty=0;
		for(int x=0; x<17;x++) {
			for(int y=0;y<17;y++) {
				int sum=0;
				for(int z=0;z<3;z++) {
					for(int n=0; n<3;n++)
						sum+=manta[x+z][y+n];
				}
				if(sum>largest) {
					largest=sum;
					largestx=x;
					largesty=y;
				}
			}
		}
		System.out.println("The coordinate of the top left of the biggest 3x3 is (" + largestx + "," + largesty + ")");
		return largest;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] manta = new int[100];
		Scanner input = new Scanner(System.in);
		int number=0;
		do {
			menu();
			number = input.nextInt();
			if (number ==1) {
				random(manta);
				System.out.println("The array had been populated randomly");
			}
			else if (number==2) {
				populate(manta);
				System.out.println("the array has been sequentially populated from 1 to 100");
			}
			else if (number==3) 
				display(manta);
			else if(number==4){
				manta=shuffle(manta);
				System.out.println("The array has been shuffled");
			}
			else if(number==5) {
				System.out.println("What number do you want to find");
				int target = input.nextInt();
				first(manta, target);
			}
			else if(number==6) {
				if(ascending(manta)==true)
					System.out.println("It is in ascending order");
				else
					System.out.println("It is not in ascending order");
			}
			else if(number==7) 
				manta=shuffleSort(manta);
			else if(number==8)
				System.out.println(lowest(manta));
			else if(number==9)
				System.out.println(highest(manta));
			else if(number==10) {
				System.out.println("What number do you wany to find");
				int target = input.nextInt();
				System.out.println(repeats(manta, target));
			}
			else if(number==11) {
				System.out.println("What number do you want to replace?");
				int num1 = input.nextInt();
				System.out.println("What do you want to replace that number with?");
				int num2 = input.nextInt();
				replace(manta, num1, num2);
				System.out.println("All " + num1 + "'s have been replaced with " + num2);
			}
			else if (number==12)
				System.out.println("The highest sum of ten consecuative numbers is "+largestTen(manta));
		}while(number!=0);
		//20x20
		int[][] square = new int[20][20];
		for (int x=0; x<20;x++) {
			for(int y=0;y<20;y++) {
				square[x][y]=(int)(Math.random()*100+1);
			}
		}
		display(square);
		System.out.println(threeByThree(square));
		
		
		//cyclic shifts
		String t = input.next();
		String s = input.next();
		char[] shifts = new char[s.length()];
		char[] text = new char[t.length()];
		boolean cyclic=false;
		int counter=0;
		for (int x=0; x<s.length();x++) 
			shifts[x] = s.charAt(x);
		for (int x=0; x<t.length();x++) 
			text[x] = t.charAt(x);
		do {
			for (int x=0; x<(t.length()-s.length());x++) {
				cyclic = true;
				for(int y=0; y<s.length();y++) {
					if(shifts[y] != text[x+y])
						cyclic=false;
					if( cyclic == true) 
						break;
				}
			}
			if(t.length()==s.length()) {
				cyclic=true;
				for(int y=0; y<s.length();y++) {
					if(shifts[y] != text[y])
						cyclic=false;
				}
			}
			char first = shifts[0];
			for(int x=0; x<s.length()-1;x++)
				shifts[x] = shifts[x+1];
			shifts[s.length()-1] = first;
			counter++;
		}while(cyclic==false && counter<s.length());
		if(cyclic==false)
			System.out.println("no");
		else
			System.out.println("yes");	
	}
}
