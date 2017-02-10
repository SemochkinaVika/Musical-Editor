package MusicalEditor.gui;


import MusicalEditor.data.Page;

import javax.swing.*;
import java.awt.*;

public class Display extends JComponent {
    private JFrame frame;
    Dimension dim = new Dimension(600, 600);
    Page page;

    public  Display(JFrame frame){
        this.frame=frame;
    }

    public void setPage(Page page) {
        this.page = page;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height);
        if(page!=null)  page.paint(g);
    }

    @Override
    public Dimension getSize(Dimension rv) {
        return dim;
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }

    @Override
    public Dimension getMinimumSize() {
        return dim;
    }

    @Override
    public Dimension getMaximumSize() {
        return dim;
    }
}
