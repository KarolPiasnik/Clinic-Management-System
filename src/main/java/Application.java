import base.AdminPanel;
import gui.AppointmentPanel;
import gui.MainPanel;
import gui.PatientAdminPanel;
import gui.WorkerAdminPanel;
import libs.DataBase;


import javax.swing.*;
import java.awt.*;


public class Application {

    public static DataBase database = new DataBase();

    public static void main(String[] args) {

        MainPanel mainPanel = new MainPanel();
        AdminPanel patientPanel = new PatientAdminPanel();
        AdminPanel workerPanel = new WorkerAdminPanel();
        AppointmentPanel appointmentPanel = new AppointmentPanel();


        final JFrame appFrame = new JFrame("Pracownicy");
        appFrame.setPreferredSize(new Dimension(800,640));
        appFrame.setContentPane(workerPanel.getPanelMain());
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
        appFrame.pack();

//        appFrame.setTitle("Pacjenci");
//        appFrame.setContentPane(patientPanel.getPanelMain());
//        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        appFrame.setVisible(true);
//        appFrame.pack();
//
//        appFrame.setTitle("System Zarządzania Kliniką");
//        appFrame.setContentPane(mainPanel.getPanelMain());
//        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        appFrame.setVisible(true);
//        appFrame.pack();
//        appFrame.setTitle("Wizyty");
//        appFrame.setContentPane(appointmentPanel.getPanelMain());
//        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        appFrame.setVisible(true);
//        appFrame.pack();

        workerPanel.fetch();
        workerPanel.updateTable();
        appFrame.pack();
    }
}
