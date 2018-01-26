package com.home;

import com.home.workingWithFiles.ReadFile;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JTextArea;

import javax.swing.JScrollPane;


public class EditTest {

    private JFrame frameEditTest;

    /**
     * Launch the application.
     */


    public void run() {
        try {
            EditTest windowEditTest = new EditTest();
            windowEditTest.frameEditTest.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Create the application.
     */
    public EditTest() {
        initializeEditTest();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initializeEditTest() {
        frameEditTest = new JFrame();
        frameEditTest.setBounds(100, 100, 400, 300);
        frameEditTest.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEditTest.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(33, 50, 215, 215);
        frameEditTest.getContentPane().add(scrollPane);

        final JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 394, 22);
        frameEditTest.getContentPane().add(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Open test");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReadFile readFile = new ReadFile();
                try {
                    List<String> strings = readFile.getLines();

                    for (String str : strings
                            ) {
                        textArea.append(String.valueOf(str) + "\n");

                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
        mnNewMenu.add(mntmNewMenuItem);
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save test");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    FileWriter fileWriter = new FileWriter("test.txt");
                    fileWriter.write(textArea.getText());
                    fileWriter.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);


    }
}

