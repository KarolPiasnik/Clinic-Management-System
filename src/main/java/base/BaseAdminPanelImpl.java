package base;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseAdminPanelImpl implements AdminPanel {

    public void updateTable() {
        throw new NotImplementedException();
    }

    public void deleteSelected() {
        throw new NotImplementedException();

    }

    public void addNew() {
        throw new NotImplementedException();

    }

    public void saveChanges() {
        throw new NotImplementedException();

    }

    public void showSummary() {
        throw new NotImplementedException();

    }

    public void search() {
        throw new NotImplementedException();
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void deleteAll() {
        throw new NotImplementedException();
    }

    protected JPanel panelMain;
    protected JPanel buttonsPanel;
    protected JPanel listPanel;
    protected JPanel searchPanel;

    protected JButton searchButton;
    protected JButton addButton;
    protected JButton deleteSelectedButton;
    protected JButton saveChangesButton;
    protected JButton deleteAllButton;
    protected JButton summaryButton;
    protected JTable resultTable;

    protected JTextField nameField;
    protected JTextField surnameField;
    protected JTextField ageField;
    protected JTextField peselField;


    public BaseAdminPanelImpl() {

        resultTable = new JTable();

        panelMain = new JPanel();
        listPanel = new JPanel();
        buttonsPanel = new JPanel();
        searchPanel = new JPanel();


        searchButton = new JButton("Szukaj");
        addButton = new JButton("Dodaj");
        deleteSelectedButton = new JButton("Usuń zaznaczone");
        saveChangesButton = new JButton("Zapisz zmiany");
        deleteAllButton = new JButton("Usuń wszystko");
        summaryButton = new JButton("Podsumowanie");


        searchPanel.add(searchButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteSelectedButton);
        buttonsPanel.add(saveChangesButton);
        buttonsPanel.add(deleteAllButton);
        buttonsPanel.add(summaryButton);

        nameField = new JTextField(5);
        surnameField = new JTextField(5);
        ageField = new JTextField(5);
        peselField = new JTextField(5);

        searchPanel.add(new JLabel("Imię"));
        searchPanel.add(nameField);
        searchPanel.add(new JLabel("Nazwisko"));
        searchPanel.add(surnameField);
        searchPanel.add(new JLabel("Wiek"));
        searchPanel.add(ageField);
        searchPanel.add(new JLabel("PESEL"));
        searchPanel.add(peselField);

        listPanel.add(resultTable);
        panelMain.add(buttonsPanel);
        panelMain.add(searchPanel);
        panelMain.add(listPanel);

        deleteSelectedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteSelected();
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNew();
            }
        });

        deleteAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAll();
            }
        });

        summaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSummary();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });

        saveChangesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.PAGE_AXIS));


    }


}
