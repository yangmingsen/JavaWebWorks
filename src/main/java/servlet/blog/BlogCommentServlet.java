package servlet.blog;

import com.google.gson.Gson;
import dao.AeCommentDao;
import entity.AeArticle;
import entity.AeComment;
import entity.Result;
import utils.DateHelpler;
import utils.SimulateSession;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BlogCommentServlet",urlPatterns = "/blog/comment")
public class BlogCommentServlet extends HttpServlet {
    /**
     * <p>1.先获取用户评论信息,然后通过session信息获取username,获取blogId</p>
     * <p>2.添加到数据库中</p>
     * <p>3.返回状态给前台</p>
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username = UserStats.getUsernameBySessionid(request.getSession().getId());
        String articleId = request.getParameter("blogId");
        String content = request.getParameter("comment");
        String date = DateHelpler.getDateMatchOne();

        AeComment comment = new AeComment(articleId,username,content,date);


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String jsonStr = null;
        Result result = null;

        if (AeCommentDao.getInstance().insert(comment)) {
            result = new Result(1,"成功");
            jsonStr = gson.toJson(result,Result.class);
        } else {
            result = new Result(0,"失败");
            jsonStr = gson.toJson(result,Result.class);
        }
        out.write(jsonStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
