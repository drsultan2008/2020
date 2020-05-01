package com.duy.operatingsystem.scheduling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobin implements Scheduling {
	private Queue<Process> processes ;
	private double quantumTime;
	private List<Process> res;
	private double[] waitTime;
	private HashMap<Integer,Process> map ;
	
	public RoundRobin(double[] arrivalTime,double[] burstTime,double quantumTime) {
		processes = new LinkedList<>();
		res = new ArrayList<>();
		waitTime = new double[arrivalTime.length+1];
		map = new HashMap<>();
		
		this.quantumTime = quantumTime;
		
		for (int i=0; i<burstTime.length; i++) {
			processes.add(new Process(arrivalTime[i],burstTime[i],i+1));
			map.put(i+1,new Process(arrivalTime[i],burstTime[i],i+1));
		}
		
		Process odd = new Process(-1,-1,0);
		double time = 0;
		
		while (processes.size()>0) {
			Process curr = processes.poll();
			if (curr.getBurstTime()>quantumTime) {
				curr.setBurstTime(curr.getBurstTime()-quantumTime);
				Process tmp = new Process(odd.getAroundTime(),curr.getBurstTime(),curr.getProcess());
				tmp.setWaitTime(quantumTime);
				time += quantumTime;
				tmp.setAroundTime(time);
				
				res.add(tmp);
				processes.add(curr);
				odd = tmp;
			}
			else {
				Process tmp = new Process(odd.getAroundTime(),curr.getBurstTime(),curr.getProcess());
				tmp.setWaitTime(curr.getBurstTime());
				time += curr.getBurstTime();
				tmp.setAroundTime(time);
				res.add(tmp);
				odd = tmp;
			}
		}
		
	}
	
	@Override
	public List<String> showGain() {
		List<String> text = new ArrayList<>();
		System.out.println("Gaintt:");
		text.add("Gaintt:");
		String line1 = "---";
		String line2 = "0.0";
		for (Process i:res) {
			String line = "";
			for (int j=0; j<i.getAroundTime(); j+=quantumTime) {
				line+="-";
			}
			
			
			String left = line.substring(0,line.length()/2);
			String right = line.substring(line.length()/2+1);
			String tmp = left + "P" + i.getProcess() + right;
			
			String space ="";
			for (int j=0; j<Double.toString(i.getAroundTime()).length(); j++) {
				space+="-";
			}
			
			line2+="-"+line+Double.toString(i.getAroundTime());
			
			line1+=tmp+space;
		}
		System.out.println(line1);
		System.out.println(line2);
		System.out.println();
		text.add(line1);
		text.add(line2);
		return text;
	}

	@Override
	public List<String> showWaitingTime() {
		List<String> text = new ArrayList<>();
		Process curr = new Process(-1,-1,0);
		// waitTime ~ startTime
		
		for (int i=1; i<waitTime.length; i++) {
			for (Process iter:res) {
				if (iter.getProcess() == i) {
					waitTime[i]=iter.getArrivalTime()-map.get(i).getArrivalTime();
					curr =iter;
					for (Process iter2:res) {
						if (iter2.getProcess()==i) {
							if (iter2!=iter) {
								waitTime[i]+=iter2.getArrivalTime()-curr.getAroundTime();
							}
							curr=iter2;
						}
					}
					break;
				}
			}
		}
		
		System.out.println("Wait time:");
		text.add("Wait time");
		double sum = 0;
		String temp = "";
		for (int i=1; i<waitTime.length; i++) {
			System.out.print("P"+i+":"+waitTime[i]+". ");
			sum+=waitTime[i];
			temp+="P"+i+":"+waitTime[i]+".&nbsp;";
		}
		text.add(temp);
		System.out.print("AVG:"+(double)sum/(waitTime.length-1));
		text.add("AVG:"+Double.toString((double)sum/(waitTime.length-1)));
		System.out.println();
		System.out.println();
		return text;
	}

	@Override
	public List<String> showAroundTime() {
		List<String> text = new ArrayList<>();
		System.out.println("Save time:");
		text.add("Save time:");
		double sum = 0;
		String temp = "";
		for (int i=1; i<=map.size(); i++) {
			map.get(i).setAroundTime(waitTime[i]+map.get(i).getBurstTime());
			System.out.print("P"+i+":"+map.get(i).getAroundTime()+". ");
			sum+=map.get(i).getAroundTime();
			temp+="P"+i+":"+map.get(i).getAroundTime()+".&nbsp;";
		}
		text.add(temp);
		System.out.print("AVG:"+(double)sum/(waitTime.length-1));
		text.add("AVG:"+Double.toString((double)sum/(waitTime.length-1)));
		System.out.println();
		return text;
	}

}
