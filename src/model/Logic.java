package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	private String[] txt1,txt2,info1,info2,exportAge,exportBreed,exportName,exportId;
	private String name,breed;
	Date date;
	private int id;
	private CompareAge compareAge;
	private CompareBreed compareBreed;
	private CompareName compareName;
	
	private LinkedList<Dog> dogs;
	
	
	public Logic (PApplet app){
		
		this.app=app;
		txt1= app.loadStrings("./imports/txt1.txt");
		txt2= app.loadStrings("./imports/txt2.txt");
		dogs=new LinkedList<Dog>();
		compareAge= new CompareAge();  
		compareBreed = new CompareBreed();
		compareName= new CompareName();
		exportAge = new String[5]; //determina la cantidad de lineas del txt
		exportBreed = new String[5];
		exportId = new String[5];
		exportName = new String[5];
	
	
			
	}


	public LinkedList<Dog> getDogs() {
		return dogs;
	}


	public void setDogs(LinkedList<Dog> dogs) {
		this.dogs = dogs;
	}


	public void GenerateDogs() {
	
		for (int i=0;i<txt1.length;i++) {
			
			info1 = txt1[i].split(" ");
			id= Integer.parseInt(info1[0]);
			name = info1[1].toLowerCase();
			
			// txt 2
			for(int j=0;j<txt2.length;j++) {
				
				info2 = txt2[j].split(" ");
				
				if(id==Integer.parseInt(info2[0])) {
					
					breed = info2[1];
					
					try {
						date = new SimpleDateFormat("dd-MM-yyyy").parse(info2[2]);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					dogs.add(new Dog(app, id, name, date, breed));
						
				}
			}
			
		}
		
	}


	public void Order(int keyCode) {

		switch (keyCode) {
		
		
		//id
		case 73:
			
			Collections.sort(dogs);
			
			for(int i = 0;i<dogs.size();i++) {
				
				String line = dogs.get(i).getId() + "," + dogs.get(i).getName() + "," +dogs.get(i).getDate() + "," + dogs.get(i).getBreed();
				exportId[i] = line;
				app.saveStrings(app.dataPath("id.txt"), exportId);	
			}
			
			break;

			//nombre 
		case 78:
			
			Collections.sort(dogs,compareName);
			
			for(int i = 0;i<dogs.size();i++) {
				
				String line = dogs.get(i).getId() + "," + dogs.get(i).getName() + "," +dogs.get(i).getDate() + "," + dogs.get(i).getBreed();
				exportName[i] = line;
				app.saveStrings(app.dataPath("name.txt"), exportName);	
			}
			break;
			
		//edad	
		case 69:
			
			Collections.sort(dogs,compareAge);
			
			for(int i = 0;i<dogs.size();i++) {
				
				String line = dogs.get(i).getId() + "," + dogs.get(i).getName() + "," +dogs.get(i).getDate() + "," + dogs.get(i).getBreed();
				exportAge[i] = line;
				app.saveStrings(app.dataPath("age.txt"), exportAge);	
			}
			break;
		
			//raza
		case 82:
			
			Collections.sort(dogs,compareBreed);
			
			for(int i = 0;i<dogs.size();i++) {
				
				String line = dogs.get(i).getId() + "," + dogs.get(i).getName() + "," +dogs.get(i).getDate() + "," + dogs.get(i).getBreed();
				exportBreed[i] = line;
				app.saveStrings(app.dataPath("breed.txt"), exportBreed);	
			}
			break;
			
		
		}
	}
	
	
}
