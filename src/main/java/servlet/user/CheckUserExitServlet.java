package servlet.user;

import com.google.gson.Gson;
import dao.UserDao;
import entity.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckUserExitServlet",urlPatterns = "/user/check")
public class CheckUserExitServlet extends HttpServlet {
    /**
     * 1.先获取用户名
     * <p>2.然后根据用户名去数据库查ur_user表查找该用户是否存在</p>
     * <p>3.如果存在返回{"status":1,"message":"存在"}</p>
     * <p>如果不存在返回{"status":0,message:"不存在"}</p>
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String jsonStr = null;
        Result result = null;
        boolean userExsit = UserDao.getInstance().checkUserAccount(username);

        if (userExsit) {
            result = new Result(1,"存在");
            jsonStr = gson.toJson(result,Result.class);
        } else {
            result = new Result(0,"不存在");
            jsonStr = gson.toJson(result,Result.class);
        }

        out.write(jsonStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
