package com.duy.operatingsystem.scheduling;

import java.util.Comparator;

public class ComparatorBurstTime implements Comparator<Process>{

	@Override
	public int compare(Process a, Process b) {
		if (a.getBurstTime()>b.getBurstTime()) {
			return 1;
		}
		else if (a.getBurstTime()<b.getBurstTime()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
