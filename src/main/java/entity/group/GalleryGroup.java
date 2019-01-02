package entity.group;

import entity.Entity;
import entity.PoAblum;
import entity.PoPhoto;

import java.util.List;

public class GalleryGroup extends Entity {
    private PoAblum ablum;
    private List<PoPhoto> photos;

    public GalleryGroup(){}

    public GalleryGroup(PoAblum ablum, List<PoPhoto> photos) {
        this.ablum = ablum;
        this.photos = photos;
    }

    public PoAblum getAblum() {
        return ablum;
    }

    public void setAblum(PoAblum ablum) {
        this.ablum = ablum;
    }

    public List<PoPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PoPhoto> photos) {
        this.photos = photos;
    }
}
