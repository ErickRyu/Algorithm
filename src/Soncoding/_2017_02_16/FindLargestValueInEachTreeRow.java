package Soncoding._2017_02_16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
	// Source : https://leetcode.com/problems/find-largest-value-in-each-tree-row/?tab=Solutions
	// Author : ErickRyu
	// Date   : 2017-02-16

	/*
	 * You need to find the largest value in each row of a binary tree.
	 * 
	 * Example:
	 * Input: 
	 * 
	 *           1
	 *          / \
	 *         3   2
	 *        / \   \
	 *       5   3   9 
	 *       
	 * Output: [1, 3, 9]
	 */	
	/**
	 * Created on 2017/02/16
	 */
	
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> largestVals = new ArrayList<>();
        if(root == null)return largestVals;
        queue.add(root);
        int queueSize = queue.size();
        while(!queue.isEmpty()){
        	int max = Integer.MIN_VALUE;
        	for(int i = 0; i < queueSize; i++){
        		TreeNode myNode = queue.poll();
        		max = Math.max(max, myNode.val);
        		if(myNode.left != null) queue.add(myNode.left);
        		if(myNode.right != null) queue.add(myNode.right);
        	}
        	largestVals.add(max);
        	queueSize = queue.size();
        }
        return largestVals;
    }
	
    public class TreeNode {
   	 int val;
   	 TreeNode left;
   	 TreeNode right;
   	 TreeNode(int x) { val = x; }
    }
}
