package com.epam.homeTask2.parseredText.elements;

import com.epam.homeTask2.parser.ParserService;

import java.util.ArrayList;
import java.util.List;

public class Paragraphs implements Recoverable {
    private String paragraph;
    private ParserService parserService = new ParserService();
    private List<Sentence> sentences = new ArrayList<>();

    public Paragraphs(String text) {
        this.paragraph = text;
        setSentence();
    }

    private void setSentence() {
        for (String sentence : parserService.getAllSentencesFromText(paragraph)) {
            sentences.add(new Sentence(sentence));
        }
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        return paragraph;
    }

    @Override
    public String recover() {
        StringBuilder str = new StringBuilder();
        for (Sentence sen : sentences) {
            str.append(sen.recover());
        }
        return new String(str).trim() + "\n";
    }
}
