package model;

import java.util.Comparator;

public class CompareBreed implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o1.getBreed().compareTo(o2.getBreed());
	}

}
