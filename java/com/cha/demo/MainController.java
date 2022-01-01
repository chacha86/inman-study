package com.cha.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cha.demo.model.URIHandler;

@WebServlet("/")
public class MainController extends HttpServlet {

	ArticleController controller = new ArticleController();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String method = request.getMethod();
		String uri = request.getRequestURI();
		
		System.out.println(method);
		System.out.println(uri);
		
		
		// uri 를 넣으면 
		// 1. /articles
		// 2. /articles/2, /members/3, /replies/1
		// -> #{articlesIdx}로 일반화. 그리고 2값을 따로 파라미터로 저장(key는 articlesIdx)
		// -> #{membersIdx}로 일반화. 그리고 3값을 따로 파라미터로 저장(key는 membersIdx)
		// -> #{repliesIdx}로 일반화. 그리고 1값을 따로 파라미터로 저장(key는 repliesIdx)
		URIHandler uriHandler = new URIHandler(uri, method);
		String result = controller.doURIMapping(uriHandler);		
		response.getWriter().append(result);
		
	}
	
	// MappingURI -> 컨트롤러에서 메서드 찾기 용도
	// @RequestMapping("/article/#{idx}")
	
}
