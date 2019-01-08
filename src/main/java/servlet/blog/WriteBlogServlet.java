package servlet.blog;

import dao.AeArticleDao;
import entity.AeArticle;
import utils.DateHelpler;
import utils.SimulateSession;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Detail;
import java.io.IOException;

@WebServlet(name = "WriteBlogServlet",urlPatterns = "/blog/write")
public class WriteBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        //如果status=0那么执行插入操作；如果为1则执行修改操作
        String status = request.getParameter("status");
        String username = UserStats.getUsernameBySessionid(request.getSession().getId());
        String blogTitle = request.getParameter("blog-title");
        String blogMarkdownDoc = request.getParameter("blog-markdown-doc");
        String blogContent = request.getParameter("blog-content");

        if(status.equals("0")) {
            Long id = generateId();
            String writeDate = DateHelpler.getDateMatchOne();

            AeArticle article = new AeArticle(id,username,blogTitle,blogContent,writeDate,writeDate,blogMarkdownDoc);
            AeArticleDao.getInstance().insert(article);

            response.sendRedirect("/blogDetail.jsp?id="+id);
        } else if (status.equals("1")) {
            String id = request.getParameter("blogId");

            String udpateDate = DateHelpler.getDateMatchOne();
            AeArticle article = new AeArticle(Long.parseLong(id),username,blogTitle,blogContent,udpateDate,blogMarkdownDoc);
            AeArticleDao.getInstance().update(article);

            response.sendRedirect("/blogDetail.jsp?id="+id);
        }



    }

    /**
     * 这个方法存在一定问题，当出现并发时可能会失常
     */
    public static synchronized Long generateId() {
        return System.currentTimeMillis();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
