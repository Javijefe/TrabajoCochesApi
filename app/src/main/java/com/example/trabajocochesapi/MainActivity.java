package com.example.trabajocochesapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.TextView;

import com.example.trabajocochesapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        TextView nom= findViewById(R.id.txtNom);
        TextView boton= findViewById(R.id.btnComenzar);

        nom.setText("Coches");
        boton.setText("Comenzar");

        View vistaMain= findViewById(R.id.mainActivity);
        vistaMain.setBackgroundColor(Color.GRAY);

        boton.setOnClickListener((e)->{
            Intent intent =new Intent(MainActivity.this, CochesLista.class);
            startActivity(intent);
        });
    }

}