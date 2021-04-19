package application.utils;

import javax.swing.JFrame;

import application.model.LogisticCompany;

public class TestComponents {
    public static void main(String main[]){
        //Create Frame
        JFrame frmMainMenu = new JFrame();

        //Size Frame
        frmMainMenu.setSize(450,75);

        //Add Components
        
        /* LocationPicker obj1 = LogisticCompany.GetInstance().getLocationDatabase().getLocationPicker();
        frmMainMenu.add(obj1); */
        TimeNDatePicker obj2 = new TimeNDatePicker();
        frmMainMenu.add(obj2);
        frmMainMenu.pack();
        frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display Frame
        frmMainMenu.setVisible(true);
    }
}
