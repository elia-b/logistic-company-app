package application.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import application.controller.ClientController;


public class ClientApplicationView extends JFrame {
	
	private ClientController controller;

	public void showError(String string) {
		JOptionPane.showMessageDialog(this, string , "Admin Response", JOptionPane.ERROR_MESSAGE);
	}
	public void showSuccess(String string) {
		JOptionPane.showMessageDialog(this, string , "Admin Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public ClientApplicationView(ClientController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client Application");
		setPreferredSize(new Dimension(800, 600));
		
		// buttons
		JButton btnUpadateName = new JButton("Update Name");
		btnUpadateName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.update_name();
			}
		});
		JButton btnUpadateEmail = new JButton("update Email");
		btnUpadateEmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.update_email();
			}
		});
		JButton btnUpadatePassword = new JButton("Update Password");
		btnUpadatePassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.update_password();
			}
		});
		JButton btnUpadateAddress = new JButton("update Address");
		btnUpadateAddress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.update_address();
			}
		});
		JButton btnUpadateCPerson = new JButton("update Contact Person");
		btnUpadateCPerson.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.update_contact_person();
			}
		});
		JButton btnFilterJByContent = new JButton("Filter Journey by Content");
		btnFilterJByContent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.filter_journey_by_content();
			}
		});
		JButton btnFilterJByDestination = new JButton("Filter Journey by Destination");
		btnFilterJByDestination.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.filter_journey_by_destination();
			}
		});
		JButton btnFilterJByOrigin = new JButton("Filter Journey by Origin");
		btnFilterJByOrigin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.filter_journey_by_origin();
			}
		});
		JButton btnRegisterJourney = new JButton("Register Journey");
		btnRegisterJourney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.register_journey();
			}
		});
		JButton btnLatestStatus = new JButton("Get latest Status");
		btnLatestStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.get_latest_status();
			}
		});
		JButton btnClosesStatus = new JButton("Get closest Status");
		btnClosesStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.get_closes_status();
			}
		});
		JButton btnlogOut = new JButton("Log-Out");
		btnlogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logOut();
				
			}
		});

		this.setLayout(new FlowLayout());
		this.add(btnUpadateName);
		this.add(btnUpadateEmail);
		this.add(btnUpadatePassword);
		this.add(btnUpadateCPerson);
		this.add(btnUpadateAddress);
		this.add(btnFilterJByContent);
		this.add(btnFilterJByDestination);
		this.add(btnFilterJByOrigin);
		this.add(btnRegisterJourney);
		this.add(btnLatestStatus);
		this.add(btnClosesStatus);
		this.add(btnlogOut);
		this.pack();
		
	}

}
