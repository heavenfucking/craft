package com.demo.craft;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.selector.Selectable;

public class Demo {

    // 参考 http://webmagic.io/docs/zh/posts/ch2-install/with-maven.html
    public static void main(String[] args){
        Site site = Site.me()
                .setTimeOut(1000 * 60 * 5)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36")
                .setRetryTimes(8);
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Request request0 = new Request();
        request0.setUrl("http://stats.nba.com/game/0021700326/playbyplay/");
        Page page0 = httpClientDownloader.download(request0, site.toTask());
        //System.out.println(page0);
        request0.setUrl("http://stats.nba.com/js/data/widgets/boxscore_breakdown_20171202.json");
        Page page1 = httpClientDownloader.download(request0, site.toTask());
        //System.out.println(page1.getJson());

        request0.setUrl("https://data.nba.com/data/10s/v2015/json/mobile_teams/nba/2017/scores/pbp/0021700326_full_pbp.json");
        Page page2 = httpClientDownloader.download(request0, site.toTask());
        System.out.println(page2.getJson());

    }
}
