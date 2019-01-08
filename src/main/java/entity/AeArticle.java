package entity;

public class AeArticle extends Entity{
    private Long id;
    private String username;
    private String title;
    private String content;
    private String markdownDoc;
    private String articlePhoto;//暂时先不用
    private String category;//暂时不用
    private String writeDate;
    private String updateDate;

    public AeArticle() {    }

    public AeArticle(Long id,String username, String title,
                     String content, String updateDate,String markdownDoc) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.updateDate = updateDate;
        this.markdownDoc = markdownDoc;
    }

    public AeArticle(Long id, String username, String title, String content,
                     String writeDate, String updateDate, String markdownDoc) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.markdownDoc = markdownDoc;
        this.writeDate = writeDate;
        this.updateDate = updateDate;
    }

    public AeArticle(Long id, String username,
                     String title, String content,
                     String articlePhoto, String category,
                     String writeDate, String updateDate,String markdownDoc) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.articlePhoto = articlePhoto;
        this.category = category;
        this.writeDate = writeDate;
        this.updateDate = updateDate;
        this.markdownDoc = markdownDoc;
    }

    public String getMarkdownDoc() {
        return markdownDoc;
    }

    public void setMarkdownDoc(String markdownDoc) {
        this.markdownDoc = markdownDoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArticlePhoto() {
        return articlePhoto;
    }

    public void setArticlePhoto(String articlePhoto) {
        this.articlePhoto = articlePhoto;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
