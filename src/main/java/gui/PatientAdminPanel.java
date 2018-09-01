package gui;


public class PatientAdminPanel extends PersonAdminPanel {


    public PatientAdminPanel() {
        super();
        collection = dataBase.getPatients();
    }
}
