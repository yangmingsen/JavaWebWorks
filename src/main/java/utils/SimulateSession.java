package utils;

import dao.UserDao;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SimulateSession {

    public static void simulateLogin(HttpServletRequest request) {

        String username = "yangmingsen";
        if (!UserStats.checkUserExsit(username)) {
            User tmpUser = UserDao.getInstance().search(username);
            System.out.println("不存在");
            //保存Session
            HttpSession session = request.getSession();
            session.setAttribute("userInfo",tmpUser);
            UserStats.addUser(username,session);
        }

    }


}
