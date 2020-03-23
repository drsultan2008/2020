package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Board extends GridPane{
	Data data = new Data();
	TextField[][] boardView = new TextField[9][9];
	int squareZize = 20;
	Button submit = new Button("Submit");
	Label msg = new Label("False");
	ValidSodoku validSudoku;
	Board(){
		initBoard();
	}
	
	void initBoard() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				boardView[i][j] = new TextField();
				add(boardView[i][j],i,j);
				if (data.getBoard(i,j)!=0) {
					boardView[i][j].setText(Integer.toString(data.getBoard(i, j)));
					boardView[i][j].setEditable(false);
					boardView[i][j].setStyle(" -fx-background-color: red;");
				}
				
//				boardView[i][j].textProperty().addListener(new ChangeListener<String>() {
//				    @Override
//				    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				    	data.setBoard(Integer.parseInt(newValue), i, j);
//				    }
//				});
			}
		}
		add(submit,10,1);
		
		submit.setMinSize(50, squareZize);
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				updateBoard();
				validSudoku = new ValidSodoku(data.getBoardData());
				if (validSudoku.ValidAll()) {
				msg.setText("True");
				}else {
					msg.setText("False");
				}
				add(msg,10,2);
			}
		});
	}
	
	void updateBoard() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (!boardView[i][j].getText().equals("")) {
//					boardView[i][j].setText(boardView[i][j].getText());
					data.setBoard(Integer.parseInt(boardView[i][j].getText()), i, j);
				}
			}
		}
	}
}
