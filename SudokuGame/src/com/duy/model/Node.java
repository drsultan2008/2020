package com.duy.model;

import java.util.HashSet;

import com.duy.utils.Constants;

public class Node {
	private int row;
	private int col;
	private char val;
	private boolean fixed;
	
	public Node(int row, int col, char val, boolean fixed) {
		super();
		this.row = row;
		this.col = col;
		this.val = val;
		this.fixed = fixed;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char getVal() {
		return val;
	}

	public void setVal(char val) {
		this.val = val;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
	
	public boolean validSudoku(boolean row, boolean col, boolean block, Game game) {
		HashSet<Character> setRow = new HashSet<>();
		HashSet<Character> setCol = new HashSet<>();
		HashSet<Character> setBlock = new HashSet<>();
		
		for (int i=0; i<Constants.SIZE; i++) {
			for (int j=0; j<Constants.SIZE; j++) {
				if (game.getNode(i, j).getVal() == '.' || !setRow.add(game.getNode(i, j).getVal())) {
					row = false;
				}
				
				if (game.getNode(j, i).getVal() == '.' || !setRow.add(game.getNode(j, i).getVal())) {
					col = false;
				}
				
				int rowBlock = i/3*3 + j/3;
				int colBlock = j%3*3 + j%3;
				
				if (game.getNode(rowBlock, colBlock).getVal() == '.' || !setRow.add(game.getNode(rowBlock, colBlock).getVal())) {
					block = false;
				}
				
				if (!row || !col || !block) {
					return false;
				}
			}
		}
		
		return true;
	}
}
