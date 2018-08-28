package gui;

import BaseGui.BaseAdminPanelImpl;
import com.mongodb.DBObject;
import entities.Patient;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PatientAdminPanel extends BaseAdminPanelImpl {
    private List<Patient> patients;
    private String[] columns =  {"Imię","Nazwisko","Wiek","Pesel","Płeć"};

    public PatientAdminPanel(){
        super();
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        resultTable.setModel(model);
    }

    public void updatePatients(List<Patient> patients){
        this.patients = patients;
    }

    @Override
    public void updateTable() {
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for(Patient patient : patients){
            model.addRow(new Object[]{patient.getName(), patient.getSurname(), patient.getAge(), patient.getPesel(), patient.getSex().name()});
        }
        resultTable.setModel(model);
    }
}
