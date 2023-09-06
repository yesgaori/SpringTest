<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
</head>
<body>
	<div>
		<h1>즐겨찾기 추가하기</h1>
		<div>
			<label>제목</label><input type="text" id="titleInput"><br>
			<label>주소</label><input type="text" id="urlInput"> <button type="button" id="duplicateBtn">중복확인</button><br>
			<button type="button" id="addBtn">추가</button>
		</div>
	</div>
	
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			$("#duplicateBtn").on("click", function() {
				let url = $("#urlInput").val();
				
				if(url == "") {
					alert("주소를 입력하세요");
					return ;
				} 
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소형식을 확인 해 주세요")
					return ;
				}
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorites/duplicate-url"
					, data:{"url":url}
					, success:function(data) {
						if(data.isDuplicate) {
							alert("중복된 이메일 입니다")
						} else {
							alert("사용가능한 이메일 입니다")
						}
					}
					, error:function() {
						alert("중복확인 에러!");
					}
					
				});
				
				
			});
			
			$("#addBtn").on("click", function() {
				// 사용자가 입력한 사이트 이름, 주소를 얻어 와서
				// create api 호출
				let title = $("#titleInput").val();
				let address = $("#urlInput").val();
				
				//유효성 검사
				if(title == "") {
					alert("제목을 입력하세요")
					return ;
				}
				
				if(address == "") {
					alert("주소를 입력하세요");
					return ;
				} 
				if(!address.startsWith("http://") && !address.startsWith("https://")) {
					alert("주소형식을 확인 해 주세요")
					return ;
				}
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorites/create"
					, data:{"name":title, "siteAddress":address}
					, success:function(data) {
						// 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						if(data.result == "success") {
							location.href = "/ajax/favoritesList"
						}else {
							alert("추가 실패")
						}
						
					}
					, error:function() {
						alert("추가 에러!!");
					}
				});
				
			});
			
			
			
			
		});
		
		
	
	</script>
	
</body>
</html>