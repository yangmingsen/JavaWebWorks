package servlet.photo;

import dao.PoPhotoDao;
import entity.PoPhoto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.DateHelpler;
import utils.FastDFSClient;
import utils.SimulateSession;
import utils.UserStats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "PhotoUploadsServlet",urlPatterns = "/gallery/upload")
public class PhotoUploadsServlet extends HttpServlet {
    private static final long serialVersionUID = -4187075130535308117L;
    private boolean isMultipart;
    private int maxFileSize = 1024 * 1024 * 10;
    private int maxMemSize = 100 * 1024;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.检查用户必须登录，如果没有登录提示必须登录  这一步Filter做
        //2.获取username
        String username = UserStats.getUsernameBySessionid(request.getSession().getId());
        List<PoPhoto> lists = new ArrayList<PoPhoto>();
        //3.上传图片到FastDFS中，并将图片地址存入PoPhoto中
        //4.然后跳转到画廊界面

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 检查是否有一个文件上传请求
        isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            System.out.println("未获取到文件"+"在PhotoUploadServlet.java中");
            out.write("未获取到文件在PhotoUploadServlet.java中");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 文件大小的最大值将被存储在内存中
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        String path = getServletContext().getRealPath("/images")+"/";
        factory.setRepository(new File(path));
        // 创建一个新的文件上传处理程序
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 允许上传的文件大小的最大值
        //upload.setSizeMax(maxFileSize);

        String fileUrl = null;
        try {
            // 解析请求，获取文件项
            List fileItems = upload.parseRequest(request);
            // 处理上传的文件项
            Iterator i = fileItems.iterator();
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // 获取上传文件的参数
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String suffix = fileName.substring(fileName.indexOf(".")+1);
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    FastDFSClient dfsClient = new FastDFSClient("classpath:config/fdfs_client.conf");

                    String filePath = dfsClient.uploadFile(fi.get(),suffix);
                    fileUrl = "http://192.168.25.133/"+filePath;

                    String date = DateHelpler.getDateMatchOne();
                    lists.add(new PoPhoto(username,fileUrl,date));

                }
            }

        } catch (Exception ex) {
            System.out.println("异常在PhotoUploadServlet.java中");
            out.write("<h1>上传错误!!!</h1>");
            return;
        }

        //存入数据库中
        PoPhotoDao.getInstance().insert(lists);

        out.write("<h1>上传成功!!!</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
