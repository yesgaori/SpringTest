<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨입력</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

	<div class="container d-flex " width="1200px">
		<div class="col-2 bg-primary text-center">
			<img src="https://blog.kakaocdn.net/dn/TxmeD/btqCKArBvPm/2tzfJfINwg0WWmCzC4jKW0/img.jpg" width="100px">
			<ul class="list-group list-group-flush">
				<li class="list-group-item bg-primary"><a href="#" class="text-dark">날씨</a></li>
				<li class="list-group-item bg-primary"><a href="totaltest01-2" class="text-dark">날씨입력</a></li>
				<li class="list-group-item bg-primary"><a href="#" class="text-dark">테마날씨</a></li>
				<li class="list-group-item bg-primary"><a href="#" class="text-dark">관측 기후</a></li>
			</ul>
		</div>
		<div class="col-10 container">
			<h1>날씨 입력</h1>
			<div class="d-flex justify-content-between col-10 align-items-center">
				<form method="get" action="/jstl/totaltest01/input">
				<label>날짜</label><input type="text" name="date">
				<label>날씨</label>
				<select name="weather">
					<option value="맑음">맑음</option>
					<option value="구름조금">구름조금</option>
					<option value="흐림">흐림</option>
					<option value="비">비</option>
				</select>
				<label>미세먼지</label>
				<select name="microDust">
					<option value="좋음">좋음</option>
					<option value="보통">보통</option>
					<option value="나쁨">나쁨</option>
					<option value="최악">최악</option>
				</select>
			</div>
			<div class="d-flex justify-content-between col-10 align-items-center">
				<label>기온</label><input type="text" name="temperatures">
				<label>강수량</label><input type="text" name="precipitation">
				<label>풍속</label><input type="text" name="windSpeed">
			</div>
			<div class="d-flex justify-content-end col-10">
				<button type="submit btn btn-success">저장</button>
			</div>
			</form>
		</div>
	</div>
	<footer class="container d-flex">
			<div class="w-1">
				<img class="grayscale-3" src="https://blog.kakaocdn.net/dn/TxmeD/btqCKArBvPm/2tzfJfINwg0WWmCzC4jKW0/img.jpg" width="100px">
			</div>
			<div class="w-11">
				(07062)서울시 동작구 여의대방로16길 61<br>
				Copyright@2020 KMA. All Rights RESERVED.
			</div>
		</footer>



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
		${date}
	
	</script>
</body>
</html>