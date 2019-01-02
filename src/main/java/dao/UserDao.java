package dao;

import entity.User;
import utils.JdbcUtil;
import java.sql.*;


public class UserDao {

    private static Connection conn = null;
    private static UserDao userDaoSingle = null;

    private UserDao() {
        try {
            conn = JdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加synchronized同步锁或是用同步代码块对类加同步锁.
     * 使用双重检查进一步做了优化，可以
     * 避免整个方法被锁，只对需要锁的代码部分加锁，可以提高执行效率
     * @return
     */
    public static UserDao getInstance() {
        if(userDaoSingle == null) {
            synchronized (UserDao.class) {
                if(userDaoSingle == null) {
                    userDaoSingle = new UserDao();
                }
            }
        }

        return userDaoSingle;
    }

    public User search(String username) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from ur_user where username=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("birthday"),
                        rs.getString("nickname"),
                        rs.getString("sex"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("personalized_signature"),
                        rs.getString("personal_introduce"),
                        rs.getString("profession_introduce"),
                        rs.getString("pic"),
                        rs.getString("love_introduce"),
                        rs.getString("goal_introduce"),
                        rs.getString("reg_date"),
                        rs.getString("update_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            JdbcUtil.release(null,pstmt,rs);
        }

        return null;
    }

    /**
     * 使用用户的账户和密码检验该用户是否是合法成员
     * @param username
     * @param password
     * @return
     */
    public boolean checkUserAccount(String username,String password) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from ur_user where username=? and password=?";

        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                return true;
            }

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    /**
     * 使用用户的账户检验该用户是否存在数据库
     * @param username
     * @return
     */
    public boolean checkUserAccount(String username) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from ur_user where username=?";

        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                return true;
            }

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    /**
     * <p>该方法作为第一次注册时，使用插入到数据库</p>
     * @param user
     * @return
     */
    public boolean insert(User user) {
        PreparedStatement pstmt = null;

        String sql = "insert into `personal_blog`.`ur_user` (`username`,`password`)values(?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());

            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(User user) {
        PreparedStatement pstmt = null;

        String sql = "UPDATE `personal_blog`.`ur_user` SET `nickname`=?,`sex`=?,`phone`=?," +
                "`email`=?,`personalizedSignature`=?,`personalIntroduce`=?," +
                "`professionIntroduce`=?,`loveIntroduce`=?,`goalIntroduce`=? WHERE `username`=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getNickname());
            pstmt.setString(2,user.getSex());
            pstmt.setString(3,user.getPhone());
            pstmt.setString(4,user.getEmail());
            pstmt.setString(5,user.getPersonalizedSignature());
            pstmt.setString(6,user.getPersonalIntroduce());
            pstmt.setString(7,user.getProfessionIntroduce());
            pstmt.setString(8,user.getLoveIntroduce());
            pstmt.setString(9,user.getGoalIntroduce());
            pstmt.setString(10,user.getUsername());
            pstmt.executeUpdate();

            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
