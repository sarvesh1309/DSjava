package com.practice.string;

public class FindNumOfSafeLandSquares {

	public int findNumSafeLand(int[][] array) {
		int length = array.length;
		int[][] visited = new int[length][length];
		int count = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				// find whether there is a safe path from this land squares to
				// outside
				if (array[i][j] == 1 && (findNumSafeLandHelper(array, visited, i, j))) {
					count++;
				}
			}
		}
		return count;

	}

	private boolean findNumSafeLandHelper(int[][] array, int[][] visited, int row, int col) {
		// if current square is sea or already visited then no safe land present
		// .
		if (array[row][col] == 0 || visited[row][col] == 1) {
			return false;
		}
		// if the currnet square is at the border and its not visited and its
		// not sea then it means this is a safe land
		if (row == 0 || (row == array.length - 1) || col == 0 || (col == array.length - 1)) {
			return true;
		}
		// backtrack to all four directions and find is there any safe land path
		// present
		boolean isPathPresent = false;
		visited[row][col] = 1;
		// check all four direction from the currnet square
		isPathPresent = (row > 0 ? findNumSafeLandHelper(array, visited, row - 1, col) : false)
				|| (row < (array.length - 1) ? findNumSafeLandHelper(array, visited, row + 1, col) : false)
				|| (col > 0 ? findNumSafeLandHelper(array, visited, row, col - 1) : false)
				|| (col < (array.length - 1) ? findNumSafeLandHelper(array, visited, row, col + 1) : false);
		visited[row][col] = 0;
		return isPathPresent;
	}

}
