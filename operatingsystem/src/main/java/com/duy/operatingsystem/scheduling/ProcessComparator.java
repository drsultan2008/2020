package com.duy.operatingsystem.scheduling;

import java.util.Comparator;

public class ProcessComparator implements Comparator<Process>{

	@Override
	public int compare(Process a, Process b) {
		if (a.getArrivalTime()>b.getArrivalTime()) {
			return 1;
		}
		else if (a.getArrivalTime()<b.getArrivalTime()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
