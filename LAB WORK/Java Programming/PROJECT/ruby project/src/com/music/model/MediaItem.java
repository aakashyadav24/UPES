package com.music.model;

public class MediaItem {
    protected int id;
    protected String title;
    protected String artist;
    protected String album;
    protected int duration;
    protected int playlistId;
    protected String type;

    public MediaItem() {}

    public MediaItem(String title, String artist, String album, int duration, int playlistId, String type) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.playlistId = playlistId;
        this.type = type;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public int getPlaylistId() { return playlistId; }
    public void setPlaylistId(int playlistId) { this.playlistId = playlistId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return id + " - " + title + " | " + artist + " | " + album + " | " + duration + "s";
    }
}
