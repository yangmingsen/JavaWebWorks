package servlet;

import dao.CtContactDao;
import entity.CtContact;
import utils.DateHelpler;
import utils.Mail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContactServlet",urlPatterns = "/contact")
public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String fromEmail = request.getParameter("from");
        String toEmail = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        String date = DateHelpler.getDateMatchOne();

        CtContact contact = new CtContact(fromEmail,toEmail,subject,message,date);
        CtContactDao.getInstance().insert(contact);//插入发送信息到数据库中
        boolean res = Mail.send(contact);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (res) {
            out.write("<h1>发送成功</h1>");
        } else {
            out.write("<h1>发送失败</h1>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
