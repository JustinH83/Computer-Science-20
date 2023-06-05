package code;

public class RNG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 15;
		int min  = 5;
		double number = Math.random()*(max-min+1);
		System.out.println((int)(number) + min);
	}

}