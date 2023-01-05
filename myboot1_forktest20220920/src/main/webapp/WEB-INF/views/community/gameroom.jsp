<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>MemberList | Othub</title>
   <link href="css/commu/room/import.css" rel="stylesheet">
    <link href="css/commu/room/common.css" rel="stylesheet">
	<script src="js/jquery-3.6.0.min.js"></script>

</head>
<body>
<div id='full' align='center'>
	<div id='left'>
		<div class='player'><%=session.getAttribute("player") %></div>
		<div class='player'>yellow</div>
		<div class='player'>yellow</div>
		<div class='player'>yellow</div>
	</div>
	<div id='center2'>
		<div class='info'>info</div>
		<div class='info'>info</div>
		<div class='info'>info</div>
		<div class='info'>info</div>
	</div>
	
	<div id='center'>
		<div class='blue'>blue</div>

	</div>
	
	<div id='right'>
		<div class='black'>black</div>

	</div>

</div>
	
</body>


</html>