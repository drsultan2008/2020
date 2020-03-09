package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class BoardView extends GridPane implements Initializable {
	private URL url;
	private Image Tot, Hum, BTom,background;
	private int squareSize = 20;
	
	@FXML
	private AnchorPane anPane;

	@FXML
	private JFXRadioButton button1;
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void boardView(){
		url = getClass().getResource("/application/images/");
		Tot = new Image(url+"Tot.png",squareSize,squareSize,true,true);
		BTom = new Image(url+"BTom.png",squareSize,squareSize,true,true);
		Hum = new Image(url+"Hum.png",squareSize,squareSize,true,true);
		background = new Image(url+"board.jpg",squareSize,squareSize,true,true);
		button1.setGraphic(new ImageView(Tot));
	}
}
