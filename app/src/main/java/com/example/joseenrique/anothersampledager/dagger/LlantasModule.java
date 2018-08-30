package com.example.joseenrique.anothersampledager.dagger;


import android.content.Context;
import android.location.LocationManager;

import com.example.joseenrique.anothersampledager.models.Llantas;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class LlantasModule {

    @Inject
    LlantaApplication application;

    public LlantasModule(LlantaApplication application){
        this.application = application;
    }

    @Provides
    public Llantas provideLlantaFirestone(){
        return  new Llantas("Firestone","unknown","Todo terreno");
    }

    @Provides
    public LocationManager provideLocationManager(){
        return (LocationManager)application.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    public Context provideContext(){
        return application;
    }








}
