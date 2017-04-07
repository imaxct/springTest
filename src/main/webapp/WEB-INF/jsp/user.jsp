<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-4-6
  Time: 下午8:41
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<c:if test="${not empty user}">
    <p>${user.id}</p>
    <p>${user.username}</p>
</c:if>
</body>
</html>
