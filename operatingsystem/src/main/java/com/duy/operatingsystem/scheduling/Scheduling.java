package com.duy.operatingsystem.scheduling;

import java.util.List;

public interface Scheduling {
	public List<String> showGain();
	public List<String> showWaitingTime();
	public List<String> showAroundTime();
}
