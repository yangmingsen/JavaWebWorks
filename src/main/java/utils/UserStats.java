package utils;

import entity.User;

import javax.servlet.http.*;
import java.util.*;

public class UserStats implements HttpSessionListener {

    private static final String USER_INFO = "userInfo";
    private static final String USERNAME = "username";

    //用户名和SeesionId绑定
    private static final Map<String,String> USERID_SESSIONID = new HashMap<String,String>();
    //SessionID和HttpSeesion绑定
    private static final Map<String, HttpSession> SEESIONID_HTTPSESSION = new HashMap<String,HttpSession>();

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        synchronized (this) {
            HttpSession session = getHttpSeesion(se.getSession().getId());
            User user = (User)session.getAttribute(USER_INFO);

            String username = user.getUsername();
            getSessionHttpSeesionMap().remove(se.getSession().getId());
            getUserSeesionMap().remove(username);
        }

    }

    public static boolean addUser(String username,HttpSession session) {
        try {
            //将用户名与seesionId绑定
            USERID_SESSIONID.put(username,session.getId());

            //将seesionID与httpSeesionId绑定
            SEESIONID_HTTPSESSION.put(session.getId(),session);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 更新SEESION_HTTPSEESION信息
     * @param session
     * @return
     */
    public static boolean updateUser(HttpSession session) {

        try {
            String seesionId = session.getId();
            getSessionHttpSeesionMap().put(seesionId,session);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *以用户名方式检测用户是否在服务器中存在 如果存在返回true 不存在返回false
     * @param username
     * @return
     */
    public static boolean checkUserExsit(String username) {
        return USERID_SESSIONID.containsKey(username);
    }


    /**
     * 以sessionid方式检测用户在服务器中是否存在 在 SESSION_HTTPSESSION中
     * @param sessionid
     * @return
     */
    public static boolean checkSessionExsit(String sessionid) {
        return getSessionHttpSeesionMap().containsKey(sessionid);
    }


    /**
     * 获取所有Seesion列表
     * @return
     */
    public static List<HttpSession> getSeesionsList() {

        List<HttpSession> sessions = new ArrayList<HttpSession>();

        Iterator<String> iter = getSessionMapKeySetIt();
        while (iter.hasNext()) {
            String key = iter.next();
            HttpSession session = getSessionHttpSeesionMap().get(key);
            sessions.add(session);
        }
        return sessions;

    }

    /**
     * 根据用户的请求信息销毁用户
     * 前提是在request中必须包含 username属性，而且username必须是在UserStats中存在的，不然会出现异常
     * @param
     * @return
     */
    public static synchronized boolean removeUser(String username) {

        try {
            String sessionid = getSessionidByUsername(username);
            getUserSeesionMap().remove(username);
            getSessionHttpSeesionMap().remove(sessionid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 通过用户名获取sessionid
     * @param username username
     * @return
     */
    public static String getSessionidByUsername(String username) {
        return getUserSeesionMap().get(username);
    }

    /**
     * 通过servelt传来的sessionid查找保存在服务器的username
     * @param sessionid sessionid
     * @return
     */
    public static String getUsernameBySessionid(String sessionid) {

        HttpSession session = getSessionHttpSeesionMap().get(sessionid);
        if(session == null) return null;

        User user = (User)session.getAttribute(USER_INFO);
        return user.getUsername();

    }

    /**
     * 获取某个用户的HttpSeeion信息
     * @param sessionid sessionid
     * @return
     */
    public static HttpSession getHttpSeesion(String sessionid) {
        return getSessionHttpSeesionMap().get(sessionid);
    }

    /**
     *获取sessionid和HttpSession的绑定Map
     * @return
     */
    public static Map<String,HttpSession> getSessionHttpSeesionMap() {
        return SEESIONID_HTTPSESSION;
    }

    public static Iterator<String> getSessionMapKeySetIt() {
        return getSessionHttpSeesionMap().keySet().iterator();
    }


    /**
     * 获取username和sessionid的绑定Map
     * @return
     */
    public static Map<String,String> getUserSeesionMap() {
        return USERID_SESSIONID;
    }


}
