package main.java.com.example.demo.repositories;

import com.example.demo.contracts.LanguageDto;
import com.example.demo.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    @Query(value = "select 1 from Language 1 order by 1.name")
    List<LanguageDto> findAllLanguages();
}
