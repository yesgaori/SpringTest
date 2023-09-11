<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>통나무 펜션</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <link rel="stylesheet" href="/style/style.css" type="text/css">
    </head>

    <body>
        <div id="wrap" width="1200px" >
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

            <section class="banner">
                <img src="/images/test06_banner2.jpg" id="bannerImage">
            </section>
            <sction class="d-flex">
                <article width="400px" height="300px" class="reservation d-flex justify-content-center align-items-center">
                    <div class="display-4">
                        실시간 <br>
                        예약 하기 
                    </div>
                </article>
                <article class="reservation-confirm" width="500px" height="300px">

                        <div class="no-member-input mt-3">
                            <div class="input-gorup form-inline">
                                <label class="input-label">이름 </label>
                                <input type="text" class="form-control text-input" id="nameInput">
                            </div>
                            <div class="input-gorup form-inline mt-3">
                                <label class="input-label">전화번호 </label>
                                <input type="text" class="form-control text-input" id="phoneNumberInput">
                            </div>
                        </div>
                        <div class="d-flex justify-content-end">
                            <button class="btn btn-success mt-3 mr-5" id="findBtn">조회 하기</button>
                        </div>
                    </div>
                </article>
                <article height="300px" width="300px" class="reservation-call d-flex justify-content-center align-items-center">
                    <div>
                        <h3>예약문의 : </h3>
                        <h1>010-</h1>
                        <h1>000-1111</h1>
                    </div>
                </article>
            </sction>

            <footer class="mt-3 ml-4">
                <address>
                    제주특별자치도 제주시 애월읍  <br>
                    사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
                    Copyright 2025 tongnamu All right reserved
                </address>

            </footer>


        </div>

    <script>
        $(document).ready(function() {
			
        	$("#findBtn").on("click", function() {
        		
        		let name = $("#nameInput").val();
        		let phoneNumber = $("#phoneNumberInput").val();
        		
        		if(name == "") {
        			alert("이름을 입력 해 주세요");
        			return ;
        		} 
        		
        		if(phoneNumber == "") {
        			alert("전화번호를 입력 해 주세요");
        			return ;
        		}
        		
        		$.ajax ({
        			type:"get"
        			, url:"/ajax/booking/search"
        			, data:{"name":name, "phoneNumber":phoneNumber}
        			, success:function(data) {
        				if(data.result =="fail"){
        					alert("조회결과가 없습니다");
        				} else {
        					alert("이름 : " + data.booking.name + "\n"
            						+ "날짜 : " + data.booking.date.substring(0,10) + "\n"
            						+ "일수 : " + data.booking.day + "\n"
            						+ "인원 : " + data.booking.headcount + "\n"
            						+ "상태 : " + data.booking.state);
            				
        				}
        				
        				
        			}
        			, error:function(data) {
        				alert("조회 에러");
        			}
        			
        			
        		});
        		
        		
        		
        		
        	});
        	
        	
            // 데이트 피커 셋팅
            $( "#date" ).datepicker({
                minDate:0, 
                dateFormat: "yy년 m월 d일",
            });

            // 라디오 버튼 선택에 따른 인풋 변경
            $("input[name=type]").on('change', function() {
                if($(this).val() == 'member') {
                    $("#member").removeClass("d-none");
                    $("#nonMember").addClass("d-none");
                } else {
                    $("#nonMember").removeClass("d-none");
                    $("#member").addClass("d-none");
                }
            });

            $("#lookupBtn").on('click', function() {
                if($("input[name=type]:checked").val() == "member") {

                    // 회원 입력 항목 유효성 검사 
                    if($("#id").val() == '')   {
                        alert("아이디를 입력하세요.");
                        return;
                    }

                    if($("#password").val() == '')   {
                        alert("비밀번호를 입력하세요.");
                        return;
                    }

                    alert("조회 성공");

                } else {

                    // 비 회원 입력 항목 유효성 검사 
                    if($("#name").val() == '')   {
                        alert("이름을 입력하세요.");
                        return;
                    }

                    if($("#phoneNumber").val() == '')   {
                        alert("전화번호를 입력하세요.");
                        return;
                    }

                    // 010 으로 시작하는 것만 통과
                    if(!$("#phoneNumber").val().startsWith("010"))   {
                        alert("010 으로 시작하는 번호만 입력가능합니다. ");
                        return;
                    }

                    if($("#date").val() == '')   {
                        alert("날짜를 입력하세요.");
                        return;
                    }

                    alert("조회 성공");
                }
            });

            var bannerList = ["images/test06_banner2.jpg", "images/test06_banner3.jpg", "images/test06_banner4.jpg"];
            var currentImageIndex = 0;
            setInterval(function() {
                $("#bannerImage").attr("src", bannerList[currentImageIndex]);
                currentImageIndex++;

                if(currentImageIndex == bannerList.length) {
                    currentImageIndex = 0;
                }
            }, 3000); 
        } );
    </script>
    </body>
</html>