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
        songs.addToEnd(new Song("Subterranean Homesick Alien", "Radiohead", "Alternative Rock", 1997));
        songs.addToEnd(new Song("Taro", "alt-J", "Indie Rock", 2012));
        songs.addToEnd(new Song("Yes I'm Changing", "Tame Impala", "Psychedelic Pop", 2015));
        songs.addToEnd(new Song("Black Star", "Radiohead", "Alternative Rock", 1995));
        songs.addToEnd(new Song("Ode To The Mets", "The Strokes", "Indie Rock", 2020));
        songs.addToEnd(new Song("Scatterbrain", "Radiohead", "Alternative Rock", 2003));
        songs.addToEnd(new Song("'Cause I'm A Man", "Tame Impala", "Psychedelic Rock", 2015));
        songs.addToEnd(new Song("Sail To The Moon", "Radiohead", "Alternative Rock", 2003));
        songs.addToEnd(new Song("Tessellate", "alt-J", "Indie Rock", 2012));
        songs.addToEnd(new Song("The Tourist", "Radiohead", "Alternative Rock", 1997));
        songs.addToEnd(new Song("Idioteque", "Radiohead", "Alternative Rock", 2000));
        songs.addToEnd(new Song("Left Hand Free", "alt-J", "Indie Rock", 2014));
        songs.addToEnd(new Song("15 Step", "Radiohead", "Alternative Rock", 2007));
        songs.addToEnd(new Song("Deadcrush", "alt-J", "Indie Rock", 2017));
        songs.addToEnd(new Song("Pulsewidth", "Aphex Twin", "Ambient", 1992));
        songs.addToEnd(new Song("Black Swan", "Thom Yorke", "Alternative Rock", 2006));
        songs.addToEnd(new Song("Identikit", "Radiohead", "Alternative Rock", 2016));
        songs.addToEnd(new Song("Love/Paranoia", "Tame Impala", "Psychedelic Rock", 2015));
        songs.addToEnd(new Song("Backdrifts", "Radiohead", "Alternative Rock", 2003));
        songs.addToEnd(new Song("Bones", "Radiohead", "Alternative Rock", 1995));
        songs.addToEnd(new Song("So Real", "Jeff Buckley", "Alternative Rock", 1994));
        songs.addToEnd(new Song("Paranoid Android", "Radiohead", "Alternative Rock", 1997));
        songs.addToEnd(new Song("Lotus Flower", "Radiohead", "Alternative Rock", 2011));
        songs.addToEnd(new Song("Die Sterne, D. 684", "Franz Schubert", "Classical", 1820));
        songs.addToEnd(new Song("Ptolemy", "Aphex Twin", "Ambient", 1992));

        LinkedChain<ListenerProfile> profiles = new LinkedChain<ListenerProfile>();
        ListenerProfile profile = new ListenerProfile();
        profiles.add(profile);

        Menu menu = new Menu(songs, profiles.get(0), new Scanner(System.in));
        menu.run();
    }
}
