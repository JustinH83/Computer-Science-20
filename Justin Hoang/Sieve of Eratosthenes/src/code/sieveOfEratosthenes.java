package code;

import java.util.Scanner;

public class sieveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Choose the limit of the nummbers");
		int[] manta = new int[input.nextInt()-2];
		for (int x=0;x<manta.length;x++) 
			manta[x]=x+2;
		for(int x=0; x<manta.length;x++) {
			for(int y=1;y<manta.length-x;y++) {
				if(manta[x]==0)
					continue;
				if(manta[x+y]%manta[x]==0)
					manta[x+y]=0;
			}
		}
		for(int x=0;x<manta.length;x++) {
			if(manta[x]!=0)
				System.out.println(manta[x]);
		}
	}
}
