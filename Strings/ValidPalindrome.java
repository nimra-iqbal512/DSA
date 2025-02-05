public class ValidPalindrome {

	public static boolean solution1(String s){
		// Converting to lowercase
		String lowerCaseStr = s.toLowerCase();

		// Removing all non alphanumeric characters from string
		// Alphanumeric characters only include letters and numbers
		String alphanumericStr = lowerCaseStr.replaceAll("[^a-z0-9]", "");	//The regular expression matches any character that is not a lowercase alphabet or digit, and replace it with empty string("").

		
		if(alphanumericStr == null){
			return false;
		}

		int start = 0;
		int end = alphanumericStr.length()-1;
		while (start < end) {
			if(alphanumericStr.charAt(start) != alphanumericStr.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;

		// TC =  0(n) + 0(n) + 0(m) = 0(n); Its total 0(n), because 0(n) > 0(m)
		// 0(n) for toLowerCase(), 0(n) for replaceAll(), 0(m) to check plaindrome, where n is the length of String 's', and m is the length of String 'alphanumericStr'.
		// I think the TC to check palindrome, instead of 0(m) should be 0(n), becuase ther is no huge diffrenece between the length of String 'lowerCaseStr' and String 'alphanumericStr'. But 0(m) yada behtar hai.. 😀

		// SC = 0(n) + 0(n) = 0(n)
		// 0(n) for String 'lowerCaseStr', 0(n) for String 'alphanumericStr'

	}


	public static boolean solution2(String s){

		int start = 0;
		int end = s.length()-1;
		while(start < end){
			// Move start pointer to next alphanumeric character
			while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
				start++;
			}
			
			// Move last pointer to previous alphanumeric character
			while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
				end--;
			}

			if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
				return false;
			}

			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		// System.out.println("Valid Palindrome");

		// String s1 = "A man, a plan, a canal: Panama";
		// String s1 = "race a car";
		String s1 = "c iv ic";
		// String s1 = " ";

		System.out.println(solution1(s1));
		System.out.println(solution2(s1));
	}
}
