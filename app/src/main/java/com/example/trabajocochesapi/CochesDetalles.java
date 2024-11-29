package com.example.trabajocochesapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class CochesDetalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coches_detalles);

        ImageView imagen=findViewById(R.id.imagen2);
        TextView marca= findViewById(R.id.marca2);
        TextView modelo= findViewById(R.id.modelo);
        TextView precio= findViewById(R.id.precio);
        TextView anyo= findViewById(R.id.anyo);

        String intentImagen= getIntent().getStringExtra("imagen");
        String intentMarca= getIntent().getStringExtra("marca");
        String intentModelo= getIntent().getStringExtra("modelo");
        String intentPrecio= getIntent().getStringExtra("precio");
        String intentAnyo= String.valueOf(getIntent().getIntExtra("anyo",10));

        marca.setText(intentMarca);
        modelo.setText(intentModelo);
        precio.setText(intentPrecio);
        anyo.setText(intentAnyo);

        Glide.with(this)
                .load(intentImagen)
                .into(imagen);
    }
}