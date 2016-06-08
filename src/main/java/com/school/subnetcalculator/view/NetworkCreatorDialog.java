package com.school.subnetcalculator.view;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6NetworkMask;
import com.school.subnetcalculator.model.Network;

import javax.swing.*;
import java.awt.*;

class NetworkCreatorDialog extends JDialog {
    private static final long serialVersionUID = -509854914694000006L;
    private JLabel lblNetworkaddress;
    private JTextField tfNetworkaddress;
    private JLabel lblPraefix;
    private JTextField tfPraefix;
    private JTextField tfNetworkmask;
    private JLabel lblNetworkmask;
    private JPanel pAddCancel;
    private JButton btnAddNetwork;
    private JButton btnCancel;
    private SubnetCalculatorFrame parentFrame;
    private IPv6Address createdAddress;
    private IPv6NetworkMask createdMask;

    public NetworkCreatorDialog(SubnetCalculatorFrame parentFrame) {
        setModal(true);
        setSize(700, 120);
        setMinimumSize(new Dimension(700, 120));
        this.parentFrame = parentFrame;
        setLocationRelativeTo(parentFrame);
        initGUI();
        setVisible(true);
    }

    private void initGUI() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0,
                Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
        getContentPane().add(getTfPraefix(), gbc_textField);
        GridBagConstraints gbc_lblNetworkmask = new GridBagConstraints();
        gbc_lblNetworkmask.insets = new Insets(0, 10, 5, 5);
        gbc_lblNetworkmask.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblNetworkmask.gridx = 0;
        gbc_lblNetworkmask.gridy = 1;
        getContentPane().add(getLblNetworkmask(), gbc_lblNetworkmask);
        GridBagConstraints gbc_tfNetworkmask = new GridBagConstraints();
        gbc_tfNetworkmask.insets = new Insets(0, 0, 5, 10);
        gbc_tfNetworkmask.gridwidth = 3;
        gbc_tfNetworkmask.anchor = GridBagConstraints.NORTH;
        gbc_tfNetworkmask.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNetworkmask.gridx = 1;
        gbc_tfNetworkmask.gridy = 1;
        getContentPane().add(getTfNetworkmask(), gbc_tfNetworkmask);
        GridBagConstraints gbc_pAddCancel = new GridBagConstraints();
        gbc_pAddCancel.anchor = GridBagConstraints.SOUTH;
        gbc_pAddCancel.gridwidth = 4;
        gbc_pAddCancel.insets = new Insets(0, 10, 10, 10);
        gbc_pAddCancel.fill = GridBagConstraints.HORIZONTAL;
        gbc_pAddCancel.gridx = 0;
        gbc_pAddCancel.gridy = 2;
        getContentPane().add(getPAddCancel(), gbc_pAddCancel);
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

    private JTextField getTfPraefix() {
        if (tfPraefix == null) {
            tfPraefix = new JTextField();
            tfPraefix.setMinimumSize(new Dimension(25, 20));
            tfPraefix.setColumns(10);
            tfPraefix.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					if(getTfPraefix().getText().length() == 0){
						getTfNetworkmask().setEditable(true);
					} else {
						getTfNetworkmask().setEditable(false);
					}
				}
				@Override
				public void focusGained(FocusEvent e) {
					if(getTfPraefix().getText().length() > 0){
						getTfNetworkmask().setEditable(false);
					}
				}
			});
        }
        return tfPraefix;
    }

    private JTextField getTfNetworkmask() {
        if (tfNetworkmask == null) {
            tfNetworkmask = new JTextField();
            tfNetworkmask.setColumns(10);
            tfNetworkmask.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					if(getTfNetworkmask().getText().length() == 0){
						getTfPraefix().setEditable(true);
					} else {
						getTfPraefix().setEditable(false);
					}
				}
				@Override
				public void focusGained(FocusEvent e) {
					if(getTfNetworkmask().getText().length() > 0){
						getTfPraefix().setEditable(false);
					}
				}
			});
        }
        return tfNetworkmask;
    }

    private JLabel getLblNetworkmask() {
        if (lblNetworkmask == null) {
            lblNetworkmask = new JLabel("Networkmask");
        }
        return lblNetworkmask;
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
            GridBagConstraints gbc_btnAddNetwork = new GridBagConstraints();
            gbc_btnAddNetwork.anchor = GridBagConstraints.NORTHEAST;
            gbc_btnAddNetwork.insets = new Insets(0, 0, 0, 5);
            gbc_btnAddNetwork.gridx = 1;
            gbc_btnAddNetwork.gridy = 0;
            pAddCancel.add(getBtnAddNetwork(), gbc_btnAddNetwork);
            GridBagConstraints gbc_btnCancel = new GridBagConstraints();
            gbc_btnCancel.anchor = GridBagConstraints.NORTHEAST;
            gbc_btnCancel.gridx = 2;
            gbc_btnCancel.gridy = 0;
            pAddCancel.add(getBtnCancel(), gbc_btnCancel);
        }
        return pAddCancel;
    }

    private JButton getBtnAddNetwork() {
        if (btnAddNetwork == null) {
            btnAddNetwork = new JButton("Add Network");
            btnAddNetwork.addActionListener(e -> addNetworkToNetworkList());
        }
        return btnAddNetwork;
    }

    private JButton getBtnCancel() {
        if (btnCancel == null) {
            btnCancel = new JButton("Cancel");
            btnCancel.addActionListener(e -> this.dispose());
        }
        return btnCancel;
    }

    private void addNetworkToNetworkList() {
        String netAddress = getTfNetworkaddress().getText();
        String netPraefix = getTfPraefix().getText();
        String netMask = getTfNetworkmask().getText();

        if (netAddress.contains(":")) {
            this.createdAddress = IPv6Address.fromString(netAddress);

            if (netPraefix != null) {
                this.createdMask = IPv6NetworkMask.fromPrefixLength(Integer.parseUnsignedInt(netPraefix, 10));
            } else if (netMask != null) {
                this.createdMask = IPv6NetworkMask.fromAddress(IPv6Address.fromString(netMask));
            }
            
            if(this.createdMask != null && this.createdAddress != null) {
            	
            	Network generatedNet = new Network(this.createdAddress, this.createdMask);

            	DefaultListModel df = (DefaultListModel) this.parentFrame.getListNetworks().getModel();
            	df.addElement(generatedNet);
            	this.dispose();
            }
        }
    }
}
