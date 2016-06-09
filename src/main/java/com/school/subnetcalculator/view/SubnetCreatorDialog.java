package com.school.subnetcalculator.view;

import com.googlecode.ipv6.IPv6Address;
import com.googlecode.ipv6.IPv6NetworkMask;
import com.school.subnetcalculator.helper.NetworkHelper;
import com.school.subnetcalculator.model.Department;
import com.school.subnetcalculator.model.Subnet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;
import java.util.List;

public class SubnetCreatorDialog extends JDialog {

    private static final long serialVersionUID = -6007338971207933410L;
    private JLabel lblSubnetaddress;
    private JTextField tfSubnetaddress;
    private JLabel lblPraefix;
    private JTextField tfPraefix;
    private JTextField tfSubnetmask;
    private JLabel lblSubnetmask;
    private JPanel pAddCancel;
    private JButton btnAddSubnet;
    private JButton btnCancel;
    private SubnetCalculatorFrame parentFrame;
    private IPv6Address createdAddress;
    private IPv6NetworkMask createdMask;
    private ArrayList<Department> departmentList;
    private JLabel lblDepartment;
    private JComboBox cBDepartments;

    public SubnetCreatorDialog(SubnetCalculatorFrame parentFrame) {
        this.prefillDepartmentList();

        setModal(true);
        setSize(700, 158);
        setMinimumSize(new Dimension(700, 158));
        this.parentFrame = parentFrame;
        setLocationRelativeTo(parentFrame);
        initGUI();
        setVisible(true);
    }

    private void prefillDepartmentList() {
        departmentList = new ArrayList<>();
        departmentList.add(new Department("Sales"));
        departmentList.add(new Department("Operations"));
        departmentList.add(new Department("Finance"));
        departmentList.add(new Department("IT"));
    }

    private void initGUI() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0,
                Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        GridBagConstraints gbc_lblNetworkaddress = new GridBagConstraints();
        gbc_lblNetworkaddress.insets = new Insets(10, 10, 5, 5);
        gbc_lblNetworkaddress.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblNetworkaddress.gridx = 0;
        gbc_lblNetworkaddress.gridy = 0;
        getContentPane().add(getLblSubnetaddress(), gbc_lblNetworkaddress);
        GridBagConstraints gbc_tfNetworkaddress = new GridBagConstraints();
        gbc_tfNetworkaddress.insets = new Insets(10, 0, 5, 5);
        gbc_tfNetworkaddress.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNetworkaddress.gridx = 1;
        gbc_tfNetworkaddress.gridy = 0;
        getContentPane().add(getTfSubnetaddress(), gbc_tfNetworkaddress);
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
        getContentPane().add(getLblSubnetmask(), gbc_lblNetworkmask);
        GridBagConstraints gbc_tfNetworkmask = new GridBagConstraints();
        gbc_tfNetworkmask.insets = new Insets(0, 0, 5, 10);
        gbc_tfNetworkmask.gridwidth = 3;
        gbc_tfNetworkmask.anchor = GridBagConstraints.NORTH;
        gbc_tfNetworkmask.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfNetworkmask.gridx = 1;
        gbc_tfNetworkmask.gridy = 1;
        getContentPane().add(getTfSubnetmask(), gbc_tfNetworkmask);
        GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
        gbc_lblDepartment.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblDepartment.insets = new Insets(0, 10, 5, 5);
        gbc_lblDepartment.gridx = 0;
        gbc_lblDepartment.gridy = 2;
        getContentPane().add(getLblDepartment(), gbc_lblDepartment);
        GridBagConstraints gbc_cBDepartments = new GridBagConstraints();
        gbc_cBDepartments.gridwidth = 3;
        gbc_cBDepartments.insets = new Insets(0, 0, 5, 10);
        gbc_cBDepartments.fill = GridBagConstraints.HORIZONTAL;
        gbc_cBDepartments.gridx = 1;
        gbc_cBDepartments.gridy = 2;
        getContentPane().add(getCBDepartments(), gbc_cBDepartments);
        GridBagConstraints gbc_pAddCancel = new GridBagConstraints();
        gbc_pAddCancel.anchor = GridBagConstraints.SOUTH;
        gbc_pAddCancel.gridwidth = 4;
        gbc_pAddCancel.insets = new Insets(0, 10, 10, 10);
        gbc_pAddCancel.fill = GridBagConstraints.HORIZONTAL;
        gbc_pAddCancel.gridx = 0;
        gbc_pAddCancel.gridy = 3;
        getContentPane().add(getPAddCancel(), gbc_pAddCancel);
    }

    private JLabel getLblSubnetaddress() {
        if (lblSubnetaddress == null) {
            lblSubnetaddress = new JLabel("Subnetaddress");
        }
        return lblSubnetaddress;
    }

    private JTextField getTfSubnetaddress() {
        if (tfSubnetaddress == null) {
            tfSubnetaddress = new JTextField();
            tfSubnetaddress.setColumns(10);
        }
        return tfSubnetaddress;
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
                    if (getTfPraefix().getText().length() == 0) {
                        getTfSubnetmask().setEditable(true);
                    } else {
                        getTfSubnetmask().setEditable(false);
                    }
                }

                @Override
                public void focusGained(FocusEvent e) {
                    if (getTfPraefix().getText().length() > 0) {
                        getTfSubnetmask().setEditable(false);
                    }
                }
            });
        }
        return tfPraefix;
    }

    private JTextField getTfSubnetmask() {
        if (tfSubnetmask == null) {
            tfSubnetmask = new JTextField();
            tfSubnetmask.setColumns(10);
            tfSubnetmask.addFocusListener(new FocusListener() {
                @Override
                public void focusLost(FocusEvent e) {
                    if (getTfSubnetmask().getText().length() == 0) {
                        getTfPraefix().setEditable(true);
                    } else {
                        getTfPraefix().setEditable(false);
                    }
                }

                @Override
                public void focusGained(FocusEvent e) {
                    if (getTfSubnetmask().getText().length() > 0) {
                        getTfPraefix().setEditable(false);
                    }
                }
            });
        }
        return tfSubnetmask;
    }

    private JLabel getLblSubnetmask() {
        if (lblSubnetmask == null) {
            lblSubnetmask = new JLabel("Subnetmask");
        }
        return lblSubnetmask;
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
            pAddCancel.add(getBtnAddSubnet(), gbc_btnAddNetwork);
            GridBagConstraints gbc_btnCancel = new GridBagConstraints();
            gbc_btnCancel.anchor = GridBagConstraints.NORTHEAST;
            gbc_btnCancel.gridx = 2;
            gbc_btnCancel.gridy = 0;
            pAddCancel.add(getBtnCancel(), gbc_btnCancel);
        }
        return pAddCancel;
    }

    private JButton getBtnAddSubnet() {
        if (btnAddSubnet == null) {
            btnAddSubnet = new JButton("Add Subnet");
            btnAddSubnet.addActionListener(e -> addSubnetToSubnetList());
        }
        return btnAddSubnet;
    }

    private JButton getBtnCancel() {
        if (btnCancel == null) {
            btnCancel = new JButton("Cancel");
            btnCancel.addActionListener(e -> this.dispose());
        }
        return btnCancel;
    }

    private void addSubnetToSubnetList() {
        String netAddress = getTfSubnetaddress().getText();
        String netPraefix = getTfPraefix().getText();
        String netMask = getTfSubnetmask().getText();
        Department department = (Department) getCBDepartments().getSelectedItem();

        Subnet generatedSubnet = NetworkHelper.generateSubnet(netAddress, netPraefix, netMask, department);
        if (generatedSubnet != null) {
            DefaultListModel df = (DefaultListModel) this.parentFrame.getListSubnets().getModel();
            df.addElement(generatedSubnet);
            this.parentFrame.getListNetworks().getSelectedValue().addSubnet(generatedSubnet);
            this.dispose();
        }
    }

    private JLabel getLblDepartment() {
        if (lblDepartment == null) {
            lblDepartment = new JLabel("Department");
        }
        return lblDepartment;
    }

    private JComboBox<Department> getCBDepartments() {
        if (cBDepartments == null) {
            cBDepartments = new JComboBox();
            cBDepartments.addItem(null);

            List<Subnet> subnetList = new ArrayList<>();

            for (int i = 0; i < ((DefaultListModel) parentFrame.getListSubnets().getModel()).getSize(); i++) {
                subnetList.add((Subnet) ((DefaultListModel) parentFrame.getListSubnets().getModel()).get(i));
            }

            for (Department department : departmentList) {
                if(!department.isUsedBySubnet(subnetList)) {
                    cBDepartments.addItem(department);
                }
            }
        }

        return cBDepartments;
    }

}
