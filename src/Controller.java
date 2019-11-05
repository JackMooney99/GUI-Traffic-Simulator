import java.io.File;

import javax.swing.Timer;

class Controller {

    private SimCity2D view;

    Controller(SimCity2D view) {
        this.view = view;
    }

    void init() {

        Timer timer = new Timer(125, e -> {
            view.cityView.getCity().step();
            view.cityView.repaint();
        });

        view.simItemRun.addActionListener(e -> {
            timer.start();
            view.statusLbl.setText("Status: " + Status.StartSimulation);
        });
        view.simItemStop.addActionListener(e -> {
            timer.stop();
            view.statusLbl.setText("Status: " + Status.StopSimulation);
        });
        view.cityItemNew.addActionListener(e -> {
            view.dispose();
            try {
                City city = City.loadCity(SimCity2D.getCity());
                this.view = new SimCity2D(city);
            } catch (Exception exc) {
                view.statusLbl.setText("Status: " + Status.NewFailed);
            }
        });
        view.cityItemSave.addActionListener(e -> SimCity2D.saveCity());
        view.cityItemEdit.addActionListener(e -> {
            view.getContentPane().remove(view.cityView);
            view.getContentPane().add(view.editCityView);
            view.pack();
            view.modeLbl.setText("Mode: " + Mode.Edit);
        });
        view.editCityView.done.addActionListener(e -> {
            view.getContentPane().remove(view.editCityView);
            view.getContentPane().add(view.cityView);

            view.modeLbl.setText("Mode: " + Mode.Simulation);
            view.statusLbl.setText("Status: " + Status.Edited);
            view.pack();
            view.cityView.updateUI();
        });
        view.cityItemExit.addActionListener(e -> System.exit(0));
        view.cityItemOpen.addActionListener(e -> {
            File file = SimCity2D.openCity();
            if (file != null) {
                SimCity2D simCity2D = new SimCity2D(City.loadCity(file.getName()));
                this.view.dispose();
                this.view = simCity2D;
            }
        });
    }
}