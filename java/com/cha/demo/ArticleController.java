package com.cha.demo;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.cha.demo.model.Article;
import com.cha.demo.model.ArticleRepository;
import com.cha.demo.model.URIHandler;
import com.cha.demo.util.MyUtil;

public class ArticleController {

	ArticleRepository articleRepository = new ArticleRepository();
	
	public String doURIMapping(URIHandler uriHandler) {
		
		String result = "";
		String methodType = uriHandler.getMethodType();
		String mappingURI = uriHandler.getMappingURI();
		Map<String, Object> params = uriHandler.getURIParams();

		if(methodType.equals("GET")) {
			result = doGetTypeService(mappingURI, params);
		} else if(methodType.equals("POST")) {
			result = doPostTypeService(mappingURI, params);
		}
		
		return result;
	}

	
	private String doPostTypeService(String mappingURI, Map<String, Object> params) {
		if(mappingURI.equals("articles/")) {
			return "POST 요청을 처리했으요!";
		} 
		return null;
	}


	private String doGetTypeService(String mappingURI, Map<String, Object> params) {
		if(mappingURI.equals("articles/")) {
			return getResultForList();
		} else if(mappingURI.equals("articles/#{articlesIdx}/")) {
			return getResultForSingle(params);
		}
		return null;
	}


	private String getResultForSingle(Map<String, Object> params) {
		int target = Integer.parseInt((String)params.get("articlesIdx"));
		Article article = articleRepository.getArticleByIdx(target);
		JSONObject jobj = new JSONObject();
				
		jobj.putAll(MyUtil.convertArticleToMap(article));
		return jobj.toJSONString();
	}

	private String getResultForList() {
		List<Article> articles = articleRepository.getAllArticles();
		
		JSONObject jobj = new JSONObject();
		List<Map<String, Object>> articleMapList = MyUtil.convertArticleListToMapList(articles);
		jobj.put("articles", articleMapList);

		return jobj.toJSONString();	
		
	}
	
}
