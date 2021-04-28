package application.view.admin_inputs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.controller.AdminController;
import application.model.Client;
import application.model.ContainerStatus;
import application.model.LogisticCompany;
import application.model.tablemodel.ClientTable;
import application.model.tablemodel.ContainerStatusTable;

public class ContainerHistoryFromJourneyInput extends JFrame{
	private  JPanel mainPanel;
    private  JButton Button;
    private  JPanel inputPanel;
    private final JTextField textField1;
    private final JTextField textField2;
    private ContainerStatusTable table;

    private JFrame jframe;

    
    private AdminController controller;

    public ContainerHistoryFromJourneyInput(AdminController controller) {
        
    	this.controller=controller;

    	
		setTitle("Container Journey Status History");
    	
    	jframe = this;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Button = new JButton();
        Button.setText("View");
        mainPanel.add(Button, BorderLayout.SOUTH);
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 5, 5, 3)));

        //label 1
        final JLabel label1 = new JLabel();
        label1.setRequestFocusEnabled(false);
        label1.setText("Container ID");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(label1, gbc);

        //horizontal spacer row 1
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(spacer1, gbc);

        //textfield label 1
        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(200, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(textField1, gbc);
        
      //label 1
        final JLabel label2 = new JLabel();
        label2.setRequestFocusEnabled(false);
        label2.setText("Journey ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(label2, gbc);

        //horizontal spacer row 1
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(spacer2, gbc);

        //textfield label 1
        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(200, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(textField2, gbc);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();


        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

        		try {
        			List<ContainerStatus> arraylist = (List<ContainerStatus>) controller.getApp().getStatusesFromContainerOnJourney(Integer.valueOf(textField1.getText()), Integer.valueOf(textField2.getText()));
        			table = new ContainerStatusTable(arraylist);
        			controller.getView().setTableModel(table);
        		}
        		catch (Exception err) {
        			controller.getView().showError(err.getMessage());
        		}
        		
            	jframe.dispose();
            }
        });
    }
    
}

