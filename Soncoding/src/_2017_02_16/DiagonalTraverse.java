package _2017_02_16;

public class DiagonalTraverse {
	// Source : https://leetcode.com/problems/find-largest-value-in-each-tree-row/?tab=Solutions
	// Author : ErickRyu
	// Date   : 2017-02-16

	/*
	 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
	 * 
	 * Example:
	 * Input:
	 * [
	 *  [ 1, 2, 3 ],
	 *  [ 4, 5, 6 ],
	 *  [ 7, 8, 9 ]
	 * ]
	 * Output:  [1,2,4,7,5,3,6,8,9]
	 * 
	 * Note:
	 * The total number of elements of the given matrix will not exceed 10,000.
	 * Subscribe to see which companies asked this question.
	 */	
	/**
	 * Created on 2017/02/16
	 */
	
    public int[] findDiagonalOrder(int[][] matrix) {
    	if(matrix.length == 0) return new int[0];
    	if(matrix[0].length == 0) return new int[0];
    	
    	int rowSize = matrix.length;
    	int colSize = matrix[0].length;
    	int[] diagonalOrderRes = new int[rowSize*colSize];
    	int row = 0, col = 0;
    	for(int i = 0; i < diagonalOrderRes.length; i++){
    		diagonalOrderRes[i] = matrix[row][col];
    		if((row+col)%2 == 0){
    			row--; col++;
    		}else{
    			row++; col--;
    		}
    		if(row == rowSize){
    			row--;
    			col += 2;
    		}else if(col == colSize){
    			col--;
    			row += 2;
    		}else if(col == -1){
    			col++;
    		}else if(row == -1){
    			row++;
    		}
    	}
    	return diagonalOrderRes;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
