package gui;

import base.BaseAdminPanelImpl;
import com.mongodb.*;
import entities.Person;
import enums.SexEnum;
import libs.MyValidationLibrary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class PersonAdminPanel extends BaseAdminPanelImpl {
    private ArrayList<Person> persons = new ArrayList<Person>();
    private String[] columns = {"Imię", "Nazwisko", "Wiek", "Pesel", "Płeć"};
    DB database;
    MongoClient mongoClient;
    DBCollection collection;

    public PersonAdminPanel() {
        super();
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        resultTable.setModel(model);
    }

    public void fetchPersons() {
        persons = new ArrayList<Person>();
        DBCursor cursor = collection.find();
        Person person = null;
        for (DBObject dbPerson : cursor) {
            person = new Person(dbPerson);
            persons.add(person);
        }
    }

    @Override
    public void updateTable() {
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Person person : persons) {
            model.addRow(new Object[]{person.getName(), person.getSurname(), person.getAge(), person.getPesel(), person.getSex()});
        }
        resultTable.setModel(model);
    }

    @Override
    public void deleteSelected() {
        ArrayList<String> idsToDelete = new ArrayList<String>();
        for (int index : resultTable.getSelectedRows()) {
            collection.remove((persons.get(index)).toDBObject());
        }
        refresh();


    }

    @Override
    public void deleteAll() {
        for (Person person : persons) {
            collection.remove(person.toDBObject());
        }
        refresh();

    }

    @Override
    public void saveChanges() {
        TableModel model = resultTable.getModel();

        Person[] personsToSave = new Person[persons.size()];
        for (int i = 0; i < persons.size(); ++i) {
            personsToSave[i] = persons.get(i);
        }

        for (int i = 0; i < model.getRowCount(); ++i) {
            personsToSave[i] = new Person();
            personsToSave[i].setId(this.persons.get(i).getId());
            personsToSave[i].setName((model.getValueAt(i, 0).toString()));
            personsToSave[i].setSurname((model.getValueAt(i, 1).toString()));
            personsToSave[i].setAge(Integer.parseInt(model.getValueAt(i, 2).toString()));
            personsToSave[i].setPesel(model.getValueAt(i, 3).toString());
            if (model.getValueAt(i, 4).toString() == "Mężczyzna") {
                personsToSave[i].setSex(SexEnum.MALE);
            } else {
                personsToSave[i].setSex(SexEnum.FEMALE);
            }
        }
        for (Person person : personsToSave) {
            collection.save(person.toDBObject());
            System.out.print(person.getId());
        }
        refresh();

    }

    public void closeDatabaseConnection() {
        mongoClient.close();
    }

    public void openDatabaseConnection() {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        database = mongoClient.getDB("ClientManagementSystem");
        collection = database.getCollection("persons");
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
                    "Wpisz dane nowego pacjenta", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
                ended = true;
            }
            if (result == JOptionPane.OK_OPTION) {
                if (MyValidationLibrary.isValidPesel(peselField.getText()) && MyValidationLibrary.isValidAge(ageField.getText())) {
                    Person person = new Person();
                    person.setName(nameField.getText());
                    person.setSurname(surnameField.getText());
                    person.setPesel(peselField.getText());
                    person.setAge(Integer.parseInt(ageField.getText()));

                    if (femaleButton.isSelected()) {
                        person.setSex(SexEnum.FEMALE);
                    } else {
                        person.setSex(SexEnum.MALE);
                    }
                    collection.insert(person.toDBObject());
                    refresh();
                    ended = true;
                } else {
                    JOptionPane.showMessageDialog(null, "PESEL lub wiek niepoprawny");
                }
            }

        }
    }

    public void refresh() {
        fetchPersons();
        updateTable();
    }

    @Override
    public void search() {
        Person modelPerson = new Person();
        if (nameField.getText().length() != 0) {
            modelPerson.setName(nameField.getText());
        }
        if (surnameField.getText().length() != 0) {
            modelPerson.setSurname(surnameField.getText());
        }
        if (ageField.getText().length() != 0 && MyValidationLibrary.isValidAge(ageField.getText())) {
            modelPerson.setAge(Integer.parseInt(ageField.getText()));
        } else {
            ageField.setText("");

        }
        if (peselField.getText().length() != 0 && MyValidationLibrary.isValidPesel(peselField.getText())) {
            modelPerson.setPesel(peselField.getText());
        } else {
            peselField.setText("");
        }

        persons = new ArrayList<Person>();
        Person person;
        DBCursor foundPersons = collection.find(modelPerson.toDBObject());
        for (DBObject dbPerson : foundPersons) {
            person = new Person(dbPerson);
            persons.add(person);
        }
        updateTable();
    }

}
