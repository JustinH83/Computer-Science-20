package code;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class textTwister {
	public static boolean canMake (String w, String l) {
		char[] word = w.toCharArray();
		char[] letters = l.toCharArray();
		for(int y=0; y<letters.length;y++) 
			for(int x=0; x<word.length;x++) 
				if(word[x]==letters[y]) {
					word[x]=' ';
					letters[y] =' ';
					break;
				}
		for(int x=0; x<word.length;x++) 
			if(word[x]!=' ') 
				return false;
		return true;
	}
	public static void enter(String w)throws Exception {
		char[] word = w.toCharArray();
		Robot keyboard = new Robot();
		for(int x=0; x<word.length;x++) {
			char letter = word[x];
			if(letter == 'a') keyboard.keyPress(KeyEvent.VK_A);
			else if(letter == 'b') keyboard.keyPress(KeyEvent.VK_B);
			else if(letter == 'c') keyboard.keyPress(KeyEvent.VK_C);
			else if(letter == 'd') keyboard.keyPress(KeyEvent.VK_D);
			else if(letter == 'e') keyboard.keyPress(KeyEvent.VK_E);
			else if(letter == 'f') keyboard.keyPress(KeyEvent.VK_F);
			else if(letter == 'c') keyboard.keyPress(KeyEvent.VK_G);
			else if(letter == 'h') keyboard.keyPress(KeyEvent.VK_H);
			else if(letter == 'i') keyboard.keyPress(KeyEvent.VK_I);
			else if(letter == 'j') keyboard.keyPress(KeyEvent.VK_J);
			else if(letter == 'k') keyboard.keyPress(KeyEvent.VK_K);
			else if(letter == 'l') keyboard.keyPress(KeyEvent.VK_L);
			else if(letter == 'm') keyboard.keyPress(KeyEvent.VK_M);
			else if(letter == 'n') keyboard.keyPress(KeyEvent.VK_N);
			else if(letter == 'o') keyboard.keyPress(KeyEvent.VK_O);
			else if(letter == 'p') keyboard.keyPress(KeyEvent.VK_P);
			else if(letter == 'q') keyboard.keyPress(KeyEvent.VK_Q);
			else if(letter == 'r') keyboard.keyPress(KeyEvent.VK_R);
			else if(letter == 's') keyboard.keyPress(KeyEvent.VK_S);
			else if(letter == 't') keyboard.keyPress(KeyEvent.VK_T);
			else if(letter == 'u') keyboard.keyPress(KeyEvent.VK_U);
			else if(letter == 'v') keyboard.keyPress(KeyEvent.VK_V);
			else if(letter == 'w') keyboard.keyPress(KeyEvent.VK_W);
			else if(letter == 'x') keyboard.keyPress(KeyEvent.VK_X);
			else if(letter == 'y') keyboard.keyPress(KeyEvent.VK_Y);
			else keyboard.keyPress(KeyEvent.VK_Z);
		}
		keyboard.keyPress(KeyEvent.VK_ENTER);
	}

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String letters = input.next();
		File infile = new File("dictionary.txt");
		input = new Scanner(infile);
        while(input.hasNext()) {
            String word = input.nextLine();
            if(canMake(word, letters)) {
            	enter(word);
            }
        }
        
	}

}
