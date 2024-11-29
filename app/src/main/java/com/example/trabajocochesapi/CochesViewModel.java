package com.example.trabajocochesapi;

import static android.content.ContentValues.TAG;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CochesViewModel extends AndroidViewModel {
    private final Application app;
    private final AppDataBase appDatabase;
    private final CocheDAO cocheDAO;
    private LiveData<List<CocheEntity>> coches;

    public CochesViewModel(Application application) {
        super(application);
        this.app = application;
        this.appDatabase = AppDataBase.getDatabase(
                this.getApplication());

        this.cocheDAO = appDatabase.getCocheDao();


    }

    public LiveData<List<CocheEntity>> getCoches() {
        refreshDataTask();
        return cocheDAO.getCoches();

    }

    public void  refreshDataTask()  {

        CochesApiService apiService=RetrofitClient.getRetrofit().create(CochesApiService.class);
        Call<List<CochesResponse>> call= apiService.getCochesList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InpwdXVxcGZ3eHppYm91Y2lhemRsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE2NjEzMTAsImV4cCI6MjA0NzIzNzMxMH0.CbZHDaGU6ghxHzvb4qmHLJapPczmy-LWjL1P4EhU2Uw");

        call.enqueue(new Callback<List<CochesResponse>>() {
            @Override
            public void onResponse(Call<List<CochesResponse>> call, Response<List<CochesResponse>> response) {
                List<CochesResponse> cochesResponse = response.body();

                ArrayList<CocheEntity> cocheEntities = new ArrayList<>();
                for (CochesResponse cocheResponse:cochesResponse){
                   cocheEntities.add( new CocheEntity(cocheResponse));
                }

                new Thread(()->cocheDAO.addCoches(cocheEntities));
            }

            @Override
            public void onFailure(Call<List<CochesResponse>> call, Throwable t) {
                Log.e(TAG,"error");
            }
        });
    }

}

