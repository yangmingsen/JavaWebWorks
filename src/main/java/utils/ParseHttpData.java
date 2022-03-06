package utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ParseHttpData {
    public static void parse(HttpServletRequest request) throws ServletException, IOException {
        //Header部分
        System.out.println("========================================================");
        System.out.print(request.getHeaderNames());
        Enumeration<?> enum1 = request.getHeaderNames();
        while (enum1.hasMoreElements()) {
            String key = (String) enum1.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + "\t" + value);
        }
        System.out.println();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String pName = parameterNames.nextElement();
            String pValue = request.getParameter(pName);
            System.out.println(pName+"\t"+pValue);
        }
        System.out.println("========================================================");

    }
}
