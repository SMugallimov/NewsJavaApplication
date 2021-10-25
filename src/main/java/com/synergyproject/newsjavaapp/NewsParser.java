package com.synergyproject.newsjavaapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class NewsParser {

    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 10000)
    public void parseTopNews(){
        String url = "https://lenta.ru/";

        try {
            Document document = Jsoup.connect(url).get();

            Elements news = document.getElements;// Тут проблема - не понятно как взять элементы с lenta.ru getElementsByArgument?
            for(Element element: news){
                String title = element.ownText();
                if(!newsService.isExist(title)){
                    News obj = new News();
                    obj.setTitle(title);
                    newsService.save(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}