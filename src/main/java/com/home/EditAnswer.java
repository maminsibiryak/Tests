package com.home;

import com.home.workingWithFiles.ReadAnswer;
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


public class EditAnswer {

    private JFrame frameEditAnswer;

    /**
     * Launch the application.
     */


    public void run() {
        try {
            EditAnswer windowEditTest = new EditAnswer();
            windowEditTest.frameEditAnswer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Create the application.
     */
    public EditAnswer() {
        initializeEditAnswer();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initializeEditAnswer() {
        frameEditAnswer = new JFrame();
        frameEditAnswer.setBounds(100, 100, 400, 300);
        frameEditAnswer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEditAnswer.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(33, 50, 215, 215);
        frameEditAnswer.getContentPane().add(scrollPane);

        final JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 394, 22);
        frameEditAnswer.getContentPane().add(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Open answer");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReadAnswer readFile = new ReadAnswer();
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
                    FileWriter fileWriter = new FileWriter("answerReadList.txt");
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

