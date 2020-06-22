package com.ingSoft.simulador;

import javax.swing.JFrame;

public class MyThread implements Runnable {

	 private  Simulador s;
   
    public MyThread (Simulador s) {
		     this.s = s;
		     
	}

	
	public void run() {
		// TODO Auto-generated method stub
		 s.simular();
		 System.out.println("SON OF A BITCH, IM IN");
		 JFrame j1 = new JFrame();
	     //j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     j1.setVisible(true);
	     j1.add(s.getVisor().getPanel());
	     j1.pack();
	}

}
