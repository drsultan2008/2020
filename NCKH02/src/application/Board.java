package application;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;

public class Board extends GridPane implements Observer{
	private Button boardView[][] = new Button[5][7];
	private int space = 40;
	private URL url;
	private Image Tot, Hum, BTom,background;
	private int squareSize = 40;
	private Controller controller;
	private boolean flag = false;
	private Cell move1;
	private LegalMove legalMove = new LegalMove();
	Board() {
		InitBoard();
		url = getClass().getResource("/application/images/");
		Tot = new Image(url+"Tot.png",squareSize,squareSize,true,true);
		BTom = new Image(url+"BTom.png",squareSize,squareSize,true,true);
		Hum = new Image(url+"Hum.png",squareSize,squareSize,true,true);
		background = new Image(url+"board.jpg",squareSize,squareSize,true,true);
	}

	Board(Controller controller) throws Exception{
//		Parent root = FXMLLoader.load(getClass().getResource("Board.fxml"));
//		add(root,0,0);
		this.controller=controller;
		InitBoard();
		url = getClass().getResource("/application/images/");
		Tot = new Image(url+"Tot01.png",squareSize,squareSize,true,true);
		BTom = new Image(url+"BTom01.png",squareSize,squareSize,true,true);
		Hum = new Image(url+"Hum.png",squareSize,squareSize,true,true);
		background = new Image(url+"board.jpg");
		BackgroundImage backgroundImage = new BackgroundImage(background,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        
		updateBoard(controller.getData().getBoardData());
		
	}
	
	@Override
	public void update(Observable s, Object arg) {
		updateBoard(controller.getData().getBoardData());
	}
	
	public void InitBoard() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<7; j++) {
				boardView[i][j] = new Button();
				boardView[i][j].setMinSize(40, 40);
				if (i==0 && j==0 || i==0 && j==1|| i==1 && j==0 || i==3 && j==0 || i==4 && j==0 || i==4 && j==1 )
					continue;
				add(boardView[i][j],i,j);
				getStylesheets().add(getClass().getResource("boardStyle.css").toExternalForm());
				setVgap(45);
				setHgap(35);
			}
		}
		event();
	}
	
	public void updateBoard(String[][] boardData) {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(i+","+j+" ");
				if (boardData[i][j].equals("Tot")) {
					boardView[j][i].setGraphic(new ImageView(Tot));
				}
				if (boardData[i][j].equals("Hum")) {
					boardView[j][i].setGraphic(new ImageView(Hum));
				}
				if (boardData[i][j].equals("BTom")) {
					boardView[j][i].setGraphic(new ImageView(BTom));
				}
			}
			System.out.println();
		}
		showTurn(controller.getData().getTuner());
	}
	
	public void showTurn(boolean turn) {
		Button msg = new Button();
		
		Image luotTom, luotHum;
		luotTom = new Image(url+"luotTom.png",100,300,true,true);
		luotHum = new Image(url+"luotHum.png",100,00,true,true);
		
		if (turn) {
			msg.setGraphic(new ImageView(luotHum));
		}else {
			msg.setGraphic(new ImageView(luotTom));
		}
		
//		add(msg,0,0);
	}
	
	public void event() {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				Cell cell = new Cell(i,j);
				boardView[i][j].setOnAction(e->{
//					moveEvent(cell);
					
				});
			}
		}
	}
	
	public void moveEvent(Cell cell) {
		if (flag == false) {
			flag = true;
			move1=cell;
			Cell[] movePossible = legalMove.allMove(move1.getRow(), move1.getCol());
			for (int i=0; i<29; i++) {
				if (movePossible[i]!=null) {
						boardView[movePossible[i].getRow()][movePossible[i].getCol()].setStyle("-fx-background-color: #69ff69;");
				}
			}
		}
		else {
			flag=false;
			controller.set(controller.getData().get(move1.getRow(), move1.getCol()), cell.getRow(), cell.getCol());
			controller.set("##", move1.getRow(), move1.getCol());
		}
	}
}
