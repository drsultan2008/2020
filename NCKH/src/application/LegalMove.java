package application;

public class LegalMove {
	Board board;
	
	LegalMove(Board board){
		this.board=board;
	}
	
	public Cell[] allMovePosible(int r, int c) {
		Cell[] allMove = new Cell[64]; // Max move far beyone
		char name= board.virtual.getBoard(r, c).charAt(1);
		char color = board.virtual.getBoard(r, c).charAt(0);
		int index=0;
		if ( name== 'p') {
			if (color == 'w') {
				if (r-1>=0 && board.virtual.getBoard(r-1, c).equals("##")) {
					allMove[index++] = new Cell(r-1,c);
				}
				if (c+1<8 && r-1>=0 && board.virtual.getBoard(r-1, c+1).charAt(0) != color && !board.virtual.getBoard(r-1, c+1).equals("##")) {
					allMove[index++] = new Cell(r-1,c+1);
				}
				if (c-1>+0 && r-1>=0 && board.virtual.getBoard(r-1, c-1).charAt(0) != color && !board.virtual.getBoard(r-1, c-1).equals("##")) {
					allMove[index++] = new Cell(r-1,c-1);
				}
				if (r==6 && board.virtual.getBoard(r-2, c).equals("##") && board.virtual.getBoard(r-1, c).equals("##")) {
					allMove[index++] = new Cell(r-2,c);
				}
			}else {
				if (r+1<=7 && board.virtual.getBoard(r+1, c).equals("##")) {
					allMove[index++] = new Cell(r+1,c);
				}
				if (r+1<=7 && c+1<=7 && board.virtual.getBoard(r+1, c+1).charAt(0) != color && !board.virtual.getBoard(r+1, c+1).equals("##")) {
					allMove[index++] = new Cell(r+1,c+1);
				}
				if (r+1<=7 && c-1>=0 && board.virtual.getBoard(r+1, c-1).charAt(0) != color && !board.virtual.getBoard(r+1, c-1).equals("##")) {
					allMove[index++] = new Cell(r+1,c-1);
				}
				if (r==1 && board.virtual.getBoard(r+2, c).equals("##") && board.virtual.getBoard(r+1, c).equals("##")) {
					allMove[index++] = new Cell(r+2,c);
				}
			}
		}
		
		if (name == 'n') {
				int x[] = {2,2,-2,-2,1,1,-1,-1};
				int y[] = {1,-1,1,-1,2,-2,2,-2};
				for (int i=0; i<8; i++) {
					int row = r +x[i];
					int col = c +y[i];
					if (row>=0 && row <8 && col>=0 && col<8 && (board.virtual.getBoard(row, col).charAt(0)!=color||board.virtual.getBoard(row, col).equals("##"))) {
						allMove[index++] = new Cell(row,col);
					}
				}
		}
		
		if (name == 'q') {
			for (int i=r+1; i<8; i++) {
				if (board.virtual.getBoard(i,c).equals("##")) {
					allMove[index++] = new Cell(i,c);
				}
				else if (board.virtual.getBoard(i, c).charAt(0) != color) {
					allMove[index++] = new Cell(i,c);
					break;
				}else if (board.virtual.getBoard(i, c).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r+1,j=c+1;j<8&&i<8;i++,j++ ) {
				if (board.virtual.getBoard(i,j).equals("##")) {
					allMove[index++] = new Cell(i,j);
				}
				else if (board.virtual.getBoard(i, j).charAt(0) != color) {
					allMove[index++] = new Cell(i,j);
					break;
				}else if (board.virtual.getBoard(i, j).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r+1,j=c-1;i<8&&j>=0; i++,j--) {
				if (board.virtual.getBoard(i,j).equals("##")) {
					allMove[index++] = new Cell(i,j);
				}
				else if (board.virtual.getBoard(i, j).charAt(0) != color) {
					allMove[index++] = new Cell(i,j);
					break;
				}else if (board.virtual.getBoard(i, j).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=c+1; i<8; i++) {
				if (board.virtual.getBoard(r,i).equals("##")) {
					allMove[index++] = new Cell(r,i);
				}
				else if (board.virtual.getBoard(r, i).charAt(0) != color) {
					allMove[index++] = new Cell(r,i);
					break;
				}else if (board.virtual.getBoard(r, i).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=c-1; i>=0; i--) {
				if (board.virtual.getBoard(r,i).equals("##")) {
					allMove[index++] = new Cell(r,i);
				}
				else if (board.virtual.getBoard(r, i).charAt(0) != color) {
					allMove[index++] = new Cell(r,i);
					break;
				}else if (board.virtual.getBoard(r, i).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r-1,j=c-1; i>=0 && j>=0 ; i--,j--) {
				if (board.virtual.getBoard(i,j).equals("##")) {
					allMove[index++] = new Cell(i,j);
				}
				else if (board.virtual.getBoard(i, j).charAt(0) != color) {
					allMove[index++] = new Cell(i,j);
					break;
				}else if (board.virtual.getBoard(i, j).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r-1; i>=0; i--){
				if (board.virtual.getBoard(i,c).equals("##")) {
					allMove[index++] = new Cell(i,c);
				}
				else if (board.virtual.getBoard(i, c).charAt(0) != color) {
					allMove[index++] = new Cell(i,c);
					break;
				}else if (board.virtual.getBoard(i, c).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r-1,j=c+1; i>=0 && j<8; i--,j++) {
				if (board.virtual.getBoard(i,j).equals("##")) {
					allMove[index++] = new Cell(i,j);
				}
				else if (board.virtual.getBoard(i, j).charAt(0) != color) {
					allMove[index++] = new Cell(i,j);
					break;
				}else if (board.virtual.getBoard(i, j).charAt(0) == color) {
					break;
				}
			}
		}
		
		if (name == 'b') {
			for (int i=r-1,j=c+1; i>=0 && j<8; i--,j++) {
				if (board.virtual.getBoard(i,j).equals("##")) {
					allMove[index++] = new Cell(i,j);
				}
				else if (board.virtual.getBoard(i, j).charAt(0) != color) {
					allMove[index++] = new Cell(i,j);
					break;
				}else if (board.virtual.getBoard(i, j).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r-1,j=c-1; i>=0 && j>=0 ; i--,j--) {
				if (board.virtual.getBoard(i,j).equals("##")) {
					allMove[index++] = new Cell(i,j);
				}
				else if (board.virtual.getBoard(i, j).charAt(0) != color) {
					allMove[index++] = new Cell(i,j);
					break;
				}else if (board.virtual.getBoard(i, j).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r+1,j=c+1;j<8&&i<8;i++,j++ ) {
				if (board.virtual.getBoard(i,j).equals("##")) {
					allMove[index++] = new Cell(i,j);
				}
				else if (board.virtual.getBoard(i, j).charAt(0) != color) {
					allMove[index++] = new Cell(i,j);
					break;
				}else if (board.virtual.getBoard(i, j).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r+1,j=c-1;i<8&&j>=0; i++,j--) {
				if (board.virtual.getBoard(i,j).equals("##")) {
					allMove[index++] = new Cell(i,j);
				}
				else if (board.virtual.getBoard(i, j).charAt(0) != color) {
					allMove[index++] = new Cell(i,j);
					break;
				}else if (board.virtual.getBoard(i, j).charAt(0) == color) {
					break;
				}
			}
		}
		
		if (name == 'r') {
			for (int i=r+1; i<8; i++) {
				if (board.virtual.getBoard(i,c).equals("##")) {
					allMove[index++] = new Cell(i,c);
				}
				else if (board.virtual.getBoard(i, c).charAt(0) != color) {
					allMove[index++] = new Cell(i,c);
					break;
				}else if (board.virtual.getBoard(i, c).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=r-1; i>=0; i--){
				if (board.virtual.getBoard(i,c).equals("##")) {
					allMove[index++] = new Cell(i,c);
				}
				else if (board.virtual.getBoard(i, c).charAt(0) != color) {
					allMove[index++] = new Cell(i,c);
					break;
				}else if (board.virtual.getBoard(i, c).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=c+1; i<8; i++) {
				if (board.virtual.getBoard(r,i).equals("##")) {
					allMove[index++] = new Cell(r,i);
				}
				else if (board.virtual.getBoard(r, i).charAt(0) != color) {
					allMove[index++] = new Cell(r,i);
					break;
				}else if (board.virtual.getBoard(r, i).charAt(0) == color) {
					break;
				}
			}
			
			for (int i=c-1; i>=0; i--) {
				if (board.virtual.getBoard(r,i).equals("##")) {
					allMove[index++] = new Cell(r,i);
				}
				else if (board.virtual.getBoard(r, i).charAt(0) != color) {
					allMove[index++] = new Cell(r,i);
					break;
				}else if (board.virtual.getBoard(r, i).charAt(0) == color) {
					break;
				}
			}
			
		}
		
		if (name == 'k') {
			int x[] = {-1,-1,-1,0,0,1,1,1};
            int y[] = {-1,0,1,-1,1,-1,0,1};
			for (int i=0; i<8; i++) {
				int row = r +x[i];
				int col = c +y[i];
				if (row>=0 && row <8 && col>=0 && col<8 && (board.virtual.getBoard(row, col).charAt(0)!=color||board.virtual.getBoard(row, col).equals("##"))) {
					allMove[index++] = new Cell(row,col);
				} 
			}
		}
		
		
		return allMove;
	}
}
