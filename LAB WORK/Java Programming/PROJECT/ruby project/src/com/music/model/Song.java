package com.music.model;

public class Song extends MediaItem {
    public Song() { this.type = "SONG"; }
    public Song(String title, String artist, String album, int duration, int playlistId) {
        super(title, artist, album, duration, playlistId, "SONG");
    }
}
