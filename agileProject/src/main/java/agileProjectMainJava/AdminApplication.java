package agileProjectMainJava;

public class AdminApplication extends Application{
	
	private LogisticCompany lc;
	
	public AdminApplication(LogisticCompany lc) {
		super(lc);
		this.lc = lc;
	}
	
	public void register_new_client(Client c1) {
        //maybe return a boolean as registerState
        if (lc.getCic().checkAllInfo(c1)) {
                lc.getClients().add(c1);
                c1.register();
                
            }
        else{
            //Throw an invalid client info
        }
    }
	
	
	public Client search(String s) {
		Client c = new Client();
		return c;
	}

}
