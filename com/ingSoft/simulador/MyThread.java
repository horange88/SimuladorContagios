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
<<<<<<< HEAD
		 System.out.println("SON OF A BITCH, IM IN");
	
=======

>>>>>>> 8401b4dbfe05b756a5c002d97766e129eeeb8a53
	}

}
