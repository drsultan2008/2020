package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveEvent implements EventHandler<ActionEvent>{
	Cell cell;
	Play play;
	MoveEvent(int i, int j, Play play){
		this.cell= new Cell(i,j);
		this.play = play;
	}
	@Override
	public void handle(ActionEvent e) {
		if (play.data.num==1) {
			if(!(play.data.cpuMove))
	        {
	            play.data.move(cell);
	            if((play.data.cpuMove))
	            {
	                play.data.pcMakeMove();
	            }
	        }
		}
		
		if (play.data.num==2) {
			if (play.data.player==play.data.HUM) {
				play.data.move(cell);
				System.out.println("Luot Hum");
//				play.data.player = play.data.TOM;
			}
			else {
				System.out.println("Luot Tom");
				play.data.move(cell);
//				play.data.player = play.data.HUM;
			}
		}
	}
}
