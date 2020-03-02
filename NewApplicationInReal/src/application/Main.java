package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox vbox =new VBox();
			Text msg = new Text("Mẹ nhập vào số trang cần in: ");
			msg.setY(20);
			msg.setX(20);
			msg.setFont(Font.font(20));
			Text begin = new Text("Từ trang:");
			begin.setFont(Font.font(20));
			TextField tf1 = new TextField();
			Text end = new Text("Đến trang:");
			end.setFont(Font.font(20));
			TextField tf2 = new TextField();
			HBox hbox = new HBox();
			Button sub = new Button("Tạo trang");
			sub.setMinSize(50, 30);
			hbox.getChildren().add(sub);		
			hbox.setAlignment(Pos.CENTER);
			hbox.setStyle("-fx-padding:10;");
			vbox.getChildren().addAll(msg,begin,tf1,end,tf2,hbox);
			
			Scene scene = new Scene(vbox,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.cs1s").toExternalForm());
			
			scene.setOnKeyPressed(e -> {
			    if (e.getCode() == KeyCode.ENTER) {
			    	int x,y;
					try {
						x = Integer.parseInt(tf1.getText());
						y = Integer.parseInt(tf2.getText());			
					}catch(Exception ee){
						x=0;
						y=0;
					}
					
					String even = "",odd="";
					int c1=0,c2=0;
					for (int i=x; i<=y; i++) {
						if (i%2!=0) {
							odd+=Integer.toString(i);
							odd+=",";
							c1++;
						}
					}
					for (int i=y; i>=x; i--) {
						if (i%2==0) {
							even+=Integer.toString(i);
							even+=",";
							c2++;
						}
					}
					Text resOdd = new Text(odd.substring(0, odd.length()-1));
					Text resEven = new Text(even.substring(0, even.length()-1));
					
					if (c1!=c2) {
						Text alert = new Text("Cảnh báo: Số trang chẵn lẻ không bằng nhau");
						alert.setFont(Font.font(14));
						alert.setFill(Color.RED);
						alert.setStyle("-fx-padding:10 10 10 10;");
						vbox.getChildren().add(alert);
					}
					String nof = "";
					nof = "In " + Integer.toString(c2) + " trang chẵn và " + Integer.toString(c1) + " trang lẻ.";
					Text msg2 = new Text(nof);
					msg2.setFont(Font.font(14));
					msg2.setFill(Color.RED);
					TextField tfOdd = new TextField(odd.substring(0,odd.length()-1));
					tfOdd.setStyle("-fx-padding: 10;");
					TextField tfEven = new TextField(even.substring(0,even.length()-1));
					tfEven.setStyle("-fx-padding: 10;");
					vbox.getChildren().addAll(msg2,tfOdd,tfEven);
			    }
			});
			
			sub.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					// Alogrithm
					int x,y;
					try {
						x = Integer.parseInt(tf1.getText());
						y = Integer.parseInt(tf2.getText());			
					}catch(Exception ee){
						x=0;
						y=0;
					}
					
					String even = "",odd="";
					int c1=0,c2=0;
					for (int i=x; i<=y; i++) {
						if (i%2!=0) {
							odd+=Integer.toString(i);
							odd+=",";
							c1++;
						}
					}
					for (int i=y; i>=x; i--) {
						if (i%2==0) {
							even+=Integer.toString(i);
							even+=",";
							c2++;
						}
					}
					Text resOdd = new Text(odd.substring(0, odd.length()-1));
					Text resEven = new Text(even.substring(0, even.length()-1));
					
					if (c1!=c2) {
						Text alert = new Text("Cảnh báo: Số trang chẵn lẻ không bằng nhau");
						alert.setFont(Font.font(14));
						alert.setFill(Color.RED);
						alert.setStyle("-fx-padding:10 10 10 10;");
						vbox.getChildren().add(alert);
					}
					String nof = "";
					nof = "In " + Integer.toString(c2) + " trang chẵn và " + Integer.toString(c1) + " trang lẻ.";
					Text msg2 = new Text(nof);
					msg2.setFont(Font.font(14));
					msg2.setFill(Color.RED);
					TextField tfOdd = new TextField(odd.substring(0,odd.length()-1));
					tfOdd.setStyle("-fx-padding: 10;");
					TextField tfEven = new TextField(even.substring(0,even.length()-1));
					tfEven.setStyle("-fx-padding: 10;");
					vbox.getChildren().addAll(msg2,tfOdd,tfEven);
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
