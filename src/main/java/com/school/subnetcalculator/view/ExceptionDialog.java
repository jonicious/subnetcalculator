package com.school.subnetcalculator.view;

import javax.swing.JDialog;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExceptionDialog extends JDialog{
	
	private static final long serialVersionUID = 2216114759951065612L;
	private JLabel lblErrorMessage;
	private JTextField tfErrorMessage;
	private JSplitPane splitPane;
	private JPanel pDetails;
	private JButton btnDetails;
	private JScrollPane spDetails;
	private JTextArea taDetails;
	private SubnetCalculatorFrame parentFrame;
	
	public ExceptionDialog(String errorMessage, Exception exception, SubnetCalculatorFrame parentFrame) {
		initGUI();
		getTfErrorMessage().setText(errorMessage);
		getTaDetails().setText(exception.toString());
		setVisible(true);
		setMinimumSize(new Dimension(500,300));
		this.parentFrame = parentFrame;
        setLocationRelativeTo(parentFrame);
	}
	
	private void initGUI() {
		setTitle("Error");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_lblErrorMessage = new GridBagConstraints();
		gbc_lblErrorMessage.insets = new Insets(10, 10, 10, 5);
		gbc_lblErrorMessage.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblErrorMessage.gridx = 0;
		gbc_lblErrorMessage.gridy = 0;
		getContentPane().add(getLblErrorMessage(), gbc_lblErrorMessage);
		GridBagConstraints gbc_tfErrorMessage = new GridBagConstraints();
		gbc_tfErrorMessage.insets = new Insets(10, 0, 10, 10);
		gbc_tfErrorMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfErrorMessage.gridx = 1;
		gbc_tfErrorMessage.gridy = 0;
		getContentPane().add(getTfErrorMessage(), gbc_tfErrorMessage);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.gridwidth = 2;
		gbc_splitPane.insets = new Insets(0, 10, 10, 10);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		getContentPane().add(getSplitPane(), gbc_splitPane);
	}

	private JLabel getLblErrorMessage() {
		if (lblErrorMessage == null) {
			lblErrorMessage = new JLabel("Error Message:");
		}
		return lblErrorMessage;
	}
	private JTextField getTfErrorMessage() {
		if (tfErrorMessage == null) {
			tfErrorMessage = new JTextField();
			tfErrorMessage.setEditable(false);
			tfErrorMessage.setColumns(10);
		}
		return tfErrorMessage;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setLeftComponent(getPDetails());
			splitPane.setRightComponent(getSpDetails());
		}
		return splitPane;
	}
	private JPanel getPDetails() {
		if (pDetails == null) {
			pDetails = new JPanel();
			GridBagLayout gbl_pDetails = new GridBagLayout();
			gbl_pDetails.columnWidths = new int[]{0, 0, 0};
			gbl_pDetails.rowHeights = new int[]{0, 0};
			gbl_pDetails.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			gbl_pDetails.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pDetails.setLayout(gbl_pDetails);
			GridBagConstraints gbc_btnDetails = new GridBagConstraints();
			gbc_btnDetails.anchor = GridBagConstraints.NORTHEAST;
			gbc_btnDetails.gridx = 1;
			gbc_btnDetails.gridy = 0;
			pDetails.add(getBtnDetails(), gbc_btnDetails);
		}
		return pDetails;
	}
	private JButton getBtnDetails() {
		if (btnDetails == null) {
			btnDetails = new JButton("Show Details");
			btnDetails.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(getBtnDetails().getText().equals("Show Details")){
						getBtnDetails().setText("Hide Details");
						getSplitPane().setDividerLocation(0.0);
					} else {
						getBtnDetails().setText("Show Details");
						getSplitPane().setDividerLocation(1.0);
					}
				}
			});
		}
		return btnDetails;
	}
	private JScrollPane getSpDetails() {
		if (spDetails == null) {
			spDetails = new JScrollPane();
			spDetails.setViewportView(getTaDetails());
		}
		return spDetails;
	}
	private JTextArea getTaDetails() {
		if (taDetails == null) {
			taDetails = new JTextArea();
		}
		return taDetails;
	}
}
