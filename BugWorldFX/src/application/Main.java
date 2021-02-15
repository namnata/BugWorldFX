package application;



import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	int width = 600;
	int height = 600;
	private Group root = new Group();

	float x = 100, y = 100;

	boolean moveBugFlag = false;

	ArrayList<Bug> bugs = new ArrayList<>();
	ArrayList<Plant> plants = new ArrayList<>();

	private void createBug() { // Create Bugs
	
		Bug b1 = new Bug("Ant", 'A', 400, 50, 50, "ladybug.png");
		Bug b2 = new Bug("Ant", 'L', 300, 200, 50, "anotherBug.png");
		Bug b3 = new Bug("Ant", 'B', 150, 150, 50, "ladybug.png");
		Bug b4 = new Bug("Ant", 'B', 350, 150, 50, "ladybug.png");

		bugs.add(b1);
		bugs.add(b2);
		bugs.add(b3);
		bugs.add(b4);
		
			
	}
	
	private void createMore() { // Create more Bugs
		

		Bug b5 = new Bug("Ant", 'A', 500, 500, 50, "ladybug.png");
		Bug b6 = new Bug("Ant", 'L', 100, 100, 50, "anotherBug.png");
		Bug b7 = new Bug("Ant", 'B', 250, 250, 50, "ladybug.png");
		
		bugs.add(b5);
		bugs.add(b6);
		bugs.add(b7);
		
		root.getChildren().add(b5);
		root.getChildren().add(b6);
		root.getChildren().add(b7);
		
		}
		
		
	private void createPlant() {// Create Plants
	
		Plant p1 = new Plant("Flower", 'F', 80, 300, 50, "sunflower.png.png");
		Plant p2 = new Plant("Flower", 'S', 200, 60, 50, "rose.gif");
		Plant p3 = new Plant("Flower", 'B', 40, 150, 50, "sunflower.png.png");
		Plant p4 = new Plant("Flower", 'B', 400, 400, 50, "rose.gif");
		Plant p5 = new Plant("Flower", 'B', 300, 500, 50, "sunflower.png.png");

		plants.add(p1);
		plants.add(p2);
		plants.add(p3);
		plants.add(p4);
		plants.add(p5);
		
	}

	@Override
	public void start(Stage primaryStage) {

		
		createBug();
		createPlant();

		HBox hBox = new HBox();
		VBox vBox = new VBox();
		hBox.setPrefSize(600, 600);
		vBox.setPrefWidth(600);
		
		//Group root = new Group();
		root.prefHeight(600);
		root.prefWidth(600);

		// Creating add button
		Button addButton = new Button("Add Bugs");
		addButton.setPrefSize(80, 20);

		// Creating play button
		Button playButton = new Button("Move Bugs");
		playButton.setPrefSize(80, 20);

		// Creating stop button
		Button stopButton = new Button("Stop Bugs");
		stopButton.setPrefSize(80, 20);
		
		// Creating stop button
		Button clearButton = new Button("Clear Bugs");
		clearButton.setPrefSize(80, 20);


		// Putting all children to root group
		root.getChildren().addAll(bugs);
		root.getChildren().addAll(plants);
		root.getChildren().add(addButton);
		root.getChildren().add(playButton);
		root.getChildren().add(stopButton);
		root.getChildren().add(clearButton);

		vBox.getChildren().addAll(addButton, playButton, stopButton, clearButton);

		root.getChildren().addAll(vBox);
		
		// Creating a scene object
		final Scene scene = new Scene(root, width, height);
		
		scene.setFill(Color.GREEN);

		// Adding Animation
		Timeline t = new Timeline();
		for (Bug b : this.bugs) {
					
			KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					if (moveBugFlag == false)
						return;
					double dx = 0;
					double dy = 0;
					Bug bug = b;
					int r = bug.getRand();
					Bounds boundsInScene = bug.localToScene(bug.getBoundsInLocal());

					if (r == 1) {
						dy = -1;
						dx = 0;
					} else if (r == 2) {
						dy=-1;
						dx=1;
					} else if (r == 3) {
						dx = 1;
						dy = 0;
					} else if(r==4) {
						dx = 1;
						dy = 1;
					} else if(r==5) {
						dx=0;
						dy=1;
					} else if(r==6) {
						dx=-1;
						dy=1;
					} else if(r==7) {
						dy=0;
						dx=-1;
					} else if(r==8) {
						dy=-1;
						dx=-1;
					}

					if (boundsInScene.getMinY() <= 0  && (r == 1 || r==2|| r==8)) {
						bug.setRand((int) (Math.random() * 7) + 1);
					} else if (boundsInScene.getMinX() >= 550 && (r == 2||r==3||r==4)) {
						bug.setRand((int) (Math.random() * 7) + 1);
					} else if (boundsInScene.getMinY() >= 550 && (r == 4||r==5||r==6)) {
						bug.setRand((int) (Math.random() * 7) + 1);
					} else if (boundsInScene.getMinX() <= 0 && (r == 6||r==7||r==8)) {
						bug.setRand((int) (Math.random() * 7) + 1);
					}

					bug.setTranslateX(bug.getTranslateX() + dx);
					bug.setTranslateY(bug.getTranslateY() + dy);
				}

			});
			t.getKeyFrames().add(frame);
		}

		t.setCycleCount(javafx.animation.Animation.INDEFINITE);
		t.play();

		// Setting title to the Stage
		primaryStage.setTitle("Bug World Again!");

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();

		// Adding MouseListener for buttons + using Lambda expression
		addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> createMore());

		playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> moveBugs());

		stopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> stopBugs());
		
		clearButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> clear());
	}

	public void clear() {
		root.getChildren().removeAll(bugs);
		
	}

	// Using boolean flag to call method
	public void stopBugs() {
		System.out.println("We stoped moving!");
		this.moveBugFlag = false;
	}

	// Using boolean flag to call method
	public void moveBugs() {
		System.out.println("We are moving!");
		this.moveBugFlag = true;

	}

	// Connecting method with button
	public void addBugs() {

		System.out.println("Add some more guys!");

	}

	public static void main(String[] args) {
		launch(args);
	}
}
