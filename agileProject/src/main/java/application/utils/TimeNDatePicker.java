package application.utils;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class TimeNDatePicker extends JPanel{
	
	// The font should be changed
	private JLabel y = new JLabel("YEAR");
	private JComboBox comboBoxYear = new JComboBox();
	private JLabel m = new JLabel("MONTH");
	private JComboBox comboBoxMonth = new JComboBox();
	private JLabel d = new JLabel("DAY");
	private JComboBox comboBoxDay = new JComboBox();
	private JLabel min = new JLabel("MIN");
	private JComboBox comboBoxMinute = new JComboBox();
	private JLabel h = new JLabel("HOUR");
	private JComboBox comboBoxHours = new JComboBox();
	private boolean leapYear = false;

    public TimeNDatePicker() {
    	this.setPreferredSize(new Dimension(430, 30));
        setLayout(new FlowLayout());
        this.add(y);
        this.add(comboBoxYear);
        this.add(m);
        this.add(comboBoxMonth);
        this.add(d);
        this.add(comboBoxDay);
        this.add(h);
        this.add(comboBoxHours);
        this.add(min);
        this.add(comboBoxMinute);
        yearInitialise();
        monthInitialise();
        dayInitialise();
        minutesInitialise();
        hoursInitialise();

        comboBoxYear.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	leapYearChange();
            	dayCompute();
            }
        });
        comboBoxMonth.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	dayCompute();
            }
        });
    }
    
    private void yearInitialise() {
    	int[] years = { 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019,
		   		   2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029,
				   2030, 2031, 2032, 2033, 2034, 2035, 2036, 2037, 2038, 2039};
    	for (int year : years) {
    		comboBoxYear.addItem(year);
    	}
    }
    
    private void monthInitialise() {
    	int[] months = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    	for (int month : months) {
    		comboBoxMonth.addItem(month);
    	}
    }
    
    private void dayInitialise() {
    	
    }
    
    private void dayCompute() {
    	comboBoxDay.removeAllItems();
    	int[] month28 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
    	int[] month29 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    	int[] month30 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    	int[] month31 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    	if (!leapYear && (Integer)comboBoxMonth.getSelectedItem() == 2) {
    		for (int day : month28) {
        		comboBoxDay.addItem(day);
        	}
    	} else if (leapYear && (Integer)comboBoxMonth.getSelectedItem() == 2){
    		for (int day : month29) {
        		comboBoxDay.addItem(day);
        	}
    	} else if ((Integer)comboBoxMonth.getSelectedItem() == 4 ||
    			   (Integer)comboBoxMonth.getSelectedItem() == 6 || 
    			   (Integer)comboBoxMonth.getSelectedItem() == 9 || 
    			   (Integer)comboBoxMonth.getSelectedItem() == 11 ){
    		for (int day : month30) {
    			comboBoxDay.addItem(day);
        	}
    	} else {
    		for (int day : month31) {
    			comboBoxDay.addItem(day);
        	}
    	}
    }
    
    private void minutesInitialise() {
    	int[] minutes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
    		           31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
    	for (int minute : minutes) {
    		comboBoxMinute.addItem(minute);
    	}
    }
    
    private void hoursInitialise() {
    	int[] hours = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
    	for (int hour : hours) {
    		comboBoxHours.addItem(hour);
    	}
    }
    
    private void leapYearChange() {
    	if (((Integer) comboBoxYear.getSelectedItem() - 2000) % 4 == 0) {
    		leapYear = true;
    	}
    	else {
    		leapYear = false;
    	}
    }
    
    public long getDate() {
    	Calendar c = Calendar.getInstance();
    	c.set((Integer) comboBoxYear.getSelectedItem(), (Integer) comboBoxMonth.getSelectedItem() - 1, (Integer) comboBoxDay.getSelectedItem(), 
    		  (Integer)comboBoxHours.getSelectedItem(), (Integer)comboBoxMinute.getSelectedItem());
    	return c.getTime().getTime();
    }

}