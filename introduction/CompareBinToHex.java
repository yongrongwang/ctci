package introduction;

public class CompareBinToHex {
	public static int charToInt(char c) {
		int n = -1;
		if (c >= '0' && c <= '9')
			n =  c - '0';
		if (c >= 'a' && c <= 'f')
			n =  c - 'a' + 10;
		if (c >= 'A' && c <= 'F')
			n =  c - 'A' + 10;
		return n;
	}
	
	public static int convertToBase(String number, int base) {
		if (base < 2 || (base > 10 && base != 16))
			return -1;
		int value = 0;
		for (int i = number.length() - 1; i >= 0; i--) {
			char c = number.charAt(i);
			int n = charToInt(c);
			if (n < 0 || n >= base)
				return -1;
			int exp = number.length() - 1 - i;
			value += n * Math.pow(base, exp);
		}
		return value;
	}
	

	public static boolean compareBinToHex(String bin, String hex) {
		int n1 = convertToBase(bin, 2);
		int n2 = convertToBase(hex, 16);
		if (n1 < 0 || n2 < 0)
			return false;
		return n1 == n2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareBinToHex("111001011", "1CB"));
	}

}
