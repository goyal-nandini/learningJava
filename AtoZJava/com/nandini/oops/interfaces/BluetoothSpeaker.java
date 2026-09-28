package com.nandini.oops.interfaces;

public class BluetoothSpeaker implements MediaPlayer{
    @Override
    public void playMusic(String song) {
        System.out.println("Bluetooth speaker playing music.");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Bluetooth speaker stopped music.");
    }
}
