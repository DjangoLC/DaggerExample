package com.example.joseenrique.anothersampledager;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseenrique.anothersampledager.dagger.LlantaApplication;
import com.example.joseenrique.anothersampledager.models.Carro;
import com.example.joseenrique.anothersampledager.models.Llantas;
import com.example.joseenrique.anothersampledager.utils.ProviderLocation;
import com.example.joseenrique.anothersampledager.utils.ProviderLocation.listener;

import javax.inject.Inject;

public class MainDagger extends AppCompatActivity implements ProviderLocation.listener{

    Button btn;
    TextView tv_info;
    Carro carro;
    @Inject
    Llantas llantas;
    @Inject
    LocationManager manager;
    @Inject
    Context context;

    String info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dagger);

        btn = findViewById(R.id.btn_info);
        tv_info = findViewById(R.id.tv_info);
        build();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info = String.format("llanta specs: marca %s \n"+
                                            "tipo: %s \n"+
                                            "Carro: %s",
                                            llantas.getMarca(),llantas.getTipo(),carro.getModelo());
                Toast.makeText(MainDagger.this, info, Toast.LENGTH_SHORT).show();
                new ProviderLocation(manager,MainDagger.this);

            }
        });

    }

    private void build(){
        carro = new Carro("Dodge","Attitude",2018,llantas);
        ((LlantaApplication)getApplication()).getLlantasComponenet().inject(this);
    }

    @Override
    public void positionChanged(Location location) {
        Toast.makeText(context, "Location: "+location.getLatitude(), Toast.LENGTH_SHORT).show();
        tv_info.setText(info+"\n Location: Latitude: ("+location.getLatitude()+")"+"\n Longitude: ("+location.getLongitude()+")");
    }
}
