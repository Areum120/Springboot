<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"/></title>
</head>
<body>

	<!-- 상단 메뉴 -->
	<tiles:insertAttribute name="header"/>
	<!-- 상단 메뉴 끝 -->

	<!-- 내용 시작 -->
	<tiles:insertAttribute name="body"/>
	<!-- 내용 끝 -->

</body>
</html>