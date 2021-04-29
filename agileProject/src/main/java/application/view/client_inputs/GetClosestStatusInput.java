package application.view.client_inputs;

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
import javax.swing.JTable;
import javax.swing.JTextField;

import application.controller.AdminController;
import application.controller.ClientController;
import application.model.Client;
import application.model.ContainerStatus;
import application.model.LogisticCompany;
import application.model.tablemodel.ClientTable;
import application.model.tablemodel.ContainerStatusTable;
import application.utils.TimeNDatePicker;

public class GetClosestStatusInput extends JFrame{
	private  JPanel mainPanel;
    private  JButton Button;
    private  JPanel inputPanel;
    private final JTextField textField1;
    private ClientTable table;

    private JFrame jframe;

    
    private ClientController controller;

    public GetClosestStatusInput(ClientController controller) {
        
    	this.controller=controller;

		setTitle("View Journey Status by Date");
    	
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
        label1.setText("Journey ID");
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
        
        
        
        final JLabel label5 = new JLabel();
        label5.setText("Date");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(label5, gbc);

        //horizontal spacer row 3
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(spacer5, gbc);

        //textfield label 3

        TimeNDatePicker tnd = new TimeNDatePicker();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(tnd, gbc);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();


        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		int idi = Integer.valueOf(textField1.getText());
            		List<ContainerStatus> results = controller.getApp().getclosestStatus(idi,tnd.getDate());
            		if (results.size() > 0){
            			
            			controller.getView().getResultTable().setModel(new ContainerStatusTable(results));
            			
            			
            		} else {
            			controller.getView().showSuccess("No registered status found. Please try again.");
            		}
            	}
        		catch (NumberFormatException err) {
        			controller.getView().showError("Invalid information. Please try again.");
        		}
        		
            	jframe.dispose();
            }
        });
    }
    
}