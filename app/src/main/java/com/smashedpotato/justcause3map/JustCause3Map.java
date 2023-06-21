package com.smashedpotato.justcause3map;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
public class JustCause3Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_cause_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //TODO
        mMap.setMapType(GoogleMap.MAP_TYPE_NONE);

        //TileProvider tileProvider = getWMSTileProviderByName("MYLAYERNAME");
        //TileOverlay tileOverlay = mMap.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider));

        mMap.addTileOverlay(new TileOverlayOptions().tileProvider(new CustomMapTileProvider(getResources().getAssets())));
        CameraUpdate upd = CameraUpdateFactory.newLatLngZoom(new LatLng(1, 1), 0);
        mMap.moveCamera(upd);
        mMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                CameraPosition position = mMap.getCameraPosition();
                float maxZoom = 6.0f;
                if (position.zoom > maxZoom) {
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(maxZoom));
                }
            }
        });
        mMap.getUiSettings().setTiltGesturesEnabled(false);

        Resources res = getResources();
        String[] markers1 = res.getStringArray(R.array.markers1);
        String[] markers2 = res.getStringArray(R.array.markers2);
        String[] markers3 = res.getStringArray(R.array.markers3);
        String[] markers4 = res.getStringArray(R.array.markers4);
        String[] markers5 = res.getStringArray(R.array.markers5);
        String[] markers6 = res.getStringArray(R.array.markers6);
        String[] markers7 = res.getStringArray(R.array.markers7);
        String[] markers8 = res.getStringArray(R.array.markers8);
        String[] markers9 = res.getStringArray(R.array.markers9);
        String[] markers10 = res.getStringArray(R.array.markers10);
        String[] markers11 = res.getStringArray(R.array.markers11);
        String[] markers12 = res.getStringArray(R.array.markers12);
        String[] markers13 = res.getStringArray(R.array.markers13);
        String[] markers14 = res.getStringArray(R.array.markers14);
        String[] markers15 = res.getStringArray(R.array.markers15);
        String[] markers16 = res.getStringArray(R.array.markers16);
        String[] markers17 = res.getStringArray(R.array.markers17);
        String[] markers18 = res.getStringArray(R.array.markers18);
        String[] markers19 = res.getStringArray(R.array.markers19);
        String[] markers20 = res.getStringArray(R.array.markers20);
        String[] markers21 = res.getStringArray(R.array.markers21);
        String[] markers22 = res.getStringArray(R.array.markers22);
        String[] markers23 = res.getStringArray(R.array.markers23);
        String[] markers24 = res.getStringArray(R.array.markers24);
        String[] markers25 = res.getStringArray(R.array.markers25);
        String[] markers26 = res.getStringArray(R.array.markers26);
        String[] markers27 = res.getStringArray(R.array.markers27);
        String[] markers28 = res.getStringArray(R.array.markers28);
        String[] markers29 = res.getStringArray(R.array.markers29);


        String[] test_markers = res.getStringArray(R.array.test_markers1);

        for (String m:markers1) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers1));
        }
        for (String m:markers2) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers2));
        }
        for (String m:markers3) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers3));
        }
        for (String m:markers4) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers4));
        }
        for (String m:markers5) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers5));
        }
        for (String m:markers6) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers6));
        }

        for (String m:markers7) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers7));
        }
        for (String m:markers8) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers8));
        }
        for (String m:markers9) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers9));
        }
        for (String m:markers10) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers10));
        }
        for (String m:markers11) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers11));
        }
        for (String m:markers12) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers12));
        }
        for (String m:markers13) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers13));
        }
        for (String m:markers14) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers14));
        }
        for (String m:markers15) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers15));
        }
        for (String m:markers16) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers16));
        }
        for (String m:markers17) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers17));
        }
        for (String m:markers18) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers18));
        }
        for (String m:markers19) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers19));
        }
        for (String m:markers20) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers20));
        }
        for (String m:markers21) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers21));
        }
        for (String m:markers22) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers21));
        }
        for (String m:markers23) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers23));
        }
        for (String m:markers24) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers24));
        }
        for (String m:markers25) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers25));
        }
        for (String m:markers26) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers26));
        }
        for (String m:markers27) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers27));
        }
        for (String m:markers28) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers28));
        }
        for (String m:markers29) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.markers29));
        }


        for (String m:test_markers) {
            String name = m.split("_")[0];
            String lat = m.split("_")[1];
            String lon = m.split("_")[2];
            LatLng location = new LatLng(Double.parseDouble(lat), Double.parseDouble(lon));
            //mMap.addMarker(new MarkerOptions().position(location).title(name)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.test_marker));
        }




        LatLng one = new LatLng(1, 1);

        Rect boundsText = new Rect();
        boundsText.set(0,0,30,30);
        Paint paintText = new TextPaint();
        paintText.setColor(Color.RED);
        paintText.getTextBounds("X", 0, 1, boundsText);
        Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmpText = Bitmap.createBitmap(boundsText.width(),
                boundsText.height(), conf);

        Canvas canvasText = new Canvas(bmpText);
        canvasText.drawText("Pants", canvasText.getWidth() / 2,
                canvasText.getHeight(), paintText);

        MarkerOptions markerOptions = new MarkerOptions()
                .position(one)
                .title("The Marker2")
                .icon(BitmapDescriptorFactory.fromBitmap(bmpText));
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(one));
    }

    public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }
}
