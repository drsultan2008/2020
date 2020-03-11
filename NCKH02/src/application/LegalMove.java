package application;

public class LegalMove extends Data {
	
	LegalMove(){
		
	}
	
	Cell[] allMove(int i, int j) {
		Cell[] moves = new Cell[29];
		int index = 0;
		
		if (boardData[i][j].equals("Hum")) {
			if (( i-1>=0  && (i>=3 || j==2)) && boardData[i-1][j].equals("##")) {
				moves[index++] = new Cell(i-1,j);
				if (i-2>=0 && boardData[i-2][j].equals("Tot")) {
					moves[index++] = new Cell(i-1,j);
				}
			}
			
			if ((i+1<=6 && (i>=2 || j==2)) && boardData[i+1][j].equals("##")) {
				moves[index++] = new Cell(i+1,j);
				if (i+2<=6 && boardData[i+2][j].equals("Tot")) {
					moves[index++] = new Cell(i+2,j);
				}
			}

			if ((j-1>=0 && (j==2 || i>=2)) && boardData[i][j-1].equals("##")) {
				moves[index++] = new Cell(i,j-1);
				if (j-2>=0 && boardData[i][j-2].equals("Tot")) {
					moves[index++] = new Cell(i,j-2);
				}
			}
			
			if ((j+1<=4 && (j==2 || i>=2) ) && boardData[i][j+1].equals("##")) {
				moves[index++] = new Cell(i,j+1);
				if (j+2<=4 && boardData[i][j+2].equals("Tot")) {
					moves[index++] = new Cell(i,j+2);
				}
			}
			
			if (i+1<=6 && j+1 <=4 && boardData[i+1][j+1].equals("##")) {
				moves[index++] = new Cell(i+1,j+1);
				if (i+2<=6 && j+2 <=4 && boardData[i+2][j+2].equals("Tot")) {
					moves[index++] = new Cell(i+2,j+2);
				}
			}
			
			if (i-1>=0 && j-1 >=0 && boardData[i-1][j-1].equals("##")) {
				moves[index++] = new Cell(i-1,j-1);
				if (i-2>=0 && j-2 >=0 && boardData[i-2][j-2].equals("Tot")) {
					moves[index++] = new Cell(i-2,j-2);
				}
			}
			
			if (i-1>=0 && j+1<=4 && boardData[i-1][j+1].equals("##")) {
				moves[index++] = new Cell(i-1,j+1);
				if (i-2>=0 && j+2<=4 && boardData[i-2][j+2].equals("Tot")) {
					moves[index++] = new Cell(i-2,j+2);
				}
			}
			
			if (i+1<=6 && j-1>=0 && boardData[i+1][j-1].equals("##")) {
				moves[index++] = new Cell(i+1,j-1);
				if (i+2<=6 && j-2>=0 && boardData[i+2][j-2].equals("Tot")) {
					moves[index++] = new Cell(i+2,j-2);
				}
			}
			
		}
		
		if (boardData[i][j].equals("Tot")) {
			if (i-1>=0 && boardData[i-1][j].equals("##")) {
				moves[index++] = new Cell(i-1,j);
			}
			
			if (i+1<=6 && boardData[i+1][j].equals("##")) {
				moves[index++] = new Cell(i+1,j);
			}

			if (j-1>=0 && boardData[i][j-1].equals("##")) {
				moves[index++] = new Cell(i,j-1);
			}
			
			if (j+1<=4 && boardData[i][j+1].equals("##")) {
				moves[index++] = new Cell(i,j+1);
			}
			
			if (i+1<=6 && j+1 <=4 && boardData[i+1][j+1].equals("##")) {
				moves[index++] = new Cell(i+1,j+1);
			}
			
			if (i-1>=0 && j-1 >=0 && boardData[i-1][j-1].equals("##")) {
				moves[index++] = new Cell(i-1,j-1);
			}
			
			if (i-1>=0 && j+1<=4 && boardData[i-1][j+1].equals("##")) {
				moves[index++] = new Cell(i-1,j+1);
			}
			
			if (i+1<=6 && j-1>=0 && boardData[i+1][j-1].equals("##")) {
				moves[index++] = new Cell(i+1,j-1);
			}
		}
		
		if (boardData[i][j].equals("BTom")) {
			if (i-1>=0 && boardData[i-1][j].equals("##")) {
				moves[index++] = new Cell(i-1,j);
			}
			
			if (i+1<=6 && boardData[i+1][j].equals("##")) {
				moves[index++] = new Cell(i+1,j);
			}

			if (j-1>=0 && boardData[i][j-1].equals("##")) {
				moves[index++] = new Cell(i,j-1);
			}
			
			if (j+1<=4 && boardData[i][j+1].equals("##")) {
				moves[index++] = new Cell(i,j+1);
			}
			
			if (i+1<=6 && j+1 <=4 && boardData[i+1][j+1].equals("##")) {
				moves[index++] = new Cell(i+1,j+1);
			}
			
			if (i-1>=0 && j-1 >=0 && boardData[i-1][j-1].equals("##")) {
				moves[index++] = new Cell(i-1,j-1);
			}
			
			if (i-1>=0 && j+1<=4 && boardData[i-1][j+1].equals("##")) {
				moves[index++] = new Cell(i-1,j+1);
			}
			
			if (i+1<=6 && j-1>=0 && boardData[i+1][j-1].equals("##")) {
				moves[index++] = new Cell(i+1,j-1);
			}
			
			if (i-1>=0 && boardData[i-1][j].equals("Tot")) {
				moves[index++] = new Cell(i-1,j);
				if (i-2>=0 && boardData[i-2][j].equals("Hum")) {
					moves[index++] = new Cell(i-1,j);
				}
			}
			
			if (i+1<=6 && boardData[i+1][j].equals("Tot")) {
				moves[index++] = new Cell(i+1,j);
				if (i+2<=6 && boardData[i+2][j].equals("Hum")) {
					moves[index++] = new Cell(i+2,j);
				}
			}

			if (j-1>=0 && boardData[i][j-1].equals("Tot")) {
				moves[index++] = new Cell(i,j-1);
				if (j-2>=0 && boardData[i][j-2].equals("Hum")) {
					moves[index++] = new Cell(i,j-2);
				}
			}
			
			if (j+1<=4 && boardData[i][j+1].equals("Tot")) {
				moves[index++] = new Cell(i,j+1);
				if (j+2<=4 && boardData[i][j+2].equals("Hum")) {
					moves[index++] = new Cell(i,j+2);
				}
			}
			
			if (i+1<=6 && j+1 <=4 && boardData[i+1][j+1].equals("Tot")) {
				moves[index++] = new Cell(i+1,j+1);
				if (i+2<=6 && j+2 <=4 && boardData[i+2][j+2].equals("Hum")) {
					moves[index++] = new Cell(i+2,j+2);
				}
			}
			
			if (i-1>=0 && j-1 >=0 && boardData[i-1][j-1].equals("Tot")) {
				moves[index++] = new Cell(i-1,j-1);
				if (i-2>=0 && j-2 >=0 && boardData[i-2][j-2].equals("Hum")) {
					moves[index++] = new Cell(i-2,j-2);
				}
			}
			
			if (i-1>=0 && j+1<=4 && boardData[i-1][j+1].equals("Tot")) {
				moves[index++] = new Cell(i-1,j+1);
				if (i-2>=0 && j+2<=4 && boardData[i-2][j+2].equals("Hum")) {
					moves[index++] = new Cell(i-2,j+2);
				}
			}
			
			if (i+1<=6 && j-1>=0 && boardData[i+1][j-1].equals("Tot")) {
				moves[index++] = new Cell(i+1,j-1);
				if (i+2<=6 && j-2>=0 && boardData[i+2][j-2].equals("Hum")) {
					moves[index++] = new Cell(i+2,j-2);
				}
			}
			
		}
		return moves;
	}
}
