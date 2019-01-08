package dao;

import entity.AeArticle;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AeArticleDao {
    private static Connection conn = null;
    private static AeArticleDao articleDaoSingle = null;

    private AeArticleDao() {
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
    public static AeArticleDao getInstance() {
        if(articleDaoSingle == null) {
            synchronized (AeArticleDao.class) {
                if(articleDaoSingle == null) {
                    articleDaoSingle = new AeArticleDao();
                }
            }
        }

        return articleDaoSingle;
    }


    public boolean insert(AeArticle article) {
        PreparedStatement pstmt = null;
        String sql = "insert into ae_article (id,username,title,content,markdown_doc,write_date)values(?,?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1,article.getId());
            pstmt.setString(2,article.getUsername());
            pstmt.setString(3,article.getTitle());
            pstmt.setString(4,article.getContent());
            pstmt.setString(5,article.getMarkdownDoc());
            pstmt.setString(6,article.getWriteDate());

            int x = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtil.release(null,pstmt,null);
        }

        return true;

    }

    public AeArticle search(Long id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from ae_article where id=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1,id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                return new AeArticle(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("content"),
                        null,
                        null,
                        rs.getString("write_date"),
                        rs.getString("update_date"),
                        rs.getString("markdown_doc"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            JdbcUtil.release(null,pstmt,rs);
        }

        return null;
    }

    public List<AeArticle> searchs(String username) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ae_article WHERE `username`=? ORDER BY ae_article.update_date DESC";

        List<AeArticle> lists = new ArrayList<AeArticle>();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                lists.add(new AeArticle(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("content"),
                        null,
                        null,
                        rs.getString("write_date"),
                        rs.getString("update_date"),
                        rs.getString("markdown_doc")));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtil.release(null,pstmt,rs);
        }

        return lists;
    }

    public List<AeArticle> getAearticlePart() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ae_article ORDER BY ae_article.update_date DESC LIMIT 0,5";

        List<AeArticle> lists = new ArrayList<AeArticle>();

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                lists.add(new AeArticle(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("content"),
                        null,
                        null,
                        rs.getString("write_date"),
                        rs.getString("update_date"),
                        rs.getString("markdown_doc")));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtil.release(null,pstmt,rs);
        }

        return lists;
    }

    public boolean update(AeArticle article) {
        PreparedStatement pstmt = null;
        String sql = "UPDATE `personal_blog`.`ae_article` SET `title` = ?, `content` = ?, `update_date` = ?,`markdown_doc`=? WHERE `id` = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,article.getTitle());
            pstmt.setString(2,article.getContent());
            pstmt.setString(3,article.getUpdateDate());
            pstmt.setString(4,article.getMarkdownDoc());
            pstmt.setLong(5,article.getId());

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
