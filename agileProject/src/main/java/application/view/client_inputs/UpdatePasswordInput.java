package application.view.client_inputs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import application.controller.ClientController;
import application.model.tablemodel.ClientTable;

public class UpdatePasswordInput extends JFrame{
	private  JPanel mainPanel;
    private  JButton Button;
    private  JPanel inputPanel;
    
    private ClientTable table;
    private JPasswordField passwordField;
    private JPasswordField passwordField1;
    private JFrame jframe;

    
    private ClientController controller;

    public UpdatePasswordInput(ClientController controller) {
        
    	this.controller=controller;


		setTitle("Change Password");
    	
    	jframe = this;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Button = new JButton();
        Button.setText("Change");
        mainPanel.add(Button, BorderLayout.SOUTH);
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 5, 5, 3)));

        //label 1
        final JLabel label1 = new JLabel();
        label1.setRequestFocusEnabled(false);
        label1.setText("Password");
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

        //password label 1
        passwordField1 = new JPasswordField();
        passwordField1.setPreferredSize(new Dimension(200, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(passwordField1, gbc);
        
        
        
        final JLabel label2 = new JLabel();
        label2.setText("Repeat Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(label2, gbc);

        //horizontal spacer row 2
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(spacer2, gbc);

        //password label 2
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(passwordField, gbc);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();


        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField1.getPassword()))) {
            		String message = controller.getApp().updatePassword( String.valueOf(passwordField.getPassword()));
            		if (message.equals("Password succesfully updated.")) {
            			controller.getView().showSuccess(message);
            		}else {
            			controller.getView().showError(message);
            		}
            	}else {
            		controller.getView().showError("Passwords don't match. Please try again.");
            	}
            	
        		
        		jframe.dispose();
        		
            }
        });
    }
}