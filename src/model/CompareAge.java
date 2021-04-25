package model;

import java.util.Comparator;

public class CompareAge implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o1.getAge().compareTo(o2.getAge());
	}

}
