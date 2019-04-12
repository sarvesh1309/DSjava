package com.practice.string;

public class isPatternPresentIn2Darray {
	public boolean isPresent(String word, char array[][]) {
		int length = array.length;
		int[][] visited = new int[length][length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (isPresentHelper(word, array, 0, i, j, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isPresentHelper(String word, char array[][], int pos, int row, int col, int[][] visited) {
		System.out.println(row + "- " + col + " - " + array[row][col]);
		if (pos == word.length()) {
			return true;
		}
		if (visited[row][col] == 1) {
			return false;
		}
		if (row == array.length || col == array.length) {
			return false;
		}
		char val = word.charAt(pos);

		if (array[row][col] == val) {
			// char is found for first pos char
			visited[row][col] = 1;
			pos++;
			boolean ischarpresent = false;
			// check 8 neighbours
			ischarpresent = (row > 0 ? isPresentHelper(word, array, pos, row - 1, col, visited) : false)
					|| (row < array.length - 1 ? isPresentHelper(word, array, pos, row + 1, col, visited) : false)
					|| (col > 0 ? isPresentHelper(word, array, pos, row, col - 1, visited) : false)
					|| (col < array.length - 1 ? isPresentHelper(word, array, pos, row, col + 1, visited) : false)
					|| (row > 0 && col > 0 ? isPresentHelper(word, array, pos, row - 1, col - 1, visited) : false)
					|| ((row < array.length - 1 && col > 0)
							? isPresentHelper(word, array, pos, row + 1, col - 1, visited) : false)
					|| ((row > 0 && col < array.length - 1)
							? isPresentHelper(word, array, pos, row - 1, col + 1, visited) : false)
					|| ((row < array.length - 1 && col < array.length - 1)
							? isPresentHelper(word, array, pos, row + 1, col + 1, visited) : false);

			visited[row][col] = 0;
			return ischarpresent;
		} else {
			return false;
		}

	}

}
