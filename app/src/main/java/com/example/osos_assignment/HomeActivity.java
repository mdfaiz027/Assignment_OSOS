package com.example.osos_assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity /*implements OnMapReadyCallback*/{

    List<MyModel> arrayList = new ArrayList<>();
    RecyclerView recyclerView;

    MyRecyclerAdapter recyclerAdapter;
    MyModel myModel;

    ProgressDialog progressDialog;

    //Retrofit
    MyApiCall myApiCall;
    Retrofit retrofit;

    //Google map
    private GoogleMap map;
    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        retrofit = new Retrofit.Builder().baseUrl("https://run.mocky.io/v3/").addConverterFactory(GsonConverterFactory.create()).build();
        myApiCall = retrofit.create(MyApiCall.class);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.show();

        Call<List<ArrayMultipleObjectModel>> call = myApiCall.getData();

        call.enqueue(new Callback<List<ArrayMultipleObjectModel>>() {
            @Override
            public void onResponse(Call<List<ArrayMultipleObjectModel>> call, Response<List<ArrayMultipleObjectModel>> response) {
                progressDialog.dismiss();

                if(response.code()!=200){
                    Toast.makeText(HomeActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    List<ArrayMultipleObjectModel> arrayMultipleObjectModelsList = response.body();

                    for(ArrayMultipleObjectModel arrayMultipleObjectModel: arrayMultipleObjectModelsList){

                        String name = arrayMultipleObjectModel.getName();
                        String username = arrayMultipleObjectModel.getUsername();
                        String email = arrayMultipleObjectModel.getEmail();
                        String street = arrayMultipleObjectModel.getAddressObject().getStreet();
                        String city = arrayMultipleObjectModel.getAddressObject().getCity();
                        String zipcode = arrayMultipleObjectModel.getAddressObject().getZipcode();
                        String lat = arrayMultipleObjectModel.getAddressObject().getGeoObject().getLat();
                        String lng = arrayMultipleObjectModel.getAddressObject().getGeoObject().getLng();

                        myModel = new MyModel(""+name, ""+username, ""+email, ""+street, ""+city, ""+zipcode);
                        arrayList.add(myModel);
                        recyclerAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ArrayMultipleObjectModel>> call, Throwable t) {

            }
        });

        recyclerAdapter = new MyRecyclerAdapter(this, arrayList);
        recyclerView.setAdapter(recyclerAdapter);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                map = googleMap;

                latitude = 17.387140;
                longitude = 78.491684;

                LatLng latlng = new LatLng(latitude, longitude);
                MarkerOptions markerOptions = new MarkerOptions().position(latlng);
                map.addMarker(markerOptions);
                map.moveCamera(CameraUpdateFactory.newLatLng(latlng));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 16f));
            }
        });
    }


/*    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        LatLng latlng = new LatLng(latitude, longitude);
        MarkerOptions markerOptions = new MarkerOptions().position(latlng);
        map.addMarker(markerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 16f));
    }*/
}