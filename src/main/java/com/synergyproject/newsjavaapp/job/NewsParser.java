package com.synergyproject.newsjavaapp.job;

import com.synergyproject.newsjavaapp.model.News;
import com.synergyproject.newsjavaapp.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NewsParser {

    final NewsService newsService;

    public NewsParser(NewsService newsService) {
        this.newsService = newsService;
    }

    @Scheduled(fixedDelay = 10_000)
    public void parseNewNews(){

        String url = "https://lenta.ru/";
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Google")
                    .referrer("https://www.google.com")
                    .timeout(5_000)
                    .get();

            Elements news = document.getElementsByClass("g-time");
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