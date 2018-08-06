package com.example.osmanyrodriguez.mapapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by porta on 05/09/2017.
 */

public class CustomDialog extends Dialog implements View.OnClickListener {

    @BindView(R.id.dialog_title)
    TextView mTvTitle;
    @BindView(R.id.zoom_2)
    Button mZoom2;
    @BindView(R.id.zoom_3)
    Button mZoom3;
    @BindView(R.id.zoom_4)
    Button mZoom4;
    @BindView(R.id.zoom_5)
    Button mZoom5;
    @BindView(R.id.zoom_6)
    Button mZoom6;
    @BindView(R.id.zoom_7)
    Button mZoom7;
    @BindView(R.id.zoom_8)
    Button mZoom8;
    @BindView(R.id.zoom_9)
    Button mZoom9;
    @BindView(R.id.zoom_10)
    Button mZoom10;
    @BindView(R.id.zoom_11)
    Button mZoom11;
    @BindView(R.id.zoom_12)
    Button mZoom12;
    @BindView(R.id.zoom_13)
    Button mZoom13;
    @BindView(R.id.zoom_14)
    Button mZoom14;
    @BindView(R.id.zoom_15)
    Button mZoom15;
    @BindView(R.id.zoom_16)
    Button mZoom16;
    @BindView(R.id.zoom_17)
    Button mZoom17;
    @BindView(R.id.zoom_18)
    Button mZoom18;
    @BindView(R.id.zoom_19)
    Button mZoom19;
    @BindView(R.id.zoom_20)
    Button mZoom20;
    @BindView(R.id.zoom_21)
    Button mZoom21;

    private float mZoomLvl;

    private GoogleMap mMap;

    private LatLng mBcn;

    public CustomDialog(@NonNull Context context, float zoom, GoogleMap mMap, LatLng mBcn) {

        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setBackgroundDrawable(new ColorDrawable(
                ContextCompat.getColor(getContext(), R.color.dialog_background_translucent)));
        ButterKnife.bind(this);

        setOnclick();
        this.mZoomLvl = zoom;
        this.mMap = mMap;
        this.mBcn = mBcn;
    }

    private void setOnclick() {

        mZoom2.setOnClickListener(this);
        mZoom3.setOnClickListener(this);
        mZoom4.setOnClickListener(this);
        mZoom5.setOnClickListener(this);
        mZoom6.setOnClickListener(this);
        mZoom7.setOnClickListener(this);
        mZoom8.setOnClickListener(this);
        mZoom9.setOnClickListener(this);
        mZoom10.setOnClickListener(this);
        mZoom11.setOnClickListener(this);
        mZoom12.setOnClickListener(this);
        mZoom13.setOnClickListener(this);
        mZoom14.setOnClickListener(this);
        mZoom15.setOnClickListener(this);
        mZoom16.setOnClickListener(this);
        mZoom17.setOnClickListener(this);
        mZoom18.setOnClickListener(this);
        mZoom19.setOnClickListener(this);
        mZoom20.setOnClickListener(this);
        mZoom21.setOnClickListener(this);
    }


    public void setTitle(String title) {

        mTvTitle.setText(title);
    }


    @Override
    public void onClick(View view) {

        Button btnPresed = (Button) view;

        mZoomLvl = Integer.parseInt(btnPresed.getText().toString());
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mBcn, mZoomLvl));
        dismiss();
    }

    @OnClick(R.id.iv_dialog_close)
    public void onCloseDialog() {

        dismiss();
    }
}
