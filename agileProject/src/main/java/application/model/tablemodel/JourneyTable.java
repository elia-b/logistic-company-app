package application.model.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import application.model.Journey;

public class JourneyTable extends AbstractTableModel {
	int size;
	List<Journey> journeys;
	
	public JourneyTable(List<Journey> journeys) {
		size = journeys.size();
		this.journeys = journeys;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
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
