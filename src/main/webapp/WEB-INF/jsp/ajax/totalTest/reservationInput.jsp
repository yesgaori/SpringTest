<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" href="/style/style.css" type="text/css">
</head>
<body>
	<div id="wrap" >
            <header class="mt-4">
                <div class="text-center display-4">통나무 팬션</div>
                <nav class="mt-4">
                    <ul class="nav nav-fill">
                        <li class="nav-item"><a class="nav-link" href="#">팬션소개</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">객실보기</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">예약안내</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">커뮤니티</a></li>
                    </ul>
                </nav>
            </header>
            <section class="container d-flex justify-content-center">
            	<div>
	            	<h1>예약 하기</h1>
	            	
	            	<label>이름</label><br>
	            	<input type="text" class="col-10" id="nameInput"><br>
	            	<label>예약날짜</label><br>
	            	<input type="text" class="col-10" id="dateInput"><br>
	            	<label>숙박일수</label><br>
	            	<input type="text" class="col-10" id="dayInput"><br>
	            	<label>숙박인원</label><br>
	            	<input type="text" class="col-10" id="headcountInput"><br>
	            	<label>전화번호</label><br>
	            	<input type="text" class="col-10" id="phoneNumberInput"><br>
	            	<button type="button" class="Btn Btn-warning" id="bookingBtn">예약하기</button>
            	</div>
			</section>
            <footer class="mt-3 ml-4">
                <address>
                    제주특별자치도 제주시 애월읍  <br>
                    사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
                    Copyright 2025 tongnamu All right reserved
                </address>

            </footer>


        </div>






	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	<script>
		$("document").ready(function() {
			
			$("#bookingBtn").on("click", function() {
			
				let name = $("#nameInput").val();
				let date = $("#dateInput").val();
				let day = $("#dayInput").val();
				let headcount = $("#headcountInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				
				if(name == "") {
					alert("이름을 입력하세요")
					return ;
				}
				if(date == "") {
					alert("날짜를 입력하세요")
					return ;
				}
				if(day == "") {
					alert("숙박일수를 입력하세요")
					return ;
				}
				
				// day가 숫자가 아닌경우
				
				if(isNaN(day)) {
					alert("숙박일수는 숫자만 입력 가능합니다");
					return ;
					
				}
				
				if(headcount == "") {
					alert("숙박인원을 입력하세요");
					return ;
				}
				
				if(isNaN(headcount)) {
					alert("숙박인원은 숫자만 입력 가능합니다");
					return ;
				}
				
				if(phoneNumber == "") {
					alert("전화번호를 입력하세요");
					return ;
				}
				

				$.ajax({
					type:"get"
					, url:"/ajax/booking/create"
					, data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
					, success:function(data) {
						if(data.result == "succes") {
							location.href="/ajax/booking/list";
						} else {
							alert("예약 실패");
						}
						
					}
					, error:function() {
						alert("예약 에러");
					}
					
				});
				
				
				
				
			});
			
			
			
			
			$("#dateInput").datepicker({
				dateFormat:"yy년mm월dd일"
			});
			
		})


	</script>

</body>
</html>