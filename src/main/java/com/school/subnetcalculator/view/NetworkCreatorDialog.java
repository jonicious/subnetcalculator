import javax.swing.JDialog;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Insets;
import java.awt.Dimension;

public class NetworkCreatorDialog extends JDialog {
	private static final long serialVersionUID = -509854914694000006L;
	private JLabel lblNetworkaddress;
	private JTextField tfNetworkaddress;
	private JLabel lblPraefix;
	private JTextField textField;
	private JTextField tfNetworkmask;
	private JLabel lblNetworkmask;

	public NetworkCreatorDialog(Component c) {
		setModal(true);
		setSize(700,110);
		setMinimumSize(new Dimension(700,110));
		setLocationRelativeTo(c);
		initGUI();
		setVisible(true);
	}

	private void initGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_lblNetworkaddress = new GridBagConstraints();
		gbc_lblNetworkaddress.insets = new Insets(10, 10, 5, 5);
		gbc_lblNetworkaddress.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNetworkaddress.gridx = 0;
		gbc_lblNetworkaddress.gridy = 0;
		getContentPane().add(getLblNetworkaddress(), gbc_lblNetworkaddress);
		GridBagConstraints gbc_tfNetworkaddress = new GridBagConstraints();
		gbc_tfNetworkaddress.insets = new Insets(10, 0, 5, 5);
		gbc_tfNetworkaddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNetworkaddress.gridx = 1;
		gbc_tfNetworkaddress.gridy = 0;
		getContentPane().add(getTfNetworkaddress(), gbc_tfNetworkaddress);
		GridBagConstraints gbc_lblPraefix = new GridBagConstraints();
		gbc_lblPraefix.insets = new Insets(10, 0, 5, 5);
		gbc_lblPraefix.gridx = 2;
		gbc_lblPraefix.gridy = 0;
		getContentPane().add(getLblPraefix(), gbc_lblPraefix);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(10, 0, 5, 10);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		getContentPane().add(getTextField(), gbc_textField);
		GridBagConstraints gbc_lblNetworkmask = new GridBagConstraints();
		gbc_lblNetworkmask.insets = new Insets(0, 10, 0, 5);
		gbc_lblNetworkmask.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNetworkmask.gridx = 0;
		gbc_lblNetworkmask.gridy = 1;
		getContentPane().add(getLblNetworkmask(), gbc_lblNetworkmask);
		GridBagConstraints gbc_tfNetworkmask = new GridBagConstraints();
		gbc_tfNetworkmask.insets = new Insets(0, 0, 0, 10);
		gbc_tfNetworkmask.gridwidth = 3;
		gbc_tfNetworkmask.anchor = GridBagConstraints.NORTH;
		gbc_tfNetworkmask.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNetworkmask.gridx = 1;
		gbc_tfNetworkmask.gridy = 1;
		getContentPane().add(getTfNetworkmask(), gbc_tfNetworkmask);
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
			tfNetworkaddress.setColumns(10);
		}
		return tfNetworkaddress;
	}

	private JLabel getLblPraefix() {
		if (lblPraefix == null) {
			lblPraefix = new JLabel("/");
		}
		return lblPraefix;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setMinimumSize(new Dimension(25, 20));
			textField.setColumns(10);
		}
		return textField;
	}

	private JTextField getTfNetworkmask() {
		if (tfNetworkmask == null) {
			tfNetworkmask = new JTextField();
			tfNetworkmask.setColumns(10);
		}
		return tfNetworkmask;
	}

	private JLabel getLblNetworkmask() {
		if (lblNetworkmask == null) {
			lblNetworkmask = new JLabel("Networkmask");
		}
		return lblNetworkmask;
	}
}
