class Solution {
	public void solveSudoku(char[][] board) {
		find(board,0, 0);
	}

	private boolean find(char[][] board,int i, int j) {
		if (i == 9) {
			if (j == 8) {
				return true;
			} else {
				return find(board,0, j + 1);
			}
		} else if (board[i][j] == '.') {
			for (char ii = '1'; ii <= '9'; ii++) {
				if (isValid(board, i, j, ii) == true) {
					board[i][j] = ii;
					if (find(board,i + 1, j) == true) {
						return true;
					}
					board[i][j] = '.';
				}
			}

		} else {
			return find(board,i + 1, j);
		}

		return false;
	}

	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.' && board[i][col] == c) {
				return false;
			}

			if (board[row][i] != '.' && board[row][i] == c) {
				return false;
			}

			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
					&& board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
				return false;
			}
		}
		return true;
	}
}