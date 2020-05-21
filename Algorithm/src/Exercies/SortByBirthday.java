package Exercies;

import java.util.Comparator;

public class SortByBirthday implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		return a.getBirthDay().compareTo(b.getBirthDay());
	}

}
