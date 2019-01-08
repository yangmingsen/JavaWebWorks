package servlet.user;

import com.google.gson.Gson;
import dao.PoAblumDao;
import entity.PoAblum;
import entity.Result;
import utils.DateHelpler;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateGalleryServlet",urlPatterns = "/user/update/galleryInfo")
public class UpdateGalleryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = UserStats.getUsernameBySessionid(request.getSession().getId());
        String title = request.getParameter("title");
        String describe = request.getParameter("describe");
        String updateDate = DateHelpler.getDateMatchOne();

        PoAblum ablum = new PoAblum(username,title,describe,updateDate);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String jsonStr = null;
        Result result = null;

        if (PoAblumDao.getInstance().update(ablum)) {
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
