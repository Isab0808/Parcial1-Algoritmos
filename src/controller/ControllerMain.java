package controller;

import java.util.LinkedList;

import model.Dog;
import model.Logic;
import processing.core.PApplet;

public class ControllerMain {

	public PApplet app;
	private Logic logic;
	
	public ControllerMain(PApplet app) {
		
		this.app=app;
		logic = new Logic(app);
		
	}
	
	public LinkedList<Dog> dogs(){
		
		return logic.getDogs();
	}
	
	
	public void GenerateDogs() {
		
		logic.GenerateDogs();
	}

	public void Order(int keyCode) {
		// TODO Auto-generated method stub
		
		logic.Order(keyCode);
		
	}
	
	
}
