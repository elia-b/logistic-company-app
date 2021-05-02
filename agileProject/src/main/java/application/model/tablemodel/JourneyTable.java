package application.model.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import application.model.Journey;

public class JourneyTable extends AbstractTableModel {
	int size;
	List<Journey> journeys;
	// constructor for initialise journeys
	public JourneyTable(List<Journey> journeys) {
		// number of the journeys
		size = journeys.size();
		// initialise the journey in the list
		this.journeys = journeys;
	}


	@Override
	public int getRowCount() {
		// initialise the number of row with size 
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getColumnCount() {
		// 7 column for getID,getClientid,getOrigin,getDestination,getContent,getNOfContainers
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//get the below value  with columnIndex
		if (columnIndex == 0) {
			return journeys.get(rowIndex).getID();
		} else if (columnIndex == 1) {
			return journeys.get(rowIndex).getClientid();
		}else if (columnIndex == 2) {
			return journeys.get(rowIndex).getOrigin();
		}else if (columnIndex == 3) {
			return journeys.get(rowIndex).getDestination();
		}else if (columnIndex == 4) {
			return journeys.get(rowIndex).getContent();
		}else if (columnIndex == 5) {
			return journeys.get(rowIndex).getNOfContainers();
		}
		return null;
	}
	@Override
	public String getColumnName(int columnIndex) {
		// initialise the columnName
		if (columnIndex == 0) {
			return "Journey ID";
		} else if (columnIndex == 1) {
			return "Client ID";
		}else if (columnIndex == 2) {
			return "Origin";
		}else if (columnIndex == 3) {
			return "Destination";
		}else if (columnIndex == 4) {
			return "Content";
		}else if (columnIndex == 5) {
			return "N of Containers";
		}
		return null;
	}

}
