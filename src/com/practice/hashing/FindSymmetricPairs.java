package com.practice.hashing;

import java.util.HashMap;

public class FindSymmetricPairs {

	/**
	 * find symmetric painrs in input like {{1,3},{4,5},{2.6},{3,1}}
	 * 
	 * @param input
	 */
	public void symmetricPairs(int input[][]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i][1]) && (map.get(input[i][1]) == input[i][0])) {
				System.out.println("pair exists for {" + input[i][0] + "," + input[i][1]+"}");
			} else {
				map.put(input[i][0], input[i][1]);
			}
		}
	}

}
