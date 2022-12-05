package com.example.cykelrytter.services;

import com.example.cykelrytter.model.NewsList;
import com.example.cykelrytter.repositories.NewsListRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class NewsListService implements INewsListService{

    private NewsListRepository newsListRepository;

    public NewsListService(NewsListRepository newsListRepository) {
        this.newsListRepository = newsListRepository;
    }

    @Override
    public Set<NewsList> findAll() {
        Set<NewsList> listOfEmails = new HashSet<>();
        newsListRepository.findAll().forEach(listOfEmails::add);
        return listOfEmails;
    }

    @Override
    public NewsList save(NewsList email) {
        return newsListRepository.save(email);
    }

    @Override
    public void delete(NewsList object) {
        newsListRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        newsListRepository.deleteById(aLong);
    }

    @Override
    public Optional<NewsList> findById(Long aLong) {
        return Optional.empty();
    }
}
