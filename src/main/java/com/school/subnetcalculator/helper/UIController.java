package com.school.subnetcalculator.helper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UIController {
	
	public UIController() throws IOException {
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

	private void setFont() throws IOException {
		try {
			Font createFont = Font.createFont(Font.TRUETYPE_FONT, new File("sf-regular.ttf"));
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
