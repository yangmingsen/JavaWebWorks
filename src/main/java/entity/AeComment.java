package entity;

public class AeComment extends Entity {
    private Long id;
    private String articleId;
    private String username;
    private String content;
    private String date;

    public AeComment(){}
    public AeComment(Long id, String articleId, String username,
                     String content, String date) {
        this.id = id;
        this.articleId = articleId;
        this.username = username;
        this.content = content;
        this.date = date;
    }

    public AeComment(String articleId, String username, String content, String date) {
        this.articleId = articleId;
        this.username = username;
        this.content = content;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
