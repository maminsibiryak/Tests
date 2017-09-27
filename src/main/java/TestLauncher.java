
import com.home.EasyTest;

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
    public TestLauncher() throws IOException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws IOException {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        textField = new JTextField();

        textField.setBounds(6, 6, 264, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);


        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setBounds(6, 45, 790, 175);
        frame.getContentPane().add(scrollPane);

        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);


        final EasyTest easyTest = new EasyTest();
        List<String> strings = easyTest.getLines();
        for (String str : strings
                ) {
            textArea.append(String.valueOf(str) + "\n");

        }


        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(6, 250, 790, 175);
        frame.getContentPane().add(scrollPane_1);

        final JTextArea textArea_1 = new JTextArea();
        scrollPane_1.setViewportView(textArea_1);


        JButton btnNewButton = new JButton("Проверить");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea_1.selectAll();
                textArea_1.replaceSelection("");
                String text = textField.getText();
                easyTest.readAnswer(text);
                ArrayList<String> strings1 = easyTest.getAnswerWriteList();
                int count = 1;
                for (String str1 : strings1
                        ) {
                    textArea_1.append("Твой ответ на вопрос " + count + " " + str1 + "\n");
                    count++;
                }
                try {
                    easyTest.checkAnswer();
                    textArea_1.append(String.valueOf("Ты получил " + easyTest.getResult() + " баллов"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
        btnNewButton.setBounds(266, 6, 117, 29);
        frame.getContentPane().add(btnNewButton);


    }
}
