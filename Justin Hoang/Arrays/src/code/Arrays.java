package code;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] manta = new int[10];
		int number=0;
		int sum=0;
		for (int x=0;x<10;x++){
			number = input.nextInt();
			manta[x] = number;
			sum += number;
		}
		System.out.println(sum);
		for (int y=0;y<10;y++)
			System.out.print(manta[y] + " ");
	}

}
