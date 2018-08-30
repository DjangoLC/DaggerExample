package com.example.joseenrique.anothersampledager.dagger;

import android.app.Application;
import android.location.LocationManager;

import javax.inject.Inject;

public class LlantaApplication extends Application {

    private LlantasComponenet llantasComponenet;

    @Inject LocationManager locationManager; // for some reason.

    @Override
    public void onCreate() {
        super.onCreate();

        llantasComponenet = DaggerLlantasComponenet.builder().llantasModule(new LlantasModule(this)).build();

    }

    public LlantasComponenet getLlantasComponenet(){
        return llantasComponenet;
    }

}
