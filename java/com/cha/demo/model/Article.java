package com.cha.demo.model;

public class Article {
	
	private int idx;
	private String title;
	private String body;
	private String nickname;
	
	public Article(int idx, String title, String body, String nickname) {
		super();
		this.idx = idx;
		this.title = title;
		this.body = body;
		this.nickname = nickname;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
