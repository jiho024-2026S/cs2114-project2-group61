import java.util.Scanner;

/** Starts the program. */
public class Main {
    public static void main(String[] args) {
        LinkedChain<Song> songs = new LinkedChain<Song>();


        LinkedChain<ListenerProfile> profiles = new LinkedChain<ListenerProfile>();
        ListenerProfile profile = new ListenerProfile();
        profiles.add(profile);

        Menu menu = new Menu(songs, profiles.get(0), new Scanner(System.in));
        menu.run();
    }
}
