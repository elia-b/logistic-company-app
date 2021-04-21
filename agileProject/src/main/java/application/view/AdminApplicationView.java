package application.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import application.controller.AdminController;


public class AdminApplicationView extends JFrame{
	private AdminController controller;

	
	public AdminApplicationView(AdminController controller) {
		this.controller = controller;
		initGUI();
	}
	public void showError(String string) {
		JOptionPane.showMessageDialog(this, string , "Admin Response", JOptionPane.ERROR_MESSAGE);
	}
	public void showSuccess(String string) {
		JOptionPane.showMessageDialog(this, string , "Admin Response", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Application");
		setPreferredSize(new Dimension(800, 600));
		
		// buttons
		JButton btnNew = new JButton("Register new Client");
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.registerClient();
			}
		});
		
		JButton btnsearchName = new JButton("Search by Name");
		btnsearchName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.searchName();
				
			}
		});
		JButton btnsearchEmail = new JButton("Search by Email");
		btnsearchEmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.searchEmail();
				
			}
		});
		JButton btnupdateJourney = new JButton("update Journey");
		btnupdateJourney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateJourney();
				
			}
		});
		JButton btnregisterContainer = new JButton("Register Container");
		btnregisterContainer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.registerContainer();
				
			}
		});
		JButton btnfinishJourney = new JButton("Finish Journey");
		btnfinishJourney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.finishJourney();
				
			}
		});
		JButton btnupdateStatus = new JButton("Update Status");
		btnupdateStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateStatus();
				
			}
		});
		JButton btnlogOut = new JButton("Log-Out");
		btnlogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logOut();
				
			}
		});
		JButton addLocation = new JButton("Register New Location");
		addLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addNewLocation();
				
			}
		});
		JButton getJourneyOfContainer = new JButton("Get Journeys Of Container");
		getJourneyOfContainer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getJourneysOfContainer();
				
			}
		});
		JButton getContainerStatus = new JButton("Get All Contanier Status");
		getContainerStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getContainerHistory();
				
			}
		});
		JButton getContainerStatusInJourney = new JButton("Get All Contanier Status from Journey");
		getContainerStatusInJourney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getContainerHistoryfromJourney();
				
			}
		});
		
		
		
		
		this.setLayout(new FlowLayout());
		this.add(btnupdateStatus);
		this.add(btnfinishJourney);
		this.add(btnregisterContainer);
		this.add(btnsearchEmail);
		this.add(btnupdateJourney);
		this.add(btnsearchName);
		this.add(btnNew);
		this.add(addLocation);
		this.add(getJourneyOfContainer);
		this.add(getContainerStatus);
		this.add(getContainerStatusInJourney);
		this.add(btnlogOut);
		this.pack();
		
		
		
	}
	
	
}
