package com.duy.operatingsystem.scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FCFS implements Scheduling {
	// TreeMap<Process,BurstTime>
	private TreeMap<Integer,Integer> map = new TreeMap<>();
	private int[] waitTime;
	private int[] aroundTime;
	private int[] endTime;
	
	public FCFS(int[] processes, int[] burstTime) {
		map.put(0, 0);
		
		for (int i=0; i<processes.length; i++) {
			map.put(processes[i], burstTime[i]);
		}
		waitTime = new int[map.size()];
		aroundTime = new int[map.size()];
		endTime = new int[map.size()];
	}
	
	@Override
	public List<String> showGain() {
		List<String> text = new ArrayList<>();
		String line1 = "";
		String line2 = "";
		int sum=0;
		
		for (int i=1; i<=map.size()-1; i++) {
			String line = "";
			for (int j=0; j<map.get(i); j++) {
				line+="-";
			}
			
			
			String left = line.substring(0,line.length()/2);
			String right = line.substring(line.length()/2+1);
			String tmp = left + "P" + i + right;
			
			sum+=map.get(i-1);
			line2+=Integer.toString(sum)+line+"-";
			
			String space ="";
			for (int j=0; j<Integer.toString(sum).length(); j++) {
				space+="&nbsp;";
			}
			
			line1+=space+tmp;
		}
		
		sum+=map.get(map.size()-1);
		line2+=Integer.toString(sum);
		System.out.println("Gantt:");
		
		text.add("Gantt:");
		text.add(line1);
		text.add(line2);
		
		System.out.println(line1);
		System.out.println(line2);
		
		return text;
	}

	@Override
	public List<String> showWaitingTime() {
		List<String> text = new ArrayList<>();
		
		System.out.println("Wait time: ");
		text.add("Wait&nbsp;time:");
		int res = 0;
		String tmp = "";
		for (int i=1; i<waitTime.length; i++) {
			waitTime[i]=map.get(i-1)+waitTime[i-1];
			System.out.print("P"+i+":"+waitTime[i]+". ");
			tmp+="P"+i+":"+waitTime[i]+". ";
			res+=waitTime[i];
		}
		
		text.add(tmp);
		
		System.out.print("AVG: ");
		String temp = "AVG:&nbsp;" + Double.toString((double)res/(waitTime.length-1));
		text.add(temp);
		System.out.println(((double)res/(waitTime.length-1)));
		
		return text;
	}
	
	@Override
	public List<String> showAroundTime() {
		List<String> text = new ArrayList<>();
		
		System.out.println("Save time: ");
		
		text.add("Save&nbsp;time:");
		
		int res = 0;
		for (int i=1; i<endTime.length; i++) {
			endTime[i]=endTime[i-1]+map.get(i);
		}
		
		String tmp = "";
		
		for (int i=1; i<aroundTime.length; i++) {
			aroundTime[i]=endTime[i]-waitTime[i];
			System.out.print("P"+i+":"+aroundTime[i]+". ");
			res+=aroundTime[i];
			tmp+="P"+i+":"+aroundTime[i]+". &nbsp;";
		}
		
		text.add(tmp);
		
		System.out.print("AVG: ");
		
		System.out.println(((double)res/(aroundTime.length-1)));
		String temp = "AVG:&nbsp;" + Double.toString((double)res/(aroundTime.length-1));
		text.add(temp);
		
		return text;
	}

}
