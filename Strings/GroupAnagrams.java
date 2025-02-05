/**
 * GroupAnagrams
 */
import java.util.*;
public class GroupAnagrams {

	public static List<List<String>> solution1(String[] strs){
		List <List<String>> output = new ArrayList<>();
		List <Integer> track = new ArrayList<>();
		
		for(int i=0; i<strs.length; i++){
			if(track.contains(i))
				continue;
			List <String> anagrams = new ArrayList<>();
			anagrams.add(strs[i]);
			String s1 = sortString(strs[i]);
			
			for(int j=i+1; j<strs.length; j++){
				String s2 = sortString(strs[j]);
				if(s1.equals(s2)){
					anagrams.add(strs[j]);
					track.add(j);
				}
			}
			output.add(anagrams);
		}
		return output;

	}

	public static String sortString(String str){
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray); 
	}

	public static void main(String[] args) {
		System.out.println("Group Anagrams");

		// System.out.println(sortString("nimra"));

		// String[] strs = {"eat","tea","tan","ate","nat","bat"};
		// String[] strs = {"eat" , "cars", "tea", "scar", "a"};
		// String[] strs = {"a"};
		String[] strs = {""};
		System.out.println(solution1(strs));
	}
}