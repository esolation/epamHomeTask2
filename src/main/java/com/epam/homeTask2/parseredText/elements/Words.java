package com.epam.homeTask2.parseredText.elements;

import com.epam.homeTask2.parser.Parser;
import com.epam.homeTask2.parser.ParserService;

import java.util.ArrayList;
import java.util.List;

public class Words implements Recoverable {
    private Parser parser = new ParserService();
    private String word;
    private List<Chars> chars = new ArrayList<>();

    public Words(String text) {
        this.word = text;
        setChars();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private void setChars() {
        for (char c : parser.getAllCharacterFromWord(word)) {
            chars.add(new Chars(c));
        }
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public String recover() {
        StringBuilder str = new StringBuilder();
        for (Chars c : chars) {
            str.append(c.recover());
        }
        return str + " ";
    }
}
