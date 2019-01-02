package dao;

import entity.PoPhoto;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoPhotoDao {
    private static Connection conn = null;
    private static PoPhotoDao photoDaoSingle = null;

    private PoPhotoDao() {
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
    public static PoPhotoDao getInstance() {
        if(photoDaoSingle == null) {
            synchronized (PoPhotoDao.class) {
                if(photoDaoSingle == null) {
                    photoDaoSingle = new PoPhotoDao();
                }
            }
        }

        return photoDaoSingle;
    }

    public boolean insert(List<PoPhoto> lists) {
        PreparedStatement pstmt = null;

        String sql = "insert into po_photo (username,photo_addr,date)values(?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            for (PoPhoto photo : lists) {
                pstmt.setString(1,photo.getUsername());
                pstmt.setString(2,photo.getPhotoAddr());
                pstmt.setString(3,photo.getDate());
                pstmt.addBatch();
            }

            pstmt.executeBatch();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtil.release(null,pstmt,null);
        }

    }

    /**
     * 根据username搜索所有关于该username对应的实体。<br>
     * 如果结果的size为0。表示未查询到任何数据。<br>
     * 如果结果为null，表示出现<strong>异常</strong>
     * @return List
     */
    public List<PoPhoto> searchs(String username) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<PoPhoto> lists = new ArrayList<PoPhoto>();

        String sql = "SELECT * FROM po_photo ORDER BY po_photo.date DESC LIMIT 0,6";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                lists.add(new PoPhoto(
                        rs.getString("username"),
                        rs.getString("photo_addr"),
                        rs.getString("date")));
            }
            return lists;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            JdbcUtil.release(null,pstmt,rs);
        }

    }
}
