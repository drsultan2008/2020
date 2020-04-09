package leetcode;

import java.util.HashSet;


public class ValidSudoku2 {

	public static boolean validSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rowSet = new HashSet<>();
			HashSet<Character> colSet = new HashSet<>();
			HashSet<Character> blockSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.' || !rowSet.add(board[i][j]))
					return false;
				if (board[j][i] == '.' || !colSet.add(board[j][i]))
					return false;
				int rowBlock = i / 3 * 3 + j / 3;
				int colBlock = i % 3 * 3 + j % 3;
				System.out.println(rowBlock + "," + colBlock + " ");
				if (board[rowBlock][colBlock] == '.' || !blockSet.add(board[rowBlock][colBlock]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku2 sudoku = new ValidSudoku2();
		String input = "974236158638591742125487936316754289742918563589362417867125394253649871491873625";
		char board[][] = new char[9][9];
		int iter = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = input.charAt(iter++);
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println(validSudoku(board));

	}

}