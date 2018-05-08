import model.TacoTruck;
import org.junit.Before;

import org.junit.Test;
import presenter.Presenter;
import view.TacoTruckWelcomePanel;


import javax.swing.*;



import java.awt.*;



import static org.junit.Assert.*;



public class PresenterTest {



    Presenter presenter;



    @Before

    public void setUp() {

        TacoTruck view = new TacoTruck();

        presenter = new Presenter(view);

    }



    @Test

    public void testPresenterInitializesWithStartScree() {

        TacoTruck view = new TacoTruck();

        Presenter presenter = new Presenter(view);

        Container currentScreen = presenter.getCurrentScreen();

        assertEquals(view, presenter.getView());

        assertEquals("view.TacoTruckWelcomePanel", currentScreen.getName());

        assertEquals(currentScreen, presenter.getView().getContentPane());

    }



    @Test

    public void testStartButtonOnClickGoesToOrderScreen () {

        JButton startButton = ((TacoTruckWelcomePanel) presenter.getCurrentScreen()).getStartButton();

        startButton.doClick();

        assertEquals("TacoTruckOrderPanel", presenter.getCurrentScreen().getName());

    }



}