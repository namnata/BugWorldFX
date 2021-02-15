package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;


public class Plant extends ImageView{
	
	private int x, y;
	private String name;
	private char symbol;
	private int size;
	private float dy;
	private int energy;
	private float dx;
	
	
	public Plant(double centerX, double centerY, double radius, float dy,float dx, int energy, String imgPath) {
		super(imgPath);
		new Circle();
		setTranslateX(centerX);
		setTranslateY(centerY);
		this.dy=dy;
		this.dx=dx;
		this.energy=energy;
		
	}
	
	public Plant(String name, char symbol, int x, int y, int size, String imgPath) {
		this.x=x;
		this.y=y;
		try {
			setImage(new Image(new FileInputStream(imgPath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.setLayoutX(x);
		this.setLayoutY(y);
		this.setFitHeight(size);
		this.setFitWidth(size);
	}

	

}
