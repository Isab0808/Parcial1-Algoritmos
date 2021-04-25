package view;

import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	private ControllerMain controllerMain;
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		PApplet.main("view.Main");
		
		
	}
	
	public void settings() {
		
		size(1280,720);
	}
	PImage fondo;
	
	public void setup() {
		
		fondo = loadImage("PetShop.jpg");
		
		controllerMain= new ControllerMain(this);
		
		controllerMain.GenerateDogs();
	}
	
	
	public void draw() {

		background(0);
		
		image(fondo, 0, 0);
		
		for (int i = 0; i < controllerMain.dogs().size(); i++) {

				//cambiar el que se multiplica por la i para el espaciado
			controllerMain.dogs().get(i).Draw(14 + (250 * i));
		}
		
		fill(0);
		text("Ordenar por ID", 240, 650);
		
		text("Ordenar por Edad", 540, 650);
		
		text("Ordenar por Raza", 835, 650);
		
		text("Ordenar por Nombre", 1135, 650);
		
		
	}
	
	public void keyPressed() {
		
		controllerMain.Order(keyCode);
	
	}

}
