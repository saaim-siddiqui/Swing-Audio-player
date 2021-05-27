package MyProject;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.io.IOException;

public class Functions {

    boolean IsPlaying = false;
    File music;
    public Functions()  {

    }

    Clip clip;

void open(File music) {
    try {
        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(music));

    } catch (Exception e) {
        System.out.println("wrong file");
    }

}

/*
public int Slide(){
    int currentTime = 0;
    try {
         currentTime = (int) clip.getMicrosecondPosition() / 1_000_000;
        //currentTime = currentSecond;
        return currentTime;
    }
    catch(Exception e) {
        System.out.println("error");
    }
    return currentTime;

    }
*/

    void PlaySound(File music) {
        int a;
        try {

            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(music));
            long P = clip.getMicrosecondPosition();
            clip.setMicrosecondPosition(P);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            IsPlaying = true;


        } catch (Exception e) {
            System.out.println("Error");
        }
    }

        void PlaySound() {
            int a;
            try {

                long P = clip.getMicrosecondPosition();
                clip.setMicrosecondPosition(P);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                IsPlaying = true;

            } catch (Exception e) {
                System.out.println("Error");
            }
        }

        public void pause() {
            clip.stop();
        }


        public void reset() {
            try {
                clip.stop();
                clip.setFramePosition(0);
                clip.start();
            } catch (Exception e) {
                System.out.println("Unsupported File");
            }

        }

    }

