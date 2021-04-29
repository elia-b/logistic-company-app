package application.view.admin_inputs;

import javax.swing.*;

import application.controller.AdminController;
import application.controller.ClientController;
import application.model.Client;
import application.model.LogisticCompany;
import application.model.tablemodel.ClientTable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RegisterClientInput extends JFrame {
	private JPanel mainPanel;
	private JButton Button;
	private JPanel inputPanel;
	private final JTextField textField1;
	private final JTextField textField2;
	private final JTextField textField3;
	private final JTextField textField4;
	private JFrame jframe;

	private ArrayList<JTextField> textFields;

	private AdminController controller;

	public RegisterClientInput(AdminController controller) {

		this.controller = controller;

		setTitle("Register Client");

		jframe = this;
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		Button = new JButton();
		Button.setText("Register");
		mainPanel.add(Button, BorderLayout.SOUTH);
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		mainPanel.add(inputPanel, BorderLayout.CENTER);
		inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 5, 5, 3)));

		// label 1
		final JLabel label1 = new JLabel();
		label1.setRequestFocusEnabled(false);
		label1.setText("Company Name");
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		inputPanel.add(label1, gbc);

		// horizontal spacer row 1
		final JPanel spacer1 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(spacer1, gbc);

		// textfield label 1
		textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(200, 30));
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(textField1, gbc);

		// label 2
		final JLabel label2 = new JLabel();
		label2.setText("Email");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		inputPanel.add(label2, gbc);

		// horizontal spacer row 2
		final JPanel spacer2 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(spacer2, gbc);

		// textfield label 2
		textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(200, 30));
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(textField2, gbc);

		// label 3
		final JLabel label3 = new JLabel();
		label3.setText("Address");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		inputPanel.add(label3, gbc);

		// horizontal spacer row 3
		final JPanel spacer3 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(spacer3, gbc);

		// textfield label 3
		textField3 = new JTextField();
		textField3.setPreferredSize(new Dimension(200, 30));
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(textField3, gbc);

		final JLabel label4 = new JLabel();
		label4.setText("Contact Person");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		inputPanel.add(label4, gbc);

		// horizontal spacer row 3
		final JPanel spacer4 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(spacer4, gbc);

		// textfield label 3
		textField4 = new JTextField();
		textField4.setPreferredSize(new Dimension(200, 30));
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(textField4, gbc);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setContentPane(mainPanel);
		this.setResizable(false);
		this.pack();

		Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Client client = new Client(textField1.getText(), textField2.getText(), textField3.getText(),
						textField4.getText());

				String message = controller.getApp().register_new_client(client);
				if (message.equals("Client successfully registered.")) {
					controller.getView().showSuccess(message);

					List<Client> clients = LogisticCompany.GetInstance().getClientDatabase().getAll();
					controller.getView().setTableModel(new ClientTable(clients));

				} else {
					controller.getView().showError(message);
				}
				jframe.dispose();

			}
		});
	}

	// textFields.get(0).getText(),textFields.get(1).getText(),textFields.get(2).getText(),textFields.get(3).getText()

}
