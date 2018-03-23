
public class Timer
{
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Clickerizer!")
		Button btn = new Button();
		Text txt = new Text(10,0, "Click Score");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(scoring)
				{
					score++;
				}
				else
				{
					score--;
				}
			}
		});
		
		timeStep = System.nanoTime() + 1000000000L;
		new AnimationTime()
		{
			public void handle(long now)
			{
				if (now > timeStep)
				{
					timeStep = now + 1000000000L;
					scoring = !scoring;
				}
				if (!scoring)
				{
					btn.setText("Don't Click");
				}
				else
				{
					btn.setText("Click Me!");
				}
				
				txt.setText("Score:" + Integer.toString(score));
			}
		}.start();
		
		StackPane root = new StackPane();
		HBox hbox  = new HBox();
		hbox.getChildren().addAll(btn.txt);
	}
}
