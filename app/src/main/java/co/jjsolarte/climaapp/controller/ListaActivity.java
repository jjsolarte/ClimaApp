package co.jjsolarte.climaapp.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.jjsolarte.climaapp.MainActivity;
import co.jjsolarte.climaapp.R;
import co.jjsolarte.climaapp.adapter.AdapterCity;
import co.jjsolarte.climaapp.model.City;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<City> cityList;
    AdapterCity adapterCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        cityList = new ArrayList<>();
        cityList = MainActivity.cityList;
        recyclerView = findViewById(R.id.listaRecycler);

        adapterCity = new AdapterCity(cityList, R.layout.item_city, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterCity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterCity.notifyDataSetChanged();
    }
}