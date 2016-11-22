
public class IslandPerimeter {
// Source : https://leetcode.com/problems/island-perimeter/
// Author : ErickRyu
// Date   : 2016-11-22

/*
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
 * Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter of the island.
 * 
 * Example:
 * 
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * 
 * Answer: 16
 */
	/**
	 * Created on 2016/11/22
	 */
	
	static final int[] Dy = {-1, 0};
	static final int[] Dx = {0, -1};
	
	public static void main(String[] args){
		int[][] testGrid = {
				{0,1,0,0},
				{1,1,1,0},
				{0,1,0,0},
				{1,1,0,0}
		};
		int res = islandPerimeter(testGrid);
		System.out.println(res);
	}
    public static int islandPerimeter(int[][] grid) {
    	int result = 0;
    	int yLen = grid.length;
    	int xLen = grid[0].length;
    	for(int y = 0; y < yLen; y++){
    		for(int x = 0; x < xLen; x++){
    			int nextY, nextX;
    			if(grid[y][x] == 1){		// If this cell is island
    				result += 4;
    				for(int i = 0; i < 2; i++){
    					nextY = y + Dy[i];
    					nextX = x + Dx[i];
    					if(nextY < 0 || nextX < 0 || grid[nextY][nextX] == 0) continue;
    					if(grid[nextY][nextX] == 1)
    						result -= 2;
    				}
    			}
    		}
    	}
    	
    	return result;
    }
	
}
