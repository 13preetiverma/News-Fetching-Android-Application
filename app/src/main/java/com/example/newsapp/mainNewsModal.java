package com.example.newsapp;

import com.example.newsapp.articleModal;

import java.util.ArrayList;

public class mainNewsModal {
    String status;
    int totalResult;
    ArrayList<articleModal> articles;

    public mainNewsModal(String status, int totalResult, ArrayList<articleModal> articles) {
        this.status = status;
        this.totalResult = totalResult;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<articleModal> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<articleModal> articles) {
        this.articles = articles;
    }
}
