package application.view.client_inputs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.controller.ClientController;
import application.model.Journey;
import application.model.LogisticCompany;
import application.model.tablemodel.ClientTable;
import application.model.tablemodel.JourneyTable;
import application.utils.LocationPicker;

public class FilterJourneyDestinationInput extends JFrame{
	private  JPanel mainPanel;
    private  JButton Button;
    private  JPanel inputPanel;
    
    

    private JFrame jframe;

    
    private ClientController controller;

    public FilterJourneyDestinationInput(ClientController controller) {
        
    	this.controller=controller;

		setTitle("Filter by Destination");
    	
    	jframe = this;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Button = new JButton();
        Button.setText("Filter");
        mainPanel.add(Button, BorderLayout.SOUTH);
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 5, 5, 3)));

        //label 1
        final JLabel label3 = new JLabel();
        label3.setRequestFocusEnabled(false);
        label3.setText("Destination");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(label3, gbc);

        //horizontal spacer row 1
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(spacer3, gbc);

        //textfield label 1
        LocationPicker comboloc2 = LogisticCompany.GetInstance().getLocationDatabase().getLocationPicker2();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(comboloc2, gbc);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();


        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 
            	
        		List<Journey> results = controller.getApp().filterJourneysbyDestination(comboloc2.getSelectedLocation());
        		if (!results.isEmpty()) {
        			
        			controller.getView().getResultTable().setModel(new JourneyTable(results));
        		}else {
        			controller.getView().showError("No such journeys found. Please try again.");
        		}
        		jframe.dispose();
        		
            }
        });
    }
}
