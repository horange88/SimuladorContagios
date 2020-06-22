package com.ingSoft.simulador;

import javax.swing.JFrame;

public class MyThread extends Thread {

	 private  Simulador s;
   
    public MyThread (Simulador s) {
		     this.s = s;
		     
	}

	
	public void run() {
		// TODO Auto-generated method stub
		 s.simular();

	}

}
