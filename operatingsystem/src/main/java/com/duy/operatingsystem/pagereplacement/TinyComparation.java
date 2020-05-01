package com.duy.operatingsystem.pagereplacement;

import java.util.Comparator;

public class TinyComparation implements Comparator<Tiny> {

	@Override
	public int compare(Tiny a, Tiny b) {
		if (a.getI()<b.getI()) {
			return -1;
		}
		else if (a.getI()>b.getI()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
}
