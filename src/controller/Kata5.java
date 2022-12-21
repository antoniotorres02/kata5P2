package controller;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReaderDB;

public class Kata5 {

    public static void main(String[] args) {
        MailListReaderDB mailListReader = new MailListReaderDB("jdbc:sqlite:kata5P1.db");
        List<Mail> mailList = mailListReader.read();
        MailHistogramBuilder mailHistogramBuilder = new MailHistogramBuilder();
        Histogram<String> histogram = mailHistogramBuilder.build(mailList);
        new HistogramDisplay(histogram).execute();
        
    }
    
}
