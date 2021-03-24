package agileProjectMainJava;

import java.util.HashSet;
import java.util.Set;

// Create an interface for any logistic company
public class LogisticCompany {
    Set<Client> clients = new HashSet<Client>();

    public void register_new_client(Client c1) {
        //maybe return a boolean as registerState
        if (this.checkNameValid(c1) &&
            this.checkEmailValid(c1) &&
            this.checkAddressValid(c1) &&
            this.checkReferencePersonValid(c1)
            ) {
                clients.add(c1);
                c1.register();
            }
        else{
            //Trow an invalid client info
        }
    }

    public int numberOfClients(){
        return clients.size();
    }

    private boolean checkReferencePersonValid(Client c1) {
        // further implementation can be done
        String rp = c1.getReferencePerson();
        return true;
    }

    private boolean checkEmailValid(Client c1) {
        String email = c1.getEmail();
        // Check whether a @ is there and if it is not already taken
        return true;
    }

    private boolean checkAddressValid(Client c1) {
        String address = c1.getAddress();
         // check that it is in the format Street Number City
        return true;
    }

    private boolean checkNameValid(Client c1) {
        String name = c1.getName();
        // check that the name is unique and not already taken
        return true;
    }
}
