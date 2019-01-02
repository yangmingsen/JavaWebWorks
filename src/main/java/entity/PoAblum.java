package entity;

public class PoAblum extends Entity {
    private Long id;
    private String title;
    private String username;
    private String describe;
    private String updateDate;

    public PoAblum(){}
    public PoAblum(Long id, String title, String username,
                   String describe, String updateDate) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.describe = describe;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}

