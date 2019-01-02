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
import java.io.IOException;

@WebServlet(name = "WriteBlogServlet",urlPatterns = "/blog/write")
public class WriteBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimulateSession.simulateLogin(request);//模拟登陆

        request.setCharacterEncoding("utf-8");

        //如果不存在sessionid
        if (! UserStats.checkSessionExsit(request.getSession().getId())) {
            request.getRequestDispatcher("login.html").forward(request,response);

        } else {

            Long id = generateId();
            String username = UserStats.getUsernameBySessionid(request.getSession().getId());
            String blogTitle = request.getParameter("blog-title");
            String blogContent = request.getParameter("blog-content");
            String writeDate = DateHelpler.getDateMatchOne();

            AeArticle article = new AeArticle(id,username,blogTitle,blogContent,writeDate,writeDate);
            AeArticleDao.getInstance().insert(article);

            response.sendRedirect("/blogDetail.jsp?id="+id);

        }

    }

    //这个方法存在一定问题，当出现并发时可能会失常
    public static synchronized Long generateId() {
        return System.currentTimeMillis();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
