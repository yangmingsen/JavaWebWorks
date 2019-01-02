<%--
  Created by IntelliJ IDEA.
  User: yangmingsen
  Date: 2018/12/28
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/photo/uploads" enctype="multipart/form-data" method="post">
        <input type="file" name="file" multiple="multiple" ><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
