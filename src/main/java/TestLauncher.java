
import com.home.EasyTest;
import com.home.EditAnswer;
import com.home.EditTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestLauncher {


    private JFrame frame;
    private JTextField textField;
    final EasyTest easyTest = new EasyTest();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestLauncher window = new TestLauncher();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TestLauncher() throws IOException, InterruptedException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws IOException, InterruptedException {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, frame.getWidth(), 22);
        frame.getContentPane().add(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Edit test");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditTest editTest = new EditTest();
                editTest.run();

            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Edit answer");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditAnswer editAnswer = new EditAnswer();
                editAnswer.run();

            }
        });
        mnNewMenu.add(mntmNewMenuItem_2);





        textField = new JTextField();

        textField.setBounds(6, 25, 264, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);


        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setBounds(6, 55, 790, 175);
        frame.getContentPane().add(scrollPane);

        final JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        /*JLabel jLabel = new JLabel();
        jLabel.setBounds(380, 25, 50, 29);
        Thread.sleep(3000);
        jLabel.setText("test");
        frame.getContentPane().add(jLabel);*/

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Start testing");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                List<String> strings = null;
                try {
                    strings = easyTest.getLines();
                    for (String str : strings
                            ) {
                        textArea.append(String.valueOf(str) + "\n");

                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);



        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(6, 250, 790, 175);
        frame.getContentPane().add(scrollPane_1);

        final JTextArea textArea_1 = new JTextArea();
        scrollPane_1.setViewportView(textArea_1);


        final JButton btnNewButton = new JButton("Проверить");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea_1.setText("");
                    String text = textField.getText();
                    easyTest.readAnswer(text);
                    ArrayList<String> strings1 = easyTest.getAnswerWriteList();
                    int count = 1;
                    for (String str1 : strings1
                            ) {
                        textArea_1.append("Твой ответ на вопрос " + count + ") " + str1 + "\n");
                        count++;
                    }

                    easyTest.checkAnswer();
                    textArea_1.append(String.valueOf("Ты получил " + easyTest.getResult() + " очков" + "\n"));
                    btnNewButton.setVisible(false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
        btnNewButton.setBounds(266, 25, 117, 29);
        frame.getContentPane().add(btnNewButton);




    }
}
