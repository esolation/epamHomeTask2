package com.epam.homeTask2.parser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserService implements Parser {
    @Override
    public List<String> getAllParagraphsFromText(String text) {
        return List.of(text.split("\\s*[\n]\\s*"));
    }

    @Override
    public List<String> getAllSentencesFromText(String text) {

        return List.of(text.split("\\s*(?<=[.?!])\\s*"));
    }
    @Override
    public List<String> getAllWordsFromSentences(String sentence) {
        return Arrays.asList(sentence.split("\\s*(?<=[,])\\s*"));
    }

    @Override
    public List<Character> getAllCharacterFromWord(String word) {
        return word.chars().mapToObj(c-> (char) c).collect(Collectors.toList());
    }
}
