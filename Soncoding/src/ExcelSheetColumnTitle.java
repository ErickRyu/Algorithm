
public class ExcelSheetColumnTitle {
	// Source : https://leetcode.com/problems/excel-sheet-column-title/
	// Author : ErickRyu
	// Date   : 2016-12-13

	
	/*
	 * 
	 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
	 * 
	 * For example:
	 * 
	 * 1 -> A
	 * 2 -> B
	 * 3 -> C
	 * ...
	 * 26 -> Z
	 * 27 -> AA
	 * 28 -> AB 
	 */
	
	/**
	 * Created on 2016/12/13
	 */
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while(n > 0){
        	n--;
        	int r = n%26;
        	res.append((char)('A' + r));
        	n = n/26;
        }
        return res.reverse().toString();
    }
    public static void main(String[] args){
		System.out.println(convertToTitle(29));
	}
}
