package MusicalEditor.gui;


import javax.swing.*;
import java.io.*;


public class MusicalEditor {


      public static void main(String[] args) throws FileNotFoundException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UserInterface userInterface = new UserInterface();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
