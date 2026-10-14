import java.util.Scanner;

/** Starts the program. */
public class Main {
    public static void main(String[] args) {
        LinkedChain<Song> songs = new LinkedChain<Song>();

        songs.addToEnd(new Song("Nude", "Radiohead", "Alternative", 2007));
        songs.addToEnd(new Song("Karma Police", "Radiohead", "Alternative", 1997));
        songs.addToEnd(new Song("Obstacle 1", "Interpol", "Post-Punk", 2002));
        songs.addToEnd(new Song("Disorder", "Joy Division", "Post-Punk", 1979));
        songs.addToEnd(new Song("Teardrop", "Massive Attack", "Trip-Hop", 1998));
        songs.addToEnd(new Song("Roads", "Portishead", "Trip-Hop", 1994));
        songs.addToEnd(new Song("Just Like Heaven", "The Cure", "Alternative", 1987));
        songs.addToEnd(new Song("No Surprises", "Radiohead", "Alternative", 1997));
        songs.addToEnd(new Song("Enjoy the Silence", "Depeche Mode", "Synth-Pop", 1990));
        songs.addToEnd(new Song("Love Will Tear Us Apart", "Joy Division", "Post-Punk", 1980));

        LinkedChain<ListenerProfile> profiles = new LinkedChain<ListenerProfile>();
        ListenerProfile profile = new ListenerProfile();
        profiles.add(profile);

        Menu menu = new Menu(songs, profiles.get(0), new Scanner(System.in));
        menu.run();
    }
}
