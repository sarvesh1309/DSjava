package com.practice.string;

public class StringOperation {

	/**
	 * use xor operation for swap operation without using tmp variable
	 * 
	 * @param input
	 * @return
	 */
	public String reverseString(String input) {
		int end = input.length() - 1;
		int start = 0;
		char ch[] = input.toCharArray();
		while (start < end) {
			ch[start] = (char) (ch[start] ^ ch[end]);
			ch[end] = (char) (ch[end] ^ ch[start]);
			ch[start] = (char) (ch[end] ^ ch[start]);
			start++;
			end--;
		}
		return String.valueOf(ch);

	}

	public String removeAdjChar(String input) {
		input = removeAdj(input, true);
		return input;

	}

	public void removeAdjCh(String input) {
		removeAdjCharAlt(input.toCharArray());
	}

	public void removeAdjCharAlt(char ch[]) {
		int j = 0;
		for (int i = 1; i < ch.length; i++) {
			while (ch[i] == ch[j] && j >= 0) {
				i++;
				j--;
			}
			ch[++j] = ch[i];
		}
		String str = String.valueOf(ch);
		System.out.println(j);
		System.out.println(str.substring(0,j+1));

	}

	private String removeAdj(String str, boolean flag) {
		if (flag) {
			int i = 0;
			flag = false;
			while (i < str.length() - 1) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					flag = true;
					String tempstr = str.substring(0, i);
					if ((i + 2) < str.length()) {
						tempstr = tempstr + str.substring((i + 2), str.length());
					}
					str = removeAdj(tempstr, flag);
				}
				i++;
			}
		}
		return str;

	}

}
