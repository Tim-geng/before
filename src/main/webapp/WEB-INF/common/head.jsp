<%--
  Created by IntelliJ IDEA.
  User: 耿旭
  Date: 2019/3/29
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
</head>
<body>
    <%
        String bashpath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
                +request.getContextPath();
        pageContext.setAttribute("bashpath",bashpath);
    %>
</body>
</html>
