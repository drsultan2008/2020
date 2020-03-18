package application;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Menu2 extends GridPane{
	Data data;
	Button nguoiChoi1,nguoiChoi2;
	Menu2 (Data data){
		this.data=data;
		nguoiChoi1 = new Button("",new ImageView(data.nguoiChoi1));
		nguoiChoi2 = new Button("",new ImageView(data.nguoiChoi2));
		BackgroundImage menuBackground = new BackgroundImage(data.menuBackground,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(menuBackground));
        getStylesheets().add(getClass().getResource("menuStyle.css").toExternalForm());
        
    	add(nguoiChoi1,10,10);
    	add(nguoiChoi2,10,11);
    	
    	nguoiChoi1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.setPlayer1();
            }
        });
    	
    	nguoiChoi2.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent actionEvent) {
    			data.setPlayer2();
    		}
    	});
    	setVgap(20);
        setHgap(6);
	}
}
