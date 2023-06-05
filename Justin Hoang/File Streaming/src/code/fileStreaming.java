package code;

import java.io.File;
import java.util.Scanner;

public class fileStreaming {

	public static void main(String[] args)throws Exception {
		
		// TODO Auto-generated method stub
		File infile = new File("input.txt");
	    Scanner input = new Scanner(infile);
	    int sum =0;
	    int counter=0;
	    while(input.hasNext()) {
	    	sum+=input.nextInt();
	    	counter++;
	    }
	    System.out.println((double)(sum)/counter);
	}

}
