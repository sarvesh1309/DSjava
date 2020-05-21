package com.practice.leetcode;

/**
 * leetcode - 44
 * 
 * @author sarveshkumar
 *
 */
public class WildCardSearch {

	public boolean isMatchRecursive(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		boolean firstMatch = !s.isEmpty() && (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0));

		if (p.charAt(0) == '*') {
			return (!s.isEmpty() && isMatchRecursive(s.substring(1), p)) || isMatchRecursive(s, p.substring(1));
		} else {
			return firstMatch && isMatchRecursive(s.substring(1), p.substring(1));
		}

	}

	Result[][] table;

	/**
	 * dynamic programming using top down approach
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatchDPTopDown(String s, String p) {
		table = new Result[s.length() + 1][p.length() + 1];
		return isMatchHelper(0, 0, s, p);
	}

	private enum Result {
		TRUE, FALSE;
	}

	// Dyanamic programming top down approach
	private boolean isMatchHelper(int i, int j, String s, String p) {
		// if this match has alredy been calculated then return from our cache
		// table
		if (table[i][j] != null) {
			return table[i][j] == Result.TRUE;
		}
		// check the length of patter and string
		boolean ans;
		if (p.length() == j) {
			ans = (s.length() == i);
		} else {

			boolean firstMatch = s.length() != i && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));

			if (p.charAt(j) == '*') {
				ans = (s.length() != i && isMatchHelper(i + 1, j, s, p)) || isMatchHelper(i, j + 1, s, p);
			} else {
				ans = firstMatch && isMatchHelper(i + 1, j + 1, s, p);
			}
		}
		table[i][j] = ans ? Result.TRUE : Result.FALSE;

		return ans;

	}

	/**
	 * dynamic programming bottom up approach
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		// remove multiple *
		boolean[][] lookup = new boolean[s.length() + 1][p.length() + 1];
		lookup[0][0] = true;
		int k = 0;
		// for starting * make loop as true . eg for patter *****
		while (k < p.length() && p.charAt(k) == '*') {
			lookup[0][k + 1] = true;
			k++;
		}
		// starting i and j from 1 as first i =0 row point to empty string and p
		// =0 point to empty pattern
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) == '*') {
					lookup[i][j] = lookup[i - 1][j] || lookup[i][j - 1];
				} else if (p.charAt(j - 1) == '?' || (p.charAt(j - 1) == s.charAt(i - 1))) {
					lookup[i][j] = lookup[i - 1][j - 1];
				} else {
					lookup[i][j] = false;
				}
			}
		}
		return lookup[s.length()][p.length()];

	}
	
	public int isMatchDIff(final String A, final String B) {
	       boolean [][]dp = new boolean[A.length()+1][B.length()+1];
	       // making entry as true for empty pattern
	       dp[0][0] = true;
	       // for * empty source pattern match would be true otherwise false
	       int k =1;
	       while(k <= B.length() && B.charAt(k-1) =='*'){
	           dp[0][k-1] =true;
	           k++;
	       }
	       for(int i =1;i<=A.length();i++){
	           for(int j =1;j<=B.length();j++){
	              if(B.charAt(j-1) == A.charAt(i-1) || B.charAt(j-1) == '?'){
	                  dp[i][j] = dp[i-1][j-1];
	              }else if(B.charAt(j-1) == '*'){
	                  dp[i][j] = dp[i-1][j] || dp[i][j-1];
	              }
	           }
	       }
	      
	      // System.out.println(dp[A.length()][B.length()]);
	       return (dp[A.length()][B.length()] == true ? 1: 0 );
	    }
	    

}
