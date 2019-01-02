package dao;

import entity.AeComment;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AeCommentDao {
    private static Connection conn = null;
    private static AeCommentDao commentDaoSingle = null;

    private AeCommentDao() {
        try {
            conn = JdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AeCommentDao getInstance() {
        if (commentDaoSingle == null) {
            synchronized (AeCommentDao.class) {
                if(commentDaoSingle == null) {
                    commentDaoSingle = new AeCommentDao();
                }
            }
        }
        return commentDaoSingle;
    }

    public boolean insert(AeComment comment) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO ae_comment (`article_id`,`username`,`content`,`date`)VALUES(?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,comment.getArticleId());
            pstmt.setString(2,comment.getUsername());
            pstmt.setString(3,comment.getContent());
            pstmt.setString(4,comment.getDate());

            pstmt.executeUpdate();

            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtil.release(null,pstmt,null);
        }
    }

    /**
     * 根据username搜索所有关于该username的数据
     * @param articleId
     * @return
     */
    public List<AeComment> search(String articleId) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AeComment> lists  = new ArrayList<AeComment>();

        String sql = "select * from ae_comment where `article_id`=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,articleId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                lists.add(new AeComment(
                    rs.getString("article_id"),
                    rs.getString("username"),
                    rs.getString("content"),
                    rs.getString("date")
                ));
            }

            return lists;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
