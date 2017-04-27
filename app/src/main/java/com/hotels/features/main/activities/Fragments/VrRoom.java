package com.hotels.features.main.activities.Fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.hotels.R;
import com.hotels.base.HotelsApplication;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class VrRoom extends Fragment {

    boolean loadImageSuccessful;
    public Bitmap VrRoomImage;
    public VrRoom() {
        // Required empty public constructor
    }

    @BindView(R.id.pano_vr_room) VrPanoramaView panoWidgetView;
    VrPanoramaView.Options panoOptions;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.vr_room_fragment, container, false);
        ButterKnife.bind(this,v);
        panoWidgetView.setEventListener(new ActivityEventListener());
        Bundle bundle=this.getArguments();
        handleBundle(bundle);
        return v;
    }

    private void handleBundle(Bundle bundle) {
        if(panoOptions==null)
        {
            panoOptions=new VrPanoramaView.Options();
        }
        panoOptions.inputType = VrPanoramaView.Options.TYPE_MONO;
        Picasso.with(VrRoom.this.getContext())
                .load("http://static1.360vrs.com/pano-content/hotel-room-at-the-hotel-biz-myeong-dong/640px-360-panorama.jpg")
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        VrRoomImage=bitmap;
                        panoWidgetView.loadImageFromBitmap(VrRoomImage,null);
                        Toast.makeText(VrRoom.this.getContext(), "Successful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        Toast.makeText(VrRoom.this.getContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        VrRoomImage=BitmapFactory.decodeResource(HotelsApplication.get().getResources(),R.mipmap.ic_launcher);
                    }
                });

        panoWidgetView.loadImageFromBitmap(VrRoomImage,null);
    }
    @Override
    public void onPause() {
        panoWidgetView.pauseRendering();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        panoWidgetView.resumeRendering();
    }

    @Override
    public void onDestroy() {
        panoWidgetView.shutdown();
        super.onDestroy();
    }

    private class ActivityEventListener extends VrPanoramaEventListener {
        /**
         * Called by pano widget on the UI thread when it's done loading the image.
         */
        @Override
        public void onLoadSuccess() {
            loadImageSuccessful = true;
            Toast.makeText(VrRoom.this.getContext(), "here", Toast.LENGTH_SHORT).show();
        }

        /**
         * Called by pano widget on the UI thread on any asynchronous error.
         */
        @Override
        public void onLoadError(String errorMessage) {
            loadImageSuccessful = false;
            Toast.makeText(
                    VrRoom.this.getContext(), "Error loading pano: " + errorMessage, Toast.LENGTH_LONG)
                    .show();
        }
    }
}
