package BaseGui;

import javax.swing.*;

public class BaseAdminPanel {

    public JPanel getPanelMain() {
        return panelMain;
    }

    private JPanel panelMain;
    private JButton searchButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton deleteAllButton;
    private JButton summaryButton;
    private JTable resultTable;

    public BaseAdminPanel() {
        panelMain = new JPanel();
        searchButton = new JButton("Szukaj");
        addButton = new JButton("Dodaj");
        deleteButton = new JButton("Usuń");
        editButton = new JButton("Edytuj");
        deleteAllButton = new JButton("Usuń wszystko");
        summaryButton = new JButton("Podsumowanie");
        panelMain.add(searchButton);
        panelMain.add(addButton);
        panelMain.add(deleteButton);
        panelMain.add(editButton);
        panelMain.add(deleteAllButton);
        panelMain.add(summaryButton);
        panelMain.add(resultTable);
    }
}
