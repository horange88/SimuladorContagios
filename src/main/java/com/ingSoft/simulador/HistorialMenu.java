package Pruebas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HistorialMenu {
	public void main(JFrame ventana) {
		JFrame historial = new JFrame("Historial de Simulaciones");
		historial.setVisible(true);
		historial.setSize(300,300);
		historial.setLocationRelativeTo(null);
		historial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.gray);
		
		JButton close_button = new JButton("Close");
		
		close_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(true);
				historial.setVisible(false);
			}
		});
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0; c.gridy = 1;
		
		panel.add(close_button);	
		historial.add(panel);
	}
}
