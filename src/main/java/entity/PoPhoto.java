package entity;

public class PoPhoto extends Entity {
    private Long id;
    private String username;
    private String photoAddr;
    private String date;

    public PoPhoto() {}

    public PoPhoto(Long id, String username, String photoAddr, String date) {
        this.id = id;
        this.username = username;
        this.photoAddr = photoAddr;
        this.date = date;
    }

    public PoPhoto(String username, String photoAddr, String date) {
        this.username = username;
        this.photoAddr = photoAddr;
        this.date = date;
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

    public String getPhotoAddr() {
        return photoAddr;
    }

    public void setPhotoAddr(String photoAddr) {
        this.photoAddr = photoAddr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
