import br.com.getulio.portifolio.Music;
import br.com.getulio.portifolio.MyFavorites;
import br.com.getulio.portifolio.Podcast;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Music music = new Music("Beyoncé","Flaws and all");

        for (int i = 0; i < 1000; i++) {
            music.play();
        }

        for (int i = 0; i < 50; i++) {
            music.like();
        }

        Podcast podcast = new Podcast("Ludocast");
        podcast.setName("Ludocast");
        podcast.setInterviewer("Ludoviajante");

        for (int i = 0; i < 5000; i++) {
            podcast.like();
        }

        for (int i = 0; i < 1000; i++) {
            podcast.play();
        }

        MyFavorites myFavorites = new MyFavorites();

        myFavorites.include(podcast);
        myFavorites.include(music);

        ArrayList<Music> musicList = new ArrayList<>();

        var music1 = new Music("Lana Del Rey", "Dark but just a game");
        var music2 = new Music("Olivia Rodrigo", "Vampire");

        musicList.add(music);
        musicList.add(music1);
        musicList.add(music2);

        System.out.println(musicList);

    }
}
