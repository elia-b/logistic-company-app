package application.model;

public class UsageReport {
	private ClientReport clientReport = new ClientReport();
	private AdminReport adminReport = new AdminReport();
	
	public ClientReport getClientReport() {
		return clientReport;
	}
	public AdminReport getAdminReport() {
		return adminReport;
	}
	
	
}
