<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="ajax test" id="ajax_btn">
	<input type="button" value="ajax test2" id="ajax_btn2">
	<script> 
	var btn = document.getElementById("ajax_btn"); 
	btn.addEventListener("click", () => { 
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/articles', true);
		xhr.send(); 
		xhr.onload = () => { 
			if (xhr.status == 200) { 
				console.log(xhr.response); 
				console.log("통신 성공"); 
			} else { 
				console.log("통신 실패"); 
			}
		} 
	}); 
	
	var btn2 = document.getElementById("ajax_btn2");
	btn2.addEventListener("click", () => {
		fetch('/articles')
			.then(function(response) {
				return response.json();
			})
			.then(function(json) {
				
				list = document.querySelector("#list");
				articles = json.articles;
				for(i = 0; i < articles.length; i++) {
 
					var str = 
						'<div>' +
							'<div>' +
								'번호 : ' + articles[i].idx + 
							'</div>' +
							'<div>' +
								'제목 : ' + articles[i].title + 
							'</div>' +
							'<div>' +
								'내용 : ' + articles[i].body + 
							'</div>' +
							'<div>' +
								'작성자 : ' + articles[i].nickname + 
							'</div>' +
						'</div>' +
						'<hr>';
						list.innerHTML += str;
				}	
			}) 
		}) 
	
	</script>

	<div id="list">
		
	</div>

</body>
</html>