package com.example.joseenrique.anothersampledager.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

public class ProviderLocation implements LocationListener {

    LocationManager locationManager;
    Context context;
    listener listener;

    public ProviderLocation(LocationManager manager,listener listener) {
        locationManager = manager;
        this.listener = listener;
        init();
    }

    public interface listener{
        void positionChanged(Location location);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location!=null)
            listener.positionChanged(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @SuppressLint("MissingPermission")
    public void init() {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                3000,
                10, this);
    }

}
