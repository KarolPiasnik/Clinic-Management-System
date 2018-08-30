package gui;

import BaseGui.BaseAdminPanelImpl;
import com.mongodb.*;
import entities.Patient;
import enums.SexEnum;
import libs.MyValidationLibrary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.ValidationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatientAdminPanel extends BaseAdminPanelImpl {
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private String[] columns =  {"Imię","Nazwisko","Wiek","Pesel","Płeć"};
    DB database;
    MongoClient mongoClient;
    DBCollection collection;

    public PatientAdminPanel(){
        super();
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        resultTable.setModel(model);
    }

    public void fetchPatients(){
        patients = new ArrayList<Patient>();
        DBCursor cursor = collection.find();
        Patient patient = null;
        for(DBObject dbPatient : cursor) {
            patient = new Patient(dbPatient);
            patients.add(patient);
        }
    }

    @Override
    public void updateTable() {
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for(Patient patient : patients){
            model.addRow(new Object[]{patient.getName(), patient.getSurname(), patient.getAge(), patient.getPesel(), patient.getSex()});
        }
        resultTable.setModel(model);
    }

    @Override
    public void deleteSelected(){
        ArrayList<String> idsToDelete = new ArrayList<String>();
        for(int index : resultTable.getSelectedRows()){
            collection.remove((patients.get(index)).toDBObject());
        }
        fetchPatients();
        updateTable();

    }

    @Override
    public void deleteAll(){
        for(Patient patient : patients){
            collection.remove(patient.toDBObject());
        }
        fetchPatients();
        updateTable();
    }

    @Override
    public void saveChanges(){
        TableModel model = resultTable.getModel();

        Patient[] patientsToSave = new Patient[patients.size()];
        for(int i = 0; i < patients.size(); ++i){
            patientsToSave[i] = patients.get(i);
        }

        for(int i = 0; i < model.getRowCount(); ++i){
            patientsToSave[i] = new Patient();
            patientsToSave[i].setId(this.patients.get(i).getId());
            patientsToSave[i].setName((model.getValueAt(i, 0).toString()));
            patientsToSave[i].setSurname((model.getValueAt(i, 1).toString()));
            patientsToSave[i].setAge(Integer.parseInt(model.getValueAt(i, 2).toString()));
            patientsToSave[i].setPesel(model.getValueAt(i, 3).toString());
            if(model.getValueAt(i, 4).toString() == "Mężczyzna"){
                patientsToSave[i].setSex(SexEnum.MALE);
            }
            else {
                patientsToSave[i].setSex(SexEnum.FEMALE);
            }
        }
        for(Patient patient : patientsToSave){
            collection.save(patient.toDBObject());
            System.out.print(patient.getId());
        }
        fetchPatients();
        updateTable();
    }

    public void closeDatabaseConnection(){
        mongoClient.close();
    }

    public void openDatabaseConnection(){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        database = mongoClient.getDB("ClientManagementSystem");
        collection = database.getCollection("patients");
    }

    @Override
    public void addNew(){
        boolean ended = false;
        while(!ended) {
            ButtonGroup group = new ButtonGroup();
            JTextField nameField = new JTextField(5);
            JTextField surnameField = new JTextField(5);
            JTextField ageField = new JTextField(5);
            JTextField peselField = new JTextField(5);
            final JRadioButton femaleButton = new JRadioButton(SexEnum.FEMALE.name());
            final JRadioButton maleButton = new JRadioButton(SexEnum.MALE.name());

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Imię:"));
            myPanel.add(nameField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Nazwisko:"));
            myPanel.add(surnameField);
            myPanel.add(new JLabel("PESEL:"));
            myPanel.add(peselField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Wiek:"));
            myPanel.add(ageField);
            femaleButton.setSelected(true);
            femaleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    maleButton.setSelected(false);
                }
            });
            maleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    femaleButton.setSelected(false);
                }
            });
            myPanel.add(femaleButton);
            myPanel.add(maleButton);


            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION){
                ended = true;
            }
            if (result == JOptionPane.OK_OPTION) {
                if (MyValidationLibrary.isValidPesel(peselField.getText()) && MyValidationLibrary.isValidAge(ageField.getText())){
                    Patient patient;
                    if (femaleButton.isSelected()) {
                        patient = new Patient(nameField.getText(), surnameField.getText(), peselField.getText(), Integer.parseInt(ageField.getText()), SexEnum.FEMALE);
                    } else {
                        patient = new Patient(nameField.getText(), surnameField.getText(), peselField.getText(), Integer.parseInt(ageField.getText()), SexEnum.MALE);
                    }
                    collection.insert(patient.toDBObject());
                    fetchPatients();
                    updateTable();
                    ended = true;
                }
                else {
                    JOptionPane.showMessageDialog(null, "PESEL lub wiek niepoprawny");
                }
            }

        }
    }

}
