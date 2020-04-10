package com.epam.homeTask2.parseredText.elements;

public class Chars implements Recoverable {
    private char c;

     Chars(char c) {
        this.c = c;
    }
    @Override
    public String recover() {
        return String.valueOf(c);
    }
}
