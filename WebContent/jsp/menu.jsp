<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<style>
	* {
		text-align: center;
	}
	
	body {
		font-family: Meiryo;
		text-align: center;
		width: 70%;
		border: 5px solid silver;
		margin: 30px 420px 30px 180px;
		padding-top:15px;
		padding-bottom: 30px;
	}
	
	.button {
		height: 40px;
		width: 200px;
		margin-bottom: 10px;
	}
</style>
</head>

<body>

	<h2>メニュー画面</h2>
	
	<div>
	<form action = "../jsp/insert.jsp" method = "post">
		<input class = "button" type = "submit" value = "会員情報新規登録"></form>
		<br>
		
	<form action = "../jsp/edit-start.jsp" method = "post">
		<input class = "button" type = "submit" value = "会員情報変更"></form>
		<br>
		
	<form action = "../jsp/delete-start.jsp" method = "post">
		<input class = "button" type = "submit" value = "会員情報削除"></form>
	
	</div>	
</body>

</html>