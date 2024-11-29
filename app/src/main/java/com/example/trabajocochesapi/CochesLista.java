package com.example.trabajocochesapi;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CochesLista extends AppCompatActivity {

    private List<Coches> cochesList = new ArrayList<>();
    private CochesAdapter adapter;
    private CochesViewModel cochesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coches_lista);

        adapter = new CochesAdapter(this,cochesList);
        ListView listView=findViewById(R.id.cochesListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent,view,posicio,id)->{
            Coches cochesSeleccionados=cochesList.get(posicio);

            Intent intent = new Intent(CochesLista.this,CochesDetalles.class);
            intent.putExtra("imagen",cochesSeleccionados.getImagen());
            intent.putExtra("marca",cochesSeleccionados.getMarca());
            intent.putExtra("modelo",cochesSeleccionados.getModelo());
            intent.putExtra("precio",cochesSeleccionados.getPrecio());
            intent.putExtra("anyo",cochesSeleccionados.getAnyo());

            startActivity(intent);
        });

    cocheService();

        cochesViewModel = new ViewModelProvider(this).get(CochesViewModel.class);
        cochesViewModel.getCoches().observe(this,cocheEntities->{
            cochesList.clear();
            for (CocheEntity cocheEntity:cocheEntities){
                cochesList.add(new Coches(cocheEntity));
            }
        });
        adapter.notifyDataSetChanged();

    }

 /*   public void refresh(View view){
        cochesList.clear();
        adapter.notifyDataSetChanged();
        cochesViewModel.refreshDataTask();
    }*/

    private void cocheService(){
        CochesApiService apiService= RetrofitClient.getRetrofit().create(CochesApiService.class);

        Call<List<CochesResponse>> call= apiService.getCochesList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InpwdXVxcGZ3eHppYm91Y2lhemRsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE2NjEzMTAsImV4cCI6MjA0NzIzNzMxMH0.CbZHDaGU6ghxHzvb4qmHLJapPczmy-LWjL1P4EhU2Uw");
        call.enqueue(new Callback<List<CochesResponse>>() {
            @Override
            public void onResponse(Call<List<CochesResponse>> call, Response<List<CochesResponse>> response) {
               List<CochesResponse>  cochesResponse=response.body();
               for (CochesResponse cochesResponse1:cochesResponse){
                  Coches coche= new Coches(cochesResponse1);
                   cochesList.add(coche);
               }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<CochesResponse>> call, Throwable t) {
                Log.e(TAG,"Error");
            }
        });
    }
}