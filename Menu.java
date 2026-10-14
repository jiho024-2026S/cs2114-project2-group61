import java.util.Scanner;

/** Handles user input and displays results. */
public class Menu {
    private LinkedChain<Song> songs;
    private ListenerProfile profile;
    private Scanner scanner;
    private SuggestionQueue suggestions = new SuggestionQueue();

    public Menu(LinkedChain<Song> songs, ListenerProfile profile, Scanner scanner) {
        this.songs = songs;
        this.profile = profile;
        this.scanner = scanner;
    }

    public void run() {
        String option = "";
        while (!option.equals("9")) {
            System.out.println("\n1 Add song | 2 Remove song | 3 Search song | 4 List songs");
            System.out.println("5 Favorite artist | 6 Favorite genre | 7 Generate suggestions");
            System.out.println("8 Next suggestion | 9 Exit");
            System.out.print("Option: ");
            option = scanner.nextLine().trim();
            switch (option) {
                case "1": addSong(); break;
                case "2": removeSong(); break;
                case "3": searchSong(); break;
                case "4": listSongs(); break;
                case "5": profile.addFavoriteArtist(readText("Favorite artist: ")); break;
                case "6": profile.addFavoriteGenre(readText("Favorite genre: ")); break;
                case "7": generateSuggestions(); break;
                case "8": nextSuggestion(); break;
                case "9": System.out.println("Goodbye."); break;
                default: System.out.println("Invalid option. Please enter a valid menu option.");
            }
        }
    }

    private String readText(String prompt) {
        String value = "";
        while (value.isEmpty()) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("Input cannot be blank. Please try again.");
            }
        }
        return value;
    }

    private int readYear() {
        while (true) {
            System.out.print("Release year: ");
            try {
                int year = Integer.parseInt(scanner.nextLine().trim());
                if (year >= 0) { return year; }
            }
            catch (NumberFormatException e) {
                // The input was not a whole number; ask again.
            }
            System.out.println("Invalid year. Enter a nonnegative whole number.");
        }
    }

    public void addSong() {
        String title = readText("Title: ");
        String artist = readText("Artist: ");
        String genre = readText("Genre: ");
        int year = readYear();
        Song song = new Song(title, artist, genre, year);
        songs.add(song);
        suggestions = new SuggestionQueue();
        System.out.println("Added: " + song);
    }

    private Song findSong(String title, String artist) {
        Song[] all = songs.toArray(new Song[songs.size()]);
        for (Song song : all) {
            if (song.getTitle().equals(title) && song.getArtist().equals(artist)) {
                return song;
            }
        }
        return null;
    }

    public void searchSong() {
        if (songs.isEmpty()) {
            System.out.println("There are no songs stored.");
            return;
        }
        Song song = findSong(readText("Title: "), readText("Artist: "));
        if (song == null) { System.out.println("Song could not be found."); }
        else { System.out.println("Found: " + song); }
    }

    public void removeSong() {
        if (songs.isEmpty()) {
            System.out.println("There are no songs stored to remove.");
            return;
        }
        Song song = findSong(readText("Title: "), readText("Artist: "));
        if (song == null) {
            System.out.println("Song to be removed could not be found.");
        }
        else {
            songs.remove(song);
            suggestions = new SuggestionQueue();
            System.out.println("Removed: " + song);
        }
    }

    public void listSongs() {
        if (songs.isEmpty()) {
            System.out.println("There are no songs stored.");
            return;
        }
        Song[] all = songs.toArray(new Song[songs.size()]);
        for (Song song : all) { System.out.println(song); }
    }

    public void generateSuggestions() {
        RecommendationEngine engine = new RecommendationEngine();
        suggestions = engine.generateSuggestions(songs, profile);
        if (suggestions.isEmpty()) {
            System.out.println("No matching suggestions were found.");
        }
        else {
            System.out.println("Suggestions ready. Choose 8 to view the next song.");
        }
    }

    public void nextSuggestion() {
        Song song = suggestions.nextSuggestion();
        if (song == null) { System.out.println("There are no more song suggestions."); }
        else { System.out.println("Next: " + song); }
    }
}
