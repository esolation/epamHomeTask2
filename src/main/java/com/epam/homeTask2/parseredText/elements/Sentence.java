package com.epam.homeTask2.parseredText.elements;

import com.epam.homeTask2.parser.Parser;
import com.epam.homeTask2.parser.ParserService;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Recoverable {
    Parser parser = new ParserService();
    private String sentence;
    private List<Words> words = new ArrayList<>();

    public Sentence(String text) {
        this.sentence = text;
        setWords();
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public List<Words> getWords() {
        return words;
    }

    public void setWords() {
        for (String word : parser.getAllWordsFromSentences(sentence)) {
            words.add(new Words(word));
        }
    }

    @Override
    public String toString() {
        return sentence;
    }

    @Override
    public String recover() {
        StringBuilder str = new StringBuilder();
        for (Words wrd : words) {
            str.append(wrd.recover());
        }

        return str + " ".trim();
    }
}
