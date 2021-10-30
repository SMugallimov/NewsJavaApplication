package com.synergyproject.newsjavaapp.job;

import com.synergyproject.newsjavaapp.model.News;
import com.synergyproject.newsjavaapp.service.NewsService;
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
    public void parseNewNews(){

        String url = "https://lenta.ru/";
        try {
            Document document = Jsoup.connect(url)
                    .userAgent("Google")
                    .referrer("https://www.google.com")
                    .get();

            Elements news = document.getElementsByClass("#root > section.b-layout.js-layout.b-layout_main > div > div > div.span8.js-main__content");
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