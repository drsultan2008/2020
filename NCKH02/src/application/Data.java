package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.net.URL;

public class Data {
	Stage window;
	URL url;
	private int squareSize = 40;
	Image chonHum,chonTom,menuBackground,Tot,BTom,Hum,background,choose,TrongSuot;
	double maxWidth = 450, maxHeight = 700;
	final int HUM=1;
    final int TOM=2;
    int player;
    int GAME_TREE_HEIGHT = 5;
	boolean cpuMove,gameOver;
	Button boardView[][] = new Button[5][7];
	Board board;
	boolean flag = false;
	Cell move1;
	LegalMove legalMove;
	Cell[] movePossible;
	Play play;
	char cpu,people;
	AI ai;
	Data(Stage stage){
		window = stage;
		
		url = getClass().getResource("/application/images/");
		chonHum = new Image(url+"chonHum.png",301,85,true,true);
		chonTom = new Image(url+"chonTom.png",301,85,true,true);
		menuBackground = new Image(url+"menuBackground.png");
		
		Tot = new Image(url+"Tot01.png",squareSize,squareSize,true,true);
		BTom = new Image(url+"BTom01.png",squareSize,squareSize,true,true);
		Hum = new Image(url+"Hum02.png",squareSize,squareSize,true,true);
		background = new Image(url+"board02.jpg");
		TrongSuot = new Image(url+"trongSuot.png",squareSize,squareSize,true,true);
		choose = new Image(url+"choose1.png",squareSize,squareSize,true,true);

		legalMove = new LegalMove(this);
		play = new Play(this);
		ai = new AI(this);
	}
	
	void setPlayerHum() {
		player=HUM;
		cpuMove=false;
		cpu = 'T';
		people = 'H';
		board = new Board(this);
		window.setScene(new Scene(play));
	    play.set();
	}
	
	void setPlayerTom() {
		player=TOM;
		cpuMove=true;
		cpu = 'H';
		people = 'T';
		board = new Board(this);
		window.setScene(new Scene(play));
	    play.set();
	}
	
	void move(Cell cell) {
		if (flag == false && !board.get(cell.getCol(), cell.getRow()).equals("##")) {
			flag = true;
			movePossible = legalMove.allMove(cell.getCol(), cell.getRow(),board.getBoardData());
			move1=cell;
			
			for (int i=0; i<29; i++) {
				if (movePossible[i]!=null) {
					boardView[movePossible[i].getCol()][movePossible[i].getRow()].setStyle("-fx-background-color: #69ff69;");
				}
			}
		}
		else {
			boolean isMove = true;
			for (int i=0; i<29; i++) {
				if (movePossible[i]!=null) {
					boardView[movePossible[i].getCol()][movePossible[i].getRow()].setStyle("");
					
					if (movePossible[i].getCol()==cell.getRow() && movePossible[i].getRow()==cell.getCol()) {
						isMove = true;
					}
				}
				
			}
			flag = false;
			if (isMove==true) {
				board.set(board.get(move1.getCol(), move1.getRow()), cell.getCol(), cell.getRow());
				board.set("###", move1.getCol(), move1.getRow());
			}
			updateBoard();
			cpuMove = true;
//			updateBoard(controller.getData().getBoardData());
		}
	}
	
	void pcMakeMove() {
		String nextBoard[][] = ai.findBestMove(board.boardData,0);
        cpuMove=false;
//        System.out.println(moveCount);
        //moveCount=0;
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<5;j++)
            {
                board.set(nextBoard[i][j], i, j);
            }
        }
//        if(counter<2)
//        {
//            gameOver=true;
//            showGameOverWindow();
//
//        }
        updateBoard();
	}
	
	public void updateBoard() {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (board.boardData[i][j].equals("Tot")) {
					boardView[j][i].setGraphic(new ImageView(Tot));
				}
				if (board.boardData[i][j].equals("Hum")) {
					boardView[j][i].setGraphic(new ImageView(Hum));
				}
				if (board.boardData[i][j].equals("TTom")) {
					boardView[j][i].setGraphic(new ImageView(BTom));
				}
				else if (board.boardData[i][j].equals("###")){
					boardView[j][i].setGraphic(new ImageView(TrongSuot));
//					System.out.print(i+","+j+" ");
				}
			}
		}
//		showTurn(controller.getData().getTuner());
	}
	
	
	
}
