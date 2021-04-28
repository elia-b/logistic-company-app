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
	
	public ContainerTable(List<Container> containers) {
		size = containers.size();
		this.containers = containers;
	}
	
	
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
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
