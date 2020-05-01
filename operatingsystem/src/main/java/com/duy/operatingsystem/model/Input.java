package com.duy.operatingsystem.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Input {
	private String process = "Hello";
	private String burst = "Hello";
	private String arrivalTime;
	private String quantumTime;
	private String page;
	private String frame;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public Input(){
	}

	public String getQuantumTime() {
		return quantumTime;
	}

	public void setQuantumTime(String quantumTime) {
		this.quantumTime = quantumTime;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getBurst() {
		return burst;
	}

	public void setBurst(String burst) {
		this.burst = burst;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
}
