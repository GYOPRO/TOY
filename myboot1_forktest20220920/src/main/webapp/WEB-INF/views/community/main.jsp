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
		
		$("#deletebtn").click(function(ev){
			 if(!confirm("탈퇴 처리 하시겠습니까?")) {
				 ev.preventDefault();
			 }
		 });
		
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
              <col width="200px"><col width="200px"><col width="200px"><col width="200px">
            </colgroup>
            <thead >
               <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>인원수</th>
                  <th>방장</th>
               </tr>
            </thead>
            <tbody>
			<c:forEach items="${boardlist }" var="list">
            	<tr onclick="location.href='game?g_seq=${list.g_seq }'" style="cursor: pointer;"><td>${list.g_seq }</td><td>${list.g_title }</td><td>${list.g_player }</td><td>${list.g_master }</td></tr>
            </c:forEach>
            </tbody>
   </table>
   </div>

   </div>
	</section>
	
	<!-- footer include -->
	<%@include file="../include/footer.jsp" %>
</body>


</html>