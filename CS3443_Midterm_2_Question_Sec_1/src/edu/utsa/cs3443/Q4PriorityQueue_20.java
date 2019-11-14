package edu.utsa.cs3443;

import java.util.*;

public class Q4PriorityQueue_20 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 2, 5, 4, 6, 7, 9, 0 };
		int [] res = getKLargestElementsUsingPriorityQueue(nums, 5);

		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + "\t");
	}

	//////////////////////////////////////////////////////////////////////////
	// THIS FUNCTION WORTH 20 POINTS
	/**
	 * This function takes an int array and an integer k
	 * returns k-largest elements
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int [] getKLargestElementsUsingPriorityQueue(int[] nums, int k) {
		System.out.println("Sorting in Descending Order");
		int [] res = new int[k];

		// TODO WRITE YOUR CODE HERE

		// checking user input
		if (nums == null || nums.length == 0 || k <= 0)
			return res;

		//queue
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
			public int compare(Integer node1, Integer node2) { return node2-node1; }
		});

		for (Integer num : nums)
			queue.offer(num);

		//output
		for (int i = 0; i < k; i++)
			res[i]= queue.poll().intValue();

		return res;
	}

}
