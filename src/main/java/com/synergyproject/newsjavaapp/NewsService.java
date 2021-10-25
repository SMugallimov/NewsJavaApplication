package com.synergyproject.newsjavaapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    public void save(News news);
    public boolean isExist(String newTitle);
    public List<News> getTopNews();
}