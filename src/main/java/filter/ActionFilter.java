package filter;

import utils.UserStats;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ActionFilter implements Filter {
    private String excludedPage;
    private String excludedStaticResource;
    private String[] excludedPages;
    private String[] excludedStaticResources;
    private String[] excludedResources = {".jpg",".js",".css",".html",".eot",
            ".woff",".svg",".ttf",".otf",".woff2",".ico",".png",".gif","json"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPage = filterConfig.getInitParameter("excludedPages");
        excludedStaticResource = filterConfig.getInitParameter("excludedStaticResources");

        if (excludedPage != null && excludedPage.length() > 0){
            excludedPages = excludedPage.split(",");
        }

        if (excludedStaticResource != null && excludedStaticResource.length() > 0){
            excludedStaticResources = excludedStaticResource.split(",");
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

        System.out.println("sessionid = "+((HttpServletRequest) request).getSession().getId());

        if(checkUrlPageIsExcluded(req)) {
            chain.doFilter(req,resp);
        } else {
            if (!checkUserLogin(req)) {
                ((HttpServletResponse) response).sendRedirect("/login.jsp");
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
        System.out.println("req.getServletPath() = "+req.getServletPath());
        for (String excluded : excludedPages) {
            if (req.getServletPath().equals(excluded) ) {
                return true;
            }
        }

        if(checkIsStaticResources(req.getServletPath())) {
            return true;
        }

        return false;
    }

    /**
     * 过滤掉一些静态资源不用拦截
     * @param resourcesPath
     * @return
     */
    public boolean checkIsStaticResources(String resourcesPath) {

        for(String path : excludedStaticResources) {
            if(resourcesPath.contains(path)) {
                return true;
            }
        }

//        for (String suffix : excludedResources) {
//            if(resourcesPath.endsWith(suffix) ) {
//                return true;
//            }
//        }

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
