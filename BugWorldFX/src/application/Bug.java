package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bug extends ImageView {

	// fields
	private String name;
	private int width = 600, height = 600;
	private float dx = -1.5f, dy = -1.5f;
	private int size;
	private int speed;
	private double energy;
	private int posX;
	private int posY;
	private char symbol;
	private int rand;

	// constructor
	public Bug(double centerX, double centerY, double radius, float dy, float dx, int energy, String imgPath) {
		super(imgPath);
		new Circle();
		setTranslateX(centerX);
		setTranslateY(centerY);
		this.dy = dy;
		this.dx = dx;
		this.energy = energy;

	}

	public Bug(String name, char symbol, int x, int y, int size, String imgPath) {
		this.posX = x;
		this.posY = y;
		try {
			setImage(new Image(new FileInputStream(imgPath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.setLayoutX(x);
		this.setLayoutY(y);
		this.setFitHeight(size);
		this.setFitWidth(size);
		rand = (int) (Math.random()*7)+1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

//	public void move() {
//		
//		//make bug move
//		setTranslateX(getTranslateX() + dx);
//		setTranslateY(getTranslateY() + dy);
//		
//		//check horizontal borders
//		if (getTranslateX() - getRadius() <= 0) {
//			setTranslateX(0 + getRadius());
//			dx *= -1;
//		} else if (getTranslateX() + getRadius() >= width) {
//			setTranslateX(width - getRadius());
//			dx *= -1;
//		}
//		
//		//check vertical borders
//		if (getTranslateY() - getRadius() <= 0) {
//			setTranslateY(0 + getRadius());
//			dy *= -1;
//		} else if (getTranslateY() + getRadius() >= height) {
//			setTranslateY(height - getRadius());
//			dy *= -1;
//		}
//
//}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getRand() {
		return rand;
	}

	public void setRand(int rand) {
		this.rand = rand;
	}
	
	

}
