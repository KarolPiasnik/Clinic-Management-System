import gui.MainApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        MainApp app = new MainApp();
        JFrame frame = new JFrame("App");
        frame.setContentPane(app.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.pack();
    }
}
