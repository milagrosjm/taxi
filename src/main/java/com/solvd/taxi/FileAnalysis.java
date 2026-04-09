package com.solvd.taxi;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileAnalysis {

    public static void countWordsFromFile(String inputPath, String outputPath, List<String> wordsToCount) throws IOException {

        File pathInputFile = new File(inputPath);

        String text = FileUtils.readFileToString(pathInputFile, StandardCharsets.UTF_8);
        text = text.toLowerCase();

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : wordsToCount) {
            int count = StringUtils.countMatches(text, word.toLowerCase());
            wordCount.put(word, count);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            result.append(entry.getKey())
                  .append(": ")
                  .append(entry.getValue())
                  .append("\n");
        }
        result.append("------\n");

        File outputFile = new File(outputPath);
        FileUtils.writeStringToFile(outputFile, result.toString(), StandardCharsets.UTF_8, true);
    }
}
