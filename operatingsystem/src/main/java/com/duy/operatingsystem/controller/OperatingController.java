package com.duy.operatingsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.duy.operatingsystem.model.Input;
import com.duy.operatingsystem.pagereplacement.FIFO;
import com.duy.operatingsystem.pagereplacement.LRU;
import com.duy.operatingsystem.pagereplacement.NRU;
import com.duy.operatingsystem.pagereplacement.PageReplacement;
import com.duy.operatingsystem.scheduling.FCFS;
import com.duy.operatingsystem.scheduling.RoundRobin;
import com.duy.operatingsystem.scheduling.SJF;
import com.duy.operatingsystem.scheduling.SJFPreemptive;
import com.duy.operatingsystem.scheduling.Scheduling;

@Controller
public class OperatingController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/fcfs")
	public String showFCFS(Model model) {
		Input input = new Input();
		input.setProcess("1 2 3");
		input.setBurst("24 3 3");
		model.addAttribute("input",input);
		return "fcfs";
	}
	
	@GetMapping("/sjn")
	public String showSJN(Model model) {
		Input input = new Input();
		input.setArrivalTime("0 2 4 5");;
		input.setBurst("7 4 1 4");
		model.addAttribute("input",input);
		return "sjn";
	}
	
	@PostMapping("/sjnSubmit")
	public String showResSJN(@ModelAttribute("input") Input input, Model model) {
		String[] splitArrival = input.getArrivalTime().split(" ");
		String[] splitTime = input.getBurst().split(" ");
		
		double[] arrival = new double[splitArrival.length];
		double[] burstTime = new double[splitArrival.length];
		
		for (int i=0; i<arrival.length; i++) {
			arrival[i]=Double.parseDouble(splitArrival[i]);
			burstTime[i]=Double.parseDouble(splitTime[i]);
		}
		
		Scheduling scheduling = new SJF(arrival,burstTime);
		
		List<String> gain = scheduling.showGain();
		List<String> wait = scheduling.showWaitingTime();
		List<String> around = scheduling.showAroundTime();
		
		model.addAttribute("gain",gain);
		model.addAttribute("wait",wait);
		model.addAttribute("around",around);
		
		return "sjnResult";
	}
	
	@GetMapping("/sjf")
	public String showSJF(Model model) {
		Input input = new Input();
		input.setArrivalTime("0 2 4 5");;
		input.setBurst("7 4 1 4");
		model.addAttribute("input",input);
		return "sjf";
	}
	
	@PostMapping("/sjfSubmit")
	public String showResSJF(@ModelAttribute("input") Input input, Model model) {
		String[] splitArrival = input.getArrivalTime().split(" ");
		String[] splitTime = input.getBurst().split(" ");
		
		double[] arrival = new double[splitArrival.length];
		double[] burstTime = new double[splitArrival.length];
		
		for (int i=0; i<arrival.length; i++) {
			arrival[i]=Double.parseDouble(splitArrival[i]);
			burstTime[i]=Double.parseDouble(splitTime[i]);
		}
		
		Scheduling scheduling = new SJFPreemptive(arrival,burstTime);
		
		List<String> gain = scheduling.showGain();
		List<String> wait = scheduling.showWaitingTime();
		List<String> around = scheduling.showAroundTime();
		
		model.addAttribute("gain",gain);
		model.addAttribute("wait",wait);
		model.addAttribute("around",around);
		
		return "sjfResult";
	}
	
	@GetMapping("/rrobin")
	public String showRrobin(Model model) {
		Input input = new Input();
		input.setArrivalTime("0 0 0 0");;
		input.setBurst("53 17 68 24");
		input.setQuantumTime("20");
		model.addAttribute("input",input);
		return "rrobin";
	}
	
	@PostMapping("/rrobinSubmit")
	public String showResRrobin(@ModelAttribute("input") Input input, Model model) {
		String[] splitArrival = input.getArrivalTime().split(" ");
		String[] splitTime = input.getBurst().split(" ");
		String quantumTime = input.getQuantumTime();
		
		double quantum = Double.parseDouble(quantumTime);
		double[] arrival = new double[splitArrival.length];
		double[] burstTime = new double[splitArrival.length];
		
		for (int i=0; i<arrival.length; i++) {
			arrival[i]=Double.parseDouble(splitArrival[i]);
			burstTime[i]=Double.parseDouble(splitTime[i]);
		}
		
		Scheduling scheduling = new RoundRobin(arrival,burstTime,quantum);
		
		List<String> gain = scheduling.showGain();
		List<String> wait = scheduling.showWaitingTime();
		List<String> around = scheduling.showAroundTime();
		
		model.addAttribute("gain",gain);
		model.addAttribute("wait",wait);
		model.addAttribute("around",around);
		
		return "rrobinResult";
	}
	
	@PostMapping("/fcfsSubmit")
	public String showRes(@ModelAttribute("input") Input input, Model model) {
		String[] splitProcess = input.getProcess().split(" ");
		String[] splitTime = input.getBurst().split(" ");
		
		int[] process = new int[splitProcess.length];
		int[] burstTime = new int[splitProcess.length];
		
		for (int i=0; i<process.length; i++) {
			process[i]=Integer.parseInt(splitProcess[i]);
			burstTime[i]=Integer.parseInt(splitTime[i]);
		}
		
		Scheduling scheduling = new FCFS(process,burstTime);
		
		List<String> gain = scheduling.showGain();
		List<String> wait = scheduling.showWaitingTime();
		List<String> around = scheduling.showAroundTime();
		
		model.addAttribute("gain",gain);
		model.addAttribute("wait",wait);
		model.addAttribute("around",around);
		
		return "fcfsResult";
	}
	
	@GetMapping("/fifo")
	public String showFIFO(Model model) {
		Input input = new Input();
		input.setPage("1 2 3 4 1 5 6 2 1 2 3 7 6 3 2 1 2 3 6 1");
		input.setFrame("3");
		model.addAttribute("input",input);
		return "fifo";
	}
	
	@PostMapping("/fifoSubmit")
	public String showResFIFO(@ModelAttribute("input") Input input, Model model) {
		String[] pageArr = input.getPage().split(" ");
		String frameStr = input.getFrame();
		
		int frame = Integer.parseInt(frameStr);
		int[] page = new int[pageArr.length];
		
		for (int i=0; i<pageArr.length; i++) {
			page[i]=Integer.parseInt(pageArr[i]);
		}
		
		PageReplacement pageReplacement = new FIFO(page,frame);
		
		List<String> table = pageReplacement.showTable();
		
		
		model.addAttribute("table",table);
		
		return "fifoResult";
	}
	
	@GetMapping("/nru")
	public String showNRU(Model model) {
		Input input = new Input();
		input.setPage("1 2 3 4 1 5 6 2 1 2 3 7 6 3 2 1 2 3 6 1");
		input.setFrame("3");
		model.addAttribute("input",input);
		return "nru";
	}
	
	@PostMapping("/nruSubmit")
	public String showResNRU(@ModelAttribute("input") Input input, Model model) {
		String[] pageArr = input.getPage().split(" ");
		String frameStr = input.getFrame();
		
		int frame = Integer.parseInt(frameStr);
		int[] page = new int[pageArr.length];
		
		for (int i=0; i<pageArr.length; i++) {
			page[i]=Integer.parseInt(pageArr[i]);
		}
		
		PageReplacement pageReplacement = new NRU(page,frame);
		
		List<String> table = pageReplacement.showTable();
		
		
		model.addAttribute("table",table);
		
		return "nruResult";
	}
	
	@GetMapping("/lru")
	public String showLRU(Model model) {
		Input input = new Input();
		input.setPage("1 2 3 4 1 2 5 1 2 3 4 5");
		input.setFrame("3");
		model.addAttribute("input",input);
		return "lru";
	}
	
	@PostMapping("/lruSubmit")
	public String showResLRU(@ModelAttribute("input") Input input, Model model) {
		String[] pageArr = input.getPage().split(" ");
		String frameStr = input.getFrame();
		
		int frame = Integer.parseInt(frameStr);
		int[] page = new int[pageArr.length];
		
		for (int i=0; i<pageArr.length; i++) {
			page[i]=Integer.parseInt(pageArr[i]);
		}
		
		PageReplacement pageReplacement = new LRU(page,frame);
		
		List<String> table = pageReplacement.showTable();
		
		model.addAttribute("table",table);
		
		return "lruResult";
	}
}
