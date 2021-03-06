package Soncoding;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Heaters {
	// Source : https://leetcode.com/problems/heaters/
	// Author : ErickRyu
	// Date   : 2016-12-13

	
	/*
	 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
	 * 
	 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
	 * 
	 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
	 * 
	 * Note:
	 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
	 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
	 * As long as a house is in the heaters' warm radius range, it can be warmed.
	 * All the heaters follow your radius standard and the warm radius will the same.
	 * Example 1:
	 * Input: [1,2,3],[2]
	 * Output: 1
	 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
	 * 
	 * Example 2:
	 * Input: [1,2,3,4],[1,4]
	 * Output: 1
	 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
	 */
	
	
	/**
	 * Created on 2016/12/14
	 */
	public static int findRadiusTreeSet(int[] houses, int[] heaters) {
		int max = -1;
		TreeSet<Integer> heatersTreeSet = new TreeSet<>(Arrays.stream(heaters).boxed().collect( Collectors.toList() ) );
		for(int house : houses){
			int floor = Integer.MAX_VALUE, ceiling = Integer.MAX_VALUE;
			if(heatersTreeSet.floor(house) != null)
			    floor = heatersTreeSet.floor(house);
			if(heatersTreeSet.ceiling(house) != null)
				ceiling = heatersTreeSet.ceiling(house);
			
			int dist1 = Math.abs(house - floor);
			int dist2 = Math.abs(house - ceiling);
			int dist = Math.min(dist1, dist2);
			max = Math.max(dist, max);
		}
		return max;
	}
	/**
	 * Created on 2016/12/13
	 */
	public static int findRadius(int[] houses, int[] heaters) {
		int max = -1;
		Arrays.sort(heaters);
		for(int house : houses){
			max = Math.max(max, binarySearch(heaters, house));
		}
		return max;
	}
	public static int binarySearch(int[] heaters, int house){
		int l = 0, r = heaters.length-1;
		int max = 987654321;
		int near = max;
		
		while(l <= r){
			int mid = (l + r)/2;
			int dist = Math.abs(heaters[mid] - house);
			if(dist < near)
				near = dist;
			if(heaters[mid] < house)
				l = mid + 1;
			else
				r = mid -1;
			}
		return near;
	}
	public static void main(String[] args){
		int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
		int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
		
//		int[] houses = {1, 2, 3, 4};
//		int[] heaters = {1, 4};
		System.out.println(findRadius(houses, heaters));
		System.out.println(findRadiusTreeSet(houses,heaters));
	}
}
