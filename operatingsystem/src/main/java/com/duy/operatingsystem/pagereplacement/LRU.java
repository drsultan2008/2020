package com.duy.operatingsystem.pagereplacement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LRU implements PageReplacement {

	private HashMap<Integer,Integer> map;
	private LinkedHashMap<Integer,Integer> mapPage;
	private PriorityQueue<Tiny> queue;
	private String[][] table;
	private int errors;
	private String linePage;
	
	public LRU(int[] page, int frame) {
		map = new HashMap<>();
		mapPage = new LinkedHashMap<>();
		queue = new PriorityQueue<>(new TinyComparation());
		
		table = new String[frame + 1][page.length + 1];
		errors = 0;

		for (int i = 0; i <= frame; i++) {
			for (int j = 0; j <= page.length; j++) {
				table[i][j] = "|&nbsp;_&nbsp;|";
			}
		}

		for (int i = 0; i < frame; i++) {
			table[i][0] = "|&nbsp;&nbsp;F" + (i + 1) + "&nbsp;&nbsp;:";
		}
		table[frame][0] = "|Fault:";

		process(page, frame);	
	}
	
	private void process(int[] page, int frame) {
		
		for (int i=0; i<page.length; i++) {
			if (queue.size()<frame) {
				queue.add(new Tiny(page[i], queue.size()));
				map.put(page[i], page[i]);
				table[frame][i + 1] = "|&nbsp;L&nbsp;|";
				errors++;
			}
			else if (!map.containsKey(page[i])) {
				int max = Integer.MIN_VALUE;
				Tiny tinyMax = null;
				
				for (Tiny iter:queue) {
					for (int j=i-1; j>=0; j--) {
						if (iter.getI()==page[j]) {
							if (max < (i-j)) {
								max = i-j;
								tinyMax = iter;
							}
							break;
						}
					}
					
				}
				
				queue.remove(tinyMax);
				queue.add(new Tiny(page[i],tinyMax.getPos()));
				map.remove(tinyMax.getI());
				map.put(page[i],page[i]);
				
				table[frame][i + 1] = "|&nbsp;L&nbsp;|";
				errors++;
				
			} 
			
			for (Tiny iter : queue) {
				table[iter.getPos()][i + 1] = "|&nbsp;" + Integer.toString(iter.getI()) + "&nbsp;|";
			}
			
		}
		
		linePage = "|Page:";
		for (int i=0; i<page.length; i++) {
			linePage+="|&nbsp;"+page[i]+"&nbsp;|";
		}
	}
	
	@Override
	public List<String> showTable() {
		List<String> text = new ArrayList<>();
		String line = "";
		int numChar = 5*(table[0].length-1) + 8;

		for (int i=0; i<numChar; i++) {
			line+="-";
		}
		
		System.out.println("LRU Table replacement: ");
		text.add("LRU&nbsp;Table&nbsp;replacement: ");
		text.add(line);
		text.add(linePage);
		
		text.add(line);
		
		System.out.println(line);
		System.out.println(linePage);
		System.out.println(line);
		
		for (String[] arr : table) {
			for (String i : arr) {
				System.out.print(i);
			}
			System.out.println();
			System.out.println(line);
		}
		
		for (String[] arr:table) {
			String tmp = "";
			for (String i:arr) {
				tmp+=i;
			}
			text.add(tmp);
			text.add(line);
			
		}
		
		System.out.println("Sum errors = "+errors + ".");
		text.add("Sum&nbsp;errors = "+Integer.toString(errors) + ".");
		return text;
	}

}
