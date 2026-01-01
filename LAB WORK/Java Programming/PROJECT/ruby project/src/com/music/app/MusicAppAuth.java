package com.music.app;

import com.music.model.User;
import com.music.model.Playlist;
import com.music.model.MediaItem;
import com.music.service.AppService;

import java.util.List;
import java.util.Scanner;

public class MusicAppAuth {
    private static final Scanner sc = new Scanner(System.in);
    private static final AppService service = new AppService();
    private static User currentUser = null;

    public static void main(String[] args) {
        System.out.println("=== Music Playlist Manager (Major Project) ===");
        while (true) {
            if (currentUser == null) showAuthMenu();
            else showMainMenu();
        }
    }

    private static void showAuthMenu() {
        System.out.println("\n1) Register");
        System.out.println("2) Login");
        System.out.println("3) Exit");
        System.out.print("Choose: ");
        String ch = sc.nextLine().trim();
        switch (ch) {
            case "1" -> doRegister();
            case "2" -> doLogin();
            case "3" -> {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid option.");
        }
    }

    private static void doRegister() {
        System.out.print("Choose username: ");
        String user = sc.nextLine().trim();
        System.out.print("Choose password: ");
        String pass = sc.nextLine();
        boolean ok = service.register(user, pass);
        System.out.println(
                ok
                        ? "Registration successful. Please login."
                        : "Registration failed (username may exist)."
        );
    }

    private static void doLogin() {
        System.out.print("Username: ");
        String user = sc.nextLine().trim();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        User u = service.login(user, pass);
        if (u != null) {
            currentUser = u;
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("Login failed. Check username/password.");
        }
    }

    private static void showMainMenu() {
        System.out.println("\n--- Main Menu --- (User: " + currentUser.getUsername() + ")");
        System.out.println("1) Create Playlist");
        System.out.println("2) My Playlists");
        System.out.println("3) Add Song to Playlist");
        System.out.println("4) View Songs in Playlist");
        System.out.println("5) Remove Song");
        System.out.println("6) Delete Playlist");
        System.out.println("7) Logout");
        System.out.print("Choose: ");
        String ch = sc.nextLine().trim();
        switch (ch) {
            case "1" -> createPlaylist();
            case "2" -> viewPlaylists();
            case "3" -> addSongToPlaylist();
            case "4" -> viewSongs();
            case "5" -> removeSong();
            case "6" -> deletePlaylist();
            case "7" -> {
                currentUser = null;
                System.out.println("Logged out.");
            }
            default -> System.out.println("Invalid option.");
        }
    }

    private static void createPlaylist() {
        System.out.print("Playlist name: ");
        String name = sc.nextLine().trim();
        System.out.print("Description (optional): ");
        String desc = sc.nextLine().trim();
        int id = service.createPlaylist(name, desc, currentUser.getId());
        if (id > 0) System.out.println("Playlist created with id: " + id);
        else System.out.println("Could not create playlist.");
    }

    private static void viewPlaylists() {
        List<Playlist> playlists = service.listUserPlaylists(currentUser.getId());
        if (playlists.isEmpty()) {
            System.out.println("No playlists found.");
            return;
        }
        System.out.println("--- Your Playlists ---");
        for (Playlist p : playlists) System.out.println(p);
    }

    private static void addSongToPlaylist() {
        System.out.print("Playlist ID: ");
        int pid = readInt();
        Playlist p = service.getPlaylistIfOwned(pid, currentUser.getId());
        if (p == null) {
            System.out.println("Playlist not found or not owned by you.");
            return;
        }

        System.out.print("Song title: ");
        String title = sc.nextLine().trim();
        System.out.print("Artist: ");
        String artist = sc.nextLine().trim();
        System.out.print("Album: ");
        String album = sc.nextLine().trim();
        System.out.print("Duration (seconds): ");
        int dur = readInt();

        int sid = service.addSongToPlaylist(pid, title, artist, album, dur);
        if (sid > 0) System.out.println("Song added with id: " + sid);
        else System.out.println("Could not add song.");
    }

    private static void viewSongs() {
        System.out.print("Playlist ID: ");
        int pid = readInt();
        Playlist p = service.getPlaylistIfOwned(pid, currentUser.getId());
        if (p == null) {
            System.out.println("Playlist not found or not owned by you.");
            return;
        }
        List<MediaItem> songs = service.getSongsInPlaylist(pid);
        if (songs.isEmpty()) {
            System.out.println("No songs.");
            return;
        }
        System.out.println("--- Songs in playlist: " + p.getName() + " ---");
        for (MediaItem m : songs) System.out.println(m);
    }

    private static void removeSong() {
        System.out.print("Song ID to remove: ");
        int sid = readInt();
        boolean ok = service.removeSong(sid);
        System.out.println(
                ok
                        ? "Song removed."
                        : "Could not remove song (maybe wrong id)."
        );
    }

    private static void deletePlaylist() {
        System.out.print("Playlist ID to delete: ");
        int pid = readInt();
        boolean ok = service.removePlaylist(pid, currentUser.getId());
        System.out.println(
                ok
                        ? "Playlist deleted."
                        : "Could not delete playlist (not found or not yours)."
        );
    }

    private static int readInt() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
