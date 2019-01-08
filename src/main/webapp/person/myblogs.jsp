<%@ page import="java.util.List" %>
<%@ page import="entity.AeArticle" %>
<%@ page import="dao.AeArticleDao" %>
<%@ page import="utils.UserStats" %><%--
  Created by IntelliJ IDEA.
  User: yangmingsen
  Date: 2019/1/8
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<AeArticle> lists = AeArticleDao.getInstance().searchs(UserStats.getUsernameBySessionid(request.getSession().getId()));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>操作</th>
    </tr>
    <%
        for (AeArticle article : lists) {
            System.out.println("title = "+article.getTitle());
    %>
    <tr>
        <td><%=article.getId()%></td>
        <td><%=article.getTitle()%></td>
        <td><a href="/blog/update?id=<%=article.getId()%>">操作</a></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
