package application;

public class LegalMove {
	Data data;
	
	LegalMove(Data data){
		this.data=data;
	}
	
	Cell[] allMove(int i, int j, String[][] boardData) {
		Cell[] moves = new Cell[29];
		int index = 0;
		
		for (int ii=0; ii<7; ii++) {
			for (int jj=0; jj<5; jj++) {
				System.out.print(boardData[ii][jj]);
			}
			System.out.println();
		}
		
		if (boardData[i][j].equals("Hum")) {
			System.out.println(i+","+j);
			if (( i-1>=0  && (i>=3 || j==2)) && boardData[i-1][j].equals("###")) {
				moves[index++] = new Cell(i-1,j);
				if (i-2>=0 && (boardData[i-2][j].equals("Tot") || boardData[i-2][j].equals("BTom"))) {
					moves[index++] = new Cell(i-1,j);
				}
			}
			
			if ((i+1<=6 && (i>=2 || j==2)) && boardData[i+1][j].equals("###")) {
				moves[index++] = new Cell(i+1,j);
				if (i+2<=6 && (boardData[i+2][j].equals("Tot") || boardData[i+2][j].equals("BTom"))) {
					moves[index++] = new Cell(i+2,j);
				}
			}

			if ((j-1>=0 && (j==2 || i>=2 || j==3)) && boardData[i][j-1].equals("###")) {
				moves[index++] = new Cell(i,j-1);
				if (j-2>=0 && (boardData[i][j-2].equals("Tot") || boardData[i][j-2].equals("BTom"))) {
					moves[index++] = new Cell(i,j-2);
				}
			}
			
			if ((j+1<=4 && (j==2 || i>=2 || j==1) ) && boardData[i][j+1].equals("###")) {
				moves[index++] = new Cell(i,j+1);
				if (j+2<=4 && (boardData[i][j+2].equals("Tot")||boardData[i][j+2].equals("BTom"))) {
					moves[index++] = new Cell(i,j+2);
				}
			}
			
			if (i+1<=6 && j+1 <=4  && (i-j==4||i-j==2||i-j==0||i-j==-2 && i!=1) && boardData[i+1][j+1].equals("###")) {
				moves[index++] = new Cell(i+1,j+1);
				if (i+2<=6 && j+2 <=4 && (boardData[i+2][j+2].equals("Tot") || boardData[i+2][j+2].equals("BTom"))) {
					moves[index++] = new Cell(i+2,j+2);
				}
			}
			
			if (i-1>=0 && j-1 >=0 &&  (i-j==4||i-j==2||i-j==0||i-j==-2) && boardData[i-1][j-1].equals("###")) {
				moves[index++] = new Cell(i-1,j-1);
				if (i-2>=0 && j-2 >=0 && (boardData[i-2][j-2].equals("Tot")||boardData[i-2][j-2].equals("BTom"))) {
					moves[index++] = new Cell(i-2,j-2);
				}
			}
			
			if (i-1>=0 && j+1<=4 && (i+j==2|| i+j==4||i+j==6||i+j==8) && boardData[i-1][j+1].equals("###")) {
				moves[index++] = new Cell(i-1,j+1);
				if (i-2>=0 && j+2<=4 && (boardData[i-2][j+2].equals("Tot") || boardData[i-2][j+2].equals("BTom"))) {
					moves[index++] = new Cell(i-2,j+2);
				}
			}
			
			if (i+1<=6 && j-1>=0 && ((i+j==2 && i!=1)|| i+j==4||i+j==6||i+j==8) && boardData[i+1][j-1].equals("###")) {
				moves[index++] = new Cell(i+1,j-1);
				if (i+2<=6 && j-2>=0 && (boardData[i+2][j-2].equals("Tot") || boardData[i+2][j-2].equals("BTom"))) {
					moves[index++] = new Cell(i+2,j-2);
				}
			}
			
		}
		
		if (boardData[i][j].equals("Tot")) {
			if (( i-1>=0  && (i>=3 || j==2)) && boardData[i-1][j].equals("###")) {
				moves[index++] = new Cell(i-1,j);
			}
			
			if ((i+1<=6 && (i>=2 || j==2)) && boardData[i+1][j].equals("###")) {
				moves[index++] = new Cell(i+1,j);
			}

			if ((j-1>=0 && (j==2 || i>=2 || j==3)) && boardData[i][j-1].equals("###")) {
				moves[index++] = new Cell(i,j-1);
			}
			
			if ((j+1<=4 && (j==2 || i>=2 || j==1) ) && boardData[i][j+1].equals("###")) {
				moves[index++] = new Cell(i,j+1);
			}
			
			if (i+1<=6 && j+1 <=4  && (i-j==4||i-j==2||i-j==0||i-j==-2 && i!=1) && boardData[i+1][j+1].equals("###")) {
				moves[index++] = new Cell(i+1,j+1);
			}
			
			if (i-1>=0 && j-1 >=0 &&  (i-j==4||i-j==2||i-j==0||i-j==-2) && boardData[i-1][j-1].equals("###")) {
				moves[index++] = new Cell(i-1,j-1);
			}
			
			if (i-1>=0 && j+1<=4 && (i+j==2|| i+j==4||i+j==6||i+j==8) && boardData[i-1][j+1].equals("###")) {
				moves[index++] = new Cell(i-1,j+1);
			}
			
			if (i+1<=6 && j-1>=0 && ((i+j==2 && i!=1)|| i+j==4||i+j==6||i+j==8) && boardData[i+1][j-1].equals("###")) {
				moves[index++] = new Cell(i+1,j-1);
			}
		}
		
		if (boardData[i][j].equals("BTom")) {
			if (( i-1>=0  && (i>=3 || j==2)) && boardData[i-1][j].equals("###")) {
				moves[index++] = new Cell(i-1,j);
			}
			
			if ((i+1<=6 && (i>=2 || j==2)) && boardData[i+1][j].equals("###")) {
				moves[index++] = new Cell(i+1,j);
			}

			if ((j-1>=0 && (j==2 || i>=2|| j==3)) && boardData[i][j-1].equals("###")) {
				moves[index++] = new Cell(i,j-1);
			}
			
			if ((j+1<=4 && (j==2 || i>=2 || j==1) ) && boardData[i][j+1].equals("###")) {
				moves[index++] = new Cell(i,j+1);
			}
			
			if (i+1<=6 && j+1 <=4  && (i-j==4||i-j==2||i-j==0||i-j==-2 && i!=1) && boardData[i+1][j+1].equals("###")) {
				moves[index++] = new Cell(i+1,j+1);
			}
			
			if (i-1>=0 && j-1 >=0 &&  (i-j==4||i-j==2||i-j==0||i-j==-2) && boardData[i-1][j-1].equals("###")) {
				moves[index++] = new Cell(i-1,j-1);
			}
			
			if (i-1>=0 && j+1<=4 && (i+j==2|| i+j==4||i+j==6||i+j==8) && boardData[i-1][j+1].equals("###")) {
				moves[index++] = new Cell(i-1,j+1);
			}
			
			if (i+1<=6 && j-1>=0 && ((i+j==2 && i!=1)|| i+j==4||i+j==6||i+j==8) && boardData[i+1][j-1].equals("###")) {
				moves[index++] = new Cell(i+1,j-1);
			}
			
			if (( i-1>=0  && (i>=3 || j==2)) && boardData[i-1][j].equals("Tot")) {
				if (i-2>=0 && boardData[i-2][j].equals("Hum")) {
					moves[index++] = new Cell(i-2,j);
				}
			}
			
			if ((i+1<=6 && (i>=2 || j==2)) && boardData[i+1][j].equals("Tot")) {
				if (i+2<=6 && boardData[i+2][j].equals("Hum")) {
					moves[index++] = new Cell(i+2,j);
				}
			}

			if ((j-1>=0 && (j==2 || i>=2 )) && boardData[i][j-1].equals("Tot")) {
				if (j-2>=0 && boardData[i][j-2].equals("Hum")) {
					moves[index++] = new Cell(i,j-2);
				}
			}
			
			if ((j+1<=4 && (j==2 || i>=2 || j==1) ) && boardData[i][j+1].equals("Tot")) {
				if (j+2<=4 && boardData[i][j+2].equals("Hum")) {
					moves[index++] = new Cell(i,j+2);
				}
			}
			
			if (i+1<=6 && j+1 <=4  && (i-j==4||i-j==2||i-j==0||i-j==-2 && i!=1) && boardData[i+1][j+1].equals("Tot")) {
				if (i+2<=6 && j+2 <=4 && boardData[i+2][j+2].equals("Hum")) {
					moves[index++] = new Cell(i+2,j+2);
				}
			}
			
			if (i-1>=0 && j-1 >=0 &&  (i-j==4||i-j==2||i-j==0||i-j==-2) && boardData[i-1][j-1].equals("Tot")) {
				if (i-2>=0 && j-2 >=0 && boardData[i-2][j-2].equals("Hum")) {
					moves[index++] = new Cell(i-2,j-2);
				}
			}
			
			if (i-1>=0 && j+1<=4 && (i+j==2|| i+j==4||i+j==6||i+j==8) && boardData[i-1][j+1].equals("Tot")) {
				if (i-2>=0 && j+2<=4 && boardData[i-2][j+2].equals("Hum")) {
					moves[index++] = new Cell(i-2,j+2);
				}
			}
			
			if (i+1<=6 && j-1>=0 && ((i+j==2 && i!=1)|| i+j==4||i+j==6||i+j==8) && boardData[i+1][j-1].equals("Tot")) {
				if (i+2<=6 && j-2>=0 && boardData[i+2][j-2].equals("Hum")) {
					moves[index++] = new Cell(i+2,j-2);
				}
			}
			
		}
		return moves;	
	}
}
