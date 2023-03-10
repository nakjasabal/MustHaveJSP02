<%@page import="java.util.UUID"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int maxPostSize = 1024 * 1000;
String encoding = "UTF-8";
String saveDirectory = application.getRealPath("/Uploads");  // 저장할 디렉터리
File saveDir = new File(saveDirectory);

DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
fileItemFactory.setRepository(saveDir);
fileItemFactory.setSizeThreshold(maxPostSize);
ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
 
try{
	List<FileItem> params = servletFileUpload.parseRequest(request);
	for(FileItem fileItem : params){
		if(fileItem.isFormField()){
			String title = fileItem.getString(encoding);
			out.println("파일외폼값:"+ title +"<br>");
			String fieldName = fileItem.getFieldName();
			out.println("fieldName:"+ fieldName +"<br>");
		}
		else{
			String fileName = fileItem.getName();
			out.println("파일명:"+ fileName +"<br>");
			
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String ext = fileName.substring(fileName.lastIndexOf('.'));
			String newFileName = uuid + ext;
			
			File uploadFile = new File(saveDir +  File.separator + newFileName);
			fileItem.write(uploadFile);
		}
	}
	
	response.sendRedirect("MultiFileList.jsp");
}
catch(Exception e){
	e.printStackTrace();
	request.setAttribute("errorMessage", "파일 업로드 오류");
    request.getRequestDispatcher("MultiFileUploadMain.jsp").forward(request, response);
} 
%>