package com.nandini.oops.interfaces;

// version 2[of this package]: "NiceeCar"
// check "main" class bottom code
// for more flexibility, its composition over inheritance

public class NiceeCar {
//    NiceeCar USES them, doesn't implement them

    // NiceeCar CARRIES these as parts inside it
    private Engine engine; // accepts ANY class that implements Engine
    private MediaPlayer musicPlayer;

    // you inject which engine and music system you want
    NiceeCar(Engine engine, MediaPlayer musicPlayer){
        this.engine = engine;           // inject any engine you want
        this.musicPlayer = musicPlayer;
    }

    void startCar(){
        engine.start();  // delegates to whoever engine is
    }

    void enjoyMusic(){
        musicPlayer.playMusic("Song"); // delegates to whoever musicSystem is
    }

//    NiceeCar doesn't implement anything — it just uses the parts.
}
