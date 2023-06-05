package code;

import java.util.Scanner;

public class CCCArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Secret Instructions
		/*
		Scanner input = new Scanner(System.in);
		String num;
		String previous="";
		num = input.next();
		while(Integer.parseInt(num)!=99999){
			int[] manta = new int[5];
			for (int x=0;x<5;x++) 
				manta[x] = num.charAt(x)-48;
			if(manta[0]+manta[1]==0)
				System.out.print(previous);
			else if((manta[0]+manta[1])%2==0) {
				previous="right ";
				System.out.print("right ");
			}
			else {
				System.out.print("left ");
				previous="left ";
			}
			System.out.println(manta[2]*100 + manta[3]*10 + manta[4]);
			num = input.next();
		}
		*/
		//arranging books
		Scanner input=new Scanner(System.in);
		String books = input.next();
		char[] manta = new char[books.length()];
		int smalls=0;
		int mediums=0;
		int larges=0;
		int switches=0;
		int largeM=0;
		int largeS=0;
		int mediumL=0;
		int mediumS=0;
		int smallL=0;
		int smallM=0;
		for(int x=0; x<books.length();x++) {
			manta[x] = books.charAt(x);
			if (manta[x]=='S')
				smalls++;
			else if (manta[x]=='M')
				mediums++;
			else
				larges++;
		}
		for(int x=0;x<larges;x++) {
			if(manta[x]=='M')
				largeM++;
			else if (manta[x]=='S')
				largeS++;
		}
		for(int x=larges;x<larges+mediums;x++) {
			if(manta[x]=='L')
				mediumL++;
			else if (manta[x]=='S')
				mediumS++;
		}
		for(int x=larges+mediums;x<books.length();x++) {
			if(manta[x]=='L')
				smallL++;
			else if (manta[x]=='M')
				smallM++;
		}
		//from mediums in large to large in medium
		if (largeM>mediumL) {
			switches+=mediumL;
			largeM-=mediumL;
			mediumL=0;
		}
		else {
			switches+=largeM;
			mediumL-=largeM;
			largeM=0;
		}
		//from smalls in large to larges in small
		if (largeS>smallL) {
			switches+=smallL;
			largeS-=smallL;
			smallL=0;
		}
		else {
			switches+=largeS;
			smallL-=largeS;
			largeS=0;
		}
		//from smalls in medium to mediums in small
		if (smallM>mediumS) {
			switches+=mediumS;
			smallM-=mediumS;
			mediumS=0;
		}
		else {
			switches+=smallM;
			mediumS-=smallM;
			smallM=0;
		}
		if(largeM>0)
			switches+=2*largeM;
		if(largeS>0)
			switches+=2*largeS;
		System.out.println(switches);
	}
}

