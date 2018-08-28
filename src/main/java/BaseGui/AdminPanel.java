package BaseGui;

import javax.swing.*;

public interface AdminPanel {
    void updateTable();
    void deleteSelected();
    void addNew();
    void editSelected();
    void showSummary();
    void search();
    JPanel getPanelMain();
}
