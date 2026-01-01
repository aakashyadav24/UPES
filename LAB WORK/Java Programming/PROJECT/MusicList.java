import java.util.ArrayList;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private String album;
    private int duration; // in seconds

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() { 
        return title; 
    }

    @Override
    public String toString() {
        return title + " by " + artist + " [" + album + "] (" + duration + "s)";
    }
}

class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("✅ Song added to playlist: " + name);
    }

    public void removeSong(String title) {
        boolean removed = songs.removeIf(song ->
            song.getTitle().equalsIgnoreCase(title)
        );

        if (removed) {
            System.out.println("🗑 Song removed: " + title);
        } else {
            System.out.println("⚠ Song not found: " + title);
        }
    }

    public void displaySongs() {
        System.out.println("\n🎶 Playlist: " + name);

        if (songs.isEmpty()) {
            System.out.println("No songs in this playlist.");
        } else {
            for (Song song : songs) {
                System.out.println("- " + song);
            }
        }
    }
}

public class MusicList {
    private static ArrayList<Playlist> playlists = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("🎵 Welcome to your Music Playlist 🎵");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create New Playlist");
            System.out.println("2. Add Song to New Playlist");
            System.out.println("3. Remove Song from New Playlist");
            System.out.println("4. View Playlist");
            System.out.println("5. View All Playlists");
            System.out.println("6. Stop");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createnewPlaylist();
                case 2 -> addSongTonewPlaylist();
                case 3 -> removeSongFromnewPlaylist();
                case 4 -> viewPlaylist();
                case 5 -> viewAllPlaylists();
                case 6 -> {
                    System.out.println("What's your current mood!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    private static void createnewPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        playlists.add(new Playlist(name));
        System.out.println("✅ Playlist created: " + name);
    }

    private static Playlist findPlaylist(String name) {
        for (Playlist p : playlists) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    private static void addSongTonewPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();

        Playlist playlist = findPlaylist(name);
        if (playlist == null) {
            System.out.println("⚠ Playlist not found.");
            return;
        }

        System.out.print("Song title: ");
        String title = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Album: ");
        String album = scanner.nextLine();
        System.out.print("Duration (in seconds): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        Song song = new Song(title, artist, album, duration);
        playlist.addSong(song);
    }

    private static void removeSongFromnewPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        Playlist playlist = findPlaylist(name);

        if (playlist == null) {
            System.out.println("⚠ Playlist not found.");
            return;
        }

        System.out.print("Enter song title to remove: ");
        String title = scanner.nextLine();
        playlist.removeSong(title);
    }

    private static void viewPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        Playlist playlist = findPlaylist(name);

        if (playlist == null) {
            System.out.println("⚠ Playlist not found.");
            return;
        }

        playlist.displaySongs();
    }

    private static void viewAllPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("📂 No playlists available.");
            return;
        }

        for (Playlist p : playlists) {
            p.displaySongs();
        }
    }
}