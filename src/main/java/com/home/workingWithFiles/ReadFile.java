package com.home.workingWithFiles;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {
    private List<String> lines;

    public List<String> getLines() throws IOException {



        lines = Files.readAllLines(Paths.get("test.txt"), StandardCharsets.UTF_8);

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(i + " " + lines.get(i));
        }

        for (String line : lines) {
            System.out.println(line);
        }
        return lines;
    }
}
