package com.duy.operatingsystem.scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SJF implements Scheduling {
	
	private PriorityQueue <Process> processes;
	private List<Process> res ;
	
	public SJF(double[] arrivalTime, double[] burstTime) {
		processes = new PriorityQueue<Process>(new ComparatorBurstTime());
		res = new ArrayList<>();
		
		for (int i=0; i<arrivalTime.length; i++) {
			processes.add(new Process(arrivalTime[i],burstTime[i],i+1));
		}
		
		double time = 0;
		for(Process i:processes) {
			if (i.getArrivalTime()==0) {
				time = i.getBurstTime();
				i.setWaitTime(0);
				i.setAroundTime(i.getBurstTime());
				res.add(i);
				processes.remove(i);
				break;
			}
		}
		
		while (processes.size()>0) {
			for (Process i:processes) {
				if (i.getArrivalTime()<=time) {
					i.setWaitTime(time-i.getArrivalTime());
					time+=i.getBurstTime();
					i.setAroundTime(i.getWaitTime()+i.getBurstTime());
					res.add(i);
					processes.remove(i);
					break;
				}
			}
		}
		
	}
	
	@Override
	public List<String> showGain() {
		List<String> text = new ArrayList<>();
		System.out.println("Gaintt:");
		String line1 = "";
		String line2 = "0.0";
		double sum=0;
		for (Process i:res) {
			String line = "";
			for (int j=0; j<i.getBurstTime(); j++) {
				line+="-";
			}
			
			
			String left = line.substring(0,line.length()/2);
			String right = line.substring(line.length()/2+1);
			String tmp = left + "P" + i.getProcess() + right;
			
			String space ="";
			for (int j=0; j<Double.toString(sum).length(); j++) {
				space+="&nbsp;";
			}
			
			sum+=i.getBurstTime();
			line2+="-"+line+Double.toString(sum);
			
			line1+=space+tmp;
		}
		System.out.println(line1);
		System.out.println(line2);
		text.add("Gaintt: ");
		text.add(line1);
		text.add(line2);
		return text;
	}

	@Override
	public List<String> showWaitingTime() {
		List<String> text = new ArrayList<>();
		System.out.println("Wait time:");
		text.add("Wait time:");
		double sum = 0;
		String tmp = "";
		for (Process i:res) {
			System.out.print("P"+i.getProcess()+":"+i.getWaitTime()+". ");
			tmp+="P"+i.getProcess()+":"+i.getWaitTime()+".&nbsp;";
			sum+=i.getWaitTime();
		}
		text.add(tmp);
		System.out.print("AVG:"+(double)sum/res.size());
		text.add("AVG:"+Double.toString((double)sum/res.size()));
		System.out.println();
		return text;
	}

	@Override
	public List<String> showAroundTime() {
		List<String> text = new ArrayList<>();
		System.out.println("Save time:");
		text.add("Save time:");
		double sum=0;
		String tmp = "";
		for (Process i:res) {
			System.out.print("P"+i.getProcess()+":"+i.getAroundTime()+". ");
			sum+=i.getAroundTime();
			tmp+="P"+i.getProcess()+":"+i.getAroundTime()+".&nbsp;";
		}
		text.add(tmp);
		System.out.print("AVG:"+(double)sum/res.size());
		text.add("AVG:"+Double.toString((double)sum/res.size()));
		System.out.println();
		return text;
	}	

}
