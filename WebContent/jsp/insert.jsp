<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報新規登録</title>
<style>
	* {
		text-align: center;
	}
	
	.birth {
		margin-right: 125px;
	}
	
	.insert {
		margin-right: 50px;
		height: 30px;
		width: 80px;
	}
	
	.re {
		height: 30px;
		width: 80px;
	}
	
	.error {
		color: red;
		font-weight: bold;
	}
</style>
</head>

<body>

	<h2>会員情報新規登録</h2>	
	
	<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
	%>

	<div class = "error">
		<%=(String) request.getAttribute("message") %>
	</div>
	
	<% } %>
	
	<form action = "../servlet/insert" method = "post">
	
		名前　　
		<input type = "text" size = "30" name = "name"><p>
		
		年齢　　
		<input type = "text" size = "30" name = "age"><p>
		
		<div class = "birth">
		生年月日　　
		<select name = "birth_year">
		
			<%
				for (int i = 1920; i <= 2020; i++) {
			%>
					
				<option value=<%=i %>><%=i %></option>
			
			<% } %></select>
			
			
		<select name = "birth_month">
			
			<%
			for (int j = 1; j <= 12; j++) {
			%>
			
				<option value=<%=j %>><%=j %></option>
			
			<% } %></select>
			
			
		<select name = "birth_day">
		
			<%
			for (int k = 1; k <= 31; k++) { 
			%>
			
				<option value=<%=k %>><%=k %></option>
				
			<% } %></select>
			
		</div>
	<p>	
		
	<div style="display:inline-flex">
		<input class = "insert" type = "submit" value = "登録"></form>
		
		
		<form action = "../jsp/menu.jsp" method = "post">
			<input class = "re" type = "submit" value = "戻る"></form>
	
	</div>
	
</body>
</html>