package code;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSkillBuilding {
	
	public static int hashcode(String word) {
		int value=0;
		for (int x=0; x<word.length();x++) 
			value+=(int)(word.charAt(x)*Math.pow(2,x));
		return value;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		/*
		File female = new File("femaleNames.txt");
		File male = new File("maleNames.txt");
		File last = new File("lastNames.txt");
		Scanner input;
		int name=0;
		for(int y=0;y<10;y++) {
			if(Math.random()<0.5) {
				name = (int)(Math.random()*20);
				input = new Scanner(female);
				for(int x=0;x<name;x++) 
					input.next();
				System.out.print(input.next() + " ");
			}
			else {
				name = (int)(Math.random()*20);
				input = new Scanner(male);
				for(int x=0;x<name;x++) 
					input.next();
				System.out.print(input.next() + " ");
			}
			name = (int)(Math.random()*20);
			input = new Scanner(last);
			for(int x=0;x<name;x++) 
				input.next();
			System.out.println(input.next());
		}
		*/
		File text = new File("book.txt");
		Scanner input = new Scanner(text);
		boolean valid=true;
		String[][] hashtable = new String[30000][9000];
		int hashcode;
		int position;
		String word;
		while(input.hasNext()) {
			word = input.next();
			//check length
			if(word.length()<3 || word.length()>6)
				continue;
			//no punctuation or capitals
			for(int x=0; x<word.length(); x++) {
				valid=true;
				if((int)(word.charAt(x))<=96 || (int)(word.charAt(x))>=123) {
					valid=false;
					break;
				}
			}
			if(valid==false)
				continue;
			//hashcode
			hashcode = hashcode(word);
			position=0;
			//finding next available position
			while(hashtable[position][hashcode]!=null) {
				position++;
			}
			valid = true;
			//checking if the word has been seen before in the hash table in the column
			for(int x=0; x<position;x++) {
				if(hashtable[x][hashcode].equals(word)) {
					valid=false;
					break;
				}
			}
			if(valid==true)
				hashtable[position][hashcode] = word;
		}
		PrintWriter pw = new PrintWriter( new File("dictionary.txt") );
		for(int x=0; x<9000;x++) 
			for(int y=0; y<30000;y++)
				if(hashtable[y][x]!=null)
					pw.println(hashtable[y][x]);
        pw.close();
	}

}
