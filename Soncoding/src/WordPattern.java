import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	// Source : https://leetcode.com/problems/word-pattern/
	// Author : ErickRyu
	// Date   : 2016-12-06
	
	/*
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
	 * 
	 * Examples:
	 * pattern = "abba", str = "dog cat cat dog" should return true.
	 * pattern = "abba", str = "dog cat cat fish" should return false.
	 * pattern = "aaaa", str = "dog cat cat dog" should return false.
	 * pattern = "abba", str = "dog dog dog dog" should return false.
	 * Notes:
	 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
	 */
	
	
	
	/**
	 * Created on 2016/12/07
	 */
   public static boolean wordPattern(String pattern, String str) {
	   HashMap<String, Integer> patternMap = new HashMap<>();
	   char[] patternArr = pattern.toCharArray();
	   String[] strArr = str.split(" ");
	   String[] patternStore = new String[26];
	   if(strArr.length != patternArr.length) return false;
	   for(int i = 0; i < patternArr.length; i++){
		   int index = patternArr[i] - 'a';
		   if(patternStore[index] == null){
			   patternStore[index] = strArr[i];
			   if(!patternMap.containsKey(strArr[i])){
				   patternMap.put(strArr[i], index);
			   }else if (patternMap.get(strArr[i]) != index){
				   return false;
			   }
		   }else{
			   if(!patternStore[index].equals(strArr[i]))
				   return false;
		   }
	   }
	   
	   return true;
   }
   
   //https://discuss.leetcode.com/topic/26339/8-lines-simple-java
   public static boolean wordPattern2(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}
	public static void main(String[] args){
		String[] testPattern = {"abba", "abba", "aaaa", "azza"};
		String[] testStr = {"dog cat cat dog", "dog cat cat fish", "dog cat cat dog", "dog dog dog dog"};
		boolean[] testAnswer = {true, false, false, false};
		for(int i = 0; i< 4; i++){
			System.out.print("#TestCase " + (i + 1) + " : ");
			System.out.println(wordPattern2(testPattern[i], testStr[i]) == testAnswer[i]);
		}
		
	}
}
