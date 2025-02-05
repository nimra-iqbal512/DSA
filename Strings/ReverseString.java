public class ReverseString {

	public static void solution1(char[] s){
		if(s == null || s.length <= 1){
			return;
		}

		char[] temp = new char[s.length];

		for(int i=s.length-1; i>=0; i--){
			temp[s.length - 1 - i] = s[i];
		}

		for(int i=0; i<s.length; i++){
			s[i] = temp[i];
		}

		System.out.println(s);

		// TC = 0(n)
		// SC = 0(n)
	}


	public static void solution2(char[] s){
		// This optimal solution uses 2 pointer approach

		if(s == null || s.length <= 1){
			return;
		}
		int start = 0;
		int end = s.length-1;
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;

			start++;
			end--;
		}

		System.out.println(s);

		// TC = 0(n)
		// SC = 0(1)
	}

	public static void main(String[] args) {
		char[] s = "Hello World".toCharArray();
		solution1(s);
		solution2(s);
	}
}