package application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import application.controller.ClientController;
import application.model.Client;
import application.model.Container;
import application.model.Journey;
import application.model.LogisticCompany;
import application.model.tablemodel.ClientTable;
import application.model.tablemodel.ContainerTable;
import application.model.tablemodel.JourneyTable;


public class ClientApplicationView extends JFrame {
	private  JPanel mainPanel;
    private  JPanel navigationPanel;
    private  JPanel toolsPanel;
    private  JLabel usernameLabel;
    private  JLabel clientTerminalLabel;
    private  JPanel textPanel;
    private  JButton filterByContentButton;
    private  JButton filterByDestinationButton;
    private  JButton filterByOriginButton;
    private  JButton resetFilterButton;
    private  JPanel filterPanel;
    private  JPanel controlPanel;
    private  JButton registerJourneyButton;
    private  JButton getLatestJourneyStatusButton;
    private  JButton getJourneyStatusByButton;
    private  JButton updateCompanyNameButton;
    private  JButton updateCompanyEmailButton;
    private  JButton updateCompanyAddressButton;
    private  JButton updateContactPersonButton;
    private  JButton changePasswordButton;
    
    private  JButton myContainersButton;
    private  JButton myJourneysButton;
    
    private  JButton logOutButton;
    private  JPanel navigationBottomPanel;
    private  JPanel updateInfoPanel;
    private  JTable resultsTable;
    private  JPanel tablePanel;

	
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
		mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        navigationPanel = new JPanel();
        navigationPanel.setLayout(new BorderLayout(0, 0));
        navigationPanel.setPreferredSize(new Dimension(200, 132));
        mainPanel.add(navigationPanel, BorderLayout.WEST);
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout(0, 2));
        navigationPanel.add(textPanel, BorderLayout.NORTH);
        textPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 12, 5, 0)));
        usernameLabel = new JLabel();
        String username = LogisticCompany.GetInstance().getClientDatabase().getValueFromID(controller.getClientid()).getName();
        usernameLabel.setText("<html>" + "<B>" + "Client: " + username + "</B>" + "</html>");
        textPanel.add(usernameLabel, BorderLayout.NORTH);
        clientTerminalLabel = new JLabel();
        clientTerminalLabel.setText("<html>" + "<I>" + "Client Terminal" + "</I>" + "</html>");
        textPanel.add(clientTerminalLabel, BorderLayout.CENTER);
        updateInfoPanel = new JPanel();
        updateInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        navigationPanel.add(updateInfoPanel, BorderLayout.CENTER);
        updateCompanyNameButton = new JButton();
        updateCompanyNameButton.setPreferredSize(new Dimension(200, 30));
        updateCompanyNameButton.setText("Update Company Name");
        updateInfoPanel.add(updateCompanyNameButton);
        updateCompanyEmailButton = new JButton();
        updateCompanyEmailButton.setPreferredSize(new Dimension(200, 30));
        updateCompanyEmailButton.setText("Update Company Email");
        updateInfoPanel.add(updateCompanyEmailButton);
        updateCompanyAddressButton = new JButton();
        updateCompanyAddressButton.setPreferredSize(new Dimension(200, 30));
        updateCompanyAddressButton.setText("Update Company Address");
        updateInfoPanel.add(updateCompanyAddressButton);
        updateContactPersonButton = new JButton();
        updateContactPersonButton.setPreferredSize(new Dimension(200, 30));
        updateContactPersonButton.setText("Update Contact Person");
        updateInfoPanel.add(updateContactPersonButton);
        navigationBottomPanel = new JPanel();
        navigationBottomPanel.setLayout(new BorderLayout(0, 0));
        navigationPanel.add(navigationBottomPanel, BorderLayout.SOUTH);
        changePasswordButton = new JButton();
        changePasswordButton.setText("Change Password");
        navigationBottomPanel.add(changePasswordButton, BorderLayout.NORTH);
        logOutButton = new JButton();
        logOutButton.setText("Log Out");
        navigationBottomPanel.add(logOutButton, BorderLayout.SOUTH);
        toolsPanel = new JPanel();
        toolsPanel.setLayout(new BorderLayout(0, 0));
        toolsPanel.setPreferredSize(new Dimension(840, 600));
        mainPanel.add(toolsPanel, BorderLayout.CENTER);
        toolsPanel.setBorder(BorderFactory.createTitledBorder(null, "Journey and Container Management Tools"));
        filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        toolsPanel.add(filterPanel, BorderLayout.NORTH);
        filterByContentButton = new JButton();
        filterByContentButton.setText("Filter by Content");
        filterByContentButton.setToolTipText("Filter my journeys by content");
        filterPanel.add(filterByContentButton);
        filterByDestinationButton = new JButton();
        filterByDestinationButton.setText("Filter by Destination");
        filterByDestinationButton.setToolTipText("Filter my journeys by destination");
        filterPanel.add(filterByDestinationButton);
        filterByOriginButton = new JButton();
        filterByOriginButton.setText("Filter by Origin");
        filterByOriginButton.setToolTipText("Filter my journeys by origin");
        filterPanel.add(filterByOriginButton);
        resetFilterButton = new JButton();
        resetFilterButton.setText("Reset Filter");
        resetFilterButton.setToolTipText("Reset journey search filter");
        filterPanel.add(resetFilterButton);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        controlPanel.setRequestFocusEnabled(true);
        toolsPanel.add(controlPanel, BorderLayout.SOUTH);
        registerJourneyButton = new JButton();
        registerJourneyButton.setText("New Journey");
        registerJourneyButton.setToolTipText("Register a new journey");
        controlPanel.add(registerJourneyButton);
        getLatestJourneyStatusButton = new JButton();
        getLatestJourneyStatusButton.setText("Latest Journey Status");
        getLatestJourneyStatusButton.setToolTipText("View the latest status of a journey");
        controlPanel.add(getLatestJourneyStatusButton);
        getJourneyStatusByButton = new JButton();
        getJourneyStatusByButton.setText("Journey Status by Date");
        getJourneyStatusByButton.setToolTipText("View status of a journey at a specific time");
        controlPanel.add(getJourneyStatusByButton);
        
        myJourneysButton = new JButton();
        myJourneysButton.setText("My Journeys");
        myJourneysButton.setToolTipText("View myjourneys, same as reset filter");
        controlPanel.add(myJourneysButton);
        myContainersButton = new JButton();
        myContainersButton.setText("My Containers");
        myContainersButton.setToolTipText("View content and location of my containers");
        controlPanel.add(myContainersButton);
        
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout(0, 0));
        toolsPanel.add(tablePanel, BorderLayout.CENTER);
        tablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        final JScrollPane tableScrollPane = new JScrollPane();
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
        resultsTable = new JTable();
        List<Journey> myjourneys = LogisticCompany.GetInstance().getJourneys().getMyJourneys(controller.getClientid());
        resultsTable.setModel(new JourneyTable(myjourneys));
        tableScrollPane.setViewportView(resultsTable);
        resultsTable.getTableHeader().setBackground(Color.white);
        tableScrollPane.setViewportView(resultsTable);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();

        updateCompanyNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.update_name();
            }
        });
        updateCompanyEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.update_email();
            }
        });
        updateCompanyAddressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.update_address();
            }
        });
        updateContactPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.update_contact_person();
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.update_password();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.logOut();
            }
        });
        filterByContentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.filter_journey_by_content();
            }
        });
        filterByDestinationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.filter_journey_by_destination();
            }
        });
        filterByOriginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.filter_journey_by_origin();
            }
        });
        resetFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	List<Journey> myjourneys = LogisticCompany.GetInstance().getJourneys().getMyJourneys(controller.getClientid());
                resultsTable.setModel(new JourneyTable(myjourneys));
            }
        });
        registerJourneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.register_journey();
            }
        });
        getLatestJourneyStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.get_latest_status();
            }
        });
        getJourneyStatusByButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.get_closes_status();
            }
        });
        myJourneysButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	List<Journey> myjourneys = LogisticCompany.GetInstance().getJourneys().getMyJourneys(controller.getClientid());
                resultsTable.setModel(new JourneyTable(myjourneys));
            }
        });
        myContainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	List<Journey> myjourneys = LogisticCompany.GetInstance().getJourneys().getMyJourneys(controller.getClientid());
            	List<Container> mycontainers = new ArrayList<Container>();
            	for (Journey j : myjourneys) {
            		List<Container> containers = LogisticCompany.GetInstance().getContainers().getMyContainers(j.getID());
            		for(Container c : containers) {
            			mycontainers.add(c);
            		}
            		
            	}
                resultsTable.setModel(new ContainerTable(mycontainers));
            }
        });
    }
	public JTable getResultTable() {
		return resultsTable;
	}


}
