package Soncoding._2017_02_23;

public class DetectCapital {
	// Source : https://leetcode.com/problems/detect-capital/
	// Author : ErickRyu
	// Date   : 2017-02-23

	/*
	 *Given a word, you need to judge whether the usage of capitals in it is right or not.
	 *
	 *We define the usage of capitals in a word to be right when one of the following cases holds:
	 *
	 *All letters in this word are capitals, like "USA".
	 *All letters in this word are not capitals, like "leetcode".
	 *Only the first letter in this word is capital if it has more than one letter, like "Google".
	 *Otherwise, we define that this word doesn't use capitals in a right way.
	 *
	 *Example 1:
	 *Input: "USA"
	 *Output: True
	 *
	 *Example 2:
	 *Input: "FlaG"
	 *Output: False
	 *
	 *Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
	 *
	 *Subscribe to see which companies asked this question.
	*/	
	/**
	 * Created on 2017/02/23
	 */
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        if(word.toUpperCase().equals(word))
        	return true;
        if(word.toLowerCase().equals(word))
        	return true;
        if(word.equals(word.substring(0, 1) + word.substring(1).toLowerCase()))
        	return true;
        return false;
	}
    /**
	 * https://discuss.leetcode.com/topic/79930/java-1-liner
	 */
    public static boolean detectCapitalUse_regex(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

}
