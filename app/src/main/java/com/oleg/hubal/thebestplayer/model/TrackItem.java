package com.oleg.hubal.thebestplayer.model;

/**
 * Created by User on 22.11.2016.
 */

public class TrackItem extends SelectableItem {

    private String albumImage;
    private String artist;
    private String title;

    public TrackItem(String albumImage, String artist, String title) {
        this.albumImage = albumImage;
        this.artist = artist;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }
}
