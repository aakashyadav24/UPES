package com.music.dao;

import com.music.model.MediaItem;
import com.music.util.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MediaItemDAO {
    public int addMediaItem(MediaItem m) {
        String sql = "INSERT INTO media_item(title, artist, album, duration, type, playlist_id) VALUES(?,?,?,?,?,?)";
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, m.getTitle());
            ps.setString(2, m.getArtist());
            ps.setString(3, m.getAlbum());
            ps.setInt(4, m.getDuration());
            ps.setString(5, m.getType());
            ps.setInt(6, m.getPlaylistId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) { m.setId(rs.getInt(1)); return m.getId(); }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return -1;
    }

    public List<MediaItem> getByPlaylist(int playlistId) {
        List<MediaItem> list = new ArrayList<>();
        String sql = "SELECT * FROM media_item WHERE playlist_id=?";
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, playlistId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MediaItem m = new MediaItem();
                    m.setId(rs.getInt("id"));
                    m.setTitle(rs.getString("title"));
                    m.setArtist(rs.getString("artist"));
                    m.setAlbum(rs.getString("album"));
                    m.setDuration(rs.getInt("duration"));
                    m.setType(rs.getString("type"));
                    m.setPlaylistId(rs.getInt("playlist_id"));
                    list.add(m);
                }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return list;
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM media_item WHERE id=?";
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) { ex.printStackTrace(); }
        return false;
    }
}
