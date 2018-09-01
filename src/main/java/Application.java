import base.AdminPanel;
import gui.AppointmentPanel;
import gui.MainPanel;
import gui.PatientAdminPanel;
import gui.WorkerAdminPanel;
import libs.DataBase;


import javax.swing.*;


public class Application {

    public static DataBase database = new DataBase();

    public static void main(String[] args) {

        MainPanel mainPanel = new MainPanel();
        AdminPanel patientPanel = new PatientAdminPanel();
        AdminPanel workerPanel = new WorkerAdminPanel();
        AppointmentPanel appointmentPanel = new AppointmentPanel();


        final JFrame patientFrame = new JFrame("App");
        patientFrame.setContentPane(patientPanel.getPanelMain());
        patientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientFrame.setVisible(true);
        patientFrame.pack();
        final JFrame workerFrame = new JFrame("App");
        workerFrame.setContentPane(workerPanel.getPanelMain());
        workerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        workerFrame.setVisible(true);
        patientFrame.pack();
        final JFrame mainFrame = new JFrame("App");
        mainFrame.setContentPane(mainPanel.getPanelMain());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.pack();
        final JFrame appointmentFrame = new JFrame("App");
        appointmentFrame.setContentPane(appointmentPanel.getPanelMain());
        appointmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appointmentFrame.setVisible(true);
        appointmentFrame.pack();

        patientPanel.openDatabaseConnection();
        patientPanel.fetch();
        patientPanel.updateTable();
        patientFrame.pack();
    }
}
