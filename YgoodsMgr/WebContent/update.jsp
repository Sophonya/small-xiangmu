<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<form name="form1" method="post" action="CategoryServlet?op=update&id=${c.id}">
  类别名称：<input type="text" name="name" value="${c.name}"/><br>
  类别描述：<input type="text" name="mark" value="${c.mark}"/><br>
     <input type="submit" value="修改"/><br>
  </form>
  </body>
</body>
</html>