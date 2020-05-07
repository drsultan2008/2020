package com.duy.controller;

import com.duy.model.Caculator;
import com.duy.view.CaculatorGUI;

public class CaculatorController {
	private Caculator caculator;
	private CaculatorGUI caculatorGUI;
	
	public CaculatorController(Caculator caculator) {
		this.caculator = caculator;
	}

	public void excecute(String line) {
		caculator.execute(line);
	}
	
	public void setResodd(double x) {
		caculator.setResOdd(x);
	}
	
	public double getResOdd() {
		return caculator.getResOdd();
	}
	
	public static void main(String args[]) {
		Caculator caculator = new Caculator();
		CaculatorController controller = new CaculatorController(caculator);
		CaculatorGUI caculatorGUI = new CaculatorGUI(controller);
		caculator.add(caculatorGUI);
		caculatorGUI.setVisible(true);
	}
}
