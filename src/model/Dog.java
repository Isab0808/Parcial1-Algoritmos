package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import processing.core.PApplet;
import processing.core.PFont;

public class Dog implements Comparable<Dog> {
	
	private PApplet app;
	private int id;
	private String name,breed;
	private Date age;
	private String date;
	private int width,height;
	private PFont font;
	
	int posY = 250;
	int posYtext = 271;
	
	public Dog(PApplet app,int id,String name,Date age,String breed) {
		
		this.app=app;
		this.id=id;
		this.name=name;
		this.breed=breed;
		this.age=age;	
		width=250;
		height=120;
		font = app.createFont("OpenSansCondensed-Light.ttf", 20);
	}
	
	
	public void Draw(int posX) {

		String pattern = "dd-MM-yyyy";
		app.textFont(font,17);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		date = simpleDateFormat.format(this.age);
		app.fill(255);
		app.rect(posX, posY, width, height);
		app.fill(0);
		app.text("Id : " + id, posX + 10, posYtext);
		app.text("Name : " + name, posX + 10, posYtext + 21);
		app.text("Breed : " + breed, posX + 10, posYtext + 21 * 2);
		app.text("Date : " + date, posX + 10, posYtext + 21 * 3);
	}

	@Override
	public int compareTo(Dog dog2) {
		// TODO Auto-generated method stub
		
		//Aquí se compara los perros por id
		return this.id - dog2.getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}


	public Date getAge() {
		return age;
	}


	public void setAge(Date age) {
		this.age = age;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
}
