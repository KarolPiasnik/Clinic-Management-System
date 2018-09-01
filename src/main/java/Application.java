import gui.PatientAdminPanel;


import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Application {

    public static void main(String[] args) {


        PatientAdminPanel app = new PatientAdminPanel();
        final JFrame patientsFrame = new JFrame("App");
        patientsFrame.setContentPane(app.getPanelMain());
        patientsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientsFrame.setVisible(true);
        patientsFrame.pack();
//        patientsFrame.addWindowListener(new WindowListener() {
//            public void windowOpened(WindowEvent e) {
//                patientsFrame.setDatabaseConnection();
//            }
//
//            public void windowClosing(WindowEvent e) {
//                patientsFrame.close();
//
//            }
//        });
//
        app.openDatabaseConnection();
        app.fetchPersons();
        app.updateTable();
        patientsFrame.pack();
    }
}
