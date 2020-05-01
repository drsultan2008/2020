package com.duy.operatingsystem.pagereplacement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FIFO implements PageReplacement {
	private HashMap<Integer, Integer> map;
	private Queue<Tiny> queue;
	private String[][] table;
	private int errors;
	private String linePage;

	public FIFO(int[] page, int frame) {
		map = new HashMap<>();
		queue = new LinkedList<>();
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
		for (int i = 0; i < page.length; i++) {
			if (queue.size() < frame) {
				queue.add(new Tiny(page[i], queue.size()));
				map.put(page[i], page[i]);
				table[frame][i + 1] = "|&nbsp;L&nbsp;|";
				errors++;
			} else if (!map.containsKey(page[i])) {
				Tiny tmp = queue.poll();
				map.remove(tmp.getI());
				map.put(page[i], page[i]);
				queue.add(new Tiny(page[i], tmp.getPos()));
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
		
		System.out.println("FIFO Table replacement: ");
		text.add("FIFO&nbsp;Table&nbsp;replacement: ");
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
