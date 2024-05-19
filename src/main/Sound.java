package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundUrl = new URL[30];

    public Sound() {
        soundUrl[0] = getClass().getResource("/sounds/cat-adventure-song.wav");
        soundUrl[1] = getClass().getResource("/sounds/collect-gold.wav");
        soundUrl[2] = getClass().getResource("/sounds/fanfare.wav");
        soundUrl[3] = getClass().getResource("/sounds/lock-the-door.wav");
        soundUrl[4] = getClass().getResource("/sounds/power-up.wav");
    }
    public void setFile(int i){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundUrl[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

        } catch (Exception e) {

        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

}
