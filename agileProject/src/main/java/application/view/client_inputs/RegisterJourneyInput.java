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
import javax.swing.JTextField;

import application.controller.AdminController;
import application.controller.ClientController;
import application.model.Client;
import application.model.Journey;
import application.model.LogisticCompany;
import application.model.tablemodel.ClientTable;
import application.model.tablemodel.JourneyTable;
import application.utils.LocationPicker;

public class RegisterJourneyInput extends JFrame{
	private  JPanel mainPanel;
    private  JButton Button;
    private  JPanel inputPanel;
    private final JTextField textField1;
    private final JTextField textField2;


    private JFrame jframe;
    
    
    private ClientController controller;

    public RegisterJourneyInput(ClientController controller) {
        
    	this.controller=controller;
    	
    	jframe = this;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Button = new JButton();
        Button.setText("Update Journey");
        mainPanel.add(Button, BorderLayout.SOUTH);
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 5, 5, 3)));

        //label 1
        final JLabel label1 = new JLabel();
        label1.setRequestFocusEnabled(false);
        label1.setText("Content");
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

        
        
        //label 2
        final JLabel label2 = new JLabel();
        label2.setRequestFocusEnabled(false);
        label2.setText("Origin");
        gbc = new GridBagConstraints();
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
        LocationPicker comboloc = LogisticCompany.GetInstance().getLocationDatabase().getLocationPicker();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(comboloc, gbc);
        
      //label 2
        final JLabel label3 = new JLabel();
        label3.setRequestFocusEnabled(false);
        label3.setText("Destination");
        gbc = new GridBagConstraints();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(label3, gbc);

        //horizontal spacer row 1
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(spacer3, gbc);

        //textfield label 1
        LocationPicker comboloc2 = LogisticCompany.GetInstance().getLocationDatabase().getLocationPicker2();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(comboloc2, gbc);
        
      //label 1
        final JLabel label4 = new JLabel();
        label4.setRequestFocusEnabled(false);
        label4.setText("N of Containers");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(label4, gbc);

        //horizontal spacer row 1
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(spacer4, gbc);

        //textfield label 1
        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(200, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
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
            		
            	
	        		Journey j = new Journey(textField1.getText(), comboloc.getSelectedLocation(), comboloc2.getSelectedLocation(), Integer.valueOf(textField2.getText()), controller.getClientid());
	        		String message = controller.getApp().registerJourney(j);
	        		if (message.equals("Successful Registration")) {
	        			List<Journey> myjourneys = LogisticCompany.GetInstance().getJourneys().getMyJourneys(controller.getClientid());
	                    controller.getView().getResultTable().setModel(new JourneyTable(myjourneys));
	        			controller.getView().showSuccess(message);
	        		}else {
	        			controller.getView().showError(message);
	        		}
            	} catch (NumberFormatException err) {
            		controller.getView().showError("Expected a Number");
            	}
            	
        		jframe.dispose();
        		
            }
        });
    }
    
    
    
}
