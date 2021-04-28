package application.model.tablemodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import application.model.Client;

public class ClientTable extends AbstractTableModel {
	int size;
	List<Client> clients;
	
	public ClientTable(List<Client> clients) {
		size = clients.size();
		this.clients = clients;
	}
	
	
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return clients.get(rowIndex).getName();
		} else if (columnIndex == 1) {
			return clients.get(rowIndex).getEmail();
		}else if (columnIndex == 2) {
			return clients.get(rowIndex).getAddress();
		}else if (columnIndex == 3) {
			return clients.get(rowIndex).getReferencePerson();
		}else if (columnIndex == 4) {
			return clients.get(rowIndex).getID();
		}
		return null;
	}
	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Name";
		} else if (columnIndex == 1) {
			return "Email";
		}else if (columnIndex == 2) {
			return "Address";
		}else if (columnIndex == 3) {
			return "Contact Person";
		}else if (columnIndex == 4) {
			return "ID";
		}
		return null;
	}

}
