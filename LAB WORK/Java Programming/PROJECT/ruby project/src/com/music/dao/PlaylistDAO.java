package com.music.dao;

import com.music.model.Playlist;
import com.music.util.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {
    public int createPlaylist(Playlist p) {
        String sql = "INSERT INTO playlist(name, description, user_id) VALUES(?, ?, ?)";
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setInt(3, p.getUserId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) { p.setId(rs.getInt(1)); return p.getId(); }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return -1;
    }

    public List<Playlist> getPlaylistsByUser(int userId) {
        List<Playlist> list = new ArrayList<>();
        String sql = "SELECT * FROM playlist WHERE user_id=?";
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Playlist p = new Playlist();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setDescription(rs.getString("description"));
                    p.setUserId(rs.getInt("user_id"));
                    list.add(p);
                }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return list;
    }

    public Playlist findByIdAndUser(int id, int userId) {
        String sql = "SELECT * FROM playlist WHERE id=? AND user_id=?";
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Playlist p = new Playlist();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setDescription(rs.getString("description"));
                    p.setUserId(rs.getInt("user_id"));
                    return p;
                }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public boolean deleteByIdAndUser(int id, int userId) {
        String sql = "DELETE FROM playlist WHERE id=? AND user_id=?";
        try (Connection c = DB.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, userId);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) { ex.printStackTrace(); }
        return false;
    }
}
