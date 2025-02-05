// The program has to return the length of largest substring without repeating characters

import java.util.HashSet;
import java.util.HashMap;

public class LargestSubstring {

	public static int solution1(String str){
		// Brute Force Appproach

		int maxLen = 0;

		for(int i=0; i<str.length(); i++){

			for(int j=i; j<str.length(); j++){
				if(isUnique(str, i, j)){
					maxLen = Math.max(maxLen, j-i+1);
				}
			}
		}

		return maxLen;

		// TC = 0(n^3), SC = 0(1)
	}

	public static boolean isUnique(String str, int start, int end){
		boolean[] characters = new boolean[256];

		for(int i=start; i<=end; i++){

			int currentChar = str.charAt(i); //ASCII Code of current character will be stored in 'currentChar'

			if(characters[currentChar]){
				return false; //not a unique substring
			}

			characters[currentChar] = true;
		}
		return true;
		
	}
	
	public static int solution2(String str){
		// Brute Force Solution

		int maxLen = 0;

		outer:
		for(int i=0; i<str.length(); i++){
			HashSet<Character> charSet = new HashSet<>();
			// int length = 0;
		
			for(int j=i; j<str.length(); j++){
				char currentChar = str.charAt(j);

				if(charSet.contains(currentChar)){
					break;
				}
				charSet.add(currentChar);
				
				// length++;
				int length = j-i+1;
				maxLen = Math.max(maxLen, length);

				// If once we reach to the end of string, then no need more iterations
				if(j == str.length()-1){
					break outer;
				}
			}
			// maxLen = Math.max(maxLen, length);
		}
		
		return maxLen;

		// TC = 0(n^2), SC = 0(n), SC is 0(n) bcoz in worst case scenario, HashSet can store upmost n elements

		// If we use ArrayList instead of HashSet, the TC would be 0(n^3) due to contains().
		// bcoz for HashSet, operations like add(), remove(), contains() TC of 0(1)
		// And for ArrayList, operations like add(), remove(), contains() TC of 0(n)
	}

	public static int solution3(String str){
		// Brute Force Solution

		int maxLen = 0;

		outer:
		for(int i=0; i<str.length(); i++){
			
			int[] hashArray = new int[256]; //Array of size 256 initialized with 0
			int length = 0;
		
			for(int j=i; j<str.length(); j++){
				char currentChar = str.charAt(j);

				if(hashArray[currentChar] == 1){
					break;
				}
				hashArray[currentChar] = 1;
				length++;
				maxLen = Math.max(maxLen, length);

				if(j == str.length()-1){
					break outer;
				}
			}
		}
		
		return maxLen;

		// TC = 0(n^2), SC = 0(1)
	}

	public static int solution4(String str){

		// Efficient than previous solutions

		int maxLen = 0;
		HashMap<Character, Integer> hashMap = new HashMap<>();

		int leftPtr = 0, rightPtr = 0;
		while(rightPtr < str.length()){
			char currentChar = str.charAt(rightPtr);

			if(hashMap.containsKey(currentChar)){			
				if(hashMap.get(currentChar) >= leftPtr){  //left pointer will only be updated if previousIndex comes between the two pointers(inclusive)
					// If purpose of this 'condition' is not understandable, then dry run the example 'cadbzabcd' without 'if' condition, and notice at iteration when 'currentChar' is second 'c'
					leftPtr = hashMap.get(currentChar) + 1;
				}
				hashMap.replace(currentChar, rightPtr);
			}else{
				hashMap.put(currentChar, rightPtr);
			}
			
			maxLen = Math.max(maxLen, rightPtr-leftPtr+1);
			rightPtr++;
		}

		return maxLen;

		// TC = 0(n), SC = 0(n)
	}

	public static int solution5(String str){
		int maxLen = 0;

		int[] arr = new int[256];
		for(int i=0; i<arr.length; i++){
			arr[i] = -1;
		}

		int left = 0, right = 0;
		while (right < str.length()) {
			int currentChar = str.charAt(right);
			if(arr[currentChar] != -1){
				if(arr[currentChar] >= left){
					left = arr[currentChar]+1;
				}
			}

			maxLen = Math.max(maxLen, right-left+1);
			arr[currentChar] = right;
			right++;
		}

		return maxLen;

		// TC = 0(n), SC = 0(1)
	}



	public static void main(String[] args) {
		System.out.println("Length of largest Substring without repeating characters");

		// String str = "cadbzabcd";
		// String str = "abcabcbb";
		// String str = "bbbbb";
		String str = "pwwkew";
		System.out.println(solution1(str));
		System.out.println(solution2(str));
		System.out.println(solution3(str));
		System.out.println(solution4(str));
		System.out.println(solution5(str));
	}
	
}
