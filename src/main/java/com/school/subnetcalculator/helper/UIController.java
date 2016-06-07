package com.school.subnetcalculator.helper;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UIController {
	
	public UIController() {
		setLookAndFeel();
		setFont();
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	private void setFont() {
		try {
			InputStream is = SubnetCalculatorFrame.class
					.getResourceAsStream("System San Francisco Display Regular.ttf");
			Font createFont = Font.createFont(Font.TRUETYPE_FONT, is);
			UIManager.put("Button.font", createFont.deriveFont(16.0f));
			UIManager.put("Label.font", createFont.deriveFont(16.0f));
			UIManager.put("TextField.font", createFont.deriveFont(16.0f));
			UIManager.put("List.font", createFont.deriveFont(16.0f));
			UIManager.put("TextArea.font", createFont.deriveFont(16.0f));
			UIManager.put("TabbedPane.font", createFont.deriveFont(16.0f));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
