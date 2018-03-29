//Lab 4.3
//Easy Mode
// Cristina Chen and Joyin Wong

package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Main extends Application 
{
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	private long timeStep;
	private int score = 0;		
	private boolean scoring = true;
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Clickerizer!");
		Button btn = new Button();
		Text txt = new Text(10,0, "Click Score");
			
		btn.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) 
		{
			if(scoring)
			{
				score++;
			}
		}
		});	
		timeStep = System.nanoTime() + 10000000000L;
		
		new AnimationTimer()
		{
			public void handle(long now)
			{ 
				if (now > timeStep)
				{
					timeStep = now + 10000000000L;
					scoring = !scoring;
				}
				if (!scoring)
				{
					btn.setText("Ten Second Cooldown...");
					score = 0;
				}
				else
				{
					btn.setText("Click Me!");
				}			
				txt.setText("Score: " + Integer.toString(score));
				
			}
		}.start();
			
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		root.getChildren().add(txt);
		root.setAlignment(txt, Pos.BOTTOM_CENTER);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
		
		}
	}

