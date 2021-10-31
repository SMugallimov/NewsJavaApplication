package com.synergyproject.newsjavaapp.service;

import com.synergyproject.newsjavaapp.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    void save(News news);
    boolean isExist(String newsTitle);
    List<News> getAllNews();
}