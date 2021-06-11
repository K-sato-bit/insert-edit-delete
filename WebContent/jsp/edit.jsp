<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.List,jp.co.aforce.Bean.MemberBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更</title>
<style>
	* {
		text-align: center;
	}
	
	.birth {
		margin-right: 125px;
	}
	
	.edit {
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

	<h2>会員情報変更画面</h2>
	
	<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
	%>

	<div class = "error">
		<%=(String) request.getAttribute("message") %>
	</div>
	
	<% } %>

	<% MemberBean mb = (MemberBean)session.getAttribute("member");%>
	
	<form action = "../jp.co.aforce.edit/edit-check" method = "post">
	
		会員番号　　
		<input type = "text" size = "28" name = "member_no" 
			value = "<%=mb.getMember_no() %>">
			
		<input type = "submit" value = "表示">
		
	</form>
		
		<p>
		
	<form action = "../servlet/edit" method = "post">
	
		名前　　
		<input type = "text" size = "30" name = "name" value="<%=mb.getName() %> "><p>
		
		年齢　　		
		<input type = "text" size = "30" name = "age" value="<%=mb.getAge() %>"><p>
		
		<div class = "birth">
		生年月日　　
		<select name = "birth_year" >
		
			<%
				for (int i = 1920; i <= 2020; i++) {
					if(i == mb.getBirth_year()){ %>
							<option value=<%=i %> selected><%=i %></option>
						<%} else {%>
							<option value=<%=i %>><%=i %></option>
						<%} %>
			<% } %></select>
			
		<select name = "birth_month">
			
			<%
			for (int j = 1; j <= 12; j++) {
				if(j == mb.getBirth_month()){ %>
				<option value=<%=j %> selected><%=j %></option>
			<%} else {%>
				<option value=<%=j %>><%=j %></option>
			<%} %>
	
						
			<% } %></select>
			
			
		<select name = "birth_day">
		
			<%
			for (int k = 1; k <= 31; k++) { 
				if(k == mb.getBirth_day()){ %>
				<option value=<%=k %> selected><%=k %></option>
			<%} else {%>
				<option value=<%=k %>><%=k %></option>
			<%} %>
				
			<% } %></select>
			
		</div>
		
		<p>
	<div style="display:inline-flex">
	
		<input type="hidden" name="member_no" value="<%=mb.getMember_no() %>">
		<input class = "edit" type = "submit" value = "変更"></form>
		
		<form action = "../jsp/edit-start.jsp" method = "post">
			<input class = "re" type = "submit" value = "戻る"></form>
		
	</div>
	
</body>
</html>