<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/chat/chatt.css'>
</head>
<body>
	<div id='chatt'>
		<h1>WebSocket Chatting</h1>
		<input type='hidden' id='mid' value="<%=session.getAttribute("m_id")%>">
	
		<input type='button' value='채팅참여' id='btnLogin'>
		<br/>
		<div id='talk'></div>
		<div id='sendZone'>
			<textarea id='msg' value='hi...' ></textarea>
			<input type='button' value='전송' id='btnSend'>
		</div>
	</div>
	<script src='js/chatt.js'></script>
</body>
</html>