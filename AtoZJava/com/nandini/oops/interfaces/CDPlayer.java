package com.nandini.oops.interfaces;

public class CDPlayer implements MediaPlayer{
    @Override
    public void playMusic(String song) {
        System.out.println("CD Player playing music.");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Stop the CD Player.");
    }
}
