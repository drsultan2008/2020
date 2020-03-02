package application;

public class BoardVirtual {
	String boardVirtual[][]=new String[8][8];
	
	BoardVirtual() {
		for (int i=0; i<8; i++)
			for (int j=0; j<8; j++)
				boardVirtual[i][j]="##";
		
		for (int i=0; i<8; i++) {
			boardVirtual[1][i] = "bp";
			boardVirtual[6][i] = "wp";
		}
		boardVirtual[0][0]="br";
        boardVirtual[0][7]="br";
        boardVirtual[7][0]="wr";
        boardVirtual[7][7]="wr";

        boardVirtual[0][1]="bn";
        boardVirtual[0][6]="bn";
        boardVirtual[7][1]="wn";
        boardVirtual[7][6]="wn";

        boardVirtual[0][2]="bb";
        boardVirtual[0][5]="bb";
        boardVirtual[7][2]="wb";
        boardVirtual[7][5]="wb";

        boardVirtual[0][3]="bk";
        boardVirtual[0][4]="bq";
        boardVirtual[7][3]="wq";
        boardVirtual[7][4]="wk";
        
	}
	public void set(String[][] board) {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				boardVirtual[i][j]= board[i][j];
			}
		}
	}
	public String[][] getBoardVirtual(){
		return boardVirtual;
	}
	public String getBoard(int i, int j) {
		return boardVirtual[i][j];
	}
	public void setBoard(int i, int j, String name) {
		boardVirtual[i][j]=name;
	}
	public void show() {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				System.out.print(boardVirtual[i][j]);
			}
			System.out.println();
		}
	}
}
