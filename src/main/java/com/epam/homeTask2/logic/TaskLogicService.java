package com.epam.homeTask2.logic;

import com.epam.homeTask2.parser.Parser;
import com.epam.homeTask2.parser.ParserService;
import com.epam.homeTask2.parseredText.Text;
import com.epam.homeTask2.parseredText.elements.Paragraphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaskLogicService implements TaskLogic {
    Parser parser = new ParserService();
    /*
    Should sort sentences
     */
    @Override
    public List<String> doTaskLogic(Text text) {
        List<String> list = new ArrayList<>();
        for(Paragraphs par:text.getParagraphs()){
            list.addAll(par.getSentences().stream()
            .map(Objects::toString)
            .collect(Collectors.toList()));
        }
        list.sort(Comparator.comparingInt(String::length).reversed());
        return list;
    }
}
