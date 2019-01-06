package dao;

import entity.PoAblum;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PoAblumDao {
    private static Connection conn = null;
    private static PoAblumDao ablumDaoSingle = null;

    private PoAblumDao() {
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
    public static PoAblumDao getInstance() {
        if(ablumDaoSingle == null) {
            synchronized (PoAblumDao.class) {
                if(ablumDaoSingle == null) {
                    ablumDaoSingle = new PoAblumDao();
                }
            }
        }

        return ablumDaoSingle;
    }

    /**
     * 根据传入的username查询对应的实体信息,返回一个PoAblum
     * @param username
     * @return
     */
    public PoAblum search(String username) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from po_album where username=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                return new PoAblum(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("username"),
                        rs.getString("describe"),
                        rs.getString("update_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtil.release(null,pstmt,rs);
        }

        return null;
    }

    /**
     * 默认初始化用户是建立(注册用户后使用)
     * @param username
     * @return
     */
    public boolean insert(String username) {
        PreparedStatement pstmt = null;
        String sql = "insert into po_album (username)values(?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);

            int x = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtil.release(null,pstmt,null);
        }

        return true;

    }


}
