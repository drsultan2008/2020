package Exercies;

import java.util.Comparator;

public class SortByScore implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		if (a.getScore() == b.getScore()) {
			return 0;
		}
		else if (a.getScore()>b.getScore()) {
			return -1;
		}
		else {
			return 1;
		}
	}

}
