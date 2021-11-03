package com.synergyproject.newsjavaapp.service;

import com.synergyproject.newsjavaapp.model.News;

import java.util.List;

public interface NewsService {
    void save(News news);
    boolean isExist(String newsTitle);
    List<News> getAllNews();
}