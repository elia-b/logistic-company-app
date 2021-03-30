package agileProjectMainJava;

public class AdminApplication {
	
	private LogisticCompany lc;
	
	public AdminApplication(LogisticCompany lc) {
		this.lc = lc;
	}
	
	public void register_new_client(Client c1) {
        //maybe return a boolean as registerState
        if (lc.getCic().checkAllInfo(c1)) {
                lc.getDatabase().registerClient(c1);;
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
