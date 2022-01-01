package com.cha.demo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cha.demo.model.Article;

public class MyUtil {

	public static Map<String, Object> convertArticleToMap(Article article) {
		
		Map<String, Object> articleMap = new HashMap();
		articleMap.put("idx", article.getIdx());
		articleMap.put("title", article.getTitle());
		articleMap.put("body", article.getBody());
		articleMap.put("nickname", article.getNickname());
		
		return articleMap;
	
	}
	
	public static List<Map<String, Object>> convertArticleListToMapList(List<Article> articles) {
		List<Map<String, Object>> articleMapList = new ArrayList();
		
		for(Article article : articles) {
			Map<String, Object> articleMap = convertArticleToMap(article);
			articleMapList.add(articleMap);
		}
		
		return articleMapList;
	}
	
}
