package servlet.user;

import com.google.gson.Gson;
import dao.UserDao;
import entity.Result;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",urlPatterns = "/user/register")
public class RegisterServlet extends HttpServlet {
    /**
     * <p>1.获取username,password</p>
     * <p>2.插入数据到ur_user表中</p>
     * <p>3.如果插入成功返回{"status":1,"message":"成功"}
     *  如果失败返回{"status":0,"message":"失败"}
     * </p>
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username,password);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String jsonStr = null;
        Result result = null;

        if (UserDao.getInstance().insert(user)) {
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
