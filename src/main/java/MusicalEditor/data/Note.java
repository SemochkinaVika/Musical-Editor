package MusicalEditor.data;

import java.awt.*;

/**
 * Created by vikalenovo on 07.02.2017.
 */
public class Note {
    public int height;
    public int duration;
    public int level;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "\n\t\tNote{" +
                "height=" + height +
                ", duration=" + duration +
                '}';
    }


    public void paint(Graphics g, int xoffset,int ystep,int base_line_y) {
        g.setColor(Color.black);
        g.fillOval(xoffset,base_line_y-ystep*level,5,5);
    }
}
