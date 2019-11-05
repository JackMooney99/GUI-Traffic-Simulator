import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import static javax.swing.JOptionPane.showMessageDialog;

public class SimCity2D extends JFrame {

    private City city;
    CityView cityView;
    EditCityView editCityView;
    private JPanel statusPnl = new JPanel();
    JLabel statusLbl = new JLabel("Status: " + Status.NewSimulation);
    JLabel modeLbl = new JLabel("Mode: " + Mode.Simulation);

    JMenuItem cityItemNew = new JMenuItem("New");
    JMenuItem cityItemEdit = new JMenuItem("Edit");
    JMenuItem cityItemOpen = new JMenuItem("Open");
    JMenuItem cityItemSave = new JMenuItem("Save");
    JMenuItem cityItemExit = new JMenuItem("Exit");

    private JMenuItem simItemUpdateRate = new JMenuItem("Update Rate");
    JMenuItem simItemRun = new JMenuItem("Run");
    JMenuItem simItemStop = new JMenuItem("Stop");
    private JMenuItem simItemSpawnRate = new JMenuItem("Spawn Rate");

    public SimCity2D(City city) {
        this.city = city;

        Car car = new Car();
        car.setDirection();
        city.addVehicle(car);
        Road start = city.getCityCells()[0][0].getRoad(Direction.LEFT);
        start.placeVehicle(car, 0);
        initControls();
    }

    private void initControls() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sim City 2D");

        cityView = new CityView(city);
        editCityView = new EditCityView(city);
        cityView.setPreferredSize(new Dimension(800, 800));

        statusPnl.add(modeLbl);
        statusPnl.add(statusLbl);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCity = new JMenu("City");
        JMenu menuSim = new JMenu("Sim");
        menuBar.add(menuCity);
        menuBar.add(menuSim);
        menuCity.add(cityItemNew);
        menuCity.add(cityItemEdit);
        menuCity.add(cityItemOpen);
        menuCity.add(cityItemSave);
        menuCity.addSeparator();
        menuCity.add(cityItemExit);
        menuSim.add(simItemUpdateRate);
        menuSim.add(simItemRun);
        menuSim.add(simItemStop);
        menuSim.add(simItemSpawnRate);
        setJMenuBar(menuBar);

        add(cityView, BorderLayout.CENTER);
        add(statusPnl, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    static String getCity() {
        JTextArea txt = new JTextArea(5, 10);

        showMessageDialog(null, "Formula: x1,y1,x2,y2 (new road for every line)");
        showMessageDialog(null, txt, "Enter road coordinates", JOptionPane.INFORMATION_MESSAGE);
        return txt.getText();
    }

    static void saveCity() {
        JFileChooser chooser = new JFileChooser(".");
        int selection = chooser.showSaveDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            try (FileWriter fw = new FileWriter(chooser.getSelectedFile())) {
                fw.write(City.lines);
            } catch (Exception exc) {
                showMessageDialog(null, exc.getMessage(), "Something went wrong",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static File openCity() {
        JFileChooser chooser = new JFileChooser(".");
        int selection = chooser.showOpenDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            try {
                return chooser.getSelectedFile();
            } catch (Exception exc) {
                showMessageDialog(null, exc.getMessage(), "Something went wrong",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

}
