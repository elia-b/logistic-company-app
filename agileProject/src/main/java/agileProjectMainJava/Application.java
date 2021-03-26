package agileProjectMainJava;

public abstract class Application {
	
	private User user;

	public Application(User user) {
		this.user = user;
	}
	
	// methods needed in both the applications (Admin / Client)
}
