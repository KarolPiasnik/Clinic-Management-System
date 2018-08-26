package BaseGui;

import javax.swing.*;

public class BaseAdminPanel {

    public JPanel getPanelMain() {
        return panelMain;
    }

    private JPanel panelMain;
    private JPanel buttonsPanel;
    private JPanel listPanel;

    private JButton searchButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton deleteAllButton;
    private JButton summaryButton;
    private JTable resultTable;

    public BaseAdminPanel() {
        resultTable = new JTable();
        panelMain = new JPanel();
        listPanel = new JPanel();
        buttonsPanel = new JPanel();
        searchButton = new JButton("Szukaj");
        addButton = new JButton("Dodaj");
        deleteButton = new JButton("Usuń");
        editButton = new JButton("Edytuj");
        deleteAllButton = new JButton("Usuń wszystko");
        summaryButton = new JButton("Podsumowanie");
        buttonsPanel.add(searchButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteAllButton);
        buttonsPanel.add(summaryButton);
        listPanel.add(resultTable);
        panelMain.add(buttonsPanel);
        panelMain.add(listPanel);
    }
}
