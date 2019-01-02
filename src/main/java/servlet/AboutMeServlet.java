package servlet;

import dao.UserDao;
import entity.User;
import utils.SimulateSession;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AboutMeServlet",urlPatterns = "/about")
public class AboutMeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 1.先判断是否登录
     * 2.如果未登录跳转到登录界面
     * 3.根据用户名username获取该用户相关信息
     * 4.将用户相关信息保存到request.setArribute()中然后跳转到about.jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimulateSession.simulateLogin(request);//模拟登陆
        //如果不存在sessionid
        if (! UserStats.checkSessionExsit(request.getSession().getId())) {
            request.getRequestDispatcher("login.html").forward(request,response);

        } else {
            String username = UserStats.getUsernameBySessionid(request.getSession().getId());
            User user = UserDao.getInstance().search(username);
            request.setAttribute("UserInfo",user);

            request.getRequestDispatcher("/about.jsp").forward(request,response);

        }
    }
}
