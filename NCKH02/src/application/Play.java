package application;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class Play extends GridPane{
	Data data;
	Play(Data data){
		this.data=data;
	}
	
	void set2() {
		BackgroundImage backgroundImage = new BackgroundImage(data.background,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        
        drawBoard();
        updateBoard();
        if (data.num == 1) {
        	for (int i=0; i<5; i++) {
    			for (int j=0; j<7; j++) {
    				Cell cell = new Cell(i,j);
    				data.boardView[i][j].setOnAction(new MoveEvent(i,j,this));
    			}
    		}
            
            if(data.cpuMove)
            {
                data.pcMakeMove();
                updateBoard();
            }
        }
        
        
	}
	
	void set() {
		BackgroundImage backgroundImage = new BackgroundImage(data.background,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        
        drawBoard();
        updateBoard();
        if (data.num == 1) {
        	for (int i=0; i<5; i++) {
    			for (int j=0; j<7; j++) {
    				Cell cell = new Cell(i,j);
    				data.boardView[i][j].setOnAction(new MoveEvent(i,j,this));
    			}
    		}
            
            if(data.cpuMove)
            {
                data.pcMakeMove();
                updateBoard();
            }
        }
        
        
	}

	void drawBoard() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<7; j++) {
				data.boardView[i][j] = new Button();
				data.boardView[i][j].setMinSize(40, 40);
				if (i==0 && j==0 || i==0 && j==1|| i==1 && j==0 || i==3 && j==0 || i==4 && j==0 || i==4 && j==1 )
					continue;
				add(data.boardView[i][j],i+1,j+1);
				getStylesheets().add(getClass().getResource("playStyle.css").toExternalForm());
				setVgap(40);
				setHgap(25);
			}
		}
	}
	
	void updateBoard() {
		for (int i=0; i<7; i++) {
			for (int j=0; j<5; j++) {
				if (data.board.boardData[i][j].equals("Tot")) {
					data.boardView[j][i].setGraphic(new ImageView(data.Tot));
				}
				if (data.board.boardData[i][j].equals("Hum")) {
					data.boardView[j][i].setGraphic(new ImageView(data.Hum));
				}
				if (data.board.boardData[i][j].equals("TTom")) {
					data.boardView[j][i].setGraphic(new ImageView(data.BTom));
				}
				else if (data.board.boardData[i][j].equals("###")){
					data.boardView[j][i].setGraphic(new ImageView(data.TrongSuot));
//					System.out.print(i+","+j+" ");
				}
			}
		}
	}
}
