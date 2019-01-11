package servlet.user;

import com.google.gson.Gson;
import dao.UserDao;
import entity.Result;
import entity.User;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/user/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String jsonStr = null;
        Result result = null;

        boolean userExsit = UserDao.getInstance().checkUserAccount(username,password);

        if (userExsit) {
            if (!UserStats.checkSessionExsit(request.getSession().getId())) {
                User tmpUser = UserDao.getInstance().search(username);
                //保存Session
                HttpSession session = request.getSession();
                session.setAttribute("userInfo",tmpUser);
                UserStats.addUser(username,session);
            }

            result = new Result(1,"success");
            jsonStr = gson.toJson(result,Result.class);

        } else {
            result = new Result(0,"failed");
            jsonStr = gson.toJson(result,Result.class);
        }

        System.out.println("jsoStr = "+jsonStr);

        out.write(jsonStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
