<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<div>
			<label>제목</label><br><input type="text" id="titleInput" class="col-9"><br>
			<label class="mt-3">주소</label><br><input type="text" id="urlInput" class="col-8"> <button type="button" id="duplicateBtn" class="btn btn-primary">중복확인</button><br>
			<div class="small d-none text-danger" id="duplicate-on">중복된 url입니다</div>
			<div class="small d-none text-primary" id="duplicate-off">사용가능한 url입니다</div>
			<button type="button" id="addBtn" class="btn btn-success col-9">추가</button>
		</div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			
			// 중복 체크 확인
			var isDuplicateCheck = false;
			// 중복상태
			var isDuplicateUrl = true;
			
			$("#urlInput").on("input", function() {
				isDuplicateCheck = false;
				isDuplicateUrl = true;
			})
			
			
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
						isDuplicateCheck = true;
						if(data.result) {
							isDuplicateUrl = true;
							$("#duplicate-on").removeClass("d-none")
							$("#duplicate-off").addClass("d-none")
						} else {
							isDuplicateUrl = false;
							$("#duplicate-on").addClass("d-none")
							$("#duplicate-off").removeClass("d-none")
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
				let url = $("#urlInput").val();
				
				//유효성 검사
				if(title == "") {
					alert("제목을 입력하세요")
					return ;
				}
				
				if(url == "") {
					alert("주소를 입력하세요");
					return ;
				} 
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소형식을 확인 해 주세요")
					return ;
				}
				
				// 중복확인 안된 상태
				if(!isDuplicateCheck) {
					alert("url 중복체크를 해주세요");
					return ;
				}
				// 중복된 url 일때
				if(isDuplicateUrl) {
					alert("중복된 url입니다");
					return ;
				}
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorites/create"
					, data:{"name":title, "url":url}
					, success:function(data) {
						// 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						if(data.result == "success") {
							location.href = "/ajax/favorites/list"
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