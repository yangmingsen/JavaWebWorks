package servlet;

import dao.PoAblumDao;
import dao.PoPhotoDao;
import entity.PoAblum;
import entity.PoPhoto;
import entity.group.GalleryGroup;
import utils.SimulateSession;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GalleryServlet",urlPatterns = "/gallery")
public class GalleryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.登录
        //2.获取username,根据username去po_album表查询画廊信息，然后在根据username去po_photo表中查询最新的6张上传照片。

        String username = UserStats.getUsernameBySessionid(request.getSession().getId());

        PoAblum ablum = PoAblumDao.getInstance().search(username);
        List<PoPhoto> photos = PoPhotoDao.getInstance().searchs(username);

        GalleryGroup gallery = new GalleryGroup(ablum,photos);

        request.setAttribute("gallery",gallery);

        request.getRequestDispatcher("/gallery.jsp").forward(request,response);

    }
}
