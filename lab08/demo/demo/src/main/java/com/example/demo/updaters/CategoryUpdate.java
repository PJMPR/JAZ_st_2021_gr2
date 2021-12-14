package com.example.demo.updaters;

import com.example.demo.contract.GenreDto;
import com.example.demo.contract.MovieDto;
import com.example.demo.contract.OMDbDto;
import com.example.demo.model.Category;
import com.example.demo.model.FilmCategory;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.FilmCategoryRepository;
import com.example.demo.repositories.FilmRepository;
import com.example.demo.repositories.interfaces.ICategory;
import com.example.demo.repositories.interfaces.IFilm;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryUpdate implements Chain {
    private final Logger logger = Logger.getLogger(Category.class.getName());

    private Chain nextInChain;
    private CategoryRepository categoryRepository;
    private FilmCategoryRepository filmCategoryRepository;
    private FilmRepository filmRepository;

    public CategoryUpdate(CategoryRepository categoryRepository, FilmCategoryRepository filmCategoryRepository, FilmRepository filmRepository) {
        this.categoryRepository = categoryRepository;
        this.filmCategoryRepository = filmCategoryRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void query(MovieDto movieDto, OMDbDto omDbDto) {
        List<String> filmTitle = filmRepository.getAllFilms().stream().map(IFilm::getTitle).collect(Collectors.toList());
        for (GenreDto genre : movieDto.getGenres()) {
            List<String> dbList = categoryRepository.getAllCategories().stream().map(ICategory::getName).collect(Collectors.toList());
            long time = new Date().getTime();

            if (!dbList.contains(genre.getName())) {
                Category c = new Category();
                c.setCategoryId(dbList.size() + 1);
                c.setName(genre.getName());
                c.setLastUpdate(new Timestamp(time));

                categoryRepository.save(c);
                logger.log(Level.INFO, "Found and added new category: " + genre.getName());
                dbList = categoryRepository.getAllCategories().stream().map(ICategory::getName).collect(Collectors.toList());
            }
            FilmCategory filmCategory = new FilmCategory();
            filmCategory.setFilmId(filmTitle.indexOf(movieDto.getTitle()) + 1);
            filmCategory.setCategoryId(dbList.indexOf(genre.getName()) + 1);
            filmCategory.setLastUpdate(new Timestamp(time));

            filmCategoryRepository.save(filmCategory);
        }
        nextInChain.query(movieDto, omDbDto);
    }
}