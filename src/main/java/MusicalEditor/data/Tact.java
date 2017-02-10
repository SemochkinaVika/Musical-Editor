package MusicalEditor.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikalenovo on 09.02.2017.
 */
public class Tact {

    List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "\n\tTact{" +
                "notes=" + notes +
                "\n\t}";
    }

    public void paint(Graphics g,int starty) {
       for(int i=0;i<5;i++){
            g.setColor(Color.black);
            g.drawLine(10, starty+10+i*20, 10+500, starty+10+i*20);
       }
       int offset=10;
       int xstep=20;
       int ystep=10;
        int base_line_y=starty+10+4*20;
       for(Note note:notes){
            note.paint(g,offset,ystep,base_line_y);
           offset+=xstep;
       }
    }
}
