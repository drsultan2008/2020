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
	 if(!(play.data.cpuMove))
        {
            play.data.move(cell);
//		 		play.data.pcMakeMove();
            if((play.data.cpuMove))
            {
//            	System.out.print("ok");
                play.data.pcMakeMove();
            }
        }
	}
}
