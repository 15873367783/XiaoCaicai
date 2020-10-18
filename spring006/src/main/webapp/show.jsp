<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${iPge.records}">
        ${dep.depid}${dep.depid}<a href="">删除</a><br>
    </c:forEach>
</body>
</html>
