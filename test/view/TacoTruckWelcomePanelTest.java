package view;

import static org.junit.Assert.*;

import org.junit.Test;
import view.TacoTruckWelcomePanel;

import javax.swing.*;

import static org.junit.Assert.*;

public class TacoTruckWelcomePanelTest {

    @Test
    public void welcomePanel_initialState() {

        TacoTruckWelcomePanel welcome = new TacoTruckWelcomePanel();
        JTextField customerNameField = (JTextField) welcome.getComponents() [1];
        JButton startButton = (JButton) welcome.getComponents() [2];
        JLabel customerPrompt = (JLabel) welcome.getComponents()[0];


        assertEquals("view.TacoTruckWelcomePanel", welcome.getName());

        assertEquals("StartOrderButton",welcome.getStartButton().getName());
        assertEquals("Start Order",welcome.getStartButton().getText());
        assertEquals("StartOrderButton", startButton.getName());
        assertEquals("Start Order", startButton.getText());
        assertEquals(startButton, welcome.getStartButton());

        assertEquals("CustomerNameField", welcome.getCustomerNameField().getName());
        assertEquals("", welcome.getCustomerNameField().getText());
        assertEquals("CustomerNameField", customerNameField.getName());
        assertEquals("", customerNameField.getText());
        assertEquals(customerNameField, welcome.getCustomerNameField());

    }






}