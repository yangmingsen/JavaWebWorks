package servlet.blog;

import dao.AeArticleDao;
import entity.AeArticle;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateBlogServlet",urlPatterns = "/blog/update")
public class UpdateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        String username = UserStats.getUsernameBySessionid(request.getSession().getId());

        AeArticle article = AeArticleDao.getInstance().search(Long.parseLong(id));

        request.setAttribute("article",article);
        request.getRequestDispatcher("/blogEdit.jsp").forward(request,response);

    }
}
