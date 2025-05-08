<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Result</title>
</head>
<body bgcolor="aqua">
<c:choose>
    <c:when test="${status eq 1}">
        <h1 style='color:green; text-align:center;'>Inserted Successfully...</h1>
    </c:when>
    <c:otherwise>
        <h1 style='color:red; text-align:center;'>Insertion Failed...</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
