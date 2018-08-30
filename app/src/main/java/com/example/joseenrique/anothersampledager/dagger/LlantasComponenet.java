package com.example.joseenrique.anothersampledager.dagger;


import com.example.joseenrique.anothersampledager.MainDagger;


import dagger.Component;

@PeerActivity
@Component(modules = {LlantasModule.class})
public interface LlantasComponenet {
    void inject(MainDagger mainDagger);
}
