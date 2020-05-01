package com.duy.operatingsystem.scheduling;

public class Process {
	private double arrivalTime;
	private double burstTime;
	private int process;
	private double waitTime;
	private double aroundTime;
	
	public Process(double arrivalTime, double burstTime, int process) {
		super();
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.process = process;
	}
	
	public Process(double burstTime, int process) {
		this.burstTime = burstTime;
		this.process = process;
	}
	
	public Process(Process x) {
		arrivalTime = x.getArrivalTime();
		burstTime = x.getBurstTime();
		process = x.getProcess();
		waitTime = x.getWaitTime();
		aroundTime = x.getAroundTime();
	}

	public double getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(double burstTime) {
		this.burstTime = burstTime;
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		this.process = process;
	}

	public double getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(double waitTime) {
		this.waitTime = waitTime;
	}

	public double getAroundTime() {
		return aroundTime;
	}

	public void setAroundTime(double aroundTime) {
		this.aroundTime = aroundTime;
	}

	@Override
	public String toString() {
		return "Process [arrivalTime=" + arrivalTime + ", burstTime=" + burstTime + ", process=" + process
				+ ", waitTime=" + waitTime + ", aroundTime=" + aroundTime + "]";
	}

}
