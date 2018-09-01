package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private JPanel panelMain;
    private JButton patientsButton;
    private JButton workersButton;
    private JButton appointmentsButton;
    private GridLayout menuLayout;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public MainPanel() {
        menuLayout = new GridLayout(0, 2);

        panelMain = new JPanel();
        panelMain.setLayout(menuLayout);
        patientsButton = new JButton("Pacjenci");
        appointmentsButton = new JButton("Usługi");
        workersButton = new JButton("Pracownicy");
        workersButton.setPreferredSize(new Dimension(200, 200));
        patientsButton.setPreferredSize(new Dimension(200, 200));
        appointmentsButton.setPreferredSize(new Dimension(200, 200));

        panelMain.add(patientsButton);
        panelMain.add(workersButton);
        panelMain.add(appointmentsButton);


    }

    public void addPatientsButtonListener (ActionListener listener){
        patientsButton.addActionListener(listener);
    }

    public void addWorkersButtonListener (ActionListener listener){
        workersButton.addActionListener(listener);
    }

    public void addAppointmentsButtonListener (ActionListener listener){
        appointmentsButton.addActionListener(listener);
    }


}
