package com.exomatik.mpm.tes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExampleRetro extends AppCompatActivity {
    private RecyclerView rcHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        rcHero = (RecyclerView) findViewById(R.id.rc_hero);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroes = response.body();

                ArrayList<Hero> listHero = new ArrayList<Hero>();

                for (Hero hashdjahdjksahdkjsa: heroes){
                    listHero.add(hashdjahdjksahdkjsa);
                }

                RecyclerLihatKuliner adapterLihatKelas = new RecyclerLihatKuliner(listHero);
                LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(ExampleRetro.this, 1, false);
                rcHero.setLayoutManager(localLinearLayoutManager);
                rcHero.setNestedScrollingEnabled(false);
                rcHero.setAdapter(adapterLihatKelas);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(ExampleRetro.this, "Error, " + t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
