package com.practice.leetcode;

/**
 * QS - 1034
 * 
 * @author sarveshkumar
 *
 */
public class ColorBoundaryConnectedComponent {
	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] visited = new int[row][col];
		int dir[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int originalColor = grid[r0][c0];
		colorBorderHelper(grid, r0, c0, color, visited, dir, originalColor);
		return grid;
	}

	public int colorBorderHelper(int[][] grid, int r0, int c0, int color, int[][] visited, int dir[][],
			int originalColor) {
		int row = grid.length;
		int col = grid[0].length;
		if (r0 < 0 || r0 == row || c0 < 0 || c0 == col) {
			return 0;
		}
		// already visited it means surrouded by same color square so return 0
		if (visited[r0][c0] == 1) {
			return 1;
		}
		// surrounded by diff color so return 0
		if (grid[r0][c0] != originalColor) {
			return 0;
		}
		visited[r0][c0] = 1;
		// initially assume as this square is surrounded by same color
		int isBorderSquare = 1;
		for (int[] d : dir) {
			// even if from one side it is not surrounded then this is a border
			// square and color it
			if (colorBorderHelper(grid, r0 + d[0], c0 + d[1], color, visited, dir, originalColor) == 0) {
				isBorderSquare = 0;
			}
		}
		if (isBorderSquare == 0) {
			grid[r0][c0] = color;
		}
		// return 1 as calling square is surrounded by this same color border
		return 1;

	}

}
