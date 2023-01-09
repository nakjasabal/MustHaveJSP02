<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mode = request.getParameter("mode");
if(mode!=null && mode.equals("1")){
	session.setAttribute("mySession", "세션 영역");
}
else if(mode!=null && mode.equals("2")){
	session.removeAttribute("mySession");
}
else if(mode!=null && mode.equals("3")){
	session.invalidate();
}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function formSubmit(f, num){
	f.mode.value = num;
	f.submit();
}
</script>
</head>
<body>
	<h2>리스너 활용하기</h2>
	<form action="">
		<input type="hidden" name="mode" />
		<input type="button" value="session영역저장" onclick="formSubmit(this.form, 1);"/>
		<input type="button" value="session영역삭제" onclick="formSubmit(this.form, 2);"/>
		<input type="button" value="session전체삭제" onclick="formSubmit(this.form, 3);"/>
	</form>
</body>
</html>