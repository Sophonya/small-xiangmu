<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<Font size=2>
<p align="center" class="STYLE6">添加商品类别</p>
</Font>
<CENTER>
<form name="form1" method="post" action="CategoryServlet" onSubmit="return mycheck(form1)">
			<input type="hidden" name="op" value="add"/>

 类别名称：<input type="text" name="name"/><br>
  类别描述：<input type="text" name="mark"/><br>
   <table width="165">
 <tr><td width="42" wnameth="42"> <input type="submit" value="添加"/><br>
  <td width="28" wnameth="50">&nbsp;</td>
  <td width="42" wnameth="50"><Input type="reset" name="h" value="重置"></td>
     <td width="33" wnameth="42">&nbsp;</td>
  </table>
  </form>
  </CENTER>
  </body>
</body>
</html>