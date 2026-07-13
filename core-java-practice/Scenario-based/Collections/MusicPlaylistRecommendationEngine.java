import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {

    private final LinkedList<String> recentSongs = new LinkedList<>();
    private static final int MAX_HISTORY = 10;

    public void playSong(String song) {
        recentSongs.remove(song);
        recentSongs.addFirst(song);
        if (recentSongs.size() > MAX_HISTORY) {
            recentSongs.removeLast();
        }
        System.out.println("Played: " + song);
    }

    public boolean searchSong(String song) {
        return recentSongs.contains(song);
    }

    public void displayHistory() {
        System.out.println("\nRecently played songs:");
        for (String song : recentSongs) {
            System.out.println("- " + song);
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine playlist = new MusicPlaylistRecommendationEngine();

        playlist.playSong("Sunrise");
        playlist.playSong("Moonlight");
        playlist.playSong("Drive");
        playlist.playSong("City Lights");
        playlist.playSong("Ocean Breeze");
        playlist.playSong("Midnight Run");
        playlist.playSong("Skyline");
        playlist.playSong("Journey");
        playlist.playSong("Horizons");
        playlist.playSong("Dreams");
        playlist.playSong("Echoes");

        playlist.displayHistory();
        System.out.println("\nSearch 'Ocean Breeze': " + playlist.searchSong("Ocean Breeze"));
        System.out.println("Search 'Sunrise': " + playlist.searchSong("Sunrise"));
    }
}
