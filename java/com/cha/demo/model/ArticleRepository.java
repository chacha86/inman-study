package com.cha.demo.model;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

	List<Article> articles = new ArrayList<Article>();
	
	public ArticleRepository() {
		articles.add(new Article(1, "title1", "body1", "hong"));
		articles.add(new Article(2, "title2", "body2", "lee"));
		articles.add(new Article(3, "title3", "body3", "cha"));
		articles.add(new Article(4, "title4", "body4", "yeo"));
	}
	
	public List<Article> getAllArticles() {
		return this.articles;
	}
	
	public Article getArticleByIdx(int idx) {
		
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getIdx() == idx) {
				return articles.get(i);
			}
		}
		
		return null;
	}
}
