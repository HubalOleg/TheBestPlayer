package com.oleg.hubal.thebestplayer.model;

/**
 * Created by User on 22.11.2016.
 */

public class TrackItem {


    private String albumImage;
    private String artist;
    private String trackName;

    public TrackItem(String albumImage, String artist, String trackName) {
        this.albumImage = albumImage;
        this.artist = artist;
        this.trackName = trackName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }
}
