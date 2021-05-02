package application.model.tablemodel;

import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import application.model.ContainerStatus;

public class ContainerStatusTable extends AbstractTableModel {
	int size;
	List<ContainerStatus> cslist;
	// constructor for initialise the containerStatus
	public ContainerStatusTable(List<ContainerStatus> cslist) {
		// number of the containerStatus
		size = cslist.size();
		// initialise the container status in the list
		this.cslist = cslist;
	}
	
	
	

	@Override
	public int getRowCount() {
		// initialise the number of row with size 
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getColumnCount() {
		// 7 column for getID, getjourneyId, getContainerID, getPressure,getTemperature,getHumidity,getDate
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//get the below value  with columnIndex
		if (columnIndex == 0) {
			return cslist.get(rowIndex).getID();
		} else if (columnIndex == 1) {
			return cslist.get(rowIndex).getJourneyId();
		}else if (columnIndex == 2) {
			return cslist.get(rowIndex).getContainerId();
		}else if (columnIndex == 3) {
			return cslist.get(rowIndex).getPressure();
		}else if (columnIndex == 4) {
			return cslist.get(rowIndex).getTemperature();
		}else if (columnIndex == 5) {
			return cslist.get(rowIndex).getHumidity();
		}else if (columnIndex == 6) {
			// get the date 
			long date = cslist.get(rowIndex).getDate();
			Date d = new Date(date);
			return d.toString();
		}
		return null;
	}
	@Override
	// initialise the columnName
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Container Status ID";
		} else if (columnIndex == 1) {
			return "Journey ID";
		}else if (columnIndex == 2) {
			return "Container ID";
		}else if (columnIndex == 3) {
			return "Pressure";
		}else if (columnIndex == 4) {
			return "Temperature";
		}else if (columnIndex == 5) {
			return "Humidity";
		}else if (columnIndex == 6) {
			return "Date";
		}
		return null;
	}

}
