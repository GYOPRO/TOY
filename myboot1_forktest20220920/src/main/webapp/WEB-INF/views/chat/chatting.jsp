<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/chat/chatt.css'>
<script>
	$(document).ready(function() {
		
	});//ready end
</script>
</head>
<body>
	<div id='chatt'>
		<div id= "chatHeader">Everyone</div>
		<input type='hidden' id='mid' value="<%=session.getAttribute("m_id")%>">
		<div id='talk'></div>
		<div id='sendZone'>
			<input id='msg' value='' autocomplete="off" size="30">
			<input type='button' value='전송' id='btnSend'>
		</div>
	</div>
	<script src='js/chatt.js'></script>
</body>
</html>