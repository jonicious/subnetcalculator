package main.com.school.subnetcalculator.helper;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UIController {
	
	public UIController() {
		setLookAndFeel();
	}
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
