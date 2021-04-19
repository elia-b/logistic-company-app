package application.utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LocationPicker extends JPanel {
	
	// The font should be changed
	private JLabel y = new JLabel("LOCATION");
	private JComboBox combo = new JComboBox();
	

    public LocationPicker() {
    	this.setPreferredSize(new Dimension(450,75));
        setLayout(new FlowLayout());
    	add(y);
    	add(combo);
    }

    public void updateCombo(ArrayList<String> locations){
        combo.removeAllItems();
        for(String l : locations) {
    		combo.addItem(l);
    	}
    }

    public String getSelectedLocation(){
        return (String) combo.getSelectedItem();
    }

}
