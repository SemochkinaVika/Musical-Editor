package MusicalEditor.gui;

import MusicalEditor.data.Page;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserInterface extends JFrame {
    private JTextArea textArea = new JTextArea();
    private Display display = new Display(this);

    public UserInterface() throws Exception {
        super("Пользовательский интерфейс");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(textArea),new JScrollPane(display));

        getContentPane().add(split,BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar();
        Font font = new Font("Verdana", Font.PLAIN, 11);
        textArea.setFont(font);
        textArea.setEditable(false);

        JMenu menu = new JMenu("Меню");
        menu.setFont(font);
        bar.add(menu);
        setJMenuBar(bar);

        JMenuItem open = new JMenuItem("Открыть");
        menu.add(open);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser(new File(System.getProperty("user.dir")));
                fileopen.addChoosableFileFilter(new FileNameExtensionFilter("json", "JSON"));
                fileopen.setAcceptAllFileFilterUsed(false);
                fileopen.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int result = fileopen.showDialog(null, "Открыть файл");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    try {
                        Page    page=Page.parse(file);
                        textArea.setText(page.toString());
                        display.setPage(page);

                    } catch (Exception ex1) {
                        ex1.printStackTrace();
                    }
                }

            }
        });

        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        split.setDividerLocation(0.5f);
    }

}
