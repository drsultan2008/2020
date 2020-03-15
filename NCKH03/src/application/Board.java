package application;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
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
	private Image Tot, Hum, BTom,background,TrongSuot,choose;
	private int squareSize = 40;
	private Controller controller;
	private boolean flag = false;
	private Cell move1;
	private LegalMove legalMove = new LegalMove(this);
	private Cell[] movePossible;
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
		Hum = new Image(url+"Hum02.png",squareSize,squareSize,true,true);
		background = new Image(url+"board.jpg");
		TrongSuot = new Image(url+"trongSuot.png",squareSize,squareSize,true,true);
		choose = new Image(url+"choose1.png",squareSize,squareSize,true,true);
		BackgroundImage backgroundImage = new BackgroundImage(background,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        
		updateBoard(controller.getData().getBoardData());
		event();
		
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
	}
	
	public void updateBoard(String[][] boardData) {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (boardData[i][j].equals("Tot")) {
					boardView[j][i].setGraphic(new ImageView(Tot));
				}
				if (boardData[i][j].equals("Hum")) {
					boardView[j][i].setGraphic(new ImageView(Hum));
				}
				if (boardData[i][j].equals("BTom")) {
					boardView[j][i].setGraphic(new ImageView(BTom));
				}
				else if (boardData[i][j].equals("###")){
					boardView[j][i].setGraphic(new ImageView(TrongSuot));
					System.out.print(i+","+j+" ");
				}
			}
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
		for (int i=0; i<5; i++) {
			for (int j=0; j<7; j++) {
				Cell cell = new Cell(i,j);
				boardView[i][j].setOnAction(new MoveEvent(i,j,this));
			}
		}
	}
	
	public void moveEvent(Cell cell) {
		
		if (flag == false && !controller.getData().get(cell.getCol(), cell.getRow()).equals("##")) {
			flag = true;
			movePossible = legalMove.allMove(cell.getCol(), cell.getRow(),controller.getData().getBoardData());
			move1=cell;
			
			for (int i=0; i<29; i++) {
				if (movePossible[i]!=null) {
					
//					boardView[movePossible[i].getCol()][movePossible[i].getRow()
					boardView[movePossible[i].getCol()][movePossible[i].getRow()].setStyle("-fx-background-color: #69ff69;");
				}
			}
//			System.out.println(cell.getCol()+" "+cell.getRow());
		}
//		else if (flag == true && cell==move1) {
//			flag = false;
//		}
		else {
//			System.out.println(cell.getCol()+" "+cell.getRow());
			boolean isMove = true;
			for (int i=0; i<29; i++) {
				if (movePossible[i]!=null) {
					boardView[movePossible[i].getCol()][movePossible[i].getRow()].setStyle("");
					
//					Cell temp = new Cell(cell.getCol(),cell.getRow());
					
					if (movePossible[i].getCol()==cell.getRow() && movePossible[i].getRow()==cell.getCol()) {
						isMove = true;
					}
				}
				
			}
			flag = false;
			if (isMove==true) {
				controller.set(controller.getData().get(move1.getCol(), move1.getRow()), cell.getCol(), cell.getRow());
				controller.set("###", move1.getCol(), move1.getRow());
			}
			updateBoard(controller.getData().getBoardData());
		}
	}
}
