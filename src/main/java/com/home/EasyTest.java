package com.home;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EasyTest {
    private List<String> lines;
    private  ArrayList<String> answerWriteList = new ArrayList<>();
    private int result ;




    //read

    public List<String> getLines() throws IOException {



        List<String> lines = Files.readAllLines(Paths.get("test.txt"), StandardCharsets.UTF_8);

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(i + " " + lines.get(i));
        }

        for (String line : lines) {
            System.out.println(line);
        }
        return lines;
    }

    //answer
    public  void readAnswer(String s) {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = s.split(",");


        for (int i = 0; i <tmp.length ; i++) {
            answerWriteList.add(i,tmp[i]);
        }

       /* for (int i = 0; i < lines.size(); i++) {
            String answer = bufferedReader.readLine();
            answerWriteList.add(answer);
        }
        for (String line : answerWriteList) {
            System.out.println(line);
        }*/

    }


    public void checkAnswer() throws IOException {
        //equals
        List<String> answerReadList = Files.readAllLines(Paths.get("answerReadList.txt"), StandardCharsets.UTF_8);

        for (int i = 0; i < answerReadList.size(); i++) {
            if (answerWriteList.get(i).equals(answerReadList.get(i))) {
                result += 1;
            } else if (!answerWriteList.get(i).equals(answerReadList.get(i))) {
                answerWriteList.set(i, "0");
            }
        }
        System.out.println(result);

        for (String aline : answerWriteList) {
            System.out.println(aline);
        }
    }

    public ArrayList<String> getAnswerWriteList() {
        return answerWriteList;
    }

    public int getResult() {
        return result;
    }


}
