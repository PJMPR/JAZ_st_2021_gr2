package main.java.com.example.demo.services;

import com.example.demo.contracts.LanguageDto;
import com.example.demo.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;
    
    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    
    @Cacheable(value = "languages")
    public List<LanguageDto> getLanguages() {
        return languageRepository.findAllLanguages;
    }
}
