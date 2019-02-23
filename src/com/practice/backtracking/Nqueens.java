package com.practice.backtracking;

public class Nqueens {

	public static void main(String[] args) {
		Nqueens nq = new Nqueens();
		nq.queen();
	}

	void queen() {
		Board b = new Board(4);
	 // System.out.println(b.isSafe(0, 0));
		queenHelper(b, 0);
		}

	void queenHelper(Board b,int col ) {
		System.out.println();
		if(b.size <=col) {
			b.printBoard();
		}else {
			for(int row=0;row<b.size;row++) {
		//choose
				if(b.isSafe(row, col)) {
				b.place(row, col);
			
			
	     //explore
				queenHelper(b,col+1);
				//unchoose
			b.remove(row, col);
			
		}
	}
	}
	}
}

class Board {
	String[][] a;
	int size;

	Board(int size) {
		this.size = size;
		a = new String[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				a[i][j] = "-";
			}
		}
	}

	void printBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	boolean isSafe(int row, int col) {
		boolean isSafe = true;
		for (int i = 0; i < size; i++) {
			if (a[i][col].equals("Q")) {
				return false;
			}
		}
		for (int i = 0; i < size; i++) {
			if (a[row][i].equals("Q")) {
				return false;
			}
		}
		int row1 = row;
		int col1 = col;
		while (row1 >= 0 && col1 >= 0) {
			if (a[row1--][col1--].equals("Q")) {
				return false;
			}
		}
		row1 = row;
		col1 = col;
		while (row1 < size && col1 < size) {
			if (a[row1++][col1++].equals("Q")) {
				return false;
			}
		}
		row1 = row;
		col1 = col;
		while ((row1 >= 0 && col1 >= 0) && (row1 < size && col1 < size)) {
			if (a[row1--][col1++].equals("Q")) {
				return false;
			}
		}
		row1 = row;
		col1 = col;
		while ((row1 >= 0 && col1 >= 0) && (row1 < size && col1 < size)) {
			if (a[row1++][col1--].equals("Q")) {
				return false;
			}
		}
		return isSafe;
	}

	void place(int row, int col) {
		a[row][col] = "Q";
	}

	void remove(int row, int col) {
		a[row][col] = "-";
	}
}
