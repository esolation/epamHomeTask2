package com.epam.homeTask2.parseredText.elements;

public class Chars implements Recoverable {
    char c;

    public Chars(char c) {
        this.c = c;
    }
    @Override
    public String recover() {
        return String.valueOf(c);
    }
}
