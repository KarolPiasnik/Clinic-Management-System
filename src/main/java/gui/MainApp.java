package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    private JPanel panelMain;
    private JButton patientsButton;
    private JButton workersButton;
    private JButton servicesButton;
    private JButton roomsButton;
    private JButton devicesButton;
    private GridLayout menuLayout;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public MainApp() {
        menuLayout = new GridLayout(0, 2);

        panelMain = new JPanel();
        panelMain.setLayout(menuLayout);
        patientsButton = new JButton("Pacjenci");
        servicesButton = new JButton("Usugi");
        roomsButton = new JButton("Pomieszczenia");
        workersButton = new JButton("Pracownicy");
        devicesButton = new JButton("Urządzenia");
        workersButton.setPreferredSize(new Dimension(200, 200));
        patientsButton.setPreferredSize(new Dimension(200, 200));
        devicesButton.setPreferredSize(new Dimension(200, 200));
        roomsButton.setPreferredSize(new Dimension(200, 200));
        servicesButton.setPreferredSize(new Dimension(200, 200));

        panelMain.add(devicesButton);
        panelMain.add(roomsButton);
        panelMain.add(patientsButton);
        panelMain.add(workersButton);
        panelMain.add(servicesButton);


        patientsButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Dziala jak ma");
            }
        });
    }


}
