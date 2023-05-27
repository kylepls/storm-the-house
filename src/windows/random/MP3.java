package windows.random;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import javazoom.jl.player.Player;


public class MP3 {
    private URL file;
    private Player player;

    // constructor that takes the name of an MP3 file
    public MP3(URL f) {
        this.file = f;
    }

    public void close() { if (player != null) {
		player.close();
	} }

    // play the MP3 file to the sound card
    public void play() {
        try {
            InputStream fis     = file.openStream();
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + file);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            @Override
			public void run() {
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();
    }
}
