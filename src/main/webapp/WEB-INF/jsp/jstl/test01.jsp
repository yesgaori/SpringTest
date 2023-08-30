<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제 1번</title>
</head>
<body>
	<h1>1. JSTL core 변수	</h1>
	<c:set var="number1" value="36" />
	<h4>첫번째 숫자 : ${number1 }</h4>
	<c:set var="number2" value="3" />
	<h4>두번째 숫자 : ${number2 }</h4>
	
	
	<h1>2. JSTL core 연산 </h1>
	
	<c:set var="plus" value="${number1 + number2 }" />
	<h4>더하기 : ${plus }</h4>
	
	<c:set var="minus" value="${number1 - number2 }" />
	<h4>빼기 : ${minus }</h4>
	
	<c:set var="multiply" value="${number1 * number2 }" />
	<h4>곱하기 : ${multiply }</h4>
	
	<c:set var="divide" value="${number1 / number2 }" />
	<h4>나누기 : ${divide }</h4>
	
	<h1>3. core out</h1>
	<c:out value="<title>core out</title>" />
	
	<h1>4. core if</h1>
	<c:if test="${plus / 2 >= 10}" >
	<h1>${plus / 2 }</h1>
	</c:if>
	<c:if test="${plus /2 < 10 }" >
	<h3>${plus / 2 }</h3>
	</c:if>
	
	<h1>5. core if</h1>
	<c:if test="${multiply > 100 }" >
		<c:out value="<script>alert('너무 큰 수입니다.')</script>" escapeXml="false" />
	</c:if>
	
	
</body>
</html>