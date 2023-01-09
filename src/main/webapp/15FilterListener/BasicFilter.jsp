<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	function formSubmit(f, met){
		if(met==1){
			f.method="get";			
		}
		else if(met==2){
			f.method="post";		
		}
		f.submit();
	}
	</script>
	<form>
		<input type="button" value="Get" onclick="formSubmit(this.form, 1);" />
		<input type="button" value="Post" onclick="formSubmit(this.form, 2);" />
	</form>
</body>
</html>