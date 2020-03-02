package application;

public class AI {
	Board board ;
	String chess[][];
	final int level = 3;
	AI(Board board){
		this.board = board;
		chess = board.virtual.getBoardVirtual();
	}
	
	public String[][] bestMove(String[][] chess){
		String[][] chessCpy = new String[8][8];
		String[][] chessCpy2 = new String[8][8];
		for (int i=0; i<8; i++) {
			for (int j=0; j<8;j++) {
				chessCpy[i][j] = chess[i][j];
			}
		}
		
		for (int i=0; i<8; i++) {
			for (int j=0; j<8;j++) {
				chessCpy2[i][j] = chess[i][j];
			}
		}
		
		Cell move = new Cell(0,0);
		
		int bestWay = Integer.MIN_VALUE;
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (chessCpy[i][j].charAt(0)=='b') {
					Cell node = new Cell(i,j);
					Cell moves[] = board.legal.allMovePosible(node.getRow(), node.getCol());
					
					for (int ii=0; ii<64; ii++) {
						if (moves[ii]!=null) {
							
							for (int i3=0; i3<8; i3++) {
								for (int j3=0; j3<8;j3++) {
									chessCpy[i3][j3] = chess[i3][j3];
								}
							}
							
							String temp1 = chessCpy[moves[ii].getRow()][moves[ii].getCol()];
							String temp2 = chessCpy[i][j];
							chessCpy[moves[ii].getRow()][moves[ii].getCol()] = chessCpy[i][j];
							chessCpy[i][j] = "##";
									
							int temp = minimax(chessCpy,node,level,false);
							
							if (temp>=bestWay) {
								bestWay = temp;
								for (int i1=0; i1<8; i1++) {
									for (int j1=0; j1<8; j1++) {
										chessCpy2[i1][j1]= chessCpy[i1][j1];
									}
								}
							}
							
							chessCpy[moves[ii].getRow()][moves[ii].getCol()] = temp1;
							chessCpy[i][j] = temp2;
						}
					}
				}
			}
		}
//		System.out.print(move.getRow()+","+move.getCol());
//		System.out.print(move.getRow()+","+move.getCol());
		return chessCpy2;
	}
	
	public int minimax(String chess[][], Cell node,int depth, boolean isMax) {
		if (depth == 0) {
			return evalution(chess,isMax);
		}
		if (isMax) { // Black (AI) turn
			int best = Integer.MIN_VALUE;
			for (int ii=0; ii<8; ii++) {
				for (int jj=0; jj<8;jj++) {
					if (chess[ii][jj].charAt(0)=='b') {
						Cell[] moves = board.legal.allMovePosible(ii, jj);
						for (int i=0; i<64; i++) {
							if (moves[i]!=null) {
								String temp1 = chess[moves[i].getRow()][moves[i].getCol()];
								String temp2 = chess[ii][jj];
								chess[moves[i].getRow()][moves[i].getCol()] = temp2;
								chess[ii][jj] = temp1;
								
								int tmp = minimax(chess,node,depth-1,!isMax);
								best= Integer.max(best, tmp);
								
								System.out.print("Best:"+best+ ",tmp: " +tmp +" AI "+ii+","+jj+":"+i+"\n");
								print(chess);
								
								chess[moves[i].getRow()][moves[i].getCol()] = temp1;
								chess[ii][jj] = temp2;
							}
						}
					}	
				}
			}
			return best;
		}
		else {
			int best = Integer.MAX_VALUE;
			for (int ii=0; ii<8; ii++) {
				for (int jj=0; jj<8;jj++) {
					if (chess[ii][jj].charAt(0)=='w') {
						Cell[] moves = board.legal.allMovePosible(ii, jj);
						for (int i=0; i<64; i++) {
							if (moves[i]!=null) {
								String temp1 = chess[moves[i].getRow()][moves[i].getCol()];
								String temp2 = chess[ii][jj];
								chess[moves[i].getRow()][moves[i].getCol()] = temp2;
								chess[ii][jj] = temp1;
								int tmp = minimax(chess,node,depth-1,!isMax);
								best = Integer.min(best, tmp);
								
								System.out.print("Best: "+best+",tmp: "+tmp+ " People "+ii+","+jj+":"+i+"\n");
								print(chess);
								
								chess[moves[i].getRow()][moves[i].getCol()] = temp1;
								chess[ii][jj] = temp2;
							}
						}
					}	
				}
			}
			return best;
		}
	}
	int evalution(String chess[][], boolean isAi) {
		int res=0; // Default
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
					if (chess[i][j].equals("bb")) {
						res+=30;
					}
					if (chess[i][j].equals("bk")) {
						res+=9000;
					}
					if (chess[i][j].equals("bn")){
						res+=35;
					}
					if (chess[i][j].equals("bp")) {
						res+=10;
					}
					if (chess[i][j].equals("br")) {
						res+=50;
					}
					if (chess[i][j].equals("bq")) {
						res+=90;
					}
					
					if (chess[i][j].equals("wb")) {
						res-=30;
					}
					if (chess[i][j].equals("wk")) {
						res-=9000;
					}
					if (chess[i][j].equals("wn")){
						res-=35;
					}
					if (chess[i][j].equals("wp")) {
						res-=10;
					}
					if (chess[i][j].equals("wr")) {
						res-=50;
					}
					if (chess[i][j].equals("wq")) {
						res-=90;
					}
			}
		}
		return res;
	}
	void print(String[][] board) {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
		
}





