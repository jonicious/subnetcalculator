package com.school.subnetcalculator.view;

import javax.swing.JDialog;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class SubnetGeneratorDialog extends JDialog {
	private JLabel lblNetworkaddress;
	private JTextField tfNetworkaddress;
	private JPanel pDepartmentsAndHosts;
	private JLabel lblDepartment;
	private JComboBox cbDepartments;
	private JLabel lblNumberOfHosts;
	private JTextField tfNumberOfHosts;
	private JPanel pGenerateCancel;
	private JButton btnGenerateSubnets;
	private JButton btnCancel;
	private JButton btnNext;
	private SubnetCalculatorFrame parentFrame;

	public SubnetGeneratorDialog(SubnetCalculatorFrame parentFrame) {
		setModal(true);
		setSize(700, 158);
        	setMinimumSize(new Dimension(700, 158));
        	this.parentFrame = parentFrame;
        	setLocationRelativeTo(parentFrame);
        	initGUI();
        	setVisible(true);
	}

	private void initGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_lblNetworkaddress = new GridBagConstraints();
		gbc_lblNetworkaddress.insets = new Insets(10, 10, 10, 5);
		gbc_lblNetworkaddress.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNetworkaddress.gridx = 0;
		gbc_lblNetworkaddress.gridy = 0;
		getContentPane().add(getLblNetworkaddress(), gbc_lblNetworkaddress);
		GridBagConstraints gbc_tfNetworkaddress = new GridBagConstraints();
		gbc_tfNetworkaddress.insets = new Insets(10, 10, 5, 10);
		gbc_tfNetworkaddress.anchor = GridBagConstraints.NORTH;
		gbc_tfNetworkaddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNetworkaddress.gridx = 1;
		gbc_tfNetworkaddress.gridy = 0;
		getContentPane().add(getTfNetworkaddress(), gbc_tfNetworkaddress);
		GridBagConstraints gbc_pDepartmentsAndHosts = new GridBagConstraints();
		gbc_pDepartmentsAndHosts.gridwidth = 2;
		gbc_pDepartmentsAndHosts.insets = new Insets(0, 10, 10, 10);
		gbc_pDepartmentsAndHosts.fill = GridBagConstraints.BOTH;
		gbc_pDepartmentsAndHosts.gridx = 0;
		gbc_pDepartmentsAndHosts.gridy = 1;
		getContentPane().add(getPDepartmentsAndHosts(),
				gbc_pDepartmentsAndHosts);
		GridBagConstraints gbc_pGenerateCancel = new GridBagConstraints();
		gbc_pGenerateCancel.gridwidth = 2;
		gbc_pGenerateCancel.insets = new Insets(0, 10, 10, 10);
		gbc_pGenerateCancel.fill = GridBagConstraints.BOTH;
		gbc_pGenerateCancel.gridx = 0;
		gbc_pGenerateCancel.gridy = 2;
		getContentPane().add(getPGenerateCancel(), gbc_pGenerateCancel);
	}

	private JLabel getLblNetworkaddress() {
		if (lblNetworkaddress == null) {
			lblNetworkaddress = new JLabel("Networkaddress");
		}
		return lblNetworkaddress;
	}

	private JTextField getTfNetworkaddress() {
		if (tfNetworkaddress == null) {
			tfNetworkaddress = new JTextField();
			tfNetworkaddress.setEditable(false);
			tfNetworkaddress.setColumns(10);
		}
		return tfNetworkaddress;
	}

	private JPanel getPDepartmentsAndHosts() {
		if (pDepartmentsAndHosts == null) {
			pDepartmentsAndHosts = new JPanel();
			GridBagLayout gbl_pDepartmentsAndHosts = new GridBagLayout();
			gbl_pDepartmentsAndHosts.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
			gbl_pDepartmentsAndHosts.rowHeights = new int[] { 0, 0 };
			gbl_pDepartmentsAndHosts.columnWeights = new double[] { 0.0, 1.0,
					0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_pDepartmentsAndHosts.rowWeights = new double[] { 0.0,
					Double.MIN_VALUE };
			pDepartmentsAndHosts.setLayout(gbl_pDepartmentsAndHosts);
			GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
			gbc_lblDepartment.anchor = GridBagConstraints.EAST;
			gbc_lblDepartment.insets = new Insets(0, 0, 0, 5);
			gbc_lblDepartment.gridx = 0;
			gbc_lblDepartment.gridy = 0;
			pDepartmentsAndHosts.add(getLblDepartment(), gbc_lblDepartment);
			GridBagConstraints gbc_cbDepartments = new GridBagConstraints();
			gbc_cbDepartments.insets = new Insets(0, 0, 0, 5);
			gbc_cbDepartments.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbDepartments.gridx = 1;
			gbc_cbDepartments.gridy = 0;
			pDepartmentsAndHosts.add(getCbDepartments(), gbc_cbDepartments);
			GridBagConstraints gbc_lblNumberOfHosts = new GridBagConstraints();
			gbc_lblNumberOfHosts.insets = new Insets(0, 0, 0, 5);
			gbc_lblNumberOfHosts.anchor = GridBagConstraints.EAST;
			gbc_lblNumberOfHosts.gridx = 2;
			gbc_lblNumberOfHosts.gridy = 0;
			pDepartmentsAndHosts.add(getLblNumberOfHosts(),
					gbc_lblNumberOfHosts);
			GridBagConstraints gbc_tfNumberOfHosts = new GridBagConstraints();
			gbc_tfNumberOfHosts.insets = new Insets(0, 0, 0, 5);
			gbc_tfNumberOfHosts.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfNumberOfHosts.gridx = 3;
			gbc_tfNumberOfHosts.gridy = 0;
			pDepartmentsAndHosts.add(getTfNumberOfHosts(), gbc_tfNumberOfHosts);
			GridBagConstraints gbc_btnNext = new GridBagConstraints();
			gbc_btnNext.gridx = 4;
			gbc_btnNext.gridy = 0;
			pDepartmentsAndHosts.add(getBtnNext(), gbc_btnNext);
		}
		return pDepartmentsAndHosts;
	}

	private JLabel getLblDepartment() {
		if (lblDepartment == null) {
			lblDepartment = new JLabel("Department");
		}
		return lblDepartment;
	}

	private JComboBox getCbDepartments() {
		if (cbDepartments == null) {
			cbDepartments = new JComboBox();
		}
		return cbDepartments;
	}

	private JLabel getLblNumberOfHosts() {
		if (lblNumberOfHosts == null) {
			lblNumberOfHosts = new JLabel("Number of Hosts");
		}
		return lblNumberOfHosts;
	}

	private JTextField getTfNumberOfHosts() {
		if (tfNumberOfHosts == null) {
			tfNumberOfHosts = new JTextField();
			tfNumberOfHosts.setColumns(10);
		}
		return tfNumberOfHosts;
	}

	private JPanel getPGenerateCancel() {
		if (pGenerateCancel == null) {
			pGenerateCancel = new JPanel();
			GridBagLayout gbl_pGenerateCancel = new GridBagLayout();
			gbl_pGenerateCancel.columnWidths = new int[] { 0, 0, 0, 0 };
			gbl_pGenerateCancel.rowHeights = new int[] { 0, 0 };
			gbl_pGenerateCancel.columnWeights = new double[] { 1.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_pGenerateCancel.rowWeights = new double[] { 0.0,
					Double.MIN_VALUE };
			pGenerateCancel.setLayout(gbl_pGenerateCancel);
			GridBagConstraints gbc_btnGenerateSubnets = new GridBagConstraints();
			gbc_btnGenerateSubnets.anchor = GridBagConstraints.SOUTHEAST;
			gbc_btnGenerateSubnets.insets = new Insets(0, 0, 0, 5);
			gbc_btnGenerateSubnets.gridx = 1;
			gbc_btnGenerateSubnets.gridy = 0;
			pGenerateCancel
					.add(getBtnGenerateSubnets(), gbc_btnGenerateSubnets);
			GridBagConstraints gbc_btnCancel = new GridBagConstraints();
			gbc_btnCancel.anchor = GridBagConstraints.SOUTHEAST;
			gbc_btnCancel.gridx = 2;
			gbc_btnCancel.gridy = 0;
			pGenerateCancel.add(getBtnCancel(), gbc_btnCancel);
		}
		return pGenerateCancel;
	}

	private JButton getBtnGenerateSubnets() {
		if (btnGenerateSubnets == null) {
			btnGenerateSubnets = new JButton("Generate Subnets");
			btnCancel.addActionListener(e -> this.dispose());
		}
		return btnGenerateSubnets;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(e -> this.dispose());
		}
		return btnCancel;
	}
	
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
		}
		return btnNext;
	}
}
