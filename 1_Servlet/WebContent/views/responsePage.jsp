<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h2 {color: red;}

#name {color: olive;}

#age {color: brown;}

#city {color: yellowgreen;}

#height {color: palevioletred;}

#gender {color: goldenrod;}
</style>
</head>
<body>

	<%
		// 스크립틀릿 (scriptlet) == html 문서 내에 자바 코드를 쓸 수 있는 영역
		
		// request.getAttribute("키") : Object(그에 해당하는 벨류값)
		String name = (String)request.getAttribute("name"); // 다운캐스팅 => 강제형변환 (오브젝트는 모든 것의 부모)
		int age = (int)request.getAttribute("age");
		String city = (String)request.getAttribute("city");
		double height = (double)request.getAttribute("height");
		String gender = (String)request.getAttribute("gender");
		String[] foods = (String[])request.getAttribute("foods");
	%>
	
	<h2>개인정보 응답 화면 - POST</h2>

	<span id="name"><%= name %></span>님은
	<span id="age"><%= age %></span>살이며,
	<span id="city"><%= city %></span>에 사는 키는
	<span id="height"><%= height %></span>cm이고, 
	
	성별은
	<% if(gender == null) { %>
		선택하지 않았습니다. <br> <!-- case 1 -->
	<% } else { %>
		<% if(gender.equals("M")) { %>
		<span id="gender">남자</span>입니다. <br> <!-- case 2 -->
		<% } else { %>
		<span id="gender">여자</span>입니다. <br> <!-- case 3 -->
		<% } %>
	<% } %>

	좋아하는 음식은
	<% if(foods == null) { %>
		없습니다. <br>
	<% } else { %>
		<ul>
			<% for(int i = 0; i < foods.length; i++) { %>
			<li><%= foods[i] %></li>
			<% } %>
		</ul>
	<% } %>

</body>
</html>