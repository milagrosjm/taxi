package com.solvd.taxi;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import java.util.stream.Collectors;

public class FileAnalysis {

    public static void countWordsFromFile(String inputPath, String outputPath, List<String> wordsToCount) throws IOException {

        File pathInputFile = new File(inputPath);

        final String text = FileUtils.readFileToString(pathInputFile, StandardCharsets.UTF_8).toLowerCase();

        Map<String, Integer> wordCount = wordsToCount.stream().collect(Collectors.toMap(
                        word -> word,
                        word -> StringUtils.countMatches(text, word.toLowerCase())));

        for (String word : wordsToCount) {
            int count = StringUtils.countMatches(text, word.toLowerCase());
            wordCount.put(word, count);
        }

        String result = wordCount.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n", "", "\n------\n"));

        File outputFile = new File(outputPath);
        FileUtils.writeStringToFile(outputFile, result.toString(), StandardCharsets.UTF_8, true);
    }
}
