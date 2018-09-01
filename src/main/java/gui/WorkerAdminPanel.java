package gui;


import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import entities.Person;
import entities.Worker;
import entities.Worker;
import enums.SexEnum;
import enums.WorkerFunctionEnum;
import libs.MyValidationLibrary;
import sun.java2d.opengl.WGLSurfaceData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorkerAdminPanel extends PersonAdminPanel {
    protected JTextField scientificTitleField;
    protected JTextField functionField;
    protected JTextField salaryField;

    ArrayList<Worker> workers = new ArrayList<Worker>();
    String[] columns = {"Imię", "Nazwisko", "Wiek", "Pesel", "Płeć", "Tytuł naukowy", "Funkcja", "Pensja"};

    public WorkerAdminPanel() {
        super();
        scientificTitleField = new JTextField("",5);
        functionField = new JTextField("",5);
        salaryField = new JTextField("",5);

        searchPanel.add(new JLabel("Tytuł naukowy"));
        searchPanel.add(scientificTitleField);
        searchPanel.add(new JLabel("Funkcja"));
        searchPanel.add(functionField);
        searchPanel.add(new JLabel("Pensja"));
        searchPanel.add(salaryField);

        collection = dataBase.getWorkers();
    }

    public void fetch() {
        workers = new ArrayList<Worker>();
        DBCursor cursor = collection.find();
        Worker worker = null;
        for (DBObject dbWorker : cursor) {
            System.out.println(cursor.size());
            worker = new Worker(dbWorker);
            workers.add(worker);
        }
    }

    @Override
    public void updateTable() {
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Worker worker : workers) {
            model.addRow(new Object[]{worker.getName(), worker.getSurname(), worker.getAge(), worker.getPesel(), worker.getSex(), worker.getScientificTitle(), worker.getFunction(), worker.getSalary()});
        }
        resultTable.setModel(model);
    }

    @Override
    public void saveChanges() {
        TableModel model = resultTable.getModel();

        Worker[] workersToSave = new Worker[workers.size()];
        for (int i = 0; i < workers.size(); ++i) {
            workersToSave[i] = workers.get(i);
        }

        for (int i = 0; i < model.getRowCount(); ++i) {
            workersToSave[i] = new Worker();
            workersToSave[i].setId(this.workers.get(i).getId());
            workersToSave[i].setName((model.getValueAt(i, 0).toString()));
            workersToSave[i].setSurname((model.getValueAt(i, 1).toString()));
            workersToSave[i].setAge(Integer.parseInt(model.getValueAt(i, 2).toString()));
            workersToSave[i].setPesel(model.getValueAt(i, 3).toString());
            if (model.getValueAt(i, 4).toString() == "Mężczyzna") {
                workersToSave[i].setSex(SexEnum.MALE);
            } else {
                workersToSave[i].setSex(SexEnum.FEMALE);
            }
            workersToSave[i].setScientificTitle(model.getValueAt(i, 5).toString());
            if (model.getValueAt(i, 6).toString() == "Terapeuta") {
                workersToSave[i].setFunction(WorkerFunctionEnum.THERAPIST);
            }
            else{
                workersToSave[i].setFunction(WorkerFunctionEnum.DOCTOR);
            }
            workersToSave[i].setSalary(Double.parseDouble(model.getValueAt(i, 7).toString()));
        }
        for (Worker worker : workersToSave) {
            collection.save(worker.toDBObject());
            System.out.print(worker.getId());
        }
        refresh();
    }

    @Override
    public void deleteSelected() {
        for (int index : resultTable.getSelectedRows()) {
            collection.remove((workers.get(index)).toDBObject());
        }
        refresh();


    }

    @Override
    public void deleteAll() {
        for (Worker worker : workers) {
            collection.remove(worker.toDBObject());
        }
        refresh();
    }
    
    @Override
    public void refresh() {
        fetch();
        updateTable();
    }

    @Override
    public void addNew() {
        boolean ended = false;
        while (!ended) {
            ButtonGroup group = new ButtonGroup();
            JTextField nameField = new JTextField(5);
            JTextField surnameField = new JTextField(5);
            JTextField ageField = new JTextField(5);
            JTextField peselField = new JTextField(5);
            JTextField scientificTitleField = new JTextField(5);
            JTextField salaryField = new JTextField(5);

            final JRadioButton femaleButton = new JRadioButton(SexEnum.FEMALE.name());
            final JRadioButton maleButton = new JRadioButton(SexEnum.MALE.name());
            final JRadioButton therapistButton = new JRadioButton(WorkerFunctionEnum.THERAPIST.name());
            final JRadioButton doctorButton = new JRadioButton(WorkerFunctionEnum.DOCTOR.name());

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
            myPanel.add(new JLabel("Tytuł naukowy:"));
            myPanel.add(scientificTitleField);
            myPanel.add(new JLabel("Funkcja:"));
            therapistButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    doctorButton.setSelected(false);
                }
            });
            doctorButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    therapistButton.setSelected(false);
                }
            });
            myPanel.add(therapistButton);
            myPanel.add(doctorButton);
            myPanel.add(new JLabel("Pensja:"));
            myPanel.add(salaryField);



            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Wpisz dane nowego pacjenta", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
                ended = true;
            }
            if (result == JOptionPane.OK_OPTION) {
                if (MyValidationLibrary.isValidPesel(peselField.getText()) && MyValidationLibrary.isValidAge(ageField.getText())) {
                    Worker worker = new Worker();
                    worker.setName(nameField.getText());
                    worker.setSurname(surnameField.getText());
                    worker.setPesel(peselField.getText());
                    worker.setAge(Integer.parseInt(ageField.getText()));

                    if (femaleButton.isSelected()) {
                        worker.setSex(SexEnum.FEMALE);
                    } else {
                        worker.setSex(SexEnum.MALE);
                    }
                    if (therapistButton.isSelected()) {
                        worker.setFunction(WorkerFunctionEnum.THERAPIST);
                    } else {
                        worker.setFunction(WorkerFunctionEnum.DOCTOR);
                    }
                    worker.setScientificTitle(scientificTitleField.getText());
                    worker.setSalary(Double.parseDouble(salaryField.getText()));

                    collection.insert(worker.toDBObject());
                    refresh();
                    ended = true;
                } else {
                    JOptionPane.showMessageDialog(null, "PESEL lub wiek niepoprawny");
                }
            }

        }
    }


    @Override
    public void search() {
        Worker modelWorker = new Worker();
        if (nameField.getText().length() != 0) {
            modelWorker.setName(nameField.getText());
        }
        if (surnameField.getText().length() != 0) {
            modelWorker.setSurname(surnameField.getText());
        }
        if (ageField.getText().length() != 0 && MyValidationLibrary.isValidAge(ageField.getText())) {
            modelWorker.setAge(Integer.parseInt(ageField.getText()));
        } else {
            ageField.setText("");

        }
        if (peselField.getText().length() != 0 && MyValidationLibrary.isValidPesel(peselField.getText())) {
            modelWorker.setPesel(peselField.getText());
        } else {
            peselField.setText("");
        }

        workers = new ArrayList<Worker>();
        Worker worker;
        DBCursor foundWorkers = collection.find(modelWorker.toDBObject());
        for (DBObject dbWorker : foundWorkers) {
            worker = new Worker(dbWorker);
            workers.add(worker);
        }
        updateTable();
    }
}
