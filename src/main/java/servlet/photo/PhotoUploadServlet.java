package servlet.photo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.FastDFSClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "PhotoUploadServlet",urlPatterns = "/blog/photo/upload")
public class PhotoUploadServlet extends HttpServlet {

    private static final long serialVersionUID = -4187075130535308117L;
    private boolean isMultipart;
    private int maxFileSize = 1024 * 1024 * 10;
    private int maxMemSize = 100 * 1024;

    protected void doPost(HttpServletRequest request, HttpServletResponse response
                          ) throws ServletException, IOException {
        // 检查是否有一个文件上传请求
        isMultipart = ServletFileUpload.isMultipartContent(request);
        String result = "";
        response.setContentType("text/html;charset=utf-8");
        if (!isMultipart) {
            result = "未获取到文件";
            System.out.println(result+"在PhotoUploadServlet.java中");
            response.getWriter().write( "{\"success\":0}" );
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
        upload.setSizeMax(maxFileSize);

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
                }
            }
            response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\""+fileUrl+"\"}" );

        } catch (Exception ex) {
            response.getWriter().write( "{\"success\":0}" );
            System.out.println("异常在PhotoUploadServlet.java中");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
