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

public class Menu extends GridPane{
	Data data;
	Button chonHum,chonTom;
	Menu (Data data){
		this.data=data;
		chonHum = new Button("",new ImageView(data.chonHum));
		chonTom = new Button("",new ImageView(data.chonTom));
		BackgroundImage menuBackground = new BackgroundImage(data.menuBackground,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(menuBackground));
        getStylesheets().add(getClass().getResource("menuStyle.css").toExternalForm());
        
    	add(chonHum,10,10);
    	add(chonTom,10,11);
    	
    	chonHum.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.setPlayerHum();
            }
        });
    	
    	chonTom.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent actionEvent) {
    			data.setPlayerTom();
    		}
    	});
    	setVgap(20);
        setHgap(6);
	}
}
