<%@page import="java.io.File"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.util.List"%>
<%@ page import="fileupload.MyFileDAO"%>
<%@ page import="fileupload.MyFileDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>MultiFileUpload</title></head>
<body>
    <h2>디렉토리에 저장된 파일 목록 보기</h2>
    <a href="MultiFileUploadMain.jsp">다중 파일 등록하기</a>
    <%
    String saveDirectory = application.getRealPath("/Uploads");
	File file = new File(saveDirectory);
	File[] fileArray = file.listFiles();
    %>
    <table border="1"> 
        <tr>            
            <th>No</th><th>파일명</th><th>용량</th><th></th>
        </tr>
    <%
    int cnt = 1;
    for (File f : fileArray) {
    %>
        <tr>             
            <td><%= cnt++ %></td>            
            <td><%= f.getName() %></td>            
            <td><%= (int)Math.ceil(f.length()/1024.0) %>KB</td>
            <td><a href="Download.jsp?oName=<%= URLEncoder.encode("원본파일명.jpg","UTF-8") %>&sName=<%= URLEncoder.encode(f.getName(),"UTF-8") %>">[다운로드]</a></td>
        </tr>
    <% } %>
    </table>    
</body>
</html>