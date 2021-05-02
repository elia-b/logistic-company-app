package application.model.tablemodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import application.model.Client;
import application.model.Container;

public class ContainerTable extends AbstractTableModel {
	int size;
	List<Container> containers;
	// constructor for initialise the container
	public ContainerTable(List<Container> containers) {
		// number of the container
		size = containers.size();
		// initialise the container object in the list
		this.containers = containers;
	}
	
	
	

	@Override
	public int getRowCount() {
		// initialise the number of row with size 
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getColumnCount() {
		//4 column for getID, getjourneyId,getLocation and getContent
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	//get the below value  with columnIndex
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return containers.get(rowIndex).getID();
		} else if (columnIndex == 1) {
			return containers.get(rowIndex).getJourneyID();
		}else if (columnIndex == 2) {
			return containers.get(rowIndex).getLocation();
		}else if (columnIndex == 3) {
			return containers.get(rowIndex).getContent();
		}
		return null;
	}
	@Override
	// Initialise the columnName
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Container ID";
		} else if (columnIndex == 1) {
			return "Journey ID";
		}else if (columnIndex == 2) {
			return "Location";
		}else if (columnIndex == 3) {
			return "Content";
		}
		return null;
	}

}
