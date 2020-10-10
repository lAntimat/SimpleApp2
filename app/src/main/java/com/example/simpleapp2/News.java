package com.example.simpleapp2;

public class News {

    private String newsTitle;
    private String newsSubtitle;

    public News(String newsTitle, String newsSubtitle) {
        this.newsTitle = newsTitle;
        this.newsSubtitle = newsSubtitle;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsSubtitle() {
        return newsSubtitle;
    }

    public void setNewsSubtitle(String newsSubtitle) {
        this.newsSubtitle = newsSubtitle;
    }
}
