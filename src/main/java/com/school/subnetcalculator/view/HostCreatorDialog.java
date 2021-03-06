package com.school.subnetcalculator.view;

import com.school.subnetcalculator.model.Host;
import com.school.subnetcalculator.model.Subnet;
import com.school.subnetcalculator.model.ipv4.IPv4Address;

import javax.swing.*;
import java.awt.*;

public class HostCreatorDialog extends JDialog{

	private static final long serialVersionUID = -1476796903624615228L;
	private SubnetCalculatorFrame parentFrame;
	private JLabel lblHostaddress;
	private JLabel lblDescription;
	private JTextField tfHostaddress;
	private JScrollPane scrollPane;
	private JTextArea taDescription;
	private JPanel pAddCancel;
	private JButton btnAddHost;
	private JButton btnCancel;

	public HostCreatorDialog(SubnetCalculatorFrame parentFrame) {
		setModal(true);
		setSize(700, 158);
		setMinimumSize(new Dimension(700, 158));
		this.parentFrame = parentFrame;
		setLocationRelativeTo(parentFrame);
		initGUI();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void initGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_lblHostaddress = new GridBagConstraints();
		gbc_lblHostaddress.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblHostaddress.insets = new Insets(10, 10, 5, 5);
		gbc_lblHostaddress.gridx = 0;
		gbc_lblHostaddress.gridy = 0;
		getContentPane().add(getLblHostaddress(), gbc_lblHostaddress);
		GridBagConstraints gbc_tfHostaddress = new GridBagConstraints();
		gbc_tfHostaddress.insets = new Insets(10, 0, 5, 10);
		gbc_tfHostaddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfHostaddress.gridx = 1;
		gbc_tfHostaddress.gridy = 0;
		getContentPane().add(getTfHostaddress(), gbc_tfHostaddress);
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 10, 10, 5);
		gbc_lblDescription.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		getContentPane().add(getLblDescription(), gbc_lblDescription);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 10, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(getScrollPane(), gbc_scrollPane);
		GridBagConstraints gbc_pAddCancel = new GridBagConstraints();
		gbc_pAddCancel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_pAddCancel.gridwidth = 2;
		gbc_pAddCancel.insets = new Insets(0, 10, 10, 10);
		gbc_pAddCancel.fill = GridBagConstraints.BOTH;
		gbc_pAddCancel.gridx = 0;
		gbc_pAddCancel.gridy = 2;
		getContentPane().add(getPAddCancel(), gbc_pAddCancel);
	}

	private JLabel getLblHostaddress() {
		if (lblHostaddress == null) {
			lblHostaddress = new JLabel("Hostaddress");
		}
		return lblHostaddress;
	}
	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel("Description");
		}
		return lblDescription;
	}
	private JTextField getTfHostaddress() {
		if (tfHostaddress == null) {
			tfHostaddress = new JTextField();
			tfHostaddress.setColumns(10);
		}
		return tfHostaddress;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTaDescription());
		}
		return scrollPane;
	}
	private JTextArea getTaDescription() {
		if (taDescription == null) {
			taDescription = new JTextArea();
		}
		return taDescription;
	}
	private JPanel getPAddCancel() {
		if (pAddCancel == null) {
			pAddCancel = new JPanel();
			GridBagLayout gbl_pAddCancel = new GridBagLayout();
			gbl_pAddCancel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_pAddCancel.rowHeights = new int[]{0, 0};
			gbl_pAddCancel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pAddCancel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pAddCancel.setLayout(gbl_pAddCancel);
			GridBagConstraints gbc_btnAddHost = new GridBagConstraints();
			gbc_btnAddHost.anchor = GridBagConstraints.SOUTHEAST;
			gbc_btnAddHost.insets = new Insets(0, 0, 0, 5);
			gbc_btnAddHost.gridx = 1;
			gbc_btnAddHost.gridy = 0;
			pAddCancel.add(getBtnAddHost(), gbc_btnAddHost);
			GridBagConstraints gbc_btnCancel = new GridBagConstraints();
			gbc_btnCancel.anchor = GridBagConstraints.SOUTHEAST;
			gbc_btnCancel.gridx = 2;
			gbc_btnCancel.gridy = 0;
			pAddCancel.add(getBtnCancel(), gbc_btnCancel);
		}
		return pAddCancel;
	}
	private JButton getBtnAddHost() {
		if (btnAddHost == null) {
			btnAddHost = new JButton("Add Host");
			btnAddHost.addActionListener(e -> addHostToHostList());
		}
		return btnAddHost;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(e -> this.dispose());
		}
		return btnCancel;
	}
	
	private void addHostToHostList(){
		IPv4Address addr = IPv4Address.fromString(getTfHostaddress().getText());
		String desc = getTaDescription().getText();
		Host host = new Host(addr, desc);

		Subnet sn = this.parentFrame.getListSubnets().getSelectedValue();

		if (!host.getIpv4Address().isInNetwork(sn.getIpv4Network())) {
			setModal(false);
			new ExceptionDialog("address not allowed", new Exception("address not available in network"), this.parentFrame);
			return;
		}

		if (host.getIpv4Address().toString() == sn.getIpv4Network().getFirstAddress().toString() || host.getIpv4Address().toString() == sn.getIpv4Network()
				.getLastAddress().toString()) {
			new ExceptionDialog("broadcast or network address must not be used", new Exception("the broadcast or the network address cannot be used as a host address " +
					"in the network"), this.parentFrame);
			return;
		}

		this.parentFrame.getListSubnets().getSelectedValue().addHostToHostList(host);
		((DefaultListModel) this.parentFrame.getListHosts().getModel()).addElement(host);
		this.dispose();
	}
}
