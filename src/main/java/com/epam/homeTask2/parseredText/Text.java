package com.epam.homeTask2.parseredText;


import com.epam.homeTask2.parser.Parser;
import com.epam.homeTask2.parser.ParserService;
import com.epam.homeTask2.parseredText.elements.Paragraphs;
import com.epam.homeTask2.parseredText.elements.Recoverable;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Text {
     private Logger log = Logger.getLogger(Text.class);
     private Parser parser = new ParserService();
     private String text;
     private StringBuilder recoveredText = new StringBuilder();
     private List<Recoverable> recov = new ArrayList<>();
     private List<Paragraphs> paragraphs = new ArrayList<>() ;
    public Text(String text) {
        try{
            BasicConfigurator.configure();
            this.text = text;
            setParagraphs();
            recov.addAll(paragraphs);
            log.info("Text successfully parsered!");
        }
        catch (NullPointerException e){
                log.error("Error!" + e.getMessage());
        }
    }

    public List<Paragraphs> getParagraphs() {
        return paragraphs;
    }

    private void setParagraphs() throws NullPointerException {
        for (String paragraph : parser.getAllParagraphsFromText(text)) {
            paragraphs.add(new Paragraphs(paragraph));
        }
    }

    public String recoverText() {
        for (Recoverable rec : recov) {
            recoveredText.append(rec.recover());
        }
        log.info("Text recovery successfully!");
        return recoveredText.toString().trim();
    }
}
