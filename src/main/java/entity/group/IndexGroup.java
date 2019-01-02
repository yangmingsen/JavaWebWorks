package entity.group;

import entity.AeArticle;
import entity.Entity;
import entity.User;

public class IndexGroup extends Entity {
    private AeArticle article;
    private User user;
    private int commentNum;

    public IndexGroup() { }

    public IndexGroup(AeArticle article, User user, int commentNum) {
        this.article = article;
        this.user = user;
        this.commentNum  =commentNum;
    }

    public AeArticle getArticle() {
        return article;
    }

    public void setArticle(AeArticle article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
}
