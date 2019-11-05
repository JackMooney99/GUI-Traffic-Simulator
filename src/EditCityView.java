import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class EditCityView extends JPanel implements MouseListener {

    private City city;
    private ArrayList<CityCell> selectedCells = new ArrayList<>();
    JMenuItem done = new JMenuItem("Done");
    private JPopupMenu menu = new JPopupMenu();


    public EditCityView(City city) {
        this.city = city;
        setPreferredSize(new Dimension(800, 800));
        setLayout(new BorderLayout());
        addMouseListener(this);
        menu.add(done);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < City.CITY_HEIGHT; ++i) {
            g.drawLine(0, i * cellHeight(), getWidth(), i * cellHeight());
        }

        for (int i = 0; i < City.CITY_WIDTH; ++i) {
            g.drawLine(i * cellWidth(), 0, i * cellWidth(), getWidth());
        }
        for (CityCell cc: selectedCells) {
            g.fillRect(cc.getX() * cellHeight(), cc.getY() * cellWidth(), cellWidth(), cellHeight());
        }
    }

    private int cellWidth() {
        return getWidth() / City.CITY_WIDTH;
    }

    private int cellHeight() {
        return getHeight() / City.CITY_HEIGHT;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        int xClick = arg0.getX();
        int yClick = arg0.getY();

        CityCell[][] cityCells = city.getCityCells();
        for (CityCell[] cityCell : cityCells) {
            for (CityCell cc : cityCell) {
                if (xClick > cc.getX() * cellWidth() && xClick < cc.getX() * cellWidth() + cellWidth() &&
                        yClick > cc.getY() * cellHeight() && yClick < cc.getY() * cellHeight() + cellHeight()) {
                    selectedCells.add(cc);
                    repaint();
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (SwingUtilities.isRightMouseButton(arg0)) {
            menu.show(this, arg0.getX(), arg0.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
}
