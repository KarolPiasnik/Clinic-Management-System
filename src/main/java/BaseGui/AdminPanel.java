package BaseGui;

import javax.swing.*;

public interface AdminPanel {
    void updateTable();
    void deleteSelected();
    void addNew();
    void saveChanges();
    void showSummary();
    void search();
    void deleteAll();
    JPanel getPanelMain();
}
