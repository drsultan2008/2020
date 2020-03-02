package application;

import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;

public class event extends Control{
	event(){
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mE) {
				System.out.print(mE.getSceneX()+":"+mE.getSceneY()+" ");
			}
		});
	}
}
