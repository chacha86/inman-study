package com.cha.demo.model;

import java.util.HashMap;
import java.util.Map;

public class URIHandler {
	
	private Map<String, Object> params = new HashMap();
	private String mappingURI; 
	private String methodType;
	
	public URIHandler(String uri, String methodType) {
		this.methodType = methodType;
		String[] uriPieces = uri.split("/"); // ["", "articles", "#{articlesIdx}"]
		// ["", "members", "#{membersIdx}"]
		// params.put("memberIdx", 3)
		int realPeiceStartIndex = 1;
		int stepForNextResourceId = 2;
		mappingURI = "";

		// articles
		for (int i = realPeiceStartIndex; i < uriPieces.length; i += stepForNextResourceId) {
			int resourceIdIndex = i + 1;

			String groupId = uriPieces[i]; // 그룹id
			String resourceId = groupId + "Idx"; // 리소스 id
			mappingURI += groupId + "/"; // "" => "articles"

			if (resourceIdIndex >= uriPieces.length) {
				break;
			}

			String formattedResouceId = "#{" + resourceId + "}";
			mappingURI += formattedResouceId + "/";
			System.out.println(resourceId + "," + uriPieces[resourceIdIndex]);
			params.put(resourceId, uriPieces[resourceIdIndex]);
		}
	
	}
	
	public String getMethodType() {
		return this.methodType;
	}
	
	public String getMappingURI() {
		return mappingURI;
	}
	
	public Map<String, Object> getURIParams() {
		return params;
	}
}
