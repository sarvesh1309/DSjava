package com.practice.string;

public class WildCardSearch {

	public static boolean wildCardMatch(String input, String pattern) {
		if (pattern.length() > input.length()) {
			return false;
		}
		return wildCardMatchHelper(input, 0, pattern, 0);

	}

	private static boolean wildCardMatchHelper(String input, int inIndex, String pattern, int pattIndex) {
		// if all char of pattern has match with the input string then its
		// pattern match
		if(pattIndex== pattern.length() && inIndex==input.length()) {
            return true;
		}
		if (inIndex == input.length()) {
			return false;
		}
		// * case - if there is no char next to * then return true otherwise
		// iterate through input sting till we find a match
		// for next char
		if (pattern.charAt(pattIndex) == '*') {
			// * is not the last char then iterate over input char till we find
			// next char from pattern
			if ((pattIndex + 1) != pattern.length()) {
				if (input.charAt(inIndex) != pattern.charAt(pattIndex + 1)) {
					return wildCardMatchHelper(input, (inIndex + 1), pattern, pattIndex);
				} else {
					return wildCardMatchHelper(input, inIndex, pattern, (pattIndex + 1));
				}
			} else {
				return true;
			}
		}
		// for ? move to next pattern char and input char to match
		if (pattern.charAt(pattIndex) == '?') {
			return wildCardMatchHelper(input, (inIndex + 1), pattern, (pattIndex + 1));
		}
		if (pattern.charAt(pattIndex) != input.charAt(inIndex)) {
			return false;
		}
		return wildCardMatchHelper(input, (inIndex + 1), pattern, (pattIndex + 1));

	}
	
	
	public boolean wildCardMatchItrration(String input, String pattern){
		if(input.isEmpty() && pattern.isEmpty()){
			return true;
		}
		if (pattern.length() > input.length()) {
			return false;
		}
		int i=0,j=0;
		for(;i<input.length()&& j<pattern.length();){
			if(pattern.charAt(j)=='*'){
				// * is not the last char
				if(j+1!=pattern.length()){
					// increment the index at input string till the next char of pattern does not match with input char 
					if(input.charAt(i)!=pattern.charAt(j+1)){
						i++;
					}else{
						j++;
					}
				}else{
					return true;
				}
			}
           if(pattern.charAt(j)=='?'){
				i++;j++;continue;
			}
           if(pattern.charAt(j)!=input.charAt(i)){
        	   return false;
           }else{
        	   i++;
        	   j++;
           }
		}
		// index of pattern is not at the same pos of index of input
		if(j==pattern.length() && i==input.length()){
			return true;
		}
		return false;
		
	}

}
