package com.practice.greedy;

import java.util.HashMap;
import java.util.Map;

public class MinDenominationCoinGreedy {

	public void printDenomination(int amount, int[] coins) {

		Map<Integer, Integer> resultSet = new HashMap<>();

		while (amount != 0) {
			// break the moment we find denomination bigger than current amount
			int maxden = 0;
			for (int i = 0; i < coins.length; i++) {
				maxden = coins[i];
				if (maxden > amount) {
					maxden = coins[i - 1];
					break;
				}
			}
			if (maxden == -1) {
				System.out.println("denominations not available");
				return;
			}
			int numOfDeno = amount / maxden;
			resultSet.put(maxden, numOfDeno);
			amount = amount % maxden;

		}

		for (int deno : resultSet.keySet()) {
			System.out.println("deno" + deno + " : count" + resultSet.get(deno));
		}

	}

}
