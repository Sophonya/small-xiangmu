<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body style="background-color:LightSteelBlue">
      <table border="1" width="80%">
      <tr>
      <td>类别名称</td>
      <td>类别描述</td>
      <td>操作</td>
      </tr>
      <c:forEach var="c" items="${clist}">
      <tr>
      <td>${c.name}</td>
      <td>${c.mark}</td>
     
      <td>
      		<a href="CategoryServlet?op=toUpdate&id=${c.id}">修改</a>
	 		<a href="CategoryServlet?op=del&id=${c.id}" onclick="return confirm('是否删除？')"/>删除</a>
	 </td>
	 </tr>
     </c:forEach>
     </table>
</body>
</body>
</html>