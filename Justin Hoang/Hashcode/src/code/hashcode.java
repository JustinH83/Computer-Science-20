package code;

public class hashcode {
	public static int hashcode(String word) {
		int value=0;
		for (int x=0; x<word.length();x++) 
			value+=(int)(word.charAt(x)*Math.pow(5,x));
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hashcode("abc"));
	}

}
