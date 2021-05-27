package MyProject;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;


public class AudioPlayer extends JFrame {

    private JButton button1;
    private JPanel panel1;

    public static void main(String[] args) {
        final boolean[] IsFile = {false};
        final boolean[] IsPlaying = {false};
        Functions F = new Functions();
        JFrame Frame = new JFrame("Motif Look and Feel");
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }

        JPanel Panel = new JPanel();
        JButton open = new JButton("open");
        JButton play = new JButton("Play");
        JButton Restart = new JButton("restart");
        //JSlider Slider = new JSlider();

        //Slider.setBackground(Color.BLACK);
        //Slider.setBounds(115,60,400,20);
        //Slider.setEnabled(false);
        //Slider.setValue(0);
        //Frame.add(Slider);
        final JFileChooser MusicFile = new JFileChooser();
        ImageIcon O = new ImageIcon("E:\\AudioPlayer\\src\\resources\\images\\search.png");
        open.setIcon(O);
        open.setContentAreaFilled(false);
        open.setFocusPainted(false);
        open.setBorderPainted(false);

        open.setBounds(115, 100, 70, 70);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                javax.swing.filechooser.FileFilter wavFilter = new FileFilter() { //sets the file filter to wav only
                    @Override
                    public String getDescription() {
                        return "Sound file (*.WAV)";
                    }

                    @Override
                    public boolean accept(File file) {
                        if (file.isDirectory()) {
                            return true;
                        } else {
                            return file.getName().toLowerCase().endsWith(".wav");
                        }
                    }
                };
                MusicFile.setFileFilter(wavFilter);
                MusicFile.setDialogTitle("Open Audio File");
                MusicFile.setAcceptAllFileFilterUsed(false);
                int r = MusicFile.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File music = new File(MusicFile.getSelectedFile().getAbsolutePath());
                    F.open(music);
                    IsFile[0] = true;

                }
            }
        });
        Frame.add(open);

        play.setBounds(290, 100, 60, 60);
        ImageIcon P = new ImageIcon("E:\\AudioPlayer\\src\\resources\\images\\resizedImage.png");
        play.setIcon(P);
        play.setContentAreaFilled(false);        play.setFocusPainted(false);
        play.setBorderPainted(false);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (IsFile[0] == false)
                {
                    File music = new File("C:\\Users\\saaim\\Music\\Billie Eilish - everything i wanted (Audio).wav");
                    F.PlaySound(music);
                    IsFile[0] = true;
                }

                else {

                    if (IsPlaying[0] == false) {
                        F.PlaySound();
                        IsPlaying[0] = true;

                    } else {
                        F.pause();
                        IsPlaying[0] = false;
                    }
                }
            }
        });
        Frame.add(play);

        Frame.add(Restart);
        ImageIcon R = new ImageIcon("E:\\AudioPlayer\\src\\resources\\images\\reset(3).png");
        Restart.setIcon(R);
        Restart.setBounds(450, 100, 60, 60);
        Restart.setFocusPainted(false);
        Restart.setBorderPainted(false);
        Restart.setContentAreaFilled(false);
        Restart.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent actionEvent) {
                                          F.reset();
                                      }
                                  });
        Frame.add(Panel);

        Panel.setBackground(Color.black);
       //F.Slide();
        //int CurrentTime = F.Slide();
        //Slider.setValue(CurrentTime);
        Frame.setLocation(380,200);
        Frame.setUndecorated(true);
        Frame.getRootPane().setWindowDecorationStyle( JRootPane. COLOR_CHOOSER_DIALOG );
        Frame.setVisible(true);
        Frame.setTitle("Music Player");
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Frame.setSize(630, 220);
        Frame.setResizable(false);

    }


}

