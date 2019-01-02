package dao;

import entity.CtContact;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CtContactDao {
    private static Connection conn = null;
    private static CtContactDao contactDaoSingle = null;

    private CtContactDao() {
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
    public static CtContactDao getInstance() {
        if(contactDaoSingle == null) {
            synchronized (CtContactDao.class) {
                if(contactDaoSingle == null) {
                    contactDaoSingle = new CtContactDao();
                }
            }
        }

        return contactDaoSingle;
    }

    public boolean insert(CtContact contact) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO ct_contact (`from`,`to`,`subject`,message,date)VALUES(?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,contact.getFrom());
            pstmt.setString(2,contact.getTo());
            pstmt.setString(3,contact.getSubject());
            pstmt.setString(4,contact.getMessage());
            pstmt.setString(5,contact.getDate());

            pstmt.executeUpdate();

            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtil.release(null,pstmt,null);
        }
    }
}
