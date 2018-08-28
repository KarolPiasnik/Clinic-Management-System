package BaseGui;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class BaseAdminPanelImpl implements AdminPanel{

    public void updateTable() {
        throw new NotImplementedException();
    }

    public void deleteSelected() {
        throw new NotImplementedException();

    }

    public void addNew() {
        throw new NotImplementedException();

    }

    public void editSelected() {
        throw new NotImplementedException();

    }

    public void showSummary() {
        throw new NotImplementedException();

    }

    public void search() {
        throw new NotImplementedException();
    }

    public JPanel getPanelMain()  {
        return panelMain;
    }

    protected JPanel panelMain;
    protected JPanel buttonsPanel;
    protected JPanel listPanel;

    protected JButton searchButton;
    protected JButton addButton;
    protected JButton deleteButton;
    protected JButton editButton;
    protected JButton deleteAllButton;
    protected JButton summaryButton;
    protected JTable resultTable;

    public BaseAdminPanelImpl() {

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

        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.PAGE_AXIS));

    }


}
