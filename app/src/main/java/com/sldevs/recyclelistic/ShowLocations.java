package com.sldevs.recyclelistic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;

public class ShowLocations extends AppCompatActivity {
    WebView showLocation;
    TextView btnGoogleMap;
    Button btnSearchCity;
    Spinner searchCity;

    String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_locations);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(ShowLocations.this,R.color.green));
            getWindow().setNavigationBarColor(ContextCompat.getColor(ShowLocations.this,R.color.green));
        }
        searchCity = findViewById(R.id.searchCity);
        String[] list = getResources().getStringArray(R.array.cityLists);
        Arrays.sort(list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchCity.setAdapter(adapter);

        showLocation = findViewById(R.id.showLocation);
        btnSearchCity = findViewById(R.id.btnSearchCity);
        btnGoogleMap = findViewById(R.id.btnGoogleMap);
        btnSearchCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCity();
            }
        });
        switch (city){
            case "Cagayan de Oro City":
                Uri cdo = Uri.parse("https://plus.codes/6QW6FJGR+MG");
                Intent goCDO = new Intent(Intent.ACTION_VIEW, cdo);
                goCDO.setPackage("com.google.android.apps.maps");
                startActivity(goCDO);
                break;
            case "Davao City":
                Uri davao = Uri.parse("https://plus.codes/6QV73J75+R4");
                Intent goDavao = new Intent(Intent.ACTION_VIEW, davao);
                goDavao.setPackage("com.google.android.apps.maps");
                startActivity(goDavao);
                break;
            case "Ormoc City":
                Uri ormoc = Uri.parse("https://plus.codes/7Q362J74+73");
                Intent goOrmoc = new Intent(Intent.ACTION_VIEW, ormoc);
                goOrmoc.setPackage("com.google.android.apps.maps");
                startActivity(goOrmoc);
                break;
            case "Manila City":
                Uri manila = Uri.parse("https://plus.codes/867FVRHM+XH");
                Intent goManila = new Intent(Intent.ACTION_VIEW, manila);
                goManila.setPackage("com.google.android.apps.maps");
                startActivity(goManila);
                break;
        }
        btnGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = searchCity.getSelectedItem().toString();

                // Create a Uri from an intent string. Use the result to create an Intent.

            }
        });



    }
    public void searchCity(){
            city = searchCity.getSelectedItem().toString();
                switch (city){
                    case "Cagayan de Oro City":
                        showLocation.setWebViewClient(new WebViewClient());
                        showLocation.getSettings().setJavaScriptEnabled(true);
                        showLocation.loadUrl("https://plus.codes/6QW6FJGR+MG");
                        break;
                    case "Davao City":
                        showLocation.setWebViewClient(new WebViewClient());
                        showLocation.getSettings().setJavaScriptEnabled(true);
                        showLocation.loadUrl("https://plus.codes/6QV73J75+R4");
                        break;
                    case "Ormoc City":
                        showLocation.setWebViewClient(new WebViewClient());
                        showLocation.getSettings().setJavaScriptEnabled(true);
                        showLocation.loadUrl("https://plus.codes/7Q362J74+73");
                        break;
                    case "Manila City":
                        showLocation.setWebViewClient(new WebViewClient());
                        showLocation.getSettings().setJavaScriptEnabled(true);
                        showLocation.loadUrl("https://plus.codes/867FVRHM+XH");
                        break;
                }

            }


}