package com.nandini.oops.interfaces;

// version 1:

// multiple interface implementation
public class Car implements Engine, Brake, MediaPlayer{
   private boolean engineOn = false;
   private String currentSong = null;

   @Override
    public void start() {
        engineOn = true;
       System.out.println("Engine started. Max speed: " + MAX_SPEED + " km/h");
       System.out.println(MAX_SPEED);
    }

    @Override
    public void stop() {
        engineOn = false;
        System.out.println("Engine stopped.");
    }

    @Override
    public void applyBrake() {
        System.out.println("Brake applied with force: " + MAX_BRAKE_FORCE);
    }

    @Override
    public void playMusic(String song) {
        currentSong = song;
        System.out.println("Playing: " + song);
    }

    @Override
    public void pauseMusic() {
        System.out.println("Paused: " + currentSong);
    }


}
