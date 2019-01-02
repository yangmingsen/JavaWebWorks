package filter;

import utils.UserStats;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ActionFilter implements Filter {
    private String excludedPage;
    private String[] excludedPages;
    private String[] excludedResources = {".jpg",".js",".css",".html"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPage = filterConfig.getInitParameter("excludedPages");
        if (excludedPage != null && excludedPage.length() > 0){
            excludedPages = excludedPage.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /**
         * 1.先排除掉不用过滤的路径
         * 2.然后在进行用户是否登录检测，如果登录则放行，否则拦截并跳转到登录界面
         */
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        if(checkUrlPageIsExcluded(req)) {
            chain.doFilter(req,resp);
        } else {
            if (!checkUserLogin(req)) {
                req.getRequestDispatcher("login.html").forward(req,resp);
            } else {
                chain.doFilter(req,resp);
            }
        }

    }

    /**
     * 过滤掉 excluded 路径不用拦截
     * @param req
     * @return
     */
    public boolean checkUrlPageIsExcluded(HttpServletRequest req) {
        for (String excluded : excludedPages) {
            if (req.getServletPath().equals(excluded) || checkIsStaticResources(req.getServletPath())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkIsStaticResources(String resourcesPath) {
        for (String suffix : excludedResources) {
            if(resourcesPath.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查用户是否已经登录 以seesionid的方式
     * @param request
     * @return
     */
    public boolean checkUserLogin(HttpServletRequest request) {
        String sessionid =request.getSession().getId();

        if(UserStats.checkSessionExsit(sessionid)) {
            return true;
        }

        return false;
    }

    @Override
    public void destroy() {

    }
}
