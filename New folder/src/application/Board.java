package application;


import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.*;

public class Board extends GridPane{
	Button[][] boardView = new Button[8][8];
	URL url;
	int squareSize = 80;
	Image bb,bk,bn,bp,bq,br,wb,wk,wn,wp,wq,wr;
	Boolean flag = false;
	Boolean people = false;
	Cell move1;
	BoardVirtual virtual = new BoardVirtual();
	LegalMove legal = new LegalMove(this);
	AI ai = new AI(this);
	
	Board(){
		url = getClass().getResource("/application/images/");

		wp = new Image(url+"wp.png",squareSize,squareSize,true,true);
        bp = new Image(url+"bp.png",squareSize,squareSize,true,true);
        wr = new Image(url+"wr.png",squareSize,squareSize,true,true);
        br = new Image(url+"br.png",squareSize,squareSize,true,true);
        wn = new Image(url+"wn.png",squareSize,squareSize,true,true);
        bn = new Image(url+"bn.png",squareSize,squareSize,true,true);
        wb = new Image(url+"wb.png",squareSize,squareSize,true,true);
        bb = new Image(url+"bb.png",squareSize,squareSize,true,true);
        wq = new Image(url+"wq.png",squareSize,squareSize,true,true);
        bq = new Image(url+"bq.png",squareSize,squareSize,true,true);
        wk = new Image(url+"wk.png",squareSize,squareSize,true,true);
        bk = new Image(url+"bk.png",squareSize,squareSize,true,true);
        
		drawBoard();
		updateBoard();
		event();
//		play();
	}
	
	void play() {
		virtual.set(ai.bestMove(virtual.getBoardVirtual()));
		updateBoard();
		people = false;
		
	}
	
	void event() {
		for (int i=0; i<8; i++)
			for (int j=0; j<8; j++)
				boardView[i][j].setOnAction(new moveEvent(i,j,this));
	}
	
	void move(Cell cell) {
		if (flag == false) {
			flag = true;
			move1=cell;
			Cell[] movePossible = legal.allMovePosible(move1.getRow(), move1.getCol());
			for (int i=0; i<64; i++) {
				if (movePossible[i]!=null) {
					if ((movePossible[i].getRow()+movePossible[i].getCol())%2==0) {
						boardView[movePossible[i].getRow()][movePossible[i].getCol()].setStyle("-fx-background-color: #69ff69;");
					}
					else {
						boardView[movePossible[i].getRow()][movePossible[i].getCol()].setStyle("-fx-background-color: #005500;");
					}
				}
			}
		}
		else {
			flag=false;
			virtual.setBoard(cell.getRow(), cell.getCol(), virtual.getBoard(move1.getRow(), move1.getCol()));
			virtual.setBoard(move1.getRow(),move1.getCol(),"##");
			updateBoard();
			play();
		}
	}
	
	void drawBoard() {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				boardView[i][j] = new Button();
				add(boardView[i][j],j,i);
				boardView[i][j].setMinSize(squareSize,squareSize);
				boardView[i][j].setMaxSize(squareSize, squareSize);
				if ((i+j)%2==0) {
					boardView[i][j].setStyle("-fx-background-color:white;");
				}else {
					boardView[i][j].setStyle("-fx-background-color:black;");
				}
			}
		}
	}
	
	void updateBoard() {    
		
        for (int i=0; i<8; i++){
        	for (int j=0; j<8; j++) {
        		
        		if ((i+j)%2==0) {
					boardView[i][j].setStyle("-fx-background-color:white;");
				}else {
					boardView[i][j].setStyle("-fx-background-color:black;");
				}
        		
        		
        		if(virtual.getBoard(i,j).equals("wp"))
                {
                    boardView[i][j].setGraphic(new ImageView(wp));
                }
                else if(virtual.boardVirtual[i][j].equals("bp"))
                {
                    boardView[i][j].setGraphic(new ImageView(bp));
                }
                else if(virtual.boardVirtual[i][j].equals("wr"))
                {
                    boardView[i][j].setGraphic(new ImageView(wr));
                }
                else if(virtual.boardVirtual[i][j].equals("br"))
                {
                    boardView[i][j].setGraphic(new ImageView(br));
                }
                else if(virtual.boardVirtual[i][j].equals("wn"))
                {
                    boardView[i][j].setGraphic(new ImageView(wn));
                }
                else if(virtual.boardVirtual[i][j].equals("wr"))
                {
                    boardView[i][j].setGraphic(new ImageView(wr));
                }
                else if(virtual.boardVirtual[i][j].equals("wb"))
                {
                    boardView[i][j].setGraphic(new ImageView(wb));
                }
                else if(virtual.boardVirtual[i][j].equals("bb"))
                {
                    boardView[i][j].setGraphic(new ImageView(bb));
                }
                else if(virtual.boardVirtual[i][j].equals("wq"))
                {
                    boardView[i][j].setGraphic(new ImageView(wq));
                }
                else if(virtual.boardVirtual[i][j].equals("bq"))
                {
                    boardView[i][j].setGraphic(new ImageView(bq));
                }
                else if(virtual.boardVirtual[i][j].equals("wk"))
                {
                    boardView[i][j].setGraphic(new ImageView(wk));
                }
                else if(virtual.boardVirtual[i][j].equals("bn"))
                {
                    boardView[i][j].setGraphic(new ImageView(bn));
                }
                else if(virtual.boardVirtual[i][j].equals("bk"))
                {
                    boardView[i][j].setGraphic(new ImageView(bk));
                }
                else 
                {
                	boardView[i][j].setGraphic(new ImageView());
                }
        	}
        }
        
	}
}
