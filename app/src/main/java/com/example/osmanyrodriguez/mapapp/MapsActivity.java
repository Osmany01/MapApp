package com.example.osmanyrodriguez.mapapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private float mZoom;
    private LatLng mBcn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mZoom = 2;

        mBcn = new LatLng(41.3818, 2.1685);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ButterKnife.bind(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        mMap.addMarker(new MarkerOptions().position(mBcn).title("Barcelona"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mBcn, mZoom));
    }

    @OnClick(R.id.btn_zoom)
    public void onDialogZooms() {

        CustomDialog dialogRequest = new CustomDialog(this, mZoom, mMap, mBcn);
        dialogRequest.mTvTitle.setText(getString(R.string.zooms));
        dialogRequest.show();

    }

}
