package com.service;

import me.apemanzilla.edjournal.Journal;
import org.springframework.stereotype.Component;

@Component
public class EDJournalService  {

    public Journal getJournalInstance() {
        return Journal.create();
    }
}
