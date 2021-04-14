package application.model;

public class ClientReport {
	private int clientapp = 0;
	private int registerjourney = 0;
	private int filterJourneysbyContent = 0;
	private int filterJourneysbyOrigin = 0;
	private int filterJourneysbyDestination = 0;
	private int getClosestStatus = 0;
	private int getLatestStatus = 0;
	private int updateAdress = 0;
	private int updateContactPerson = 0;
	private int updateEmail = 0;
	private int updateName = 0; 
	private int updatePassword = 0;
	 
	public void increaseClientapp() {
		this.clientapp++;
	}
	public void increaseRegisterjourney() {
		this.registerjourney++;
	}
	public void increaseFilterJourneysbyContent() {
		this.filterJourneysbyContent++;
	}
	public void increaseFilterJourneysbyOrigin() {
		this.filterJourneysbyOrigin++;
	}
	public void increaseFilterJourneysbyDestination() {
		this.filterJourneysbyDestination++;
	}
	public void increaseGetClosestStatus() {
		this.getClosestStatus++;	}
	public void increaseGetLatestStatus() {
		this.getLatestStatus++;
	}
	public void increaseUpdateAdress() {
		this.updateAdress++;
	}
	public void increaseUpdateContactPerson() {
		this.updateContactPerson++;
	}
	public void increaseUpdateEmail() {
		this.updateEmail++;
	}
	public void increaseUpdateName() {
		this.updateName++;
	}
	public void increaseUpdatePassword() {
		this.updatePassword++;
	}
	public int getClientapp() {
		return clientapp;
	}
	public int getRegisterjourney() {
		return registerjourney;
	}
	public int getFilterJourneysbyContent() {
		return filterJourneysbyContent;
	}
	public int getFilterJourneysbyOrigin() {
		return filterJourneysbyOrigin;
	}
	public int getFilterJourneysbyDestination() {
		return filterJourneysbyDestination;
	}
	public int getGetClosestStatus() {
		return getClosestStatus;
	}
	public int getGetLatestStatus() {
		return getLatestStatus;
	}
	public int getUpdateAdress() {
		return updateAdress;
	}
	public int getUpdateContactPerson() {
		return updateContactPerson;
	}
	public int getUpdateEmail() {
		return updateEmail;
	}
	public int getUpdateName() {
		return updateName;
	}
	public int getUpdatePassword() {
		return updatePassword;
	}
	
	
}
