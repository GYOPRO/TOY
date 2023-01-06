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
   <link href="css/commu/list/import.css" rel="stylesheet">
    <link href="css/commu/list/common.css" rel="stylesheet">
	<script src="js/jquery-3.6.0.min.js"></script>
	<script>
	$(document).ready(function() {
		var ss = <%=session.getAttribute("nick")%>
		var change = "손님"+Math.floor(Math.random()*1000);
		if(ss == null){
			document.getElementById("mid").value=change;
		}
		});//ready end
	</script>
</head>
<body>
	<!-- navbar include -->
	<%@include file="../include/navbar.jsp" %>
	
	<section class="myorder">
		<div class="myorderBox">
			<h3 class="orderTitle">방 목록</h3>
				<div class="inner">
	<table>
	 <colgroup>
              <col width="150px"><col width="400px"><col width="220px"><col width="220px">
            </colgroup>
            <thead >
               <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>인원수</th>
                  <th>제작자</th>
               </tr>
            </thead>
            <tbody>
			<c:forEach items="${boardlist }" var="list">
            	<tr onclick="location.href='game?g_seq=${list.g_seq }'" id="bodytr"><td>${list.g_seq }</td><td>${list.g_title }</td><td>${list.g_player }명</td><td>${list.g_master }</td></tr>
            </c:forEach>
            </tbody>
   </table>
   </div>
   </div>
   	<div id='chatt'>
		<div id= "chatHeader">Everyone</div>
		<input type='hidden' id='mid' value="<%=session.getAttribute("nick")%>">
		<div id='talk'></div>
		<div id='sendZone'>
			<input id='msg' value='' autocomplete="off" size="30">
			<input type='button' value='전송' id='btnSend'>
		</div>
	</div>
	<script src='js/chatt.js'></script>
	</section>
	
	<!-- footer include -->
	<%@include file="../include/footer.jsp" %>
</body>


</html>