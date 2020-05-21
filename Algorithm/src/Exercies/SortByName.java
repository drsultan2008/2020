package Exercies;

import java.util.Comparator;

public class SortByName implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		return a.getName().compareTo(b.getName());
	}

}
