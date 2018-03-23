package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		int count = 0;
		primaryStage.setTitle("FastClicker");
		Button btn = new Button();
		btn.setText("Click me~");
		btn.setOnAction(new EventHandler<ActionEvent>()	//if button gets pressed
				{
					@Override
					public void handle(ActionEvent event) //how do u make a counter for this
					{
						count++;	//this is where the button prints out hello world
					}
				});
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
