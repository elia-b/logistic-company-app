package application.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import application.controller.AdminController;
import application.model.Client;
import application.model.Container;
import application.model.Journey;
import application.model.LogisticCompany;
import application.model.tablemodel.ClientTable;
import application.model.tablemodel.ContainerTable;
import application.model.tablemodel.JourneyTable;


public class AdminApplicationView extends JFrame{
	private AdminController controller;

	
	private  JPanel mainPanel;
    private  JPanel navigationPanel;
    private  JPanel toolsPanel;
    private  JLabel usernameLabel;
    private  JLabel adminTerminalLabel;
    private  JPanel filterPanel;
    private  JPanel controlPanel;
    private  JPanel tablePanel;
    private  JButton filterByNameButton;
    private  JButton filterByEmailButton;
    private  JButton resetFilterButton;
    private  JButton logOutButton;
    private  JButton registerNewClientButton;
    private  JButton registerNewContainerButton;
    private  JButton updateContainerStatusButton;
    private  JButton updateJourneyButton;
    private  JButton finishJourneyButton;
    private  JButton addLocationButton;
    private  JButton containerStatusHistoryButton;
    private  JButton containerJourneyHistoryButton;
    private  JButton containerJourneyStatusHistoryButton;
    private  JButton allContainersButton;
    private  JButton allJourneysButton;
    private  JPanel textPanel;
    private  JTable resultsTable;
	
	
    public JTable getResultsTable() {
		return resultsTable;
	}
    



	public void setResultsTable(JTable resultsTable) {
		this.resultsTable = resultsTable;
	}




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
	public void setTableModel(TableModel model) {
		resultsTable.setModel(model);
	}
	
	private void initGUI() {
		mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        navigationPanel = new JPanel();
        navigationPanel.setLayout(new BorderLayout());
        navigationPanel.setPreferredSize(new Dimension(200, 66));
        mainPanel.add(navigationPanel, BorderLayout.WEST);
        logOutButton = new JButton();
        logOutButton.setText("Log Out");
        navigationPanel.add(logOutButton, BorderLayout.SOUTH);
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout(0, 2));
        navigationPanel.add(textPanel, BorderLayout.NORTH);
        textPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(5, 12, 5, 0)));
        usernameLabel = new JLabel();
        String username = LogisticCompany.GetInstance().getName();
        usernameLabel.setText("<html>" + "<B>" + "Company: "+ username + "</B>" + "</html>");
        textPanel.add(usernameLabel, BorderLayout.NORTH);
        adminTerminalLabel = new JLabel();
        adminTerminalLabel.setText("<html>" + "<I>" + "Admin Terminal" + "</I>" + "</html>");
        textPanel.add(adminTerminalLabel, BorderLayout.SOUTH);
        toolsPanel = new JPanel();
        toolsPanel.setLayout(new BorderLayout());
        toolsPanel.setPreferredSize(new Dimension(840, 600));
        mainPanel.add(toolsPanel, BorderLayout.CENTER);
        toolsPanel.setBorder(BorderFactory.createTitledBorder("Client Management Tools"));
        filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        toolsPanel.add(filterPanel, BorderLayout.NORTH);
        filterByNameButton = new JButton();
        filterByNameButton.setText("Filter by Name");
        filterByNameButton.setToolTipText("Filter clients by name");
        filterPanel.add(filterByNameButton);
        filterByEmailButton = new JButton();
        filterByEmailButton.setText("Filter by Email");
        filterByEmailButton.setToolTipText("Filter clients by email address");
        filterPanel.add(filterByEmailButton);
        resetFilterButton = new JButton();
        resetFilterButton.setText("Reset Filter");
        resetFilterButton.setToolTipText("Reset client search filter");
        filterPanel.add(resetFilterButton);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        controlPanel.setPreferredSize(new Dimension(860, 72));
        toolsPanel.add(controlPanel, BorderLayout.SOUTH);
        registerNewClientButton = new JButton();
        registerNewClientButton.setText("New Client");
        registerNewClientButton.setToolTipText("Register a new client");
        controlPanel.add(registerNewClientButton);
        registerNewContainerButton = new JButton();
        registerNewContainerButton.setText("New Container");
        registerNewContainerButton.setToolTipText("Register a new shipping container");
        controlPanel.add(registerNewContainerButton);
        updateContainerStatusButton = new JButton();
        updateContainerStatusButton.setText("Update Container Status");
        updateContainerStatusButton.setToolTipText("Update status of a shipping container");
        controlPanel.add(updateContainerStatusButton);
        updateJourneyButton = new JButton();
        updateJourneyButton.setText("Update Journey");
        updateJourneyButton.setToolTipText("Update location of all containers on a journey");
        controlPanel.add(updateJourneyButton);
        finishJourneyButton = new JButton();
        finishJourneyButton.setText("Finish Journey");
        finishJourneyButton.setToolTipText("Mark all containers on a journey as empty");
        controlPanel.add(finishJourneyButton);
        addLocationButton = new JButton();
        addLocationButton.setText("New Port");
        addLocationButton.setToolTipText("Add a new shipping port option");
        controlPanel.add(addLocationButton);
        containerStatusHistoryButton = new JButton();
        containerStatusHistoryButton.setText("Container Status History");
        containerStatusHistoryButton.setToolTipText("View the status history of a shipping container");
        controlPanel.add(containerStatusHistoryButton);
        containerJourneyHistoryButton = new JButton();
        containerJourneyHistoryButton.setText("Container Journey History");
        containerJourneyHistoryButton.setToolTipText("View the journey history of a shipping container");
        controlPanel.add(containerJourneyHistoryButton);
        containerJourneyStatusHistoryButton = new JButton();
        containerJourneyStatusHistoryButton.setText("Container Journey Status History");
        containerJourneyStatusHistoryButton.setToolTipText("View the status history of a shipping container on a particular journey");
        controlPanel.add(containerJourneyStatusHistoryButton);
        
        allContainersButton = new JButton();
        allContainersButton.setText("All Containers");
        allContainersButton.setToolTipText("View all the registered containers");
        controlPanel.add(allContainersButton);
        
        allJourneysButton = new JButton();
        allJourneysButton.setText("All Journeys");
        allJourneysButton.setToolTipText("View all the registered journeys");
        controlPanel.add(allJourneysButton);
        
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        toolsPanel.add(tablePanel, BorderLayout.CENTER);
        tablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        final JScrollPane tableScrollPane = new JScrollPane();
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
        
        resultsTable = new JTable();
        List<Client> clients = LogisticCompany.GetInstance().getClientDatabase().getAll();
        resultsTable.setModel(new ClientTable(clients));
        tableScrollPane.setViewportView(resultsTable);
        resultsTable.getTableHeader().setBackground(Color.white);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();
        

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.logOut();
            }
        });
        filterByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.searchName();
            }
        });
        filterByEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.searchEmail();

            }
        });
        resetFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 List<Client> clients = LogisticCompany.GetInstance().getClientDatabase().getAll();
                 resultsTable.setModel(new ClientTable(clients));
            	
            }

        });
        registerNewClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.registerClient();

            }
        });
        registerNewContainerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.registerContainer();
            }
        });
        updateContainerStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.updateStatus();
            }
        });
        finishJourneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.finishJourney();
            }
        });
        addLocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.addNewLocation();
            }
        });
        updateJourneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.updateJourney();
            }
        });
        containerStatusHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.getContainerHistory();
            }
        });
        containerJourneyHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.getJourneysOfContainer();
            }
        });
        containerJourneyStatusHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.getContainerHistoryfromJourney();
            }
        });
        allContainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           	 List<Container> containers = LogisticCompany.GetInstance().getContainers().getAll();
                resultsTable.setModel(new ContainerTable(containers));
           	
           }
        });
        allJourneysButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           	 List<Journey> journeys = LogisticCompany.GetInstance().getJourneys().getAll();
                resultsTable.setModel(new JourneyTable(journeys));
           	
           }
        });
    }
	
	
}
