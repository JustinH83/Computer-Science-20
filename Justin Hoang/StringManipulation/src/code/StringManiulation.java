package code;

import java.util.Scanner;

public class StringManiulation {
	
	public static int getLength(String st) {
		return st.length();
	}
//This method returns the number of times a char, ch, appears in the String, st
	public static int letterCount(String st, char ch){
		int counter=0;
		for(int x=0; x<st.length();x++)
			if(st.charAt(x)==ch)
				counter++;
		return counter;
	}
//This method returns the reverse of the String, st
	public static String reverse(String st) {
		char[] word = new char[st.length()];
		char[] reverse = new char[st.length()];
		for(int x=0; x<st.length();x++) 
			word[x] = st.charAt(x);
		for(int x=0; x<st.length();x++) 
			reverse[x] = word[st.length()-1-x];
		String reversed ="";
		for(int x=0; x<st.length();x++)
			reversed+=reverse[x];
		return reversed;
	}
//This method returns true if st1 and st2 are anagrams of each other.
//If they are not anagrams, it returns false
//The method is case sensitive
	public static boolean isAnagram(String st1, String st2){
		boolean anagram =true;
		boolean contains =false;
		char[] string1 = new char[st1.length()];
		char[] string2 = new char[st2.length()];
		if(st1.length()!=st2.length())
			return false;
		for(int x=0; x<st1.length();x++)
			string1[x] = st1.charAt(x);
		for(int x=0; x<st1.length();x++)
			string2[x] = st2.charAt(x);
		for(int x=0; x<st1.length();x++) {
			contains=false;
			for(int y=0; y<st2.length();y++) {
				if(string1[x]==string2[y]) {
					string2[y]=' ';
					contains=true;
					break;
				}
			}
			if(contains==false)
				return false;
		}
		return anagram;
	}
/*This method will return the pig latin version of a word. The pig latin
version of a word is found by moving the first letter of the word to the
end of the word and then adding "ay" to it.
Example: Robin = obinRay;
Example: Raven = avenRay
Example: Cyborg = yborgCay;
*/
	public static String pigLatin(String st) {
		char[] pigLatin = new char[st.length()];
		for (int x=0; x<st.length();x++) 
			pigLatin[x] = st.charAt(x);
		char first = pigLatin[0];
		for(int x=0; x<st.length()-1;x++)
			pigLatin[x] = pigLatin[x+1];
		pigLatin[st.length()-1] = first;
		char[] manta = new char[st.length()+2];
		for (int x=0; x<st.length();x++) 
			manta[x] = pigLatin[x];
		manta[st.length()] ='a';
		manta[st.length()+1]='y';
		String pig = "";
		for (int x=0; x<manta.length;x++)
			pig+=manta[x];
		return pig;
	}
/*This method will remove all duplicate characters from a String so that it
is only made of unique characters. You can assume all characters in the String
will have ASCII values between 32 and 126 (inclusive)
Sample Input:
banana
Sample Output:
ban
*/
	public static String removeDuplicates(String st) {
		char[] manta = new char[st.length()];
		char[] seen = new char[st.length()];
		for (int x=0; x<st.length();x++) 
			manta[x] = st.charAt(x);
		for(int x=0; x<st.length();x++) {
			boolean in=false;
			for (int y=0; y<seen.length;y++) {
				if(manta[x]==seen[y])
					in=true;
			}
			if(in==true)
				manta[x] = ' ';
			else
				seen[x]=manta[x];
		}
		String done = "";
		for(int x=0; x<st.length();x++) {
			if(manta[x]!=32)
				done+=manta[x];
		}
		return done;
	}
/*The following method takes a string of 1's and 0's and compresses it by
making a new string in the following way:
1. The new string will start with the first character (either 1 or 0) in the
string
2. The next character will be a number showing how many of that digit appeared
in a row before the opposite digit appeared.
3. The next character will be a number showing how many of the opposite digit
appeared in a row before the first digit appeared again.
4. Go to step 2 and keep repeating until the whole string is compressed.
Sample input: 111111111111000000001111111110000110001111000
Sample output: 1 12 8 9 4 2 3 4 3
*/
	public static void compression(String st) {
		char[] manta = new char[st.length()];
		for (int x=0; x<st.length();x++)
			manta[x] = st.charAt(x);
		int counter=0;
		System.out.print(manta[0]+"  ");
		while(counter<st.length()) {
			int amount=0;
			char first = manta[counter];
			while(manta[counter]==first) {
				amount++;
				counter++;
				if(counter>=st.length())
					break;
			}
			System.out.print(amount + "  ");
		}
	}


//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
/////////////////////////////////////////
//DO NOT EDIT ANY CODE BELOW THIS LINE!//
/////////////////////////////////////////
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testNumber = input.nextInt();
		if(testNumber == 1){
			String st = input.next();
			System.out.println( getLength(st) );
		}
		else if(testNumber == 2){
			String st = input.next();
			System.out.println( letterCount(st, 'p'));
			System.out.println( letterCount(st, 'b'));
			System.out.println( letterCount(st, 'a'));
		}
		else if(testNumber == 3){
			String st = input.next();
			System.out.println( reverse(st) );
		}
		else if(testNumber == 4){
			String s1 = input.next();
			String s2 = input.next();
			System.out.println( isAnagram(s1, s2) );
		}
		else if(testNumber == 5){
			String st = input.next();
			System.out.println( pigLatin(st) );
		}
		else if (testNumber == 6){
			String st = input.next();
			System.out.println( removeDuplicates(st) );
		}
		else if(testNumber == 7){
			String st = input.next();
			compression(st);
		}



	}
}
