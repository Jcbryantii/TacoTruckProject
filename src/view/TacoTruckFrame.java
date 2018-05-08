package view;

import javax.swing.*;

public class TacoTruckFrame extends JFrame {

    public TacoTruckFrame() {

        this.setName("TacoTruckFrame");
        this.setTitle("DisAint Taco Bell");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setContentPane(new TacoTruckWelcomePanel());
        this.setVisible(true);

    }

}