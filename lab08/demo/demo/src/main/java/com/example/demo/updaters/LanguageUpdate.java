package com.example.demo.updaters;

import com.example.demo.contract.LanguagesDto;
import com.example.demo.contract.MovieDto;
import com.example.demo.contract.OMDbDto;
import com.example.demo.model.Language;
import com.example.demo.repositories.LanguageRepository;
import com.example.demo.repositories.interfaces.ILanguages;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LanguageUpdate implements Chain {
    private final Logger logger = Logger.getLogger(LanguageUpdate.class.getName());

    private Chain nextInChain;
    private LanguageRepository languageRepository;

    public LanguageUpdate(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void query(MovieDto movieDto, OMDbDto omDbDto) {
        for (LanguagesDto lang : movieDto.getLanguages()) {
            List<String> dbList = languageRepository.getAllLanguages().stream().map(ILanguages::getName).collect(Collectors.toList());

            if (!dbList.contains(lang.getEnglish_name())) {
                long time = new Date().getTime();

                Language l = new Language();
                l.setLanguageId(dbList.size() + 1);
                l.setName(lang.getEnglish_name());
                l.setLastUpdate(new Timestamp(time));

                languageRepository.save(l);
                logger.log(Level.INFO, "Found and added new language: " + l.getName());
            }
        }
        nextInChain.query(movieDto, omDbDto);
    }
}