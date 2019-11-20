package com.myapplication.made.getlocationprojeksendiri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static String KEY_LATITUDE = "latitude";
    public static String KEY_LONGITUDE = "longitude";

    double terimaLatitude, terimaLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        terimaLatitude = getIntent().getDoubleExtra(KEY_LATITUDE, 1);
        terimaLongitude = getIntent().getDoubleExtra(KEY_LONGITUDE, 2);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng posisi = new LatLng(terimaLatitude, terimaLongitude);
        mMap.addMarker(new MarkerOptions().position(posisi).title("Posisi anda"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(posisi));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(posisi,17f));
    }
}
