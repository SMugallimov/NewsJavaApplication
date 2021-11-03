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
                    .timeout(5_000)
                    .referrer("https://www.google.com")
                    .get();

            Elements news = document.select("#root > section.b-layout.js-layout.b-layout_main > div > div > " +
                    "div.span4.b-sidebar-stickycolumn.js-main__sidebars > " +
                    "div.b-sidebar-stickycolumn__top.js-main__sidebar-top > section > div");
            for(Element element: news.select("a")){
                String title = element.text();
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