package com.music.service;

import com.music.dao.MediaItemDAO;
import com.music.dao.PlaylistDAO;
import com.music.dao.UserDAO;
import com.music.model.MediaItem;
import com.music.model.Playlist;
import com.music.model.Song;
import com.music.model.User;
// import com.music.util.*; // <- keep only if you really use something from util

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AppService {
    private final UserDAO userDAO = new UserDAO();
    private final PlaylistDAO playlistDAO = new PlaylistDAO();
    private final MediaItemDAO mediaDAO = new MediaItemDAO();

    // Utility: hash password using SHA-256
    public static String sha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] b = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte by : b) {
                sb.append(String.format("%02x", by));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    // Register new user (return false if username already exists)
    public boolean register(String username, String password) {
        if (userDAO.findByUsername(username) != null) return false;
        String hash = sha256(password);
        User u = new User(username, hash);
        return userDAO.createUser(u);
    }

    // Login: verify password hash
    public User login(String username, String password) {
        User u = userDAO.findByUsername(username);
        if (u == null) return null;
        String hash = sha256(password);
        return hash.equals(u.getPasswordHash()) ? u : null;
    }

    // Create playlist for a user
    public int createPlaylist(String name, String description, int userId) {
        Playlist p = new Playlist(name, description, userId);
        return playlistDAO.createPlaylist(p);
    }

    // List all playlists of a user
    public List<Playlist> listUserPlaylists(int userId) {
        return playlistDAO.getPlaylistsByUser(userId);
    }

    // Get playlist if it belongs to the user (for access control)
    public Playlist getPlaylistIfOwned(int id, int userId) {
        return playlistDAO.findByIdAndUser(id, userId);
    }

    // Delete playlist only if owned by user
    public boolean removePlaylist(int id, int userId) {
        return playlistDAO.deleteByIdAndUser(id, userId);
    }

    // Add a song to a playlist
    public int addSongToPlaylist(int playlistId,
                                 String title,
                                 String artist,
                                 String album,
                                 int duration) {
        Song s = new Song(title, artist, album, duration, playlistId);
        return mediaDAO.addMediaItem(s);
    }

    // Get all songs in a playlist
    public List<MediaItem> getSongsInPlaylist(int playlistId) {
        return mediaDAO.getByPlaylist(playlistId);
    }

    // Remove a song by ID
    public boolean removeSong(int songId) {
        return mediaDAO.deleteById(songId);
    }
}
