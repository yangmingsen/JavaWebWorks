package servlet.user;

import com.google.gson.Gson;
import dao.UserDao;
import entity.Result;
import entity.User;
import utils.DateHelpler;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateUserServlet",urlPatterns = "/user/update")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = UserStats.getUsernameBySessionid(request.getSession().getId());
        String nickname = request.getParameter("nickname");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String personalizedSignature = request.getParameter("personalizedSignature");
        String personalIntroduce = request.getParameter("personalIntroduce");
        String professionIntroduce = request.getParameter("professionIntroduce");
        String loveIntroduce = request.getParameter("loveIntroduce");
        String goalIntroduce = request.getParameter("goalIntroduce");
        String updateDate = DateHelpler.getDateMatchOne();

        User user = new User(username,nickname,sex,phone,email,personalizedSignature,
                personalIntroduce,professionIntroduce,loveIntroduce,goalIntroduce,updateDate);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String jsonStr = null;
        Result result = null;

        if (UserDao.getInstance().update(user)) {
            result = new Result(1,"success");
            jsonStr = gson.toJson(result,Result.class);
        } else {
            result = new Result(0,"failed");
            jsonStr = gson.toJson(result,Result.class);
        }
        out.write(jsonStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
