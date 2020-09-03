package co.jjsolarte.climaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import co.jjsolarte.climaapp.controller.ListaActivity;
import co.jjsolarte.climaapp.model.City;
import co.jjsolarte.climaapp.services.PostServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText edtCity;
    Button btnBuscar;

//    AdapterLista adapterLista;
    public static List<City> cityList;
//    RecyclerView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCity = findViewById(R.id.mainEdtCity);
        btnBuscar = findViewById(R.id.mainBtnBuscar);
//        listView = findViewById(R.id.mainList);
        cityList = new ArrayList<>();
//
//        adapterLista = new AdapterLista(cityList, R.layout.item_lista, this);
//        listView.setHasFixedSize(true);
//        listView.setAdapter((RecyclerView.Adapter) adapterLista);
//        listView.setLayoutManager(new LinearLayoutManager(this));
//        adapterLista.notifyDataSetChanged();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Vamos a hacer la petición
                //Mostramos resultados
                getPosts();
            }
        });

    }

    private void getPosts() {
        //Definir la url base
        String url = "https://www.metaweather.com";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Interface que creamos
        PostServices postService = retrofit.create(PostServices.class);
        Call<List<City>> call = postService.getPost();

        call.enqueue(new Callback<List<City>>() {

            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                for (City city : response.body()) {
//                    Toast.makeText(MainActivity.this, city.getTitle(), Toast.LENGTH_SHORT).show();
                    cityList.add(city);
                }
//                adapterLista.notifyDataSetChanged();
//                arrayAdapter.notifyDataSetChanged();

                mostrarLista();
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Petición Fallida" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void mostrarLista() {
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
    }
}