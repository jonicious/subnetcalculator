package com.school.subnetcalculator.view;

import com.school.subnetcalculator.helper.Converter;
import com.school.subnetcalculator.helper.DocumentParser;
import com.school.subnetcalculator.helper.UIController;
import com.school.subnetcalculator.model.Host;
import com.school.subnetcalculator.model.Network;
import com.school.subnetcalculator.model.Subnet;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class SubnetCalculatorFrame extends JFrame {
    private static final long serialVersionUID = -6244329414716205933L;
    private JTabbedPane tpNetworkSubnetsHosts;
    private JButton btnAddNetwork;
    private JButton btnOptions;
    private JButton btnDeleteNetwork;
    private JButton btnLoad;
    private JButton btnSave;
    private JPanel pNetworks;
    private JLabel lblNetworks;
    private JList<Network> listNetworks;
    private JPanel pSubnets;
    private JLabel lblNetwork;
    private JTextField tfNetwork;
    private JLabel lblSubnets;
    private JPanel pNetworkButtons;
    private JList<Subnet> listSubnets;
    private JPanel pSubnetButtons;
    private JButton btnAddSubnet;
    private JButton btnDeleteSubnet;
    private JPanel pHosts;
    private JLabel lblDescription;
    private JLabel lblBinary;
    private JTextField tfBinary;
    private JLabel lblHosts;
    private JList<Host> listHosts;
    private JScrollPane sPDescription;
    private JTextArea taDescription;
    private JPanel pHostButtons;
    private JButton btnAddHost;
    private JButton btnDeleteHost;
    private JLabel lblSubnetaddress;
    private JTextField tfSubnetAddress;
    private JTextField tfBroadcastaddress;
    private JLabel lblBroadcastaddress;
    private JButton btnGenerateSubnets;
    private JLabel lblDepartment;
    private JTextField tfDepartment;

    public SubnetCalculatorFrame() throws IOException {
        new UIController();
        initGUI();
        setVisible(true);
        setSize(new Dimension(700, 500));
        setTitle("SubnetCalculator");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initGUI() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        GridBagConstraints gbc_tpNetworkSubnetsHosts = new GridBagConstraints();
        gbc_tpNetworkSubnetsHosts.insets = new Insets(10, 10, 10, 10);
        gbc_tpNetworkSubnetsHosts.fill = GridBagConstraints.BOTH;
        gbc_tpNetworkSubnetsHosts.gridx = 0;
        gbc_tpNetworkSubnetsHosts.gridy = 0;
        getContentPane().add(getTpNetworkSubnetsHosts(),
                gbc_tpNetworkSubnetsHosts);
    }

    private JTabbedPane getTpNetworkSubnetsHosts() {
        if (tpNetworkSubnetsHosts == null) {
            tpNetworkSubnetsHosts = new JTabbedPane(JTabbedPane.TOP);
            tpNetworkSubnetsHosts
                    .addTab("Networks", null, getPNetworks(), null);
            tpNetworkSubnetsHosts.addTab("Subnets", null, getPSubnets(), null);
            tpNetworkSubnetsHosts.addTab("Hosts", null, getPHosts(), null);
            tpNetworkSubnetsHosts.setEnabledAt(1, false);
            tpNetworkSubnetsHosts.setEnabledAt(2, false);
        }
        return tpNetworkSubnetsHosts;
    }

    private JButton getBtnAddNetwork() {
        if (btnAddNetwork == null) {
            btnAddNetwork = new JButton("Add Network");
            btnAddNetwork.addActionListener(e -> new NetworkCreatorDialog(SubnetCalculatorFrame.this));
        }
        return btnAddNetwork;
    }

    private JButton getBtnOptions() {
        if (btnOptions == null) {
            btnOptions = new JButton("Options");
        }
        return btnOptions;
    }

    private JButton getBtnDeleteNetwork() {
        if (btnDeleteNetwork == null) {
            btnDeleteNetwork = new JButton("Delete Network");
            btnDeleteNetwork.addActionListener(e -> {
                if (getListNetworks().getSelectedValue() != null) {

                    ((DefaultListModel) getListNetworks().getModel()).removeElement(getListNetworks().getSelectedValue());
                }
            });
        }
        return btnDeleteNetwork;
    }

    private JButton getBtnLoad() {
        if (btnLoad == null) {
            btnLoad = new JButton("Load");
            btnLoad.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showOpenDialog(SubnetCalculatorFrame.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    DefaultListModel model = (DefaultListModel) getListNetworks().getModel();
                    model.removeAllElements();
                    getTpNetworkSubnetsHosts().setEnabledAt(1, false);
                    getTpNetworkSubnetsHosts().setEnabledAt(2, false);
                    for (Network net : DocumentParser.importFromFile(fileChooser.getSelectedFile().getName())) {
                        ((DefaultListModel) getListNetworks().getModel()).addElement(net);
                    }
                }
            });
        }
        return btnLoad;
    }

    private JButton getBtnSave() {
        if (btnSave == null) {
            btnSave = new JButton("Save");
            btnSave.addActionListener(e -> {
                java.util.List<Network> networkList = new ArrayList<>();
                for (int i = 0; i < getListNetworks().getModel().getSize(); i++) {
                    networkList.add(getListNetworks().getModel().getElementAt(i));
                }
                DocumentParser.exportToFile(networkList, "export.json");
            });
        }
        return btnSave;
    }

    private JPanel getPNetworks() {
        if (pNetworks == null) {
            pNetworks = new JPanel();
            GridBagLayout gbl_pNetworks = new GridBagLayout();
            gbl_pNetworks.columnWidths = new int[]{0, 0, 0};
            gbl_pNetworks.rowHeights = new int[]{0, 0, 0};
            gbl_pNetworks.columnWeights = new double[]{0.0, 1.0,
                    Double.MIN_VALUE};
            gbl_pNetworks.rowWeights = new double[]{1.0, 0.0,
                    Double.MIN_VALUE};
            pNetworks.setLayout(gbl_pNetworks);
            GridBagConstraints gbc_lblNetworks = new GridBagConstraints();
            gbc_lblNetworks.anchor = GridBagConstraints.NORTH;
            gbc_lblNetworks.insets = new Insets(5, 5, 5, 5);
            gbc_lblNetworks.gridx = 0;
            gbc_lblNetworks.gridy = 0;
            pNetworks.add(getLblNetworks(), gbc_lblNetworks);
            GridBagConstraints gbc_listNetworks = new GridBagConstraints();
            gbc_listNetworks.insets = new Insets(5, 0, 5, 0);
            gbc_listNetworks.fill = GridBagConstraints.BOTH;
            gbc_listNetworks.gridx = 1;
            gbc_listNetworks.gridy = 0;
            pNetworks.add(getListNetworks(), gbc_listNetworks);
            GridBagConstraints gbc_pNetworkButtons = new GridBagConstraints();
            gbc_pNetworkButtons.gridwidth = 2;
            gbc_pNetworkButtons.insets = new Insets(10, 0, 0, 5);
            gbc_pNetworkButtons.fill = GridBagConstraints.BOTH;
            gbc_pNetworkButtons.gridx = 0;
            gbc_pNetworkButtons.gridy = 1;
            pNetworks.add(getPNetworkButtons(), gbc_pNetworkButtons);
        }
        return pNetworks;
    }

    private JLabel getLblNetworks() {
        if (lblNetworks == null) {
            lblNetworks = new JLabel("Networks");
        }
        return lblNetworks;
    }

    public JList<Network> getListNetworks() {
        if (listNetworks == null) {
            listNetworks = new JList<>();
            listNetworks.setModel(new DefaultListModel<>());
            listNetworks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listNetworks.addListSelectionListener(e -> {
                if (getListNetworks().getSelectedValue() != null) {
                    getTpNetworkSubnetsHosts().setEnabledAt(1, true);
                    getTfNetwork().setText(String.valueOf(getListNetworks().getSelectedValue().toString()));
                    DefaultListModel df = (DefaultListModel) getListSubnets().getModel();
                    df.clear();
                    getListNetworks().getSelectedValue().getSubnetList().forEach(df::addElement);
                } else {
                    getTpNetworkSubnetsHosts().setEnabledAt(1, false);
                    getTpNetworkSubnetsHosts().setEnabledAt(2, false);
                }
            });
        }
        return listNetworks;
    }

    private JPanel getPSubnets() {
        if (pSubnets == null) {
            pSubnets = new JPanel();
            GridBagLayout gbl_pSubnets = new GridBagLayout();
            gbl_pSubnets.columnWidths = new int[]{0, 0, 0};
            gbl_pSubnets.rowHeights = new int[]{0, 0, 0, 0, 0};
            gbl_pSubnets.columnWeights = new double[]{0.0, 1.0,
                    Double.MIN_VALUE};
            gbl_pSubnets.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0,
                    Double.MIN_VALUE};
            pSubnets.setLayout(gbl_pSubnets);
            GridBagConstraints gbc_lblNetwork = new GridBagConstraints();
            gbc_lblNetwork.anchor = GridBagConstraints.NORTHWEST;
            gbc_lblNetwork.insets = new Insets(5, 5, 5, 5);
            gbc_lblNetwork.gridx = 0;
            gbc_lblNetwork.gridy = 0;
            pSubnets.add(getLblNetwork(), gbc_lblNetwork);
            GridBagConstraints gbc_tfNetwork = new GridBagConstraints();
            gbc_tfNetwork.insets = new Insets(5, 0, 5, 0);
            gbc_tfNetwork.anchor = GridBagConstraints.NORTH;
            gbc_tfNetwork.fill = GridBagConstraints.HORIZONTAL;
            gbc_tfNetwork.gridx = 1;
            gbc_tfNetwork.gridy = 0;
            pSubnets.add(getTfNetwork(), gbc_tfNetwork);
            GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
            gbc_lblDepartment.anchor = GridBagConstraints.NORTHWEST;
            gbc_lblDepartment.insets = new Insets(5, 5, 5, 5);
            gbc_lblDepartment.gridx = 0;
            gbc_lblDepartment.gridy = 1;
            pSubnets.add(getLblDepartment(), gbc_lblDepartment);
            GridBagConstraints gbc_tfDepartment = new GridBagConstraints();
            gbc_tfDepartment.insets = new Insets(0, 0, 5, 0);
            gbc_tfDepartment.fill = GridBagConstraints.HORIZONTAL;
            gbc_tfDepartment.gridx = 1;
            gbc_tfDepartment.gridy = 1;
            pSubnets.add(getTfDepartment(), gbc_tfDepartment);
            GridBagConstraints gbc_lblSubnets = new GridBagConstraints();
            gbc_lblSubnets.anchor = GridBagConstraints.NORTHWEST;
            gbc_lblSubnets.insets = new Insets(5, 5, 5, 5);
            gbc_lblSubnets.gridx = 0;
            gbc_lblSubnets.gridy = 2;
            pSubnets.add(getLblSubnets(), gbc_lblSubnets);
            GridBagConstraints gbc_listSubnets = new GridBagConstraints();
            gbc_listSubnets.insets = new Insets(5, 0, 5, 0);
            gbc_listSubnets.fill = GridBagConstraints.BOTH;
            gbc_listSubnets.gridx = 1;
            gbc_listSubnets.gridy = 2;
            pSubnets.add(getListSubnets(), gbc_listSubnets);
            GridBagConstraints gbc_pSubnetButtons = new GridBagConstraints();
            gbc_pSubnetButtons.gridwidth = 2;
            gbc_pSubnetButtons.insets = new Insets(10, 0, 0, 5);
            gbc_pSubnetButtons.fill = GridBagConstraints.BOTH;
            gbc_pSubnetButtons.gridx = 0;
            gbc_pSubnetButtons.gridy = 3;
            pSubnets.add(getPSubnetButtons(), gbc_pSubnetButtons);
        }
        return pSubnets;
    }

    private JTextField getTfDepartment() {
        if (tfDepartment == null) {
            tfDepartment = new JTextField();
            tfDepartment.setColumns(10);
            tfDepartment.setEditable(false);
        }
        return tfDepartment;
    }

    private JLabel getLblDepartment() {
        if (lblDepartment == null) {
            lblDepartment = new JLabel("Department");
        }
        return lblDepartment;
    }

    private JLabel getLblNetwork() {
        if (lblNetwork == null) {
            lblNetwork = new JLabel("Network");
        }
        return lblNetwork;
    }

    private JTextField getTfNetwork() {
        if (tfNetwork == null) {
            tfNetwork = new JTextField();
            tfNetwork.setColumns(10);
            tfNetwork.setEditable(false);
        }
        return tfNetwork;
    }

    private JLabel getLblSubnets() {
        if (lblSubnets == null) {
            lblSubnets = new JLabel("Subnets");
        }
        return lblSubnets;
    }

    private JPanel getPNetworkButtons() {
        if (pNetworkButtons == null) {
            pNetworkButtons = new JPanel();
            GridBagLayout gbl_pNetworkButtons = new GridBagLayout();
            gbl_pNetworkButtons.columnWidths = new int[]{0, 0, 0, 0};
            gbl_pNetworkButtons.rowHeights = new int[]{0, 0, 0};
            gbl_pNetworkButtons.columnWeights = new double[]{0.0, 0.0, 0.0,
                    Double.MIN_VALUE};
            gbl_pNetworkButtons.rowWeights = new double[]{0.0, 0.0,
                    Double.MIN_VALUE};
            pNetworkButtons.setLayout(gbl_pNetworkButtons);
            GridBagConstraints gbc_btnAddNetwork = new GridBagConstraints();
            gbc_btnAddNetwork.fill = GridBagConstraints.HORIZONTAL;
            gbc_btnAddNetwork.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnAddNetwork.insets = new Insets(0, 0, 5, 5);
            gbc_btnAddNetwork.gridx = 0;
            gbc_btnAddNetwork.gridy = 0;
            pNetworkButtons.add(getBtnAddNetwork(), gbc_btnAddNetwork);
            GridBagConstraints gbc_btnDeleteNetwork = new GridBagConstraints();
            gbc_btnDeleteNetwork.fill = GridBagConstraints.HORIZONTAL;
            gbc_btnDeleteNetwork.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnDeleteNetwork.insets = new Insets(0, 0, 5, 5);
            gbc_btnDeleteNetwork.gridx = 1;
            gbc_btnDeleteNetwork.gridy = 0;
            pNetworkButtons.add(getBtnDeleteNetwork(), gbc_btnDeleteNetwork);
            GridBagConstraints gbc_btnGenerateSubnets = new GridBagConstraints();
            gbc_btnGenerateSubnets.fill = GridBagConstraints.HORIZONTAL;
            gbc_btnGenerateSubnets.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnGenerateSubnets.insets = new Insets(0, 0, 5, 0);
            gbc_btnGenerateSubnets.gridx = 2;
            gbc_btnGenerateSubnets.gridy = 0;
            pNetworkButtons.add(getBtnGenerateSubnets(), gbc_btnGenerateSubnets);
            GridBagConstraints gbc_btnOptions = new GridBagConstraints();
            gbc_btnOptions.fill = GridBagConstraints.HORIZONTAL;
            gbc_btnOptions.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnOptions.insets = new Insets(0, 0, 0, 5);
            gbc_btnOptions.gridx = 0;
            gbc_btnOptions.gridy = 1;
            pNetworkButtons.add(getBtnOptions(), gbc_btnOptions);
            GridBagConstraints gbc_btnLoad = new GridBagConstraints();
            gbc_btnLoad.fill = GridBagConstraints.HORIZONTAL;
            gbc_btnLoad.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnLoad.insets = new Insets(0, 0, 0, 5);
            gbc_btnLoad.gridx = 1;
            gbc_btnLoad.gridy = 1;
            pNetworkButtons.add(getBtnLoad(), gbc_btnLoad);
            GridBagConstraints gbc_btnSave = new GridBagConstraints();
            gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
            gbc_btnSave.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnSave.gridx = 2;
            gbc_btnSave.gridy = 1;
            pNetworkButtons.add(getBtnSave(), gbc_btnSave);
        }
        return pNetworkButtons;
    }

    public JList<Subnet> getListSubnets() {
        if (listSubnets == null) {
            listSubnets = new JList<>();
            listSubnets.setModel(new DefaultListModel<>());
            listSubnets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSubnets.addListSelectionListener(e -> {
                if (getListSubnets().getSelectedValue() != null) {
                    getTpNetworkSubnetsHosts().setEnabledAt(2, true);
                    getTfSubnetAddress().setText(String.valueOf(getListSubnets().getSelectedValue().toString()));

                    if (getListSubnets().getSelectedValue().getDepartment() != null) {
                        getTfDepartment().setText(getListSubnets().getSelectedValue().getDepartment().getName());
                    }

                    if (getListSubnets().getSelectedValue().getIpv4Network().getFirstAddress() != null) {
                        getTfBroadcastaddress().setText(getListSubnets().getSelectedValue().getIpv4Network().getLastAddress().toString());
                    }

                    DefaultListModel df = (DefaultListModel) getListHosts().getModel();
                    df.clear();

                    if (getListSubnets().getSelectedValue().getHosts() != null) {
                        getListSubnets().getSelectedValue().getHosts().forEach(df::addElement);
                    }
                } else {
                    getTfDepartment().setText("");
                    getTpNetworkSubnetsHosts().setEnabledAt(2, false);
                }
            });
        }
        return listSubnets;
    }

    private JPanel getPSubnetButtons() {
        if (pSubnetButtons == null) {
            pSubnetButtons = new JPanel();
            GridBagLayout gbl_pSubnetButtons = new GridBagLayout();
            gbl_pSubnetButtons.columnWidths = new int[]{0, 0, 0, 0};
            gbl_pSubnetButtons.rowHeights = new int[]{0, 0};
            gbl_pSubnetButtons.columnWeights = new double[]{0.0, 0.0, 0.0,
                    Double.MIN_VALUE};
            gbl_pSubnetButtons.rowWeights = new double[]{0.0,
                    Double.MIN_VALUE};
            pSubnetButtons.setLayout(gbl_pSubnetButtons);
            GridBagConstraints gbc_btnAddSubnet = new GridBagConstraints();
            gbc_btnAddSubnet.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnAddSubnet.insets = new Insets(0, 0, 0, 5);
            gbc_btnAddSubnet.gridx = 0;
            gbc_btnAddSubnet.gridy = 0;
            pSubnetButtons.add(getBtnAddSubnet(), gbc_btnAddSubnet);
            GridBagConstraints gbc_btnDeleteSubnet = new GridBagConstraints();
            gbc_btnDeleteSubnet.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnDeleteSubnet.insets = new Insets(0, 0, 0, 5);
            gbc_btnDeleteSubnet.gridx = 1;
            gbc_btnDeleteSubnet.gridy = 0;
            pSubnetButtons.add(getBtnDeleteSubnet(), gbc_btnDeleteSubnet);
        }
        return pSubnetButtons;
    }

    private JButton getBtnAddSubnet() {
        if (btnAddSubnet == null) {
            btnAddSubnet = new JButton("Add Subnet");
            btnAddSubnet.addActionListener(e -> new SubnetCreatorDialog(SubnetCalculatorFrame.this));
        }
        return btnAddSubnet;
    }

    private JButton getBtnDeleteSubnet() {
        if (btnDeleteSubnet == null) {
            btnDeleteSubnet = new JButton("Delete Subnet");
            btnDeleteSubnet.addActionListener(e -> {
                if (getListSubnets().getSelectedValue() != null) {
                    getListNetworks().getSelectedValue().removeSubnetFromList(getListSubnets().getSelectedValue());
                    ((DefaultListModel) getListSubnets().getModel()).remove(getListSubnets().getSelectedIndex());
                }
            });
        }
        return btnDeleteSubnet;
    }

    private JPanel getPHosts() {
        if (pHosts == null) {
            pHosts = new JPanel();
            GridBagLayout gbl_pHosts = new GridBagLayout();
            gbl_pHosts.columnWidths = new int[]{0, 0, 0};
            gbl_pHosts.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
            gbl_pHosts.columnWeights = new double[]{0.0, 1.0,
                    Double.MIN_VALUE};
            gbl_pHosts.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0,
                    1.0, 0.0, Double.MIN_VALUE};
            pHosts.setLayout(gbl_pHosts);
            GridBagConstraints gbc_lblSubnetaddress = new GridBagConstraints();
            gbc_lblSubnetaddress.anchor = GridBagConstraints.NORTHWEST;
            gbc_lblSubnetaddress.insets = new Insets(5, 5, 5, 5);
            gbc_lblSubnetaddress.gridx = 0;
            gbc_lblSubnetaddress.gridy = 0;
            pHosts.add(getLblSubnetaddress(), gbc_lblSubnetaddress);
            GridBagConstraints gbc_tfSubnetAddress = new GridBagConstraints();
            gbc_tfSubnetAddress.anchor = GridBagConstraints.NORTH;
            gbc_tfSubnetAddress.insets = new Insets(5, 0, 5, 0);
            gbc_tfSubnetAddress.fill = GridBagConstraints.HORIZONTAL;
            gbc_tfSubnetAddress.gridx = 1;
            gbc_tfSubnetAddress.gridy = 0;
            pHosts.add(getTfSubnetAddress(), gbc_tfSubnetAddress);
            GridBagConstraints gbc_lblBroadcastaddress = new GridBagConstraints();
            gbc_lblBroadcastaddress.insets = new Insets(5, 5, 5, 5);
            gbc_lblBroadcastaddress.anchor = GridBagConstraints.NORTHWEST;
            gbc_lblBroadcastaddress.gridx = 0;
            gbc_lblBroadcastaddress.gridy = 1;
            pHosts.add(getLblBroadcastaddress(), gbc_lblBroadcastaddress);
            GridBagConstraints gbc_tfBroadcastaddress = new GridBagConstraints();
            gbc_tfBroadcastaddress.insets = new Insets(5, 0, 5, 0);
            gbc_tfBroadcastaddress.fill = GridBagConstraints.HORIZONTAL;
            gbc_tfBroadcastaddress.gridx = 1;
            gbc_tfBroadcastaddress.gridy = 1;
            pHosts.add(getTfBroadcastaddress(), gbc_tfBroadcastaddress);
            GridBagConstraints gbc_lblHosts = new GridBagConstraints();
            gbc_lblHosts.anchor = GridBagConstraints.NORTHWEST;
            gbc_lblHosts.insets = new Insets(5, 5, 5, 5);
            gbc_lblHosts.gridx = 0;
            gbc_lblHosts.gridy = 2;
            pHosts.add(getLblHosts(), gbc_lblHosts);
            GridBagConstraints gbc_listHosts = new GridBagConstraints();
            gbc_listHosts.insets = new Insets(5, 0, 5, 0);
            gbc_listHosts.fill = GridBagConstraints.BOTH;
            gbc_listHosts.gridx = 1;
            gbc_listHosts.gridy = 2;
            pHosts.add(getListHosts(), gbc_listHosts);
            GridBagConstraints gbc_lblBinary = new GridBagConstraints();
            gbc_lblBinary.anchor = GridBagConstraints.NORTHWEST;
            gbc_lblBinary.insets = new Insets(5, 5, 5, 5);
            gbc_lblBinary.gridx = 0;
            gbc_lblBinary.gridy = 3;
            pHosts.add(getLblBinary(), gbc_lblBinary);
            GridBagConstraints gbc_tfBinary = new GridBagConstraints();
            gbc_tfBinary.insets = new Insets(0, 0, 5, 0);
            gbc_tfBinary.fill = GridBagConstraints.HORIZONTAL;
            gbc_tfBinary.gridx = 1;
            gbc_tfBinary.gridy = 3;
            pHosts.add(getTfBinary(), gbc_tfBinary);
            GridBagConstraints gbc_lblDescription = new GridBagConstraints();
            gbc_lblDescription.anchor = GridBagConstraints.NORTHWEST;
            gbc_lblDescription.insets = new Insets(5, 5, 5, 5);
            gbc_lblDescription.gridx = 0;
            gbc_lblDescription.gridy = 4;
            pHosts.add(getLblDescription(), gbc_lblDescription);
            GridBagConstraints gbc_sPDescription = new GridBagConstraints();
            gbc_sPDescription.insets = new Insets(0, 0, 5, 0);
            gbc_sPDescription.fill = GridBagConstraints.BOTH;
            gbc_sPDescription.gridx = 1;
            gbc_sPDescription.gridy = 4;
            pHosts.add(getSPDescription(), gbc_sPDescription);
            GridBagConstraints gbc_pHostButtons = new GridBagConstraints();
            gbc_pHostButtons.gridwidth = 2;
            gbc_pHostButtons.fill = GridBagConstraints.BOTH;
            gbc_pHostButtons.gridx = 0;
            gbc_pHostButtons.gridy = 5;
            pHosts.add(getPHostButtons(), gbc_pHostButtons);
        }
        return pHosts;
    }

    private JLabel getLblDescription() {
        if (lblDescription == null) {
            lblDescription = new JLabel("Description");
        }
        return lblDescription;
    }

    private JLabel getLblBinary() {
        if (lblBinary == null) {
            lblBinary = new JLabel("Binary");
        }
        return lblBinary;
    }

    private JTextField getTfBinary() {
        if (tfBinary == null) {
            tfBinary = new JTextField();
            tfBinary.setEditable(false);
            tfBinary.setColumns(10);
        }
        return tfBinary;
    }

    private JLabel getLblHosts() {
        if (lblHosts == null) {
            lblHosts = new JLabel("Hosts");
        }
        return lblHosts;
    }

    public JList<Host> getListHosts() {
        if (listHosts == null) {
            listHosts = new JList<>();
            listHosts.setModel(new DefaultListModel<>());
            listHosts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listHosts.addListSelectionListener(e -> {
                if (getListHosts().getSelectedValue() != null) {
                    String addrString = getListHosts().getSelectedValue().toString().replace(":", " ").replace(".", " ");
                    String binaryString = "";

                    String[] stringParts = addrString.split(" ");
                    for (String s : stringParts) {
                        binaryString += Converter.convertHexadecimalToBinary(s) + " ";
                    }

                    if (getListHosts().getSelectedValue().getDescription() != null) {
                        getTaDescription().setText(getListHosts().getSelectedValue().getDescription());
                    }

                    getTfBinary().setText(binaryString);
                } else {
                    getTfBinary().setText("");
                    getTaDescription().setText("");
                }
            });
        }
        return listHosts;
    }

    private JScrollPane getSPDescription() {
        if (sPDescription == null) {
            sPDescription = new JScrollPane();
            sPDescription.setViewportView(getTaDescription());
        }
        return sPDescription;
    }

    private JTextArea getTaDescription() {
        if (taDescription == null) {
            taDescription = new JTextArea();
            taDescription.setEditable(false);
        }
        return taDescription;
    }

    private JPanel getPHostButtons() {
        if (pHostButtons == null) {
            pHostButtons = new JPanel();
            GridBagLayout gbl_pHostButtons = new GridBagLayout();
            gbl_pHostButtons.columnWidths = new int[]{0, 0, 0};
            gbl_pHostButtons.rowHeights = new int[]{0, 0};
            gbl_pHostButtons.columnWeights = new double[]{0.0, 0.0,
                    Double.MIN_VALUE};
            gbl_pHostButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
            pHostButtons.setLayout(gbl_pHostButtons);
            GridBagConstraints gbc_btnAddHost = new GridBagConstraints();
            gbc_btnAddHost.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnAddHost.insets = new Insets(0, 0, 0, 5);
            gbc_btnAddHost.gridx = 0;
            gbc_btnAddHost.gridy = 0;
            pHostButtons.add(getBtnAddHost(), gbc_btnAddHost);
            GridBagConstraints gbc_btnDeleteHost = new GridBagConstraints();
            gbc_btnDeleteHost.anchor = GridBagConstraints.NORTHWEST;
            gbc_btnDeleteHost.gridx = 1;
            gbc_btnDeleteHost.gridy = 0;
            pHostButtons.add(getBtnDeleteHost(), gbc_btnDeleteHost);
        }
        return pHostButtons;
    }

    private JButton getBtnAddHost() {
        if (btnAddHost == null) {
            btnAddHost = new JButton("Add Host");
            btnAddHost.addActionListener(e -> new HostCreatorDialog(SubnetCalculatorFrame.this));
        }
        return btnAddHost;
    }

    private JButton getBtnDeleteHost() {
        if (btnDeleteHost == null) {
            btnDeleteHost = new JButton("Delete Host");
            btnDeleteHost.addActionListener(e -> {
                if (getListHosts().getSelectedValue() != null) {
                    getListSubnets().getSelectedValue().removeHostFromList(getListHosts().getSelectedValue());
                    ((DefaultListModel) getListHosts().getModel()).remove(getListHosts().getSelectedIndex());
                }
            });
        }
        return btnDeleteHost;
    }

    private JLabel getLblSubnetaddress() {
        if (lblSubnetaddress == null) {
            lblSubnetaddress = new JLabel("Subnetaddress");
        }
        return lblSubnetaddress;
    }

    private JTextField getTfSubnetAddress() {
        if (tfSubnetAddress == null) {
            tfSubnetAddress = new JTextField();
            tfSubnetAddress.setColumns(10);
        }
        return tfSubnetAddress;
    }

    private JTextField getTfBroadcastaddress() {
        if (tfBroadcastaddress == null) {
            tfBroadcastaddress = new JTextField();
            tfBroadcastaddress.setColumns(10);
            tfBroadcastaddress.setEditable(false);
        }
        return tfBroadcastaddress;
    }

    private JLabel getLblBroadcastaddress() {
        if (lblBroadcastaddress == null) {
            lblBroadcastaddress = new JLabel("Broadcastaddress");
        }
        return lblBroadcastaddress;
    }

    private JButton getBtnGenerateSubnets() {
        if (btnGenerateSubnets == null) {
            btnGenerateSubnets = new JButton("Generate Subnets");
            btnGenerateSubnets.addActionListener(e -> {
                if (getListNetworks().getSelectedValue() != null) {
                    new SubnetGeneratorDialog(SubnetCalculatorFrame.this);
                }
            });
        }
        return btnGenerateSubnets;
    }
}
